package com.banking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="Account_ID")
	private int accountId;
	@Column(name="Customer_Name")
	private String customerName;
	@Column(name="Email")
	private String email;
	@Column(name="Address")
	private String address;
	@Column(name="Pancard")
	private String pancard;
	@Column(name="Mobile_No")
	private long mobileno;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCustomer_Name() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public long getMobileNo() {
		return mobileno;
	}
	public void setMobileNo(long mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Customer [Account_ID=" + accountId + ", Customer_Name=" + customerName + ", Email=" + email
				+ ", Address=" + address + ", Pancard=" + pancard + ", Mobile_No=" + mobileno + "]";
	}
	
	
	
	
	
}
