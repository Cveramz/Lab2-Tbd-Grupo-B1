package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Coordinador;
import java.util.List;

public interface CoordinadorRepository {

    /* metodos abstractos declarados */
    public Coordinador createCoordinador(Coordinador coordinador);
    public List<Coordinador> getCoordinadorById(Integer id);
    public List<Coordinador> findAllCoordinadores();
    public String  updateCoordinador(Coordinador coordinadorUpdate,Integer id_coordinador);
    public void deleteByIdCoordinador(Integer id);

    public List<Coordinador> login(String email_coordinador, String password_coordinador);
}
