package com.memoriz.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    @ManyToOne
    @JoinColumn
    private Aluno aluno;

}
