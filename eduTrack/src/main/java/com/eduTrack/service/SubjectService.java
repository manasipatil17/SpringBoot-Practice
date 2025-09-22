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
}
