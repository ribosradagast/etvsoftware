package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Appointment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6027694335205665932L;
	private Date date;			//date of appointment
	private String description;	//description of appointment (reason)
	private Doctor doctor;		//doctor appointment is with
	private String results;		//results of appointment ("I have cancer", "I will die in 7 days", ect.)
	private User user;			//user appointment is with, for clairty
	
	public Appointment(Date Date,
							 Doctor DOctor,
							 String Description){
		
		setDate(Date);
		setDoctor(DOctor);
		setDescription(Description);
		
	}
	
	public String toString(){
		return description;
	}
	
	public boolean appointmentInDays(int days){
		//returns true if the appointment is in <= number of days
		//given as parameter; otherwise false
		return false;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getResults() {
		return results;
	}

	public User getUser() {
		return user;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public void setUser(User user) {
		this.user = user;
	}
}