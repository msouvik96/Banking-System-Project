package com.banking.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Service_Tracker")
public class ServiceTracker {

	@Id
	@Column(name="Service_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serviceId;
	@Column(name="Service_Description")
	private String serviceDescription;
	@Column(name="Account_ID")
	private int accountId;
	@Column(name="Service_Raised_Date")
	private Date serviceRaisedDate;
	@Column(name="Service_Status")
	private String serviceStatus;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Date getServiceRaisedDate() {
		return serviceRaisedDate;
	}
	public void setServiceRaisedDate(Date serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	@Override
	public String toString() {
		return "ServiceTracker [serviceId=" + serviceId + ", serviceDescription=" + serviceDescription + ", accountId="
				+ accountId + ", serviceRaisedDate=" + serviceRaisedDate + ", serviceStatus=" + serviceStatus + "]";
	}
	
	
	
	
	
}
