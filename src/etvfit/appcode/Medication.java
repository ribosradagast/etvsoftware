package etvfit.appcode;

import java.io.*;

public class Medication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int HOURS = 1;
	public static final int DAYS = 2;
	
	private int dosage;			//take X units each time
	private int numDosages;		//remaining doses
	private String givenFor;	//reason given
	private String name;		
	private int takeEvery;		//take a dose
	private int timeUnits;		//every these units
	
	public Medication(String name, int dosage, int takeEvery, int timeUnits,
			int numDosages, String givenFor) {
		//Eclipse put a super(); in here but I don't know why or think we need it.
		this.name = name;
		this.dosage = dosage;
		this.takeEvery = takeEvery;
		this.setTimeUnits(timeUnits);
		this.numDosages = numDosages;
		this.givenFor = givenFor;
	}
	
	public String toString(){
		return name;
	}
	
	public int getDosage() {
		return dosage;
	}
	
	public int getNumDosages() {
		return numDosages;
	}
	
	public String getGivenFor() {
		return givenFor;
	}

	public String getName() {
		return name;
	}

	public int getTakeEvery() {
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

	public void setNumDosages(int numDosages) {
		this.numDosages = numDosages;
	}

	public void setGivenFor(String givenFor) {
		this.givenFor = givenFor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTakeEvery(int takeEvery) {
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

	public void setTimeUnits(int timeUnits) {
		this.timeUnits = timeUnits;
	}

	public int getTimeUnits() {
		return timeUnits;
	}
}