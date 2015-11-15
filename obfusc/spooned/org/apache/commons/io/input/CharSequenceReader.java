package org.apache.commons.io.input;


public class CharSequenceReader extends java.io.Reader implements java.io.Serializable {
    private static final long serialVersionUID = 3724187752191401220L;

    private final java.lang.CharSequence charSequence;

    private int idx;

    private int mark;

    public CharSequenceReader(final java.lang.CharSequence charSequence) {
        this.charSequence = charSequence != null ? charSequence : "";
    }

    @java.lang.Override
    public void close() {
        idx = 0;
        mark = 0;
    }

    @java.lang.Override
    public void mark(final int readAheadLimit) {
        mark = idx;
    }

    @java.lang.Override
    public boolean markSupported() {
        return true;
    }

    @java.lang.Override
    public int read() {
        if ((idx) >= (charSequence.length())) {
            return org.apache.commons.io.IOUtils.EOF;
        } else {
            return charSequence.charAt((idx)++);
        }
    }

    @java.lang.Override
    public int read(final char[] array, final int offset, final int length) {
        if ((idx) >= (charSequence.length())) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        if (array == null) {
            throw new java.lang.NullPointerException("Character array is missing");
        } 
        if (((length < 0) || (offset < 0)) || ((offset + length) > (array.length))) {
            throw new java.lang.IndexOutOfBoundsException(((((("Array Size=" + (array.length)) + ", offset=") + offset) + ", length=") + length));
        } 
        int count = 0;
        for (int i = 0 ; i < length ; i++) {
            final int c = read();
            if (c == (org.apache.commons.io.IOUtils.EOF)) {
                return count;
            } 
            array[(offset + i)] = ((char)(c));
            count++;
        }
        return count;
    }

    @java.lang.Override
    public void reset() {
        idx = mark;
    }

    @java.lang.Override
    public long skip(final long n) {
        if (n < 0) {
            throw new java.lang.IllegalArgumentException(("Number of characters to skip is less than zero: " + n));
        } 
        if ((idx) >= (charSequence.length())) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        final int dest = ((int)(java.lang.Math.min(charSequence.length(), ((idx) + n))));
        final int count = dest - (idx);
        idx = dest;
        return count;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return charSequence.toString();
    }
}

