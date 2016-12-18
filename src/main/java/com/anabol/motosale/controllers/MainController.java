package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.dao.repository.ManufacturerRepository;
import com.anabol.motosale.dao.repository.ModelRepository;
import com.anabol.motosale.model.Ad;
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
import java.util.List;

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
        model.addAttribute("models", Lists.newArrayList(modelRepository.findByManufacturer_Name(manufacturerName)));
        model.addAttribute("manufacturer", manufacturerName);
		return "manufacturer";
	}
}