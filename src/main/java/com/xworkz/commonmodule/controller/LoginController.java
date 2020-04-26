package com.xworkz.commonmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	public void setService(LoginService service) {
		System.out.println("invoking setService.");
		this.service = service;
	}

	public LoginController() {
		System.out.println("created  \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/login.do")
	public String onLogin(LoginDTO loginDTO, Model model) {
		String page = "";
		System.out.println("invoked onLogin...");

		String mail = loginDTO.getEmail();
		System.out.println("Login mail:" + mail);

		String psw = loginDTO.getPassword();
		System.out.println("Login password" + psw);
		try {
			String data = this.service.validEmailPassword(loginDTO);
			System.out.println("model Attribute.." + loginDTO);
			System.out.println(data);

			if (data.equals("LoginSuccess")) {
				System.out.println("Login Successfully...");
				model.addAttribute("valid", "Login Successfully...");
				return "Home";
			} else if (data.equals("LoginFail")) {
				System.out.println("your Email and Password is wrong...");
				model.addAttribute("validmsg", "your Email and Password is wrong...");
				return "Login";
			} else {
				System.out.println("Block user...");
				model.addAttribute("loginblock", "Your Account is Block.");
				return "LoginBlock";
			}
		} catch (Exception e) {
			System.out.println("controller Exception......");
			e.printStackTrace();
		}
		return page;
	}
}
