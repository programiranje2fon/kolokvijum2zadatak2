package varijanta_resenja.autobuska_stanica.rezervacije;

import varijanta_resenja.autobuska_stanica.Polazak;

public interface RezervacijaKarata {
	
	void unesiPolazak(Polazak polazakZaUnos) throws Exception;
	boolean rezervisiKarte(String destinacija, int brojKarata);
}
