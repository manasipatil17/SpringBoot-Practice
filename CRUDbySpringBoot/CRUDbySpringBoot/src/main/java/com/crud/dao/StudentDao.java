package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.crud.CruDbySpringBootApplication;
import com.crud.entity.Student;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


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
	
//	public void fetchAllRecords(Student s) {
//		Session ss= sf.openSession();
//		Transaction ts = ss.beginTransaction();
//		
//		HibernateCriteriaBuilder cb= ss.getCriteriaBuilder();
//		CriteriaQuery<Object> cq= cb.createQuery();
//		Root<Student> r= cq.from(Student.class);
//		cq.select(r);
//		Query<Object> q=ss.createQuery(cq);
//		List<Object> l=q.getResultList();
//		
//		for (Student s : l) {
//			
//		}
//		
//	}
	
	
}
