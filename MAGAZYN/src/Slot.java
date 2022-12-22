

public class Slot extends Produkt{
    private double vs;
    private int sId;
    private static int nbSId = 0;
    private Produkt produkt;

    Slot(){
        this.setsId();
        this.produkt = new Produkt();
    }
    public void setsId(){
        this.sId = Slot.nbSId++;
    }

    public double getVs(){
        return this.vs;
    }

    public Produkt getProdukt(){
        return this.produkt;
    }


    public void dodajProdukt(Produkt p) {
        if (p.getV() <= 1000) {
            if (p.getV() <= 333) {
                this.vs = 333;
                p.wSlocie();
                this.produkt = p;

            } else if (p.getV() <= 666) {
                this.vs = 666;
                p.wSlocie();
                this.produkt = p;
            } else if (p.getV() <= 1000) {
                this.vs = 1000;
                p.wSlocie();
                this.produkt = p;
            }
        }
        else
            throw new RuntimeException("ZA DUZY NA SLOT!!!");
    }


    public void usunProdukt(){
        Produkt p = this.produkt;
        this.produkt = Produkt.getPusty();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("SLOT NR " + this.sId + "[V = " + this.vs +  " dm^3] ---> " + this.produkt.nazwa + " " + this.produkt.id);
        return s.toString();
    }
  }




