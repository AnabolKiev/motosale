package com.anabol.motosale.form;

import com.anabol.motosale.model.ManufacturerDownload;
import java.util.Map;
import java.util.TreeMap;

public class ManufacturersForm {

    private Map<String, ManufacturerDownload> manufacturersMap = new TreeMap<String, ManufacturerDownload>();

    public Map<String, ManufacturerDownload> getManufacturersMap() {
        return manufacturersMap;
    }

    public void setManufacturersMap(Map<String, ManufacturerDownload> manufacturersMap) {
        this.manufacturersMap = manufacturersMap;
    }

}
