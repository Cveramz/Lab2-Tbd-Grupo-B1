package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class EmergenciaImpl implements EmergenciaRepository {

    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createEmergencia: método que guarda una emergencia en la BD;
     *
     * @param emergencia_in - un objeto que contiene los datos de la emergencia;
     * * @return - la emergencia creada y guardada en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Emergencia createEmergencia (Emergencia emergencia_in) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT INTO emergencia (id_emergencia,id_institucion, tipo,ubicacion,equipamiento_necesario, titulo, descripcion)" +
                    "VALUES (:id_emergencia, :id_institucion, :tipo, :ubicacion, :equipamiento_necesario, :titulo, :descripcion)";
            connection.createQuery(sql, true)
                    .addParameter("id_emergencia", emergencia_in.getIdEmergencia())
                    .addParameter("id_institucion", emergencia_in.getIdInstitucion())
                    .addParameter("tipo", emergencia_in.getTipo())
                    .addParameter("ubicacion", emergencia_in.getUbicacion())
                    .addParameter("equipamiento_necesario", emergencia_in.getEquipamiento_necesario())
                    .addParameter("titulo", emergencia_in.getTitulo())
                    .addParameter("descripcion", emergencia_in.getDescripcion())
                    .executeUpdate();
            return emergencia_in;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getEmergenciaById: método que obtiene una emergencia específica de la BD con su id;
     *
     * @param id - id de la emergencia;
     * @return - la emergencia buscada;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Emergencia> getEmergenciaById(Integer id_emergencia){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Emergencia WHERE id_emergencia = :id_emergencia")
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todas las emergencias de la BD;
     *
     * @return - una lista con las emergencias presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Emergencia> findAllEmergency(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Emergencia ORDER BY id_emergencia ASC")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }

    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todas las emergencias de la BD;
     *
     * @return - una lista con las emergencias presentes en la BD;
     *
    -------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Emergencia> findAllCompletedEmergency() {
        try (Connection connection = sql2o.open()) {
            String sql = "SELECT e.* " +
                    "FROM Emergencia e " +
                    "WHERE e.id_emergencia NOT IN ( " +
                    "  SELECT t.id_emergencia " +
                    "  FROM tarea t " +
                    "  LEFT JOIN estado_tarea et ON t.id_estado_tarea = et.id_estado_tarea " +
                    "  WHERE et.estado <> 'Completa' " +
                    ")";

            return connection.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }





    /*--------------------------------------------------------------------------------------------------------
     * updateEmergencia: método que actualiza los datos de una emergencia en la BD;
     *
     * @param emergenciaUpdate - el objeto con el id de la emergencia y los nuevos datos;
     * @return - los datos de la emergencia actualizados;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public String updateEmergencia(Emergencia emergenciaUpdate, Integer id_emergencia) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Emergencia " +
                            "SET id_institucion =:id_institucion, tipo =:tipo, ubicacion =:ubicacion, equipamiento_necesario =:equipamiento_necesario" +
                            "WHERE id_emergencia =:id_emergencia")
                    .addParameter("id_emergencia", id_emergencia)
                    .addParameter("id_institucion", emergenciaUpdate.getIdInstitucion())
                    .addParameter("tipo", emergenciaUpdate.getTipo())
                    .addParameter("emergencia", emergenciaUpdate.getUbicacion())
                    .addParameter("equipamiento_necesario", emergenciaUpdate.getEquipamiento_necesario())
                    .addParameter("titulo", emergenciaUpdate.getTitulo())
                    .addParameter("descripcion", emergenciaUpdate.getDescripcion())

                    .executeUpdate();
            return "Informacion actualizada";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdEmergencia: método que borra una emergencia de la BD;
     *
     * @param id - id de la emergencia a eliminar;
     *
    ------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdEmergencia(Integer id_emergencia) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Emergencia WHERE id_emergencia =:id_emergencia")
                    .addParameter("id_emergencia", id_emergencia)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

