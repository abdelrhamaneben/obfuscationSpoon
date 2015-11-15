package package2;


public class Conducteur {
    enum Civilite {
vfd67ab50_1f77_4679_8550_c74dd54a6af5, vdeb6c1b1_8ce2_4246_93e5_12ebc55c8bf7, vb582b3a6_a13b_4869_8d00_0c648da67486;    }

    private Civilite v78a483b0_b662_4174_9338_d9dbbbd10d2e = Civilite.vfd67ab50_1f77_4679_8550_c74dd54a6af5;

    private java.lang.String v043e7c9b_c89d_4708_9472_fba6ee070703;

    private int v3020bf6f_f4dc_4f88_90e9_561bceb59a87;

    private java.util.List<package1.Voiture> v1ce2e6a6_5393_4212_a479_1f113da71d34;

    public Conducteur() {
        v1ce2e6a6_5393_4212_a479_1f113da71d34 = new java.util.ArrayList<package1.Voiture>();
    }

    public java.lang.String d() {
        return v043e7c9b_c89d_4708_9472_fba6ee070703;
    }

    public void a(java.lang.String v043e7c9b_c89d_4708_9472_fba6ee070703) {
        this.v043e7c9b_c89d_4708_9472_fba6ee070703 = v043e7c9b_c89d_4708_9472_fba6ee070703;
    }

    public int c() {
        return v3020bf6f_f4dc_4f88_90e9_561bceb59a87;
    }

    public void a(int v3020bf6f_f4dc_4f88_90e9_561bceb59a87) {
        this.v3020bf6f_f4dc_4f88_90e9_561bceb59a87 = v3020bf6f_f4dc_4f88_90e9_561bceb59a87;
    }

    public Civilite f() {
        return v78a483b0_b662_4174_9338_d9dbbbd10d2e;
    }

    public void a(Civilite v78a483b0_b662_4174_9338_d9dbbbd10d2e) {
        this.v78a483b0_b662_4174_9338_d9dbbbd10d2e = v78a483b0_b662_4174_9338_d9dbbbd10d2e;
    }

    public java.util.List<package1.Voiture> e() {
        return v1ce2e6a6_5393_4212_a479_1f113da71d34;
    }

    public void a(java.util.List<package1.Voiture> v1ce2e6a6_5393_4212_a479_1f113da71d34) {
        this.v1ce2e6a6_5393_4212_a479_1f113da71d34 = v1ce2e6a6_5393_4212_a479_1f113da71d34;
    }

    public boolean a() {
        if ((v1ce2e6a6_5393_4212_a479_1f113da71d34.size()) == 0) {
            return true;
        } 
        return false;
    }

    public boolean b() {
        if ((v1ce2e6a6_5393_4212_a479_1f113da71d34.size()) == 1) {
            return true;
        } 
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return this.v043e7c9b_c89d_4708_9472_fba6ee070703;
    }

    public void a(java.lang.String vf1d93f70_7afa_422c_8a09_1b0873560540, int v3020bf6f_f4dc_4f88_90e9_561bceb59a87) {
        this.v3020bf6f_f4dc_4f88_90e9_561bceb59a87 = v3020bf6f_f4dc_4f88_90e9_561bceb59a87;
        for (package1.Voiture v0bca3f07_bfc4_49d3_b491_62af3916424b : v1ce2e6a6_5393_4212_a479_1f113da71d34) {
            v0bca3f07_bfc4_49d3_b491_62af3916424b.setMarque(vf1d93f70_7afa_422c_8a09_1b0873560540);
        }
    }

    public void a(package1.Voiture v0bca3f07_bfc4_49d3_b491_62af3916424b) {
        v1ce2e6a6_5393_4212_a479_1f113da71d34.add(v0bca3f07_bfc4_49d3_b491_62af3916424b);
    }
}

