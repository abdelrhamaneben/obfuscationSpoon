package package2;


public class Conducteur {
    enum Civilite {
MADAME, MADEMOISELLE, MONSIEUR;    }

    private Civilite civilite = Civilite.MADAME;

    private java.lang.String nom;

    private int age;

    private java.util.List<package1.Voiture> voitures;

    public java.lang.String g() {
        return nom;
    }

    public void a(java.lang.String nom) {
        this.nom = nom;
    }

    public int a() {
        return age;
    }

    public void a(int age) {
        this.age = age;
    }

    public Civilite e() {
        return civilite;
    }

    public void a(Civilite civilite) {
        this.civilite = civilite;
    }

    public java.util.List<package1.Voiture> c() {
        return voitures;
    }

    public void a(java.util.List<package1.Voiture> voitures) {
        this.voitures = voitures;
    }

    public boolean d() {
        if ((voitures.size()) == 0) {
            return true;
        } 
        return false;
    }

    public boolean b() {
        if ((voitures.size()) == 1) {
            return true;
        } 
        return false;
    }

    @java.lang.Override
    public java.lang.String f() {
        return this.nom;
    }

    public void a(java.lang.String marque, int age) {
        this.age = age;
        for (package1.Voiture v : voitures) {
            v.a(marque);
        }
    }
}

