package com.cv.spring.interfaces;

import java.util.List;

import com.cv.spring.models.Movie;

public interface MovieSearcher {
	
	public List<Movie> filterByActor();
	public List<Movie> sortByReleaseDate();
	public List<Movie> filterByActress();

}
