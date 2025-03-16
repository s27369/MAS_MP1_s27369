package root;

import java.util.ArrayList;
import java.util.List;

public class Dowodca {
    private String imie, nazwisko, stopien;
    private Dowodca przelozony;

    List<Dowodca> podwladni = new ArrayList<>();

    public Dowodca(String imie, String nazwisko, String stopien) {
        setImie(imie);
        setStopien(stopien);
        setNazwisko(nazwisko);
    }

    public String getImie() {
        return imie;
    }

    public void dodajPodwladnego(Dowodca podwladny){
        if(podwladny==null){
            throw new IllegalArgumentException("Podwładny nie może być null");
        }
        podwladni.add(podwladny);
    }

    public void dodajPrzelozonego(Dowodca przelozony){
        if(przelozony==null){
            throw new IllegalArgumentException("Podwładny nie może być null");
        }
        this.przelozony = przelozony;
    }

    public void setImie(String imie) {
        if(imie==null || imie.isBlank()){
            throw new IllegalArgumentException("Imie nie może być null ani puste");
        }
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if(nazwisko==null || nazwisko.isBlank()){
            throw new IllegalArgumentException("Nazwisko nie może być null ani puste");
        }
        this.nazwisko = nazwisko;
    }

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        if(stopien==null || stopien.isBlank()){
            throw new IllegalArgumentException("Stopien nie może być null ani pusty");
        }
        this.stopien = stopien;
    }

    @Override
    public String toString() {


        return stopien+" "+imie+" "+nazwisko;
    }
}
