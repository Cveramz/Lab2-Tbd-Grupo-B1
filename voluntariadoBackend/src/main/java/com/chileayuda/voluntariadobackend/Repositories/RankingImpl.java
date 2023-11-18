package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class RankingImpl implements RankingRepository {

    /* Métodos de la capa de repositorio de Emergencia */
    @Autowired
    private Sql2o sql2o;

    /* API endpoints - operaciones CRUD */

    /*--------------------------------------------------------------------------------------------------------
     * createRanking: método que guarda un ranking en la BD;
     *
     * @param ranking - un objeto que contiene los datos del ranking;
     * @return - el ranking creado y guardado en la base de datos;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public Ranking createRanking (Ranking ranking) {
        try (Connection connection = sql2o.open()) {
            String sql = "INSERT TO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito)"+
                    "VALUES (:id_ranking, :id_voluntario, :id_tarea, :puntos_requisito)";
            connection.createQuery(sql, true)
                    .addParameter("id_ranking", ranking.getId_ranking())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("puntos_requisito", ranking.getPuntos_requisito())
                    .executeUpdate();
            return ranking;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * getRankingById: método que obtiene un ranking específico de la BD con su id;
     *
     * @param id - id del ranking;
     * @return - el ranking buscado;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Ranking> getRankingById(Integer id_ranking){
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM Ranking WHERE id_ranking = :id_ranking")
                    .addParameter("id_ranking", id_ranking)
                    .executeAndFetch(Ranking.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAllRankings: método que obtiene todos los rankings de la BD;
     *
     * @return - una lista con los rankings presentes en la BD;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Ranking> findAllRankings(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM Ranking ORDER BY id_ranking ASC")
                    .executeAndFetch(Ranking.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }


    }

    /*--------------------------------------------------------------------------------------------------------
     * updateRanking: método que actualiza los datos de un ranking en la BD;
     *
     * @param rankingUpdate - el objeto con el id del ranking y los nuevos datos;
     * @return - los datos del ranking actualizados;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public String updateRanking(Ranking rankingUpdate, Integer id_ranking) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE Ranking " +
                            "SET id_voluntario =:id_voluntario, id_tarea =:id_tarea, puntos_requisito =:puntos_requisito" +
                            "WHERE id_ranking =:id_ranking")
                    .addParameter("id_ranking", id_ranking)
                    .addParameter("id_voluntario", rankingUpdate.getId_voluntario())
                    .addParameter("id_tarea", rankingUpdate.getId_tarea())
                    .addParameter("puntos_requisito", rankingUpdate.getPuntos_requisito())
                    .executeUpdate();
            return "Actualizado";
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteRankingById: método que borra un ranking de la BD;
     *
     * @param id - id del ranking a eliminar;
     *
     --------------------------------------------------------------------------------------------------------*/
    @Override
    public void deleteRankingById(Integer idRanking) {
        try(Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM Ranking WHERE id_ranking =:id_ranking")
                    .addParameter("id_ranking", idRanking)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

