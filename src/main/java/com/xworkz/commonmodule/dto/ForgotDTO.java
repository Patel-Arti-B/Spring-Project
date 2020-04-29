package com.xworkz.commonmodule.dto;

import java.io.Serializable;

public class ForgotDTO implements Serializable {

	private String email;

	public ForgotDTO() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgotDTO [email=" + email + "]";
	}

	public ForgotDTO(String email) {
		this.email = email;
	}
}
