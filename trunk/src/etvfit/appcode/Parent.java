package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Parent extends User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8980166716105828325L;
    public Vector<User> children;

    public Parent(String username, String password) {
        super(username, password);
    }

	public Parent(String name, int age, boolean sex, String address1,
			String city, String state, String zip, String insuranceProvider,
			String insuranceNumber, String password, String phone,
			String username, String allergies) {
		super(name, age, sex, address1, city, state, zip, insuranceProvider,
				insuranceNumber, password, phone, username, allergies);
		// TODO Auto-generated constructor stub
	}

	public void addNewChild(User newKid) {
        children.add(newKid);
    }
}