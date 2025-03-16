package root2.Osoby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zolnierz extends Osoba{

    private static final List<String> stopnieSzeregowcow = new ArrayList<>(Arrays.asList("szeregowy", "starszy szeregowy", "starszy szeregowy specjalista"));
    private static final List<String> stopniePodoficerskie = new ArrayList<>(Arrays.asList("kapral", "plutonowy", "sierżant"));
    private static final List<String> stopnieOficerskie = new ArrayList<>(Arrays.asList("porucznik", "kapitan", "major", "pułkownik"));
    private static final List<String> stopnieGeneralskie = new ArrayList<>(Arrays.asList("generał brygady", "generał dywizji"));
    private String stopien;
    private Zolnierz przelozony;
    public Boolean czySzeregowy=false, czyPodoficer=false, czyOficer=false, czyGeneral=false;
    public Zolnierz(String imie, String nazwisko, String stopien) {
        super(imie, nazwisko);
        setStopien(stopien);
    }

    public Zolnierz(String imie, String nazwisko, String stopien, Zolnierz przelozony) {
        this(imie, nazwisko, stopien);
        setPrzelozony(przelozony);
    }

    public Zolnierz getPrzelozony() {
        return przelozony;
    }

    public void setPrzelozony(Zolnierz przelozony) {
        this.przelozony = przelozony;
    }

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        if(stopien==null || stopien.isBlank()){
            throw new IllegalArgumentException("stopien nie może być null ani pusty");
        }

        if (stopnieSzeregowcow.contains(stopien)){
            czySzeregowy=true;
        } else if (stopniePodoficerskie.contains(stopien)) {
            czyPodoficer=true;
        } else if(stopnieOficerskie.contains(stopien)){
            czyOficer = true;
        } else if (stopnieGeneralskie.contains(stopien)) {
            czyGeneral=true;
        }else{
            throw new IllegalArgumentException("niepoprawny stopień");
        }
        this.stopien = stopien;
    }

    @Override
    public String toString() {
        return stopien+" "+super.toString();
    }
}
