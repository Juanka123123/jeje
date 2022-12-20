package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto cuenta

public class raza {
    @Override
    public String toString() {
        return "raza [id=" + id + ", tamanyo=" + tamanyo + ", amabilidad=" + amabilidad + ", pelosidad=" + pelosidad + ", nombre=" + nombre + "]";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "tamanyo")
    private int tamanyo;
    @Column(name = "amabilidad")
    private int amabilidad;
    @Column(name = "pelosidad")
    private int pelosidad;
    @Column(unique=true)
    private String nombre;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getTamanyo() {
        return tamanyo;
    }
    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }
    public int getAmabilidad() {
        return amabilidad;
    }
    public void setAmabilidad(int amabilidad) {
        this.amabilidad = amabilidad;
    }
    public int getPelosidad() {
        return pelosidad;
    }
    public void setPelosidad(int pelosidad) {
        this.pelosidad = pelosidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
