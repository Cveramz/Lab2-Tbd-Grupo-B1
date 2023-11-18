package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Institucion;
import com.chileayuda.voluntariadobackend.Repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {

private final com.chileayuda.voluntariadobackend.Repositories.InstitucionRepository institucionRepository;

    public InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    /* Servicios disponibles */


    /*--------------------------------------------------------------------------------------------------------
     * createInstitucion: método que guarda una institución en la BD;
     *
     * @param institucion - un objeto que contiene los datos de la institución;
     * @return - la institución creada y guardada en la base de datos;
     *
     -------------------------------------------------------------------------------------------------------*/
    @PostMapping("/institucion")
    @ResponseBody
    public Institucion create(@RequestBody Institucion institucion) {
        return institucionRepository.createInstitucion(institucion);
    }
    /*--------------------------------------------------------------------------------------------------------
     * getInstitucionById: método que obtiene una institución específica de la BD con su id;
     *
     * @param id - id de la institución;
     * @return - la institución buscada;
     *
     -----------------------------------------------------------------------------------------------------*/
    @GetMapping("/institucion/{id_institucion}")
    public List<Institucion> getInstitucion(@PathVariable Integer id_institucion) {
        return institucionRepository.getInstitucionById(id_institucion);
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAllInstituciones: método que obtiene todas las instituciones de la BD;
     *
     * @return - una lista con las instituciones presentes en la BD;
     *
     -----------------------------------------------------------------------------------------------------*/
    @GetMapping("/institucion")
    public List<Institucion> getAllinstitucions() {
        return institucionRepository.findAllInstituciones();
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateInstitucion: método que actualiza los datos de una institución en la BD;
     *
     * @param institucionUpdate - el objeto con el id de la institución y los nuevos datos;
     * @return - los datos de la institución actualizados;
     *
     ------------------------------------------------------------------------------------------------------*/
    @PutMapping("/institucion/update/{id_institucion}")
    @ResponseBody
    public String updateinstitucion(@RequestBody Institucion institucion, @PathVariable Integer id_institucion) {
        return institucionRepository.updateInstitucion(institucion, id_institucion);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteInstitucionById: método que borra una institución de la BD;
     *
     * @param id - id de la institución a eliminar;
     *
     -------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/institucion/{id_institucion}")
    public void borrar(@PathVariable Integer id_institucion) {
        institucionRepository.deleteInstitucionById(id_institucion);
    }
}

