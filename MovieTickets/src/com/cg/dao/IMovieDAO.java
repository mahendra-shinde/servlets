package com.cg.dao;

import java.util.List;

import com.cg.models.Movie;

public interface IMovieDAO {
	List<Movie> findAll();
	Movie findByTitle(String title);
	Movie findById(Integer id);
	void update(Movie m);
}
