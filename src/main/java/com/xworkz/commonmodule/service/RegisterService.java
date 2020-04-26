package com.xworkz.commonmodule.service;

import org.springframework.ui.Model;

import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.dto.RegisterDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;

public interface RegisterService {
	public String validAndsave(RegisterDTO registerDTO, Model model);

	
}
