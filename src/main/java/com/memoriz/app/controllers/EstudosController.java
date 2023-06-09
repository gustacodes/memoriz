package com.memoriz.app.controllers;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.services.EstudosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudos")
public class EstudosController {

    @Autowired
    private EstudosServices services;

    /*@PostMapping("/registrar-resumo/{id}")
    public String updateStudies(@PathVariable Long id, Estudos estudos) {

        Estudos studies = services.findById(id);
        studies.setId(id);
        studies.setResumo(estudos.getResumo());
        services.save(studies);
        return "redirect:/estudos/meus-resumos";
    }*/

    @GetMapping("/registrar-resumo")
    public ModelAndView saveStudies() {
        ModelAndView mv = new ModelAndView("memoriz");
        List<Estudos> estudos = services.findAll();
        mv.addObject("estudos", estudos);
        return mv;
    }

    @PostMapping("/registrar-resumo")
    public RedirectView saveStudies(Estudos estudos) {
        services.save(estudos);
        return new RedirectView("/estudos/registrar-resumo");
    }

    @GetMapping("/meus-resumos/{id}")
    public ModelAndView findStudies(@PathVariable Long id) {
        Estudos meusEstudos = services.findById(id);
        ModelAndView mv = new ModelAndView("resumos");
        mv.addObject("estudos", meusEstudos);
        return mv;
    }

}
