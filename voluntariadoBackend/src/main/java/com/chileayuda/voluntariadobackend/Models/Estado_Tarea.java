package com.chileayuda.voluntariadobackend.Models;

public class Estado_Tarea {
    private Integer id_estado_tarea;
    private String estado;
    public Estado_Tarea(Integer id_estado_tarea, String estado) {
        this.id_estado_tarea = id_estado_tarea;
        this.estado = estado;
    }

    public Integer getId_estado_tarea() {
        return id_estado_tarea;
    }

    public void setId_estado_tarea(Integer id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
