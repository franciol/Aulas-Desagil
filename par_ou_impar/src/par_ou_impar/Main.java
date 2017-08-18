package par_ou_impar;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();
		Random gerador = new Random();
		
		int soma;
		
		int contador = 0;
		while (contador < 10) {
			computador.escolha = gerador.nextInt(11);
			System.out.println("Qual numero de 0 a 10 voce escolhe?");
			jogador.escolha = sc.nextInt();
			soma = computador.escolha + jogador.escolha;
			if ( soma % 2 == 0 ) {
				jogador.pontuacao += 3;
				computador.pontuacao -= 1;
				System.out.println("Essa vitória é sua!!! Sua escolha foi " + jogador.escolha + " e a do computador foi "+ computador.escolha + " totalizando " + soma + " que é par");
			}
			else {
				jogador.pontuacao -= 1;
				computador.pontuacao += 3;
				System.out.println("Essa vitória é do seu oponente!!! Sua escolha foi " + jogador.escolha + " e a do computador foi "+ computador.escolha + " totalizando " + soma + " que é ímpar");
			}
			
			contador += 1;
		}
		
		if (computador.pontuacao > jogador.pontuacao) {
			System.out.println("Voce foi derrotado!!! Sua pontuação final foi " + jogador.pontuacao + " E a do seu oponente foi " + computador.pontuacao);
		}
		else if (computador.pontuacao == jogador.pontuacao) {
			System.out.println("Empate!!! Sua pontuação final foi " + jogador.pontuacao + " E a do seu oponente foi " + computador.pontuacao);
		}
		else {
			System.out.println("Voce ganhou!!! Sua pontuação final foi " + jogador.pontuacao + " E a do seu oponente foi " + computador.pontuacao);
		}
		
		
	}

}
