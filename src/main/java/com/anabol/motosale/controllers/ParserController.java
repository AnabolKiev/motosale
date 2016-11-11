package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.ParserDao;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Controller
@Transactional
public class ParserController {
    private String startUrl = "http://www.motorcyclespecs.co.za/Manufacturer.htm";

    @Resource(name = "parserDaoJsoup")
    private ParserDao dao;

    private static Logger log = Logger.getLogger(ParserController.class.getName());

    @RequestMapping(value = "/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("manufacturerList", dao.getManufacturers());
        model.addAttribute("modelList", dao.getModels());
        model.addAttribute("bikeModel", dao.getModelAttr());
        return "parser";
    }

    @RequestMapping(value = "/parser/getManufacturerList", method = RequestMethod.GET)
    public String getManufacrurerList(Model model) {
        dao.uploadManufacturers(startUrl);
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/clearManufacturerList", method = RequestMethod.GET)
    public String clearManufacrurerList(Model model) {
        dao.clearManufacturers();
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/getModelPages", method = RequestMethod.GET)
    public String getModelListByManufacturer(@RequestParam("manufacturerUrl") String manufacturerUrl, Model model) {
        dao.uploadModels(manufacturerUrl);
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser/clearModelList", method = RequestMethod.GET)
    public String clearModelList(Model model) {
        dao.clearModels();
        return "redirect:/parser";
    }


    @RequestMapping(value = "/parser/getModel", method = RequestMethod.GET)
    public String getModelAttrByUrl(@RequestParam("pageUrl") String url, Model model) {
        log.info(url);
        dao.uploadModelAttr(url);
        return "redirect:/parser";
    }
}
