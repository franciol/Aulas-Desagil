package aula3;

public class Politician {
	int salary;
	boolean corrupt;
	
		
	void calculateActualSalary() {
		if (corrupt == true) {
			System.out.println("Sal�rio real = " + 10*salary);
		}
		else if (corrupt == false) {
			System.out.println("Sal�rio real = " + salary);
		}
		
	}
}
