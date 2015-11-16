package package1;


public class Voiture extends package1.AbstractVoiture implements package1.Vehicule {
    private int taille;

    private java.lang.String marque;

    public int c() {
        return taille;
    }

    public void b(int taille) {
        this.taille = taille;
    }

    public java.lang.String d() {
        return marque;
    }

    public void a(java.lang.String marque) {
        this.marque = marque;
    }

    public int b() {
        return 33;
    }

    public java.lang.String e() {
        return "vroum" + (a());
    }

    @java.lang.Override
    public java.lang.String a() {
        return "tutut";
    }
}

