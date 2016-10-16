package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.model.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;

@Controller
@Transactional
public class WelcomeController {

	@Resource(name = "adDaoImpl")
    private AdDao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Ad> ads = dao.getAllAds();
    	model.addAttribute("ads", ads);
		return "index";
	}

}