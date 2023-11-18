package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class InstitucionImpl implements InstitucionRepository {

    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;


    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createInstitucion: método que guarda una institución en la BD;
     *
     * @param institucion - un objeto que contiene los datos de la institución;
     * @return - la institución creada y guardada en la base de datos;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public Institucion createInstitucion (Institucion institucion) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO institucion (id_institucion,id_coordinador, nombre_institucion,telefono,ubicacion_institucion)"+
                    "VALUES (:id_institucion, :id_coordinador,:nombre_institucion, :telefono, :ubicacion_institucion)";
            connection.createQuery(sql, true)
                    .addParameter("id_institucion", institucion.getId_institucion())
                    .addParameter("id_coordinador", institucion.getId_coordinador())
                    .addParameter("nombre_institucion", institucion.getNombre_institucion())
                    .addParameter("telefono", institucion.getTelefono())
                    .addParameter("ubicacion_institucion", institucion.getUbicacion_institucion())
                    .executeUpdate();
            return institucion;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getInstitucionById: método que obtiene una institución específica de la BD con su id;
     *
     * @param id - id de la institución;
     * @return - la institución buscada;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Institucion> getInstitucionById(Integer id_institucion){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Institucion WHERE id_institucion = :id_institucion")
                    .addParameter("id_institucion", id_institucion)
                    .executeAndFetch(Institucion.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAllInstituciones: método que obtiene todas las instituciones de la BD;
     *
     * @return - una lista con las instituciones presentes en la BD;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Institucion> findAllInstituciones(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Institucion ORDER BY id_institucion ASC")
                    .executeAndFetch(Institucion.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateInstitucion: método que actualiza los datos de una institución en la BD;
     *
     * @param institucionUpdate - el objeto con el id de la institución y los nuevos datos;
     * @return - los datos de la institución actualizados;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public String updateInstitucion(Institucion institucionUpdate, Integer id_institucion) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Institucion " +
                            "SET id_coordinador =:id_coordinador, nombre_institucion =:nombre_institucion, telefono =:telefono, ubicacion_institucion =:ubicacionInstitucion" +
                            "WHERE id_institucion =:id_institucion")
                    .addParameter("id_institucion", id_institucion)
                    .addParameter("id_coordinador", institucionUpdate.getId_coordinador())
                    .addParameter("nombre_institucion", institucionUpdate.getNombre_institucion())
                    .addParameter("telefono", institucionUpdate.getTelefono())
                    .addParameter("ubicacion_institucion", institucionUpdate.getUbicacion_institucion())
                    .executeUpdate();
            return "acutalizado";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteInstitucionById: método que borra una institución de la BD;
     *
     * @param id - id de la institución a eliminar;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteInstitucionById (Integer id_institucion) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Institucion WHERE id_institucion =:id_institucion")
                    .addParameter("id_institucion", id_institucion)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

