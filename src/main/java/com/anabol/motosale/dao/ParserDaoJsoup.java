package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ModelAttributeRepository;
import com.anabol.motosale.dao.repository.ModelListRepository;
import com.anabol.motosale.model.ModelList;
import com.mysql.jdbc.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class ParserDaoJsoup implements ParserDao {

    @Autowired
    ModelListRepository modelListRepository;
    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    private static Logger log = Logger.getLogger(ParserDaoJsoup.class.getName());

    private TreeMap<String, String> manufacturers = new TreeMap<String, String>();
    private HashMap<String, String> pages = new HashMap<String, String>();
    private HashMap<String, String> models = new HashMap<String, String>();
    private HashMap<String, String> modelAttr = new HashMap<String, String>();

    private static String manufacturerSelector = "td#table24 a[href]";
    private static String modelPagesSelector = "p a[href][target=_self]";
    private static String modelSelector = "a[href*=model]";
    private static String AttrRowSelector = "table:contains(Make Model):not(table:has(script)) tr";
    private static String AttrNameSelector = "td[width=460]";
    private static String AttrValueSelector = "td[width=1388]";

    private HashMap<String, String> parseLinks(String urlToRead, String selector) {
        HashMap<String, String> result = new HashMap();
        Document doc = null;
        try {
            doc = Jsoup.connect(urlToRead).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select(selector);
        for (Element link: links) {
            log.info(link.text() + "---" + link.attr("abs:href"));
            if (!StringUtils.isNullOrEmpty(link.text())) {
                result.put(link.text(), link.attr("abs:href"));
            }
        }
        return result;
    }

    private HashMap<String, String> parseAttributes(String urlToRead, String selectorName, String selectorValue) {
        HashMap<String, String> result = new HashMap();
        Document doc = null;
        try {
            doc = Jsoup.connect(urlToRead).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements rows = doc.select(AttrRowSelector);
        for (Element row: rows) {
            String attrName = row.select(selectorName).first().text();
            String attrValue = row.select(selectorValue).first().text();
            log.info(attrName + "---" + attrValue);
            if (!StringUtils.isNullOrEmpty(attrName) && !StringUtils.isNullOrEmpty(attrValue)) {
                result.put(attrName, attrValue);
            }
        }
        return result;
    }

    public void uploadManufacturers(String url) {
        manufacturers.putAll(parseLinks(url, manufacturerSelector));
    }

    public TreeMap<String, String> getManufacturers() {
        return manufacturers;
    }

    public String getUrlByManufacturer(String manufacturer) {
        return manufacturers.get(manufacturer);
    }

    public void uploadModelPages(String manufacturer) {
        String url = getUrlByManufacturer(manufacturer);
        log.info(manufacturer + "---" + url);
        pages.put(url, manufacturer); // adding manufacturer start URL for case of 1 page
        for (String pageUrl: parseLinks(url, modelPagesSelector).values()) // parse main manufacturer page and save other pages
            pages.put(pageUrl, manufacturer);
        for (String pageUrl: pages.keySet()) // parse pages and save models URLs
            models.putAll(parseLinks(pageUrl, modelSelector));
    }

    public HashMap<String, String> getModels() {
        /*HashMap<String,String> modelList = new HashMap<String, String>();
        Iterator<ModelList> i = modelListRepository.findAll().iterator();
        while (i.hasNext()) {
            modelList.put(i.next().getUrl(), i.next().getManufacturer());
        }
        return modelList;*/
        return models;
    }

    public void saveModels(String manufacturer, HashMap<String, String> modelList) {
        for(String modelUrl: modelList.values() ) {
            //ModelList model = new ModelList();
            //model.setUrl(modelUrl);
            //model.setManufacturer(manufacturer);
            //modelListRepository.save(model);
            models.put(modelUrl, manufacturer);
         }
    }

    public HashMap<String, String> getModelAttr() {
        return modelAttr;
    }

    public void uploadModelAttr(String url) {
        modelAttr.clear();
        log.info(url);
        modelAttr.putAll(parseAttributes(url, AttrNameSelector, AttrValueSelector));
    }



}
