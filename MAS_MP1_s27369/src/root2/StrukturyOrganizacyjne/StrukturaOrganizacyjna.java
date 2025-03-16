package root2.StrukturyOrganizacyjne;

import root2.Osoby.Dowodca;

public abstract class StrukturaOrganizacyjna {
    Dowodca dowodca;
    int numer;
    protected static final String suffix = "Obrony Terytorialnej";

    public StrukturaOrganizacyjna(int numer) {
        setNumer(numer);
    }

    public StrukturaOrganizacyjna(Dowodca dowodca, int numer) {
        this(numer);
        setDowodca(dowodca);
    }


    public Dowodca getDowodca() {
        return dowodca;
    }

    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        this.dowodca = dowodca;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }
}
