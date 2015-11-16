// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class main {
    public static void main(java.lang.String[] args) {
        package2.Assurance a = new package2.Assurance();
        package2.Conducteur c1 = new package2.Conducteur();
        package2.Conducteur c2 = new package2.Conducteur();
        package1.Voiture v1 = new package1.Voiture();
        package1.AbstractVoiture v2 = new package1.Voiture();
        java.lang.System.out.println(v2.a());
        a.a(c1);
        a.a(c2);
        v1.a("Volvo");
        a.a("MMA");
        c1.a(22);
        c1.a("Jean");
        c1.a(v1);
        java.lang.System.out.println(((((((((c1.d()) + " a une voiture de marque ") + (v1.d())) + " et est assuré chez ") + (a.b())) + " qui a ") + (a.a())) + " pietons."));
    }
}

