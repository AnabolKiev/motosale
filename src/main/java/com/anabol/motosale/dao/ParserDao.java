package com.anabol.motosale.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

public interface ParserDao {

    public void uploadManufacturers(String url);

    public TreeMap<String, String> getManufacturers();

    public String getUrlByManufacturer(String manufacturer);

    public void uploadModelPages(String manufacturer);

    public HashMap<String, String> getModels();

    public void saveModels(String manufacturer, HashMap<String, String> modelList);
}
