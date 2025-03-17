package root2;
import root2.Osoby.Dowodca;
import root2.Osoby.Osoba;
import root2.Osoby.Zolnierz;
import root2.StrukturyOrganizacyjne.Batalion;
import root2.StrukturyOrganizacyjne.Brygada;
import sample.ObjectPlus;

public class Main {
    public static void main(String[] args) {

        /*{
            createSampleObjects2();
            root2.ObjectPlus.printExtent();
            mainSave();
        }*/
        {
            mainLoad();
            root2.ObjectPlus.printExtent();
        }
    }

    private static void mainSave(){
        try {
            ObjectPlus.saveExtent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void mainLoad(){
        try {
            ObjectPlus.loadExtent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void createSampleObjects(){
        Brygada brygada1 = new Brygada(18, "Stołeczna", "Warszawa");
        System.out.println(brygada1);
        Brygada brygada2 = new Brygada(6, "Mazowiecka", "Radom");
        System.out.println(brygada2);

        Batalion batalion18_1 = new Batalion(1, new Adres("Szeroka", 1, "Warszawa"));
        Batalion batalion18_2 = new Batalion(2, new Adres("Warszawska", 2, "Warszawa"));

        Batalion batalion6_1 = new Batalion(1, new Adres("Radomska", 1, "Radom"));
        Batalion batalion6_2 = new Batalion(2, new Adres("Długa", 2, "Radom"));

        batalion18_1.setBrygadaMacierzysta(brygada1);
        batalion18_2.setBrygadaMacierzysta(brygada1);
        System.out.println(batalion18_1);
        System.out.println(batalion18_2);
        batalion6_1.setBrygadaMacierzysta(brygada2);
        batalion6_2.setBrygadaMacierzysta(brygada2);
        System.out.println(batalion6_1);
        System.out.println(batalion6_2);


        Dowodca dowodca1 = new Dowodca("Jan", "Kowalski", "Generał brygady");
        System.out.println(dowodca1);

        dowodca1.obejmijDowodztwo(brygada1);
        System.out.println(dowodca1);

        Dowodca dowodca2 = new Dowodca("Karol", "Nowak", "Kapral");
        System.out.println(dowodca2);

//        dowodca2.obejmijDowodztwo(brygada1); //IllegalArgumentException: Dowódcą brygady może zostać tylko generał
//        System.out.println(dowodca2);
//        System.out.println(brygada1);

        dowodca2.setStopien("Pułkownik");
        System.out.println(dowodca2);
        dowodca2.obejmijDowodztwo(batalion18_1); //teraz po awansie na Pułkownika już nie ma exception
        System.out.println(dowodca2);

        Zolnierz z1 = new Zolnierz("Jakub", "Kręgiel", "Porucznik");
        Zolnierz z2 = new Zolnierz("Piotr", "Krasulak", "Porucznik");

        dowodca1.addPodwladny(dowodca2);
        dowodca2.addPodwladny(z1);
        dowodca2.addPodwladny(z2);

        System.out.println(dowodca1+", podwładni: "+dowodca1.getPodwladni());
        System.out.println(dowodca2+", podwładni: "+dowodca2.getPodwladni());

        System.out.println(brygada1+", bataliony: "+brygada1.getBataliony());
        System.out.println(brygada2+", bataliony: "+brygada2.getBataliony());

    }
    private static void createSampleObjects2(){
        Zolnierz z1 = new Zolnierz("test", "testowski", "Kapral");
    }
}
