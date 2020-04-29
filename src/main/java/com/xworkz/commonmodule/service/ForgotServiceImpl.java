package com.xworkz.commonmodule.service;

import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.commonmodule.dao.ForgotDAO;
import com.xworkz.commonmodule.dto.ForgotDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Service
public class ForgotServiceImpl implements ForgotService {

	@Autowired
	private ForgotDAO forgotDAO;

	public void setForgotDAO(ForgotDAO forgotDAO) {
		System.out.println("invoked setForgotDAO...");
		this.forgotDAO = forgotDAO;
	}

	public ForgotServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public String validForgotPsw(ForgotDTO forgotDTO, Model model) {
		System.out.println("invoked validForgotPsw");
		try {
			RegisterEntity entity = this.forgotDAO.getForgotByEmail(forgotDTO.getEmail());
			System.out.println("Register Entity:" + entity);

			if (Objects.isNull(entity)) {
				return "emailNotMatch";
			}
			int idDb = entity.getId();
			System.out.println("Id from Db:" + idDb);

			int countNo = 0;

			if (Objects.nonNull(entity)) {
				System.out.println("If Objects....Entity....");

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

				System.out.println("Password:" + psw);
				System.out.println("Encoded Password:" + hashPsw);

				entity.setPassword(hashPsw);
				entity.setCount(countNo);
				System.out.println("count no is" + countNo);

				this.forgotDAO.updateCountForgot(psw, countNo, idDb);

				model.addAttribute("NewPassword", psw);
				return "emailMatch";
			}
		} catch (Exception e) {
			System.out.println("Forgot service exception......");
			e.printStackTrace();
		}
		return "emailNotMatch";
	}
}