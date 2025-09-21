package com.eduTrack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public String deleteUserById(String username) {
		Session session=null;
		String msg =null;
		
		try {
		session=factory.openSession();
		Transaction ts=session.beginTransaction();
		User user=session.get(User.class, username);
		session.remove(user);
		msg="user row deleted...";
		ts.commit();
		}
		catch(Exception e) {
			msg=null;
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return msg;
	}
	
}
