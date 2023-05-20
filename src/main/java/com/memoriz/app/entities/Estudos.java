package com.memoriz.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_estudos")
@Getter
@Setter
public class Estudos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String disciplina;
    @Column(columnDefinition = "TEXT")
    private String resumo;
    @ManyToOne
    @JoinColumn
    private Aluno aluno;

}
