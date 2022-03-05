package model.entities;

import java.util.HashSet;
import java.util.Set;

public class Instructor {
	
	private String name;
	
	public Instructor() {		
	}
	
	public Instructor(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	@Override
	public String toString() {
		return "Instructor [name=" + name + "]";
	}

	public Set<Instructor> instructorList(Set<Course> courses){
		if(courses.isEmpty()) {
			throw new IllegalArgumentException("List can´t be empty");
		}
		Set<Instructor> instructors = new HashSet<>();
		for (Course c : courses) {
			instructors.add(c.getInstructor());				
		}		
		return instructors;
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Instructor other = (Instructor) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
