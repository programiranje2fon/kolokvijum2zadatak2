package autobuska_stanica;

import java.util.GregorianCalendar;

public class Polazak {

	private String destinacija;
	private GregorianCalendar vreme;
	private int brojSlobodnihMesta;

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		if ((destinacija == null) || destinacija.isEmpty()) {
			throw new RuntimeException("Greska: Destinacija ne sme biti null ili prazan string!");
		} else {
			this.destinacija = destinacija;
		}
	}

	public GregorianCalendar getVreme() {
		return vreme;
	}

	public void setVreme(GregorianCalendar vreme) {
		if ((vreme == null) || vreme.before(new GregorianCalendar())) {
			throw new RuntimeException("Greska: Vreme ne sme biti null ili trenutak u proslosti!");
		} else {
			this.vreme = vreme;
		}
	}

	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		if (brojSlobodnihMesta <= 0) {
			throw new RuntimeException("Greska: Broj slobodnih mesta ne sme biti negativan broj!!");
		} else {
			this.brojSlobodnihMesta = brojSlobodnihMesta;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Polazak))
			return false;

		Polazak p = (Polazak) obj;

		return this.destinacija.equals(p.destinacija) && this.vreme.equals(p.vreme);
	}
}
