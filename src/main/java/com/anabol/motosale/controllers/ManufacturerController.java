package com.anabol.motosale.controllers;

import java.util.List;

import com.anabol.motosale.dao.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.anabol.motosale.dao.ManufacturerDao;
import com.anabol.motosale.model.Manufacturer;
import javax.annotation.Resource;

@Controller
@Transactional
public class ManufacturerController {

    @Resource(name = "manufacturerDaoImpl")
    private ManufacturerDao dao;


    @RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
    public String indexManufacturer(Model model) {
        List<Manufacturer> manufacturers = dao.getAllManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerEdit";
    }

    @RequestMapping(value = "/manufacturer/delete/{id}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("id") Long id, Model model) {
        dao.deleteById(id);
        return "redirect:/manufacturer/";
    }

    @RequestMapping(value = "/manufacturer/edit/{id}", method = RequestMethod.GET)
    public String updateManufacturer(@PathVariable("id") Long id, Model model) {
        List<Manufacturer> manufacturers = dao.getAllManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer", dao.findManufacturerById(id));
        return "manufacturerEdit";
    }
    @RequestMapping(value = "/manufacturer/", method = RequestMethod.POST)
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        if (manufacturer.getId() == null) {
            dao.insertManufacturer(manufacturer);
        } else {
            dao.updateManufacturer(manufacturer);
        }
        return "redirect:/manufacturer/";
    }
}
