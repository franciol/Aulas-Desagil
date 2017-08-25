import java.util.LinkedList;

public class Course {
	
	private LinkedList<Enrollment> enrollments = new LinkedList<>();
	private LinkedList<InsaneEnrollment> insaneEnrollments = new LinkedList<>();
	
	void enroll(Student student) {
		Enrollment enroll1 = new Enrollment(student.getId(), student.getName());
		enrollments.add(enroll1);
	}
	
	void enrollInsane(Student student, double penalty) {
		InsaneEnrollment insaneEnroll1 = new InsaneEnrollment(student.getId(), student.getName(), penalty);
		insaneEnrollments.add(insaneEnroll1);
	}
	
	void setGrade(int idAluno , double nota) {
		for(int i = 0 ; i < enrollments.size(); i++) {
			if(enrollments.get(i).getId() == idAluno) {
				enrollments.get(i).setFinalGrade(nota);
				break;
			}
		}
	}
	void setInsaneGrade(int idAluno , double nota) {
		for(int i = 0 ; i < insaneEnrollments.size(); i++) {
			if(insaneEnrollments.get(i).getId() == idAluno) {
				insaneEnrollments.get(i).setFinalGrade(nota);
				break;
			}
		}
	}
	
	void printReport() {
		for(int i = 0 ; i < enrollments.size(); i++) {
			System.out.println("Nome: "+enrollments.get(i).getName()+" id: "+ enrollments.get(i).getId()+" Nota: "+enrollments.get(i).getFinalGrade());
			}
		}
		
		void printInsaneReport() {
			for(int i = 0 ; i < insaneEnrollments.size(); i++) {
				System.out.println("Nome: "+insaneEnrollments.get(i).getName()+" id: "+ insaneEnrollments.get(i).getId()+" Nota: "+insaneEnrollments.get(i).getFinalGrade());
			
			}
		
	}
	
	
	
	

}
