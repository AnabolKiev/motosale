package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ModelAttributeDownloadRepository;
import com.anabol.motosale.dao.repository.ModelDownloadRepository;
import com.anabol.motosale.model.ManufacturerDownload;
import com.anabol.motosale.model.ModelDownload;
import com.anabol.motosale.model.ModelAttributeDownload;
import com.mysql.jdbc.StringUtils;
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
import java.util.logging.Logger;

@Repository
public class ParserDaoJsoup implements ParserDao {

    @Autowired
    ModelDownloadRepository modelDownloadRepository;
    @Autowired
    ModelAttributeDownloadRepository modelAttributeDownloadRepository;

    private static Logger log = Logger.getLogger(ParserDaoJsoup.class.getName());

    private Map<String, ManufacturerDownload> manufacturers = new TreeMap<String, ManufacturerDownload>();
    private Map<String, String> pages = new HashMap<String, String>();
    private Map<String, ModelDownload> models = new HashMap<String, ModelDownload>();
    private List<ModelAttributeDownload> modelAttr = new ArrayList<ModelAttributeDownload>();

//    private static String startUri = "http://www.motorcyclespecs.co.za/Manufacturer.htm";
    private static String startUri = //"C:\\DevTools\\MCS\\MCS\\www.motorcyclespecs.co.za\\Manufacturer.html";
                                         "C:\\DevTools\\bikez\\bikez.com\\brands\\index.php.htm";
    private static String manufacturerSelector = //"td#table24 a[href]";
                                                 "table.zebra tr td a[href]";
    private static String modelPagesSelector = //"table p a[href*=htm]:matches(^\\W*\\d+\\W*$)";
                                                 "table.zebra tr:not(.head,.odd,.even) td a[href]";
    private static String modelSelector = //"a[href*=model]";
                                                "table.zebra tr.odd td a[href]:not(:has(img)), table.zebra tr.even td a[href]:not(:has(img))";
    private static String modelRowSelector = //"tr:has(a[href*=model]):not(:has(tr))";
                                                "table.zebra tr.odd, table.zebra tr.even";
    private static String modelUrlSelector = //"td:eq(0) a[href*=model]";
                                                "td:eq(0) a[href]";
    private static String modelYearSelector = "td:eq(1)";
    private static String AttrRowSelector = //"table:contains(Make Model):not(table:has(script)):not(table:has(img)) tr";
                                                "table.grid tr:not(:has(th)):not(:has(script)):has(td:eq(1))";
    private static String AttrNameSelector = "td:eq(0):not(:has(table))";
    private static String AttrValueSelector = "td:eq(1):not(:has(table))";

    private Map<String, String> parseLinks(String uriToRead, String selector) {
        Map<String, String> result = new HashMap();
        try {
//            doc = Jsoup.connect(uriToRead).get(); // parsing from URL
            File input = new File(uriToRead);
//            log.info("File path: " + input.getPath());
<<<<<<< HEAD
            Document doc = Jsoup.parse(input, "CP1252"); // parsing from file
=======
            Document doc = Jsoup.parse(input, "windows-1252"); // parsing from file
>>>>>>> origin/master
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

    private Map<String, String> parseYears(String uriToRead, String selectorRow, String selectorName, String selectorValue) {
        Map<String, String> result = new HashMap();
        try {
//            doc = Jsoup.connect(uriToRead).get(); // parsing from URL
            File input = new File(uriToRead);
//            log.info("File path: " + input.getPath());
<<<<<<< HEAD
            Document doc = Jsoup.parse(input, "CP1252"); // parsing from file
=======
            Document doc = Jsoup.parse(input, "windows-1252"); // parsing from file
>>>>>>> origin/master
            Elements rows = doc.select(selectorRow);
            URI absUri = input.toURI();
            for (Element row: rows) {
                Element model = row.select(selectorName).first();
                Element year = row.select(selectorValue).first();
                if ((model != null) && (year != null)) {
                    try {
                        URI relativeUri = new URI(model.attr("href"));
                        String absPath = absUri.resolve(relativeUri).getPath(); // building absolute URI from page URI and relative URI
                        String modelYear = year.text();
                        if (!StringUtils.isNullOrEmpty(absPath) && !StringUtils.isNullOrEmpty(modelYear)) {
                            result.put(absPath, modelYear);
                        }
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

    private Map<String, String> parseAttributes(String uriToRead, String selectorRow, String selectorName, String selectorValue) {
        Map<String, String> result = new HashMap();
        try {
//            doc = Jsoup.connect(uriToRead).get(); // parsing from URL
            File input = new File(uriToRead);
<<<<<<< HEAD
            log.info("File path: " + input.getPath());
            Document doc = Jsoup.parse(input, "CP1252"); // parsing from file
=======
//            log.info("File path: " + input.getPath());
            Document doc = Jsoup.parse(input, "windows-1252"); // parsing from file
>>>>>>> origin/master
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

    public Map<String, ManufacturerDownload> getManufacturers() {
        return manufacturers;
    }

    public void clearManufacturers() {
        manufacturers.clear();
    }

    public void downloadModels(String manufacturerUrl) {
        String manufacturer = manufacturers.get(manufacturerUrl).getName();
   //     log.info("Adding to pages: " + manufacturerUrl);
        Set<String> parsedPages = parseLinks(manufacturerUrl, modelPagesSelector).keySet();
        Map<String, String> manufacturerPages = new HashMap<String, String>();
        manufacturerPages.put(manufacturerUrl, manufacturer); // adding manufacturer start URL for case of single page
        for (String pageUrl: parsedPages) // parse main manufacturer page and save other pages
            manufacturerPages.put(pageUrl, manufacturer);
        manufacturers.get(manufacturerUrl).setPagesCount(manufacturerPages.size());
        pages.putAll(manufacturerPages);
  //      log.info("Pages count: " + manufacturerPages.size());

        Map<String, ModelDownload> manufacturerModels = new HashMap<String, ModelDownload>();
        for (String pageUrl: manufacturerPages.keySet()) {// parse pages and save models URLs
   //         log.info("Search for models on page: " + pageUrl);
            Map<String, String> parsedModels = parseLinks(pageUrl, modelSelector); // parse models
//            Map<String, String> parsedModelsYear = parseYears(pageUrl, modelRowSelector, modelUrlSelector, modelYearSelector); // parsed models and years
            for (String modelUrl: parsedModels.keySet()) {
                ModelDownload model = new ModelDownload();
                model.setUrl(modelUrl);
                model.setManufacturer(manufacturer);
                model.setModelName(parsedModels.get(modelUrl));
//                model.setModelYear(parsedModelsYear.get(modelUrl));
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

    public Map<String, ModelDownload> getModels() {
        /*HashMap<String,String> modelList = new HashMap<String, String>();
        Iterator<ModelList> i = modelListRepository.findAll().iterator();
        while (i.hasNext()) {
            modelList.put(i.next().getUrl(), i.next().getManufacturer());
        }
        return modelList;*/
        return models;
    }

    public void saveModels() {
        modelDownloadRepository.save(models.values());
    }

    public List<ModelAttributeDownload> getModelAttr() {
        return modelAttr;
    }

    public void downloadModelAttr(String url) {
    //    log.info("Parse attributes from: " + url);
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

    public void downloadModelsAttr() {
        clearModelAttr();
        for (String url: models.keySet())
            downloadModelAttr(url);
    }

    public void saveModelAttr() {
        modelAttributeDownloadRepository.save(modelAttr);
    }

    public void clearModelAttr() {
        modelAttr.clear();
    }

}
