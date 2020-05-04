package com.xworkz.commonmodule.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.dao.LoginDAO;
import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.exception.ServiceException;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	private static int noOfCount = 0;

	@Autowired
	private LoginDAO loginDAO;

	public String validEmailPassword(LoginDTO dto) throws ServiceException {
		boolean flag = false;
		logger.info("invoked validEmailPassword");
		try {
			RegisterEntity entity = this.loginDAO.getByEmail(dto.getEmail());
			logger.info("Register Entity:" + entity);
			if (Objects.isNull(entity)) {
				return "LoginFail";
			}

			String pswDb = entity.getPassword();
			logger.info("Pssword db:" + pswDb);

			int idDb = entity.getId();
			logger.info("Id from Db:" + idDb);

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			boolean isPswMatch = encoder.matches(dto.getPassword(), pswDb);
			logger.info("Is Password Is Match" + isPswMatch);

			noOfCount = entity.getCount();
			logger.info(noOfCount);
			if (noOfCount >= 0 && noOfCount < 3) {
				if (isPswMatch == true) {
					logger.info("Password is match.....");
					flag = true;
				} else {
					noOfCount++;
					logger.info("password fail...");
					this.loginDAO.updateCount(noOfCount, idDb);
				}
			} else {
				if (noOfCount == 3) {
					return "LoginBlock";
				}
			}
			if (flag == true) {
				return "LoginSuccess";
			}
		} catch (Exception e) {
			ServiceException exception = new ServiceException();
			logger.error(exception.getMessage(), e);
			throw exception;
		}
		return "LoginFail";
	}
}
