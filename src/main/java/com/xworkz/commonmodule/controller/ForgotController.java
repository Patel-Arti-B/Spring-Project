package com.xworkz.commonmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.ForgotDTO;
import com.xworkz.commonmodule.service.ForgotService;

@Controller
@RequestMapping("/")
public class ForgotController {

	@Autowired
	private ForgotService service;

	public void setService(ForgotService service) {
		System.out.println("invoked setService.......");
		this.service = service;
	}

	public ForgotController() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("forgot.do")
	public String forgotPsw(ForgotDTO forgotDTO, Model model) {
		System.out.println("invoked forgotPsw......");
		String Forgotpage = "";

		String email =forgotDTO.getEmail();
		System.out.println("Email :" + email);

		try {
			String dataDb = this.service.validForgotPsw(forgotDTO,model);
			System.out.println("model Attribute.." + forgotDTO);
			System.out.println(dataDb);

			if (dataDb.equals("emailMatch")) {
				System.out.println("Your Email is Match.....");
				model.addAttribute("validmsg", "Your Email is Match...");
				
				Forgotpage = "Forgot";
			} else {
				System.out.println("Please reset again Your mail id is not correct...");
				model.addAttribute("forgot", "Please reset again Your mail id is not correct...");
				Forgotpage = "Forgot";
			}
		} catch (Exception e) {
			System.out.println("controller Exception......");
			e.printStackTrace();
		}
		return Forgotpage;
	}
}
