package com.banking.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Fund_Transfer")
public class FundTransfer {

	@Id
	@Column(name="FundTransfer_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fundTransferId;
	@Column(name="Account_ID")
	private int accountId;
	@Column(name="Payee_Account_ID")
	private int payeeAccountId;
	@Column(name="Date_Of_Transfer")
	private Date dateofTransfer;
	@Column(name="Transfer_Amount")
	private double transferAmount;
	
	public int getFundTransferId() {
		return fundTransferId;
	}
	public void setFundTransferId(int fundTransferId) {
		this.fundTransferId = fundTransferId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPayeeAccountId() {
		return payeeAccountId;
	}
	public void setPayeeAccountId(int payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}
	public Date getDateOfTransfer() {
		return dateofTransfer;
	}
	public void setDateOfTransfer(Date dateOfTransfer) {
		dateofTransfer = dateOfTransfer;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public double setTransferAmount(double amount) {
		return transferAmount = amount;
	}
	@Override
	public String toString() {
		return "Fund_Transfer [FundTransfer_ID=" + fundTransferId + ", Account_ID=" + accountId
				+ ", Payee_Account_ID=" + payeeAccountId + ", Date_Of_Transfer=" + dateofTransfer
				+ ", Transfer_Amount=" + transferAmount + "]";
	}
	
	
}
