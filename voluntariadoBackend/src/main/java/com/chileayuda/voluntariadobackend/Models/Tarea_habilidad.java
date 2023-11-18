package com.chileayuda.voluntariadobackend.Models;

public class Tarea_habilidad {
    private Integer id_tarea_habilidad;
    private Integer id_tarea;
    private Integer id_habilidad;

    public Tarea_habilidad(Integer id_tarea_habilidad, Integer id_tarea, Integer id_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
        this.id_tarea = id_tarea;
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_tarea_habilidad() {
        return id_tarea_habilidad;
    }

    public void setId_tarea_habilidad(Integer id_tarea_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
