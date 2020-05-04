package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.exception.DAOException;

public interface RegisterUserDAO {
	public boolean validUserId(String userId) throws DAOException;

	public boolean validEmail(String email) throws DAOException;

}
