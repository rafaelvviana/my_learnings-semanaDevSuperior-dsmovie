package br.com.rvv.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rvv.dsmovie.dto.MovieDto;
import br.com.rvv.dsmovie.entities.Movie;
import br.com.rvv.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDto> findAll(Pageable pageable){		
		Page<Movie> lista = movieRepository.findAll(pageable);
		Page<MovieDto> page = lista.map((movie) -> new MovieDto(movie));
		return page;
	};
	
	@Transactional(readOnly = true)
	public MovieDto findById(Long id){		
		Movie movie = movieRepository.findById(id).get();
		MovieDto movieDto = new MovieDto(movie);
		return movieDto;
	};
	
	
}
