# Zadatak 1

Napraviti javnu klasu **Polazak** u paketu **autobuska_stanica** koja ima:
- Privatni atribut **destinacija** (npr. “Novi Sad”).
- Privatne atribute **sat** i **minut** koji predstavljaju sat i minut u danu polaska.
- Privatni atribut **brojSlobodnihMesta** koji predstavlja broj slobodnih mesta za taj polazak.
- Odgovarajuće **javne get i set metode** za ove atribute. Atribut destinacija ne sme biti null, niti prazan String. Atribut sat može biti samo u granicama od 0 do 24, a atribut minut u granicama od 0 do 60. U slučaju unosa ovih nedozvoljenih vrednosti, baciti neproveravani izuzetak sa odgovarajućom porukom.
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase **Polazak**, pa ako nije, vraća FALSE. Metoda vraća TRUE ako su destinacija i vreme jednaki destinaciji i vremenu unetog festivala, a inače FALSE.

Napraviti javni interfejs **RezervacijaKarata** u paketu **autobuska_stanica.rezervacije** koji ima:
- Metodu **unesiPolazak** koja ne vraća ništa, prima kao parametar objekat klase **Polazak** i baca proveravani izuzetak.
- Metodu **rezervisiKarte** koja vraća boolean vrednost, a prima naziv destinacije i broj karata.

Napraviti javnu klasu **AutobuskaStanica** u paketu **autobuska_stanica** koja implementira interfejs **RezervacijaKarata** i ima:
- Privatni atribut **polasci** koji predstavlja listu objekata klase Polazak. Ovu listu je potrebno odmah inicijalizovati.
- Implementiranu javnu metodu **unesiPolazak** koja kao parametar prima objekat klase **Polazak** i unosi ga na prvo mesto u listi. Unošenje se vrši samo ako uneti objekat nije NULL i ako u listi ne postoji isti takav polazak. U suprotnom, baciti proveravani izuzetak sa porukom o grešci.
- Implementiranu javnu metodu **rezervišiKarte** koja na osnovu unete destinacije pronalazi polazak za tu destinaciju (u bilo koje vreme) i proverava da li na tom polasku ima dovoljno mesta da može da se rezerviše uneti broj karata. Ako ima, metoda smanjuje broj slobodnih mesta za broj karata i vraća TRUE. Ako nema, traži se neki drugi polazak za tu destinaciju i cela procedura se ponavlja. Ako ni na jednom polasku za tu destinaciju nema dovoljno mesta, metoda vraća FALSE.

Napraviti vizuelnu klasu **AutobuskaStanicaGUI** u paketu **autobuska_stanica.gui** koja izgleda kao na slici. Naslov prozora bi trebalo da bude "Autobuska stanica". Podesiti grafički interfejs tako da se u toku rada aplikacije ne mogu menjati dimenzije forme.
- Klasa AutobuskaStanicaGUI bi trebalo da sadrži privatni atribut **stanica** koji predstavlja objekat klase AutobuskaStanica. Odmah inicijalizovati objekat.
- Kada se pritisne dugme "Obrisi", briše se sadržaj svih elemenata u delu forme UNOS.
- Kada se pritisne dugme "Dodaj", preuzimaju se svi podaci o polasku iz polja za unos u delu forme UNOS, kreira se objekat klase **Polazak** i dodaje u stanicu (atribut **stanica**). Ukoliko se desi greška prilikom isčitavanja podataka sa forme ili prilikom dodavanja polaska u stanicu, ispisati odgovarajuću poruku u novom prozoru. U slučaju da je unos uspešan, ispisati u novom prozoru poruku "Polazak je uspesno dodat".
- Kada se pritisne dugme "Rezervisi", preuzimaju se podaci o destinaciji i broju karata i vrši se rezervacija na atributu **stanica**. Ukoliko je rezervacija uspešno obavljena, ispisati u novom prozoru poruku "Rezervacija uspesno obavljena". U suprotnom, ispisati poruku "Rezervacija nije uspela".

![Alt text](../images/prozor.jpg?raw=true "Title")
