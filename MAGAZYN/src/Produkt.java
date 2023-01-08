import java.io.FileWriter;


public class Produkt {

    private static int nbId = 1;
    protected int id ;
    protected String nazwa;
    private String kolor;
    private double dlugosc;
    private double szerokosc;
    private double wysokosc;
    private double masa;

    private double v;

   /// private boolean wSlocie;




    Produkt(String nazwa, String kolor, double dlugosc, double szerokosc, double wysokosc, double masa ){
        this.setId();
        this.nazwa = nazwa;
        this. kolor = kolor;
        this. dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.masa = masa;
        this.v = getV();
    }

    Produkt(int id, String nazwa, String kolor, double dlugosc, double szerokosc, double wysokosc, double masa ){
        if(id>0)
         this.id = id;
        else
            this.id = 0;
        this.nazwa = nazwa;
        this. kolor = kolor;
        if(dlugosc>0)
            this. dlugosc = dlugosc;
        else
            throw new RuntimeException("Dlugosc musi byc dodatnia");
        if(szerokosc>0)
            this.szerokosc = szerokosc;
        else
            throw new RuntimeException("Szerokosc musi byc dodatnia");
        if(wysokosc>0)
            this.wysokosc = wysokosc;
        else
            throw new RuntimeException("Wysokosc musi byc dodatnia");
        this.masa = masa;
        this.v = getV();
    }
    Produkt(){
        this.nazwa = "PUSTY";
        this.id = -1;
        this.v =0;
    }

    public void setId(){
        this.id = Produkt.nbId++;
    }

    public double getV(){
            return dlugosc * szerokosc * wysokosc / 1000;}

    public boolean czyPusty(){
        if(this.id == -1)
            return true;
        else
            return false;
    }
    public static Produkt getPusty(){
        return new Produkt();
    }





    @Override
    public String toString() {
        String s = "";
        s += "==================================\n";
        s += this.nazwa + " [" + this.id + "]\n";
        s += "==============INFO================\n";
        s += "   Masa :  " + this.masa + " [kg]\n";
        s += "   Objetosc [V]: " + this.getV() + " [dm^3]\n";
        s += "   Kolor: " + this.kolor + "\n";
        s += "----------------------------------\n";
        s += "Wymiary\n";
        s += "   Szerokosc : " + this.dlugosc + " [cm]\n";
        s += "   Dlugosc : " + this.szerokosc + " [cm]\n";
        s += "   Wysokosc : " + this.wysokosc + " [cm]\n";
        s += "==================================\n";

        return s;
    }
    public void save(){
        try {

            FileWriter w = new FileWriter(this.nazwa + "_" + this.id + "_.txt");
            w.write(this.nazwa + "\n");
            w.write(this.kolor + "\n");
            w.write(this.dlugosc + "\n");
            w.write(this.szerokosc + "\n");
            w.write(this.wysokosc + "\n");
            w.write(this.masa + "\n");
            w.write(this.v + "\n");
            w.close();

        }catch (Exception e){
            System.out.println(e.toString());}
        }




}
