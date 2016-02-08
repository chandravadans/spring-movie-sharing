package com.cv.spring.models;

import java.time.LocalDate;
import java.util.Date;

public class Movie {
	
	String name;
	String leadActor;
	String leadActress;
	LocalDate releaseDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeadActor() {
		return leadActor;
	}
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
	public String getLeadActress() {
		return leadActress;
	}
	public void setLeadActress(String leadActress) {
		this.leadActress = leadActress;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	

}
