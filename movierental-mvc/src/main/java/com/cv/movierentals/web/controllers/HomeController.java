package com.cv.movierentals.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cv.movierentals.models.Movie;
import com.cv.movierentals.util.MovieUtil;

@Controller
public class HomeController {
	
	@Autowired
	MovieUtil movieUtil;
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json" )
	public List<Movie> home(){
		return movieUtil.sortMovies();
	}

}
