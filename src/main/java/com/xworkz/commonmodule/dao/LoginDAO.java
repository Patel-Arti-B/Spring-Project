package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.entity.RegisterEntity;

public interface LoginDAO {
	public RegisterEntity getByEmail(String email);

	public Integer updateCount(int noOfCount, int id);
}
