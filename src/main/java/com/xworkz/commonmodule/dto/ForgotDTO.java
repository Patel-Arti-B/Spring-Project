package com.xworkz.commonmodule.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.xworkz.commonmodule.controller.ForgotController;

public class ForgotDTO implements Serializable {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	private String email;

	public ForgotDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
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
