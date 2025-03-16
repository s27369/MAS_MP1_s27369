package root2.StrukturyOrganizacyjne;

import root2.Adres;
import root2.Osoby.Dowodca;
import root2.StrukturyOrganizacyjne.StrukturaOrganizacyjna;

public class Batalion extends StrukturaOrganizacyjna {
    //każdy batalion ma swoją jednostkę.
    //dowódcą batalionu może zostać tylko pułkownik.
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

    @Override
    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        if(!dowodca.getStopien().toLowerCase().equals("pułkownik")){
            throw new IllegalArgumentException("Dowódcą batalionu może zostać tylko pułkownik");
        }
        this.dowodca = dowodca;
    }
}
