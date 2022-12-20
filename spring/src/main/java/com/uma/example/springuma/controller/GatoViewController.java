package com.uma.example.springuma.controller;



import org.hibernate.metamodel.mapping.internal.IdClassRepresentationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.uma.example.springuma.model.GatoService;
import com.uma.example.springuma.model.gato;

@Controller
public class GatoViewController {
    @Autowired
    private GatoService gatoService;

    @GetMapping("/listGato")
    public String listGatoView (Model model) {
        model.addAttribute("gatos", gatoService.getAllGatos());
        return "listagatos";
    }

    @PostMapping("/rgato/{id}")
	public String deleteGatoView(@PathVariable("id") Long id  , Model model) {
       
        gatoService.removeGatoID(id);
        model.addAttribute("gato", gatoService.getGato(id));
        return listGatoView (model);
        
	}

    @GetMapping("/egato/{id}")
	public String editGatoView(@PathVariable("id") Long id ,Model model) {
        model.addAttribute("gato", gatoService.getGato(id));
        return "editagatos";
	}

    @PostMapping("/update")
	public String update(gato cat, Model model) {
        
        gatoService.updateGato(cat);
		model.addAttribute("gato", gatoService.getGato(cat.getId()));
        return listGatoView (model);
	}

    @GetMapping("/nuevogato")
    public String nuevoGatoView (Model model) {
        model.addAttribute("gato",  new gato());
        return "nuevogato";
    }

    @PostMapping("/crea")
	public String crea(gato cat, Model model) {
        gatoService.addGato(cat);
		model.addAttribute("gato", gatoService.getGato(cat.getId()));
        return listGatoView (model);
	}
}   

