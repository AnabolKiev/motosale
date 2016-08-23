package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.anabol.motosale.dao.AdDaoMem;
import com.anabol.motosale.model.Ad;

/**
 *  онтроллер дл€ главной страницы приложени€.
 */
@Controller
public class WelcomeController {
	private AdDaoMem adDao = new AdDaoMem();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("ads", adDao.getAllAds());
		return "/WEB-INF/jsp/index.jsp";
	}

}