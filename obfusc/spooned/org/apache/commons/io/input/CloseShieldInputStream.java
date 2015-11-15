package org.apache.commons.io.input;


public class CloseShieldInputStream extends org.apache.commons.io.input.ProxyInputStream {
    public CloseShieldInputStream(final java.io.InputStream in) {
        super(in);
    }

    @java.lang.Override
    public void close() {
        in = new org.apache.commons.io.input.ClosedInputStream();
    }
}

