package com.crud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.crud.CruDbySpringBootApplication;
import com.crud.entity.Student;

@Repository
public class StudentDao {
  
	@Autowired
	SessionFactory sf;

	public String insertData(Student s) {
		Session ss=sf.openSession();
		Transaction ts=ss.beginTransaction();
		
		ss.persist(s);
		
		ts.commit();
		ss.close();
		return "Data is inserted";
	}
	
	public String deleteData(int id) {
		Session ss= sf.openSession();
		Transaction ts =ss.beginTransaction();
		
		Student s1=ss.get(Student.class, id);
		ss.remove(s1);
		ts.commit();
		ss.close();
		
		
		return "Data is deleted";
	}
	
	public String updateData(Student s, int id) {
		Session ss=sf.openSession();
		Transaction ts=ss.beginTransaction();
		
		Student s1=ss.get(Student.class, id);
		s1.setName(s.getName());
		s1.setCity(s.getCity());
		
		ss.merge(s1);
		ts.commit();
		ss.close();
		return "Data updated";
	}
	
	public Student fetchSingleRecord( int id) {
		Session ss=sf.openSession();
		Transaction ts=ss.beginTransaction();
		
		Student s1=ss.get(Student.class, id);
		
		
		ts.commit();
		ss.close();
		return s1;
	}
	
	
}
