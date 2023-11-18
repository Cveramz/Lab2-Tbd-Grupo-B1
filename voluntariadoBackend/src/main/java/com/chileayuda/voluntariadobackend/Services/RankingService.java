package com.chileayuda.voluntariadobackend.Services;

import com.chileayuda.voluntariadobackend.Models.Ranking;
import com.chileayuda.voluntariadobackend.Repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
    private final com.chileayuda.voluntariadobackend.Repositories.RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    /* Servicios disponibles */


    /*--------------------------------------------------------------------------------------------------------
     * createRanking: método que guarda un ranking en la BD;
     *
     * @param ranking - un objeto que contiene los datos del ranking;
     * @return - el ranking creado y guardado en la base de datos;
     *
     ---------------------------------------------------------------------------------------------*/
    @PostMapping("/ranking")
    @ResponseBody
    public Ranking create(@RequestBody Ranking ranking) {
        return rankingRepository.createRanking(ranking);
    }
    /*--------------------------------------------------------------------------------------------------------
     * getRankingById: método que obtiene un ranking específico de la BD con su id;
     *
     * @param id - id del ranking;
     * @return - el ranking buscado;
     *
     --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/ranking/{id_ranking}")
    public List<Ranking> getrankings(@PathVariable Integer id_ranking) {
        return rankingRepository.getRankingById(id_ranking);
    }
    /*--------------------------------------------------------------------------------------------------------
     * findAllRankings: método que obtiene todos los rankings de la BD;
     *
     * @return - una lista con los rankings presentes en la BD;
     *
     --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/ranking")
    public List<Ranking> getAllrankings() {
        return rankingRepository.findAllRankings();
    }
    /*--------------------------------------------------------------------------------------------------------
     * updateRanking: método que actualiza los datos de un ranking en la BD;
     *
     * @param rankingUpdate - el objeto con el id del ranking y los nuevos datos;
     * @return - los datos del ranking actualizados;
     *
     --------------------------------------------------------------------------------------------------------*/
    @PutMapping("/ranking/update/{id_ranking}")
    @ResponseBody
    public String updateranking(@RequestBody Ranking ranking, @PathVariable Integer id_ranking) {
        return rankingRepository.updateRanking(ranking, id_ranking);
    }
    /*--------------------------------------------------------------------------------------------------------
     * deleteRankingById: método que borra un ranking de la BD;
     *
     * @param id - id del ranking a eliminar;
     *
     --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/ranking/{id_ranking}")
    public void borrar(@PathVariable Integer id_ranking) {
        rankingRepository.deleteRankingById(id_ranking);
    }
}

