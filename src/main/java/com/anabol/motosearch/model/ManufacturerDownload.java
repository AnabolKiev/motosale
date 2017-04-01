package com.anabol.motosearch.model;

public class ManufacturerDownload {
    private String url;
    private String name;
    private boolean Checked;
    private int pagesCount;
    private int modelsCount;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getModelsCount() {
        return modelsCount;
    }

    public void setModelsCount(int modelsCount) {
        this.modelsCount = modelsCount;
    }
}

