package etvfit.appcode;

import java.util.*;
import java.io.*;

public class DataHolder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4900217699329488166L;
	public Vector<Doctor> doctors = new Vector<Doctor>();	//doctors in the save file
	public Vector<User> users = new Vector<User>();			//users in the save file
}