package org.apache.commons.csv;


final class Lexer implements java.io.Closeable {
    private static final char v9b14c3f9_0736_40e7_8df8_53e37ae442f1 = '￾';

    private final char vf4eef25d_c057_4e72_b82f_c925a28a233f;

    private final char v4b6f529a_bf14_4b39_8138_605b40d13170;

    private final char vd794faad_a9a8_4e18_ae75_7b9ba8eb442c;

    private final char v51f9f836_acd6_4052_a954_f46e6b376be3;

    private final boolean vf93b1475_59b8_467c_bd90_1938ec944017;

    private final boolean v2f25c313_f9bc_4d56_844b_b13ead09bae8;

    private final org.apache.commons.csv.ExtendedBufferedReader vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d;

    Lexer(final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1 ,final org.apache.commons.csv.ExtendedBufferedReader vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d) {
        this.vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d;
        this.vf4eef25d_c057_4e72_b82f_c925a28a233f = ve5f721bc_309d_44a8_8287_6371e32911c1.j();
        this.v4b6f529a_bf14_4b39_8138_605b40d13170 = a(ve5f721bc_309d_44a8_8287_6371e32911c1.l());
        this.vd794faad_a9a8_4e18_ae75_7b9ba8eb442c = a(ve5f721bc_309d_44a8_8287_6371e32911c1.m());
        this.v51f9f836_acd6_4052_a954_f46e6b376be3 = a(ve5f721bc_309d_44a8_8287_6371e32911c1.k());
        this.vf93b1475_59b8_467c_bd90_1938ec944017 = ve5f721bc_309d_44a8_8287_6371e32911c1.d();
        this.v2f25c313_f9bc_4d56_844b_b13ead09bae8 = ve5f721bc_309d_44a8_8287_6371e32911c1.b();
    }

    org.apache.commons.csv.Token a(final org.apache.commons.csv.Token v93acf3bd_209f_4c16_a481_84d151c1a464) throws java.io.IOException {
        int vba85b1dd_b585_4a76_83c9_69edcb55a51f = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.b();
        int v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
        boolean vae9f996d_644e_4538_8fa4_1bf95c793ac9 = i(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
        if (v2f25c313_f9bc_4d56_844b_b13ead09bae8) {
            while (vae9f996d_644e_4538_8fa4_1bf95c793ac9 && (g(vba85b1dd_b585_4a76_83c9_69edcb55a51f))) {
                vba85b1dd_b585_4a76_83c9_69edcb55a51f = v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e;
                v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
                vae9f996d_644e_4538_8fa4_1bf95c793ac9 = i(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
                if (c(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
                    return v93acf3bd_209f_4c16_a481_84d151c1a464;
                } 
            }
        } 
        if ((c(vba85b1dd_b585_4a76_83c9_69edcb55a51f)) || ((!(b(vba85b1dd_b585_4a76_83c9_69edcb55a51f))) && (c(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)))) {
            v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
            return v93acf3bd_209f_4c16_a481_84d151c1a464;
        } 
        if ((g(vba85b1dd_b585_4a76_83c9_69edcb55a51f)) && (a(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e))) {
            final java.lang.String vf3517e54_6a8f_49e1_917d_d136b927d774 = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.readLine();
            if (vf3517e54_6a8f_49e1_917d_d136b927d774 == null) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
                return v93acf3bd_209f_4c16_a481_84d151c1a464;
            } 
            final java.lang.String v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721 = vf3517e54_6a8f_49e1_917d_d136b927d774.trim();
            v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721);
            v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.vd6e30361_0376_4fe8_8488_1ac29949eb2e;
            return v93acf3bd_209f_4c16_a481_84d151c1a464;
        } 
        while ((v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63) == (org.apache.commons.csv.Token.Type.vcd967bed_e5aa_4a5f_8f78_2d03f3825dd4)) {
            if (vf93b1475_59b8_467c_bd90_1938ec944017) {
                while ((h(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) && (!vae9f996d_644e_4538_8fa4_1bf95c793ac9)) {
                    v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
                    vae9f996d_644e_4538_8fa4_1bf95c793ac9 = i(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
                }
            } 
            if (b(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.v60e5332e_7bfb_4320_93d6_779736ac6331;
            } else if (vae9f996d_644e_4538_8fa4_1bf95c793ac9) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.va3b8a558_18b2_4b2d_a9a4_15e411538a51;
            } else if (f(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                b(v93acf3bd_209f_4c16_a481_84d151c1a464);
            } else if (c(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
                v93acf3bd_209f_4c16_a481_84d151c1a464.v1eb8d52d_d259_4046_bb48_97d066892663 = true;
            } else {
                a(v93acf3bd_209f_4c16_a481_84d151c1a464, v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
            }
        }
        return v93acf3bd_209f_4c16_a481_84d151c1a464;
    }

    private org.apache.commons.csv.Token a(final org.apache.commons.csv.Token v93acf3bd_209f_4c16_a481_84d151c1a464, int v76b0f698_674f_4195_b405_454726babbcd) throws java.io.IOException {
        while (true) {
            if (i(v76b0f698_674f_4195_b405_454726babbcd)) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.va3b8a558_18b2_4b2d_a9a4_15e411538a51;
                break;
            } else if (c(v76b0f698_674f_4195_b405_454726babbcd)) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
                v93acf3bd_209f_4c16_a481_84d151c1a464.v1eb8d52d_d259_4046_bb48_97d066892663 = true;
                break;
            } else if (b(v76b0f698_674f_4195_b405_454726babbcd)) {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.v60e5332e_7bfb_4320_93d6_779736ac6331;
                break;
            } else if (d(v76b0f698_674f_4195_b405_454726babbcd)) {
                final int vd575a136_a67d_40b7_b820_074f5b8213cb = b();
                if (vd575a136_a67d_40b7_b820_074f5b8213cb == (org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede)) {
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(v76b0f698_674f_4195_b405_454726babbcd))).append(((char)(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.b())));
                } else {
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(vd575a136_a67d_40b7_b820_074f5b8213cb)));
                }
                v76b0f698_674f_4195_b405_454726babbcd = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
            } else {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(v76b0f698_674f_4195_b405_454726babbcd)));
                v76b0f698_674f_4195_b405_454726babbcd = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
            }
        }
        if (vf93b1475_59b8_467c_bd90_1938ec944017) {
            a(v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8);
        } 
        return v93acf3bd_209f_4c16_a481_84d151c1a464;
    }

    private org.apache.commons.csv.Token b(final org.apache.commons.csv.Token v93acf3bd_209f_4c16_a481_84d151c1a464) throws java.io.IOException {
        final long vaf1f3ce2_e56e_44c7_816e_b3d16c8f34cb = d();
        int v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e;
        while (true) {
            v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
            if (d(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                final int vd575a136_a67d_40b7_b820_074f5b8213cb = b();
                if (vd575a136_a67d_40b7_b820_074f5b8213cb == (org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede)) {
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e))).append(((char)(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.b())));
                } else {
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(vd575a136_a67d_40b7_b820_074f5b8213cb)));
                }
            } else if (f(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                if (f(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.c())) {
                    v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
                    v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)));
                } else {
                    while (true) {
                        v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
                        if (b(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                            v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.v60e5332e_7bfb_4320_93d6_779736ac6331;
                            return v93acf3bd_209f_4c16_a481_84d151c1a464;
                        } else if (c(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                            v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.ve340628d_6285_467c_8287_52a0d117c0de;
                            v93acf3bd_209f_4c16_a481_84d151c1a464.v1eb8d52d_d259_4046_bb48_97d066892663 = true;
                            return v93acf3bd_209f_4c16_a481_84d151c1a464;
                        } else if (i(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                            v93acf3bd_209f_4c16_a481_84d151c1a464.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.va3b8a558_18b2_4b2d_a9a4_15e411538a51;
                            return v93acf3bd_209f_4c16_a481_84d151c1a464;
                        } else if (!(h(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e))) {
                            throw new java.io.IOException(((toto.totoStringConstantes.v526e9374_d4ce_41b0_9f86_47e372353f6d + (d())) + toto.totoStringConstantes.vf8633228_12bb_4075_ad47_d5abe581cc4a));
                        } 
                    }
                }
            } else if (c(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)) {
                throw new java.io.IOException(((toto.totoStringConstantes.v7bfc9074_da3b_430a_b79e_a1bf13d67ea7 + vaf1f3ce2_e56e_44c7_816e_b3d16c8f34cb) + toto.totoStringConstantes.v5fa2505a_c224_4082_bb9d_e323a75e86d3));
            } else {
                v93acf3bd_209f_4c16_a481_84d151c1a464.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.append(((char)(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e)));
            }
        }
    }

    private char a(final java.lang.Character v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e) {
        return v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == null ? v9b14c3f9_0736_40e7_8df8_53e37ae442f1 : v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e.charValue();
    }

    long d() {
        return vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.d();
    }

    long c() {
        return vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.e();
    }

    int b() throws java.io.IOException {
        final int v76b0f698_674f_4195_b405_454726babbcd = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
        switch (v76b0f698_674f_4195_b405_454726babbcd) {
            case 'r' :
                return org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c;
            case 'n' :
                return org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0;
            case 't' :
                return org.apache.commons.csv.Constants.v2ff5fe22_60bc_4dd9_8b8f_757f5dcb52df;
            case 'b' :
                return org.apache.commons.csv.Constants.v8c8f18b6_4250_4c58_baf4_130f7cff2d5a;
            case 'f' :
                return org.apache.commons.csv.Constants.va60409ce_be51_45f6_a35a_30e10a1f2f86;
            case org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c :
            case org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0 :
            case org.apache.commons.csv.Constants.va60409ce_be51_45f6_a35a_30e10a1f2f86 :
            case org.apache.commons.csv.Constants.v2ff5fe22_60bc_4dd9_8b8f_757f5dcb52df :
            case org.apache.commons.csv.Constants.v8c8f18b6_4250_4c58_baf4_130f7cff2d5a :
                return v76b0f698_674f_4195_b405_454726babbcd;
            case org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede :
                throw new java.io.IOException(toto.totoStringConstantes.ve566221a_f11e_429a_894b_e1c619bb5b54);
            default :
                if (e(v76b0f698_674f_4195_b405_454726babbcd)) {
                    return v76b0f698_674f_4195_b405_454726babbcd;
                } 
                return org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede;
        }
    }

    void a(final java.lang.StringBuilder v9045a371_d287_4350_846b_c2615ed308fb) {
        int v5a06c40f_84de_44e2_a309_6e11057f46cd = v9045a371_d287_4350_846b_c2615ed308fb.length();
        while ((v5a06c40f_84de_44e2_a309_6e11057f46cd > 0) && (java.lang.Character.isWhitespace(v9045a371_d287_4350_846b_c2615ed308fb.charAt((v5a06c40f_84de_44e2_a309_6e11057f46cd - 1))))) {
            v5a06c40f_84de_44e2_a309_6e11057f46cd = v5a06c40f_84de_44e2_a309_6e11057f46cd - 1;
        }
        if (v5a06c40f_84de_44e2_a309_6e11057f46cd != (v9045a371_d287_4350_846b_c2615ed308fb.length())) {
            v9045a371_d287_4350_846b_c2615ed308fb.setLength(v5a06c40f_84de_44e2_a309_6e11057f46cd);
        } 
    }

    boolean i(int v76b0f698_674f_4195_b405_454726babbcd) throws java.io.IOException {
        if ((v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) && ((vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.c()) == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0))) {
            v76b0f698_674f_4195_b405_454726babbcd = vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.read();
        } 
        return (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) || (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c));
    }

    boolean a() {
        return vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.a();
    }

    boolean h(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return (!(b(v76b0f698_674f_4195_b405_454726babbcd))) && (java.lang.Character.isWhitespace(((char)(v76b0f698_674f_4195_b405_454726babbcd))));
    }

    boolean g(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return ((v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) || (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c))) || (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v49caa2e4_ffeb_4f1a_8f9d_415673c83f65));
    }

    boolean c(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede);
    }

    boolean b(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return v76b0f698_674f_4195_b405_454726babbcd == (vf4eef25d_c057_4e72_b82f_c925a28a233f);
    }

    boolean d(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return v76b0f698_674f_4195_b405_454726babbcd == (v4b6f529a_bf14_4b39_8138_605b40d13170);
    }

    boolean f(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return v76b0f698_674f_4195_b405_454726babbcd == (vd794faad_a9a8_4e18_ae75_7b9ba8eb442c);
    }

    boolean a(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return v76b0f698_674f_4195_b405_454726babbcd == (v51f9f836_acd6_4052_a954_f46e6b376be3);
    }

    private boolean e(final int v76b0f698_674f_4195_b405_454726babbcd) {
        return (((v76b0f698_674f_4195_b405_454726babbcd == (vf4eef25d_c057_4e72_b82f_c925a28a233f)) || (v76b0f698_674f_4195_b405_454726babbcd == (v4b6f529a_bf14_4b39_8138_605b40d13170))) || (v76b0f698_674f_4195_b405_454726babbcd == (vd794faad_a9a8_4e18_ae75_7b9ba8eb442c))) || (v76b0f698_674f_4195_b405_454726babbcd == (v51f9f836_acd6_4052_a954_f46e6b376be3));
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d.close();
    }
}

