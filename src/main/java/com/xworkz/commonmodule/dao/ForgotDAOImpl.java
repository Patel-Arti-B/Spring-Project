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
public class ForgotDAOImpl implements ForgotDAO {

	private static final Logger logger = Logger.getLogger(ForgotController.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		logger.info("invoked setFactory......");
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getForgotByEmail(String email) {
		logger.info("invoked get forgot by email...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "from RegisterEntity where email='" + email + "'";

			Query query = session.createQuery(hql);
			logger.info("Query created...." + query);

			entity = (RegisterEntity) query.uniqueResult();
			logger.info("Entity:" + entity);
			if (entity != null) {
				logger.info("Email match");
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
		return null;
	}

	public int updateCountForgot(String password, int countNo, int id) {
		logger.info("invoked updateCountForgot......");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity forgot set forgot.password='" + password + "',forgot.count='" + countNo
					+ "'where forgot.id='" + id + "'";
			Query query = session.createQuery(hql);
			logger.info("update query creted...");

			query.executeUpdate();
			logger.info("Count result");
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException h) {
			session.getTransaction().rollback();
			logger.error(h.getMessage(), h);
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}
}
