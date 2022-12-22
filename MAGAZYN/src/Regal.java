public class Regal extends Przeslo{
    private double vR = 3000;
    protected int nrR;
    private static int nrRR = 0;


   Przeslo prz =new Przeslo();
   Przeslo prz2 =new Przeslo();
   Przeslo prz3 =new Przeslo();

    Regal(){
        this.setnrR();
    }

    public void setnrR(){
        this.nrR = Regal.nrRR++;
    }

    public void dodajProdukt(Produkt p){
        if(this.prz.vzaj + p.getV() > prz.getVp()){
            if(this.prz2.vzaj + p.getV() > prz2.getVp()){
              if(this.prz3.vzaj + p.getV() > prz3.getVp())
                   System.out.println("BRAK MIEJSCA NA TEN PRODUKT NA REGALE!!!");
               else
                   prz3.dodajProdukt(p);System.out.println(" brak miejsca");
            }
            else
                prz2.dodajProdukt(p);
        }
        else
           this.prz.dodajProdukt(p);
    }

    public void wezProdukt(int wezId){
//        if(prz.czyZawiera(wezId) == false && prz2.czyZawiera(wezId) == false && prz3.czyZawiera(wezId) == false){
//            throw new RuntimeException("NIE MA NA MAGAZYNIE`!!`");
//        }
//        else {
            if(this.prz.czyZawiera(wezId))
                prz.pobierz(wezId);

//            }
//
//        }
  }

    public double getVr(){
        return this.vR;
    }


    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("---------------REGAL NR. " + nrR + "[WOLNE MIEJSCE: "+ (vR - (prz.vzaj - prz2.vzaj - prz3.vzaj))+ "]\n");
        s.append(prz.toString() + prz2.toString() + prz3.toString());
        return s.toString();
    }

}
