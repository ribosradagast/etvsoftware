package etvfit.appcode;

import java.io.*;

public class Doctor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 107370099662254157L;
	private String address1;	//address line 1
	private String address2;	//address line 2
	private String name;		//uh, duh
	private String phone;		//phone number
	private boolean specialist;	//is a specialist?
	private String speciality;	//speciality if applicable
	
	public Doctor(String Name,String Addr1,String Addr2,String Phone){
		this(Name,Addr1,Addr2,Phone,false,"");
	}
	
	public String toString(){
		return name;
	}
	
	public Doctor( String Name,
						String Addr1,
						String Addr2,
						String Phone,
						boolean Specialist,
						String Speciality
						){
		
		name=Name;
		address1=Addr1;
		address2=Addr2;
		setPhone(Phone);
		setSpecialist(Specialist);
		setSpeciality(Speciality);
		
	}

	public Doctor() {
		address1 = "";		//address line 1
		address2 = "";		//address line 2
		name = "";			
		phone = "";			//phone number
		speciality = "";	//speciality if applicable
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
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
	
	public boolean isSpecialist() {
		return specialist;
	}
	
	public String mailingLabel(){
		return name+"\n"+address1+"\n"+address2;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSpecialist(boolean specialist) {
		this.specialist = specialist;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}