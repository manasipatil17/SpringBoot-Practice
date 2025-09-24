package com.eduTrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eduTrack.entities.Subject;
import com.eduTrack.entities.User;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class SubjectDao {

	@Autowired
	private SessionFactory factory;
	
	public Subject createSubject(Subject subject) {
		
		Session session =null;
		Subject sub =     null;
		try {
		session=factory.openSession();
		Transaction ts = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
        Root<Subject> root = query.from(Subject.class);
        query.select(root).where(builder.equal(root.get("name"), subject.getName()));

        List<Subject> list = session.createQuery(query).getResultList();
        if (list.isEmpty()) {
            session.persist(subject);
            ts.commit();
            sub = subject;
        }

    } 
	
	catch(Exception e) {
        e.printStackTrace();
    } 
		finally {
        if (session != null) {
            session.close();
        }
    }
    return sub;
	}
	
	public String deleteSubject(long id) {
		
		Session session =null;
		String msg=null;
		
		try {
		session=factory.openSession();
	    Transaction ts =session.beginTransaction();
	    Subject sub=session.get(Subject.class, id);
	    session.remove(sub);
	    msg="row deleted...";
	    ts.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
	    session.close();
		}
	    return msg;
	}
	
	public Subject updateSubject(Subject subject, long id) {
		Session session = null;
		Subject sub=null;
		
		try {
			session =factory.openSession();
			Transaction ts= session.beginTransaction();
			session.get(Subject.class, id);
			sub.setName(subject.getName());
			session.merge(sub);
			ts.commit();
			sub=subject;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return sub;
	}
}
