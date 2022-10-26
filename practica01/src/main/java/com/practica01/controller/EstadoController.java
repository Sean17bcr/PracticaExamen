
package com.practica01.controller;

import com.practica01.domain.Estado;
import com.practica01.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/estado/nuevo")
    public String nuevoEstado(Estado estado){
        return "modificarEstado";
    }
    
    @PostMapping("/estado/guardar")
    public String guardarEstado(Estado estado){
        estadoService.save(estado);
        
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idPais}")
    public String modificarEstado(Estado estado, Model model){
        estado = estadoService.getEstado(estado);
        model.addAttribute("estado",estado);
        
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idPais}")
    public String eliminarEstado(Estado estado){
        estadoService.delete(estado);
        return "redirect:/";
    }
    
    
}
