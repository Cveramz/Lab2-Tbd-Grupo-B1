package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import com.chileayuda.voluntariadobackend.Models.Estado_Tarea;
import com.chileayuda.voluntariadobackend.Repositories.Info_EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class Info_EmergenciaService {
    private final com.chileayuda.voluntariadobackend.Repositories.Info_EmergenciaRepository emergenciaService;

    public Info_EmergenciaService(Info_EmergenciaRepository emergenciaService) {
        this.emergenciaService = emergenciaService;
    }
    @GetMapping("/informacionEmergencia")
    public Object obtenerInformacionEmergencia(@RequestParam Integer idEmergencia) {
        List<Emergencia> detallesEmergencia = emergenciaService.obtenerDetallesEmergencia();
        String estadoActualEmergencia = emergenciaService.obtenerEstadoActualEmergencia(idEmergencia);
        int numeroVoluntariosPorEmergencia = emergenciaService.obtenerNumeroVoluntariosPorEmergencia(idEmergencia);

        // Puedes retornar los resultados directamente como un objeto JSON
        return Map.of(
                "detallesEmergencia", detallesEmergencia,
                "estadoActualEmergencia", estadoActualEmergencia,
                "numeroVoluntariosPorEmergencia", numeroVoluntariosPorEmergencia
        );
    }
    @GetMapping("/completadas")
    public List<Emergencia> obtenerEmergenciasCompletadas() {
        return emergenciaService.obtenerEmergenciasCompletadas();
    }

}
