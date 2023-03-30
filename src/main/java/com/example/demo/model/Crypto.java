package com.example.demo.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Crypto {

	String base;
	String currency;
	String amount;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	Date timestamp;
	
	public Crypto() {
		super();
		timestamp = new Date();
		// TODO Auto-generated constructor stub
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Crypto [base=" + base + ", currency=" + currency + ", amount=" + amount + ", timestamp=" + timestamp
				+ "]";
	}

	
	
}
