package etvfit.appcode;

import java.util.*;
import java.io.*;

public class Parent extends User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8980166716105828325L;
    public Vector<User> children = new Vector<User> ();

    public Parent(String username, String password) {
        super(username, password);
    }

    public Parent(String username, String password,String name, int age, String address, String city, String state, int zip, String phone, String insurance, long insuranceNumber, String medicalHistory, String allergies, Doctor primaryPhysician)  {

        super(  username,  password, name,  age,  address,  city,  state,  zip,
                phone,  insurance,  insuranceNumber,  medicalHistory,  allergies, primaryPhysician) ;

    }

    public void addNewChild(User kid){
        children.add(kid);
    }
}