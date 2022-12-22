import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Magazyn extends Regal {

    private double v;
    private int lR;
    private Map<Integer, Regal> regaly = new HashMap<>();
    private Map<Integer, Produkt> produkty = new HashMap<>();
    Magazyn(int n){
        int i;
        for (i=0; i<n; i++){
            Regal regal = new Regal();
            regaly.put(regal.nrR, regal);
            this.v += regal.getVr();
            this.lR +=1;
        }



    }
    
    
    public void dodajProdukt(Produkt p){

       for(int i=1; i<=this.lR; i++){
           if(produkty.containsValue(p))
               System.out.println("***");

           else {
               produkty.put(p.id,p);
               regaly.get(i).dodajProdukt(p);}
       }
    }

    public void wezProdukt(int id){
        if(produkty.containsKey(id)){
            for(Map.Entry<Integer, Regal> set:
            regaly.entrySet()){
                set.getValue().wezProdukt(id);
                produkty.remove(id);
            }

        }
    }





    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("=============MAGAZYN [" + this.lR + " R]====================\n");
        for(int i=1; i<=this.lR; i++)
            s.append(regaly.get(i));
        return s.toString();

    }



}
