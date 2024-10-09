package com.muhamidbecerra.examen.t2.proyecto_examen_t2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibro;
	
	private String titulo;
    private String nombreAutor;
    private String apellidoAutor;
    private String categoria;
    private Double precio;
    
	public Libro() {
	}
	
	public Libro(int idLibro, String titulo, String nombreAutor, String apellidoAutor, String categoria,
			Double precio) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidoAutor() {
		return apellidoAutor;
	}
	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
