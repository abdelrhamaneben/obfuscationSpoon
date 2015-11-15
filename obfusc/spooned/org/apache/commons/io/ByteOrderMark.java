package org.apache.commons.io;


public class ByteOrderMark implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public static final org.apache.commons.io.ByteOrderMark UTF_8 = new org.apache.commons.io.ByteOrderMark("UTF-8" , 239 , 187 , 191);

    public static final org.apache.commons.io.ByteOrderMark UTF_16BE = new org.apache.commons.io.ByteOrderMark("UTF-16BE" , 254 , 255);

    public static final org.apache.commons.io.ByteOrderMark UTF_16LE = new org.apache.commons.io.ByteOrderMark("UTF-16LE" , 255 , 254);

    public static final org.apache.commons.io.ByteOrderMark UTF_32BE = new org.apache.commons.io.ByteOrderMark("UTF-32BE" , 0 , 0 , 254 , 255);

    public static final org.apache.commons.io.ByteOrderMark UTF_32LE = new org.apache.commons.io.ByteOrderMark("UTF-32LE" , 255 , 254 , 0 , 0);

    public static final char UTF_BOM = '﻿';

    private final java.lang.String charsetName;

    private final int[] bytes;

    public ByteOrderMark(final java.lang.String charsetName ,final int... bytes) {
        if ((charsetName == null) || (charsetName.isEmpty())) {
            throw new java.lang.IllegalArgumentException("No charsetName specified");
        } 
        if ((bytes == null) || ((bytes.length) == 0)) {
            throw new java.lang.IllegalArgumentException("No bytes specified");
        } 
        this.charsetName = charsetName;
        this.bytes = new int[bytes.length];
        java.lang.System.arraycopy(bytes, 0, this.bytes, 0, bytes.length);
    }

    public java.lang.String c() {
        return charsetName;
    }

    public int b() {
        return bytes.length;
    }

    public int a(final int pos) {
        return bytes[pos];
    }

    public byte[] a() {
        final byte[] copy = new byte[bytes.length];
        for (int i = 0 ; i < (bytes.length) ; i++) {
            copy[i] = ((byte)(bytes[i]));
        }
        return copy;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (!(obj instanceof org.apache.commons.io.ByteOrderMark)) {
            return false;
        } 
        final org.apache.commons.io.ByteOrderMark bom = ((org.apache.commons.io.ByteOrderMark)(obj));
        if ((bytes.length) != (bom.length())) {
            return false;
        } 
        for (int i = 0 ; i < (bytes.length) ; i++) {
            if ((bytes[i]) != (bom.get(i))) {
                return false;
            } 
        }
        return true;
    }

    @java.lang.Override
    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (final int b : bytes) {
            hashCode += b;
        }
        return hashCode;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append('[');
        builder.append(charsetName);
        builder.append(": ");
        for (int i = 0 ; i < (bytes.length) ; i++) {
            if (i > 0) {
                builder.append(",");
            } 
            builder.append("0x");
            builder.append(java.lang.Integer.toHexString((255 & (bytes[i]))).toUpperCase());
        }
        builder.append(']');
        return builder.toString();
    }
}

