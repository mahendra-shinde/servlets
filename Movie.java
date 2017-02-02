package com.cg.models;

import java.io.Serializable;

public class Movie implements Serializable {
	private int movieId;
	private String title;
	private double price;
	private String producerEmailId;

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducerEmailId() {
		return producerEmailId;
	}
	public void setProducerEmailId(String producerEmailId) {
		this.producerEmailId = producerEmailId;
	}
	
}
