package br.com.rvv.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rvv.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
