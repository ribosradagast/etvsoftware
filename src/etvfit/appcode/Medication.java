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
	private Doctor docWhoPrescribed;
    private int NOD;                 //number of dosages to take at a time.

	public Medication(){
		givenFor = "";
		name = "";
		docWhoPrescribed = new Doctor();
	}

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

    public int getNOD() {
        return NOD;
    }

    public void setNOD(int NOD) {
        this.NOD = NOD;
    }

    public Doctor getDocWhoPrescribed() {
        return docWhoPrescribed;
    }

    public void setDocWhoPrescribed(Doctor docWhoPrescribed) {
        this.docWhoPrescribed = docWhoPrescribed;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getGivenFor() {
        return givenFor;
    }

    public void setGivenFor(String givenFor) {
        this.givenFor = givenFor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumDosages() {
        return numDosages;
    }

    public void setNumDosages(int numDosages) {
        this.numDosages = numDosages;
    }

    public int getTakeEvery() {
        return takeEvery;
    }

    public void setTakeEvery(int takeEvery) {
        this.takeEvery = takeEvery;
    }

    public int getTimeUnits() {
        return timeUnits;
    }

    public void setTimeUnits(int timeUnits) {
        this.timeUnits = timeUnits;
    }

}
