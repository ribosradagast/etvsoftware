package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Medication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dosage;			//take X units each time
	private int dosesLeft;		//remaining doses
	private String givenFor;	//reason given
	private Date lastTaken;		//date of last taken dose
	private String name;		//uh, duh.
	private Date takeEvery;		//time between doses
	
	public Medication(String name, int dosage, Date lastTaken, Date takeEvery,
			int dosesLeft, String givenFor) {
		//Eclipse put a super(); in here but I don't know why or think we need it.
		this.name = name;
		this.dosage = dosage;
		this.lastTaken = lastTaken;
		this.takeEvery = takeEvery;
		this.dosesLeft = dosesLeft;
		this.givenFor = givenFor;
	}
	
	public String toString(){
		return name;
	}
	
	public int getDosage() {
		return dosage;
	}
	
	public int getDosesLeft() {
		return dosesLeft;
	}
	
	public String getGivenFor() {
		return givenFor;
	}

	public Date getLastTaken() {
		return lastTaken;
	}

	public String getName() {
		return name;
	}

	public Date getTakeEvery() {
		return takeEvery;
	}

	public boolean refillInDays(int numOfDays){
		//returns true if the perscription must be refilled in <= number of days 
		//given as parameter; otherwise false
		
		return false;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public void setDosesLeft(int dosesLeft) {
		this.dosesLeft = dosesLeft;
	}

	public void setGivenFor(String givenFor) {
		this.givenFor = givenFor;
	}

	public void setLastTaken(Date lastTaken) {
		this.lastTaken = lastTaken;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTakeEvery(Date takeEvery) {
		this.takeEvery = takeEvery;
	}

	public boolean takeInDays(int numOfDays){
		//returns true if the perscription must be taken in <= number of days 
		//given as parameter; otherwise false
		
		return false;
	}

	public boolean takeInHours(int numOfHours){
		//returns true if the perscription must be taken in <= number of hours 
		//given as parameter; otherwise false
		
		return false;
	}

	public void tookMed(){
		//simply flips the lastTaken to today
		setLastTaken(new Date());
	}
}