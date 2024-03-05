package com.clickncash.model;

public class UserRequest {

	private String fullName;
	private String userName;
	private String mobile;
	private String email;
	private String shop;
	private String aadhar;
	private String pancard;
	private String password;
	private String address;
	private String state;
	private String pincode;
	private String city;
	private Long userType;
	private Long parentId;
	private String dob;
	private String companyName;
	private int transactionService;
	private String vpa;
	private String bcagentid;
	private double lienAmount;
	private double rollingReserve;
	private String payinCallbackUrl;
	private String payoutCallbackUrl;
	private String userIp;
	private String status;
	private String apiStatus;
	
	public UserRequest(String fullName, String userName, String mobile, String email, String shop, String aadhar,
			String pancard, String password, String address, String state, String pincode, String city, Long userType,
			Long parentId, String dob, String companyName, int transactionService, String vpa, String bcagentid) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.shop = shop;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.password = password;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.city = city;
		this.userType = userType;
		this.parentId = parentId;
		this.dob = dob;
		this.companyName = companyName;
		this.transactionService = transactionService;
		this.vpa = vpa;
		this.bcagentid = bcagentid;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getUserType() {
		return userType;
	}
	public void setUserType(Long userType) {
		this.userType = userType;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTransactionService() {
		return transactionService;
	}
	public void setTransactionService(int transactionService) {
		this.transactionService = transactionService;
	}
	public String getVpa() {
		return vpa;
	}
	public void setVpa(String vpa) {
		this.vpa = vpa;
	}
	public String getBcagentid() {
		return bcagentid;
	}
	public void setBcagentid(String bcagentid) {
		this.bcagentid = bcagentid;
	}
	public double getLienAmount() {
		return lienAmount;
	}
	public double getRollingReserve() {
		return rollingReserve;
	}
	public void setLienAmount(double lienAmount) {
		this.lienAmount = lienAmount;
	}
	public void setRollingReserve(double rollingReserve) {
		this.rollingReserve = rollingReserve;
	}
	public String getPayinCallbackUrl() {
		return payinCallbackUrl;
	}
	public String getPayoutCallbackUrl() {
		return payoutCallbackUrl;
	}
	public void setPayinCallbackUrl(String payinCallbackUrl) {
		this.payinCallbackUrl = payinCallbackUrl;
	}
	public void setPayoutCallbackUrl(String payoutCallbackUrl) {
		this.payoutCallbackUrl = payoutCallbackUrl;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApiStatus() {
		return apiStatus;
	}
	public void setApiStatus(String apiStatus) {
		this.apiStatus = apiStatus;
	}	
	
	
}
