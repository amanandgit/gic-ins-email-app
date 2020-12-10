package com.cts.gic.vo;

import lombok.Getter;

@Getter
public class Customer {
	
	private int id;
	private String name;
	private String emailId;
	private String LOB;
	private String state;
	
	public Customer(int id, String name, String emailId, String lOB, String state) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.LOB = lOB;
		this.state = state;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLOB() {
		return LOB;
	}
	public void setLOB(String lOB) {
		LOB = lOB;
	}
	
	

}
