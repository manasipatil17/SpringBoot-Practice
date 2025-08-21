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
}
