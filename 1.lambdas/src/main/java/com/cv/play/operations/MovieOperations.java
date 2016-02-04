package com.cv.play.operations;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.cv.play.model.Movie;

public class MovieOperations {
	// Sorting and filtering operations performed on lists of movies
	public static void sortByName(List<Movie> movies){
		Collections.sort(movies, 
				(m1,m2) -> { return m1.getName().compareTo(m2.getName());});
		
	}
	public static List<Movie> filterByActor(List<Movie> movies, String actorName){
		List<Movie> results = movies.stream()
							  .filter(m -> (m.getLeadActor().compareTo(actorName))==0)
							  .collect(Collectors.toList());
		return results;
	}
}