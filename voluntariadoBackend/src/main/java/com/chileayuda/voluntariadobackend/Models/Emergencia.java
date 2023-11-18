package com.chileayuda.voluntariadobackend.Models;

import java.awt.*;

public class Emergencia {
    //ATRIBUTOS
    private Integer id_emergencia;
    private Integer id_institucion;
    private String tipo;
    private String ubicacion;
    private String equipamiento_necesario;
    private String titulo;
    private String descripcion;
    private float latitud;
    private float longitud;
    private Point ubicacionGeom;

    public Emergencia(Integer id_emergencia, Integer id_institucion, String tipo, String ubicacion, String equipamiento_necesario, String titulo, String descripcion, float latitud, float longitud, Point ubicacionGeom) {
        this.id_emergencia = id_emergencia;
        this.id_institucion = id_institucion;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.equipamiento_necesario = equipamiento_necesario;
        this.titulo = titulo;
        this.descripcion  = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ubicacionGeom = ubicacionGeom;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
    public float getLatitud() {
        return latitud;
    }
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
    public float getLongitud() {
        return longitud;
    }
    public Point getUbicacionGeom() {
        return ubicacionGeom;
    }
    public void setUbicacionGeom(Point ubicacionGeom) {
        this.ubicacionGeom = ubicacionGeom;
    }
}
