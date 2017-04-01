package com.anabol.motosearch.controllers;

import com.anabol.motosearch.dao.ParserDao;
import com.anabol.motosearch.form.CheckedWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.logging.Logger;

@Controller
@Transactional
public class ParserController {

    @Inject
    private ParserDao dao;

    private static Logger log = Logger.getLogger(ParserController.class.getName());

    @RequestMapping(value = "/admin/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("manufacturers", dao.getManufacturers());
        model.addAttribute("models", dao.getModels());
        //model.addAttribute("bikeModel", dao.getModelAttr());
        return "parser";
    }

    @RequestMapping(value = "/admin/parser/getManufacturerList", method = RequestMethod.GET)
    public String getManufacturers(Model model) {
        dao.downloadManufacturers();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearManufacturerList", method = RequestMethod.GET)
    public String clearManufacturers(Model model) {
        dao.clearManufacturers();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModelPages", method = RequestMethod.GET)
    public String getModelsByManufacturer(@RequestParam("manufacturerUrl") String manufacturerUrl, Model model) {
        dao.downloadModels(manufacturerUrl);
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModelPages", method = RequestMethod.POST)
    public String getModelListByCheckbox(@ModelAttribute("checkedWrapper") CheckedWrapper manufacturers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        for (String manufacturerUrl: manufacturers.getManufacturersList()) {
             dao.downloadModels(manufacturerUrl);
        }
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearModelList", method = RequestMethod.GET)
    public String clearModels(Model model) {
        dao.clearModels();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModel", method = RequestMethod.GET)
    public String getModelAttrByUrl(@RequestParam("pageUrl") String url, Model model) {
        log.info(url);
        dao.clearModelAttr();
        dao.downloadModelAttr(url);
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/saveModels", method = RequestMethod.GET)
    public String saveModels(Model model) {
        dao.saveModels();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/admin/parser/getModelsAttr", method = RequestMethod.GET)
    public String getModels(Model model) {
        dao.downloadModelsAttr();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearModelAttr", method = RequestMethod.GET)
    public String clearModelAttr(Model model) {
        dao.clearModelAttr();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/saveModelAttr", method = RequestMethod.GET)
    public String saveModelAttr(Model model) {
        dao.saveModelAttr();
        return "redirect:/admin/parser";
    }
}
