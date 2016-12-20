package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.dao.repository.ManufacturerRepository;
import com.anabol.motosale.dao.repository.ModelRepository;
import com.anabol.motosale.model.BikeModel;
import com.anabol.motosale.model.Manufacturer;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.*;

@Controller
@Transactional
public class MainController {

	@Resource(name = "adDaoImpl")
    private AdDao dao;
	@Inject
	private ManufacturerRepository manufacturerDao;
	@Inject
	private ModelRepository modelRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("manufacturers", Lists.newArrayList(manufacturerDao.findByActiveTrue()));
		return "index";
	}

	@RequestMapping(value = "/{manufacturerName}", method = RequestMethod.GET)
	public String showManufacturerModels(@PathVariable("manufacturerName") String manufacturerName, Model model) {
		List<Manufacturer> manufacturer = manufacturerDao.findByNameAndActiveTrue(manufacturerName);
		if (1 == manufacturer.size() && !manufacturer.isEmpty()) {
			Long manufacturerId = manufacturer.get(0).getId();
			List<BikeModel> modelList = modelRepository.findByManufacturer_IdAndManufacturer_ActiveTrue(manufacturerId);
			Set<String> modelNameSet = new TreeSet<String>();
			Iterator<BikeModel> modelIterator = modelList.iterator();
			while (modelIterator.hasNext()) {
				modelNameSet.add(modelIterator.next().getName());
			}
			model.addAttribute("modelsShort", modelNameSet);
			model.addAttribute("models", modelList);
			model.addAttribute("manufacturer", manufacturerName);
		}
			return "manufacturer";
	}
}