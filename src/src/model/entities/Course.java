package model.entities;

import java.util.Set;
import java.util.TreeSet;

public class Course {
	
	private String name;
	
	private Set<Student> student = new TreeSet<>();
	private Instructor instructor;
	
	public Course() {		
	}
	
	public Course(String name) {
		this.name = name;
	}

	public Course(String name, Instructor instructor) {
		this.name = name;
		this.instructor = instructor;
	}	
	
	public Course(String name, Set<Student> student) {
		this.name = name;
		this.student = student;		
	}

	public Course(String name, Set<Student> student, Instructor instructor) {
		this.name = name;
		this.student = student;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", student=" + student + ", instructor=" + instructor + "]";
	}
}
