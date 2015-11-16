package package2;


public class Conducteur {
    enum Civilite {
MADAME, MADEMOISELLE, MONSIEUR;    }

    private Civilite civilite = Civilite.MADAME;

    private java.lang.String nom;

    private int age;

    private java.util.List<package1.Voiture> voitures;

    public Conducteur() {
        voitures = new java.util.ArrayList<package1.Voiture>();
    }

    public java.lang.String d() {
        return nom;
    }

    public void a(java.lang.String nom) {
        this.nom = nom;
    }

    public int c() {
        return age;
    }

    public void a(int age) {
        this.age = age;
    }

    public Civilite f() {
        return civilite;
    }

    public void a(Civilite civilite) {
        this.civilite = civilite;
    }

    public java.util.List<package1.Voiture> e() {
        return voitures;
    }

    public void a(java.util.List<package1.Voiture> voitures) {
        this.voitures = voitures;
    }

    public boolean a() {
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
    public java.lang.String toString() {
        return this.nom;
    }

    public void a(java.lang.String marque, int age) {
        this.age = age;
        for (package1.Voiture v : voitures) {
            v.a(marque);
        }
    }

    public void a(package1.Voiture v) {
        voitures.add(v);
    }
}

