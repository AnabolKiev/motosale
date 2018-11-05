package com.anabol.motosearch.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManufacturerDownload {
    private String url;
    private String name;
    private boolean Checked;
    private int pagesCount;
    private int modelsCount;
}

