package com.anabol.motosale.form;

import java.util.HashMap;
import java.util.Map;

public class MapWrapper {

    private Map<Long, String> map = new HashMap<Long, String>();

    public Map<Long, String> getMap() {
        return map;
    }

    public void setMap(Map<Long, String> map) {
        this.map = map;
    }

}
