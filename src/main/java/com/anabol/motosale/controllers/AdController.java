package com.anabol.motosale.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.anabol.motosale.dao.AdDao;
import com.anabol.motosale.model.Ad;

import javax.annotation.Resource;

@Controller
public class AdController {

	@Autowired
	@Resource(name = "adDaoImpl")
	private AdDao dao;

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	   final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAd(Model model) {
		Ad ad = new Ad();
		model.addAttribute("ad", ad);
		return "addEdit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditAd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ad", dao.findAdById(id));
		return "addEdit";
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAd(@PathVariable("id") Long id, Model model) {
		dao.deleteById(id);
        return "redirect:/";
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveAdPost(@ModelAttribute Ad ad, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
		}
        if (ad.getId() == null) {
			dao.insertAd(ad);
        } else {
			dao.updateAd(ad);
        }
        return "redirect:/";
	}

}