package org.apache.commons.io.input;


public abstract class ProxyInputStream extends java.io.FilterInputStream {
    public ProxyInputStream(final java.io.InputStream proxy) {
        super(proxy);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        try {
            beforeRead(1);
            final int b = in.read();
            afterRead((b != (org.apache.commons.io.IOUtils.EOF) ? 1 : org.apache.commons.io.IOUtils.EOF));
            return b;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public int read(final byte[] bts) throws java.io.IOException {
        try {
            beforeRead((bts != null ? bts.length : 0));
            final int n = in.read(bts);
            afterRead(n);
            return n;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public int read(final byte[] bts, final int off, final int len) throws java.io.IOException {
        try {
            beforeRead(len);
            final int n = in.read(bts, off, len);
            afterRead(n);
            return n;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public long skip(final long ln) throws java.io.IOException {
        try {
            return in.skip(ln);
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    @java.lang.Override
    public int available() throws java.io.IOException {
        try {
            return super.available();
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        try {
            in.close();
        } catch (final java.io.IOException e) {
            handleIOException(e);
        }
    }

    @java.lang.Override
    public synchronized void mark(final int readlimit) {
        in.mark(readlimit);
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        try {
            in.reset();
        } catch (final java.io.IOException e) {
            handleIOException(e);
        }
    }

    @java.lang.Override
    public boolean markSupported() {
        return in.markSupported();
    }

    protected void b(final int n) throws java.io.IOException {
    }

    protected void a(final int n) throws java.io.IOException {
    }

    protected void a(final java.io.IOException e) throws java.io.IOException {
        throw e;
    }
}

