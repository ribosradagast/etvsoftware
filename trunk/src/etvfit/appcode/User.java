package etvfit.appcode;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    /**
     *
     */
    public static final boolean MALE=true;
    
    public Vector<Appointment> appointments = new Vector<Appointment>();
    public Vector<Medication> medications = new Vector<Medication>();
    private Vector<Doctor> specialists = new Vector<Doctor>();
    
    private static final long serialVersionUID = -1426153572408063526L;
    private String name = "";
    private int age = 0;
    private boolean sex =MALE;
    private String address1 = "";
    private String city = "";
    private String state = "";
    private String zip = "";
    private String insuranceProvider = "";	//insurance company
    private String insuranceNumber = "";	//number on insurance policy
    private String password = "";			//password
    private String phone = "";				//user's phone number
    private Doctor primaryPhysician = null;
    private String username = "";			//user's login name
    private String allergies = "";
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public boolean getSex() {	//TODO: getSex() more often!!! ;D
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

    public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

	public User(String name, int age, boolean sex,
			String address1, String city, String state, String zip,
			String insuranceProvider, String insuranceNumber, String password,
			String phone, String username,
			String allergies) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.insuranceProvider = insuranceProvider;
		this.insuranceNumber = insuranceNumber;
		this.password = password;
		this.phone = phone;
		this.username = username;
		this.allergies = allergies;
	}

	public String getAddress1() {
        return address1;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
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
        return name + "\n" + address1 + "\n" + city+ ", "+state+" "+zip;
    }

    public String toString() {
        return username;
    }

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
}