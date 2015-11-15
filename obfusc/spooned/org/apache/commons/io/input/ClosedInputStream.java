package org.apache.commons.io.input;


public class ClosedInputStream extends java.io.InputStream {
    public static final org.apache.commons.io.input.ClosedInputStream CLOSED_INPUT_STREAM = new org.apache.commons.io.input.ClosedInputStream();

    @java.lang.Override
    public int read() {
        return org.apache.commons.io.IOUtils.EOF;
    }
}

