package com.anabol.motosale.controllers;

import com.anabol.motosale.dao.ParserDao;
import com.anabol.motosale.model.ModelList;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Controller
@Transactional
public class ParserController {
    private String startUrl = "http://www.motorcyclespecs.co.za/Manufacturer.htm";

    @Resource(name = "parserDaoImpl")
    private ParserDao dao;

    @RequestMapping(value = "/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("manufacturerList", dao.getManufacturerMap());
        model.addAttribute("modelList", dao.getModelMap());
        return "parser";
    }

    @RequestMapping(value = "/parser/getManufacturerList", method = RequestMethod.GET)
    public String getManufacrurerList(Model model) {
        dao.saveManufacturerMap(dao.parseLinks(startUrl, "td#table24 p + p a[href]"));
        return "redirect:/parser";
    }

    @RequestMapping(value = "/parser", method = RequestMethod.POST)
    public String savePost(@ModelAttribute ModelList models, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }

        Map<String, String> manufacturerSet = new HashMap<String, String>();
        Map<String, HashSet> manufacturerLinkSet = new HashMap<String, HashSet>();
        HashSet<String> hSet = new HashSet();
        HashSet<String> modelLinks = new HashSet();
        HashSet<String> modelAttr = new HashSet();
        String tempStr = "";
        int i = 1;

//            manufacturerSet = parseLinks(startUrl, "td#table24 p + p a[href]");
//            tempStr = manufacturerSet.get("Honda");
//            tempStr = "http://www.motorcyclespecs.co.za/bikes/Honda%20.htm";
//            hSet.addAll(parseLinks(tempStr, "p b a[href]").values());

//            for(String tmpUrl: hSet) {
//                modelLinks.addAll(parseLinks(tmpUrl, "div table td a[href]").values());
//            }


            tempStr = "http://www.motorcyclespecs.co.za/model/Honda/honda_cb600f%2005.htm";
            modelAttr.addAll(dao.parseLinks(tempStr, "div font table tr").values());
        model.addAttribute("bindRes",modelAttr);
        return "error";
    }
}
