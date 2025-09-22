package com.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduTrack.entities.Subject;
import com.eduTrack.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService service;
	
	@PostMapping("/addSubject")
	public Subject createSubject(@RequestBody Subject subject) {
		
		return service.createSubject(subject);
	}
}
