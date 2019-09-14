package com.banking.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Account_Master")
public class AccountMaster {

	@Id
	@Column(name="Account_ID")
	private int accountId;
	@Column(name="Account_Type")
	private String accountType;
	@Column(name="Account_Balance")
	private double accountBalance;
	@Column(name="Open_Date")
	private Date openDate;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date date) {
		openDate = date;
	}
	@Override
	public String toString() {
		return "Account_Master [Account_ID=" + accountId + ", Account_Type=" + accountType + ", Account_Balance="
				+ accountBalance + ", Open_Date=" + openDate + "]";
	
	}
	
}
