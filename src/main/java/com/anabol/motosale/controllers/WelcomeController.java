package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.anabol.motosale.dao.MockUserDao;
import com.anabol.motosale.model.User;

/**
 *  онтроллер дл€ главной страницы приложени€.
 */
@Controller
public class WelcomeController {
	private MockUserDao userDao = new MockUserDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("users", userDao.getAllUsers());
		return "/WEB-INF/jsp/index.jsp";
	}

}