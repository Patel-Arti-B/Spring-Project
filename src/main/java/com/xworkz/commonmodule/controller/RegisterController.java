package com.xworkz.commonmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	private RegisterService service;

	public void setService(RegisterService service) {
		System.out.println("invoked setRegisterService");
		this.service = service;
	}

	@RequestMapping("/register.do")
	public String onSave(@ModelAttribute("Register") RegisterDTO dto, Model model) {
		System.out.println("invoked onSave....");

		System.out.println("model Attribute " + dto);

		model.addAttribute("msg", "Register Data Successfully...");

		this.service.validAndsave(dto, model);

		return "Register";
	}
}
