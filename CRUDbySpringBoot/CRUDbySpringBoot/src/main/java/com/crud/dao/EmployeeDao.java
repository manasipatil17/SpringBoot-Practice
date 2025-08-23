package com.crud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sf;
	Session ss=null;
	Transaction ts=null;
	String msg;
	public String insertData(Employee e) {
		
		
		try {
		 ss=sf.openSession();
	     ts=ss.beginTransaction();
		ss.persist(e);
		msg = "Data is inserted";
		ts.commit();
		}
		catch(Exception e1) {
			if(ts!=null) {
				ts.rollback();
			}
		}
			
			finally {
				ss.close();
			}

	
		
		return msg;
	}
}
