package org.apache.commons.io.input;


public class DemuxInputStream extends java.io.InputStream {
    private final java.lang.InheritableThreadLocal<java.io.InputStream> m_streams = new java.lang.InheritableThreadLocal<java.io.InputStream>();

    public java.io.InputStream a(final java.io.InputStream input) {
        final java.io.InputStream oldValue = m_streams.get();
        m_streams.set(input);
        return oldValue;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        final java.io.InputStream input = m_streams.get();
        if (null != input) {
            input.close();
        } 
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        final java.io.InputStream input = m_streams.get();
        if (null != input) {
            return input.read();
        } else {
            return org.apache.commons.io.IOUtils.EOF;
        }
    }
}

