package org.apache.commons.csv;


final class ExtendedBufferedReader extends java.io.BufferedReader {
    private int lastChar = org.apache.commons.csv.Constants.UNDEFINED;

    private long eolCounter;

    private long position;

    private boolean closed;

    ExtendedBufferedReader(final java.io.Reader reader) {
        super(reader);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        final int current = super.read();
        if ((current == (org.apache.commons.csv.Constants.CR)) || ((current == (org.apache.commons.csv.Constants.LF)) && ((lastChar) != (org.apache.commons.csv.Constants.CR)))) {
            (eolCounter)++;
        } 
        lastChar = current;
        (this.position)++;
        return lastChar;
    }

    int b() {
        return lastChar;
    }

    @java.lang.Override
    public int read(final char[] buf, final int offset, final int length) throws java.io.IOException {
        if (length == 0) {
            return 0;
        } 
        final int len = super.read(buf, offset, length);
        if (len > 0) {
            for (int i = offset ; i < (offset + len) ; i++) {
                final char ch = buf[i];
                if (ch == (org.apache.commons.csv.Constants.LF)) {
                    if ((org.apache.commons.csv.Constants.CR) != (i > 0 ? buf[(i - 1)] : lastChar)) {
                        (eolCounter)++;
                    } 
                } else if (ch == (org.apache.commons.csv.Constants.CR)) {
                    (eolCounter)++;
                } 
            }
            lastChar = buf[((offset + len) - 1)];
        } else if (len == (-1)) {
            lastChar = org.apache.commons.csv.Constants.END_OF_STREAM;
        } 
        position += len;
        return len;
    }

    @java.lang.Override
    public java.lang.String readLine() throws java.io.IOException {
        final java.lang.String line = super.readLine();
        if (line != null) {
            lastChar = org.apache.commons.csv.Constants.LF;
            (eolCounter)++;
        } else {
            lastChar = org.apache.commons.csv.Constants.END_OF_STREAM;
        }
        return line;
    }

    int c() throws java.io.IOException {
        super.mark(1);
        final int c = super.read();
        super.reset();
        return c;
    }

    long d() {
        if (((((lastChar) == (org.apache.commons.csv.Constants.CR)) || ((lastChar) == (org.apache.commons.csv.Constants.LF))) || ((lastChar) == (org.apache.commons.csv.Constants.UNDEFINED))) || ((lastChar) == (org.apache.commons.csv.Constants.END_OF_STREAM))) {
            return eolCounter;
        } 
        return (eolCounter) + 1;
    }

    long e() {
        return this.position;
    }

    public boolean a() {
        return closed;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        closed = true;
        lastChar = org.apache.commons.csv.Constants.END_OF_STREAM;
        super.close();
    }
}

