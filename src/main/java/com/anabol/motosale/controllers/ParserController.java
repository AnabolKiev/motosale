package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.ParserDao;
import com.anabol.motosale.form.CheckedWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Controller
@Transactional
public class ParserController {

    @Resource(name = "parserDaoJsoup")
    private ParserDao dao;

    private static Logger log = Logger.getLogger(ParserController.class.getName());

    @RequestMapping(value = "/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("manufacturers", dao.getManufacturers());
        model.addAttribute("models", dao.getModels());
        model.addAttribute("bikeModel", dao.getModelAttr());
        return "parser";
    }

    @RequestMapping(value = "/parser/getManufacturerList", method = RequestMethod.GET)
    public String getManufacturers(Model model) {
        dao.downloadManufacturers();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/clearManufacturerList", method = RequestMethod.GET)
    public String clearManufacturers(Model model) {
        dao.clearManufacturers();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/getModelPages", method = RequestMethod.GET)
    public String getModelsByManufacturer(@RequestParam("manufacturerUrl") String manufacturerUrl, Model model) {
        dao.downloadModels(manufacturerUrl);
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/getModelPages", method = RequestMethod.POST)
    public String getModelListByCheckbox(@ModelAttribute("checkedWrapper") CheckedWrapper manufacturers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }
        for (String manufacturerUrl: manufacturers.getManufacturersList()) {
             dao.downloadModels(manufacturerUrl);
        }
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/clearModelList", method = RequestMethod.GET)
    public String clearModels(Model model) {
        dao.clearModels();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/getModel", method = RequestMethod.GET)
    public String getModelAttrByUrl(@RequestParam("pageUrl") String url, Model model) {
        log.info(url);
        dao.clearModelAttr();
        dao.downloadModelAttr(url);
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/getModels", method = RequestMethod.GET)
    public String getModels(Model model) {
        dao.downloadModelsAttr();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/clearModelAttr", method = RequestMethod.GET)
    public String clearModelAttr(Model model) {
        dao.clearModelAttr();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/saveModelAttr", method = RequestMethod.GET)
    public String saveModelAttr(Model model) {
        dao.saveModelAttr();
        return "redirect:/parser";
    }
}
