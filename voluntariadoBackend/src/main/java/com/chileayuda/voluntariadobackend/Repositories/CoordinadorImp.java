package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Coordinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class CoordinadorImp implements CoordinadorRepository {

    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createCoordinador: método que guarda un coordinador en la BD;
     *
     * @param coordinador_in - un objeto que contiene los datos del coordinador;
     * * @return - el coordinador creado y guardado en la base de datos;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public Coordinador createCoordinador (Coordinador coordinador) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT INTO coordinador (id_coordinador, nombre_coordinador, email_coordinador, password_coordinador) " +
                    "VALUES (:id_coordinador, :nombre_coordinador, :email_coordinador, :password_coordinador)";
            connection.createQuery(sql, true)
                    .addParameter("id_coordinador", coordinador.getId_coordinador())
                    .addParameter("nombre_coordinador", coordinador.getNombre_coordinador())
                    .addParameter("email_coordinador", coordinador.getEmail_coordinador())
                    .addParameter("password_coordinador", coordinador.getPassword_coordinador())
                    .executeUpdate();
            return coordinador;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getCoordinadorById: método que obtiene un coordinador específico de la BD con su id;
     *
     * @param id - id del coordinador;
     * @return - el coordinador buscado;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Coordinador> getCoordinadorById(Integer id_coordinador){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Coordinador WHERE id_coordinador = :id_coordinador")
                    .addParameter("id_coordinador", id_coordinador)
                    .executeAndFetch(Coordinador.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: método que obtiene todos los coordinadores de la BD;
     *
     * @return - una lista con los coordinadores presentes en la BD;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Coordinador> findAllCoordinadores(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Coordinador ORDER BY id_coordinador ASC")
                    .executeAndFetch(Coordinador.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateCoordinador: método que actualiza los datos de un coordinador en la BD;
     *
     * @param coordinadorUpdate - el objeto con el id del coordinador y los nuevos datos;
     * @return - los datos del coordinador actualizados;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public String updateCoordinador(Coordinador coordinadorUpdate, Integer id_coordinador) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Coordinador " +
                            "SET nombre_coordinador =:nombre_coordinador, email_coordinador =:email_coordinador, password_coordinador =:password_coordinador" +
                            "WHERE id_coordinador =:id_coordinador")
                    .addParameter("id_coordinador", id_coordinador)
                    .addParameter("nombre_coordinador", coordinadorUpdate.getNombre_coordinador())
                    .addParameter("email_coordinador", coordinadorUpdate.getEmail_coordinador())
                    .addParameter("password_coordinador", coordinadorUpdate.getPassword_coordinador())
                    .executeUpdate();
            return "Coordinador actualizado";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdCoordinador: método que borra un coordinador de la BD;
     *
     * @param id - id del coordinador a eliminar;
     *
    --------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdCoordinador(Integer id_coordinador) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Coordinador WHERE id_coordinador =:id_coordinador")
                    .addParameter("id_coordinador", id_coordinador)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Coordinador> login(String email_coordinador, String password_coordinador){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM coordinador WHERE email_coordinador =:email_coordinador AND password_coordinador =:password_coordinador")
                    .addParameter("email_coordinador", email_coordinador)
                    .addParameter("password_coordinador", password_coordinador)
                    .executeAndFetch(Coordinador.class);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }

    }
}

