package root2.Osoby;

import root2.StrukturyOrganizacyjne.Batalion;
import root2.StrukturyOrganizacyjne.Brygada;
import root2.StrukturyOrganizacyjne.StrukturaOrganizacyjna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dowodca extends Zolnierz{
    private List<Zolnierz> podwladni = new ArrayList<>();
    private StrukturaOrganizacyjna dowodzonaStruktura;

    public Dowodca(String imie, String nazwisko, String stopien) {
        super(imie, nazwisko, stopien);
    }
    public Dowodca(String imie, String nazwisko, String stopien, StrukturaOrganizacyjna strukturaOrganizacyjna) {
        this(imie, nazwisko, stopien);
        obejmijDowodztwo(strukturaOrganizacyjna);
    }

    public StrukturaOrganizacyjna getDowodzonaStruktura() {
        return dowodzonaStruktura;
    }

    public void obejmijDowodztwo(StrukturaOrganizacyjna dowodzonaStruktura) {
        if(dowodzonaStruktura==null){
            throw new IllegalArgumentException("dowodzonaStruktura nie może być null ani puste");
        }
        if (dowodzonaStruktura instanceof Brygada){
            if(!czyGeneral)
                throw new IllegalArgumentException("Dowódcą brygady może zostać tylko generał");
        } else if (dowodzonaStruktura instanceof Batalion) {
            if(!this.getStopien().toLowerCase().equals("pułkownik"))
                throw new IllegalArgumentException("Dowódcą batalionu może zostać tylko pułkownik");
        }
        dowodzonaStruktura.setDowodca(this);
        this.dowodzonaStruktura = dowodzonaStruktura;
    }

    public List<Zolnierz> getPodwladni() {
        return Collections.unmodifiableList(podwladni);
    }

    public void setPodwladni(List<Zolnierz> podwladni) {
        this.podwladni = podwladni;
    }

    public void addPodwladny(Zolnierz zolnierz){
        if (zolnierz==null)
            throw new IllegalArgumentException("Żołnierz nie może być null");
        this.podwladni.add(zolnierz);
    }

    @Override
    public String toString() {
        return super.toString()+
                (dowodzonaStruktura!=null?", dowódca "+dowodzonaStruktura.toString():"");
    }
}
