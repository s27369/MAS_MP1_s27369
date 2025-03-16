package root;

public class Batalion extends Brygada{
    // brygada dzieli się na 3 bataliony. każdy może mieć swoją jednostkę.
    protected int numBatalion;
    protected Adres adresJednostki;

    public Batalion(int numBrygady, String typ, String miasto, int numBatalion) {
        super(numBrygady, typ, miasto);

    }

    public Batalion(int numBrygady, String typ, String miasto, Adres adresJednostki) {
        super(numBrygady, typ, miasto);
        setAdresJednostki(adresJednostki);
}

    public int getNumBatalion() {
        return numBatalion;
    }

    public void setNumBatalion(int numBatalion) {
        if(numBatalion<1 || numBatalion>3){
            throw new IllegalArgumentException("Numer batalionu musi być z zakresu 1-3");
        }
        this.numBatalion = numBatalion;
    }

    public Adres getAdresJednostki() {
        return adresJednostki;
    }

    //przeciążenie metody
    public void setAdresJednostki(Adres adresJednostki) {
        if (adresJednostki==null){
            throw new IllegalArgumentException("adresJednostki nie może być null");
        }
        this.adresJednostki = adresJednostki;
    }

    public void setAdresJednostki(String ulica, int numUlica, String miasto){
        this.adresJednostki = new Adres(ulica, numUlica, miasto);
    }
}
