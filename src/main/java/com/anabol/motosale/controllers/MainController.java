package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.dao.repository.*;
import com.anabol.motosale.model.BikeModel;
import com.anabol.motosale.model.BikeModel_;
import com.anabol.motosale.model.Manufacturer;
import com.anabol.motosale.model.Manufacturer_;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.data.jpa.domain.Specifications.*;
import javax.persistence.criteria.*;

@Controller
@Transactional
public class MainController {

	@Resource(name = "adDaoImpl")
    private AdDao dao;
	@Inject
	private ManufacturerRepository manufacturerDao;
	@Inject
	private ModelRepository modelDao;
	@Inject
	private CategoryRepository categoryDao;
    @Inject
    private FinalDriveTypeRepository finalDriveTypeDao;
    @Inject
    private EngineTypeRepository engineTypeDao;

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such page")  // 404
	public class PageNotFoundException extends RuntimeException {
		// ...
	}

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("manufacturers", Lists.newArrayList(manufacturerDao.findByActiveTrue()));
		model.addAttribute("categories", Lists.newArrayList(categoryDao.findAll()));
        model.addAttribute("finalDriveTypes", Lists.newArrayList(finalDriveTypeDao.findAll()));
        model.addAttribute("engineTypes", Lists.newArrayList(engineTypeDao.findAll()));
		return "index";
	}

	@RequestMapping(value = "/{manufacturerName}", method = RequestMethod.GET)
	public String showManufacturerModels(@PathVariable("manufacturerName") String manufacturerName, Model model) {
		Manufacturer manufacturer = manufacturerDao.findByNameAndActiveTrue(manufacturerName);
		if (manufacturer == null) throw new PageNotFoundException(); // validation of manufacturer`s name
		Long manufacturerId = manufacturer.getId();
		List<BikeModel> modelList = modelDao.findByManufacturer_IdAndManufacturer_ActiveTrue(manufacturerId);
		Iterator<BikeModel> modelIterator = modelList.iterator();
		Map<String, Set<Integer>> modelMap = new TreeMap<>(); 	// Sorted map. Key - unique models, Values - years
		while (modelIterator.hasNext()) {
			BikeModel bikeModel = modelIterator.next();
			if (!modelMap.containsKey(bikeModel.getName())) {  	// create new record in map
				modelMap.put(bikeModel.getName(), new TreeSet<Integer>());
			}
			modelMap.get(bikeModel.getName()).add(bikeModel.getYear());  // adding year
		}
		model.addAttribute("modelMap", modelMap);
		model.addAttribute("manufacturer", manufacturerName);
		return "manufacturer";
	}

    @RequestMapping(value = "/{manufacturerName}/{modelName}/{modelYear}", method = RequestMethod.GET)
    public String showModelSpecs(@PathVariable("manufacturerName") String manufacturerName, @PathVariable("modelName") String modelName, @PathVariable("modelYear") Integer modelYear, Model model) {
        Manufacturer manufacturer = manufacturerDao.findByNameAndActiveTrue(manufacturerName);
        if (manufacturer == null) throw new PageNotFoundException(); // validation of manufacturer`s name
        Long manufacturerId = manufacturer.getId();
        BikeModel bikeModel = modelDao.findByManufacturer_IdAndNameAndYearAndManufacturer_ActiveTrue(manufacturerId, modelName, modelYear);
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
                                 @RequestParam("sizePerPage") final Integer sizePerPage,
                                 @RequestParam("pageNumber") final Integer pageNumber) throws ServletException, IOException {
		Specification<BikeModel> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();   // Constructing list of parameters
            predicates.add(cb.isTrue(root.join(BikeModel_.manufacturer, JoinType.LEFT).get(Manufacturer_.active)));
            if (manufacturers != null) {
                predicates.add(root.get(BikeModel_.manufacturer).in(manufacturers));
            }
            if (categories != null) {
                predicates.add(root.get(BikeModel_.category).in(categories));
            }
            if (engineTypes != null) {
                predicates.add(root.get(BikeModel_.engineType).in(engineTypes));
            }
            if (finalDriveTypes != null) {
                predicates.add(root.get(BikeModel_.finalDriveType).in(finalDriveTypes));
            }
            if (yearFrom != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.year), yearFrom));
            }
            if (yearTo != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.year), yearTo));
            }
            if (displacementFrom != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.displacement), displacementFrom.floatValue()));
            }
            if (displacementTo != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.displacement), displacementTo.floatValue()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return modelDao.findAll(spec, new PageRequest(pageNumber, sizePerPage));
	}

}