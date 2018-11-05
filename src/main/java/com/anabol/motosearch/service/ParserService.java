package com.anabol.motosearch.service;

import com.anabol.motosearch.model.ManufacturerDownload;
import com.anabol.motosearch.model.ModelAttributeDownload;
import com.anabol.motosearch.model.ModelDownload;

import java.util.*;

public interface ParserService {

    void downloadManufacturers();

    Map<String, ManufacturerDownload> getManufacturers();

    void clearManufacturers();

    void downloadModels(String manufacturer);

    Map<String, ModelDownload> getModels();

    void clearModels();

    void saveModels();

    List<ModelAttributeDownload> getModelAttr();

    void downloadModelsAttr();

    void downloadModelAttr(String url);

    void clearModelAttr();

    void saveModelAttr();
}
