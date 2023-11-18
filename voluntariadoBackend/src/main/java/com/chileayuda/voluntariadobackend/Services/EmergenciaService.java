package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import com.chileayuda.voluntariadobackend.Repositories.EmergenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {
    private final com.chileayuda.voluntariadobackend.Repositories.EmergenciaRepository emergenciaRepository;

    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }


    /* Servicios disponibles */

    /*--------------------------------------------------------------------------------------------------------
     * createEmergencia: método que guarda una emergencia en la BD;
     *
     * @param emergencia_in - un objeto que contiene los datos de la emergencia;
     * @return - la emergencia creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @PostMapping("/emergencia")
    @ResponseBody
    public Emergencia create(@RequestBody Emergencia emergencia) {
        return emergenciaRepository.createEmergencia(emergencia);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getEmergenciaById: método que obtiene una emergencia específica de la BD con su id;
     *
     * @param id_emergencia - id de la emergencia;
     * @return - la emergencia buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/emergencia/{id_emergencia}")
    public List<Emergencia> getEmergenciaByID(@PathVariable Integer id_emergencia) {
        return emergenciaRepository.getEmergenciaById(id_emergencia);
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todas las emergencias de la BD;
     *
     * @return - una lista con las emergencias presentes en la BD;
     *
    --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/emergencia")
        public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAllEmergency();
    }


    /*--------------------------------------------------------------------------------------------------------
     * findAllCompletas: método que obtiene todas las emergencias completas de la BD;
     *
     * @return - una lista con las emergencias completas en la BD;
     *
    --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/emergencia/completa")
    public List<Emergencia> getAllCompletas(){
        return emergenciaRepository.findAllCompletedEmergency();
    }


    /*--------------------------------------------------------------------------------------------------------
     * updateEmergencia: método que actualiza los datos de una emergencia en la BD;
     *
     * @param emergenciaUpdate - el objeto con el id de la emergencia y los nuevos datos;
     * @return - los datos de la emergencia actualizados;
     *
    --------------------------------------------------------------------------------------------------------*/
    @PutMapping("/emergencia/update/{id_emergencia}")
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable Integer id_emergencia) {
        return emergenciaRepository.updateEmergencia(emergencia, id_emergencia);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdEmergencia: método que borra una emergencia de la BD;
     *
     * @param id_emergencia - id de la emergencia a eliminar;
     *
    --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/emergencia/{id_emergencia}")
    public void borrar(@PathVariable Integer id_emergencia) {
        emergenciaRepository.deleteByIdEmergencia(id_emergencia);
    }
}
