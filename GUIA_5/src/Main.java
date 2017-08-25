
public class Main {
	public static void main(String[] args) {
		Course desagil =  new Course();
		Student Rapha = new Student(1,"Raphael");
		Student Fred = new Student(2,"Fred");
		desagil.enrollInsane(Rapha, 0.7);
		desagil.enrollInsane(Fred, 0.5556);
		
		desagil.setInsaneGrade(1, 9);
		desagil.setInsaneGrade(2, 9);
		desagil.printInsaneReport();
		
	}

}
