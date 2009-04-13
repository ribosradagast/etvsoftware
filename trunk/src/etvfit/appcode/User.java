package etvfit.appcode;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    /**
     *
     */
    public static final boolean MALE = true;
    public static final boolean FEMALE = false;
    private static final long serialVersionUID = -1426153572408063526L;
    private String username;    //user's login name
    private String name;   //duh
    private int age;            //duh
    private boolean sex = MALE;
    private String address;    //duh
    public Vector<Appointment> appointments = new Vector<Appointment>();
    public Vector<Medication> medications = new Vector<Medication>();
    private Vector<Medication> priorMedications = new Vector<Medication>();
    private Vector<Doctor> specialists = new Vector<Doctor>();
    private String city;
    private String state;
    private int zip;
    private String insurance;   //insurance company
    private long insuranceNumber; //insurance number
    private String password;    //password
    private String phone;       //user's phone number
    private Doctor primaryPhysician = new Doctor();
    private String medicalHistory;
    private String allergies;

    public User(String username, String password, String name, int age, String address, String city, String state, int zip, String phone, String insurance, long insuranceNumber, String medicalHistory, String allergies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.insurance = insurance;
        this.insuranceNumber = insuranceNumber;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;

        //ALSO!!!  Make the User always have at leastone specialist
       this.specialists.add(new Doctor());
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void stopTaking(Medication m) {
        if (medications.contains(m)) {
            priorMedications.add(medications.remove(medications.indexOf(m)));
        }
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Vector<Medication> getPriorMedications() {
        return priorMedications;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

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
        this(username, password, "", 0, "", "", "", 0, "", "", 0, "", "");
    }

    public String getAddress() {
        return address;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
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
        return name + "\n" + address + "\n" + city + ", " + state + " " + zip;
    }

    public String toString() {
        return username;
    }
}