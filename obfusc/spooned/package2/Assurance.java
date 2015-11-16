package package2;


public class Assurance {
    private java.lang.String nom;

    private java.util.List<package2.Conducteur> clients;

    public Assurance() {
        clients = new java.util.ArrayList<package2.Conducteur>();
    }

    public java.lang.String b() {
        return nom;
    }

    public void a(java.lang.String nom) {
        this.nom = nom;
    }

    public java.util.List<package2.Conducteur> c() {
        return clients;
    }

    public void a(java.util.List<package2.Conducteur> clients) {
        this.clients = clients;
    }

    public void a(package2.Conducteur c) {
        this.clients.add(c);
    }

    public java.util.List<java.lang.String> d() {
        java.util.List<java.lang.String> noms = new java.util.ArrayList<java.lang.String>();
        for (package2.Conducteur c : clients) {
            noms.add(c.d());
        }
        return noms;
    }

    public int a() {
        int cpt = 0;
        for (package2.Conducteur c : clients) {
            if (c.a()) {
                cpt++;
            } 
        }
        return cpt;
    }
}

