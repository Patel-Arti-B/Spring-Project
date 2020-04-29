package com.xworkz.commonmodule.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.entity.RegisterEntity;

@Repository
public class ForgotDAOImpl implements ForgotDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		System.out.println("invoked setFactory......");
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getForgotByEmail(String email) {
		System.out.println("invoked get forgot by email...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "from RegisterEntity where email='" + email + "'";

			Query query = session.createQuery(hql);
			System.out.println("Query created...." + query);

			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity:" + entity);
			if (entity != null) {
				System.out.println("Email match");
				return entity;
			} else {
				return null;
			}
		} catch (HibernateException h) {
			session.getTransaction().rollback();
			h.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	public int updateCountForgot(String password, int countNo, int id) {
		System.out.println("invoked updateCountForgot......");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity forgot set forgot.password='" + password + "',forgot.count='" + countNo
					+ "'where forgot.id='" + id + "'";
			Query query = session.createQuery(hql);
			System.out.println("update query creted...");

			query.executeUpdate();
			System.out.println("Count result");
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException h) {
			session.getTransaction().rollback();
			h.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}
}
