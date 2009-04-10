package etvfit.appcode;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    /**
     *
     */
    public static final boolean MALE=true;
    
    private static final long serialVersionUID = -1426153572408063526L;
     private String name;   //duh
      private int age;            //duh
      private boolean sex =MALE;
    private String address1;    //duh

    public Vector<Appointment> appointments = new Vector<Appointment>();
    public Vector<Medication> medications = new Vector<Medication>();
    private Vector<Doctor> specialists = new Vector<Doctor>();

    private String address2;    //duh

  
    private String insurance;   //insurance company
    private String password;    //password
    private String phone;       //user's phone number
    private Doctor primaryPhysician;
    private String username;    //user's login name
    private String allergies;


    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.address1 = "";
        this.address2 = "";
        this.age = 0;
        this.name = "";
        this.insurance = "";
        this.phone = "";
        this.allergies = "";
        this.sex=MALE;
    }

    public User(String address1, String address2, int age, 
            String insurance, boolean isParent, String name,
            String password, String phone, String username, String allergies, boolean sex) {
        super();
        this.address1 = address1;
        this.address2 = address2;
        this.age = age;
        this.name = name;
        this.insurance = insurance;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.allergies = allergies;
        this.sex=sex;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getInsurance() {
        return insurance;
    }

 

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Doctor getPrimaryPhysician() {
        return primaryPhysician;
    }

    public Vector<Doctor> getSpecialists() {
        return specialists;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPrimaryPhysician(Doctor primaryPhysician) {
        this.primaryPhysician = primaryPhysician;
    }

    public void setSpecialists(Vector<Doctor> specialists) {
        this.specialists = specialists;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean changePassword(String curPass, String newPass) {
        if (this.isPassword(curPass)) {
            password = newPass;
            return true;
        }

        return false;
    }

    public boolean isPassword(String passAttempt) {
        return password.equals(passAttempt);
    }

    @Override
    public boolean equals(Object obj) {
        User u;
        try {
            u = (User) obj;
        } catch (ClassCastException e) {
            return false;
        }
        if (u.password.equals(this.password) && u.username.equals(this.username)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 17 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    public String mailingLabel() {
        return name + "\n" + address1 + "\n" + address2;
    }

    public String toString() {
        return username;
    }
}