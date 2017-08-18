import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedList<Command> historicos = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (true) {
			System.out.println("Escreva seu comando: ");
			String comand = sc.nextLine();
			if (comand == null) {
				System.out.println(historicos);
				break;
			}
			else {
				
				
				
				i++;
			}
				
			
			
		}
	}
}
