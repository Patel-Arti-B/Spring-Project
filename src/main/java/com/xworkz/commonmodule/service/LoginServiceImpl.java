package com.xworkz.commonmodule.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.commonmodule.dao.LoginDAO;
import com.xworkz.commonmodule.dto.LoginDTO;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LoginService {

	private static int noOfCount = 0;

	@Autowired
	private LoginDAO loginDAO;

	public String validEmailPassword(LoginDTO dto) {
		boolean flag = false;
		System.out.println("invoked validEmailPassword");
		try {
			RegisterEntity entity = this.loginDAO.getByEmail(dto.getEmail());
			System.out.println("Register Entity:" + entity);
			if (Objects.isNull(entity)) {
				return "LoginFail";
			}

			String pswDb = entity.getPassword();
			System.out.println("Pssword db:" + pswDb);

			int idDb = entity.getId();
			System.out.println("Id from Db:" + idDb);

			noOfCount=entity.getCount();
			System.out.println(noOfCount);
			if (noOfCount >= 0 && noOfCount < 3) {
				if (dto.getPassword().equals(pswDb)) {
					System.out.println("Password is right...");
					flag = true;
				} else {
					noOfCount++;
					System.out.println("password fail...");
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
			System.out.println("Login service exception......");
			e.printStackTrace();
		}
		return "LoginFail";
	}
}
