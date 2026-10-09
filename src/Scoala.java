import java.util.HashMap;
import java.util.Map;

public class Scoala
{
    Map<String, Clasa> Clase = new HashMap<>();

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
    }


}
