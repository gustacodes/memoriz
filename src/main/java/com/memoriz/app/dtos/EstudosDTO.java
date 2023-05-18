package com.memoriz.app.dtos;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudosDTO {

    private Long id;
    private String disciplina;
    private String resumo;
    private Aluno aluno;

    public EstudosDTO(Estudos estudos) {
        id = estudos.getId();
        disciplina = estudos.getDisciplina();
        resumo = estudos.getResumo();
        aluno = estudos.getAluno();
    }

}
