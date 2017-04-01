package com.anabol.motosearch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex(Model model) {
        return "admin";
    }
}