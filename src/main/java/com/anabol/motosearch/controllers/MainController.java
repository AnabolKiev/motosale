package com.anabol.motosearch.controllers;

import com.anabol.motosearch.dao.repository.*;
import com.anabol.motosearch.model.*;
import com.anabol.motosearch.service.BikeModelService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;
import static javafx.beans.binding.Bindings.select;

@Controller
@Transactional
public class MainController {

	@Inject
	private ManufacturerRepository manufacturerDao;
	@Autowired
	private BikeModelService modelService;
	@Inject
	private CategoryRepository categoryDao;
    @Inject
    private FinalDriveTypeRepository finalDriveTypeDao;
    @Inject
    private EngineTypeRepository engineTypeDao;

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such page")  // 404
	private class PageNotFoundException extends RuntimeException {
		// ...
	}

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("manufacturers", Lists.newArrayList(manufacturerDao.findByActiveTrue()));
		model.addAttribute("categories", Lists.newArrayList(categoryDao.findAll()));
        model.addAttribute("finalDriveTypes", Lists.newArrayList(finalDriveTypeDao.findAll()));
        model.addAttribute("engineTypes", Lists.newArrayList(engineTypeDao.findAllByOrderByGroupOrderAscEngineOrderAsc()));
		return "index";
	}

	@RequestMapping(value = "/bike/{manufacturerName}", method = RequestMethod.GET)
	public String showManufacturerModels(@PathVariable("manufacturerName") String manufacturerName, Model model) {
		Manufacturer manufacturer = manufacturerDao.findByNameAndActiveTrue(manufacturerName);
		if (manufacturer == null) throw new PageNotFoundException(); // validation of manufacturer`s name
		Long manufacturerId = manufacturer.getId();
		//List<BikeModel> modelList = modelDao.findByManufacturer_IdAndManufacturer_ActiveTrue(manufacturerId);
		//model.addAttribute("modelMap", getAggregatedModels(modelList)); // models data uploads by ajax request now
        model.addAttribute("manufacturerId", manufacturerId);
		model.addAttribute("manufacturer", manufacturer.getName());
		return "manufacturer";
	}

    @RequestMapping(value = "/bike/{manufacturerName}/{modelName}/{modelYear}", method = RequestMethod.GET)
    public String showModelSpecs(@PathVariable("manufacturerName") String manufacturerName, @PathVariable("modelName") String modelName, @PathVariable("modelYear") Integer modelYear, Model model) {
        Manufacturer manufacturer = manufacturerDao.findByNameAndActiveTrue(manufacturerName);
        if (manufacturer == null) throw new PageNotFoundException(); // validation of manufacturer`s name
        Long manufacturerId = manufacturer.getId();
        BikeModel bikeModel = modelService.findByKey(manufacturerId, modelName, modelYear);
		if (bikeModel == null) throw new PageNotFoundException(); // validation of model
		model.addAttribute("model", bikeModel);
        return "model";
    }

	@RequestMapping(value = "/ajax/searchModels/", method = RequestMethod.GET)
	public @ResponseBody
    Page<BikeModel> searchModels(@RequestParam(name = "manufacturer", required = false) final List<Long> manufacturers,
                                 @RequestParam(name = "category", required = false) final List<Long> categories,
                                 @RequestParam(name = "engineType", required = false) final List<Long> engineTypes,
                                 @RequestParam(name = "finalDriveType", required = false) final List<Long> finalDriveTypes,
                                 @RequestParam(name = "yearFrom", required = false) final Integer yearFrom,
                                 @RequestParam(name = "yearTo", required = false) final Integer yearTo,
                                 @RequestParam(name = "displacementFrom", required = false) final Integer displacementFrom,
                                 @RequestParam(name = "displacementTo", required = false) final Integer displacementTo,
                                 @RequestParam(name = "searchText", required = false) final String searchText,
                                 @RequestParam("sizePerPage") final Integer sizePerPage,
                                 @RequestParam("pageNumber") final Integer pageNumber) throws ServletException, IOException {
        return modelService.findByFilters(manufacturers, categories, engineTypes, finalDriveTypes, yearFrom, yearTo, displacementFrom, displacementTo, searchText, sizePerPage, pageNumber);
	}

    @RequestMapping(value = "/ajax/searchModelsAll/", method = RequestMethod.GET)
    public @ResponseBody
    List<Object[]> searchModelsAll(@RequestParam(name = "manufacturer", required = false) final List<Long> manufacturers,
                                    @RequestParam(name = "category", required = false) final List<Long> categories,
                                    @RequestParam(name = "engineType", required = false) final List<Long> engineTypes,
                                    @RequestParam(name = "finalDriveType", required = false) final List<Long> finalDriveTypes,
                                    @RequestParam(name = "yearFrom", required = false) final Integer yearFrom,
                                    @RequestParam(name = "yearTo", required = false) final Integer yearTo,
                                    @RequestParam(name = "displacementFrom", required = false) final Integer displacementFrom,
                                    @RequestParam(name = "displacementTo", required = false) final Integer displacementTo,
                                    @RequestParam(name = "searchText", required = false) final String searchText) throws ServletException, IOException {
        return modelService.findAggregatedByFilters(manufacturers, categories, engineTypes, finalDriveTypes, yearFrom, yearTo, displacementFrom, displacementTo, searchText);
    }

    @RequestMapping(value = "/ajax/searchModelsByManufacturer/", method = RequestMethod.GET)
    public @ResponseBody
    List<Object[]> searchModelsByManufacturer(@RequestParam final Long manufacturerId) throws ServletException, IOException {
        return modelService.findAggregatedByManufacturer(manufacturerId);
    }
}