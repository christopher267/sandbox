package com.charles.sandbox.web.dataobject.v1;

import java.io.Serializable;

public class MovieVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String genre;
	private String npaaRating;
	private String year;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNpaaRating() {
		return npaaRating;
	}
	public void setNpaaRating(String npaaRating) {
		this.npaaRating = npaaRating;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
