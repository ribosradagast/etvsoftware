package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Appointment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6027694335205665932L;
    private Calendar date;			//date of appointment

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
    private Doctor doctor;		//doctor appointment is with
    private String time;        //time of appt
    private String description;	//description of appointment (reason)
    private String results;		//results of appointment ("I have cancer", "I will die in 7 days", ect.)

    public Appointment() {
        date = Calendar.getInstance();
        doctor = new Doctor();
        time = "";
        description = "";
        results = "";
    }

    public Appointment(Calendar date, Doctor doctor, String time, String description, String results) {
        this.date = date;
        this.doctor = doctor;
        this.time = time;
        this.description = description;
        this.results = results;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "\""+ description +"\""+ " appointment with " + doctor;
    }

    public boolean appointmentInDays(int days) {
        //returns true if the appointment is in <= number of days
        //given as parameter; otherwise false
        return false;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setResults(String results) {
        this.results = results;
    }
}