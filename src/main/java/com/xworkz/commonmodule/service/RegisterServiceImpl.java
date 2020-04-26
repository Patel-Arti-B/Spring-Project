package com.xworkz.commonmodule.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.commonmodule.dao.RegisterDAO;
import com.xworkz.commonmodule.dao.RegisterUserDAO;
import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private RegisterUserDAO userDAO;

	public void setUserDAO(RegisterUserDAO userDAO) {
		System.out.println("invoked setUserDAO.....");
		this.userDAO = userDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		System.out.println("invoked setRegisterDAO......");
		this.registerDAO = registerDAO;
	}

	public RegisterServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public String validAndsave(RegisterDTO registerDTO, Model model) {
		System.out.println("invoked validAndsave....");

		boolean flag = false;
		String userId = registerDTO.getUserId();
		if (userId != null && !userId.isEmpty() && userId.length() >= 3 && userId.length() <= 10) {
			System.out.println("Register User Id is valid...");
			flag = true;
		} else {
			System.out.println("Register User Id is Not valid...");
			flag = false;
		}
		String email = registerDTO.getEmail();
		if (email != null && !email.isEmpty()) {
			System.out.println("Register email is valid...");
			flag = true;
		} else {
			System.out.println("Register email is Not valid...");
			flag = false;
		}
		String phone = registerDTO.getPhone();
		if (phone != null && !phone.isEmpty()) {
			System.out.println("Register phone number is valid...");
			flag = true;
		} else {
			System.out.println("Register phone number is Not valid...");
			flag = false;
		}
		String course = registerDTO.getCourse();
		if (course != null && !course.isEmpty()) {
			System.out.println("Register course is valid...");
			flag = true;
		} else {
			System.out.println("Register course is Not valid...");
			flag = false;
		}

		String agree = registerDTO.getAgree();
		if (agree != null) {
			System.out.println("Register agree is valid...");
			flag = true;
		} else {
			System.out.println("Register agree is Not valid...");
			flag = false;
		}

		if (registerDTO.getAgree().equals("disagree")) {
			System.out.println("please valid registration...");
			model.addAttribute("disAgree", "Your registration Dis-Agree...You should Agree for registration..");
			return "Register";
		}

		if (userDAO.validUserId(registerDTO.getUserId()) && userDAO.validEmail(registerDTO.getEmail())) {
			RegisterEntity entity = new RegisterEntity();
			BeanUtils.copyProperties(registerDTO, entity);

			String chars = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghigklmnopqrstuvwxyz123456789!@#$%^&*";
			String psw = "";
			int length = 8;

			Random random = new Random();
			char[] text = new char[length];
			for (int i = 0; i < length; i++) {
				text[i] = chars.charAt(random.nextInt(chars.length()));
			}
			for (int i = 0; i < length; i++) {
				psw += text[i];
			}
			entity.setPassword(psw);
			entity.setCount(0);
			System.out.println("Password" + entity.getPassword());

			model.addAttribute("UserID", entity.getUserId());
			model.addAttribute("Email", entity.getEmail());
			model.addAttribute("password", entity.getPassword());
			registerDAO.saveRegister(entity);
			return "Register";
		} else if (userDAO.validUserId(registerDTO.getUserId())) {
			model.addAttribute("useUserID", "UserId Already exists");
			return "Register";
		} else if (userDAO.validEmail(registerDTO.getEmail())) {
			model.addAttribute("useEmail", "Email Already exists");
			return "Register";
		}
		return "Register";
	}
}