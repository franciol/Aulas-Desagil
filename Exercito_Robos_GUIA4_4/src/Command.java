import java.util.Date;
import java.util.LinkedList;

public class Command {
	
	private String ordem = new String();
	private int data;

	
	void inicializar(String ordemInicial, int i) {
		ordem = ordemInicial;
		data = i;
	}
	
	String getcommand() {
		String string = new String(ordem+" "+data);
		return string;
	}

	
	
}
