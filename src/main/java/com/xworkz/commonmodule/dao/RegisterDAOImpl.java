package com.xworkz.commonmodule.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		logger.info("invoked setFactory.....");
		this.factory = factory;
	}

	public void saveRegister(RegisterEntity entity) {
		logger.info("invoked saveRegister");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(entity);
			if (Objects.nonNull(entity)) {
				logger.info("Register data save...");
			} else {
				logger.info("Register data save...");
			}
			session.getTransaction().commit();
		} catch (HibernateException h) {
			logger.error(h.getMessage(), h);
			session.getTransaction().rollback();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
	}
}
