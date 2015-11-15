package org.apache.commons.io.input;


public abstract class ProxyReader extends java.io.FilterReader {
    public ProxyReader(final java.io.Reader proxy) {
        super(proxy);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        try {
            beforeRead(1);
            final int c = in.read();
            afterRead((c != (org.apache.commons.io.IOUtils.EOF) ? 1 : org.apache.commons.io.IOUtils.EOF));
            return c;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public int read(final char[] chr) throws java.io.IOException {
        try {
            beforeRead((chr != null ? chr.length : 0));
            final int n = in.read(chr);
            afterRead(n);
            return n;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public int read(final char[] chr, final int st, final int len) throws java.io.IOException {
        try {
            beforeRead(len);
            final int n = in.read(chr, st, len);
            afterRead(n);
            return n;
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return org.apache.commons.io.IOUtils.EOF;
        }
    }

    @java.lang.Override
    public int read(final java.nio.CharBuffer target) throws java.io.IOException {
        try {
            beforeRead((target != null ? target.length() : 0));
            final int n = in.read(target);
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
    public boolean ready() throws java.io.IOException {
        try {
            return in.ready();
        } catch (final java.io.IOException e) {
            handleIOException(e);
            return false;
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
    public synchronized void mark(final int idx) throws java.io.IOException {
        try {
            in.mark(idx);
        } catch (final java.io.IOException e) {
            handleIOException(e);
        }
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

