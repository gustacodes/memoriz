package com.memoriz.app.dtos;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private List<Estudos> estudos;

    public AlunoDTO(Aluno aluno) {
        id = aluno.getId();
        nome = aluno.getNome();
        email = aluno.getEmail();
        estudos = aluno.getEstudos();
    }

}
