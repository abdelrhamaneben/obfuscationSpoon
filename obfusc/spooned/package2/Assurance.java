package package2;


public class Assurance {
    private java.lang.String nom;

    private java.util.List<package2.Conducteur> clients;

    public Assurance() {
    }

    public java.lang.String b() {
        return nom;
    }

    public void a(java.lang.String nom) {
        this.nom = nom;
    }

    public java.util.List<package2.Conducteur> a() {
        return clients;
    }

    public void a(java.util.List<package2.Conducteur> clients) {
        this.clients = clients;
    }

    public java.util.List<java.lang.String> c() {
        java.util.List<java.lang.String> noms = new java.util.ArrayList<java.lang.String>();
        for (package2.Conducteur c : clients) {
            noms.add(c.g());
        }
        return noms;
    }

    public int d() {
        int cpt = 0;
        for (package2.Conducteur c : clients) {
            if (c.d()) {
                cpt++;
            } 
        }
        return cpt;
    }
}

