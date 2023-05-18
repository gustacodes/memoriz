package com.memoriz.app.repositories;

import com.memoriz.app.entities.Estudos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudosRepository extends JpaRepository<Estudos, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_estudos WHERE aluno_id = :id")
    List<Estudos> findByid(Long id);
}
