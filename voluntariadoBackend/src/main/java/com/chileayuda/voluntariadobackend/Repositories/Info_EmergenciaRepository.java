package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import com.chileayuda.voluntariadobackend.Models.Estado_Tarea;

import java.util.List;

public interface Info_EmergenciaRepository {

    List<Emergencia> obtenerDetallesEmergencia();
    String obtenerEstadoActualEmergencia(Integer idEmergencia);
    int obtenerNumeroVoluntariosPorEmergencia(Integer idEmergencia);

    List<Emergencia> obtenerEmergenciasCompletadas();

}
