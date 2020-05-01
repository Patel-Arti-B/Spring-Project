package com.xworkz.commonmodule.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.xworkz.commonmodule.controller.ForgotController;

public class RegisterDTO implements Serializable {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	private String userId;
	private String email;
	private String phone;
	private String course;
	private String agree;
	private String password;
	private int count;

	public RegisterDTO() {
		logger.info("creted \t" + this.getClass().getSimpleName());
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RegisterDTO [userId=" + userId + ", email=" + email + ", phone=" + phone + ", course=" + course
				+ ", agree=" + agree + ", password=" + password + ", count=" + count + "]";
	}

	public RegisterDTO(String userId, String email, String phone, String course, String agree, String password,
			int count) {
		this.userId = userId;
		this.email = email;
		this.phone = phone;
		this.course = course;
		this.agree = agree;
		this.password = password;
		this.count = count;
	}

}
