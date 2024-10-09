package com.muhamidbecerra.examen.t2.proyecto_examen_t2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Libro;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.service.LibroService;

@Controller
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/listarLibros")
	public String listarLibros(Model model){
		List<Libro> libros = libroService.listarLibro();
		model.addAttribute("libros", libros);
		
		return "Libros";
	}
	
	@GetMapping("/nuevoLibro")
	public String nuevoLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "LibroForm";
	}
	
	@GetMapping("/mostrarLibro/{id}")
	public String mostrarLibro(@PathVariable int id, Model model) {
		model.addAttribute("libro", libroService.hallarLibro(id));
		return "LibroForm";
	}
	
	@PostMapping("/saveLibro")
	public String guardarLibro(@ModelAttribute Libro libro) {
		libroService.guardarLibro(libro);
		return "redirect:/listarLibros";
	}
	
	@GetMapping("/libroDelete/{id}")
	public String eliminarLibro(@PathVariable int id) {
		libroService.eliminarLibro(id);
		return "redirect:/listarLibros";
	}
}
