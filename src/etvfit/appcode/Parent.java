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

    public Parent(String address1, String address2, int age,
            String insurance, boolean isParent, String name,
            String password, String phone, String username, String allergies, boolean sex)  {

        super( address1,  address2,  age,
             insurance,  isParent,  name,
             password,  phone,  username,  allergies,  sex) ;

    }

    public User addNewChild(String address1, String address2, int age,
            String insurance, boolean isParent, String name,
            String password, String phone, String username, String allergies, boolean sex) {

        User newKid = new User( address1,  address2,  age,
             insurance,  isParent,  name,
             password,  phone,  username,  allergies,  sex) ;
        children.add(newKid);
        return newKid;
    }
}