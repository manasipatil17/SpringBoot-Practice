package com.eduTrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduTrack.dao.SubjectDao;
import com.eduTrack.entities.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDao dao;
	
	public Subject createSubject(Subject subject) {
		return dao.createSubject(subject);
	}
	
	public String deleteSubject(long id) {
		return dao.deleteSubject(id);
	}
	
public Subject updateSubject(Subject subject, long id) {
		
		return dao.updateSubject(subject, id);
	}

}

