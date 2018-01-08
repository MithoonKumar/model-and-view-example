package com.example.demomodelview.controller;


import com.example.demomodelview.model.model1;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
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
    @RequestMapping("/gson")
    @ResponseBody
    public String useOfGson(){
        model1 model = new model1();
        model.setK(10);
        model.setStr("Mithoon");
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        return jsonString;
    }

    @RequestMapping(value="/post",method= RequestMethod.POST)
    @ResponseBody
    public String useOfGson1(@RequestBody String str){
        Gson gson = new Gson();
        model1 newModel = gson.fromJson(str,model1.class);
        return "success";
    }
}
