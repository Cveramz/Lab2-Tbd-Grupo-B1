package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import java.util.List;


public interface EmergenciaRepository {

    /* metodos abstractos declarados*/

    public Emergencia createEmergencia(Emergencia emergencia_in);
    public List<Emergencia> getEmergenciaById(Integer id);
    public List<Emergencia> findAllEmergency();
    public List<Emergencia> findAllCompletedEmergency();
    public String updateEmergencia(Emergencia emergenciaUpdate, Integer id);
    public void deleteByIdEmergencia(Integer id);
}
