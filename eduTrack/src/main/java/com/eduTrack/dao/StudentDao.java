package com.eduTrack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eduTrack.entities.Student;

@Repository
public class StudentDao {

    @Autowired
	private SessionFactory factory;
	public Student createStudent(Student student) {
		
		Session session= null;
		Student s = null;
		
		try {
		session = factory.openSession();
		Transaction tr=session.beginTransaction();
		session.persist(student);
		tr.commit();
		s=student;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return s;
	
	}
}
