

public class Slot extends Produkt {
    private double vs; //objetosc slotu
    private Produkt produkt; // produkt do przechowania informacji o dodanym produkcie
    Slot() {
        this.produkt = new Produkt();
    }
    public void dodajProdukt(Produkt p) {   // dodanie produktu i ustalenie V slotu (0-1000 -> 1000 ; 1000-3000 -> 3000 ; >3000 -> ZA DUZY!
        if (p.getV() <= 1000) {
            this.vs = 1000;
            this.produkt = p;
        }
        else if (p.getV() < 3000) {
            this.vs = 3000;
            this.produkt = p;
        }
        else if (p.getV() > 3000) {
            throw new RuntimeException("ZA DUZY NA SLOT!!!");
        }
    }
    public void usunProdukt() {    // ususniecie produktu ze slotu , wyzerowanie V slotu
        Produkt p = this.produkt;
        this.produkt = Produkt.getPusty();
        this.vs = 0;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("SLOT " + "[V = " + this.vs + " dm^3] ---> " + this.produkt.nazwa + " " + this.produkt.id);
        return s.toString();
    }
}




