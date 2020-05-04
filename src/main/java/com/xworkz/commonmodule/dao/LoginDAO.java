package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.exception.DAOException;

public interface LoginDAO {
	public RegisterEntity getByEmail(String email) throws DAOException;

	public Integer updateCount(int noOfCount, int id)throws DAOException;
}
