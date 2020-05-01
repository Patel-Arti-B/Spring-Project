package com.xworkz.commonmodule.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.controller.ForgotController;
import com.xworkz.commonmodule.entity.RegisterEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		logger.info("invoked setFactory..");
		this.factory = factory;
	}

	public RegisterEntity getByEmail(String email) {
		logger.info("invoked getByEmail");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "select entity from RegisterEntity entity where entity.email='" + email + "'";
			Query query = session.createQuery(hql);

			entity = (RegisterEntity) query.uniqueResult();
			logger.info("Entity:" + entity);
			if (entity != null) {
				System.out.println("Email and Password matching...");
				return entity;
			} else {
				return null;
			}
		} catch (HibernateException h) {
			session.getTransaction().rollback();
			logger.error(h.getMessage(), h);
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return entity;
	}

	public Integer updateCount(int noOfCount, int id) {
		logger.info("invoked updateCount.....");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity login set login.count='" + noOfCount + "' where login.id='" + id + "'";
			Query query = session.createQuery(hql);

			int count = query.executeUpdate();
			logger.info("Count result:" + count);
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException h) {
			logger.error(h.getMessage(), h);
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}
}
