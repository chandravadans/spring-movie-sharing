package com.cv.spring.movieutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.cv.spring.interfaces.MovieSearcher;
import com.cv.spring.models.Movie;

@Component("MovieUtil")
@PropertySource("classpath:app.properties")
public class MovieUtil {

	@Autowired
	MovieSearcher searcher;

	List<Movie> memoryCache;

	@Value("${movies.path}")
	private String moviesResourcePath;
	
	
	public void setMovieSearcher(MovieSearcher ms){
		this.searcher = ms;
	}
	
	public MovieUtil() {
	}

	//Java 8 Function. Takes an argument, returns an argument. Cool!
	Function<String, Movie> stringToMovie = new Function<String, Movie>(){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		@Override
		public Movie apply(String movieStr) {
			Movie theMovie = new Movie();
			String[] parts = movieStr.split(",");
			theMovie.setName(parts[0].trim());
			theMovie.setLeadActor(parts[1].trim());
			theMovie.setLeadActress(parts[2].trim());
			theMovie.setReleaseDate(LocalDate.parse(parts[3].trim(),dateTimeFormatter));
			return theMovie;
		}
		
	};
	
	
	@PostConstruct
	public void init() throws IOException {
		System.out.println("Reading movies from : " + moviesResourcePath);
		Stream<String> lines = Files.lines(Paths.get(moviesResourcePath));
		
		memoryCache = lines.map(stringToMovie).collect(Collectors.<Movie> toList());
		
		System.out.println("Read "+memoryCache.size()+" movies into cache");
		
	}
	
	public String getMoviesResourcePath(){
		return moviesResourcePath;
	}
	
	public void setMoviesResourcePath(String path){
		this.moviesResourcePath = path;
	}
	
	public List<Movie> getCache(){
		return this.memoryCache;
	}
	
	public List<Movie> getMoviesByActor(String actor){
		return searcher.filterByActor(memoryCache, actor);
	}
	
	public List<Movie> sortMovies(){
		return searcher.sortByReleaseDate(memoryCache);
	}
	
	public List<Movie> getMoviesByActress(String actress){
		return searcher.filterByActress(memoryCache, actress);
	}
}
