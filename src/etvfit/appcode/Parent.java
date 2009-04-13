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

    public void addNewChild(User kid){
        children.add(kid);
    }
}