package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.exception.DAOException;

public interface RegisterDAO {
	public void saveRegister(RegisterEntity entity) throws DAOException;

}
