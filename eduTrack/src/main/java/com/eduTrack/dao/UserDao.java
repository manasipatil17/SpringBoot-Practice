package com.eduTrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduTrack.entities.Student;
import com.eduTrack.entities.User;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
	
	public User updateUser(User user, String username) {
		
		Session session = null;
		User user1=null;
		
		try {
		session=factory.openSession();
		Transaction ts= session.beginTransaction();
		user1=session.get(User.class, username);
		user1.setFirstname(user.getFirstname());
		user1.setLastname(user.getLastname());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setRole(user.getRole());
		session.merge(user1);
		ts.commit();
		session.close();
		return user1;
		}
		catch(Exception e) {
          e.printStackTrace();
          session.close();
          return null;
		}
	}
	
	public User getUserByUsername(String username) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			user = session.get(User.class, username);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return user;
	}

	public List<User> getAllUser() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			 CriteriaBuilder cb=session.getCriteriaBuilder();
		        CriteriaQuery<Object> cq= cb.createQuery();
		        Root<Student> root=cq.from(Student.class);
		        cq.select(root);
		        Query q= session.createQuery(cq);
		        list=q.getResultList();
		        for ( User user : list) {
					System.out.println(user);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	
}
