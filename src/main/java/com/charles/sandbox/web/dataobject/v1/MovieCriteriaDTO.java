package com.charles.sandbox.web.dataobject.v1;

import java.io.Serializable;

public class MovieCriteriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String movieName;
	private String genre;
	private Long yearStart;
	private Long yearEnd;

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Long getYearStart() {
		return yearStart;
	}
	public void setYearStart(Long yearStart) {
		this.yearStart = yearStart;
	}
	public Long getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(Long yearEnd) {
		this.yearEnd = yearEnd;
	}
}
