package package2;


public class Assurance {
    private java.lang.String v043e7c9b_c89d_4708_9472_fba6ee070703;

    private java.util.List<package2.Conducteur> vc588d98a_88fc_4dde_ad8f_be8fd3702981;

    public Assurance() {
        vc588d98a_88fc_4dde_ad8f_be8fd3702981 = new java.util.ArrayList<package2.Conducteur>();
    }

    public java.lang.String b() {
        return v043e7c9b_c89d_4708_9472_fba6ee070703;
    }

    public void a(java.lang.String v043e7c9b_c89d_4708_9472_fba6ee070703) {
        this.v043e7c9b_c89d_4708_9472_fba6ee070703 = v043e7c9b_c89d_4708_9472_fba6ee070703;
    }

    public java.util.List<package2.Conducteur> c() {
        return vc588d98a_88fc_4dde_ad8f_be8fd3702981;
    }

    public void a(java.util.List<package2.Conducteur> vc588d98a_88fc_4dde_ad8f_be8fd3702981) {
        this.vc588d98a_88fc_4dde_ad8f_be8fd3702981 = vc588d98a_88fc_4dde_ad8f_be8fd3702981;
    }

    public void a(package2.Conducteur vd0bdb9c4_8acd_4575_953a_1575c7baab2f) {
        this.vc588d98a_88fc_4dde_ad8f_be8fd3702981.add(vd0bdb9c4_8acd_4575_953a_1575c7baab2f);
    }

    public java.util.List<java.lang.String> d() {
        java.util.List<java.lang.String> v9c6e7ce0_e792_4b5f_90fb_f3c9865099de = new java.util.ArrayList<java.lang.String>();
        for (package2.Conducteur vd0bdb9c4_8acd_4575_953a_1575c7baab2f : vc588d98a_88fc_4dde_ad8f_be8fd3702981) {
            v9c6e7ce0_e792_4b5f_90fb_f3c9865099de.add(vd0bdb9c4_8acd_4575_953a_1575c7baab2f.getNom());
        }
        return v9c6e7ce0_e792_4b5f_90fb_f3c9865099de;
    }

    public int a() {
        int v76fcb1d1_27ae_4a4c_94a0_52499b6db415 = 0;
        for (package2.Conducteur vd0bdb9c4_8acd_4575_953a_1575c7baab2f : vc588d98a_88fc_4dde_ad8f_be8fd3702981) {
            if (vd0bdb9c4_8acd_4575_953a_1575c7baab2f.isPieton()) {
                v76fcb1d1_27ae_4a4c_94a0_52499b6db415++;
            } 
        }
        return v76fcb1d1_27ae_4a4c_94a0_52499b6db415;
    }
}

