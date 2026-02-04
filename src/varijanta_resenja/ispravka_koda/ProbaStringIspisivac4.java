package varijanta_resenja.ispravka_koda;

import java.util.LinkedList;
import java.util.List;

public class ProbaStringIspisivac4 {

	public static void main(String[] args) {
		List<String> lista = new LinkedList<>();
		lista.add("BELO");
		lista.add("CRNO");
		lista.add("ZUTO");
		lista.add("SIVO");
		
		StringIspisivac4.ispisiParalelogram(lista);
	}
}
