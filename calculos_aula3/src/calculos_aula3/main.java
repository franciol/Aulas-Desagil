package calculos_aula3;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		retangulo rect = new retangulo();
		System.out.println("Lado A: ");
		rect.a = sc.nextInt();
		System.out.println("Lado B: ");
		rect.b = sc.nextInt();
		
		System.out.println("Area do retangulo é: " + rect.calcArea());
		System.out.println("Perimetro do retangulo é: "+ rect.calcPerimetro());
		
		Prisma prisma = new Prisma();
		
		System.out.println("Altura do prisma: ");
		prisma.altura = sc.nextInt();
		prisma.base = rect;
		
		System.out.println("Volume do Prisma: " + prisma.calcVolume());
		
		
		
	}

}
