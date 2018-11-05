package com.anabol.motosearch.controllers;

import com.anabol.motosearch.service.ParserService;
import com.anabol.motosearch.form.CheckedWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

@Slf4j
@Controller
@Transactional
public class ParserController {

    @Inject
    private ParserService parserService;

    @RequestMapping(value = "/admin/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("manufacturers", parserService.getManufacturers());
        model.addAttribute("models", parserService.getModels());
        //model.addAttribute("bikeModel", parserService.getModelAttr());
        return "admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getManufacturers", method = RequestMethod.GET)
    public String getManufacturers(Model model) {
        parserService.downloadManufacturers();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearManufacturers", method = RequestMethod.GET)
    public String clearManufacturers(Model model) {
        parserService.clearManufacturers();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModelPages", method = RequestMethod.POST)
    public String getModelListByCheckbox(@ModelAttribute("checkedWrapper") CheckedWrapper manufacturers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        for (String manufacturerUrl: manufacturers.getManufacturersList()) {
            parserService.downloadModels(manufacturerUrl);
        }
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearModels", method = RequestMethod.GET)
    public String clearModels(Model model) {
        parserService.clearModels();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/saveModels", method = RequestMethod.GET)
    public String saveModels(Model model) {
        parserService.saveModels();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModelsAttr", method = RequestMethod.GET)
    public String getModels(Model model) {
        parserService.downloadModelsAttr();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/getModelAttr", method = RequestMethod.GET)
    public String getModelAttrByUrl(@RequestParam("pageUrl") String url, Model model) {
        parserService.downloadModelAttr(url);
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/clearModelAttr", method = RequestMethod.GET)
    public String clearModelAttr(Model model) {
        parserService.clearModelAttr();
        return "redirect:/admin/parser";
    }

    @RequestMapping(value = "/admin/parser/saveModelAttr", method = RequestMethod.GET)
    public String saveModelAttr(Model model) {
        parserService.saveModelAttr();
        return "redirect:/admin/parser";
    }
}
