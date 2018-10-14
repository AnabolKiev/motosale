package com.anabol.motosearch.controllers;

import com.anabol.motosearch.dao.repository.*;
import com.anabol.motosearch.model.*;
import com.anabol.motosearch.service.BikeModelService;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
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
    @Autowired
    private BikeModelService modelService;

    @RequestMapping(value = "/admin/model", method = RequestMethod.GET)
    public String indexModel(Model model) {
        model.addAttribute("manufacturers", Lists.newArrayList(manufacturerDao.findAll()));
        model.addAttribute("categories", Lists.newArrayList(categoryDao.findAll()));
        model.addAttribute("coolingTypes", Lists.newArrayList(coolingTypeDao.findAll()));
        model.addAttribute("engineTypes", Lists.newArrayList(engineTypeDao.findAll()));
        model.addAttribute("finalDriveTypes", Lists.newArrayList(finalDriveTypeDao.findAll()));
        model.addAttribute("starterTypes", Lists.newArrayList(starterTypeDao.findAll()));
        return "admin/modelEdit";
    }

    @JsonView(Views.AdminUi.class)
    @RequestMapping(value = "/ajax/model/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<BikeModel> showModels(@RequestParam Long manufacturerId) throws ServletException, IOException {
        return modelService.findByManufacturer(manufacturerId);
    }

    @RequestMapping(value = "/ajax/deleteModel/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteModel(@RequestParam Long modelId) throws ServletException, IOException {
        modelService.delete(modelId);
    }

    @RequestMapping(value = "/ajax/modelAttr/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody BikeModel showModelAttr(@RequestParam Long modelId) throws ServletException, IOException {
        return modelService.findOne(modelId);
    }


    @RequestMapping(value = "/ajax/modelAttr/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveModelAttr(@RequestBody BikeModel bikeModel) throws ServletException, IOException {
        if (bikeModel.getManufacturerId() != null) {        // Model enrichment for dictionaries
            Manufacturer manufacturer = manufacturerDao.findOne(bikeModel.getManufacturerId());
            if (manufacturer != null) bikeModel.setManufacturer(manufacturer);
        }
        if (bikeModel.getCategoryId() != null) {
            Category category = categoryDao.findOne(bikeModel.getCategoryId());
            if (category != null) bikeModel.setCategory(category);
        }
        if (bikeModel.getCoolingTypeId() != null) {
            CoolingType coolingType = coolingTypeDao.findOne(bikeModel.getCoolingTypeId());
            if (coolingType != null) bikeModel.setCoolingType(coolingType);
        }
        if (bikeModel.getEngineTypeId() != null) {
            EngineType engineType = engineTypeDao.findOne(bikeModel.getEngineTypeId());
            if (engineType != null) bikeModel.setEngineType(engineType);
        }
        if (bikeModel.getFinalDriveTypeId() != null) {
            FinalDriveType finalDriveType = finalDriveTypeDao.findOne(bikeModel.getFinalDriveTypeId());
            if (finalDriveType != null) bikeModel.setFinalDriveType(finalDriveType);
        }
        if (bikeModel.getStarterTypeId() != null) {
            StarterType starterType = starterTypeDao.findOne(bikeModel.getStarterTypeId());
            if (starterType != null) bikeModel.setStarterType(starterType);
        }
        modelService.save(bikeModel);
    }

}
