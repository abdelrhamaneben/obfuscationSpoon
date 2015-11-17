package org.apache.commons.csv;


public final class CSVParser implements java.io.Closeable , java.lang.Iterable<org.apache.commons.csv.CSVRecord> {
    public static org.apache.commons.csv.CSVParser a(final java.io.File v3735cf24_a197_4984_92d1_76a778786f64, final java.nio.charset.Charset vaf8940d0_150a_4b4c_8033_933e46107b7e, final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1) throws java.io.IOException {
        org.apache.commons.csv.Assertions.a(v3735cf24_a197_4984_92d1_76a778786f64, toto.totoStringConstantes.vaed5ea6d_c70f_4433_afd0_9cb64dd06bcc);
        org.apache.commons.csv.Assertions.a(ve5f721bc_309d_44a8_8287_6371e32911c1, toto.totoStringConstantes.vf1944b4d_993d_41f7_beef_1645eb3e65a8);
        return new org.apache.commons.csv.CSVParser(new java.io.InputStreamReader(new java.io.FileInputStream(v3735cf24_a197_4984_92d1_76a778786f64) , vaf8940d0_150a_4b4c_8033_933e46107b7e) , ve5f721bc_309d_44a8_8287_6371e32911c1);
    }

    public static org.apache.commons.csv.CSVParser a(final java.lang.String ve76abd69_6e67_4f7e_916d_192d0474aac3, final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1) throws java.io.IOException {
        org.apache.commons.csv.Assertions.a(ve76abd69_6e67_4f7e_916d_192d0474aac3, toto.totoStringConstantes.v2fd7bab1_390e_4f0d_9f79_e9005a2ee0e7);
        org.apache.commons.csv.Assertions.a(ve5f721bc_309d_44a8_8287_6371e32911c1, toto.totoStringConstantes.vf1944b4d_993d_41f7_beef_1645eb3e65a8);
        return new org.apache.commons.csv.CSVParser(new java.io.StringReader(ve76abd69_6e67_4f7e_916d_192d0474aac3) , ve5f721bc_309d_44a8_8287_6371e32911c1);
    }

    public static org.apache.commons.csv.CSVParser a(final java.net.URL v9001cac9_85f4_4053_b4b1_5785c64f59b4, final java.nio.charset.Charset vaf8940d0_150a_4b4c_8033_933e46107b7e, final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1) throws java.io.IOException {
        org.apache.commons.csv.Assertions.a(v9001cac9_85f4_4053_b4b1_5785c64f59b4, toto.totoStringConstantes.va3520808_eb22_467b_bbd6_848fca1cade2);
        org.apache.commons.csv.Assertions.a(vaf8940d0_150a_4b4c_8033_933e46107b7e, toto.totoStringConstantes.v2646d8e1_8785_4425_97f0_e061b812c32c);
        org.apache.commons.csv.Assertions.a(ve5f721bc_309d_44a8_8287_6371e32911c1, toto.totoStringConstantes.vf1944b4d_993d_41f7_beef_1645eb3e65a8);
        return new org.apache.commons.csv.CSVParser(new java.io.InputStreamReader(v9001cac9_85f4_4053_b4b1_5785c64f59b4.openStream() , vaf8940d0_150a_4b4c_8033_933e46107b7e) , ve5f721bc_309d_44a8_8287_6371e32911c1);
    }

    private final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1;

    private final java.util.Map<java.lang.String, java.lang.Integer> v4bb54536_d88f_4d7c_a6e0_3a95834979d2;

    private final org.apache.commons.csv.Lexer v632f0a48_c21a_49e8_9fba_a0970f60f0f8;

    private final java.util.List<java.lang.String> v90502a8c_e81d_4b2d_822f_22c9ba7b2740 = new java.util.ArrayList<java.lang.String>();

    private long ve92d7808_f944_48fe_9175_7fdd1d4b9519;

    private final long v212e1946_9793_4e80_b87c_b95b570d7aa0;

    private final org.apache.commons.csv.Token ve82182b8_4231_423d_b020_04227beaffbb = new org.apache.commons.csv.Token();

    public CSVParser(final java.io.Reader vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d ,final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1) throws java.io.IOException {
        this(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d, ve5f721bc_309d_44a8_8287_6371e32911c1, 0, 1);
    }

    public CSVParser(final java.io.Reader vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d ,final org.apache.commons.csv.CSVFormat ve5f721bc_309d_44a8_8287_6371e32911c1 ,final long v212e1946_9793_4e80_b87c_b95b570d7aa0 ,final long ve92d7808_f944_48fe_9175_7fdd1d4b9519) throws java.io.IOException {
        org.apache.commons.csv.Assertions.a(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d, toto.totoStringConstantes.vf5f7ddc3_80c0_41f3_aedc_c563ca6bfcaa);
        org.apache.commons.csv.Assertions.a(ve5f721bc_309d_44a8_8287_6371e32911c1, toto.totoStringConstantes.vf1944b4d_993d_41f7_beef_1645eb3e65a8);
        this.ve5f721bc_309d_44a8_8287_6371e32911c1 = ve5f721bc_309d_44a8_8287_6371e32911c1;
        this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8 = new org.apache.commons.csv.Lexer(ve5f721bc_309d_44a8_8287_6371e32911c1 , new org.apache.commons.csv.ExtendedBufferedReader(vca6ae099_05d0_4a0a_a28e_f1d905b0dd8d));
        this.v4bb54536_d88f_4d7c_a6e0_3a95834979d2 = d();
        this.v212e1946_9793_4e80_b87c_b95b570d7aa0 = v212e1946_9793_4e80_b87c_b95b570d7aa0;
        this.ve92d7808_f944_48fe_9175_7fdd1d4b9519 = ve92d7808_f944_48fe_9175_7fdd1d4b9519 - 1;
    }

    private void h() {
        final java.lang.String v4ae167ac_ffa7_418c_8a93_5c3f05279e81 = this.ve82182b8_4231_423d_b020_04227beaffbb.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8.toString();
        final java.lang.String v70267c9a_2351_4d5d_bf0b_493c724c7aac = this.ve5f721bc_309d_44a8_8287_6371e32911c1.n();
        if (v70267c9a_2351_4d5d_bf0b_493c724c7aac == null) {
            this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.add(v4ae167ac_ffa7_418c_8a93_5c3f05279e81);
        } else {
            this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.add((v4ae167ac_ffa7_418c_8a93_5c3f05279e81.equalsIgnoreCase(v70267c9a_2351_4d5d_bf0b_493c724c7aac) ? null : v4ae167ac_ffa7_418c_8a93_5c3f05279e81));
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if ((this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8) != null) {
            this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8.close();
        } 
    }

    public long e() {
        return this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8.d();
    }

    public java.util.Map<java.lang.String, java.lang.Integer> c() {
        return (this.v4bb54536_d88f_4d7c_a6e0_3a95834979d2) == null ? null : new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(this.v4bb54536_d88f_4d7c_a6e0_3a95834979d2);
    }

    public long f() {
        return this.ve92d7808_f944_48fe_9175_7fdd1d4b9519;
    }

    public java.util.List<org.apache.commons.csv.CSVRecord> b() throws java.io.IOException {
        org.apache.commons.csv.CSVRecord v0beef314_6ddb_40bd_a623_cdef51a90f52;
        final java.util.List<org.apache.commons.csv.CSVRecord> v5d10a044_1ebc_42c9_a176_b60ccaf35543 = new java.util.ArrayList<org.apache.commons.csv.CSVRecord>();
        while ((v0beef314_6ddb_40bd_a623_cdef51a90f52 = g()) != null) {
            v5d10a044_1ebc_42c9_a176_b60ccaf35543.add(v0beef314_6ddb_40bd_a623_cdef51a90f52);
        }
        return v5d10a044_1ebc_42c9_a176_b60ccaf35543;
    }

    private java.util.Map<java.lang.String, java.lang.Integer> d() throws java.io.IOException {
        java.util.Map<java.lang.String, java.lang.Integer> va042acdc_11a6_461f_9e46_fa06ac59607d = null;
        final java.lang.String[] v2227e799_dd7f_4cc7_9635_f1238242c56c = this.ve5f721bc_309d_44a8_8287_6371e32911c1.p();
        if (v2227e799_dd7f_4cc7_9635_f1238242c56c != null) {
            va042acdc_11a6_461f_9e46_fa06ac59607d = this.ve5f721bc_309d_44a8_8287_6371e32911c1.c() ? new java.util.TreeMap<java.lang.String, java.lang.Integer>(java.lang.String.CASE_INSENSITIVE_ORDER) : new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>();
            java.lang.String[] v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18 = null;
            if ((v2227e799_dd7f_4cc7_9635_f1238242c56c.length) == 0) {
                final org.apache.commons.csv.CSVRecord v627b2cad_1919_44c2_a583_a2f661151d7d = g();
                if (v627b2cad_1919_44c2_a583_a2f661151d7d != null) {
                    v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18 = v627b2cad_1919_44c2_a583_a2f661151d7d.d();
                } 
            } else {
                if (this.ve5f721bc_309d_44a8_8287_6371e32911c1.e()) {
                    g();
                } 
                v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18 = v2227e799_dd7f_4cc7_9635_f1238242c56c;
            }
            if (v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18 != null) {
                for (int ve80b1152_e1ec_473f_b7c5_255785978c71 = 0 ; ve80b1152_e1ec_473f_b7c5_255785978c71 < (v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18.length) ; ve80b1152_e1ec_473f_b7c5_255785978c71++) {
                    final java.lang.String v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b = v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18[ve80b1152_e1ec_473f_b7c5_255785978c71];
                    final boolean ve8194875_3c61_4d2b_8aa5_3f4b2b5020c5 = va042acdc_11a6_461f_9e46_fa06ac59607d.containsKey(v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b);
                    final boolean v72355d24_7a5f_4290_8eac_74d87ab84152 = (v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b == null) || (v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b.trim().isEmpty());
                    if (ve8194875_3c61_4d2b_8aa5_3f4b2b5020c5 && ((!v72355d24_7a5f_4290_8eac_74d87ab84152) || (v72355d24_7a5f_4290_8eac_74d87ab84152 && (!(this.ve5f721bc_309d_44a8_8287_6371e32911c1.a()))))) {
                        throw new java.lang.IllegalArgumentException((((toto.totoStringConstantes.v8ff7e36c_3eb0_47ec_96be_3b7259bc29a7 + v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b) + toto.totoStringConstantes.vca990365_ce64_4b48_8d6d_cbcc268e2a11) + (java.util.Arrays.toString(v1ef0dfc0_8c11_46d7_866a_68f4d1a68a18))));
                    } 
                    va042acdc_11a6_461f_9e46_fa06ac59607d.put(v0f3c4935_9483_45d7_9ea0_9bc8cc5e825b, java.lang.Integer.valueOf(ve80b1152_e1ec_473f_b7c5_255785978c71));
                }
            } 
        } 
        return va042acdc_11a6_461f_9e46_fa06ac59607d;
    }

    public boolean a() {
        return this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8.a();
    }

    @java.lang.Override
    public java.util.Iterator<org.apache.commons.csv.CSVRecord> iterator() {
        return new java.util.Iterator<org.apache.commons.csv.CSVRecord>() {
            private org.apache.commons.csv.CSVRecord v34107b0f_4537_4b32_afae_137f60346e56;

            private org.apache.commons.csv.CSVRecord a() {
                try {
                    return org.apache.commons.csv.CSVParser.this.g();
                } catch (final java.io.IOException v991c9f69_83b6_4b14_b315_bc0771a5c384) {
                    throw new java.lang.RuntimeException(v991c9f69_83b6_4b14_b315_bc0771a5c384);
                }
            }

            @java.lang.Override
            public boolean hasNext() {
                if (org.apache.commons.csv.CSVParser.this.a()) {
                    return false;
                } 
                if ((this.v34107b0f_4537_4b32_afae_137f60346e56) == null) {
                    this.v34107b0f_4537_4b32_afae_137f60346e56 = a();
                } 
                return (this.v34107b0f_4537_4b32_afae_137f60346e56) != null;
            }

            @java.lang.Override
            public org.apache.commons.csv.CSVRecord next() {
                if (org.apache.commons.csv.CSVParser.this.a()) {
                    throw new java.util.NoSuchElementException(toto.totoStringConstantes.v4754dfce_aa2c_43d2_98e1_fbaa44204921);
                } 
                org.apache.commons.csv.CSVRecord v52d530e7_4e62_45f5_b66e_9937d11d5ac1 = this.v34107b0f_4537_4b32_afae_137f60346e56;
                this.v34107b0f_4537_4b32_afae_137f60346e56 = null;
                if (v52d530e7_4e62_45f5_b66e_9937d11d5ac1 == null) {
                    v52d530e7_4e62_45f5_b66e_9937d11d5ac1 = a();
                    if (v52d530e7_4e62_45f5_b66e_9937d11d5ac1 == null) {
                        throw new java.util.NoSuchElementException(toto.totoStringConstantes.v8da2e80f_9df7_4dea_95ce_f57363f55bbd);
                    } 
                } 
                return v52d530e7_4e62_45f5_b66e_9937d11d5ac1;
            }

            @java.lang.Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    org.apache.commons.csv.CSVRecord g() throws java.io.IOException {
        org.apache.commons.csv.CSVRecord v37168378_8ab2_402c_82b2_bdbacfb5a574 = null;
        this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.clear();
        java.lang.StringBuilder veddeea5c_ec73_4930_ac12_64d4878d1662 = null;
        final long vdfcfbdac_fd88_4db5_9365_23dccee703fe = (v632f0a48_c21a_49e8_9fba_a0970f60f0f8.c()) + (this.v212e1946_9793_4e80_b87c_b95b570d7aa0);
        do {
            this.ve82182b8_4231_423d_b020_04227beaffbb.a();
            this.v632f0a48_c21a_49e8_9fba_a0970f60f0f8.a(this.ve82182b8_4231_423d_b020_04227beaffbb);
            switch (this.ve82182b8_4231_423d_b020_04227beaffbb.v76d145cf_ee7f_4603_a9bd_233ee3072f63) {
                case v60e5332e_7bfb_4320_93d6_779736ac6331 :
                    h();
                    break;
                case va3b8a558_18b2_4b2d_a9a4_15e411538a51 :
                    h();
                    break;
                case ve340628d_6285_467c_8287_52a0d117c0de :
                    if (this.ve82182b8_4231_423d_b020_04227beaffbb.v1eb8d52d_d259_4046_bb48_97d066892663) {
                        h();
                    } 
                    break;
                case vcd967bed_e5aa_4a5f_8f78_2d03f3825dd4 :
                    throw new java.io.IOException(((toto.totoStringConstantes.v526e9374_d4ce_41b0_9f86_47e372353f6d + (e())) + toto.totoStringConstantes.v382ed5c4_bbf4_47ca_b5f5_66518d2df48c));
                case vd6e30361_0376_4fe8_8488_1ac29949eb2e :
                    if (veddeea5c_ec73_4930_ac12_64d4878d1662 == null) {
                        veddeea5c_ec73_4930_ac12_64d4878d1662 = new java.lang.StringBuilder();
                    } else {
                        veddeea5c_ec73_4930_ac12_64d4878d1662.append(org.apache.commons.csv.Constants.v40af5569_3bee_44cb_bbd6_c23bc40ee4d0);
                    }
                    veddeea5c_ec73_4930_ac12_64d4878d1662.append(this.ve82182b8_4231_423d_b020_04227beaffbb.v7dbc069e_2ba2_4951_94db_5a6d5e1be4a8);
                    this.ve82182b8_4231_423d_b020_04227beaffbb.v76d145cf_ee7f_4603_a9bd_233ee3072f63 = org.apache.commons.csv.Token.Type.v60e5332e_7bfb_4320_93d6_779736ac6331;
                    break;
                default :
                    throw new java.lang.IllegalStateException((toto.totoStringConstantes.v2c352712_68bb_4e8c_9653_bfc91466d049 + (this.ve82182b8_4231_423d_b020_04227beaffbb.v76d145cf_ee7f_4603_a9bd_233ee3072f63)));
            }
        } while ((this.ve82182b8_4231_423d_b020_04227beaffbb.v76d145cf_ee7f_4603_a9bd_233ee3072f63) == (org.apache.commons.csv.Token.Type.v60e5332e_7bfb_4320_93d6_779736ac6331) );
        if (!(this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.isEmpty())) {
            (this.ve92d7808_f944_48fe_9175_7fdd1d4b9519)++;
            final java.lang.String v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721 = veddeea5c_ec73_4930_ac12_64d4878d1662 == null ? null : veddeea5c_ec73_4930_ac12_64d4878d1662.toString();
            v37168378_8ab2_402c_82b2_bdbacfb5a574 = new org.apache.commons.csv.CSVRecord(this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.toArray(new java.lang.String[this.v90502a8c_e81d_4b2d_822f_22c9ba7b2740.size()]) , this.v4bb54536_d88f_4d7c_a6e0_3a95834979d2 , v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721 , this.ve92d7808_f944_48fe_9175_7fdd1d4b9519 , vdfcfbdac_fd88_4db5_9365_23dccee703fe);
        } 
        return v37168378_8ab2_402c_82b2_bdbacfb5a574;
    }
}

