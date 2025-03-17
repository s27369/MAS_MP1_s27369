package root;

public class Main {
    public static void main(String[] args) {
        Brygada br1 = new Brygada(18, "Stołeczna", "Warszawa", "August Emil Fieldorf 'Nil'");
        Brygada br2 = new Brygada(6, "Mazowiecka", "Radom");

        Batalion bat1 = new Batalion(181, new Adres("Wesoła", 1, "Warszawa"));
        Batalion bat2 = new Batalion(182, new Adres("Smutna", 2, "Warszawa"));
        Batalion bat3 = new Batalion(61, new Adres("Wysoka", 3, "Radom"));
        Batalion bat4 = new Batalion(62, new Adres("Niska", 4, "Radom"));

        br1.addBatalion(bat1);
        br1.addBatalion(bat2);
        br2.addBatalion(bat3);
        br2.addBatalion(bat4);

        save();

        load();
        ObjectPlus.printExtent();
    }

    public static void save(){
        try{
            ObjectPlus.saveExtent();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void load(){
        try{
            ObjectPlus.loadExtent();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
