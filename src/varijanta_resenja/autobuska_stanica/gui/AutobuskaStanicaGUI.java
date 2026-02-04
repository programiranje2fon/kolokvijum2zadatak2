package varijanta_resenja.autobuska_stanica.gui;

import varijanta_resenja.autobuska_stanica.AutobuskaStanica;
import varijanta_resenja.autobuska_stanica.Polazak;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AutobuskaStanicaGUI extends JFrame {
    private JTextField textFieldDestinacijaUnos;
    private JTextField textFieldDan;
    private JTextField textFieldMesec;
    private JTextField textFieldGodina;
    private JTextField textFieldBrojSlobodnihMesta;
    private JButton dodajButton;
    private JButton obrisiButton;
    private JTextField textFieldDestinacijaRezervacija;
    private JTextField textFieldBrojKarata;
    private JButton rezervisiButton;
    private JPanel mojPanel;

    private AutobuskaStanica stanica = new AutobuskaStanica();

    public AutobuskaStanicaGUI(){
        setContentPane(mojPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Umesto setSize moze alternativno metoda pack koji ce da napravi prozor da
        //bude najmanjih dimenzija ali da se vide sve komponente na njemu
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Autobuska stanica");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String destinacija = textFieldDestinacijaUnos.getText();
                    int dan = Integer.parseInt(textFieldDan.getText());
                    int mesec = Integer.parseInt(textFieldMesec.getText());
                    int godina = Integer.parseInt(textFieldGodina.getText());
                    int brojSlobodnihMesta = Integer.parseInt(textFieldBrojSlobodnihMesta.getText());

                    LocalDate datum = LocalDate.of(godina, mesec, dan);

                    Polazak polazak = new Polazak();
                    polazak.setDestinacija(destinacija);
                    polazak.setVreme(datum);
                    polazak.setBrojSlobodnihMesta(brojSlobodnihMesta);

                    stanica.unesiPolazak(polazak);
                    //JOptionPane.INFORMATION_MESSAGE konstanta se koristi ako je na dijalogu
                    // potrebno prikazati ikonicu za informaciju
                    JOptionPane.showMessageDialog(null, "Polazak je uspesno dodat", "Uspesno",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    //JOptionPane.ERROR_MESSAGE konstanta se koristi ako je na dijalogu
                    // potrebno prikazati ikonicu za gresku
                    JOptionPane.showMessageDialog(null,
                            e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        obrisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldDestinacijaUnos.setText(null);
                textFieldDan.setText(null);
                textFieldMesec.setText(null);
                textFieldGodina.setText(null);
                textFieldBrojSlobodnihMesta.setText(null);
            }
        });
        rezervisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destinacija = textFieldDestinacijaRezervacija.getText();
                int brojKarata = Integer.parseInt(textFieldBrojKarata.getText());

                boolean uspesno = stanica.rezervisiKarte(destinacija, brojKarata);

                if (uspesno) {
                    //JOptionPane.INFORMATION_MESSAGE konstanta se koristi ako je na
                    // dijalogu potrebno prikazati ikonicu za informaciju
                    JOptionPane.showMessageDialog(null, "Rezervacija uspesno obavljena", "Uspesno",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //JOptionPane.ERROR_MESSAGE konstanta se koristi ako je na dijalogu
                    // potrebno prikazati ikonicu za gresku
                    JOptionPane.showMessageDialog(null, "Rezervacija nije uspela", "Greska",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new AutobuskaStanicaGUI().setVisible(true);
    }
}
