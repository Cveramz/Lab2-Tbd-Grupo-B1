package com.chileayuda.voluntariadobackend.Models;

import java.awt.*;

public class Emergencia {
    //ATRIBUTOS
    private Integer id_emergencia;
    private Integer id_institucion;
    private String tipo;
    private String equipamiento_necesario;
    private String titulo;
    private String descripcion;
    private double latitud;
    private double longitud;
    private Point ubicacionGeom;
    private String direccion;

    public Emergencia(Integer id_emergencia, Integer id_institucion, String tipo, String equipamiento_necesario, String titulo, String descripcion, double latitud, double longitud, Point ubicacionGeom, String direccion) {
        this.id_emergencia = id_emergencia;
        this.id_institucion = id_institucion;
        this.tipo = tipo;
        this.equipamiento_necesario = equipamiento_necesario;
        this.titulo = titulo;
        this.descripcion  = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ubicacionGeom = ubicacionGeom;
        this.direccion = direccion;
    }

    //GETTERS Y SETTERS
    public Integer getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Integer id) {
        this.id_emergencia = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getEquipamiento_necesario() {
        return equipamiento_necesario;
    }

    public void setEquipamiento_necesario(String equipamiento_necesario) {
        this.equipamiento_necesario = equipamiento_necesario;
    }

    public Integer getIdInstitucion() {
        return id_institucion;
    }

    public void setIdInstitucion(Integer idnstitucion) {
        this.id_institucion = id_institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public double getLatitud() {
        return latitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public double getLongitud() {
        return longitud;
    }
    public Point getUbicacionGeom() {
        return ubicacionGeom;
    }
    public void setUbicacionGeom(Point ubicacionGeom) {
        this.ubicacionGeom = ubicacionGeom;
    }
    public String getDireccion(){ return direccion;}
    public void setDireccion(String direccion){ this.direccion = direccion;}
}
