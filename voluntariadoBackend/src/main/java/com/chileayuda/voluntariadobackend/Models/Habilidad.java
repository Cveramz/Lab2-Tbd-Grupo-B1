package com.chileayuda.voluntariadobackend.Models;


public class Habilidad {
    //ATRIBUTOS
    private Integer id_habilidad;
    private String nombre_habilidad;

    public Habilidad(Integer id_habilidad, String nombre_habilidad) {
        this.id_habilidad = id_habilidad;
        this.nombre_habilidad = nombre_habilidad;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }
}
