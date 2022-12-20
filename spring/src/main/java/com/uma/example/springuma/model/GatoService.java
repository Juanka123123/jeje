package com.uma.example.springuma.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Service
public class GatoService {
    @Autowired
    RepositoryGato repositoryGato;

    public List<gato> getAllGatos(){
        return repositoryGato.findAll();
    }
    
    public gato getGato(long id){
        return repositoryGato.getReferenceById(id);
    }

    public gato addGato(gato g){
        return repositoryGato.saveAndFlush(g);
    }

    public void deleteGato(gato g){
        repositoryGato.delete(g);
    }

    public void updateGato(gato g){
        gato cat = repositoryGato.getReferenceById(g.getId());
        cat.setColor(g.getColor());
        cat.setEdad(g.getEdad());
        cat.setNombre(g.getNombre());
		cat.setRaza(g.getRaza());
        repositoryGato.saveAndFlush(cat);
    }

    public void removeGatoID(Long c){
        repositoryGato.deleteById(c);
    }

}
