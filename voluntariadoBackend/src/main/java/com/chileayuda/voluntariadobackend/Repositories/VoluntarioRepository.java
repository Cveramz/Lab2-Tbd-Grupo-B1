package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import com.chileayuda.voluntariadobackend.Models.Voluntario;
import java.util.List;
import java.util.Map;

public interface VoluntarioRepository {

    /* metodos abstractos declarados*/
    public Voluntario createVol(Voluntario vol_in);
    public List<Voluntario> getVolById(Integer id);
    public List<Voluntario> findAllVoluntarios();
    public String updateVol(Voluntario volUpdate, Integer id);
    public void deleteByIdVol(Integer id);

    List<Map<String, Object>> getVoluntariosCercanos(Integer N, Integer id_emergencia);


}
