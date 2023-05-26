package com.memoriz.app.controllers;

import com.memoriz.app.entities.Estudos;
import com.memoriz.app.services.EstudosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestesController {

    @Autowired
    EstudosServices es;

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

    @GetMapping("/status")
    public ModelAndView status() {
        ModelAndView mv = new ModelAndView("tests/status");
        List<Estudos> estudos = es.findAll();
        mv.addObject("estudos", estudos);
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
