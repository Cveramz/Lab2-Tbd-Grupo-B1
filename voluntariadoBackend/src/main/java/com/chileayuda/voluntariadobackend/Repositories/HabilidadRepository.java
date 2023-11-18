package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Habilidad;

import java.util.List;
public interface HabilidadRepository {

    /* metodos abstractos declarados*/
    public Habilidad createHabilidad(Habilidad habilidad);
    public List<Habilidad> getHabilidadById(Integer id);
    public List<Habilidad> findAllHabilidades();
    public String updateHabilidad(Habilidad habilidadUpdate, Integer id);
    public void deleteHabilidadById(Integer id);

}
