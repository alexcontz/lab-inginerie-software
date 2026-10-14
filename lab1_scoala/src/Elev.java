import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Elev
{
    String nume;
    Gen gen;
    Set<String> activitati = new HashSet<>();

    Elev(String nume, Gen gen)
    {
        this.nume = nume;
        this.gen = gen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elev elev = (Elev) o;
        return Objects.equals(nume, elev.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume);
    }

    @Override
    public String toString() {
        return nume;
    }
}
