package com.memoriz.app.controllers;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.services.EstudosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/estudos")
public class EstudosController {

    @Autowired
    private EstudosServices services;

    @GetMapping("/resumos")
    public ModelAndView meuPau() {
        ModelAndView mv = new ModelAndView("relatorio");
        return mv;
    }

    @GetMapping("/registrar-resumo")
    public ModelAndView saveStudies() {
        ModelAndView mv = new ModelAndView("memoriz");
        return mv;
    }

    @PostMapping("/registrar-resumo")
    public ModelAndView saveStudies(Estudos estudos) {
        ModelAndView mv = new ModelAndView("resumos");
        services.save(estudos);
        return mv;
    }

    @GetMapping("/meus-resumos")
    public ModelAndView findAll() {
        Iterable<Estudos> meusEstudos = services.findAll();
        ModelAndView mv = new ModelAndView("resumos");
        mv.addObject("estudos", meusEstudos);
        return mv;
    }

}
