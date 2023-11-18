package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Voluntario;
import com.chileayuda.voluntariadobackend.Repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService{

    private final com.chileayuda.voluntariadobackend.Repositories.VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    /* Servicios disponibles */


    /*--------------------------------------------------------------------------------------------------------
     * createVol: metodo que guarda un voluntario en la BD;
     *
     * @param vol_in - un objeto que contiene los datos del voluntario;
     * * @return - el voluntario creado y guardado en la base de datos;
     *
      -------------------------------------------------------*/
    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario create(@RequestBody Voluntario voluntario) {
        return voluntarioRepository.createVol(voluntario);
    }
    /*--------------------------------------------------------------------------------------------------------
     * getVolById: metodod que obtiene un voluntario especifico de la BD con su id;
     *
     * @param id_inst - id del voluntario;
     * @return - el voluntario buscado;
     *
     -----------------------------------------------*/
    @GetMapping("/voluntario/{id_voluntario}")
    public List<Voluntario> getvoluntario(@PathVariable Integer id_voluntario) {
        return voluntarioRepository.getVolById(id_voluntario);
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAll: metodo que obtiene todos los voluntarios de la BD;
     *
     * @return - una lista con los voluntarios presentes en la BD;
     *
     --------------------------------------------------------------*/
    @GetMapping("/voluntario")
    public List<Voluntario> getAllvoluntarios() {
        return voluntarioRepository.findAllVoluntarios();
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateVol: metodo que actualiza los datos de un voluntario en la BD;
     *
     * @param instUpdate - el objeto con el id del voluntario y los nuevos datos;
     * @return - los datos del voluntario actualizados;
     *
     ------------------------------------------------------------------*/
    @PutMapping("/voluntario/update/{id_voluntario}")
    @ResponseBody
    public String updatevoluntario(@RequestBody Voluntario voluntario, @PathVariable Integer id_voluntario) {
        return voluntarioRepository.updateVol(voluntario, id_voluntario);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdVol: metodo que borra un voluntario de la BD;
     *
     * @param id - id del voluntario a eliminar;
     *
     --------------------------------------------*/

    @DeleteMapping("/voluntario/{id_voluntario}")
    public void borrar(@PathVariable Integer id_voluntario) {
        voluntarioRepository.deleteByIdVol(id_voluntario);
    }

}
