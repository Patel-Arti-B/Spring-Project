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
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		System.out.println("invoked setFactory..");
		this.factory = factory;
	}

	public RegisterEntity getByEmail(String email) {
		System.out.println("invoked getByEmail");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "select entity from RegisterEntity entity where entity.email=" + "'" + email + "'";
			Query query = session.createQuery(hql);

			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity:" + entity);
			if (entity != null) {
				System.out.println("Email and Password matching...");
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
		return entity;
	}

	public Integer updateCount(int noOfCount, int id) {
		System.out.println("invoked updateCount.....");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity login set login.count='" + noOfCount + "' where login.id='" + id + "'";
			Query query = session.createQuery(hql);
			
			int count = query.executeUpdate();
			System.out.println("Count result:" + count);
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException h) {
			h.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}
}
