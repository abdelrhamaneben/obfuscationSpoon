package org.apache.commons.io;


public class EndianUtils {
    public EndianUtils() {
        super();
    }

    public static short a(final short value) {
        return ((short)((((value >> 0) & 255) << 8) + (((value >> 8) & 255) << 0)));
    }

    public static int a(final int value) {
        return (((((value >> 0) & 255) << 24) + (((value >> 8) & 255) << 16)) + (((value >> 16) & 255) << 8)) + (((value >> 24) & 255) << 0);
    }

    public static long a(final long value) {
        return (((((((((value >> 0) & 255) << 56) + (((value >> 8) & 255) << 48)) + (((value >> 16) & 255) << 40)) + (((value >> 24) & 255) << 32)) + (((value >> 32) & 255) << 24)) + (((value >> 40) & 255) << 16)) + (((value >> 48) & 255) << 8)) + (((value >> 56) & 255) << 0);
    }

    public static float a(final float value) {
        return java.lang.Float.intBitsToFloat(org.apache.commons.io.EndianUtils.swapInteger(java.lang.Float.floatToIntBits(value)));
    }

    public static double a(final double value) {
        return java.lang.Double.longBitsToDouble(org.apache.commons.io.EndianUtils.swapLong(java.lang.Double.doubleToLongBits(value)));
    }

    public static void a(final byte[] data, final int offset, final short value) {
        data[(offset + 0)] = ((byte)((value >> 0) & 255));
        data[(offset + 1)] = ((byte)((value >> 8) & 255));
    }

    public static short g(final byte[] data, final int offset) {
        return ((short)((((data[(offset + 0)]) & 255) << 0) + (((data[(offset + 1)]) & 255) << 8)));
    }

    public static int d(final byte[] data, final int offset) {
        return (((data[(offset + 0)]) & 255) << 0) + (((data[(offset + 1)]) & 255) << 8);
    }

    public static void a(final byte[] data, final int offset, final int value) {
        data[(offset + 0)] = ((byte)((value >> 0) & 255));
        data[(offset + 1)] = ((byte)((value >> 8) & 255));
        data[(offset + 2)] = ((byte)((value >> 16) & 255));
        data[(offset + 3)] = ((byte)((value >> 24) & 255));
    }

    public static int c(final byte[] data, final int offset) {
        return (((((data[(offset + 0)]) & 255) << 0) + (((data[(offset + 1)]) & 255) << 8)) + (((data[(offset + 2)]) & 255) << 16)) + (((data[(offset + 3)]) & 255) << 24);
    }

    public static long f(final byte[] data, final int offset) {
        final long low = ((((data[(offset + 0)]) & 255) << 0) + (((data[(offset + 1)]) & 255) << 8)) + (((data[(offset + 2)]) & 255) << 16);
        final long high = (data[(offset + 3)]) & 255;
        return (high << 24) + (4294967295L & low);
    }

    public static void a(final byte[] data, final int offset, final long value) {
        data[(offset + 0)] = ((byte)((value >> 0) & 255));
        data[(offset + 1)] = ((byte)((value >> 8) & 255));
        data[(offset + 2)] = ((byte)((value >> 16) & 255));
        data[(offset + 3)] = ((byte)((value >> 24) & 255));
        data[(offset + 4)] = ((byte)((value >> 32) & 255));
        data[(offset + 5)] = ((byte)((value >> 40) & 255));
        data[(offset + 6)] = ((byte)((value >> 48) & 255));
        data[(offset + 7)] = ((byte)((value >> 56) & 255));
    }

    public static long e(final byte[] data, final int offset) {
        final long low = org.apache.commons.io.EndianUtils.readSwappedInteger(data, offset);
        final long high = org.apache.commons.io.EndianUtils.readSwappedInteger(data, (offset + 4));
        return (high << 32) + (4294967295L & low);
    }

    public static void a(final byte[] data, final int offset, final float value) {
        org.apache.commons.io.EndianUtils.writeSwappedInteger(data, offset, java.lang.Float.floatToIntBits(value));
    }

    public static float b(final byte[] data, final int offset) {
        return java.lang.Float.intBitsToFloat(org.apache.commons.io.EndianUtils.readSwappedInteger(data, offset));
    }

    public static void a(final byte[] data, final int offset, final double value) {
        org.apache.commons.io.EndianUtils.writeSwappedLong(data, offset, java.lang.Double.doubleToLongBits(value));
    }

    public static double a(final byte[] data, final int offset) {
        return java.lang.Double.longBitsToDouble(org.apache.commons.io.EndianUtils.readSwappedLong(data, offset));
    }

    public static void a(final java.io.OutputStream output, final short value) throws java.io.IOException {
        output.write(((byte)((value >> 0) & 255)));
        output.write(((byte)((value >> 8) & 255)));
    }

    public static short h(final java.io.InputStream input) throws java.io.IOException {
        return ((short)((((org.apache.commons.io.EndianUtils.read(input)) & 255) << 0) + (((org.apache.commons.io.EndianUtils.read(input)) & 255) << 8)));
    }

    public static int e(final java.io.InputStream input) throws java.io.IOException {
        final int value1 = org.apache.commons.io.EndianUtils.read(input);
        final int value2 = org.apache.commons.io.EndianUtils.read(input);
        return ((value1 & 255) << 0) + ((value2 & 255) << 8);
    }

    public static void a(final java.io.OutputStream output, final int value) throws java.io.IOException {
        output.write(((byte)((value >> 0) & 255)));
        output.write(((byte)((value >> 8) & 255)));
        output.write(((byte)((value >> 16) & 255)));
        output.write(((byte)((value >> 24) & 255)));
    }

    public static int d(final java.io.InputStream input) throws java.io.IOException {
        final int value1 = org.apache.commons.io.EndianUtils.read(input);
        final int value2 = org.apache.commons.io.EndianUtils.read(input);
        final int value3 = org.apache.commons.io.EndianUtils.read(input);
        final int value4 = org.apache.commons.io.EndianUtils.read(input);
        return ((((value1 & 255) << 0) + ((value2 & 255) << 8)) + ((value3 & 255) << 16)) + ((value4 & 255) << 24);
    }

    public static long g(final java.io.InputStream input) throws java.io.IOException {
        final int value1 = org.apache.commons.io.EndianUtils.read(input);
        final int value2 = org.apache.commons.io.EndianUtils.read(input);
        final int value3 = org.apache.commons.io.EndianUtils.read(input);
        final int value4 = org.apache.commons.io.EndianUtils.read(input);
        final long low = (((value1 & 255) << 0) + ((value2 & 255) << 8)) + ((value3 & 255) << 16);
        final long high = value4 & 255;
        return (high << 24) + (4294967295L & low);
    }

    public static void a(final java.io.OutputStream output, final long value) throws java.io.IOException {
        output.write(((byte)((value >> 0) & 255)));
        output.write(((byte)((value >> 8) & 255)));
        output.write(((byte)((value >> 16) & 255)));
        output.write(((byte)((value >> 24) & 255)));
        output.write(((byte)((value >> 32) & 255)));
        output.write(((byte)((value >> 40) & 255)));
        output.write(((byte)((value >> 48) & 255)));
        output.write(((byte)((value >> 56) & 255)));
    }

    public static long f(final java.io.InputStream input) throws java.io.IOException {
        final byte[] bytes = new byte[8];
        for (int i = 0 ; i < 8 ; i++) {
            bytes[i] = ((byte)(org.apache.commons.io.EndianUtils.read(input)));
        }
        return org.apache.commons.io.EndianUtils.readSwappedLong(bytes, 0);
    }

    public static void a(final java.io.OutputStream output, final float value) throws java.io.IOException {
        org.apache.commons.io.EndianUtils.writeSwappedInteger(output, java.lang.Float.floatToIntBits(value));
    }

    public static float b(final java.io.InputStream input) throws java.io.IOException {
        return java.lang.Float.intBitsToFloat(org.apache.commons.io.EndianUtils.readSwappedInteger(input));
    }

    public static void a(final java.io.OutputStream output, final double value) throws java.io.IOException {
        org.apache.commons.io.EndianUtils.writeSwappedLong(output, java.lang.Double.doubleToLongBits(value));
    }

    public static double a(final java.io.InputStream input) throws java.io.IOException {
        return java.lang.Double.longBitsToDouble(org.apache.commons.io.EndianUtils.readSwappedLong(input));
    }

    private static int c(final java.io.InputStream input) throws java.io.IOException {
        final int value = input.read();
        if ((org.apache.commons.io.IOUtils.EOF) == value) {
            throw new java.io.EOFException("Unexpected EOF reached");
        } 
        return value;
    }
}

