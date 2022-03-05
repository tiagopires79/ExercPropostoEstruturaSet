package model.entities;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private Integer number;
	
	public  Student() {		
	}

	public Student(Integer number) {		
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Set<Student> totalStudentPerInstructor(String instructorName, Set<Course> courses) {
		Instructor newInstructor = new Instructor(instructorName);
		Set<Instructor> instructorList = newInstructor.instructorList(courses);	
		
		if(!instructorList.contains(newInstructor)) {
			throw new IllegalArgumentException("Instructor not exits");
		}
		else if(courses.isEmpty() || instructorName == null) {
			throw new IllegalArgumentException("List can´t be empty");
		}
		Set<Student> students = new HashSet<>();
		for (Course c : courses) {
			if (c.getInstructor().equals(newInstructor)) {				
				students.addAll(c.getStudent());
			}					
		}		
		return students;		
	}
	
	@Override
	public String toString() {
		return "Student [number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}	
}
