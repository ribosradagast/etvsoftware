package etvfit.appcode;

import java.io.*;

public class Doctor implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 107370099662254157L;
    private String address;	//address line 1
    private String city;
    private String state;
    private int zip;
    private String name;		//uh, duh
    private String phone;		//phone number
    private String speciality;	//speciality if applicable

    public Doctor(String Name, String Addr1, String city, String state, int zip, String Phone) {
        this(Name, Addr1, city, state, zip, Phone,  "");
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        Doctor doc;
        try {
            doc = (Doctor) other;

        } catch (ClassCastException e) {
            return false;
        }
        if (doc.getName().equals(this.name) && doc.getPhone().equals(this.phone)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        return hash;
    }

    public Doctor(String Name,
            String Addr1,
            String city,
            String state,
            int zip,
            String Phone,
            String Speciality) {

        name = Name;
        address = Addr1;
        this.city = city;
        this.state = state;
        this.zip = zip;

        setPhone(Phone);


        setSpeciality(Speciality);
    }

    public Doctor() {
        address = "";		//address line 1
        this.city = "";
        this.state = "";
        name =
                "";
        phone =
                "";			//phone number
        speciality =
                "";	//speciality if applicable
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getAddress1() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpeciality() {
        return speciality;
    }



    public String mailingLabel() {
        return name + "\n" + address + "\n" + city + ", " + state + " " + zip;
    }

    public void setAddress1(String address1) {
        this.address = address1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}