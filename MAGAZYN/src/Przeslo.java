import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Przeslo extends Slot {
    private int nP;
    private static int np = 1;

    private static int nrS = 1;

    protected Map<Integer, String> sloty = new HashMap<>();
    protected Map<Integer, Double> objetosci = new HashMap<>();

     private Slot slot = new Slot();
    private double v = 1000;

    protected  double vzaj = 0;


    Przeslo(){
        this.setnrP();
    }

    public void setnrP(){
        this.nP = Przeslo.np++;
    }

    public double getVp(){
        return this.v;
    }

    public void dodajProdukt(Produkt p) {
//        if (sloty.containsKey(p.id)) {
//            throw new RuntimeException("PRODUKT JUZ NA MAGAZYNIE~!!~");
//        } else {

            this.slot.dodajProdukt(p);


            if (this.vzaj + this.slot.getVs() <= this.v) {
                sloty.put(p.id, p.nazwa);
                objetosci.put(p.id, this.slot.getVs());
                this.vzaj += this.slot.getVs();
                this.nrS++;
                this.slot.usunProdukt();
            } else {
                System.out.println("PRZESLO PELNE!!!");
            }
        }


    public boolean czyZawiera(int wezId){
        if(this.sloty.containsKey(wezId))
            return true;
        else
            return false;
    }

    public void pobierz(int pobId){
        System.out.println("Produkt ID: " + pobId + " pobrany z przesla nr. " + this.nP );
        sloty.remove(pobId);
        vzaj = vzaj - (objetosci.get(pobId));

    }




    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Przeslo nr. " + nP + "(WOLNE MIEJSCE : " + (this.v - this.vzaj) + ")\n");
        s.append(this.sloty + "\n");
        return s.toString();
    }
}
