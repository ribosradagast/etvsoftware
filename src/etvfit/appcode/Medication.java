package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Medication implements Serializable {

    /**
     *
     */
    public static final int HOURS = 1;
    public static final int DAYS = 2;
    private static final long serialVersionUID = 1L;

    private int dosage;         	//take X units each time
    private int numDosages;     	//number of dosages
    private String givenFor;    	//reason given
    private String name;	    	//uh, duh.
    private int takeEvery;          //take a dose
    private int timeUnits = HOURS;  //units
    private Doctor docWhoPrescribed;
    private int NOD;                 //number of dosages to take at a time.

    public int getNOD() {
        return NOD;
    }

    public void setNOD(int NOD) {
        this.NOD = NOD;
    }
    public Medication(int dosage, int numDosages, String givenFor, String name, int takeEvery, Doctor docWhoPrescribed, int NOD) {
        this.dosage = dosage;
        this.numDosages = numDosages;
        this.givenFor = givenFor;
        this.name = name;
        this.takeEvery = takeEvery;
        this.docWhoPrescribed = docWhoPrescribed;
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