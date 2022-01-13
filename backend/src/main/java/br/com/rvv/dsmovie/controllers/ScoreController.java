package br.com.rvv.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvv.dsmovie.dto.MovieDto;
import br.com.rvv.dsmovie.dto.ScoreDto;
import br.com.rvv.dsmovie.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDto saveScore(@RequestBody ScoreDto score) {
		
		return scoreService.saveScore(score);
	}
	
}
