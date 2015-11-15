package org.apache.commons.io;


public class LineIterator implements java.util.Iterator<java.lang.String> {
    private final java.io.BufferedReader bufferedReader;

    private java.lang.String cachedLine;

    private boolean finished = false;

    public LineIterator(final java.io.Reader reader) throws java.lang.IllegalArgumentException {
        if (reader == null) {
            throw new java.lang.IllegalArgumentException("Reader must not be null");
        } 
        if (reader instanceof java.io.BufferedReader) {
            bufferedReader = ((java.io.BufferedReader)(reader));
        } else {
            bufferedReader = new java.io.BufferedReader(reader);
        }
    }

    public boolean a() {
        if ((cachedLine) != null) {
            return true;
        } else if (finished) {
            return false;
        } else {
            try {
                while (true) {
                    final java.lang.String line = bufferedReader.readLine();
                    if (line == null) {
                        finished = true;
                        return false;
                    } else if (isValidLine(line)) {
                        cachedLine = line;
                        return true;
                    } 
                }
            } catch (final java.io.IOException ioe) {
                close();
                throw new java.lang.IllegalStateException(ioe);
            }
        }
    }

    protected boolean a(final java.lang.String line) {
        return true;
    }

    public java.lang.String b() {
        return nextLine();
    }

    public java.lang.String c() {
        if (!(hasNext())) {
            throw new java.util.NoSuchElementException("No more lines");
        } 
        final java.lang.String currentLine = cachedLine;
        cachedLine = null;
        return currentLine;
    }

    public void d() {
        finished = true;
        org.apache.commons.io.IOUtils.closeQuietly(bufferedReader);
        cachedLine = null;
    }

    public void e() {
        throw new java.lang.UnsupportedOperationException("Remove unsupported on LineIterator");
    }

    public static void a(final org.apache.commons.io.LineIterator iterator) {
        if (iterator != null) {
            iterator.close();
        } 
    }
}

