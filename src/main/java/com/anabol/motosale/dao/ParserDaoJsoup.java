package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ModelAttributeRepository;
import com.anabol.motosale.dao.repository.ModelListRepository;
import com.anabol.motosale.model.ManufacturerDownload;
import com.anabol.motosale.model.ModelAttribute;
import com.anabol.motosale.model.ModelList;
import com.mysql.jdbc.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class ParserDaoJsoup implements ParserDao {

//    @Autowired
//    ModelListRepository modelListRepository;
//    @Autowired
//    ModelAttributeRepository modelAttributeRepository;

    private static Logger log = Logger.getLogger(ParserDaoJsoup.class.getName());

    private Map<String, ManufacturerDownload> manufacturers = new TreeMap<String, ManufacturerDownload>();
    private Map<String, String> pages = new HashMap<String, String>();
    private Map<String, ModelAttribute> models = new HashMap<String, ModelAttribute>();
    private List<ModelAttribute> modelAttr = new ArrayList<ModelAttribute>();

//    private static String startUrl = "http://www.motorcyclespecs.co.za/Manufacturer.htm";
    private static String startUrl = "C:\\DevTools\\MCS\\MCS\\www.motorcyclespecs.co.za\\Manufacturer.html";

    private static String manufacturerSelector = "td#table24 a[href]";
    private static String modelPagesSelector = "table table p a[href*=htm][target=_self]";
    private static String modelSelector = "a[href*=model]";
    private static String AttrRowSelector = "table:contains(Make Model):not(table:has(script)) tr";
    private static String AttrNameSelector = "td:eq(0)";
    private static String AttrValueSelector = "td:eq(1)";

    private String getAbsUri(String startUri, String relatedUri) {  // replacing URL to local
        String baseUri = startUri.substring(0, startUri.lastIndexOf("\\"));
        if (relatedUri.contains("../")) { // related path
            relatedUri = relatedUri.replace("../","");
            baseUri = baseUri.substring(0, baseUri.lastIndexOf("\\"));
        }
        relatedUri = relatedUri.replace("/", "\\"); //  slash
        relatedUri = relatedUri.replace("%20"," "); //  space
        return baseUri + "\\" + relatedUri;
    }

    private Map<String, String> parseLinks(String urlToRead, String selector) {
        Map<String, String> result = new HashMap();
        Document doc = null;
        try {
//            doc = Jsoup.connect(urlToRead).get(); // parsing from URL
            File input = new File(urlToRead);
            log.info("File path: " + input.getPath());
            doc = Jsoup.parse(input, "UTF-8"); // parsing from file
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select(selector);
        for (Element link: links) {
            if (!StringUtils.isNullOrEmpty(link.text().trim().replace("\u00a0",""))) {  // trimming spaces and nbsp tag
                String absUri = getAbsUri(urlToRead, link.attr("href"));
                log.info("Key(URL): " + absUri + " --- Value: " + link.text());
                result.put(absUri, link.text());
            }
        }
        return result;
    }

    private Map<String, String> parseAttributes(String urlToRead, String selectorName, String selectorValue) {
        Map<String, String> result = new HashMap();
        Document doc = null;
        try {
//            doc = Jsoup.connect(urlToRead).get(); // parsing from URL
            File input = new File(urlToRead);
            log.info("File path: " + input.getPath());
            doc = Jsoup.parse(input, "UTF-8"); // parsing from file
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements rows = doc.select(AttrRowSelector);
        for (Element row: rows) {
            String attrName = row.select(selectorName).first().text();
            String attrValue = row.select(selectorValue).first().text();
            if (!StringUtils.isNullOrEmpty(attrName) && !StringUtils.isNullOrEmpty(attrValue)) {
             //   log.info("Name: " + attrName + " --- Value: " + attrValue);
                result.put(attrName, attrValue);
            }
        }
        return result;
    }

    public void downloadManufacturers() {
        Map<String, String> parsedManufacturers = parseLinks(startUrl, manufacturerSelector);
        for (String manufacturerUrl: parsedManufacturers.keySet()) {
            ManufacturerDownload manufacturer = new ManufacturerDownload();
            manufacturer.setUrl(manufacturerUrl);
            manufacturer.setName(parsedManufacturers.get(manufacturerUrl));
            manufacturers.put(manufacturerUrl, manufacturer);
        }
    }

    public Map<String, ManufacturerDownload> getManufacturers() {
        return manufacturers;
    }

    public void clearManufacturers() {
        manufacturers.clear();
    }

    public void downloadModels(String manufacturerUrl) {
        String manufacturer = manufacturers.get(manufacturerUrl).getName();
        log.info("Adding to pages: " + manufacturerUrl);
        Set<String> parsedPages = parseLinks(manufacturerUrl, modelPagesSelector).keySet();
        Map<String, String> manufacturerPages = new HashMap<String, String>();
        manufacturerPages.put(manufacturerUrl, manufacturer); // adding manufacturer start URL for case of single page
        for (String pageUrl: parsedPages) // parse main manufacturer page and save other pages
            manufacturerPages.put(pageUrl, manufacturer);
        manufacturers.get(manufacturerUrl).setPagesCount(manufacturerPages.size());
        pages.putAll(manufacturerPages);
        log.info("Pages count: " + manufacturerPages.size());

        Map<String, ModelAttribute> manufacturerModels = new HashMap<String, ModelAttribute>();
        for (String pageUrl: manufacturerPages.keySet()) {// parse pages and save models URLs
            log.info("Search for models on page: " + pageUrl);
            Map<String, String> parsedModels = parseLinks(pageUrl, modelSelector); // parse models
            for (String modelUrl: parsedModels.keySet()) {
                ModelAttribute model = new ModelAttribute();
                model.setUrl(modelUrl);
                model.setManufacturer(manufacturer);
                model.setModelName(parsedModels.get(modelUrl));
                log.info("Adding to models: " + modelUrl);
                manufacturerModels.put(modelUrl, model);
            }
        }
        manufacturers.get(manufacturerUrl).setModelsCount(manufacturerModels.size());
        models.putAll(manufacturerModels);
        log.info("Pages count: " + manufacturerModels.size());
    }

    public void clearModels() {
        pages.clear();
        models.clear();
    }

    public Map<String, ModelAttribute> getModels() {
        /*HashMap<String,String> modelList = new HashMap<String, String>();
        Iterator<ModelList> i = modelListRepository.findAll().iterator();
        while (i.hasNext()) {
            modelList.put(i.next().getUrl(), i.next().getManufacturer());
        }
        return modelList;*/
        return models;
    }

    public List<ModelAttribute> getModelAttr() {
        return modelAttr;
    }

    public void downloadModelAttr(String url) {
        log.info("Searching for attributes: " + url);
        Map<String, String> parsedModelAttr = parseAttributes(url, AttrNameSelector, AttrValueSelector);
        for (String attrName: parsedModelAttr.keySet()) {
            ModelAttribute modelAttribute = new ModelAttribute();
            modelAttribute.setUrl(url);
            modelAttribute.setModelName(models.get(url).getModelName());
            modelAttribute.setManufacturer(models.get(url).getManufacturer());
            modelAttribute.setAttrName(attrName);
            modelAttribute.setAttrValue(parsedModelAttr.get(attrName));
            modelAttr.add(modelAttribute);
        }
    }

    public void downloadModelsAttr() {
        for (String url: models.keySet())
            downloadModelAttr(url);
    }

    public void saveModelAttr() {
// TO DO
    }

    public void clearModelAttr() {
        modelAttr.clear();
    }

}
