import java.util.Iterator;
import java.util.LinkedList;

public class Course {
	
	private LinkedList<Enrollment> enrollments = new LinkedList<>();
	
	void enroll(Student student) {
		Enrollment enroll1 = new Enrollment(student.getId(), student.getName());
		enrollments.add(enroll1);
	}
	
	void setGrade(int idAluno , double nota) {
		for(int i = 0 ; i < enrollments.size(); i++) {
			if(enrollments.get(i).getId() == idAluno) {
				enrollments.get(i).setFinalGrade(nota);
				break;
			}
		}
	}
	
	void printReport() {
		for(int i = 0 ; i < enrollments.size(); i++) {
			System.out.println("Nome: "+enrollments.get(i).getName()+" id: "+ enrollments.get(i).getId()+" Nota: "+enrollments.get(i).getFinalGrade());
		
		}
		
	}
	
	
	
	

}
