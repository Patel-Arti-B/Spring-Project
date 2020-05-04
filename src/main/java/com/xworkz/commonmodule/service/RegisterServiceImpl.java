package com.xworkz.commonmodule.service;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.dao.RegisterDAO;
import com.xworkz.commonmodule.dao.RegisterUserDAO;
import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.exception.DAOException;
import com.xworkz.commonmodule.exception.ServiceException;

@Service
public class RegisterServiceImpl implements RegisterService {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private RegisterUserDAO userDAO;

	public void setUserDAO(RegisterUserDAO userDAO) {
		logger.info("invoked setUserDAO.....");
		this.userDAO = userDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		logger.info("invoked setRegisterDAO......");
		this.registerDAO = registerDAO;
	}

	public RegisterServiceImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public String validAndsave(RegisterDTO registerDTO, Model model) throws ServiceException {
		logger.info("invoked validAndsave....");

		boolean flag = false;
		String userId = registerDTO.getUserId();
		if (userId != null && !userId.isEmpty() && userId.length() >= 3 && userId.length() <= 10) {
			logger.info("Register User Id is valid...");
			flag = true;
		} else {
			logger.info("Register User Id is Not valid...");
			flag = false;
		}
		String email = registerDTO.getEmail();
		if (email != null && !email.isEmpty()) {
			logger.info("Register email is valid...");
			flag = true;
		} else {
			logger.info("Register email is Not valid...");
			flag = false;
		}
		String phone = registerDTO.getPhone();
		if (phone != null && !phone.isEmpty()) {
			logger.info("Register phone number is valid...");
			flag = true;
		} else {
			logger.info("Register phone number is Not valid...");
			flag = false;
		}
		String course = registerDTO.getCourse();
		if (course != null && !course.isEmpty()) {
			logger.info("Register course is valid...");
			flag = true;
		} else {
			logger.info("Register course is Not valid...");
			flag = false;
		}

		String agree = registerDTO.getAgree();
		if (agree != null) {
			logger.info("Register agree is valid...");
			flag = true;
		} else {
			logger.info("Register agree is Not valid...");
			flag = false;
		}

		if (registerDTO.getAgree().equals("disagree")) {
			logger.info("please valid registration...");
			model.addAttribute("disAgree", "Your registration Dis-Agree...You should Agree for registration..");
			return "Register";
		} else {
			try {
				RegisterEntity entity = new RegisterEntity();
				BeanUtils.copyProperties(registerDTO, entity);

				if (userDAO.validUserId(registerDTO.getUserId()) && userDAO.validEmail(registerDTO.getEmail())) {
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

					BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
					String hashedpsw = encoder.encode(psw);
					logger.info("Encrypt psw:" + hashedpsw);

					encoder.matches(psw, hashedpsw);

					entity.setPassword(hashedpsw);
					entity.setCount(0);
					logger.info("Password:" + psw);

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
			} catch (Exception e) {
				ServiceException exception = new ServiceException();
				logger.error(exception.getMessage(), e);
				throw exception;
			}
		}
		return agree;

	}
}