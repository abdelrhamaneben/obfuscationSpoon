package org.apache.commons.io.input;


public class BoundedInputStream extends java.io.InputStream {
    private final java.io.InputStream in;

    private final long max;

    private long pos = 0;

    private long mark = org.apache.commons.io.IOUtils.EOF;

    private boolean propagateClose = true;

    public BoundedInputStream(final java.io.InputStream in ,final long size) {
        this.max = size;
        this.in = in;
    }

    public BoundedInputStream(final java.io.InputStream in) {
        this(in, org.apache.commons.io.IOUtils.EOF);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        if (((max) >= 0) && ((pos) >= (max))) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        final int result = in.read();
        (pos)++;
        return result;
    }

    @java.lang.Override
    public int read(final byte[] b) throws java.io.IOException {
        return read(b, 0, b.length);
    }

    @java.lang.Override
    public int read(final byte[] b, final int off, final int len) throws java.io.IOException {
        if (((max) >= 0) && ((pos) >= (max))) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        final long maxRead = (max) >= 0 ? java.lang.Math.min(len, ((max) - (pos))) : len;
        final int bytesRead = in.read(b, off, ((int)(maxRead)));
        if (bytesRead == (org.apache.commons.io.IOUtils.EOF)) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        pos += bytesRead;
        return bytesRead;
    }

    @java.lang.Override
    public long skip(final long n) throws java.io.IOException {
        final long toSkip = (max) >= 0 ? java.lang.Math.min(n, ((max) - (pos))) : n;
        final long skippedBytes = in.skip(toSkip);
        pos += skippedBytes;
        return skippedBytes;
    }

    @java.lang.Override
    public int available() throws java.io.IOException {
        if (((max) >= 0) && ((pos) >= (max))) {
            return 0;
        } 
        return in.available();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return in.toString();
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if (propagateClose) {
            in.close();
        } 
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        in.reset();
        pos = mark;
    }

    @java.lang.Override
    public synchronized void mark(final int readlimit) {
        in.mark(readlimit);
        mark = pos;
    }

    @java.lang.Override
    public boolean markSupported() {
        return in.markSupported();
    }

    public boolean a() {
        return propagateClose;
    }

    public void a(final boolean propagateClose) {
        this.propagateClose = propagateClose;
    }
}

