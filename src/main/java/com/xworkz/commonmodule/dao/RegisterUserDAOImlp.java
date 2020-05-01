package com.xworkz.commonmodule.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Repository
public class RegisterUserDAOImlp implements RegisterUserDAO {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		logger.info("invoked setFactory....");
		this.factory = factory;
	}

	public RegisterUserDAOImlp() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public boolean validUserId(String userId) {
		logger.info("invoked validUserId....");
		Session session = factory.openSession();
		String hql = "select register from RegisterEntity register where register.userId='" + userId + "'";
		Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);
		// query.setParameter(0, userId);
		RegisterEntity result = query.setMaxResults(1).uniqueResult();
		if (result == null)
			return true;
		else
			return false;
	}

	public boolean validEmail(String email) {
		System.out.println("invoked validEmail....");
		Session session = factory.openSession();
		String hql = "select register from RegisterEntity register where register.email='" + email + "'";
		Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);
		// query.setParameter(0, email);
		RegisterEntity result = query.setMaxResults(1).uniqueResult();
		if (result == null)
			return true;
		else
			return false;
	}
}
