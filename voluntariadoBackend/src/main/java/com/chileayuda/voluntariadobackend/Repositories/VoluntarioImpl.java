package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class VoluntarioImpl implements VoluntarioRepository {

    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createVol: metodo que guarda un voluntario en la BD;
     *
     * @param vol_in - un objeto que contiene los datos del voluntario;
     * * @return - el voluntario creado y guardado en la base de datos;
     *
      --------------------------------------------------------------------------------------------------------*/
    @Override
    public Voluntario createVol(Voluntario voluntario) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO voluntario (id_voluntario,nombre_voluntario,edad,equipamiento,estado_salud,disponibilidad,email_voluntario,password_voluntario)" +
                    "VALUES (:id_voluntario, :nombr_voluntario, :edad, :estado_salud, :disponibilidad, :email_voluntario, :password_voluntario)";
            connection.createQuery(sql, true)
                    .addParameter("id_Voluntario", voluntario.getId_voluntario())
                    .addParameter("nombre_voluntario", voluntario.getNombre_voluntario())
                    .addParameter("edad", voluntario.getEdad())
                    .addParameter("estado_salud", voluntario.getEstado_salud())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("email_voluntario", voluntario.getEmail_voluntario())
                    .addParameter("password_voluntario", voluntario.getPassword_voluntario())
                    .executeUpdate();
            return voluntario;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getVolById: metodod que obtiene un voluntario especifico de la BD con su id;
     *
     * @param id_inst - id del voluntario;
     * @return - el voluntario buscado;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Voluntario> getVolById(Integer id_voluntario) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Voluntario WHERE id_voluntario = :id_voluntario")
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: metodo que obtiene todos los voluntarios de la BD;
     *
     * @return - una lista con los voluntarios presentes en la BD;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Voluntario> findAllVoluntarios() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Voluntario ORDER BY id_voluntario ASC")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateVol: metodo que actualiza los datos de un voluntario en la BD;
     *
     * @param instUpdate - el objeto con el id del voluntario y los nuevos datos;
     * @return - los datos del voluntario actualizados;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public String updateVol(Voluntario voluntarioUpdate, Integer id_voluntario) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Voluntario " +
                            "SET nombre_voluntario =:nombre_voluntario, edad =:edad, estado_salud =:estado_salud, disponibilidad =:disponibilidad, email_voluntario =:email_voluntario, password_voluntario =:password_voluntario" +
                            "WHERE id_voluntario =:id_voluntario")
                    .addParameter("id_voluntario", id_voluntario)
                    .addParameter("nombre_voluntario", voluntarioUpdate.getNombre_voluntario())
                    .addParameter("edad", voluntarioUpdate.getEdad())
                    .addParameter("estado_salud", voluntarioUpdate.getEstado_salud())
                    .addParameter("disponibilidad", voluntarioUpdate.getDisponibilidad())
                    .addParameter("email_voluntario", voluntarioUpdate.getEmail_voluntario())
                    .addParameter("password_voluntario", voluntarioUpdate.getPassword_voluntario())
                    .executeUpdate();
            return "Actualizado";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }


    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdVol: metodo que borra un voluntario de la BD;
     *
     * @param id - id del voluntario a eliminar;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteByIdVol(Integer id_voluntario) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Voluntario WHERE id_voluntario =:id_voluntario")
                    .addParameter("id_voluntario", id_voluntario)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
