package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Habilidad;
import com.chileayuda.voluntariadobackend.Repositories.HabilidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {

    private final com.chileayuda.voluntariadobackend.Repositories.HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    /* Servicios disponibles */


    /*--------------------------------------------------------------------------------------------------------
     * createHabilidad: método que guarda una habilidad en la BD;
     *
     * @param habilidad - un objeto que contiene los datos de la habilidad;
     * @return - la habilidad creada y guardada en la base de datos;
     *
     --------------------------------------------------------------------------------------------------------*/
    @PostMapping("/habilidad")
    @ResponseBody
    public Habilidad create(@RequestBody Habilidad habilidad) {
        return habilidadRepository.createHabilidad(habilidad);
    }
    /*--------------------------------------------------------------------------------------------------------
     * getHabilidadById: método que obtiene una habilidad específica de la BD con su id;
     *
     * @param id - id de la habilidad;
     * @return - la habilidad buscada;
     *
     --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/habilidad/{id_habilidad}")
    public List<Habilidad> gethabilidad(@PathVariable Integer id_habilidad) {
        return habilidadRepository.getHabilidadById(id_habilidad);
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAllHabilidades: método que obtiene todas las habilidades de la BD;
     *
     * @return - una lista con las habilidades presentes en la BD;
     *
     --------------------------------------------------------------------------------------------------------}*/
    @GetMapping("/habilidad")
    public List<Habilidad> getAllhabilidades() {
        return habilidadRepository.findAllHabilidades();
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateHabilidad: método que actualiza los datos de una habilidad en la BD;
     *
     * @param habilidadUpdate - el objeto con el id de la habilidad y los nuevos datos;
     * @return - los datos de la habilidad actualizados;
     *
     -------------------------------------------------------------------------------------------------------*/
    @PutMapping("/habilidad/update/{id_habilidad}")
    @ResponseBody
    public String updatehabilidad(@RequestBody Habilidad habilidad, @PathVariable Integer id_habilidad) {
        return habilidadRepository.updateHabilidad(habilidad, id_habilidad);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteHabilidadById: método que borra una habilidad de la BD;
     *
     * @param id - id de la habilidad a eliminar;
     *
     --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/habilidad/{id_habilidad}")
    public void borrar(@PathVariable Integer id_habilidad) {
        habilidadRepository.deleteHabilidadById(id_habilidad);
    }
}

