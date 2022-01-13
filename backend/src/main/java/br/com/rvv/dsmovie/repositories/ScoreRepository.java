package br.com.rvv.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rvv.dsmovie.entities.Score;
import br.com.rvv.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
