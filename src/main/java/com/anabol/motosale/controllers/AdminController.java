package com.anabol.motosale.controllers;

import org.springframework.stereotype.Controller;
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
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex(Model model) {
        return "admin";
    }
}