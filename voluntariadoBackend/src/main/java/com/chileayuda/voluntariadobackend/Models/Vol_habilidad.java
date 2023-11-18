package com.chileayuda.voluntariadobackend.Models;

public class Vol_habilidad {
    private Integer id_vol_habilidad;
    private Integer id_voluntario;
    private Integer id_habilidad;

    public Vol_habilidad(Integer id_vol_habilidad, Integer id_voluntario, Integer id_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_vol_habilidad() {
        return id_vol_habilidad;
    }

    public void setId_vol_habilidad(Integer id_vol_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
