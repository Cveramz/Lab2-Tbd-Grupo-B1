package com.chileayuda.voluntariadobackend.Models;

public class Eme_habilidad {
    private Integer id_eme_habilidad;
    private Integer id_emergencia;
    private Integer id_habilidad;

    public Eme_habilidad(Integer id_eme_habilidad, Integer id_emergencia, Integer id_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_eme_habilidad() {
        return id_eme_habilidad;
    }

    public void setId_eme_habilidad(Integer id_eme_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
