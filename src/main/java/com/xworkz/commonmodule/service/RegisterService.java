package com.xworkz.commonmodule.service;

import org.springframework.ui.Model;

import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.exception.ServiceException;

public interface RegisterService {
	public String validAndsave(RegisterDTO registerDTO, Model model) throws ServiceException;

}
