package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.anabol.motosale.dao.MockUserDao;
import com.anabol.motosale.model.User;

/** 
 * Контроллер для работы с объявлениями
 */
@Controller 
public class AdController {
	private MockUserDao userDao = new MockUserDao();

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/WEB-INF/jsp/addEditUser.jsp";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userDao.findUserById(id));
		return "/WEB-INF/jsp/addEditUser.jsp";
	}
	
/*	@ModelAttribute("user")
	public User newUser() {
	    return new User();
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveUserPost(@ModelAttribute User user) {
	//	userDao.saveUser(user);
		return new ModelAndView("/WEB-INF/jsp/index.jsp", "users", userDao.getAllUsers());
	}

}