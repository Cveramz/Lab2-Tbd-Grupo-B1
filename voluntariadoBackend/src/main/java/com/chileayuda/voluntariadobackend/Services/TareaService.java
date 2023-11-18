package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Tarea;
import com.chileayuda.voluntariadobackend.Repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class TareaService {

    private final com.chileayuda.voluntariadobackend.Repositories.TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    /* Servicios disponibles */

    /*--------------------------------------------------------------------------------------------------------
     * createTarea: método que guarda una tarea en la BD;
     *
     * @param tarea_in - un objeto que contiene los datos de la tarea;
     * @return - la tarea creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------*/
    @PostMapping("/tarea")
    @ResponseBody
    public Tarea create(@RequestBody Tarea tarea) {
        return tareaRepository.createTarea(tarea);
    }
    /*--------------------------------------------------------------------------------------------------------
     * getTareaById: método que obtiene una tarea específica de la BD con su id;
     *
     * @param id_tarea - id de la tarea;
     * @return - la tarea buscada;
     *
    -------------------------------------------------------*/
    @GetMapping("/tarea/{id_tarea}")
    public List<Tarea> getTareas(@PathVariable Integer id_tarea) {
        return tareaRepository.getTareaById(id_tarea);
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todas las tareas de la BD;
     *
     * @return - una lista con las tareas presentes en la BD;
     *
    --------------------------------------------------*/
    @GetMapping("/tarea")
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAllTareas();
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateTarea: método que actualiza los datos de una tarea en la BD;
     *
     * @param tareaUpdate - el objeto con el id de la tarea y los nuevos datos;
     * @return - los datos de la tarea actualizados;
     *
    -------------------------------------------*/
    @PutMapping("/tarea/update/{id_tarea}")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable Integer id_tarea) {
        return tareaRepository.updateTarea(tarea, id_tarea);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdTarea: método que borra una tarea de la BD;
     *
     * @param id_tarea - id de la tarea a eliminar;
     *
    --------------------------------------------------------------*/
    @DeleteMapping("/tarea/{id_tarea}")
    public void borrar(@PathVariable Integer id_tarea) {
        tareaRepository.deleteByIdTarea(id_tarea);
    }
}

