package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ModelAttributeRepository;
import com.anabol.motosale.dao.repository.ModelListRepository;
import com.anabol.motosale.model.ModelList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class ParserDaoJsoup implements ParserDao {

    @Autowired
    ModelListRepository modelListRepository;
    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    private TreeMap<String, String> manufacturers = new TreeMap<String, String>();
    private HashMap<String, String> pages = new HashMap<String, String>();
    private HashMap<String, String> models = new HashMap<String, String>();

    private static String manufacturerSelector = "td#table24 p + p a[href]";
    private static String modelPagesSelector = "p b a[href]";
    private static String modelSelector = "div table td a[href]";

    private HashMap<String, String> parseLinks(String urlToRead, String selector) {
        HashMap<String, String> result = new HashMap();
        Document doc = null;
        try {
            doc = Jsoup.connect(urlToRead).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select(selector);
        for (Element src: links) {
            result.put(src.text(), src.attr("abs:href"));
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
        for (String pageUrl: parseLinks(url, modelPagesSelector).values()) {
            pages.put(pageUrl, manufacturer);
            models.putAll(parseLinks(pageUrl, modelSelector));
        }
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

}
