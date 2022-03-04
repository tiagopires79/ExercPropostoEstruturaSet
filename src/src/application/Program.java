package application;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import model.entities.Course;
import model.entities.Instructor;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		Course course = null;
		Student student = null;
		
		Set<Course> courses = new TreeSet<>();
		Set<Student> students = null;
		
		try{
			System.out.print("How many instructors? ");
			int totalInstructors = input.nextInt();
			input.nextLine();
			for(int i=1;i <= totalInstructors;i++) {
				System.out.print("Enter with instructor name number " + i + ": ");
				String instructorName = input.nextLine();
				Instructor instructor = new Instructor(instructorName);
						
			    System.out.print("How many courses for instructor " + instructorName + "? ");
				int totalCourses = input.nextInt();
				input.nextLine();
				String courseName;
				for(int j=1;j <= totalCourses;j++) {				
					System.out.print("Enter with course name number "+ j + " in the instructor " + instructorName + ": ");
					courseName = input.nextLine();
					course = new Course(courseName, instructor);
	
					System.out.print("How many students for course " + courseName + " in the instructor " + instructorName + "? ");
					int totalStudents = input.nextInt();				
					students = new HashSet<>();
					for (int z = 1; z <= totalStudents; z++) {					
						System.out.print("Enter student number " + z + " in the course " + courseName + " and instructor " + instructorName + ": ");
						int studentNumber = input.nextInt();
						student = new Student(studentNumber);
						students.add(student); // Adicionando estudantes à lista de estudantes										
					}
					input.nextLine();
					course.setStudent(students);// Adicionando lista de estudantes ao curso				
					courses.add(course); // adicionando curso à lista de cursos	
					for(Course c : courses) {
						System.out.print(c + "\n");
						//System.out.print();
					}
					students = new HashSet<>();
				}							
			}		
			//input.nextLine();
			char response;
			System.out.println();
			do {
				Set<Instructor> instructors = new HashSet<>();
				System.out.print("Instructors List: ");
				instructors.addAll(course.getInstructor().instructorList(courses));
				for(Instructor i : instructors) {
					System.out.print(i.getName() + ", ");				
				}
				System.out.println();
				
				System.out.print("Pesquisar total de alunos para qual instrutor da lista acima? ");
				String instructorName = input.nextLine();
				
				//Obtem lista de estudantes do instrutor
				students = student.totalStudentPerInstructor(instructorName, courses);
				
			    
			    System.out.print("Total studants instructor " + instructorName + ": "+ students.size());
			    
			    System.out.print("Pesquisar other Instructors (s/n)?");
			    response = input.next().charAt(0);	
			} while (response == 's');
		}
		catch(InputMismatchException e){
			e.getMessage();
		}
	    finally {
	    	input.close();
		}	    
	}
}


