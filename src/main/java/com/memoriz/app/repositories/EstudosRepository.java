package com.memoriz.app.repositories;

import com.memoriz.app.entities.Estudos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface EstudosRepository extends JpaRepository<Estudos, Long> {

}
