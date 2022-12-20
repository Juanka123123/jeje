package com.uma.example.springuma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.uma.example.springuma.model.GatoService;
import com.uma.example.springuma.model.gato;

@RestController
public class GatoController {
    @Autowired
    private GatoService gatoService;

    @GetMapping("/gatos")
    public List<gato> getGatos(){
        return gatoService.getAllGatos();
    }

    @PostMapping(value = "/gatos",  consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody gato g) {
        if (gatoService.addGato(g) == null)
            return ResponseEntity.internalServerError().body("el gato ya existe");
        else{
            return ResponseEntity.ok().body("un nuevo gato se ha añadido");
        }
	}

    @GetMapping("/gato/{id}")
    public gato getGato(@PathVariable("id") Long id){
        return gatoService.getGato(id);
    }

    @PutMapping(value = "/gato/{id}",  consumes = "application/json")
	public void actulizar(@RequestBody gato g) {
        gatoService.updateGato(g);
	}

    @DeleteMapping("/gato/{id}")
    public ResponseEntity<?> deleteGato(@RequestBody gato g){
        gatoService.deleteGato(g);
        return ResponseEntity.ok().body("Gato eliminada con exito");
    }



}
