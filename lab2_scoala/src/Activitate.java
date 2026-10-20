import java.util.HashSet;
import java.util.Set;

public class Activitate {
    String nume;
    Profesor coordonator;
    Set<Elev> elevi = new HashSet<>();

    Activitate(String nume, Profesor coordonator) {
        this.nume = nume;
        this.coordonator = coordonator;
    }

    void adaugaElev(Elev e) {
        if (e != null) {
            elevi.add(e);
            e.activitati.add(this.nume);
        }
    }

    void eliminaElev(Elev e) {
        if (e != null) {
            elevi.remove(e);
            e.activitati.remove(this.nume);
        }
    }

    int getNumarElevi() {
        return elevi.size();
    }
}
