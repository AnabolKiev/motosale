package com.anabol.motosale.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DictionaryController {
    @RequestMapping(value = "/admin/dictionary", method = RequestMethod.GET)
    public String dictionaryIndex(Model model) {
        return "dictionary";
    }
}
