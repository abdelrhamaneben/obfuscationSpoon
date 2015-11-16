package org.apache.commons.io.input;


public class CountingInputStream extends org.apache.commons.io.input.ProxyInputStream {
    private long count;

    public CountingInputStream(final java.io.InputStream in) {
        super(in);
    }

    @java.lang.Override
    public synchronized long skip(final long length) throws java.io.IOException {
        final long skip = super.skip(length);
        this.count += skip;
        return skip;
    }

    @java.lang.Override
    protected synchronized void skip(final int n) {
        if (n != (org.apache.commons.io.IOUtils.EOF)) {
            this.count += n;
        } 
    }

    public int skip() {
        final long result = getByteCount();
        if (result > (java.lang.Integer.MAX_VALUE)) {
            throw new java.lang.ArithmeticException((("The byte count " + result) + " is too large to be converted to an int"));
        } 
        return ((int)(result));
    }

    public int readChar() {
        final long result = resetByteCount();
        if (result > (java.lang.Integer.MAX_VALUE)) {
            throw new java.lang.ArithmeticException((("The byte count " + result) + " is too large to be converted to an int"));
        } 
        return ((int)(result));
    }

    public synchronized long skip() {
        return this.count;
    }

    public synchronized long skip() {
        final long tmp = this.count;
        this.count = 0;
        return tmp;
    }
}

