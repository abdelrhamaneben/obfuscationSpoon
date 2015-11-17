package org.apache.commons.csv;


final class ExtendedBufferedReader extends java.io.BufferedReader {
    private int vba85b1dd_b585_4a76_83c9_69edcb55a51f = org.apache.commons.csv.Constants.v49caa2e4_ffeb_4f1a_8f9d_415673c83f65;

    private long vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6;

    private long v12ffbbc7_81b0_49b9_886c_f7baeaf1faa4;

    private boolean ve04c97a8_3dc3_40e0_8151_7b89ecffd352;

    ExtendedBufferedReader(final java.io.Reader vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d) {
        super(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        final int v34107b0f_4537_4b32_afae_137f60346e56 = super.read();
        if ((v34107b0f_4537_4b32_afae_137f60346e56 == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) || ((v34107b0f_4537_4b32_afae_137f60346e56 == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) && ((vba85b1dd_b585_4a76_83c9_69edcb55a51f) != (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)))) {
            (vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6)++;
        } 
        vba85b1dd_b585_4a76_83c9_69edcb55a51f = v34107b0f_4537_4b32_afae_137f60346e56;
        (this.v12ffbbc7_81b0_49b9_886c_f7baeaf1faa4)++;
        return vba85b1dd_b585_4a76_83c9_69edcb55a51f;
    }

    int b() {
        return vba85b1dd_b585_4a76_83c9_69edcb55a51f;
    }

    @java.lang.Override
    public int read(final char[] v1967ca36_c643_4e79_b55e_91d6e6ac7f83, final int va569de84_f513_45a6_938b_8926909c09d4, final int v5a06c40f_84de_44e2_a309_6e11057f46cd) throws java.io.IOException {
        if (v5a06c40f_84de_44e2_a309_6e11057f46cd == 0) {
            return 0;
        } 
        final int v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f = super.read(v1967ca36_c643_4e79_b55e_91d6e6ac7f83, va569de84_f513_45a6_938b_8926909c09d4, v5a06c40f_84de_44e2_a309_6e11057f46cd);
        if (v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f > 0) {
            for (int ve80b1152_e1ec_473f_b7c5_255785978c71 = va569de84_f513_45a6_938b_8926909c09d4 ; ve80b1152_e1ec_473f_b7c5_255785978c71 < (va569de84_f513_45a6_938b_8926909c09d4 + v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f) ; ve80b1152_e1ec_473f_b7c5_255785978c71++) {
                final char v76b0f698_674f_4195_b405_454726babbcd = v1967ca36_c643_4e79_b55e_91d6e6ac7f83[ve80b1152_e1ec_473f_b7c5_255785978c71];
                if (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0)) {
                    if ((org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c) != (ve80b1152_e1ec_473f_b7c5_255785978c71 > 0 ? v1967ca36_c643_4e79_b55e_91d6e6ac7f83[(ve80b1152_e1ec_473f_b7c5_255785978c71 - 1)] : vba85b1dd_b585_4a76_83c9_69edcb55a51f)) {
                        (vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6)++;
                    } 
                } else if (v76b0f698_674f_4195_b405_454726babbcd == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) {
                    (vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6)++;
                } 
            }
            vba85b1dd_b585_4a76_83c9_69edcb55a51f = v1967ca36_c643_4e79_b55e_91d6e6ac7f83[((va569de84_f513_45a6_938b_8926909c09d4 + v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f) - 1)];
        } else if (v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f == (-1)) {
            vba85b1dd_b585_4a76_83c9_69edcb55a51f = org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede;
        } 
        v12ffbbc7_81b0_49b9_886c_f7baeaf1faa4 += v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f;
        return v0511a1f2_5ca8_4c4d_b3a7_d14d0a7c362f;
    }

    @java.lang.Override
    public java.lang.String readLine() throws java.io.IOException {
        final java.lang.String vf3517e54_6a8f_49e1_917d_d136b927d774 = super.readLine();
        if (vf3517e54_6a8f_49e1_917d_d136b927d774 != null) {
            vba85b1dd_b585_4a76_83c9_69edcb55a51f = org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0;
            (vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6)++;
        } else {
            vba85b1dd_b585_4a76_83c9_69edcb55a51f = org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede;
        }
        return vf3517e54_6a8f_49e1_917d_d136b927d774;
    }

    int c() throws java.io.IOException {
        super.mark(1);
        final int v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e = super.read();
        super.reset();
        return v083fe0bb_f5c7_4102_bc79_3df5e9ee3f4e;
    }

    long d() {
        if (((((vba85b1dd_b585_4a76_83c9_69edcb55a51f) == (org.apache.commons.csv.Constants.v75045f96_5308_47ab_9cd2_f8db4f1ead8c)) || ((vba85b1dd_b585_4a76_83c9_69edcb55a51f) == (org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0))) || ((vba85b1dd_b585_4a76_83c9_69edcb55a51f) == (org.apache.commons.csv.Constants.v49caa2e4_ffeb_4f1a_8f9d_415673c83f65))) || ((vba85b1dd_b585_4a76_83c9_69edcb55a51f) == (org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede))) {
            return vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6;
        } 
        return (vbadbbbeb_3ad6_4f5b_9e7e_5e8421c7cfb6) + 1;
    }

    long e() {
        return this.v12ffbbc7_81b0_49b9_886c_f7baeaf1faa4;
    }

    public boolean a() {
        return ve04c97a8_3dc3_40e0_8151_7b89ecffd352;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        ve04c97a8_3dc3_40e0_8151_7b89ecffd352 = true;
        vba85b1dd_b585_4a76_83c9_69edcb55a51f = org.apache.commons.csv.Constants.v09df0b62_e087_4b38_ac1f_bc7871dfdede;
        super.close();
    }
}

