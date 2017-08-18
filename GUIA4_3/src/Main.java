import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0 ; i < 10 ; i++) {
			numeros[i] = 0;
		}
		System.out.println("Digite sua nova senha: ");
		String senha = sc.nextLine();
		boolean certo = true;
		
		for (int j = 0; j < senha.length(); j++) {
			int numeroatual = (int) senha.charAt(j);
			numeroatual -= 48;
			if (numeroatual <= 9 && numeroatual >= 0){
				numeros[numeroatual] += 1;
				
			}
		}
		for (int k = 0; k <10 ; k++) {
			
			if (numeros[k] < 2){
				certo = false;
				break;
			}
		}
		if (certo == true) {
			System.out.println("Parabens pela responsabilidade");
		}
		else {
			System.out.println("Voce esta despedido");
		}
		
		
		
	}

}
