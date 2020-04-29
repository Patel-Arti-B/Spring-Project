package com.xworkz.commonmodule.service;

import org.springframework.ui.Model;

import com.xworkz.commonmodule.dto.ForgotDTO;

public interface ForgotService {
	public String validForgotPsw(ForgotDTO forgotDTO, Model model);
}
