package com.cv.play.model;

import java.util.Date;

public class Movie {
	
	String name;
	String leadActor;
	String leadActress;
	Date releaseDate;
	
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	

}
