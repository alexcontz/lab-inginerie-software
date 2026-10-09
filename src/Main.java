public class Main {
    public static void main(String[] args) {
        Scoala scoala = new Scoala();

        Clasa clasa9A = new Clasa(30, 9, 'A');
        Clasa clasa10B = new Clasa(28, 10, 'B');
        Clasa clasa11C = new Clasa(25, 11, 'C');

        Elev e1 = new Elev("Ion Popescu", Gen.Masculin);
        Elev e2 = new Elev("Maria Ionescu", Gen.Feminin);
        Elev e3 = new Elev("Andrei Radu", Gen.Masculin);
        Elev e4 = new Elev("Elena Dumitrescu", Gen.Feminin);
        Elev e5 = new Elev("George Vasile", Gen.Masculin);
        Elev e6 = new Elev("Ana Marin", Gen.Feminin);
        Elev e7 = new Elev("Mihai Stan", Gen.Masculin);

        clasa9A.adaugaElev(e1);
        clasa9A.adaugaElev(e2);
        clasa9A.adaugaElev(e3);
        clasa10B.adaugaElev(e4);
        clasa10B.adaugaElev(e5);
        clasa11C.adaugaElev(e6);
        clasa11C.adaugaElev(e7);

        scoala.adaugaClasa("9A", clasa9A);
        scoala.adaugaClasa("10B", clasa10B);
        scoala.adaugaClasa("11C", clasa11C);

        System.out.println("=== Stare initiala a scolii ===");
        System.out.println("Numar clase: " + scoala.getNumarClase());
        System.out.println("Total elevi in scoala: " + scoala.getTotalElevi());
        System.out.println();

        System.out.println("-> Eliminam elevul " + e1.nume + " din clasa 9A...");
        clasa9A.eliminaElev(e1);
        System.out.println("Total elevi in 9A: " + clasa9A.getTotalElevi());
        System.out.println("Total elevi in scoala: " + scoala.getTotalElevi());
        System.out.println();

        System.out.println("-> Eliminam clasa 11C din scoala...");
        scoala.eliminaClasa("11C");
        System.out.println("Numar clase ramase: " + scoala.getNumarClase());
        System.out.println("Total elevi in scoala: " + scoala.getTotalElevi());
        System.out.println();

        System.out.println("-> Eliminam elevul dupa nume: Elena Dumitrescu...");
        scoala.eliminaElevDupaNume("Elena Dumitrescu");
        System.out.println("Total elevi in scoala: " + scoala.getTotalElevi());
        System.out.println();

        System.out.println("=== Informatii finale despre Scoala ===");
        System.out.println("Numar clase: " + scoala.getNumarClase());
        System.out.println("Total elevi in toate clasele: " + scoala.getTotalElevi());
        System.out.println();

        System.out.println("==========================================");
        System.out.println("=== TESTARE ACTIVITATI EXTRACURRICULARE ===");
        System.out.println("==========================================");

        Profesor profInfo = new Profesor("Popa Cristina", "Informatica");
        Profesor profSport = new Profesor("Ionescu Dan", "Educatie Fizica");
        Profesor profMuzica = new Profesor("Radulescu Carmen", "Muzica");
        Profesor profDesen = new Profesor("Enache Mihai", "Arte Vizuale");

        Activitate actProgramare = new Activitate("Programare", profInfo);
        Activitate actFotbal = new Activitate("Fotbal", profSport);
        Activitate actCor = new Activitate("Cor", profMuzica);
        Activitate actPictura = new Activitate("Pictura", profDesen);

        scoala.adaugaActivitate("Programare", actProgramare);
        scoala.adaugaActivitate("Fotbal", actFotbal);
        scoala.adaugaActivitate("Cor", actCor);
        scoala.adaugaActivitate("Pictura", actPictura);

        Elev eExtern = new Elev("Bogdan Teodorescu", Gen.Masculin);

        scoala.inscrieElevInActivitate("Programare", e2);
        scoala.inscrieElevInActivitate("Programare", e3);
        scoala.inscrieElevInActivitate("Programare", eExtern);

        scoala.inscrieElevInActivitate("Fotbal", e3);
        scoala.inscrieElevInActivitate("Fotbal", e5);
        scoala.inscrieElevInActivitate("Fotbal", e7);
        scoala.inscrieElevInActivitate("Fotbal", eExtern);

        scoala.inscrieElevInActivitate("Cor", e2);
        scoala.inscrieElevInActivitate("Cor", e6);

        scoala.inscrieElevInActivitate("Pictura", e6);

        scoala.afiseazaTopActivitati();
        System.out.println();
        System.out.println("Numar elevi care participa la cel putin o activitate: " + scoala.getNumarEleviCuActivitati());
        System.out.println();

        System.out.println("-> Eliminam elevul Andrei Radu din activitatea Fotbal...");
        scoala.eliminaElevDinActivitate("Fotbal", e3);

        System.out.println("-> Eliminam activitatea Pictura din scoala...");
        scoala.eliminaActivitate("Pictura");
        System.out.println();

        scoala.afiseazaTopActivitati();
        System.out.println();

        System.out.println("Numar final de elevi care participa la cel putin o activitate: " + scoala.getNumarEleviCuActivitati());
    }
}
