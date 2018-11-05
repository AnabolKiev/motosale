package com.anabol.motosearch.service.impl;

import com.anabol.motosearch.dao.repository.ModelAttributeDownloadRepository;
import com.anabol.motosearch.dao.repository.ModelDownloadRepository;
import com.anabol.motosearch.model.ManufacturerDownload;
import com.anabol.motosearch.model.ModelDownload;
import com.anabol.motosearch.model.ModelAttributeDownload;
import com.anabol.motosearch.service.ParserService;
import com.mysql.jdbc.StringUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Repository
@Slf4j
public class ParserServiceJsoup implements ParserService {

    @Autowired
    ModelDownloadRepository modelDownloadRepository;
    @Autowired
    ModelAttributeDownloadRepository modelAttributeDownloadRepository;

    @Getter
    private Map<String, ManufacturerDownload> manufacturers = new TreeMap<>();
    @Getter
    private Map<String, ModelDownload> models = new HashMap<>();
    @Getter
    private List<ModelAttributeDownload> modelAttr = new ArrayList<>();
    private Map<String, String> pages = new HashMap<>();

    private static final String startUri = "C:\\DevTools\\bikez\\bikez.com\\brands\\index.html";
    private static final String manufacturerSelector = "table.zebra tr td a[href]";
    private static final String modelPagesSelector = "table.zebra tr:not(.head,.odd,.even) td a[href]";
    private static final String modelSelector = "table.zebra tr.odd td a[href]:not(:has(img)), table.zebra tr.even td a[href]:not(:has(img))";
    private static final String AttrRowSelector = "table.grid tr:not(:has(th)):not(:has(script)):has(td:eq(1))";
    private static final String AttrNameSelector = "td:eq(0):not(:has(table))";
    private static final String AttrValueSelector = "td:eq(1):not(:has(table))";

    private static Map<String, String> parseLinks(String uriToRead, String selector) {
        Map<String, String> result = new HashMap<>();
        try {
//            doc = Jsoup.connect(uriToRead).get(); // parsing from URL
            File input = new File(uriToRead);
//            log.info("File path: " + input.getPath());
            Document doc = Jsoup.parse(input, "windows-1252"); // parsing from file
            Elements links = doc.select(selector);
            URI absUri = input.toURI();
            for (Element link: links) {
                if (!StringUtils.isNullOrEmpty(link.text().trim().replace("\u00a0",""))) {  // trimming spaces and nbsp tag
                    try {
                        URI relativeUri = new URI(link.attr("href"));
                        String absPath = absUri.resolve(relativeUri).getPath(); // building absolute URI from page URI and relative URI
//                        log.info("Key(URL): " + absPath + " --- Value: " + link.text());
                        result.put(absPath, link.text());
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Map<String, String> parseAttributes(String uriToRead, String selectorRow, String selectorName, String selectorValue) {
        Map<String, String> result = new HashMap<>();
        try {
//            doc = Jsoup.connect(uriToRead).get(); // parsing from URL
            File input = new File(uriToRead);
//            log.info("File path: " + input.getPath());
            Document doc = Jsoup.parse(input, "windows-1252"); // parsing from file
            Elements rows = doc.select(selectorRow);
            for (Element row: rows) {
                Element name = row.select(selectorName).first();
                Element value = row.select(selectorValue).first();
                if ((name != null) && (value != null)) {
                    String attrName = name.text();
                    String attrValue = value.text();
                    if (!StringUtils.isNullOrEmpty(attrName) && !StringUtils.isNullOrEmpty(attrValue)) {
                        //   log.info("Name: " + attrName + " --- Value: " + attrValue);
                        result.put(attrName, attrValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void downloadManufacturers() {
        Map<String, String> parsedManufacturers = parseLinks(startUri, manufacturerSelector);
        for (String manufacturerUrl: parsedManufacturers.keySet()) {
            ManufacturerDownload manufacturer = new ManufacturerDownload();
            manufacturer.setUrl(manufacturerUrl);
            manufacturer.setName(parsedManufacturers.get(manufacturerUrl));
            manufacturers.put(manufacturerUrl, manufacturer);
        }
    }

    public void clearManufacturers() {
        manufacturers.clear();
    }

    public void downloadModels(String manufacturerUrl) {
        String manufacturer = manufacturers.get(manufacturerUrl).getName();
   //     log.info("Adding to pages: " + manufacturerUrl);
        Set<String> parsedPages = parseLinks(manufacturerUrl, modelPagesSelector).keySet();
        Map<String, String> manufacturerPages = new HashMap<>();
        manufacturerPages.put(manufacturerUrl, manufacturer); // adding manufacturer start URL for case of single page
        for (String pageUrl: parsedPages) // parse main manufacturer page and save other pages
            manufacturerPages.put(pageUrl, manufacturer);
        manufacturers.get(manufacturerUrl).setPagesCount(manufacturerPages.size());
        pages.putAll(manufacturerPages);
  //      log.info("Pages count: " + manufacturerPages.size());

        Map<String, ModelDownload> manufacturerModels = new HashMap<>();
        for (String pageUrl: manufacturerPages.keySet()) {// parse pages and save models URLs
            log.info("Search for models on page: " + pageUrl);
            Map<String, String> parsedModels = parseLinks(pageUrl, modelSelector); // parse models
            for (String modelUrl: parsedModels.keySet()) {
                ModelDownload model = new ModelDownload();
                model.setUrl(modelUrl);
                model.setManufacturer(manufacturer);
                model.setModelName(parsedModels.get(modelUrl));
                //log.info("Adding to models: " + modelUrl);
                manufacturerModels.put(modelUrl, model);
            }
        }
        manufacturers.get(manufacturerUrl).setModelsCount(manufacturerModels.size());
        models.putAll(manufacturerModels);
     //   log.info("Pages count: " + manufacturerModels.size());
    }

    public void clearModels() {
        pages.clear();
        models.clear();
    }

    public void saveModels() {
        modelDownloadRepository.save(models.values());
    }

    public void downloadModelsAttr() {
        clearModelAttr();
        for (String url: models.keySet())
            downloadModelAttr(url);
    }

    public void downloadModelAttr(String url) {
        log.info("Parse attributes from: " + url);
        clearModelAttr();
        Map<String, String> parsedModelAttr = parseAttributes(url, AttrRowSelector, AttrNameSelector, AttrValueSelector);
        for (String attrName: parsedModelAttr.keySet()) {
            ModelAttributeDownload modelAttribute = new ModelAttributeDownload();
            modelAttribute.setUrl(url);
            modelAttribute.setAttrName(attrName);
            modelAttribute.setAttrValue(parsedModelAttr.get(attrName));
            modelAttr.add(modelAttribute);
        }
        models.get(url).setAttrCount(parsedModelAttr.size());
    }

    public void clearModelAttr() {
        modelAttr.clear();
    }

    public void saveModelAttr() {
        modelAttributeDownloadRepository.save(modelAttr);
    }
}
