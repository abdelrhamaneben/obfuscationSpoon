package org.apache.commons.csv;


public final class CSVPrinter implements java.io.Closeable , java.io.Flushable {
    private final java.lang.Appendable vc7935f99_d3ec_4224_ad37_05245a0b9290;

    private final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1;

    private boolean v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e = true;

    public CSVPrinter(final java.lang.Appendable vc7935f99_d3ec_4224_ad37_05245a0b9290 ,final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1) throws java.io.IOException {
        org.apache.commons.csv.Assertions.a(vc7935f99_d3ec_4224_ad37_05245a0b9290, toto.totoStringConstantes.v9c2bbdb6_62dd_49bb_bc7d_4e9267a91d67);
        org.apache.commons.csv.Assertions.a(ve5f721bc_309d_44a8_8287_6371e32911c1, toto.totoStringConstantes.vf1944b4d_993d_41f7_beef_1645eb3e65a8);
        this.vc7935f99_d3ec_4224_ad37_05245a0b9290 = vc7935f99_d3ec_4224_ad37_05245a0b9290;
        this.ve5f721bc_309d_44a8_8287_6371e32911c1 = ve5f721bc_309d_44a8_8287_6371e32911c1;
        if ((ve5f721bc_309d_44a8_8287_6371e32911c1.q()) != null) {
            for (final java.lang.String vf3517e54_6a8f_49e1_917d_d136b927d774 : ve5f721bc_309d_44a8_8287_6371e32911c1.q()) {
                if (vf3517e54_6a8f_49e1_917d_d136b927d774 != null) {
                    b(vf3517e54_6a8f_49e1_917d_d136b927d774);
                } 
            }
        } 
        if (((ve5f721bc_309d_44a8_8287_6371e32911c1.p()) != null) && (!(ve5f721bc_309d_44a8_8287_6371e32911c1.e()))) {
            b(((java.lang.Object[])(ve5f721bc_309d_44a8_8287_6371e32911c1.p())));
        } 
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if ((vc7935f99_d3ec_4224_ad37_05245a0b9290) instanceof java.io.Closeable) {
            ((java.io.Closeable)(vc7935f99_d3ec_4224_ad37_05245a0b9290)).close();
        } 
    }

    @java.lang.Override
    public void flush() throws java.io.IOException {
        if ((vc7935f99_d3ec_4224_ad37_05245a0b9290) instanceof java.io.Flushable) {
            ((java.io.Flushable)(vc7935f99_d3ec_4224_ad37_05245a0b9290)).flush();
        } 
    }

    public java.lang.Appendable a() {
        return this.vc7935f99_d3ec_4224_ad37_05245a0b9290;
    }

    public void a(final java.lang.Object v89bc6ee2_779c_4b13_8b18_7d401c9a96f8) throws java.io.IOException {
        java.lang.String ve7ba8045_fa81_43ac_b9b5_c39733419175;
        if (v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 == null) {
            final java.lang.String v70267c9a_2351_4d5d_bf0b_493c724c7aac = ve5f721bc_309d_44a8_8287_6371e32911c1.n();
            ve7ba8045_fa81_43ac_b9b5_c39733419175 = v70267c9a_2351_4d5d_bf0b_493c724c7aac == null ? org.apache.commons.csv.Constants.vcf4e0993_1a2d_4068_8673_f7c69577a1af : v70267c9a_2351_4d5d_bf0b_493c724c7aac;
        } else {
            ve7ba8045_fa81_43ac_b9b5_c39733419175 = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.toString();
        }
        a(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, ve7ba8045_fa81_43ac_b9b5_c39733419175, 0, ve7ba8045_fa81_43ac_b9b5_c39733419175.length());
    }

    private void a(final java.lang.Object v0a9367ca_8d80_4092_98c5_ada2331dd6b8, final java.lang.CharSequence v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, final int va569de84_f513_45a6_938b_8926909c09d4, final int v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f) throws java.io.IOException {
        if (!(v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e)) {
            vc7935f99_d3ec_4224_ad37_05245a0b9290.append(ve5f721bc_309d_44a8_8287_6371e32911c1.j());
        } 
        if (ve5f721bc_309d_44a8_8287_6371e32911c1.i()) {
            b(v0a9367ca_8d80_4092_98c5_ada2331dd6b8, v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, va569de84_f513_45a6_938b_8926909c09d4, v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f);
        } else if (ve5f721bc_309d_44a8_8287_6371e32911c1.g()) {
            a(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, va569de84_f513_45a6_938b_8926909c09d4, v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f);
        } else {
            vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, va569de84_f513_45a6_938b_8926909c09d4, (va569de84_f513_45a6_938b_8926909c09d4 + v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f));
        }
        v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e = false;
    }

    private void a(final java.lang.CharSequence v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, final int va569de84_f513_45a6_938b_8926909c09d4, final int v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f) throws java.io.IOException {
        int vdd709c37_67f3_46fe_9977_9d93b3fe18f6 = va569de84_f513_45a6_938b_8926909c09d4;
        int v7166038e_f285_4550_9dbd_83e77eda420d = va569de84_f513_45a6_938b_8926909c09d4;
        final int v21023c31_f4b1_40f3_be02_c094694bbe87 = va569de84_f513_45a6_938b_8926909c09d4 + v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f;
        final char va97aa86f_0935_4c47_9861_ecd949e03bb0 = ve5f721bc_309d_44a8_8287_6371e32911c1.j();
        final char v4b6f529a_bf14_4b39_8138_605b40d13170 = ve5f721bc_309d_44a8_8287_6371e32911c1.l().charValue();
        while (v7166038e_f285_4550_9dbd_83e77eda420d < v21023c31_f4b1_40f3_be02_c094694bbe87) {
            char v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.charAt(v7166038e_f285_4550_9dbd_83e77eda420d);
            if ((((v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0))) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == va97aa86f_0935_4c47_9861_ecd949e03bb0)) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == v4b6f529a_bf14_4b39_8138_605b40d13170)) {
                if (v7166038e_f285_4550_9dbd_83e77eda420d > vdd709c37_67f3_46fe_9977_9d93b3fe18f6) {
                    vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, v7166038e_f285_4550_9dbd_83e77eda420d);
                } 
                if (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) {
                    v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = 'n';
                } else if (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) {
                    v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = 'r';
                } 
                vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v4b6f529a_bf14_4b39_8138_605b40d13170);
                vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
                vdd709c37_67f3_46fe_9977_9d93b3fe18f6 = v7166038e_f285_4550_9dbd_83e77eda420d + 1;
            } 
            v7166038e_f285_4550_9dbd_83e77eda420d++;
        }
        if (v7166038e_f285_4550_9dbd_83e77eda420d > vdd709c37_67f3_46fe_9977_9d93b3fe18f6) {
            vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, v7166038e_f285_4550_9dbd_83e77eda420d);
        } 
    }

    private void b(final java.lang.Object v0a9367ca_8d80_4092_98c5_ada2331dd6b8, final java.lang.CharSequence v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, final int va569de84_f513_45a6_938b_8926909c09d4, final int v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f) throws java.io.IOException {
        boolean v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = false;
        int vdd709c37_67f3_46fe_9977_9d93b3fe18f6 = va569de84_f513_45a6_938b_8926909c09d4;
        int v7166038e_f285_4550_9dbd_83e77eda420d = va569de84_f513_45a6_938b_8926909c09d4;
        final int v21023c31_f4b1_40f3_be02_c094694bbe87 = va569de84_f513_45a6_938b_8926909c09d4 + v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f;
        final char v3f9d754e_623d_44d4_97ab_3241187f3c40 = ve5f721bc_309d_44a8_8287_6371e32911c1.j();
        final char vd794faad_a9a8_4e18_ae75_7b9ba8eb442c = ve5f721bc_309d_44a8_8287_6371e32911c1.m().charValue();
        org.apache.commons.csv.QuoteMode v9c01e2a5_5420_4860_97c2_2f83442fce3c = ve5f721bc_309d_44a8_8287_6371e32911c1.w();
        if (v9c01e2a5_5420_4860_97c2_2f83442fce3c == null) {
            v9c01e2a5_5420_4860_97c2_2f83442fce3c = org.apache.commons.csv.QuoteMode.vf700b163_46be_4c99_9285_3627fb1480b3;
        } 
        switch (v9c01e2a5_5420_4860_97c2_2f83442fce3c) {
            case v8a100c75_d304_4a8b_ab71_a541b15081ec :
                v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                break;
            case v096ec967_be59_4d3c_96f5_53912f62fe00 :
                v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = !(v0a9367ca_8d80_4092_98c5_ada2331dd6b8 instanceof java.lang.Number);
                break;
            case vd0e6bad9_d1e8_4cb3_98be_a1b537e1b1a1 :
                a(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, va569de84_f513_45a6_938b_8926909c09d4, v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f);
                return ;
            case vf700b163_46be_4c99_9285_3627fb1480b3 :
                if (v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f <= 0) {
                    if (v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e) {
                        v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                    } 
                } else {
                    char v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.charAt(v7166038e_f285_4550_9dbd_83e77eda420d);
                    if ((v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e) && ((((v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e < '0') || ((v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e > '9') && (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e < 'A'))) || ((v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e > 'Z') && (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e < 'a'))) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e > 'z'))) {
                        v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                    } else if (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e <= (org.apache.commons.csv.Constants.vd6e30361_0376_4fe8_8488_1ac29949eb2e)) {
                        v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                    } else {
                        while (v7166038e_f285_4550_9dbd_83e77eda420d < v21023c31_f4b1_40f3_be02_c094694bbe87) {
                            v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.charAt(v7166038e_f285_4550_9dbd_83e77eda420d);
                            if ((((v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c))) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == vd794faad_a9a8_4e18_ae75_7b9ba8eb442c)) || (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == v3f9d754e_623d_44d4_97ab_3241187f3c40)) {
                                v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                                break;
                            } 
                            v7166038e_f285_4550_9dbd_83e77eda420d++;
                        }
                        if (!v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20) {
                            v7166038e_f285_4550_9dbd_83e77eda420d = v21023c31_f4b1_40f3_be02_c094694bbe87 - 1;
                            v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.charAt(v7166038e_f285_4550_9dbd_83e77eda420d);
                            if (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e <= (org.apache.commons.csv.Constants.v569df8fb_aeac_4b08_898d_56564d68564d)) {
                                v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20 = true;
                            } 
                        } 
                    }
                }
                if (!v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20) {
                    vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, v21023c31_f4b1_40f3_be02_c094694bbe87);
                    return ;
                } 
                break;
            default :
                throw new java.lang.IllegalStateException((toto.totoStringConstantes.v9ea19504_8711_4d48_a27a_33b3069c8028 + v9c01e2a5_5420_4860_97c2_2f83442fce3c));
        }
        if (!v1d5ef4c7_0bbe_42a0_ba7a_ace0428b8e20) {
            vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, v21023c31_f4b1_40f3_be02_c094694bbe87);
            return ;
        } 
        vc7935f99_d3ec_4224_ad37_05245a0b9290.append(vd794faad_a9a8_4e18_ae75_7b9ba8eb442c);
        while (v7166038e_f285_4550_9dbd_83e77eda420d < v21023c31_f4b1_40f3_be02_c094694bbe87) {
            final char v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v89bc6ee2_779c_4b13_8b18_7d401c9a96f8.charAt(v7166038e_f285_4550_9dbd_83e77eda420d);
            if (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e == vd794faad_a9a8_4e18_ae75_7b9ba8eb442c) {
                vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, (v7166038e_f285_4550_9dbd_83e77eda420d + 1));
                vdd709c37_67f3_46fe_9977_9d93b3fe18f6 = v7166038e_f285_4550_9dbd_83e77eda420d;
            } 
            v7166038e_f285_4550_9dbd_83e77eda420d++;
        }
        vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8, vdd709c37_67f3_46fe_9977_9d93b3fe18f6, v7166038e_f285_4550_9dbd_83e77eda420d);
        vc7935f99_d3ec_4224_ad37_05245a0b9290.append(vd794faad_a9a8_4e18_ae75_7b9ba8eb442c);
    }

    public void b(final java.lang.String v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721) throws java.io.IOException {
        if (!(ve5f721bc_309d_44a8_8287_6371e32911c1.f())) {
            return ;
        } 
        if (!(v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e)) {
            b();
        } 
        vc7935f99_d3ec_4224_ad37_05245a0b9290.append(ve5f721bc_309d_44a8_8287_6371e32911c1.k().charValue());
        vc7935f99_d3ec_4224_ad37_05245a0b9290.append(org.apache.commons.csv.Constants.v569df8fb_aeac_4b08_898d_56564d68564d);
        for (int ve80b1152_e1ec_473f_b7c5_255785978c71 = 0 ; ve80b1152_e1ec_473f_b7c5_255785978c71 < (v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721.length()) ; ve80b1152_e1ec_473f_b7c5_255785978c71++) {
            final char v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721.charAt(ve80b1152_e1ec_473f_b7c5_255785978c71);
            switch (v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e) {
                case org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c :
                    if (((ve80b1152_e1ec_473f_b7c5_255785978c71 + 1) < (v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721.length())) && ((v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721.charAt((ve80b1152_e1ec_473f_b7c5_255785978c71 + 1))) == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0))) {
                        ve80b1152_e1ec_473f_b7c5_255785978c71++;
                    } 
                case org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0 :
                    b();
                    vc7935f99_d3ec_4224_ad37_05245a0b9290.append(ve5f721bc_309d_44a8_8287_6371e32911c1.k().charValue());
                    vc7935f99_d3ec_4224_ad37_05245a0b9290.append(org.apache.commons.csv.Constants.v569df8fb_aeac_4b08_898d_56564d68564d);
                    break;
                default :
                    vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e);
                    break;
            }
        }
        b();
    }

    public void b() throws java.io.IOException {
        final java.lang.String v445eaa37_cbd6_4b53_8809_5035e8eda261 = ve5f721bc_309d_44a8_8287_6371e32911c1.o();
        if (v445eaa37_cbd6_4b53_8809_5035e8eda261 != null) {
            vc7935f99_d3ec_4224_ad37_05245a0b9290.append(v445eaa37_cbd6_4b53_8809_5035e8eda261);
        } 
        v1d5cae2b_4ce5_4a5a_a1f8_c60fd075386e = true;
    }

    public void b(final java.lang.Iterable<?> va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) throws java.io.IOException {
        for (final java.lang.Object v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 : va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) {
            a(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8);
        }
        b();
    }

    public void b(final java.lang.Object... va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) throws java.io.IOException {
        for (final java.lang.Object v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 : va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) {
            a(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8);
        }
        b();
    }

    public void c(final java.lang.Iterable<?> va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) throws java.io.IOException {
        for (final java.lang.Object v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 : va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) {
            if (v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 instanceof java.lang.Object[]) {
                b(((java.lang.Object[])(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8)));
            } else if (v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 instanceof java.lang.Iterable) {
                b(((java.lang.Iterable<?>)(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8)));
            } else {
                b(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8);
            }
        }
    }

    public void c(final java.lang.Object... va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) throws java.io.IOException {
        for (final java.lang.Object v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 : va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be) {
            if (v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 instanceof java.lang.Object[]) {
                b(((java.lang.Object[])(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8)));
            } else if (v89bc6ee2_779c_4b13_8b18_7d401c9a96f8 instanceof java.lang.Iterable) {
                b(((java.lang.Iterable<?>)(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8)));
            } else {
                b(v89bc6ee2_779c_4b13_8b18_7d401c9a96f8);
            }
        }
    }

    public void b(final java.sql.ResultSet v3c594619_cc60_431c_8f60_3af3f1b3123f) throws java.io.IOException, java.sql.SQLException {
        final int vff3bfb0b_0856_4f46_a51a_417a32299705 = v3c594619_cc60_431c_8f60_3af3f1b3123f.getMetaData().getColumnCount();
        while (v3c594619_cc60_431c_8f60_3af3f1b3123f.next()) {
            for (int ve80b1152_e1ec_473f_b7c5_255785978c71 = 1 ; ve80b1152_e1ec_473f_b7c5_255785978c71 <= vff3bfb0b_0856_4f46_a51a_417a32299705 ; ve80b1152_e1ec_473f_b7c5_255785978c71++) {
                a(v3c594619_cc60_431c_8f60_3af3f1b3123f.getObject(ve80b1152_e1ec_473f_b7c5_255785978c71));
            }
            b();
        }
    }
}

