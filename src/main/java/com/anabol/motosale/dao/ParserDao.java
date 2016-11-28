package com.anabol.motosale.dao;

import com.anabol.motosale.model.ManufacturerDownload;
import com.anabol.motosale.model.ModelAttributeDownload;
import com.anabol.motosale.model.ModelDownload;

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
