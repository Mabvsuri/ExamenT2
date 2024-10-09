package com.muhamidbecerra.examen.t2.proyecto_examen_t2.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Libro;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.model.Orden;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.service.LibroService;
import com.muhamidbecerra.examen.t2.proyecto_examen_t2.service.OrdenService;

@Controller
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/listarOrdenes")
    public String listarOrden(Model model) {
        List<Orden> ordenes = ordenService.listarOrden();
        model.addAttribute("libros", libroService.listarLibro());
        model.addAttribute("ordenes", ordenes);
        
        return "ordenes";
    }
    
    @GetMapping("/nuevaOrden")
    public String nuevaOrden(Model model) {
        model.addAttribute("orden", new Orden());
        model.addAttribute("libros", libroService.listarLibro());
        return "OrdenForm";
    }
    
    @GetMapping("/mostrarOrden/{id}")
    public String mostrarOrden(@PathVariable int id, Model model) {
        model.addAttribute("libros", libroService.listarLibro());
        model.addAttribute("orden", ordenService.hallarOrden(id));
        return "OrdenForm";
    }
    
    @PostMapping("/saveOrden")
    public String guardarOrden(@ModelAttribute Orden orden, @RequestParam List<Integer> libroIds) {
        Set<Libro> librosSeleccionados = new HashSet<>();
        for (Integer libroId : libroIds) {
            Libro libro = libroService.hallarLibro(libroId);
            if (libro != null) {
                librosSeleccionados.add(libro);
            }
        }
        orden.setLibros(librosSeleccionados);
        ordenService.guardarOrden(orden);
        return "redirect:/listarOrdenes";
    }
    
    @GetMapping("/ordenDelete/{id}")
    public String eliminarOrden(@PathVariable int id) {
        ordenService.eliminarOrden(id);
        return "redirect:/listarOrdenes";
    }
}
