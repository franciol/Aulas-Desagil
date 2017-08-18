import java.util.Date;
import java.util.LinkedList;

public class Command {
	
	private String ordem = new String();
	private Long data;

	
	void inicializar(String ordemInicial, Long dateInicial) {
		ordem = ordemInicial;
		data = dateInicial;
	}
	
	String getcommand() {
		String string = new String(ordem+" "+data);
		return string;
	}

	
	
}
