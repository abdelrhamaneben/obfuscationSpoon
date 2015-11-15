package org.apache.commons.io;


public class EndianUtilsTest extends junit.framework.TestCase {
    public EndianUtilsTest(final java.lang.String name) {
        super(name);
    }

    public void a() {
        new org.apache.commons.io.EndianUtils();
    }

    public void b() throws java.io.IOException {
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(new byte[]{  });
        try {
            org.apache.commons.io.EndianUtils.readSwappedDouble(input);
            junit.framework.TestCase.fail("Expected EOFException");
        } catch (final java.io.EOFException e) {
        }
    }

    public void n() {
        junit.framework.TestCase.assertEquals(((short)(0)), org.apache.commons.io.EndianUtils.swapShort(((short)(0))));
        junit.framework.TestCase.assertEquals(((short)(513)), org.apache.commons.io.EndianUtils.swapShort(((short)(258))));
        junit.framework.TestCase.assertEquals(((short)(65535)), org.apache.commons.io.EndianUtils.swapShort(((short)(65535))));
        junit.framework.TestCase.assertEquals(((short)(258)), org.apache.commons.io.EndianUtils.swapShort(((short)(513))));
    }

    public void l() {
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.EndianUtils.swapInteger(0));
        junit.framework.TestCase.assertEquals(67305985, org.apache.commons.io.EndianUtils.swapInteger(16909060));
        junit.framework.TestCase.assertEquals(16777216, org.apache.commons.io.EndianUtils.swapInteger(1));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.EndianUtils.swapInteger(16777216));
        junit.framework.TestCase.assertEquals(286331153, org.apache.commons.io.EndianUtils.swapInteger(286331153));
        junit.framework.TestCase.assertEquals(-1412567280, org.apache.commons.io.EndianUtils.swapInteger(284151211));
        junit.framework.TestCase.assertEquals(171, org.apache.commons.io.EndianUtils.swapInteger(-1426063360));
    }

    public void m() {
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.EndianUtils.swapLong(0));
        junit.framework.TestCase.assertEquals(578437695752307201L, org.apache.commons.io.EndianUtils.swapLong(72623859790382856L));
        junit.framework.TestCase.assertEquals(-1L, org.apache.commons.io.EndianUtils.swapLong(-1L));
        junit.framework.TestCase.assertEquals(171, org.apache.commons.io.EndianUtils.swapLong(-6124895493223874560L));
    }

    public void k() {
        junit.framework.TestCase.assertEquals(0.0F, org.apache.commons.io.EndianUtils.swapFloat(0.0F), 0.0);
        final float f1 = java.lang.Float.intBitsToFloat(16909060);
        final float f2 = java.lang.Float.intBitsToFloat(67305985);
        junit.framework.TestCase.assertEquals(f2, org.apache.commons.io.EndianUtils.swapFloat(f1), 0.0);
    }

    public void j() {
        junit.framework.TestCase.assertEquals(0.0, org.apache.commons.io.EndianUtils.swapDouble(0.0), 0.0);
        final double d1 = java.lang.Double.longBitsToDouble(72623859790382856L);
        final double d2 = java.lang.Double.longBitsToDouble(578437695752307201L);
        junit.framework.TestCase.assertEquals(d2, org.apache.commons.io.EndianUtils.swapDouble(d1), 0.0);
    }

    public void o() {
        junit.framework.TestCase.assertEquals(((short)(258)), org.apache.commons.io.EndianUtils.swapShort(org.apache.commons.io.EndianUtils.swapShort(((short)(258)))));
        junit.framework.TestCase.assertEquals(16909060, org.apache.commons.io.EndianUtils.swapInteger(org.apache.commons.io.EndianUtils.swapInteger(16909060)));
        junit.framework.TestCase.assertEquals(72623859790382856L, org.apache.commons.io.EndianUtils.swapLong(org.apache.commons.io.EndianUtils.swapLong(72623859790382856L)));
        final float f1 = java.lang.Float.intBitsToFloat(16909060);
        junit.framework.TestCase.assertEquals(f1, org.apache.commons.io.EndianUtils.swapFloat(org.apache.commons.io.EndianUtils.swapFloat(f1)), 0.0);
        final double d1 = java.lang.Double.longBitsToDouble(72623859790382856L);
        junit.framework.TestCase.assertEquals(d1, org.apache.commons.io.EndianUtils.swapDouble(org.apache.commons.io.EndianUtils.swapDouble(d1)), 0.0);
    }

    public void g() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 2 , 1 };
        junit.framework.TestCase.assertEquals(258, org.apache.commons.io.EndianUtils.readSwappedShort(bytes, 0));
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(258, org.apache.commons.io.EndianUtils.readSwappedShort(input));
    }

    public void v() throws java.io.IOException {
        byte[] bytes = new byte[2];
        org.apache.commons.io.EndianUtils.writeSwappedShort(bytes, 0, ((short)(258)));
        junit.framework.TestCase.assertEquals(2, bytes[0]);
        junit.framework.TestCase.assertEquals(1, bytes[1]);
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(2);
        org.apache.commons.io.EndianUtils.writeSwappedShort(baos, ((short)(258)));
        bytes = baos.toByteArray();
        junit.framework.TestCase.assertEquals(2, bytes[0]);
        junit.framework.TestCase.assertEquals(1, bytes[1]);
    }

    public void i() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 2 , 1 };
        junit.framework.TestCase.assertEquals(258, org.apache.commons.io.EndianUtils.readSwappedUnsignedShort(bytes, 0));
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(258, org.apache.commons.io.EndianUtils.readSwappedUnsignedShort(input));
    }

    public void e() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 4 , 3 , 2 , 1 };
        junit.framework.TestCase.assertEquals(16909060, org.apache.commons.io.EndianUtils.readSwappedInteger(bytes, 0));
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(16909060, org.apache.commons.io.EndianUtils.readSwappedInteger(input));
    }

    public void t() throws java.io.IOException {
        byte[] bytes = new byte[4];
        org.apache.commons.io.EndianUtils.writeSwappedInteger(bytes, 0, 16909060);
        junit.framework.TestCase.assertEquals(4, bytes[0]);
        junit.framework.TestCase.assertEquals(3, bytes[1]);
        junit.framework.TestCase.assertEquals(2, bytes[2]);
        junit.framework.TestCase.assertEquals(1, bytes[3]);
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(4);
        org.apache.commons.io.EndianUtils.writeSwappedInteger(baos, 16909060);
        bytes = baos.toByteArray();
        junit.framework.TestCase.assertEquals(4, bytes[0]);
        junit.framework.TestCase.assertEquals(3, bytes[1]);
        junit.framework.TestCase.assertEquals(2, bytes[2]);
        junit.framework.TestCase.assertEquals(1, bytes[3]);
    }

    public void h() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 4 , 3 , 2 , 1 };
        junit.framework.TestCase.assertEquals(16909060L, org.apache.commons.io.EndianUtils.readSwappedUnsignedInteger(bytes, 0));
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(16909060L, org.apache.commons.io.EndianUtils.readSwappedUnsignedInteger(input));
    }

    public void f() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 };
        junit.framework.TestCase.assertEquals(72623859790382856L, org.apache.commons.io.EndianUtils.readSwappedLong(bytes, 0));
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(72623859790382856L, org.apache.commons.io.EndianUtils.readSwappedLong(input));
    }

    public void u() throws java.io.IOException {
        byte[] bytes = new byte[8];
        org.apache.commons.io.EndianUtils.writeSwappedLong(bytes, 0, 72623859790382856L);
        junit.framework.TestCase.assertEquals(8, bytes[0]);
        junit.framework.TestCase.assertEquals(7, bytes[1]);
        junit.framework.TestCase.assertEquals(6, bytes[2]);
        junit.framework.TestCase.assertEquals(5, bytes[3]);
        junit.framework.TestCase.assertEquals(4, bytes[4]);
        junit.framework.TestCase.assertEquals(3, bytes[5]);
        junit.framework.TestCase.assertEquals(2, bytes[6]);
        junit.framework.TestCase.assertEquals(1, bytes[7]);
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(8);
        org.apache.commons.io.EndianUtils.writeSwappedLong(baos, 72623859790382856L);
        bytes = baos.toByteArray();
        junit.framework.TestCase.assertEquals(8, bytes[0]);
        junit.framework.TestCase.assertEquals(7, bytes[1]);
        junit.framework.TestCase.assertEquals(6, bytes[2]);
        junit.framework.TestCase.assertEquals(5, bytes[3]);
        junit.framework.TestCase.assertEquals(4, bytes[4]);
        junit.framework.TestCase.assertEquals(3, bytes[5]);
        junit.framework.TestCase.assertEquals(2, bytes[6]);
        junit.framework.TestCase.assertEquals(1, bytes[7]);
    }

    public void d() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 4 , 3 , 2 , 1 };
        final float f1 = java.lang.Float.intBitsToFloat(16909060);
        final float f2 = org.apache.commons.io.EndianUtils.readSwappedFloat(bytes, 0);
        junit.framework.TestCase.assertEquals(f1, f2, 0.0);
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(f1, org.apache.commons.io.EndianUtils.readSwappedFloat(input), 0.0);
    }

    public void s() throws java.io.IOException {
        byte[] bytes = new byte[4];
        final float f1 = java.lang.Float.intBitsToFloat(16909060);
        org.apache.commons.io.EndianUtils.writeSwappedFloat(bytes, 0, f1);
        junit.framework.TestCase.assertEquals(4, bytes[0]);
        junit.framework.TestCase.assertEquals(3, bytes[1]);
        junit.framework.TestCase.assertEquals(2, bytes[2]);
        junit.framework.TestCase.assertEquals(1, bytes[3]);
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(4);
        org.apache.commons.io.EndianUtils.writeSwappedFloat(baos, f1);
        bytes = baos.toByteArray();
        junit.framework.TestCase.assertEquals(4, bytes[0]);
        junit.framework.TestCase.assertEquals(3, bytes[1]);
        junit.framework.TestCase.assertEquals(2, bytes[2]);
        junit.framework.TestCase.assertEquals(1, bytes[3]);
    }

    public void c() throws java.io.IOException {
        final byte[] bytes = new byte[]{ 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 };
        final double d1 = java.lang.Double.longBitsToDouble(72623859790382856L);
        final double d2 = org.apache.commons.io.EndianUtils.readSwappedDouble(bytes, 0);
        junit.framework.TestCase.assertEquals(d1, d2, 0.0);
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(bytes);
        junit.framework.TestCase.assertEquals(d1, org.apache.commons.io.EndianUtils.readSwappedDouble(input), 0.0);
    }

    public void r() throws java.io.IOException {
        byte[] bytes = new byte[8];
        final double d1 = java.lang.Double.longBitsToDouble(72623859790382856L);
        org.apache.commons.io.EndianUtils.writeSwappedDouble(bytes, 0, d1);
        junit.framework.TestCase.assertEquals(8, bytes[0]);
        junit.framework.TestCase.assertEquals(7, bytes[1]);
        junit.framework.TestCase.assertEquals(6, bytes[2]);
        junit.framework.TestCase.assertEquals(5, bytes[3]);
        junit.framework.TestCase.assertEquals(4, bytes[4]);
        junit.framework.TestCase.assertEquals(3, bytes[5]);
        junit.framework.TestCase.assertEquals(2, bytes[6]);
        junit.framework.TestCase.assertEquals(1, bytes[7]);
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(8);
        org.apache.commons.io.EndianUtils.writeSwappedDouble(baos, d1);
        bytes = baos.toByteArray();
        junit.framework.TestCase.assertEquals(8, bytes[0]);
        junit.framework.TestCase.assertEquals(7, bytes[1]);
        junit.framework.TestCase.assertEquals(6, bytes[2]);
        junit.framework.TestCase.assertEquals(5, bytes[3]);
        junit.framework.TestCase.assertEquals(4, bytes[4]);
        junit.framework.TestCase.assertEquals(3, bytes[5]);
        junit.framework.TestCase.assertEquals(2, bytes[6]);
        junit.framework.TestCase.assertEquals(1, bytes[7]);
    }

    public void p() {
        final double[] tests = new double[]{ 34.345 , -345.5645 , 545.12 , 10.043 , 7.123456789123 };
        for (final double test : tests) {
            byte[] buffer = new byte[8];
            final long ln1 = java.lang.Double.doubleToLongBits(test);
            org.apache.commons.io.EndianUtils.writeSwappedLong(buffer, 0, ln1);
            final long ln2 = org.apache.commons.io.EndianUtils.readSwappedLong(buffer, 0);
            junit.framework.TestCase.assertEquals(ln1, ln2);
            buffer = new byte[8];
            org.apache.commons.io.EndianUtils.writeSwappedDouble(buffer, 0, test);
            final double val = org.apache.commons.io.EndianUtils.readSwappedDouble(buffer, 0);
            junit.framework.TestCase.assertEquals(test, val, 0);
        }
    }

    public void q() throws java.lang.Exception {
        final byte[] target = new byte[]{ 0 , 0 , 0 , ((byte)(128)) };
        final long expected = 2147483648L;
        long actual = org.apache.commons.io.EndianUtils.readSwappedUnsignedInteger(target, 0);
        junit.framework.TestCase.assertEquals("readSwappedUnsignedInteger(byte[], int) was incorrect", expected, actual);
        final java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(target);
        actual = org.apache.commons.io.EndianUtils.readSwappedUnsignedInteger(in);
        junit.framework.TestCase.assertEquals("readSwappedUnsignedInteger(InputStream) was incorrect", expected, actual);
    }
}

