package com.memoriz.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestesController {

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @GetMapping("/meusResumos")
    public ModelAndView meusResumos() {
        ModelAndView mv = new ModelAndView("meusResumos");
        return mv;
    }

    @GetMapping("/memoriz")
    public ModelAndView memoriz() {
        ModelAndView mv = new ModelAndView("memoriz");
        return mv;
    }

    @GetMapping("/relatorio")
    public ModelAndView relatorio() {
        ModelAndView mv = new ModelAndView("relatorio");
        return mv;
    }
}
