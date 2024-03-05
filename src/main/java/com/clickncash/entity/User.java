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
	private Long refId;
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
    private String parent;
    private String education;
    private String dob;
    private boolean isWhatsApp;
    private String address;				//  address	
	private String pincode;
	private String state;
	private String city;
	private String perAddress;
	private String perPincode;
	private String perState;
	private String perCity;
	private boolean sameAsCurrent;
	private String aadhar;				//	id proof
	private String pancard;
	private String voterid;
	private String jobTitle;			//	office details
	private String  monthlyIncome;
	private String officeMobile;
	private String officeAddress;
	private String officePincode;
	private String officeCity;
	private String nomineeName;			//	nominee details
	private String nomineeParent;
	private String nomineeMobile;
	private String nomineeDob;
	private String relation;
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


	public Long getRefId() {
		return refId;
	}


	public void setRefId(Long refId) {
		this.refId = refId;
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


	public String getParent() {
		return parent;
	}


	public void setParent(String parent) {
		this.parent = parent;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public boolean isWhatsApp() {
		return isWhatsApp;
	}


	public void setWhatsApp(boolean isWhatsApp) {
		this.isWhatsApp = isWhatsApp;
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


	public String getPerAddress() {
		return perAddress;
	}


	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}


	public String getPerPincode() {
		return perPincode;
	}


	public void setPerPincode(String perPincode) {
		this.perPincode = perPincode;
	}


	public String getPerState() {
		return perState;
	}


	public void setPerState(String perState) {
		this.perState = perState;
	}


	public String getPerCity() {
		return perCity;
	}


	public void setPerCity(String perCity) {
		this.perCity = perCity;
	}


	public boolean isSameAsCurrent() {
		return sameAsCurrent;
	}


	public void setSameAsCurrent(boolean sameAsCurrent) {
		this.sameAsCurrent = sameAsCurrent;
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


	public String getVoterid() {
		return voterid;
	}


	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getMonthlyIncome() {
		return monthlyIncome;
	}


	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}


	public String getOfficeMobile() {
		return officeMobile;
	}


	public void setOfficeMobile(String officeMobile) {
		this.officeMobile = officeMobile;
	}


	public String getOfficeAddress() {
		return officeAddress;
	}


	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}


	public String getOfficePincode() {
		return officePincode;
	}


	public void setOfficePincode(String officePincode) {
		this.officePincode = officePincode;
	}


	public String getOfficeCity() {
		return officeCity;
	}


	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}


	public String getNomineeName() {
		return nomineeName;
	}


	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}


	public String getNomineeParent() {
		return nomineeParent;
	}


	public void setNomineeParent(String nomineeParent) {
		this.nomineeParent = nomineeParent;
	}


	public String getNomineeMobile() {
		return nomineeMobile;
	}


	public void setNomineeMobile(String nomineeMobile) {
		this.nomineeMobile = nomineeMobile;
	}


	public String getNomineeDob() {
		return nomineeDob;
	}


	public void setNomineeDob(String nomineeDob) {
		this.nomineeDob = nomineeDob;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
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


	public User(Long id, Long refId, String status, Timestamp createdAt, Timestamp loginTime, Timestamp updatedAt,
			Long updatedBy, String otp, Long createdBy, String username, String email, String mobile, String password,
			String name, String gender, Long userType, String parent, String education, String dob, boolean isWhatsApp,
			String address, String pincode, String state, String city, String perAddress, String perPincode,
			String perState, String perCity, boolean sameAsCurrent, String aadhar, String pancard, String voterid,
			String jobTitle, String monthlyIncome, String officeMobile, String officeAddress, String officePincode,
			String officeCity, String nomineeName, String nomineeParent, String nomineeMobile, String nomineeDob,
			String relation, boolean accountNonLocked, int failedAttempt, Date lockTime) {
		super();
		this.id = id;
		this.refId = refId;
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
		this.parent = parent;
		this.education = education;
		this.dob = dob;
		this.isWhatsApp = isWhatsApp;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.perAddress = perAddress;
		this.perPincode = perPincode;
		this.perState = perState;
		this.perCity = perCity;
		this.sameAsCurrent = sameAsCurrent;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.voterid = voterid;
		this.jobTitle = jobTitle;
		this.monthlyIncome = monthlyIncome;
		this.officeMobile = officeMobile;
		this.officeAddress = officeAddress;
		this.officePincode = officePincode;
		this.officeCity = officeCity;
		this.nomineeName = nomineeName;
		this.nomineeParent = nomineeParent;
		this.nomineeMobile = nomineeMobile;
		this.nomineeDob = nomineeDob;
		this.relation = relation;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




}
