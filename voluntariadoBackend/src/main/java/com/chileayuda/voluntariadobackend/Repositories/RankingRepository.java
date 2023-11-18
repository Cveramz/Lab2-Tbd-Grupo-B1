package com.chileayuda.voluntariadobackend.Repositories;

import com.chileayuda.voluntariadobackend.Models.Ranking;
import java.util.List;
public interface RankingRepository {

    /* metodos abstractos declarados*/
    public Ranking createRanking(Ranking ranking);
    public List<Ranking> getRankingById(Integer id);
    public List<Ranking> findAllRankings();
    public String updateRanking(Ranking rankingUpdate, Integer id);
    public void deleteRankingById( Integer id);

}
