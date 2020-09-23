package com.cg.bank.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Date;


@Entity
@Table
public class Account {
	
    @Id
    @GeneratedValue
    private Long acc_num;
    private Double amount;
    private String customerName;
    private String city;
    private String state;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private Long mobileNumber;
    private Long aadhar;
    private String pan;
    private Date dob;
    private String gender;
    private Date passbook_last_updated;
    

	public void setAcc_num(Long acc_num) {
		this.acc_num = acc_num;
	}

	public Long getAcc_num() {
		return acc_num;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getAadhar() {
        return aadhar;
    }

    public void setAadhar(Long aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public Date getPassbook_last_updated() {
		return passbook_last_updated;
	}

	public void setPassbook_last_updated(Date passbook_last_updated) {
		this.passbook_last_updated = passbook_last_updated;
	}



}