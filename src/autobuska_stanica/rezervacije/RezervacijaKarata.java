package autobuska_stanica.rezervacije;

import autobuska_stanica.Polazak;

public interface RezervacijaKarata {
	
	void unesiPolazak(Polazak polazakZaUnos) throws Exception;
	boolean rezervisiKarte(String destinacija, int brojKarata);
}
