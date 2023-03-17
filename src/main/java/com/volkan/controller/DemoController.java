package com.volkan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/getname")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","mustafa");
        modelAndView.setViewName("demo");
        return modelAndView;
    }
}
