package ispravka_koda;

import java.util.LinkedList;
import java.util.List;

public class TestStringIspisivac4 {

	public static void main(String[] args) {
		List<String> lista = new LinkedList<>();
		lista.add("BELO");
		lista.add("CRNO");
		lista.add("ZUTO");
		lista.add("SIVO");
		
		StringIspisivac4.ispisiParalelogram(lista);
	}
}
