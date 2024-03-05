package com.clickncash.entity;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;//ACTIVE - DEACTIVE
	private Timestamp createdAt;
	private Timestamp loginTime;
	private Timestamp updatedAt;
	private Long updatedBy;	
	private String otp;
	private Long createdBy;
	private String username;		//	member details
    private String email;
    private String mobile;
    private String password ;
    private String name;
    private String gender;
    private Long userType;
    private String dob;
    private String address;				//  address	
	private String pincode;
	private String state;
	private String city;
	private String aadhar;				//	id proof
	private String pancard;	
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;   
	@Column(name = "failed_attempt")
	private int failedAttempt;     
	@Column(name = "lock_time")
	private Date lockTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Long getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Long getUserType() {
		return userType;
	}


	public void setUserType(Long userType) {
		this.userType = userType;
	}



	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}





	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getPancard() {
		return pancard;
	}


	public void setPancard(String pancard) {
		this.pancard = pancard;
	}



	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public int getFailedAttempt() {
		return failedAttempt;
	}


	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}


	public Date getLockTime() {
		return lockTime;
	}


	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}




	public User(Long id, String status, Timestamp createdAt, Timestamp loginTime, Timestamp updatedAt, Long updatedBy,
			String otp, Long createdBy, String username, String email, String mobile, String password, String name,
			String gender, Long userType, String dob, String address, String pincode, String state, String city,
			String aadhar, String pancard, boolean accountNonLocked, int failedAttempt, Date lockTime) {
		super();
		this.id = id;
		this.status = status;
		this.createdAt = createdAt;
		this.loginTime = loginTime;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.otp = otp;
		this.createdBy = createdBy;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.userType = userType;
		this.dob = dob;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




}
