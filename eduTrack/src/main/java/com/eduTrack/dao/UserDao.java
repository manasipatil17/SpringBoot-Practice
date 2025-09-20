package com.eduTrack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduTrack.entities.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory factory;
	
	public User registerUser(User user) {
		Session session = null;
		User user2 = null;
		try {
			session = factory.openSession();
			user2 = session.get(User.class, user.getUsername());
			if (user2 == null) {
				session.save(user);
				session.beginTransaction().commit();
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return null;
	}

	
}
