package com.muhamidbecerra.examen.t2.proyecto_examen_t2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Libro;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.repository.ILibroRepository;

@Service
public class LibroService {

	@Autowired
	private ILibroRepository LibroRepository;
	
	public List<Libro> listarLibro(){
		return LibroRepository.findAll();
	}
	
	public Libro hallarLibro(int codigo) {
		return LibroRepository.findById(codigo).orElse(null);
	}
	
	public Libro guardarLibro(Libro libro) {
		return LibroRepository.save(libro);
	}
	
	public void eliminarLibro(int codigo) {
		LibroRepository.deleteById(codigo);
	}
}
