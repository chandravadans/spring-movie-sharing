package com.cv.play.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.cv.play.model.Movie;
import com.cv.play.operations.MovieOperations;

public class AllTests {
	
	@Test
	public void sortsByMovieName(){
		PodamFactoryImpl randomBeanFactory = new PodamFactoryImpl();
		List<Movie> movies = new ArrayList<Movie>();
		for(int i=0;i<5;i++){
			Movie m = randomBeanFactory.manufacturePojo(Movie.class);
			System.out.println("Random movie # "+i+": "+m.getName());
			movies.add(m);
		}
		MovieOperations.sortByName(movies);
		for(int i=0;i<movies.size()-1;i++){
			if(movies.get(i).getName().compareTo(movies.get(i+1).getName())>0)
				fail("Not sorted!");
		}
	}
	
	@Test
	public void filtersByActorName(){
		String actorName = "Ranvir";
		PodamFactoryImpl randomBeanFactory = new PodamFactoryImpl();
		List<Movie> movies = new ArrayList<Movie>();
		for(int i=0;i<5;i++){
			Movie m = randomBeanFactory.manufacturePojo(Movie.class);
			if(i%2 == 0)
				m.setLeadActor("Ranbir");
			else
				m.setLeadActor("Ranvir");
			System.out.println("Random movie # "+i+": "+m.getLeadActor());
			movies.add(m);
		}
		
		List<Movie> filteredList = MovieOperations.filterByActor(movies, "Ranvir");
		for(Movie m : filteredList){
			if(actorName.compareTo(m.getLeadActor())!=0)
				fail(m.getName()+" doesn't cast "+actorName+" in the lead role!");
		}
		
	}
}
