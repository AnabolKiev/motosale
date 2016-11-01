package com.anabol.motosale.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.anabol.motosale.model.Parser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.*;

@Controller
@Transactional
public class ParserController {
    private String startUrl = "http://www.motorcyclespecs.co.za/Manufacturer.htm";

    @PersistenceContext(unitName = "MotoSaleJPA")
    private EntityManager em;

/*    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/

    public HashMap<String, String> parseLinks(String urlToRead, String selector) throws IOException {
        HashMap<String, String> result = new HashMap();
        Document doc = Jsoup.connect(urlToRead).get();
        Elements links = doc.select(selector);
        for (Element src: links) {
            result.put(src.text(), src.attr("abs:href"));
        }
        return result;
    }

    @RequestMapping(value = "/parser", method = RequestMethod.GET)
    public String parse(Model model) {
        model.addAttribute("parser", new Parser());
        return "parser";
    }

    @RequestMapping(value = "/parser", method = RequestMethod.POST)
    public String savePost(@ModelAttribute Parser parser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindRes", bindingResult);
            return "error";
        }

//        parser.setHtml(getHTML(parser.getUrl()));
//        Session session = sessionFactory.getCurrentSession();
//        session.save(parser);

        Map<String, String> manufacturerSet = new HashMap<String, String>();
        Map<String, HashSet> manufacturerLinkSet = new HashMap<String, HashSet>();
        HashSet<String> hSet = new HashSet();
        HashSet<String> modelLinks = new HashSet();
        HashSet<String> modelAttr = new HashSet();
        String tempStr = "";
        int i = 1;
        try {
//            manufacturerSet = parseLinks(startUrl, "td#table24 p + p a[href]");
//            tempStr = manufacturerSet.get("Honda");
//            tempStr = "http://www.motorcyclespecs.co.za/bikes/Honda%20.htm";
//            hSet.addAll(parseLinks(tempStr, "p b a[href]").values());

//            for(String tmpUrl: hSet) {
//                modelLinks.addAll(parseLinks(tmpUrl, "div table td a[href]").values());
//            }


            tempStr = "http://www.motorcyclespecs.co.za/model/Honda/honda_cb600f%2005.htm";
            modelAttr.addAll(parseLinks(tempStr, "div font table tr").values());

        } catch (IOException e) {
            e.printStackTrace();
        }


        model.addAttribute("bindRes",modelAttr);
        return "error";
    }
}
