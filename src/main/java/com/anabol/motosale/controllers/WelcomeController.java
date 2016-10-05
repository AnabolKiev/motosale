package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.anabol.motosale.dao.AdDaoJNDI;
import com.anabol.motosale.model.Ad;
import java.util.*;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Ad> ads = AdDaoJNDI.getInstance().getAllAds();
    	model.addAttribute("ads", ads);
		return "/WEB-INF/jsp/index.jsp";
	}

}