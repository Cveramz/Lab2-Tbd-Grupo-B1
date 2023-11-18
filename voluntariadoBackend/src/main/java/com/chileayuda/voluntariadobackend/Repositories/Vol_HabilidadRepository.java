package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Vol_habilidad;
import java.util.List;

public interface Vol_HabilidadRepository {
    /* metodos abstractos declarados*/

    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad);
    public List<Vol_habilidad> getVol_habilidadById(Integer id);
    public List<Vol_habilidad> findAllVol_habilidad();
    public Vol_habilidad updateVol_habilidad(Vol_habilidad vol_habilidadUpdate, Integer id);
    public void deleteByIdVol_habilidad(Integer id);
}
