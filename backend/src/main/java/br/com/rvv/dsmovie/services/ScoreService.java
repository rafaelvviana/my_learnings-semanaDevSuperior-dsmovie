package br.com.rvv.dsmovie.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rvv.dsmovie.dto.MovieDto;
import br.com.rvv.dsmovie.dto.ScoreDto;
import br.com.rvv.dsmovie.entities.Movie;
import br.com.rvv.dsmovie.entities.Score;
import br.com.rvv.dsmovie.entities.User;
import br.com.rvv.dsmovie.repositories.MovieRepository;
import br.com.rvv.dsmovie.repositories.ScoreRepository;
import br.com.rvv.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public MovieDto saveScore(ScoreDto scoreDto) {
		
		User user = userRepository.findByEmail(scoreDto.getEmail());
		if(user == null) {
			user = new User(scoreDto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s: movie.getScores()) {
			sum += s.getValue();
		}
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDto(movie);
	}
	
}
