package com.example.demomodelview.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {
    @RequestMapping("/new")
    public String func(Model model){
        model.addAttribute("one",1);
        return "new";
    }

    @RequestMapping("/index")
    public ModelAndView func1(){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("one","one");
        Map<String, Object> model1 = new HashMap<String, Object>();
        model1.put("one","one hi hai bhai");
        ModelAndView m = new ModelAndView("index","model",model);
        return m;
    }
    @RequestMapping("/one")
    public String redirectMethod(){
        return "redirect:/new";
    }
}
