package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.*;
import com.anabol.motosale.form.MapWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Transactional
public class DictionaryController {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CoolingTypeDao coolingTypeDao;
    @Autowired
    private EngineTypeDao engineTypeDao;
    @Autowired
    private FinalDriveTypeDao finalDriveTypeDao;
    @Autowired
    private StarterTypeDao starterTypeDao;

    @RequestMapping(value = "/admin/dictionary", method = RequestMethod.GET)
    public String dictionaryIndex(Model model) {
        model.addAttribute("categories", categoryDao.getAll());
        model.addAttribute("coolingTypes", coolingTypeDao.getAll());
        model.addAttribute("engineTypes", engineTypeDao.getAll());
        model.addAttribute("finalDriveTypes", finalDriveTypeDao.getAll());
        model.addAttribute("starterTypes", starterTypeDao.getAll());
        return "dictionary";
    }

    @RequestMapping(value = "/ajax/category/", method = RequestMethod.POST)
    protected void saveCategories(@RequestParam("categoriesWrapper") MapWrapper categoriesWrapper, HttpServletResponse response) throws ServletException, IOException {
    }

}
