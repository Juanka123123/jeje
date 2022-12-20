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


import com.uma.example.springuma.model.RazaService;
import com.uma.example.springuma.model.raza;

@RestController
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping("/razas")
    public List<raza> getRazas(){
        return razaService.getAllRazas();
    }

    @PostMapping(value = "/razas",  consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody raza r) {
        if (razaService.addRaza(r) == null)
            return ResponseEntity.internalServerError().body("la raza ya existe");
        else{
            return ResponseEntity.ok().body("una nueva raza se ha añadido");
        }
	}

    @GetMapping("/raza/{id}")
    public raza getGato(@PathVariable("id") Long id){
        return razaService.getRaza(id);
    }

    @PutMapping(value = "/raza/{id}",  consumes = "application/json")
	public void actulizar(@RequestBody raza r) {
        razaService.updateRaza(r);
	}

    @DeleteMapping("/raza/{id}")
    public ResponseEntity<?> deleteRaza(@RequestBody raza r){
        razaService.deleteRaza(r);
        return ResponseEntity.ok().body("Raza eliminada con exito");
    }


}
