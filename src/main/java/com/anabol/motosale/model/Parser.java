package com.anabol.motosale.model;

import javax.persistence.*;

@Entity
@Table(name = "parser_test")
public class Parser {
    @Id
    @Column(name = "URL")
    private String url;
    @Column(name = "HTML")
    private String html;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
