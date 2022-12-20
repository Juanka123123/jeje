package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto cuenta
public class gato {

    /*@Override
    public String toString() {
        return "gato [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", color=" +   ", raza=" + raza + "]";
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true) 
    private String nombre;
    @Column(name = "edad")
    private long edad;
    @Column(name = "color")
    private String color;
    @ManyToOne
    private raza Raza;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getEdad() {
        return edad;
    }
    public void setEdad(long edad) {
        this.edad = edad;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public raza getRaza() {
        return Raza;
    }
    public void setRaza(raza rza) {
        this.Raza = rza;
    }


}
