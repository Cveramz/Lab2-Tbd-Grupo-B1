package com.chileayuda.voluntariadobackend.Models;

public class Ranking {
    //ATRIBUTOS
    private Integer id_ranking;
    private Integer id_voluntario;
    private Integer id_tarea;
    private int puntos_requisito;

    public Ranking(Integer id_ranking, Integer id_voluntario, Integer id_tarea, int puntos_requisito) {
        this.id_ranking = id_ranking;
        this.id_voluntario = id_voluntario;
        this.id_tarea = id_tarea;
        this.puntos_requisito = puntos_requisito;
    }

    public Integer getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(Integer id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getPuntos_requisito() {
        return puntos_requisito;
    }

    public void setPuntos_requisito(int puntos_requisito) {
        this.puntos_requisito = puntos_requisito;
    }
}
