package com.xworkz.commonmodule.service;

import org.springframework.ui.Model;

import com.xworkz.commonmodule.dto.ForgotDTO;
import com.xworkz.commonmodule.exception.ServiceException;

public interface ForgotService {
	public String validForgotPsw(ForgotDTO forgotDTO, Model model) throws ServiceException;
}
