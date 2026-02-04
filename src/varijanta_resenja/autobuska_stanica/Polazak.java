package varijanta_resenja.autobuska_stanica;

import java.time.LocalDate;

public class Polazak {

	private String destinacija;
	private LocalDate vreme;
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

	public LocalDate getVreme() {
		return vreme;
	}

	public void setVreme(LocalDate vreme) {
		if ((vreme == null) || vreme.isBefore(LocalDate.now())) {
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
