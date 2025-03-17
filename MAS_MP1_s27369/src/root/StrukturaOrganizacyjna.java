package root;


public abstract class StrukturaOrganizacyjna extends ObjectPlus {

//    public SposobWyswietlania sposobWyswietlania = SposobWyswietlania.LADNY;
    public SposobWyswietlania sposobWyswietlania = SposobWyswietlania.SZCZEGOLOWY;
    protected int numer;
    protected static final String suffix = "Obrony Terytorialnej";
    static String motto = "Zawsze gotowi zawsze blisko";//klasowy
    public StrukturaOrganizacyjna(int numer) {
        this.numer = numer;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        if (numer<1){
            throw new IllegalArgumentException("numBrygady musi być większy lub równy 1");
        }
        this.numer = numer;
    }
}
