package com.muhamidbecerra.examen.t2.proyecto_examen_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

}
