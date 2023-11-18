package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Institucion;
import java.util.List;
public interface InstitucionRepository {

    /* metodos abstractos declarados*/
    public Institucion createInstitucion(Institucion institucion);
    public List<Institucion> getInstitucionById(Integer id);
    public List<Institucion> findAllInstituciones();
    public String updateInstitucion(Institucion institucionUpdate, Integer id);
    public void deleteInstitucionById(Integer id);
}
