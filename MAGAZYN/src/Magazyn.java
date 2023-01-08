import java.util.HashMap;
import java.util.Map;


public class Magazyn extends Regal {
    private double v; /// objetosc magazyny
    private int i = 1; /// iterator do automatycznego dodawania
    private int lR; /// liczba regalow na magzynie (max. 10)
    private Map<Integer, Regal> regaly = new HashMap<>(); /// mapa do poruszania sie po regalach
    private Map<Integer, Produkt> produkty = new HashMap<>(); /// mapa z produktami id>id

    Magazyn(int n) {                                               /// kontruktor tworzacy Magazyn skladajacy z n regalow (max.10)
        int i;
        if (n > 10) {
            throw new RuntimeException("Za duzo regalow!!!");
        } else {
            for (i = 0; i < n; i++) {
                Regal regal = new Regal();
                regaly.put(regal.nrR, regal);
                this.v += regal.getVr();

            }
            this.lR = n;
        }


    }


    public void dodajProdukt(Produkt p) {                                   /// dodawanie produktu na najblizsze mozliwe miejsce
        if (produkty.containsKey(p.id)) {
            throw new RuntimeException("PRODUKT " + p.id + " JUZ NA MAGAZYNIE!");
        }
        if (i > 1) {
            int n = i;
            for (int j = 1; j < i; j++) {
                if (regaly.get(i - j).getVz() < 9000)
                    i = i - j;
            }
        }
        if (regaly.get(i).getVz() == 9000) {
            while (regaly.get(i).getVz() == 9000)
                i++;
        }
        produkty.put(p.id, p);
        regaly.get(i).dodajProdukt(p);
        System.out.println("dodany do " + i + " r");
    }


    public void dodajProduktNaReg(Produkt p, int nrR) {                           /// dodawanie produktu na wybrany regal
        if (nrR > this.lR || regaly.get(nrR).getVz() == 9000)
            throw new RuntimeException("\nNie ma tyle regalow!!! / " +
                    "BRAK MIEJSCA NA " + nrR + " regale!!! ");
        if (produkty.containsKey(p.id)) {
            throw new RuntimeException("PRODUKT " + p.id + " JUZ NA MAGAZYNIE!");
        } else {
            produkty.put(p.id, p);
            regaly.get(nrR).dodajProdukt(p);
        }
    }


    public void wezProdukt(int id) {
        if (produkty.containsKey(id)) {
            System.out.println("Pobrany produkt: \n" + produkty.get(id));
            for (Map.Entry<Integer, Regal> set :
                    regaly.entrySet()) {
                set.getValue().wezProdukt(id);
                produkty.remove(id);
            }
        }
        else {
            throw new RuntimeException("NIE MA NA MAGAZYNIE!!!");
        }

    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("=============MAGAZYN [" + this.lR + " R]====================\n");
        for (int i = 1; i <= this.lR; i++)
            s.append(regaly.get(i));
        return s.toString();

    }


}
