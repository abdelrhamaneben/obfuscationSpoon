package org.apache.commons.io.input;


public class NullInputStream extends java.io.InputStream {
    private final long size;

    private long position;

    private long mark = -1;

    private long readlimit;

    private boolean eof;

    private final boolean throwEofException;

    private final boolean markSupported;

    public NullInputStream(final long size) {
        this(size, true, false);
    }

    public NullInputStream(final long size ,final boolean markSupported ,final boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
    }

    public long c() {
        return position;
    }

    public long d() {
        return size;
    }

    @java.lang.Override
    public int available() {
        final long avail = (size) - (position);
        if (avail <= 0) {
            return 0;
        } else if (avail > (java.lang.Integer.MAX_VALUE)) {
            return java.lang.Integer.MAX_VALUE;
        } else {
            return ((int)(avail));
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        eof = false;
        position = 0;
        mark = -1;
    }

    @java.lang.Override
    public synchronized void mark(final int readlimit) {
        if (!(markSupported)) {
            throw new java.lang.UnsupportedOperationException("Mark not supported");
        } 
        mark = position;
        this.readlimit = readlimit;
    }

    @java.lang.Override
    public boolean markSupported() {
        return markSupported;
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        if (eof) {
            throw new java.io.IOException("Read after end of file");
        } 
        if ((position) == (size)) {
            return doEndOfFile();
        } 
        (position)++;
        return processByte();
    }

    @java.lang.Override
    public int read(final byte[] bytes) throws java.io.IOException {
        return read(bytes, 0, bytes.length);
    }

    @java.lang.Override
    public int read(final byte[] bytes, final int offset, final int length) throws java.io.IOException {
        if (eof) {
            throw new java.io.IOException("Read after end of file");
        } 
        if ((position) == (size)) {
            return doEndOfFile();
        } 
        position += length;
        int returnLength = length;
        if ((position) > (size)) {
            returnLength = length - ((int)(((position) - (size))));
            position = size;
        } 
        processBytes(bytes, offset, returnLength);
        return returnLength;
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        if (!(markSupported)) {
            throw new java.lang.UnsupportedOperationException("Mark not supported");
        } 
        if ((mark) < 0) {
            throw new java.io.IOException("No position has been marked");
        } 
        if ((position) > ((mark) + (readlimit))) {
            throw new java.io.IOException((((("Marked position [" + (mark)) + "] is no longer valid - passed the read limit [") + (readlimit)) + "]"));
        } 
        position = mark;
        eof = false;
    }

    @java.lang.Override
    public long skip(final long numberOfBytes) throws java.io.IOException {
        if (eof) {
            throw new java.io.IOException("Skip after end of file");
        } 
        if ((position) == (size)) {
            return doEndOfFile();
        } 
        position += numberOfBytes;
        long returnLength = numberOfBytes;
        if ((position) > (size)) {
            returnLength = numberOfBytes - ((position) - (size));
            position = size;
        } 
        return returnLength;
    }

    protected int b() {
        return 0;
    }

    protected void a(final byte[] bytes, final int offset, final int length) {
    }

    private int a() throws java.io.EOFException {
        eof = true;
        if (throwEofException) {
            throw new java.io.EOFException();
        } 
        return org.apache.commons.io.IOUtils.EOF;
    }
}

