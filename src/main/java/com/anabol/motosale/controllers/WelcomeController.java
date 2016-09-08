package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.anabol.motosale.dao.AdDaoMem;
import com.anabol.motosale.dao.AdDaoJDBC;
import com.anabol.motosale.model.Ad;
import java.util.*;


@Controller
public class WelcomeController {
//	private AdDaoMem adDao = new AdDaoMem();
	private AdDaoJDBC adDao = new AdDaoJDBC();

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
//		adDao.getConnection();
		List<Ad> ads = adDao.getAllAds();
//		adDao.closeConnection();
    	model.addAttribute("ads", ads);
		return "/WEB-INF/jsp/index.jsp";
	}

}