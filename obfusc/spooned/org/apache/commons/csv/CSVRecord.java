package org.apache.commons.csv;


public final class CSVRecord implements java.io.Serializable , java.lang.Iterable<java.lang.String> {
    private static final java.lang.String[] ve771d5e2_28d3_4ba9_adaa_1a61c2362e37 = new java.lang.String[0];

    private static final long veafb09a9_6285_49cb_8bdc_4300f89d1b2a = 1L;

    private final long v80317686_ef9c_42c9_86df_c59cad931592;

    private final java.lang.String v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721;

    private final java.util.Map<java.lang.String, java.lang.Integer> v15423260_dde3_4c7c_b2f7_94811f03d9e8;

    private final long ve92d7808_f944_48fe_9175_7fdd1d4b9519;

    private final java.lang.String[] va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be;

    CSVRecord(final java.lang.String[] va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be ,final java.util.Map<java.lang.String, java.lang.Integer> v15423260_dde3_4c7c_b2f7_94811f03d9e8 ,final java.lang.String v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721 ,final long ve92d7808_f944_48fe_9175_7fdd1d4b9519 ,final long v80317686_ef9c_42c9_86df_c59cad931592) {
        this.ve92d7808_f944_48fe_9175_7fdd1d4b9519 = ve92d7808_f944_48fe_9175_7fdd1d4b9519;
        this.va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be = va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be != null ? va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be : ve771d5e2_28d3_4ba9_adaa_1a61c2362e37;
        this.v15423260_dde3_4c7c_b2f7_94811f03d9e8 = v15423260_dde3_4c7c_b2f7_94811f03d9e8;
        this.v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721 = v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721;
        this.v80317686_ef9c_42c9_86df_c59cad931592 = v80317686_ef9c_42c9_86df_c59cad931592;
    }

    public java.lang.String a(final java.lang.Enum<?> v991c9f69_83b6_4b14_b315_bc0771a5c384) {
        return c(v991c9f69_83b6_4b14_b315_bc0771a5c384.toString());
    }

    public java.lang.String a(final int ve80b1152_e1ec_473f_b7c5_255785978c71) {
        return va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be[ve80b1152_e1ec_473f_b7c5_255785978c71];
    }

    public java.lang.String c(final java.lang.String v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4) {
        if ((v15423260_dde3_4c7c_b2f7_94811f03d9e8) == null) {
            throw new java.lang.IllegalStateException(toto.totoStringConstantes.v7c411cd0_ea1b_491f_b37b_0e806440bd65);
        } 
        final java.lang.Integer vc8c283e4_89b0_40e6_91ec_7edf4bc7618e = v15423260_dde3_4c7c_b2f7_94811f03d9e8.get(v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4);
        if (vc8c283e4_89b0_40e6_91ec_7edf4bc7618e == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(toto.totoStringConstantes.v64c99748_0cdd_4bc4_a1bf_2deba5a94869, v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4, v15423260_dde3_4c7c_b2f7_94811f03d9e8.keySet()));
        } 
        try {
            return va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be[vc8c283e4_89b0_40e6_91ec_7edf4bc7618e.intValue()];
        } catch (final java.lang.ArrayIndexOutOfBoundsException v991c9f69_83b6_4b14_b315_bc0771a5c384) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(toto.totoStringConstantes.v6449303b_58aa_43d7_929d_59416fb64d38, v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4, vc8c283e4_89b0_40e6_91ec_7edf4bc7618e, java.lang.Integer.valueOf(va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length)));
        }
    }

    public long g() {
        return v80317686_ef9c_42c9_86df_c59cad931592;
    }

    public java.lang.String c() {
        return v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721;
    }

    public long h() {
        return ve92d7808_f944_48fe_9175_7fdd1d4b9519;
    }

    public boolean a() {
        return ((v15423260_dde3_4c7c_b2f7_94811f03d9e8) == null) || ((v15423260_dde3_4c7c_b2f7_94811f03d9e8.size()) == (va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length));
    }

    public boolean a(final java.lang.String v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4) {
        return ((v15423260_dde3_4c7c_b2f7_94811f03d9e8) != null) && (v15423260_dde3_4c7c_b2f7_94811f03d9e8.containsKey(v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4));
    }

    public boolean b(final java.lang.String v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4) {
        return (a(v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4)) && ((v15423260_dde3_4c7c_b2f7_94811f03d9e8.get(v48a5cff4_374f_4c5b_b1d0_fe21b235e2c4).intValue()) < (va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length));
    }

    @java.lang.Override
    public java.util.Iterator<java.lang.String> iterator() {
        return e().iterator();
    }

    <M extends java.util.Map<java.lang.String, java.lang.String>>M a(final M vf2704457_7f92_4d7d_9765_d9af95953a09) {
        if ((v15423260_dde3_4c7c_b2f7_94811f03d9e8) == null) {
            return vf2704457_7f92_4d7d_9765_d9af95953a09;
        } 
        for (final java.util.Map.Entry<java.lang.String, java.lang.Integer> ve9fc7197_5a9e_4a0c_9ba2_d998e9b29089 : v15423260_dde3_4c7c_b2f7_94811f03d9e8.entrySet()) {
            final int v703c5aa1_6786_4efd_b185_d2372cf31623 = ve9fc7197_5a9e_4a0c_9ba2_d998e9b29089.getValue().intValue();
            if (v703c5aa1_6786_4efd_b185_d2372cf31623 < (va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length)) {
                vf2704457_7f92_4d7d_9765_d9af95953a09.put(ve9fc7197_5a9e_4a0c_9ba2_d998e9b29089.getKey(), va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be[v703c5aa1_6786_4efd_b185_d2372cf31623]);
            } 
        }
        return vf2704457_7f92_4d7d_9765_d9af95953a09;
    }

    public int b() {
        return va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length;
    }

    private java.util.List<java.lang.String> e() {
        return java.util.Arrays.asList(va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be);
    }

    public java.util.Map<java.lang.String, java.lang.String> f() {
        return a(new java.util.HashMap<java.lang.String, java.lang.String>(va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be.length));
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((((((toto.totoStringConstantes.v5e1a8ea2_abef_4ee8_b6ca_e7f3cabca75e + (v3dbb45e2_f83e_4c30_acd8_4cb5d9ec4721)) + toto.totoStringConstantes.ve70a06a1_2e44_4c61_860f_845af6a5bf8b) + (v15423260_dde3_4c7c_b2f7_94811f03d9e8)) + toto.totoStringConstantes.vf844cd32_430d_4e53_99de_28c19848be68) + (ve92d7808_f944_48fe_9175_7fdd1d4b9519)) + toto.totoStringConstantes.vdede1103_ec20_4cf5_b8ba_ff730e75e747) + (java.util.Arrays.toString(va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be))) + toto.totoStringConstantes.v6fdc1313_5ea1_4d35_b6ad_4a52312776f2;
    }

    java.lang.String[] d() {
        return va2ffe59e_88a3_47f3_b2e3_d1354d1dc1be;
    }
}

