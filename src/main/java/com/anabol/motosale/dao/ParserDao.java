package com.anabol.motosale.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

public interface ParserDao {
    public HashMap<String, String> parseLinks(String urlToRead, String selector);

    public void saveManufacturerList(HashMap<String, String> manufacturerList);

    public HashMap<String, String> getManufacturerList();

    public String getManufacturerUrl(String manufacturer);

    public HashMap<String, String> getModelList();

    public void saveModelList(String manufacturer, HashMap<String, String> modelList);
}
