package com.chileayuda.voluntariadobackend.Models;




public class Coordinador {
    //ATRIBUTOS
    private Integer id_coordinador;
    private String nombre_coordinador;
    private String email_coordinador;
    private String password_coordinador;

    public Coordinador(Integer id_coordinador, String nombre_coordinador, String email_coordinador, String password_coordinador) {
        this.id_coordinador = id_coordinador;
        this.nombre_coordinador = nombre_coordinador;
        this.email_coordinador = email_coordinador;
        this.password_coordinador = password_coordinador;
    }

    public Integer getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(Integer id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre_coordinador() {
        return nombre_coordinador;
    }

    public void setNombre_coordinador(String nombre_coordinador) {
        this.nombre_coordinador = nombre_coordinador;
    }

    public String getEmail_coordinador() {
        return email_coordinador;
    }

    public void setEmail_coordinador(String email) {
        this.email_coordinador = email;
    }

    public String getPassword_coordinador() {
        return password_coordinador;
    }

    public void setPassword_coordinador(String password) {
        this.password_coordinador = password;
    }
}
