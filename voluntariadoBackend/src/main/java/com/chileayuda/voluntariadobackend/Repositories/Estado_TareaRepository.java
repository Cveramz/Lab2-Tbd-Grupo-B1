package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Estado_Tarea;
import java.util.List;

public interface Estado_TareaRepository {
    /* metodos abstractos declarados*/

    public Estado_Tarea createEstado_tarea(Estado_Tarea estado_tarea);
    public List<Estado_Tarea> getEstado_tareaById(Integer id);
    public List<Estado_Tarea> findAllEstado_tarea();
    public Estado_Tarea updateEstado_tarea(Estado_Tarea estado_tareaUpdate, Integer id);
    public void deleteByIdEstado_tarea(Integer id);

}
