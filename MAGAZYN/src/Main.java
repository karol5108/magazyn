
public class Main {
    public static void main(String[] args) {
     ///   System.out.println("Hello world!");
        Produkt p6 = new Produkt(20,"produkt", "bialy", 10, 10, 88, 20);

      //  System.out.println(p);
        Produkt p2 = new Produkt(13,"produkt", "bialy", 10,10, 10, 20);
       // System.out.println(p2);
        Produkt p3 = new Produkt(15,"produkt", "bialy", 90,90, 90, 20);
     //   System.out.println(p2);
        Produkt p4 = new Produkt(115,"produkt", "bialy", 10,10, 10, 20);

  //     Slot s = new Slot();
   //    s.dodajProdukt(p);
//       System.out.println(s);
//        Slot s2 = new Slot();
//        s2.dodajProdukt(p2);
//        System.out.println(s2);
//        s2.usunProdukt();
//        System.out.println(s2);

  ///      Przeslo prz = new Przeslo();
 ///       prz.dodajProdukt(p2);
  ///     System.out.println(prz);
//        prz.dodajProdukt(p2);
//        System.out.println(prz);
 //       prz.dodajProdukt(p);
 //       System.out.println(prz);
//        Regal r1 = new Regal();
//        Regal r2 = new Regal();
//       r1.dodajProdukt(p);
//       r1.dodajProdukt(p2);
//        r1.dodajProdukt(p3);
//        r1.dodajProdukt(p4);
//
//
//        System.out.println(r1);
//       r1.wezProdukt(12);
//        System.out.println(r1);
//     r1.dodajProdukt(p);
//      System.out.println(r1);
//
//        r2.dodajProdukt(p3);
//        System.out.println(r2);
      ///  Przeslo.getPusty();

        Magazyn magazyn = new Magazyn(2);
        magazyn.dodajProdukt(p2);
      magazyn.dodajProdukt(p3);
        magazyn.dodajProdukt(p4);
        System.out.println(magazyn);
        magazyn.wezProdukt(115);
        System.out.println(magazyn);
}}