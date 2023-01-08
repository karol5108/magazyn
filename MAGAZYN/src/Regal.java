public class Regal extends Przeslo {
    private double vR = 9000; // objetosc Regalu
    private double vZ; // zajeta objetosc Regalu
    protected int nrR; // nr Regalu
    private static int nrRR = 0;
    Przeslo prz = new Przeslo();
    Przeslo prz2 = new Przeslo();
    Przeslo prz3 = new Przeslo();

    Regal() {
        this.setnrR();
    }

    public void setnrR() {
        this.nrR = Regal.nrRR++;
    }

    public void dodajProdukt(Produkt p) {
        int vP = 1000;
        if (p.getV() > 1000)
            vP = 3000;

        if (this.prz.vzaj + vP > prz.getVp()) {
            if (this.prz2.vzaj + vP > prz2.getVp()) {
                if (this.prz3.vzaj + vP > prz3.getVp()) {
                    System.out.println("BRAK MIEJSCA NA TEN PRODUKT NA REGALE nr." + nrR + " !!!");
                } else {
                    this.prz3.dodajProdukt(p);
                    this.vZ += vP;
                }
            } else {
                this.prz2.dodajProdukt(p);
                this.vZ += vP;
            }
        } else {
            this.prz.dodajProdukt(p);
            this.vZ += vP;
        }
    }

    public void wezProdukt(int wezId) {
        if (this.prz.czyZawiera(wezId)) {
            prz.pobierz(wezId);
            if (this.prz.ileP() == 1)
                this.vZ -= 3000;
            else
                this.vZ -= 1000;
        } else if (this.prz2.czyZawiera(wezId)) {
            prz2.pobierz(wezId);
            if (this.prz2.ileP() == 1)
                this.vZ -= 3000;
            else
                this.vZ -= 1000;
        } else if (this.prz3.czyZawiera(wezId)) {
            prz3.pobierz(wezId);
            if (this.prz3.ileP() == 1)
                this.vZ -= 3000;
            else
                this.vZ -= 1000;
        }
    }
    public double getVr() {
        return this.vR;
    }
    public double getVz() {
        return this.vZ;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("---------------REGAL NR. " + nrR + "[WOLNE MIEJSCE: " + (this.vR - (this.prz.vzaj + this.prz2.vzaj + this.prz3.vzaj)) + "]\n");
        s.append(prz.toString() + prz2.toString() + prz3.toString());
        return s.toString();
    }

}
