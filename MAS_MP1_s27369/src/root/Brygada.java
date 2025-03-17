package root;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brygada extends StrukturaOrganizacyjna {
    //brygada ma przypisane miasto którego broni i składa się z <=3 batalionów.
    //brygada może ale nie musi mieć patrona
    private String typ, miasto;
    private List<Batalion> bataliony = new ArrayList<>();//powtarzalny
    private String patron;//opcjonalny


    public Brygada(int numer, String typ, String miasto) {
        super(numer);
        setTyp(typ);
        setMiasto(miasto);
    }
    public Brygada(int numer, String typ, String miasto, String patron) {
        super(numer);
        setTyp(typ);
        setMiasto(miasto);
        setPatron(patron);
    }

    public void addBatalion(Batalion batalion) {
        if (batalion == null)
            throw new IllegalArgumentException("batalion nie może być null");
        if (bataliony.size()==3){
            System.out.println("Osiągnięto maksymalną liczbę batalionów");
        }
        if(bataliony.contains(batalion)){
            System.out.println("Batalion już jest przypisany do "+this);
        }else{
            this.bataliony.add(batalion);
        }
    }

    public void removeBatalion(Batalion b){
        if (b == null)
            throw new IllegalArgumentException("batalion nie może być null");
        if(bataliony.contains(b)){
            bataliony.remove(b);
            System.out.println("Pomyślnie usunięto "+b+" z "+this);
        }
    }

    public List<Batalion> getBataliony() {
        return Collections.unmodifiableList(bataliony);
    }

    public int getLiczbaBatalionow(){//pochodny
        return this.bataliony.size();
    }


    public String getMiasto() {
        return miasto;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        if (patron == null || patron.isBlank()) {
            throw new IllegalArgumentException("patron nie może być null ani blank");
        }
        this.patron = patron;
    }

    public void setMiasto(String miasto) {
        if (miasto == null || miasto.isBlank()) {
            throw new IllegalArgumentException("miasto nie może być null ani blank");
        }
        this.miasto = miasto;
    }

    public String getTyp() {
        return typ;
    }


    public void setTyp(String typ) {
        if (typ == null || typ.isBlank()) {
            throw new IllegalArgumentException("typ nie może być null ani blank");
        }
        this.typ = typ;
    }

    @Override
    public String toString() {
        if (sposobWyswietlania==SposobWyswietlania.LADNY)
            return numer + " " + typ + " Brygada " + suffix+(this.patron!=null?" im."+patron:"");
        else
            return "Brygada{" +
                    "numer=" + numer +
                    ", typ='" + typ + '\'' +
                    (patron!=null?", patron="+patron:"")+
                    ", miasto='" + miasto + '\'' +
                    ", bataliony=" + bataliony +
                    '}';
    }
}
