package com.anabol.motosearch.controllers.old;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.anabol.motosearch.dao.repository.ManufacturerRepository;
import com.anabol.motosearch.dao.old.AdDao;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.anabol.motosearch.model.old.Ad;

import javax.annotation.Resource;
import javax.inject.Inject;

@Controller
@Transactional
public class AdController {

	@Resource(name = "adDaoImpl")
	private AdDao dao;
	@Inject
	private ManufacturerRepository manufacturerDao;

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	   final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAd(Model model) {
		model.addAttribute("ad", new Ad());
		model.addAttribute("manufacturers", manufacturerDao.findAll());
		return "old/addEdit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditAd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ad", dao.findAdById(id));
		model.addAttribute("manufacturers", manufacturerDao.findAll());
		return "old/addEdit";
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