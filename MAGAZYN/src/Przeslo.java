import java.util.HashMap;
import java.util.Map;


public class Przeslo extends Slot {
    private int nP ; // nr. Przesla
    private static int np = 1; // zmienna do ustawiania nr Przesla
    private int ileP = 3; // ile produktow w Przesle
    protected Map<Integer, String> sloty = new HashMap<>(); // mapa z nr. id i nazwa produktu na danym Przesle
    private Slot slot = new Slot();
    private double v = 3000; // objetosc przesla
    protected double vzaj = 0; // zajeta objetosc przesla
    Przeslo() {
        this.setnrP();
    }
    public void setnrP() {
        this.nP = Przeslo.np++;
    }
    public double getVp() {
        return this.v;
    }
    public void dodajProdukt(Produkt p) {
        if (p.getV() > 1000 && p.getV() < 3000) {
            System.out.println("Za duzy na slot - Dodany do przesla! ");
            sloty.put(p.id, p.nazwa);
            this.vzaj += 3000;
            this.ileP = 1;
            this.slot.usunProdukt();
        }
        else {
            this.slot.dodajProdukt(p);
            sloty.put(p.id, p.nazwa);
            this.vzaj += 1000;
            this.slot.usunProdukt();
       }}
    public boolean czyZawiera(int wezId) {
        if (this.sloty.containsKey(wezId))
            return true;
        else
            return false;}
    public void pobierz(int pobId) {
        System.out.println("Produkt ID: " + pobId + " pobrany z przesla nr. " + this.nP);
        sloty.remove(pobId);
        if(this.ileP == 1)
            vzaj -= 3000;
        else
            vzaj -= 1000;}
    public int ileP(){
        return this.ileP;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Przeslo nr. " + nP + "(WOLNE MIEJSCE : " + (this.v - this.vzaj) + ")\n");
        s.append(this.sloty + "\n");
        return s.toString();
    }
}
