
public class Main {
	public static void main(String[] args) {
		Course desagil =  new Course();
		Student Rapha = new Student(1,"Raphael");
		Student Fred = new Student(2,"Fred");
		desagil.enroll(Rapha);
		desagil.enroll(Fred);
		
		desagil.setGrade(1, 8);
		desagil.setGrade(2, 9);
		desagil.printReport();
		
	}

}
