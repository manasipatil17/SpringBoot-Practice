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
		Transaction ts=session.beginTransaction();
		session.persist(student);
		ts.commit();
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
	
	public String deleteStudent(Long id) {
		Session session=null;
		String msg=null;
		
		try {
		 session= factory.openSession();
		Transaction ts = session.beginTransaction();
		Student student = session.get(Student.class, id);
	   if(student !=null) {
		session.remove(student);
		ts.commit();
		msg="row deleted...";
	   }
	   else {
		   msg="Id not exists...";
	   }
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		return msg;
	}
}
