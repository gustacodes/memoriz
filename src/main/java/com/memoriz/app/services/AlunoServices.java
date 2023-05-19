package com.memoriz.app.services;

import com.memoriz.app.dtos.AlunoDTO;
import com.memoriz.app.entities.Aluno;
import com.memoriz.app.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServices {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<AlunoDTO> findAll() {
        List<Aluno> listaAlunos = alunoRepository.findAll();
        return listaAlunos.stream().map(x -> new AlunoDTO(x)).toList();
    }

    public AlunoDTO findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        Aluno al = aluno.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return new AlunoDTO(aluno.get());
    }

}
