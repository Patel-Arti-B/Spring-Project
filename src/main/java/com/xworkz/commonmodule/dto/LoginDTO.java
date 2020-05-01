package com.xworkz.commonmodule.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.xworkz.commonmodule.controller.ForgotController;

public class LoginDTO implements Serializable {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	private int id;
	private String email;
	private String password;

	public LoginDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public LoginDTO(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

}
