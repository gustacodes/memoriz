package com.memoriz.app.services;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import com.memoriz.app.repositories.EstudosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudosServices {

    @Autowired
    private EstudosRepository estudosRepository;

    public Estudos save(Estudos estudos) {
        return estudosRepository.save(estudos);
    }

    public List<Estudos> findAll() {
        return estudosRepository.findAll();
    }

    public Estudos findById(Long id) {
        Optional<Estudos> estudo = estudosRepository.findById(id);
        return estudo.get();
    }

}
