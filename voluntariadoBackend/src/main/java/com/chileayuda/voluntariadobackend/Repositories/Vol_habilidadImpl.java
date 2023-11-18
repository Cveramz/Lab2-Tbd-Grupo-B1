package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Vol_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class Vol_habilidadImpl implements Vol_HabilidadRepository{
    /* Métodos de la capa de repositorio de Vol_Habilidad */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createVol_habilidad: método que guarda una vol_habilidad en la BD;
     *
     * @param vol_habilidad - un objeto que contiene los datos de la vol_habilidad;
     * * @return - la vol_habilidad creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Vol_habilidad createVol_habilidad (Vol_habilidad vol_habilidad) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO vol_habilidad (id_vol_habilidad,id_voluntario, id_habilidad)" +
                    "VALUES (:id_vol_habilidad, :id_voluntario, :id_habilidad)";
            connection.createQuery(sql, true)
                    .addParameter("id_vol_habilidad", vol_habilidad.getId_vol_habilidad())
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .executeUpdate();
            return vol_habilidad;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getVol_habilidadById: método que obtiene una vol_hbailidad específica de la BD con su id;
     *
     * @param id - id de la vol_habilidad;
     * @return - la vol_habilidad buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Vol_habilidad> getVol_habilidadById(Integer id_vol_habilidad){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Vol_habilidad WHERE id_vol_habilidad = :id_vol_habilidad")
                    .addParameter("id_vol_habilidad", id_vol_habilidad)
                    .executeAndFetch(Vol_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAllVol_habilidad: método que obtiene todas las vol_habilidades de la BD;
     *
     * @return - una lista con las vol_habilidades presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Vol_habilidad> findAllVol_habilidad(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Vol_habilidad ORDER BY id_vol_habilidad ASC")
                    .executeAndFetch(Vol_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateVol_habilidad: método que actualiza los datos de una vol_habilidad en la BD;
     *
     * @param vol_habilidadUpdate - el objeto con el id de la vol_habilidad y los nuevos datos;
     * @return - los datos de la vol_habilidad actualizados;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public Vol_habilidad updateVol_habilidad(Vol_habilidad vol_habilidadUpdate, Integer id_vol_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Vol_habilidad " +
                            "SET id_voluntario =:id_voluntario, id_habilidad =:id_habilidad" +
                            "WHERE id_vol_habilidad =:id_vol_habilidad")
                    .addParameter("id_vol_habilidad", id_vol_habilidad)
                    .addParameter("id_voluntario", vol_habilidadUpdate.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidadUpdate.getId_habilidad())
                    .executeUpdate();
            return vol_habilidadUpdate;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdVol_habilidad: método que borra una vol_habilidad de la BD;
     *
     * @param id - id de la vol_habilidad a eliminar;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdVol_habilidad(Integer id_vol_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Vol_habilidad WHERE id_vol_habilidad =:id_vol_habilidad")
                    .addParameter("id_vol_habilidad", id_vol_habilidad)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
