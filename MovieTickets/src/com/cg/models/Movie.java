package com.cg.models;

public class Movie {
	private Integer movieId;
	private String title;
	private Integer year;
	private Integer availableTickets;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(Integer availableTickets) {
		this.availableTickets = availableTickets;
	}
	public Movie(Integer movieId, String title, Integer year, Integer availableTickets) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.year = year;
		this.availableTickets = availableTickets;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
