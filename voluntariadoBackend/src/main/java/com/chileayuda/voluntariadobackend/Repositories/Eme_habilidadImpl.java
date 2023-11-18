package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Eme_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Eme_habilidadImpl implements Eme_HabilidadRepository{
    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createEmergencia: método que guarda una emergencia habilidad en la BD;
     *
     * @param eme_habilidad - un objeto que contiene los datos de la emergencia habilidad;
     * * @return - la emergencia habilidad creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Eme_habilidad createEme_habilidad(Eme_habilidad eme_habilidad) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO eme_habilidad (id_eme_habilidad,id_emergencia, id_habilidad)" +
                    "VALUES (:id_eme_habilidad, :id_emergencia, id_habilidad)";
            connection.createQuery(sql, true)
                    .addParameter("id_eme_habilidad", eme_habilidad.getId_eme_habilidad())
                    .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", eme_habilidad.getId_habilidad())
                    .executeUpdate();
            return eme_habilidad;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getEme_habilidadById: método que obtiene una emergencia habilidad específica de la BD con su id;
     *
     * @param id - id de la emergencia habilidad;
     * @return - la emergencia buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Eme_habilidad> getEme_habilidadById(Integer id_eme_habilidad){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Eme_habilidad WHERE id_eme_habilidad = :id_eme_habilidad")
                    .addParameter("id_eme_habilidad", id_eme_habilidad)
                    .executeAndFetch(Eme_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAllEme_habilidad: método que obtiene todas las emergencias habilidades de la BD;
     *
     * @return - una lista con las emergencias habilidades presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Eme_habilidad> findAllEme_habilidad(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Eme_habilidad ORDER BY id_eme_habilidad ASC")
                    .executeAndFetch(Eme_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateEme_habilidad: método que actualiza los datos de una emergencia habilidad en la BD;
     *
     * @param eme_habilidadUpdate - el objeto con el id de la emergencia habilidad y los nuevos datos;
     * @return - los datos de la emergencia habilidad actualizados;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public Eme_habilidad updateEme_habilidad(Eme_habilidad eme_habilidadUpdate, Integer id_eme_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Eme_habilidad " +
                            "SET id_emergencia =:id_emergencia, id_habilidad =:id_habilidad" +
                            "WHERE id_eme_habilidad =:id_eme_habilidad")
                    .addParameter("id_eme_habilidad", id_eme_habilidad)
                    .addParameter("id_emergencia", eme_habilidadUpdate.getId_emergencia())
                    .addParameter("id_habilidad", eme_habilidadUpdate.getId_habilidad())
                    .executeUpdate();
            return eme_habilidadUpdate;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdEme_habilidad: método que borra una emergencia habilidadde la BD;
     *
     * @param id - id de la emergencia habilidad a eliminar;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdEme_habilidad(Integer id_eme_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Eme_habilidad WHERE id_eme_habilidad =:id_eme_habilidad")
                    .addParameter("id_eme_habilidad", id_eme_habilidad)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
