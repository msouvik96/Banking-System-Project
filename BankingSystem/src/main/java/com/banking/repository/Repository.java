package com.banking.repository;

import java.util.HashMap;


public class Repository {
	
	public static HashMap<String,String> getRepo()
	{
		HashMap<String, String> rep=new HashMap<String, String>();
		rep.put("url","jdbc:mysql://localhost:3306/Banking_System");
		rep.put("driver", "com.mysql.jdbc.Driver");
		rep.put("prop", "C:/Users/Souvik/Desktop/Caps_Training/BankingSystem/dbcredential.properties");
		return rep;
	}
}
