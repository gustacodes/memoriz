package com.memoriz.app.controllers;

import com.memoriz.app.dtos.AlunoDTO;
import com.memoriz.app.dtos.EstudosDTO;
import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.repositories.EstudosRepository;
import com.memoriz.app.services.AlunoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServices alunoServices;

    @Autowired
    private EstudosRepository estudosRepository;

    @PostMapping("/cadastro")
    public Aluno save(@RequestBody Aluno aluno) {
        return alunoServices.save(aluno);
    }

    @GetMapping("/lista")
    public List<Aluno> findAll() {
        return alunoServices.findAll();
    }

    @PostMapping("/estudos/{id}")
    public Aluno salvaEstudos(@PathVariable Long id, @RequestBody Estudos estudos) {
        Aluno aluno = alunoServices.findById(id);
        estudos.setAluno(aluno);
        estudosRepository.save(estudos);
        return aluno;
    }

    @GetMapping("/estudos/{id}")
    public List<Estudos> estudos(@PathVariable Long id) {
        Aluno aluno = alunoServices.findById(id);
        List<Estudos> l = estudosRepository.findByid(id);        
        return l;
    }
}
