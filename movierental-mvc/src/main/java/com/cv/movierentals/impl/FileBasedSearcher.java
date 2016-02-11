package com.cv.movierentals.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cv.movierentals.interfaces.MovieSearcher;
import com.cv.movierentals.models.Movie;

@Component
public class FileBasedSearcher implements MovieSearcher{
	
	@Override
	public List<Movie> filterByActor(List<Movie> movies, String actor) {
		
		return movies.stream()
				.filter(
				m -> m.getLeadActor().equalsIgnoreCase(actor)
				)
				.collect(Collectors.<Movie> toList());
	}

	@Override
	public List<Movie> sortByReleaseDate(List<Movie> movies) {
		
		return movies.stream()
				.sorted(
				(m1,m2) -> m1.getReleaseDate().compareTo(m2.getReleaseDate())
				)
				.collect(Collectors.<Movie>toList());
		
		
	}

	@Override
	public List<Movie> filterByActress(List<Movie> movies, String actress) {
		
		return movies.stream()
				.filter(
				m -> m.getLeadActress().equalsIgnoreCase(actress)
				)
				.collect(Collectors.<Movie> toList());
	}
}