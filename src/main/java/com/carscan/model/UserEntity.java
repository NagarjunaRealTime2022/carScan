package com.carscan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserEntity")
public class UserEntity {

	public UserEntity(Long id, String firstName, String lastName, String dob, String city, String mobileNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.city = city;
		this.mobileNumber = mobileNumber;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    private Long id;
    
	// fname, lname, dob, city, and mobile number
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="dob")
    private String dob;
    
    @Column(name="city")
    private String city;
    
    @Column(name="mobile_number")
    private String mobileNumber;
    
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    
    public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	 @Override
		public String toString() {
			return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
					+ ", city=" + city + ", mobileNumber=" + mobileNumber + "]";
		}


}