package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.exception.ServiceException;

public interface LoginService {
	public String validEmailPassword(LoginDTO dto) throws ServiceException;
}
