package org.apache.commons.io.input;


public class BoundedReader extends java.io.Reader {
    private static final int INVALID = -1;

    private final java.io.Reader target;

    private int charsRead = 0;

    private int markedAt = INVALID;

    private int readAheadLimit;

    private final int maxCharsFromTargetReader;

    public BoundedReader(java.io.Reader target ,int maxCharsFromTargetReader) throws java.io.IOException {
        this.target = target;
        this.maxCharsFromTargetReader = maxCharsFromTargetReader;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        target.close();
    }

    @java.lang.Override
    public void reset() throws java.io.IOException {
        charsRead = markedAt;
        target.reset();
    }

    @java.lang.Override
    public void mark(int readAheadLimit) throws java.io.IOException {
        this.readAheadLimit = readAheadLimit - (charsRead);
        markedAt = charsRead;
        target.mark(readAheadLimit);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        if ((charsRead) >= (maxCharsFromTargetReader)) {
            return -1;
        } 
        if (((markedAt) >= 0) && (((charsRead) - (markedAt)) >= (readAheadLimit))) {
            return -1;
        } 
        (charsRead)++;
        return target.read();
    }

    @java.lang.Override
    public int read(char[] cbuf, int off, int len) throws java.io.IOException {
        int c;
        for (int i = 0 ; i < len ; i++) {
            c = read();
            if (c == (-1)) {
                return i;
            } 
            cbuf[(off + i)] = ((char)(c));
        }
        return len;
    }
}

