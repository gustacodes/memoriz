package com.memoriz.app.repositories;

import com.memoriz.app.entities.Aluno;
import com.memoriz.app.entities.Estudos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
