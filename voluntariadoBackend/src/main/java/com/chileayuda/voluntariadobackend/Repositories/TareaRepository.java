package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Tarea;
import java.util.List;
public interface TareaRepository {

    /* metodos abstractos declarados*/
    public Tarea createTarea(Tarea tarea_in);
    public List<Tarea> getTareaById(Integer id);
    public List<Tarea> findAllTareas();
    public String updateTarea(Tarea tareaUpdate, Integer id);
    public void deleteByIdTarea(Integer id);

}
