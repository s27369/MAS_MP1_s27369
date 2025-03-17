package root;


import example.ObjectPlus;
import example.Student;

public class Batalion extends StrukturaOrganizacyjna {
    //każdy batalion ma swoją jednostkę.
    private Adres adresJednostki;

    public Batalion(int numer, Adres adresJednostki) {
        super(numer);
        setAdresJednostki(adresJednostki);
    }

    public Adres getAdresJednostki() {
        return adresJednostki;
    }

    public void setAdresJednostki(Adres adresJednostki) {
        if(adresJednostki==null){
            throw new IllegalArgumentException("adresJednostki nie może być null");
        }
        this.adresJednostki = adresJednostki;
    }
    public void setAdresJednostki(String ulica, int numUlicy, String miasto) {//przeciazenie
        if(ulica==null || miasto==null){
            throw new IllegalArgumentException("ulica ani miasto nie może być null");
        }
        if(numUlicy<1){
            throw new IllegalArgumentException("Numer ulicy musi być >=1");
        }
        setAdresJednostki(new Adres(ulica, numUlicy, miasto));
    }

    public static Batalion getBatalionByNumer(int numer){//static
        return ObjectPlus.getExtentFromClass(Batalion.class)
                .stream().filter(batalion -> batalion.getNumer() == numer)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {//przysloniecie
        if (sposobWyswietlania==SposobWyswietlania.LADNY)
            return numer + " Batalion";
        else{
            return "Batalion{" +
                    "numer=" + numer +
                    ", adresJednostki=" + adresJednostki +
                    '}';
        }
    }

}
