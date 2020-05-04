package com.xworkz.commonmodule.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.exception.ControllerException;
import com.xworkz.commonmodule.service.LoginService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private LoginService service;

	public void setService(LoginService service) {
		logger.info("invoking setService.");
		this.service = service;
	}

	public LoginController() {
		logger.info("created  \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/login.do")
	public String onLogin(LoginDTO loginDTO, Model model) throws ControllerException {
		String page = "";
		logger.info("invoked onLogin...");

		String mail = loginDTO.getEmail();
		logger.info("Login mail:" + mail);

		String psw = loginDTO.getPassword();
		logger.info("Login password" + psw);
		try {
			String data = this.service.validEmailPassword(loginDTO);
			logger.info("model Attribute.." + loginDTO);
			logger.info(data);

			if (data.equals("LoginSuccess")) {
				logger.info("Login Successfully...");
				model.addAttribute("valid", "Login Successfully...");
				page = "Home";
			} else if (data.equals("LoginFail")) {
				logger.info("your Email and Password is wrong...");
				model.addAttribute("validmsg", "your Email and Password is wrong...");
				page = "Login";
			} else {
				logger.info("Block user...");
				model.addAttribute("loginblock", "Your Account is Block.");
				page = "LoginBlock";
			}
		} catch (Exception e) {
			ControllerException exception = new ControllerException();
			logger.error(exception.getMessage(), e);
			throw exception;
		}
		return page;
	}
}
