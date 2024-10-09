package com.muhamidbecerra.examen.t2.proyecto_examen_t2.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ordenes")
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;
    
    private int idCliente;
    
    private LocalDate fechaOrden;
    
    @ManyToMany
    @JoinTable(
        name = "orden_libro",
        joinColumns = @JoinColumn(name = "idOrden"),
        inverseJoinColumns = @JoinColumn(name = "idLibro")
    )
    private Set<Libro> libros = new HashSet<>();

	public Orden(int idOrden, int idCliente, LocalDate fechaOrden, Set<Libro> libros) {
		this.idOrden = idOrden;
		this.idCliente = idCliente;
		this.fechaOrden = fechaOrden;
		this.libros = libros;
	}

	public Orden() {
		
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

    
}
