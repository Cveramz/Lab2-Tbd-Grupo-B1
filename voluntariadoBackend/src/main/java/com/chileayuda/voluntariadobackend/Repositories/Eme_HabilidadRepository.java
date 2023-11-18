package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Eme_habilidad;

import java.util.List;

public interface Eme_HabilidadRepository {
    /* metodos abstractos declarados*/

    public Eme_habilidad createEme_habilidad(Eme_habilidad eme_habilidad);
    public List<Eme_habilidad> getEme_habilidadById(Integer id);
    public List<Eme_habilidad> findAllEme_habilidad();
    public Eme_habilidad updateEme_habilidad(Eme_habilidad eme_habilidadUpdate, Integer id_eme_habilidad);
    public void deleteByIdEme_habilidad(Integer id);
}
