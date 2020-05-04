package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.exception.DAOException;

public interface ForgotDAO {
	public RegisterEntity getForgotByEmail(String email) throws DAOException;

	public int updateCountForgot(String password, int countNo, int id) throws DAOException;
}
