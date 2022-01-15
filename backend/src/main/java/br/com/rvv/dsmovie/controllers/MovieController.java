package br.com.rvv.dsmovie.controllers;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvv.dsmovie.dto.MovieDto;
import br.com.rvv.dsmovie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public Page<MovieDto> findAll(Pageable pageable) {
		return movieService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public MovieDto findById(@PathVariable Long id) {
		return movieService.findById(id);

	}
}
