package com.xworkz.commonmodule.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.entity.RegisterEntity;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		System.out.println("invoked setFactory.....");
		this.factory = factory;
	}

	public void saveRegister(RegisterEntity entity) {
		System.out.println("invoked saveRegister");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(entity);
			if (Objects.nonNull(entity)) {
				System.out.println("Register data save...");
			} else {
				System.out.println("Register data save...");
			}
			session.getTransaction().commit();
		} catch (HibernateException h) {
			h.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
	}
}
