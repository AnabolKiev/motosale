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

    public void saveManufacturerMap(HashMap<String, String> models) {
        manufacturers.putAll(models);
    }

    public HashMap<String, String> getManufacturerMap() {
        return manufacturers;
    }

    public HashMap<String, String> getModelMap() {
        HashMap<String,String> modelList = new HashMap<String, String>();
        Iterator<ModelList> i = modelListRepository.findAll().iterator();
        while (i.hasNext()) {
            modelList.put(i.next().getUrl(), i.next().getManufacturer());
        }
        return modelList;
    }

}
