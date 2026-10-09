public class Profesor {
    String nume;
    String materie;

    Profesor(String nume) {
        this.nume = nume;
    }

    Profesor(String nume, String materie) {
        this.nume = nume;
        this.materie = materie;
    }

    @Override
    public String toString() {
        return nume + (materie != null ? " (" + materie + ")" : "");
    }
}
