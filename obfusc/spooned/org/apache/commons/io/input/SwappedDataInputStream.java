package org.apache.commons.io.input;


public class SwappedDataInputStream extends org.apache.commons.io.input.ProxyInputStream implements java.io.DataInput {
    public SwappedDataInputStream(final java.io.InputStream input) {
        super(input);
    }

    public boolean skip() throws java.io.EOFException, java.io.IOException {
        return 0 != (readByte());
    }

    public byte mark() throws java.io.EOFException, java.io.IOException {
        return ((byte)(in.read()));
    }

    public char readChar() throws java.io.EOFException, java.io.IOException {
        return ((char)(readShort()));
    }

    public double a() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedDouble(in);
    }

    public float b() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedFloat(in);
    }

    public void a(final byte[] data) throws java.io.EOFException, java.io.IOException {
        readFully(data, 0, data.length);
    }

    public void a(final byte[] data, final int offset, final int length) throws java.io.EOFException, java.io.IOException {
        int remaining = length;
        while (remaining > 0) {
            final int location = (offset + length) - remaining;
            final int count = read(data, location, remaining);
            if ((org.apache.commons.io.IOUtils.EOF) == count) {
                throw new java.io.EOFException();
            } 
            remaining -= count;
        }
    }

    public int c() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedInteger(in);
    }

    public java.lang.String f() throws java.io.EOFException, java.io.IOException {
        throw new java.lang.UnsupportedOperationException("Operation not supported: readLine()");
    }

    public long h() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedLong(in);
    }

    public short i() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedShort(in);
    }

    public int d() throws java.io.EOFException, java.io.IOException {
        return in.read();
    }

    public int e() throws java.io.EOFException, java.io.IOException {
        return org.apache.commons.io.EndianUtils.readSwappedUnsignedShort(in);
    }

    public java.lang.String g() throws java.io.EOFException, java.io.IOException {
        throw new java.lang.UnsupportedOperationException("Operation not supported: readUTF()");
    }

    public int a(final int count) throws java.io.EOFException, java.io.IOException {
        return ((int)(in.skip(count)));
    }
}

