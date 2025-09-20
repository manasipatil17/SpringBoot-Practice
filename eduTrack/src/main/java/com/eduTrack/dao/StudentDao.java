package com.eduTrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eduTrack.entities.Student;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
	
	public Student getStudentById(long id) {
		
		Session session=null;
		Student student =null;
		
		try {
		session = factory.openSession();
		Transaction ts = session.beginTransaction();
		student =session.get(Student.class, id);
		ts.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return student;
	}
	
	public String updateData(Student s, long id) {
		Session session=null;
		Student s1=null;
		try {
		session=factory.openSession();
		Transaction ts=session.beginTransaction();
		
		s1=session.get(Student.class, id);
		s1.setName(s.getName());
		s1.setEmail(s.getEmail());
		session.merge(s1);
		ts.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return "Data updated";
	}
	
	public List<Student> getAllStudents(){
			Session session = null;
			List<Student> list=null;
			
			try {
			session = factory.openSession();
			Transaction ts = session.beginTransaction();
			 CriteriaBuilder cb=session.getCriteriaBuilder();
		        CriteriaQuery<Object> cq= cb.createQuery();
		        Root<Student> root=cq.from(Student.class);
		        cq.select(root);
		        Query q= session.createQuery(cq);
		        list=q.getResultList();
		        for ( Student stud : list) {
					System.out.println(stud);
				}
		        ts.commit();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
		        session.close();
			}
		        return list;
			
	}
	
}
