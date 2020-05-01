package com.xworkz.commonmodule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.xworkz.commonmodule.controller.ForgotController;

import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "register_tab")
public class RegisterEntity implements Serializable {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Id
	@GenericGenerator(name = "Register", strategy = "increment")
	@GeneratedValue(generator = "Register")

	@Column(name = "R_ID")
	private int id;

	@NotEmpty(message = "UserId can not be empty")
	@Column(name = "R_USERID")
	private String userId;

	@NotEmpty(message = "Email can not be empty")
	@Column(name = "R_EMAIL")
	private String email;
	@Column(name = "R_PHONE")
	private String phone;
	@Column(name = "R_COURSE")
	private String course;
	@Column(name = "R_AGREE")
	private String agree;
	@Column(name = "R_PASSWORD")
	private String password;
	@Column(name = "L_COUNT")
	private int count;

	public RegisterEntity() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "RegisterEntity [id=" + id + ", userId=" + userId + ", email=" + email + ", phone=" + phone + ", course="
				+ course + ", agree=" + agree + ", password=" + password + ", count=" + count + "]";
	}

	public RegisterEntity(int id, String userId, String email, String phone, String course, String agree,
			String password, int count) {
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.phone = phone;
		this.course = course;
		this.agree = agree;
		this.password = password;
		this.count = count;
	}

}
