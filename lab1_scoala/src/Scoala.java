import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Scoala
{
    Map<String, Clasa> Clase = new HashMap<>();
    Map<String, Activitate> activitati = new HashMap<>();

    void adaugaClasa(String s, Clasa c){
        Clase.put(s,c);
    }
    void eliminaClasa(String s){
        Clase.remove(s);
    }
    int getNumarClase() {
        return Clase.size();
    }
    int getTotalElevi(){
        final int[] total = {0};
        Clase.forEach((k, v) -> { total[0] += v.getTotalElevi(); });
        return total[0];
    }
    void adaugaElevInClasa(String clasa, Elev elev) {
        if (Clase.containsKey(clasa)) {
            Clase.get(clasa).adaugaElev(elev);
        }
    }

    void eliminaElevDupaNume(String nume) {
        for (Clasa c : Clase.values()) {
            if (c.elevi != null) {
                c.elevi.removeIf(e -> e.nume.equals(nume));
            }
        }
        for (Activitate act : activitati.values()) {
            if (act.elevi != null) {
                act.elevi.removeIf(e -> e.nume.equals(nume));
            }
        }
    }

    void adaugaActivitate(String nume, Activitate activitate) {
        activitati.put(nume, activitate);
    }

    void eliminaActivitate(String nume) {
        Activitate act = activitati.remove(nume);
        if (act != null && act.elevi != null) {
            for (Elev e : act.elevi) {
                e.activitati.remove(nume);
            }
        }
    }

    void inscrieElevInActivitate(String numeActivitate, Elev elev) {
        Activitate act = activitati.get(numeActivitate);
        if (act != null && elev != null) {
            act.adaugaElev(elev);
        }
    }

    void eliminaElevDinActivitate(String numeActivitate, Elev elev) {
        Activitate act = activitati.get(numeActivitate);
        if (act != null && elev != null) {
            act.eliminaElev(elev);
        }
    }

    void afiseazaTopActivitati() {
        System.out.println("=== Topul activitatilor dupa numarul de elevi participanti ===");
        activitati.values().stream()
            .sorted((a1, a2) -> Integer.compare(a2.getNumarElevi(), a1.getNumarElevi()))
            .forEach(a -> {
                String prof = (a.coordonator != null) ? a.coordonator.nume : "Fara coordonator";
                System.out.println(a.nume + " (Prof. " + prof + ") - " + a.getNumarElevi() + " elevi");
            });
    }

    int getNumarEleviCuActivitati() {
        Set<Elev> eleviUnici = new HashSet<>();
        for (Activitate act : activitati.values()) {
            if (act.elevi != null) {
                eleviUnici.addAll(act.elevi);
            }
        }
        return eleviUnici.size();
    }
}
