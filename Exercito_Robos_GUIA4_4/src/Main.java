import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedList<Command> historicos = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		Date data = new Date();
		while (true) {
			System.out.println("Escreva seu comando: ");
			String comand = sc.nextLine();
			if (comand.equals("")) {
				for (int i = historicos.size()-1 ; i >= 0 ; i--) {
					
					System.out.println(historicos.get(i).getcommand());
				}
				
				break;
			}
			else {
				Command comando = new Command();
				comando.inicializar(comand, data.getDay());
				historicos.add(comando);
			}
				
		}
	}
}
