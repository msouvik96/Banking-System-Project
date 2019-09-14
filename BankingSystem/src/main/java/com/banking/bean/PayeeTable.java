package com.banking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PayeeTable")
public class PayeeTable {

	@Id
	@Column(name="Account_ID")
	private int accountId;
	@Column(name="Payee_Account_ID")
	private int payeeAccountId;
	@Column(name="Nickname")
	private String nickname;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "PayeeTable [accountId=" + accountId + ", payeeAccountId=" + payeeAccountId + ", nickname=" + nickname
				+ "]";
	}
	
	
	
	
}
