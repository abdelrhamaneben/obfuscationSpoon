package org.apache.commons.io.input;


public class BrokenInputStream extends java.io.InputStream {
    private final java.io.IOException exception;

    public BrokenInputStream(final java.io.IOException exception) {
        this.exception = exception;
    }

    public BrokenInputStream() {
        this(new java.io.IOException("Broken input stream"));
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        throw exception;
    }

    @java.lang.Override
    public int available() throws java.io.IOException {
        throw exception;
    }

    @java.lang.Override
    public long skip(final long n) throws java.io.IOException {
        throw exception;
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        throw exception;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        throw exception;
    }
}

