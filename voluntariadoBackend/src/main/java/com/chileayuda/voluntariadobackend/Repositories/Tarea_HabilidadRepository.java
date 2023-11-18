package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Tarea_habilidad;
import java.util.List;
public interface Tarea_HabilidadRepository {
    /* metodos abstractos declarados*/

    public Tarea_habilidad createTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public List<Tarea_habilidad> getTarea_habilidadById(Integer id);
    public List<Tarea_habilidad> findAllTarea_habilidad();
    public Tarea_habilidad updateTarea_habilidad(Tarea_habilidad tarea_habilidadUpdate, Integer id);
    public void deleteByIdTarea_habilidad(Integer id);
}
