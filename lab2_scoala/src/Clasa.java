import java.util.ArrayList;

public class Clasa
{
    int capacitate;
    int numar;
    char litera;
    ArrayList<Elev> elevi = new ArrayList<>();

    Clasa() {}

    Clasa(int capacitate, int numar, char litera) {
        this.capacitate = capacitate;
        this.numar = numar;
        this.litera = litera;
    }

    void adaugaElev(Elev e){
        elevi.add(e);
    }
    void eliminaElev(Elev e){
        elevi.remove(e);
    }
    int getTotalElevi(){
        return elevi.size();
    }
}
