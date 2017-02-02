package com.cg.dao;

import java.util.List;

import com.cg.models.Movie;

public interface IMovieDAO {
	int add(Movie movie);
	Movie search(int id);
	void update(Movie m);
	List<Movie> getAllMoviesUnder(double price);
}
