package com.cv.movierentals.interfaces;

import java.util.List;

import com.cv.movierentals.models.Movie;

public interface MovieSearcher {
	
	public List<Movie> filterByActor(List<Movie> movies, String actor);
	public List<Movie> sortByReleaseDate(List<Movie> movies);
	public List<Movie> filterByActress(List<Movie> movies, String actress);

}

