package autobuska_stanica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class AutobuskaStanicaTest {

	private AutobuskaStanica instance;

	@Before
	public void setUp() throws Exception {
		instance = new AutobuskaStanica();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_polasci() {
		assertTrue("U klasi nije definisan atribut polasci", TestUtil.doesFieldExist(AutobuskaStanica.class, "polasci"));
	}

	@Test
	public void atribut_polasci_vidljivost() {
		assertTrue("Atribut polasci nije privatan", TestUtil.hasFieldModifier(AutobuskaStanica.class, "polasci", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_unesiPolazak() throws Exception {
		GregorianCalendar vreme = new GregorianCalendar();
		vreme.set(GregorianCalendar.DAY_OF_MONTH, vreme.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme);
		p1.setBrojSlobodnihMesta(10);
		
		Polazak p2 = new Polazak();
		p2.setDestinacija("Krusevac");
		p2.setVreme(vreme);
		p2.setBrojSlobodnihMesta(20);
		
		instance.unesiPolazak(p1);
		instance.unesiPolazak(p2);
		
		@SuppressWarnings("unchecked")
		List<Polazak> polasci = (List<Polazak>) TestUtil.getFieldValue(instance, "polasci");
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss.SSS");
		
		assertEquals("Kada se u listu dodaju polasci: Pirot ("+formater.format(vreme.getTime())+") - 10 mesta i Krusevac ("+formater.format(vreme.getTime())+") - 20 mesta, prvi u listi nije polazak za Krusevac", p2, polasci.get(0));
		assertEquals("Kada se u listu dodaju polasci: Pirot ("+formater.format(vreme.getTime())+") - 10 mesta i Krusevac ("+formater.format(vreme.getTime())+") - 20 mesta, drugi u listi nije polazak za Pirot", p1, polasci.get(1));
	}
	
	@Test(expected = Exception.class)
	public void metoda_unesiPolazak_dvaIsta() throws Exception {
		GregorianCalendar vreme = new GregorianCalendar();
		vreme.set(GregorianCalendar.DAY_OF_MONTH, vreme.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme);
		p1.setBrojSlobodnihMesta(10);
		
		instance.unesiPolazak(p1);
		instance.unesiPolazak(p1);
	}
	
	@Test
	public void metoda_rezervisiKarte_imaMesta() throws Exception {
		GregorianCalendar vreme1 = new GregorianCalendar();
		vreme1.set(GregorianCalendar.DAY_OF_MONTH, vreme1.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme1);
		p1.setBrojSlobodnihMesta(10);
		
		GregorianCalendar vreme2 = new GregorianCalendar();
		vreme2.set(GregorianCalendar.DAY_OF_MONTH, vreme2.get(GregorianCalendar.DAY_OF_MONTH) + 2);
		
		Polazak p2 = new Polazak();
		p2.setDestinacija("Pirot");
		p2.setVreme(vreme2);
		p2.setBrojSlobodnihMesta(5);
		
		Polazak p3 = new Polazak();
		p3.setDestinacija("Nova Varos");
		p3.setVreme(vreme2);
		p3.setBrojSlobodnihMesta(7);
		
		instance.unesiPolazak(p1);
		instance.unesiPolazak(p2);
		instance.unesiPolazak(p3);
		
		boolean ishodRezervacije = instance.rezervisiKarte("Pirot", 9);
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss.SSS");

		assertTrue("Kada se u autobuskoj stanici nalaze sledeci polasci: Pirot ("+formater.format(p1.getVreme().getTime())+") - 10 mesta, Pirot ("+formater.format(p2.getVreme().getTime())+") - 5 mesta i Nova Varos ("+formater.format(p3.getVreme().getTime())+") - 7 mesta, rezervacija za Pirot za 9 karata nije uspesna.",
				ishodRezervacije);
	}
	
	@Test
	public void metoda_rezervisiKarte_nemaMesta() throws Exception {
		GregorianCalendar vreme1 = new GregorianCalendar();
		vreme1.set(GregorianCalendar.DAY_OF_MONTH, vreme1.get(GregorianCalendar.DAY_OF_MONTH) + 1);

		Polazak p1 = new Polazak();
		p1.setDestinacija("Pirot");
		p1.setVreme(vreme1);
		p1.setBrojSlobodnihMesta(10);
		
		GregorianCalendar vreme2 = new GregorianCalendar();
		vreme2.set(GregorianCalendar.DAY_OF_MONTH, vreme2.get(GregorianCalendar.DAY_OF_MONTH) + 2);
		
		Polazak p2 = new Polazak();
		p2.setDestinacija("Pirot");
		p2.setVreme(vreme2);
		p2.setBrojSlobodnihMesta(5);
		
		Polazak p3 = new Polazak();
		p3.setDestinacija("Nova Varos");
		p3.setVreme(vreme2);
		p3.setBrojSlobodnihMesta(7);
		
		instance.unesiPolazak(p1);
		instance.unesiPolazak(p2);
		instance.unesiPolazak(p3);
		
		boolean ishodRezervacije = instance.rezervisiKarte("Nova Varos", 9);
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss.SSS");

		assertFalse("Kada se u autobuskoj stanici nalaze sledeci polasci: Pirot ("+formater.format(p1.getVreme().getTime())+") - 10 mesta, Pirot ("+formater.format(p2.getVreme().getTime())+") - 5 mesta i Nova Varos ("+formater.format(p3.getVreme().getTime())+") - 7 mesta, rezervacija za Nova Varos za 9 karata nije uspesna.",
				ishodRezervacije);
	}
}
