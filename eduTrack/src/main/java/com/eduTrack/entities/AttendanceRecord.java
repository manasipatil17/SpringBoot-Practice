package com.eduTrack.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class AttendanceRecord {
    @Id
	private String id;
    
    @ManyToOne
    @JoinColumn(name = "faculty")
	private User user;
    
	private int numberOfStudents;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	private String date;
	private String time;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "attendance_students",
        joinColumns = @JoinColumn(name = "attendance_record_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

	public AttendanceRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceRecord(String id, User user, int numberOfStudents, Subject subject, String date, String time,
			List<Student> students) {
		super();
		this.id = id;
		this.user = user;
		this.numberOfStudents = numberOfStudents;
		this.subject = subject;
		this.date = date;
		this.time = time;
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "AttendanceRecord [id=" + id + ", user=" + user + ", numberOfStudents=" + numberOfStudents + ", subject="
				+ subject + ", date=" + date + ", time=" + time + ", students=" + students + "]";
	}
	
	

}
