import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Produkt p1 = new Produkt(20, "produkt", "bialy", 10, 10, 88, 20); // V = 0-1000
        Produkt p2 = new Produkt(777, "produkt", "bialy", 150, 140, 140, 20); // V = 1000-3000

        Random r= new Random();

        Magazyn magazyn = new Magazyn(2);

        for(int i=0; i<10; i++){
            Produkt p = new Produkt("PRODUKT", "BRAK", r.nextDouble()*100, r.nextDouble()*100, r.nextDouble()*100, r.nextDouble()*10);
           magazyn.dodajProdukt(p);
        }
        magazyn.wezProdukt(1);

        magazyn.dodajProdukt(p1);
        magazyn.dodajProduktNaReg(p2, 2);
        magazyn.dodajProduktNaReg(p2, 2);

        System.out.println(magazyn);
    }
}