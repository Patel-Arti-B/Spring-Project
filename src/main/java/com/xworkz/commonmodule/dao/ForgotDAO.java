package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.entity.RegisterEntity;

public interface ForgotDAO {
	public RegisterEntity getForgotByEmail(String email);

	public int updateCountForgot(String password, int countNo, int id);
}
