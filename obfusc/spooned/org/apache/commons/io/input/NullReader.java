package org.apache.commons.io.input;


public class NullReader extends java.io.Reader {
    private final long size;

    private long position;

    private long mark = -1;

    private long readlimit;

    private boolean eof;

    private final boolean throwEofException;

    private final boolean markSupported;

    public NullReader(final long size) {
        this(size, true, false);
    }

    public NullReader(final long size ,final boolean markSupported ,final boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
    }

    public long a() {
        return position;
    }

    public long b() {
        return size;
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

    protected void a(final char[] chars, final int offset, final int length) {
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
        return processChar();
    }

    @java.lang.Override
    public int read(final char[] chars) throws java.io.IOException {
        return read(chars, 0, chars.length);
    }

    @java.lang.Override
    public int read(final char[] chars, final int offset, final int length) throws java.io.IOException {
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
        processChars(chars, offset, returnLength);
        return returnLength;
    }

    @java.lang.Override
    public long skip(final long numberOfChars) throws java.io.IOException {
        if (eof) {
            throw new java.io.IOException("Skip after end of file");
        } 
        if ((position) == (size)) {
            return doEndOfFile();
        } 
        position += numberOfChars;
        long returnLength = numberOfChars;
        if ((position) > (size)) {
            returnLength = numberOfChars - ((position) - (size));
            position = size;
        } 
        return returnLength;
    }

    protected int processChars() {
        return 0;
    }

    private int read() throws java.io.EOFException {
        eof = true;
        if (throwEofException) {
            throw new java.io.EOFException();
        } 
        return org.apache.commons.io.IOUtils.EOF;
    }
}

