package com.memoriz.app.controllers;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.services.EstudosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/estudos")
public class EstudosController {

    @Autowired
    private EstudosServices services;

    @GetMapping("/registrar-resumo")
    public ModelAndView saveStudies() {
        ModelAndView mv = new ModelAndView("memoriz");
        return mv;
    }

    @PostMapping("/registrar-resumo")
    public String saveStudies(Estudos estudos) {
        services.save(estudos);
        return "redirect:/estudos/meus-resumos";
    }

    @PostMapping("/registrar-resumo/{id}")
    public String updateStudies(@PathVariable Long id, Estudos estudos) {

        Estudos studies = services.findById(id);
        studies.setId(id);
        studies.setResumo(estudos.getResumo());
        services.save(studies);
        return "redirect:/estudos/meus-resumos";
    }

    @GetMapping("/meus-resumos")
    public ModelAndView findAllStudies() {
        Iterable<Estudos> meusEstudos = services.findAll();
        ModelAndView mv = new ModelAndView("/tests/resumos");
        mv.addObject("estudos", meusEstudos);
        return mv;
    }
}
