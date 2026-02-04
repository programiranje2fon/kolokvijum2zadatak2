package ispravka_koda;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringIspisivac4Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));		
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void metoda_ispisiParalelogram() {
		List<String> lista = new LinkedList<>();
		lista.add("BELO");
		lista.add("CRNO");
		lista.add("ZUTO");
		lista.add("SIVO");

		String ocekivaniIspis = 
				"*BELO*" + System.lineSeparator() +
				" C    Z" + System.lineSeparator() +
				"  R    U" + System.lineSeparator() +
				"   N    T" + System.lineSeparator() +
				"    O    O" + System.lineSeparator() +
				"     *SIVO*"+ System.lineSeparator();
		
		StringIspisivac4.ispisiParalelogram(lista);
		
		assertEquals("NE ispisuju se reci u obliku paralelograma.", ocekivaniIspis, outContent.toString());
	}
}
