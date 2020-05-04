package com.xworkz.commonmodule.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.commonmodule.dto.ForgotDTO;
import com.xworkz.commonmodule.exception.ControllerException;
import com.xworkz.commonmodule.service.ForgotService;

@Controller
public class ForgotController {

	private static final Logger logger = Logger.getLogger(ForgotController.class);
	@Autowired
	private ForgotService service;

	public void setService(ForgotService service) {
		logger.info("invoked setService.......");
		this.service = service;
	}

	public ForgotController() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("forgot.do")
	public String forgotPsw(ForgotDTO forgotDTO, Model model) throws ControllerException {
		logger.info("invoked forgotPsw......");
		String Forgotpage = "";

		String email = forgotDTO.getEmail();
		logger.info("Email :" + email);

		try {
			String dataDb = this.service.validForgotPsw(forgotDTO, model);
			logger.info("model Attribute.." + forgotDTO);
			logger.info(dataDb);

			if (dataDb.equals("emailMatch")) {
				logger.info("Your Email is Match.....");
				model.addAttribute("validmsg", "Your Email is Match...");

				Forgotpage = "Forgot";
			} else {
				logger.info("Please reset again Your mail id is not correct...");
				model.addAttribute("forgot", "Please reset again Your mail id is not correct...");
				Forgotpage = "Forgot";
			}
		} catch (Exception e) {
			ControllerException exception = new ControllerException();
			logger.error(exception.getMessage(), e);
			throw exception;
		}
		return Forgotpage;
	}
}
