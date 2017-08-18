import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cripto cripto = new Cripto();

		System.out.println("Escreva aqui sua mensagem: ");
		String recebida = sc.nextLine();
		String codificada = cripto.criptografar(recebida);
		System.out.println("Sua mensagem codificada é: "+ codificada);
		
		
		
	}
}
