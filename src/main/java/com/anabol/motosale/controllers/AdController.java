package com.anabol.motosale.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.model.Ad;

/** 
 * Контроллер для работы с объявлениями
 */
@Controller 
public class AdController {
	private AdDao adDao = new AdDao();

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	   final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		Ad ad = new Ad();
		model.addAttribute("ad", ad);
		return "/WEB-INF/jsp/addEdit.jsp";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditAd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ad", adDao.findAdById(id));
		return "/WEB-INF/jsp/addEdit.jsp";
	}
	
/*	@ModelAttribute("user")
	public User newUser() {
	    return new User();
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveAdPost(@ModelAttribute Ad ad, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/WEB-INF/jsp/error.jsp", "bindRes", bindingResult);
		}
		adDao.saveAd(ad);
		return new ModelAndView("/WEB-INF/jsp/index.jsp", "ads", adDao.getAllAds());
	}

}