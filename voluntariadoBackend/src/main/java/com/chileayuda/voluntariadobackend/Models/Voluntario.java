package com.chileayuda.voluntariadobackend.Models;


public class Voluntario {
    //ATRIBUTOS

    private Long id_voluntario;
    private String nombre_voluntario;
    private int edad;
    private String equipamiento;
    private Boolean estado_salud;
    private Boolean disponibilidad;
    private String email_voluntario;
    private String password_voluntario;

    public Voluntario(Long id_voluntario, String nombre_voluntario, int edad, String equipamiento, Boolean estado_salud, Boolean disponibilidad, String email_voluntario, String password_voluntario) {
        this.id_voluntario = id_voluntario;
        this.nombre_voluntario = nombre_voluntario;
        this.edad = edad;
        this.equipamiento = equipamiento;
        this.estado_salud = estado_salud;
        this.disponibilidad = disponibilidad;
        this.email_voluntario = email_voluntario;
        this.password_voluntario = password_voluntario;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getNombre_voluntario() {
        return nombre_voluntario;
    }

    public void setNombre_voluntario(String nombre_voluntario) {
        this.nombre_voluntario = nombre_voluntario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public Boolean getEstado_salud() {
        return estado_salud;
    }

    public void setEstado_salud(Boolean estado_salud) {
        this.estado_salud = estado_salud;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEmail_voluntario() {
        return email_voluntario;
    }

    public void setEmail_voluntario(String email_voluntario) {
        this.email_voluntario = email_voluntario;
    }

    public String getPassword_voluntario() {
        return password_voluntario;
    }

    public void setPassword_voluntario(String password_voluntario) {
        this.password_voluntario = password_voluntario;
    }
}

