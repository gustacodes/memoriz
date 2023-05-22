package com.memoriz.app.controllers;

import com.memoriz.app.dtos.AlunoDTO;
import com.memoriz.app.dtos.EstudosDTO;
import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.repositories.EstudosRepository;
import com.memoriz.app.services.AlunoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServices alunoServices;

    @Autowired
    private EstudosRepository estudosRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoServices.save(aluno));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<AlunoDTO>> findAll() {
        List<AlunoDTO> alunoDTO = alunoServices.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);
    }

    @GetMapping("/estudos/save")
    public ModelAndView salvaEstudos() {
        ModelAndView mv = new ModelAndView("memoriz");
        return mv;
    }

    @PostMapping("/estudos/save")
    public ModelAndView salvaEstudos(Estudos estudos) {
        ModelAndView mv = new ModelAndView("memoriz");
        estudosRepository.save(estudos);
        return mv;
    }

    @GetMapping("/estudos/{id}")
    public ResponseEntity<AlunoDTO> estudos(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoServices.findById(id);
        List<Estudos> lista = estudosRepository.findByid(id);
        alunoDTO.setEstudos(lista);

        return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoServices.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
