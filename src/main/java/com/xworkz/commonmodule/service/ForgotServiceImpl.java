package com.xworkz.commonmodule.service;

import java.util.Objects;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.dao.ForgotDAO;
import com.xworkz.commonmodule.dto.ForgotDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Service
public class ForgotServiceImpl implements ForgotService {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private ForgotDAO forgotDAO;

	public void setForgotDAO(ForgotDAO forgotDAO) {
		logger.info("invoked setForgotDAO...");
		this.forgotDAO = forgotDAO;
	}

	public ForgotServiceImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public String validForgotPsw(ForgotDTO forgotDTO, Model model) {
		logger.info("invoked validForgotPsw");
		try {
			RegisterEntity entity = this.forgotDAO.getForgotByEmail(forgotDTO.getEmail());
			logger.info("Register Entity:" + entity);

			if (Objects.isNull(entity)) {
				return "emailNotMatch";
			}
			int idDb = entity.getId();
			logger.info("Id from Db:" + idDb);

			int countNo = 0;

			if (Objects.nonNull(entity)) {
				logger.info("If Objects....Entity....");

				String chars = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghigklmnopqrstuvwxyz123456789!@#$%^&*";
				String psw = "";
				int length = 8;

				Random random = new Random();
				char[] text = new char[length];
				for (int i = 0; i < length; i++) {
					text[i] = chars.charAt(random.nextInt(chars.length()));
				}
				for (int i = 0; i < length; i++) {
					psw += text[i];
				}

				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String hashPsw = encoder.encode(psw);

				logger.info("Password:" + psw);
				logger.info("Encoded Password:" + hashPsw);

				entity.setPassword(hashPsw);
				entity.setCount(countNo);
				logger.info("count no is" + countNo);

				this.forgotDAO.updateCountForgot(psw, countNo, idDb);

				model.addAttribute("NewPassword", psw);
				return "emailMatch";
			}
		} catch (Exception e) {
			logger.info("Forgot service exception......");
			logger.error(e.getMessage(), e);
		}
		return "emailNotMatch";
	}
}