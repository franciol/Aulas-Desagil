package calculos_aula3;

public class Prisma {
	
	retangulo base = new retangulo();
	int altura;

	
	
	
	int calcVolume() {
		return altura*base.calcArea();
	}

}
