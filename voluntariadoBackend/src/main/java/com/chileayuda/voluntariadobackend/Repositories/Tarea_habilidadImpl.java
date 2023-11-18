package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Tarea_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository

public class Tarea_habilidadImpl implements Tarea_HabilidadRepository {
    /* Métodos de la capa de repositorio de Tarea Habilidad*/
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createTarea_habilidad: método que guarda una tarea habilidad en la BD;
     *
     * @param tarea_habilidad - un objeto que contiene los datos de la tarea habilidad;
     * * @return - la tarea habilidad creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Tarea_habilidad createTarea_habilidad (Tarea_habilidad tarea_habilidad) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO tarea_habilidad (id_tarea_habilidad,id_tarea, id_habilidad)" +
                    "VALUES (:id_tarea_habilidad, :id_tarea, :id_habilidad)";
            connection.createQuery(sql, true)
                    .addParameter("id_tarea_habilidad", tarea_habilidad.getId_tarea_habilidad())
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .addParameter("id_habilidad", tarea_habilidad.getId_habilidad())
                    .executeUpdate();
            return tarea_habilidad;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getTarea_habilidadById: método que obtiene una tarea habilidad específica de la BD con su id;
     *
     * @param id - id de la tarea habilidad;
     * @return - la tarea habilidad buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Tarea_habilidad> getTarea_habilidadById(Integer id_tarea_habilidad){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad")
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
                    .executeAndFetch(Tarea_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAllTarea_habilidad: método que obtiene todas las tarea habilidades de la BD;
     *
     * @return - una lista con las tareas habilidades presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Tarea_habilidad> findAllTarea_habilidad(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Tarea_habilidad ORDER BY id_tarea_habilidad ASC")
                    .executeAndFetch(Tarea_habilidad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateTarea_habilidad: método que actualiza los datos de una Tarea habilidad en la BD;
     *
     * @param tarea_habilidadUpdate - el objeto con el id de la tarea habilidad y los nuevos datos;
     * @return - los datos de la tarea habilidad actualizados;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public Tarea_habilidad updateTarea_habilidad(Tarea_habilidad tarea_habilidadUpdate, Integer id_tarea_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Tarea_habilidad " +
                            "SET id_tarea =:id_tarea, id_habilidad =:id_habilidad" +
                            "WHERE id_tarea_habilidad =:id_tarea_habilidad")
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
                    .addParameter("id_tarea", tarea_habilidadUpdate.getId_tarea())
                    .addParameter("id_habilidad", tarea_habilidadUpdate.getId_habilidad())
                    .executeUpdate();
            return tarea_habilidadUpdate;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdTarea_habilidad: método que borra una tarea habilidad de la BD;
     *
     * @param id - id de la tarea habilidad a eliminar;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdTarea_habilidad(Integer id_tarea_habilidad) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Tarea_habilidad WHERE id_tarea_habilidad =:id_tarea_habilidad")
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
