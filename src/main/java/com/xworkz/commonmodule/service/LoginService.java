package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.LoginDTO;

public interface LoginService {
	public String validEmailPassword(LoginDTO dto);
}
