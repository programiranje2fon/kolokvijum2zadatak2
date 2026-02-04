package varijanta_resenja.autobuska_stanica;

import java.util.LinkedList;
import java.util.List;

import varijanta_resenja.autobuska_stanica.rezervacije.RezervacijaKarata;

public class AutobuskaStanica implements RezervacijaKarata {

	private List<Polazak> polasci = new LinkedList<>();

	public void unesiPolazak(Polazak polazak) throws Exception {
		if (polazak == null) {
			throw new Exception("Greska: Polazak ne sme biti null");
		}

		if (!polasci.contains(polazak)) {
			polasci.add(0, polazak);
		} else {
			throw new Exception("Polazak se vec nalazi u listi");
		}
	}

	@Override
	public boolean rezervisiKarte(String destinacija, int brojKarata) {
		for (Polazak polazak : polasci) {
			if (polazak.getDestinacija().equals(destinacija)
					&& (polazak.getBrojSlobodnihMesta() - brojKarata) >= 0) {

				polazak.setBrojSlobodnihMesta(polazak.getBrojSlobodnihMesta() - brojKarata);
				return true;
			}
		}

		return false;
	}

}