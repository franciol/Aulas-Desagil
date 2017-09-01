
public class Enrollment {
	protected Student student;
	protected double finalGrade;
	
	public Enrollment(int idIn, String nameIn) {
		student = new Student(idIn ,nameIn);
	}
	
	void setFinalGrade(double newFinal) {
		finalGrade = newFinal;
	}
	
	double getFinalGrade() {
		return finalGrade;
	}
	
	int getId() {
		return student.getId();
	}
	
	String getName() {
		return student.getName();
	}

}
