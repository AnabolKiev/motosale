package com.anabol.motosearch.dao;

import com.anabol.motosearch.model.ManufacturerDownload;
import com.anabol.motosearch.model.ModelAttributeDownload;
import com.anabol.motosearch.model.ModelDownload;

import java.util.*;

public interface ParserDao {

    public void downloadManufacturers();

    public Map<String, ManufacturerDownload> getManufacturers();

    public void clearManufacturers();

    public void downloadModels(String manufacturer);

    public void clearModels();

    public Map<String, ModelDownload> getModels();

    public void saveModels();

    public void saveModelAttr();

    public List<ModelAttributeDownload> getModelAttr();

    public void downloadModelAttr(String url);

    public void downloadModelsAttr();

    public void clearModelAttr();
}
