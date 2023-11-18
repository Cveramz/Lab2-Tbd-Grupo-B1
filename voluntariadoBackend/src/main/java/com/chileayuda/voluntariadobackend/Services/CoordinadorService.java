package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Coordinador;
import com.chileayuda.voluntariadobackend.Repositories.CoordinadorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class CoordinadorService {

   private final com.chileayuda.voluntariadobackend.Repositories.CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository) {
        this.coordinadorRepository = coordinadorRepository;
    }

    /* Servicios disponibles */

    /*--------------------------------------------------------------------------------------------------------
     * createCoordinador: método que guarda un coordinador en la BD;
     *
     * @param coordinador_in - un objeto que contiene los datos del coordinador;
     * @return - el coordinador creado y guardado en la base de datos;
     *
    ------------------------------------------------------------------------------------------------------*/
    @PostMapping("/coordinador")
    @ResponseBody
    public Coordinador createCoordinador(@RequestBody Coordinador coordinador_in) {
        return coordinadorRepository.createCoordinador(coordinador_in);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getCoordinadorById: método que obtiene un coordinador específico de la BD con su id;
     *
     * @param id_coordinador - id del coordinador;
     * @return - el coordinador buscado;
     *
    --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/coordinador/{id_coordinador}")
    public List<Coordinador> getCoordinadorById(@PathVariable Integer id_coordinador) {
        return coordinadorRepository.getCoordinadorById(id_coordinador);
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todos los coordinadores de la BD;
     *
     * @return - una lista con los coordinadores presentes en la BD;
     *
    --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/coordinador")
    public List<Coordinador> getAllCoordinadores() {
        return coordinadorRepository.findAllCoordinadores();
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateCoordinador: método que actualiza los datos de un coordinador en la BD;
     *
     * @param coordinadorUpdate - el objeto con el id del coordinador y los nuevos datos;
     * @return - los datos del coordinador actualizados;
     *
    --------------------------------------------------------------------------------------------------------*/
    @PutMapping("/coordinador/update/{id_coordinador}")
    @ResponseBody
    public String updateCoordinador(@RequestBody Coordinador coordinador, @PathVariable Integer id_coordinador) {
        return coordinadorRepository.updateCoordinador(coordinador, id_coordinador);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdCoordinador: método que borra un coordinador de la BD;
     *
     * @param id_coordinador - id del coordinador a eliminar;
     *
    --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/coordinador/{id_coordinador}")
    public void borrar(@PathVariable Integer id_coordinador) {
        coordinadorRepository.deleteByIdCoordinador(id_coordinador);
    }

    //Login
    @GetMapping("/coordinador/login/{email_coordinador}/{password_coordinador}")
    public List<Coordinador> login(@PathVariable String email_coordinador, @PathVariable String password_coordinador){
        return coordinadorRepository.login(email_coordinador, password_coordinador);
    }
}

