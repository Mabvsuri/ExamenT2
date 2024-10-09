package com.muhamidbecerra.examen.t2.proyecto_examen_t2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Orden;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.repository.IOrdenRepository;

@Service
public class OrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;
	
	public List<Orden> listarOrden(){
		return ordenRepository.findAll();
	}
	
	public Orden hallarOrden(int codigo) {
		return ordenRepository.findById(codigo).orElse(null);
	}
	
	public Orden guardarOrden(Orden Orden) {
		return ordenRepository.save(Orden);
	}
	
	public void eliminarOrden(int codigo) {
		ordenRepository.deleteById(codigo);
	}
}
