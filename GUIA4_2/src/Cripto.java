
public class Cripto {
	
	String criptografar(String string) {
		String novaString = new String();
		for (int i = 0 ; i < string.length(); i++) {
			char atual = string.charAt(i);
			int atualInt = (int) atual;
			if (atualInt <= 90 && atualInt >= 65) {
				//maiuscula
				if (atualInt < 68) {
					atualInt += 13;
				}
				else {
					atualInt -= 13;
				}
				
			}
			else if (atualInt >= 97 && atualInt <= 122) {
				//Minuscula
				if (atualInt < 110) {
					atualInt += 13;
				}
				else {
					atualInt -= 13;
		
				}
		
			}
			
			char novo = (char) atualInt;
			novaString += novo;
			
			
			
		}
		return novaString;
		
	}
	
	void traduzir() {
		
	}
}
