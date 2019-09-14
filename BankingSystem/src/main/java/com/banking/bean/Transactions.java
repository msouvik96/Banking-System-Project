package com.banking.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {

	@Id
	@Column(name="Transaction_ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@Column(name="Transaction_Description")
	private String tranDescription;
	@Column(name="Date_Of_Transaction")
	private Date dateOfTransaction;
	@Column(name="Transaction_Type")
	private String transactionType;
	@Column(name="Transaction_Amount")
	private int transactionAmount;
	@Column(name="Account_ID")
	private int accountId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTranDescription() {
		return tranDescription;
	}
	public void setTranDescription(String tranDescription) {
		this.tranDescription = tranDescription;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", tranDescription=" + tranDescription
				+ ", dateOfTransaction=" + dateOfTransaction + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", accountId=" + accountId + "]";
	}
	
	
	
	
}
