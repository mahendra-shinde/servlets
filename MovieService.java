package com.cg.service;

import com.cg.dao.IMovieDAO;
import com.cg.dao.MovieDAO;
import com.cg.exception.MovieException;
import com.cg.models.Movie;

public class MovieService implements IMovieService {

	private IMovieDAO dao = null;
	
	public MovieService() {
		dao = new MovieDAO();
	}
	
	@Override
	public int add(Movie movie)throws MovieException {
		return dao.add(movie);
	}

}
