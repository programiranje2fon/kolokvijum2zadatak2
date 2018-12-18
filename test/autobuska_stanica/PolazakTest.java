package autobuska_stanica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class PolazakTest {

	private Polazak instance;

	@Before
	public void setUp() throws Exception {
		instance = new Polazak();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_destinacija() {
		assertTrue("U klasi nije definisan atribut destinacija", TestUtil.doesFieldExist(Polazak.class, "destinacija"));
	}
	
	@Test
	public void atribut_destinacija_vidljivost() {
		assertTrue("Atribut destinacija nije privatan", TestUtil.hasFieldModifier(Polazak.class, "destinacija", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_vreme() {
		assertTrue("U klasi nije definisan atribut vreme", TestUtil.doesFieldExist(Polazak.class, "vreme"));
	}
	
	@Test
	public void atribut_vreme_vidljivost() {
		assertTrue("Atribut vreme nije privatan", TestUtil.hasFieldModifier(Polazak.class, "vreme", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_brojSlobodnihMesta() {
		assertTrue("U klasi nije definisan atribut brojSlobodnihMesta", TestUtil.doesFieldExist(Polazak.class, "brojSlobodnihMesta"));
	}
	
	@Test
	public void atribut_brojSlobodnihMesta_vidljivost() {
		assertTrue("Atribut brojSlobodnihMesta nije privatan", TestUtil.hasFieldModifier(Polazak.class, "brojSlobodnihMesta", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setDestinacija() throws Exception {
		instance.setDestinacija("Pirot");
		String destinacija = (String) TestUtil.getFieldValue(instance, "destinacija");
		assertEquals("Nakon poziva metode setDestinacija(String) sa prosledjenim parametrom \"Pirot\", vrednost atributa destinacija se nije promenila na tu vrednost", "Pirot", destinacija);
	}
	
	@Test(expected = RuntimeException.class)
	public void metoda_setDestinacija_null() throws Exception {
		instance.setDestinacija(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void metoda_setDestinacija_prazanString() throws Exception {
		instance.setDestinacija("");
	}
	
	@Test
	public void metoda_getDestinacija() {
		String destinacija = (String) TestUtil.getFieldValue(instance, "destinacija");

		assertEquals("Metoda getDestinacija ne vraca vrednost atributa destinacija", destinacija, instance.getDestinacija());
	}
	
	@Test
	public void metoda_setVreme() {
		GregorianCalendar ocekivanoVreme = new GregorianCalendar();
		ocekivanoVreme.set(GregorianCalendar.DAY_OF_MONTH, ocekivanoVreme.get(GregorianCalendar.DAY_OF_MONTH) + 3);
		
		instance.setVreme(ocekivanoVreme);
		GregorianCalendar vreme = (GregorianCalendar) TestUtil.getFieldValue(instance, "vreme");
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss.SSS");
		assertEquals("Nakon poziva metode setVreme(GregorianCalendar) sa prosledjenim datumom \""+formater.format(ocekivanoVreme.getTime())+"\", vrednost atributa vreme se nije promenila na tu vrednost", ocekivanoVreme, vreme);
	}
	
	@Test(expected = RuntimeException.class)
	public void metoda_setVreme_null() {
		instance.setVreme(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void metoda_setVreme_prazanString() {
		GregorianCalendar vreme = new GregorianCalendar();
		vreme.set(GregorianCalendar.DAY_OF_MONTH, vreme.get(GregorianCalendar.DAY_OF_MONTH) - 1);
		instance.setVreme(vreme);
	}
	
	@Test
	public void metoda_getVreme() {
		GregorianCalendar vreme = (GregorianCalendar) TestUtil.getFieldValue(instance, "vreme");
		
		assertEquals("Metoda getVreme() ne vraca vrednost atributa vreme", vreme, instance.getVreme());
	}
	
	@Test
	public void metoda_setBrojSlobodnihMesta() {
		instance.setBrojSlobodnihMesta(10);
		int brojSlobodnihMesta = (int) TestUtil.getFieldValue(instance, "brojSlobodnihMesta");
		assertEquals("Nakon poziva metode setBrojSlobodnihMesta(int) sa prosledjenim argumentom \"10\", vrednost atributa brojSlobodnihMesta se nije promenila na tu vrednost", 10, brojSlobodnihMesta);
	}
	
	@Test(expected = RuntimeException.class)
	public void metoda_setBrojSlobodnihMesta_manjeOdNule() {
		instance.setBrojSlobodnihMesta(-1);
	}
	
	@Test
	public void metoda_getBrojSlobodnihMesta() {
		int brojSlobodnihMesta = (int) TestUtil.getFieldValue(instance, "brojSlobodnihMesta");
		
		assertEquals("Metoda getBrojSlobodnihMesta() ne vraca vrednost atributa brojSlobodnihMesta", brojSlobodnihMesta, instance.getBrojSlobodnihMesta());
	}
	
	@Test
	public void metoda_equals_nijeDobraKlasa() {
		assertFalse("Metoda equals() ne vraca false ako se prosledi objekat druge klase.", instance.equals(new Object()));
	}
	
	@Test
	public void metoda_equals_isti() {
		GregorianCalendar vreme = new GregorianCalendar();
		vreme.set(GregorianCalendar.DAY_OF_MONTH, vreme.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		instance.setDestinacija("Pirot");
		instance.setVreme(vreme);
		instance.setBrojSlobodnihMesta(10);
		
		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme);
		p1.setBrojSlobodnihMesta(10);
		
		assertEquals("Metoda equals() ne vraca vrednost true za prosledjeni polazak sa istom destinacijom i vremenom.", p1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitaDestinacija() {
		GregorianCalendar vreme = new GregorianCalendar();
		vreme.set(GregorianCalendar.DAY_OF_MONTH, vreme.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		instance.setDestinacija("Pirot");
		instance.setVreme(vreme);
		instance.setBrojSlobodnihMesta(10);
		
		Polazak p1 = new Polazak();
		p1.setDestinacija("Krusevac");
		p1.setVreme(vreme);
		p1.setBrojSlobodnihMesta(10);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjeni polazak sa razlicitom destinacijom.", p1, instance);
	}
	
	
	@Test
	public void metoda_equals_razlicitoVreme() {
		GregorianCalendar vreme1 = new GregorianCalendar();
		vreme1.set(GregorianCalendar.DAY_OF_MONTH, vreme1.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		instance.setDestinacija("Pirot");
		instance.setVreme(vreme1);
		instance.setBrojSlobodnihMesta(10);
		
		GregorianCalendar vreme2 = new GregorianCalendar();
		vreme2.set(GregorianCalendar.DAY_OF_MONTH, vreme2.get(GregorianCalendar.DAY_OF_MONTH) + 2);
		
		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme2);
		p1.setBrojSlobodnihMesta(10);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjeni polazak sa razlicitim vremenom.", p1, instance);
	}
	
}
