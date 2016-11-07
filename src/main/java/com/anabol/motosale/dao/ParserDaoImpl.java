package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.ModelAttributeRepository;
import com.anabol.motosale.dao.repository.ModelListRepository;
import com.anabol.motosale.model.ModelList;
import com.sun.javafx.sg.prism.NGShape;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class ParserDaoImpl implements ParserDao {

    @Autowired
    ModelListRepository modelListRepository;
    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    private HashMap<String, String> manufacturers = new HashMap<String, String>();

    public HashMap<String, String> parseLinks(String urlToRead, String selector) {
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

    public void saveManufacturerList(HashMap<String, String> manufacturerList) {
        manufacturers.putAll(manufacturerList);
    }

    public HashMap<String, String> getManufacturerList() {
        return manufacturers;
    }

    public String getManufacturerUrl(String manufacturer) {
        return manufacturers.get(manufacturer);
    }

    public HashMap<String, String> getModelList() {
        HashMap<String,String> modelList = new HashMap<String, String>();
        Iterator<ModelList> i = modelListRepository.findAll().iterator();
        while (i.hasNext()) {
            modelList.put(i.next().getUrl(), i.next().getManufacturer());
        }
        return modelList;
    }

    public void saveModelList(String manufacturer, HashMap<String, String> modelList) {
        for(String modelUrl: modelList.values() ) {
            ModelList model = new ModelList();
            model.setUrl(modelUrl);
            model.setManufacturer(manufacturer);
            modelListRepository.save(model);
        }
    }

}
