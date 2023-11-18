package com.chileayuda.voluntariadobackend.Models;



public class Institucion {
    //ATRIBUTOS
    private Integer id_institucion;
    private String nombre_institucion;
    private int telefono;
    private String ubicacion_institucion;
    private Integer id_coordinador;

    public Institucion(Integer id_institucion, String nombre_institucion, int telefono, String ubicacion_institucion, Integer id_coordinador) {
        this.id_institucion = id_institucion;
        this.nombre_institucion = nombre_institucion;
        this.telefono = telefono;
        this.ubicacion_institucion = ubicacion_institucion;
        this.id_coordinador = id_coordinador;
    }

    public Integer getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion_institucion() {
        return ubicacion_institucion;
    }

    public void setUbicacion_institucion(String ubicacion_institucion) {
        this.ubicacion_institucion = ubicacion_institucion;
    }

    public Integer getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(Integer id_coordinador) {
        this.id_coordinador = id_coordinador;
    }
}
