package root;

public class Brygada {
    protected int numBrygady;
    protected String miasto, typ;
    protected Adres adresJednostki;
    static final String suffix = "Obrony Terytorialnej";

    public Brygada(int numBrygady, String typ, String miasto) {
        try {
            setNumBrygady(numBrygady);
            setTyp(typ);
            setMiasto(miasto);
        }catch (Exception e){
            e.printStackTrace();
//            removeFromExtent();
        }
    }

    public Brygada(int numBrygady, String typ, String miasto, Adres adresJednostki) {
        this(numBrygady, typ, miasto);
        setAdresJednostki(adresJednostki);
    }

    public int getNumBrygady() {
        return numBrygady;
    }

    public void setNumBrygady(int numBrygady) {

        this.numBrygady = numBrygady;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        if(miasto != null){
            if(miasto.isBlank()){
                throw new IllegalArgumentException("Miasto nie może być puste");
            }
        }
        this.miasto = miasto;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        if(typ != null){
            if(typ.isBlank()){
                throw new IllegalArgumentException("Typ nie może być pusty");
            }
        }
        this.typ = typ;
    }

    public Adres getAdresJednostki() {
        return adresJednostki;
    }

    //przeciążenie metody
    public void setAdresJednostki(Adres adresJednostki) {
        this.adresJednostki = adresJednostki;
    }

    public void setAdresJednostki(String ulica, int numUlica, String miasto){
        this.adresJednostki = new Adres(ulica, numUlica, miasto);
    }


}
