package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Estado_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Estado_TareaImpl implements Estado_TareaRepository{
    /* Métodos de la capa de repositorio de Estado_Tarea */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createEstado_tarea: método que guarda una emergencia en la BD;
     *
     * @param estado_tarea - un objeto que contiene los datos del estado de la tarea;
     * * @return - el estado tarea creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Estado_Tarea createEstado_tarea(Estado_Tarea estado_tarea) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO estado_tarea (id_estado_tarea, estado)" +
                    "VALUES (:id_estado_tarea, :estado)";
            connection.createQuery(sql, true)
                    .addParameter("id_estado_tarea", estado_tarea.getId_estado_tarea())
                    .addParameter("estado", estado_tarea.getEstado())
                    .executeUpdate();
            return estado_tarea;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getEstado_tareaById: método que obtiene un estado tarea específico de la BD con su id;
     *
     * @param id - id del estado de la tarea;
     * @return - la estado tarea buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Estado_Tarea> getEstado_tareaById(Integer id_estado_tarea){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Estado_Tarea WHERE id_estado_tarea = :id_estado_tarea")
                    .addParameter("id_estado_tarea", id_estado_tarea)
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAllEstado_tarea: método que obtiene todos los estados de tarea de la BD;
     *
     * @return - una lista con los estados de tarea presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Estado_Tarea> findAllEstado_tarea(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Estado_tarea ORDER BY id_estado_tarea ASC")
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateEstado_tarea: método que actualiza los datos de un estado tarea en la BD;
     *
     * @param estado_tareaUpdate - el objeto con el id del estado de la tarea y los nuevos datos;
     * @return - los datos del estado de la tarea actualizados;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public Estado_Tarea updateEstado_tarea(Estado_Tarea estado_tareaUpdate, Integer id_estado_tarea) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Estado_tarea " +
                            "SET estado =:estado" +
                            "WHERE id_estado_tarea =:id_estado_tarea")
                    .addParameter("id_estado_tarea", id_estado_tarea)
                    .addParameter("estado", estado_tareaUpdate.getEstado())
                    .executeUpdate();
            return estado_tareaUpdate;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdEstado_Tarea: método que borra un estado tarea de la BD;
     *
     * @param id - id de estado de la tarea a eliminar;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdEstado_tarea(Integer id_estado_tarea) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Estado_Tarea WHERE id_estado_tarea =:id_estado_tarea")
                    .addParameter("id_estado_tarea", id_estado_tarea)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
