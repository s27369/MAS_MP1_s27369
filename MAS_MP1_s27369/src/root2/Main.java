package root2;
import root2.Osoby.Dowodca;
import root2.StrukturyOrganizacyjne.Batalion;
import root2.StrukturyOrganizacyjne.Brygada;

public class Main {
    public static void main(String[] args) {
        Brygada brygada1 = new Brygada(18, "Stołeczna", "Warszawa");
        System.out.println(brygada1);
        Brygada brygada2 = new Brygada(6, "Mazowiecka", "Radom");
        System.out.println(brygada2);

        Batalion batalion18_1 = new Batalion(1, new Adres("Szeroka", 1, "Warszawa"));
        Batalion batalion18_2 = new Batalion(2, new Adres("Warszawska", 2, "Warszawa"));
        System.out.println(batalion18_1);
        System.out.println(batalion18_2);

        Batalion batalion6_1 = new Batalion(1, new Adres("Radomska", 1, "Radom"));
        Batalion batalion6_2 = new Batalion(2, new Adres("Długa", 2, "Radom"));
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
        System.out.println(brygada1);

    }
}
