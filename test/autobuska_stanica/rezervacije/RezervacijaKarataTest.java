package autobuska_stanica.rezervacije;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import autobuska_stanica.Polazak;
import test.TestUtil;

public class RezervacijaKarataTest {

	@Test
	public void metoda_unesiPolazak() {
		assertTrue("U interfejsu nije definisana metoda unesiPolazak(Polazak)", TestUtil.doesMethodExist(RezervacijaKarata.class, "unesiPolazak", new Class<?>[]{Polazak.class}));
	}
	
	@Test
	public void metoda_rezervisiKarte() {
		assertTrue("U interfejsu nije definisana metoda rezervisiKarte()", TestUtil.doesMethodExist(RezervacijaKarata.class, "rezervisiKarte", new Class<?>[]{String.class, int.class}));
	}
}
