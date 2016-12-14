package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.repository.*;
import com.anabol.motosale.form.MapWrapper;
import com.anabol.motosale.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Transactional
public class DictionaryController {

    @Inject
    private CategoryRepository categoryDao;
    @Inject
    private CoolingTypeRepository coolingTypeDao;
    @Inject
    private EngineTypeRepository engineTypeDao;
    @Inject
    private FinalDriveTypeRepository finalDriveTypeDao;
    @Inject
    private StarterTypeRepository starterTypeDao;

    @RequestMapping(value = "/admin/dictionary", method = RequestMethod.GET)
    public String dictionaryIndex(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("coolingTypes", coolingTypeDao.findAll());
        model.addAttribute("engineTypes", engineTypeDao.findAll());
        model.addAttribute("finalDriveTypes", finalDriveTypeDao.findAll());
        model.addAttribute("starterTypes", starterTypeDao.findAll());
        return "dictionary";
    }

    @RequestMapping(value = "/ajax/category/", method = RequestMethod.POST)
    public void saveCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> categoriesMap = request.getParameterMap();
        for (String id: categoriesMap.keySet()) {
            String categoryName = categoriesMap.get(id)[0];
            Category category = categoryDao.findOne(Long.valueOf(id));
            category.setName(categoryName);
            categoryDao.save(category);
        }
    }

    @RequestMapping(value = "/ajax/engineType/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveEngineTypes(@RequestBody Map<String, Object> engineTypesMap, BindingResult bindingResult) throws ServletException, IOException {
        System.out.println(bindingResult);
    }

}
