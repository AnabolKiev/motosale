package com.anabol.motosale.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
//import com.anabol.motosale.dao.AdDaoMem;
import com.anabol.motosale.dao.AdDaoJDBC;
import com.anabol.motosale.model.Ad;

@Controller
public class AdController {
//	private AdDaoMem adDao = new AdDaoMem();
	private AdDaoJDBC adDao = new AdDaoJDBC();

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	   final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAd(Model model) {
		Ad ad = new Ad();
		model.addAttribute("ad", ad);
		return "/WEB-INF/jsp/addEdit.jsp";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditAd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ad", adDao.findAdById(id));
		return "/WEB-INF/jsp/addEdit.jsp";
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAd(@PathVariable("id") Long id, Model model) {
        adDao.deleteById(id);
        List<Ad> ads = adDao.getAllAds();
        model.addAttribute("ads", ads);
        return "/WEB-INF/jsp/index.jsp";
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveAdPost(@ModelAttribute Ad ad, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/WEB-INF/jsp/error.jsp", "bindRes", bindingResult);
		}
        if (ad.getId() == null) {
            adDao.insertAd(ad);
        } else {
            adDao.updateAd(ad);
        }
		List<Ad> ads = adDao.getAllAds();
		return new ModelAndView("/WEB-INF/jsp/index.jsp", "ads", ads);
	}

}