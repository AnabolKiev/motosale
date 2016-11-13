package com.anabol.motosale.dao;

import com.anabol.motosale.model.ManufacturerDownload;
import com.anabol.motosale.model.ModelAttribute;
import org.springframework.stereotype.Repository;
import java.util.*;

public interface ParserDao {

    public void downloadManufacturers();

    public Map<String, ManufacturerDownload> getManufacturers();

    public void clearManufacturers();

    public void downloadModels(String manufacturer);

    public void clearModels();

    public Map<String, ModelAttribute> getModels();

    public void saveModelAttr();

    public List<ModelAttribute> getModelAttr();

    public void downloadModelAttr(String url);

    public void clearModelAttr();
}
