package com.anabol.motosearch.controllers;

import java.io.IOException;

import com.anabol.motosearch.dao.repository.ManufacturerRepository;
import com.anabol.motosearch.model.Manufacturer;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

@Controller
@Transactional
public class ManufacturerController {

    @Inject
    private ManufacturerRepository dao;

    @RequestMapping(value = "/admin/manufacturer", method = RequestMethod.GET)
    public String indexManufacturer(Model model) {
        model.addAttribute("manufacturers", Lists.newArrayList(dao.findAll()));
        model.addAttribute("manufacturer", new Manufacturer());
        return "admin/manufacturerEdit";
    }

    @RequestMapping(value = "/admin/manufacturer/delete/{id}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("id") Long id, Model model) {
        dao.delete(id);
        return "redirect:/admin/manufacturer/";
    }

    @RequestMapping(value = "/admin/manufacturer/edit/{id}", method = RequestMethod.GET)
    public String updateManufacturer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("manufacturers", Lists.newArrayList(dao.findAll()));
        model.addAttribute("manufacturer", dao.findOne(id));
        return "admin/manufacturerEdit";
    }
    @RequestMapping(value = "/admin/manufacturer/", method = RequestMethod.POST)
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        dao.save(manufacturer);
        return "redirect:/admin/manufacturer/";
    }

    @RequestMapping(value = "/ajax/manufacturer/", method = RequestMethod.POST)
    public void setManufacturersActive(@RequestParam("checkedManufacturers") Long[] checkedManufacturers, HttpServletResponse response) throws ServletException, IOException {
        dao.setActiveAll(false);
        dao.setActiveByIDs(true, checkedManufacturers);
    }

}
