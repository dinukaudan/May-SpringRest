package com.udan.demo.model;

public class HelloBean {

	private String messege;

	public HelloBean(String messege) {

	this.messege= messege;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	@Override
	public String toString() {
		return "HelloBean [messege=" + messege + "]";
	}

}
