package com.xworkz.commonmodule.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.service.RegisterService;

@Controller
public class RegisterController {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private RegisterService service;

	public void setService(RegisterService service) {
		logger.info("invoked setRegisterService");
		this.service = service;
	}

	@RequestMapping("/register.do")
	public String onSave(@ModelAttribute("Register") RegisterDTO dto, Model model) {
		logger.info("invoked onSave....");

		logger.info("model Attribute " + dto);

		model.addAttribute("msg", "Register Data Successfully...");

		this.service.validAndsave(dto, model);

		return "Register";
	}
}
