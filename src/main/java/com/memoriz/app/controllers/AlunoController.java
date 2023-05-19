package com.memoriz.app.controllers;

import com.memoriz.app.dtos.AlunoDTO;
import com.memoriz.app.dtos.EstudosDTO;
import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.repositories.EstudosRepository;
import com.memoriz.app.services.AlunoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<AlunoDTO> findAll() {
        List<AlunoDTO> alunoDTO = alunoServices.findAll();
        return alunoDTO;
    }

    @PostMapping("/estudos/save/{id}")
    public Object salvaEstudos(@PathVariable Long id, @RequestBody Estudos estudos) {
        AlunoDTO alunoDTO = alunoServices.findById(id);
        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        estudos.setAluno(aluno);
        estudosRepository.save(estudos);
        return estudos;
    }

    @GetMapping("/estudos/{id}")
    public List<Estudos> estudos(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoServices.findById(id);
        List<Estudos> lista = estudosRepository.findByid(id);
        return lista;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoServices.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
