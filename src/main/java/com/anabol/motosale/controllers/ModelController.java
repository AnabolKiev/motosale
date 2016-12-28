package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.repository.*;
import com.anabol.motosale.model.BikeModel;
import com.anabol.motosale.model.Manufacturer;
import com.anabol.motosale.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Transactional
public class ModelController {

    @Inject
    private ManufacturerRepository manufacturerDao;
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
    @Inject
    private ModelRepository modelDao;

    @RequestMapping(value = "/admin/model", method = RequestMethod.GET)
    public String indexModel(Model model) {
        model.addAttribute("manufacturers", Lists.newArrayList(manufacturerDao.findAll()));
        model.addAttribute("categories", Lists.newArrayList(categoryDao.findAll()));
        model.addAttribute("coolingTypes", Lists.newArrayList(coolingTypeDao.findAll()));
        model.addAttribute("engineTypes", Lists.newArrayList(engineTypeDao.findAll()));
        model.addAttribute("finalDriveTypes", Lists.newArrayList(finalDriveTypeDao.findAll()));
        model.addAttribute("starterTypes", Lists.newArrayList(starterTypeDao.findAll()));
        return "modelEdit";
    }

    @JsonView(Views.AdminUi.class)
    @RequestMapping(value = "/ajax/model/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<BikeModel> showModels(@RequestParam Long manufacturerId) throws ServletException, IOException {
        return modelDao.findByManufacturer_Id(manufacturerId);
    }

    @RequestMapping(value = "/ajax/modelAttr/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody BikeModel showModelAttr(@RequestParam Long modelId) throws ServletException, IOException {
        return modelDao.findOne(modelId);
    }

}
