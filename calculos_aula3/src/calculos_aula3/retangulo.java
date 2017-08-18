package calculos_aula3;

import java.util.Scanner;

public class retangulo {
		
	
	int a,b;
	
	
	
	
	int calcPerimetro(){
		int perimetro;
		perimetro = (2*a) + (2*b);
		return perimetro;	
	}
	
	int calcArea() {
		int area;
		area = a*b;
		return area;
	}

}

