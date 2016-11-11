package com.anabol.motosale.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

public interface ParserDao {

    public void uploadManufacturers(String url);

    public TreeMap<String, String> getManufacturers();

    public void clearManufacturers();

    public void uploadModels(String manufacturer);

    public void clearModels();

    public HashMap<String, String> getModels();

    public void saveModels(String manufacturer, HashMap<String, String> modelList);

    public HashMap<String, String> getModelAttr();

    public void uploadModelAttr(String url);
}
