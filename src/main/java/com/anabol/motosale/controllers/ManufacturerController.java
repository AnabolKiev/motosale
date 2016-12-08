package com.anabol.motosale.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.anabol.motosale.dao.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.anabol.motosale.dao.ManufacturerDao;
import com.anabol.motosale.model.Manufacturer;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Transactional
public class ManufacturerController {

    @Resource(name = "manufacturerDaoImpl")
    private ManufacturerDao dao;


    @RequestMapping(value = "/admin/manufacturer", method = RequestMethod.GET)
    public String indexManufacturer(Model model) {
        List<Manufacturer> manufacturers = dao.getAll();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerEdit";
    }

    @RequestMapping(value = "/admin/manufacturer/delete/{id}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("id") Long id, Model model) {
        dao.deleteById(id);
        return "redirect:/admin/manufacturer/";
    }

    @RequestMapping(value = "/admin/manufacturer/edit/{id}", method = RequestMethod.GET)
    public String updateManufacturer(@PathVariable("id") Long id, Model model) {
        List<Manufacturer> manufacturers = dao.getAll();
        model.addAttribute("manufacturers", manufacturers);
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer", dao.findById(id));
        return "manufacturerEdit";
    }
    @RequestMapping(value = "/admin/manufacturer/", method = RequestMethod.POST)
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        if (manufacturer.getId() == null) {
            dao.insert(manufacturer);
        } else {
            dao.update(manufacturer);
        }
        return "redirect:/admin/manufacturer/";
    }

    @RequestMapping(value = "/ajax/manufacturer/", method = RequestMethod.POST)
    protected void setManufacturersActive(@RequestParam("checkedManufacturers") Long[] checkedManufacturers, HttpServletResponse response) throws ServletException, IOException {
        dao.setActiveAll(false);
        dao.setActiveByIds(true, checkedManufacturers);
    }

}
