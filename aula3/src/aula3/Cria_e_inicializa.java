package aula3;

public class Cria_e_inicializa {
	public static void main(String[] args) {
		Politician carlos = new Politician();
		carlos.salary = 11111;
		carlos.corrupt = true;
		
		
		
		Politician Andre = new Politician();
		Andre.salary = 5000;
		Andre.corrupt = false;
		
		carlos.calculateActualSalary();
		Andre.calculateActualSalary();
		
		
	}

}
