package com.uma.example.springuma.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaService {
    @Autowired
    RepositoryRaza repositoryRaza;

    public List<raza> getAllRazas(){
        return repositoryRaza.findAll();
    }
    
    public raza getRaza(long id){
        return repositoryRaza.getReferenceById(id);
    }

    public raza addRaza(raza r){
        return repositoryRaza.saveAndFlush(r);
    }

    public void deleteRaza(raza r){
        repositoryRaza.delete(r);
    }

    public void updateRaza(raza r){
        raza raz = repositoryRaza.getReferenceById(r.getId());
        raz.setAmabilidad(r.getAmabilidad());
        raz.setNombre(r.getNombre());
        raz.setPelosidad(r.getPelosidad());
        raz.setTamanyo(r.getTamanyo());
        repositoryRaza.saveAndFlush(r);
    }

}
