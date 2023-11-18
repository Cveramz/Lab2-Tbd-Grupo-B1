package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Emergencia;
import com.chileayuda.voluntariadobackend.Models.Estado_Tarea;
import com.chileayuda.voluntariadobackend.Services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Info_Emergencia implements Info_EmergenciaRepository {

    private final Sql2o sql2o;

    @Autowired
    public Info_Emergencia(DatabaseContext databaseContext) {
        this.sql2o = databaseContext.sql2o();
    }


    public List<Emergencia> obtenerDetallesEmergencia() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Emergencia").executeAndFetch(Emergencia.class);
        }
    }


    public String obtenerEstadoActualEmergencia(Integer idEmergencia) {
        try (Connection con = sql2o.open()) {
            int totalTareas = con.createQuery("SELECT COUNT(*) FROM Tarea WHERE id_emergencia = :idEmergencia")
                    .addParameter("idEmergencia", idEmergencia)
                    .executeScalar(Integer.class);

            int id = 0;
            int tareasCompletadas = con.createQuery("SELECT COUNT(*) FROM Tarea WHERE id_emergencia = :idEmergencia " +
                            "AND id_estado_tarea = :idEstadoCompletado")
                    .addParameter("idEmergencia", idEmergencia)
                    .addParameter("idEstadoCompletado", id)
                    .executeScalar(Integer.class);

            if (tareasCompletadas == totalTareas) {
                return "completado";
            } else {
                return "en proceso";
            }
        }
    }


    public int obtenerNumeroVoluntariosPorEmergencia(Integer idEmergencia) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT COUNT(*) FROM Voluntario v " +
                            "JOIN Ranking r ON v.id_voluntario = r.id_voluntario " +
                            "JOIN Tarea t ON r.id_tarea = t.id_tarea " +
                            "WHERE t.id_emergencia = :idEmergencia")
                    .addParameter("idEmergencia", idEmergencia)
                    .executeScalar(Integer.class);
        }
    }


    public List<Emergencia> obtenerEmergenciasCompletadas() {
        try (Connection con = sql2o.open()) {
            List<Emergencia> emergenciasCompletadas = new ArrayList<>();

            // Obtener todas las emergencias desde la base de datos
            List<Emergencia> todasLasEmergencias = con.createQuery("SELECT * FROM Emergencia")
                    .executeAndFetch(Emergencia.class);

            for (Emergencia emergencia : todasLasEmergencias) {
                int totalTareas = con.createQuery("SELECT COUNT(*) FROM Tarea WHERE id_emergencia = :idEmergencia")
                        .addParameter("idEmergencia", emergencia.getIdEmergencia())
                        .executeScalar(Integer.class);

                int tareasCompletadas = con.createQuery("SELECT COUNT(*) FROM Tarea WHERE id_emergencia = :idEmergencia " +
                                "AND id_estado_tarea = :idEstadoCompletado")
                        .addParameter("idEmergencia", emergencia.getIdEmergencia())
                        .addParameter("idEstadoCompletado", 1)
                        .executeScalar(Integer.class);

                if (tareasCompletadas == totalTareas) {
                    emergenciasCompletadas.add(emergencia);
                }
            }

            return emergenciasCompletadas;
        }
    }






}

