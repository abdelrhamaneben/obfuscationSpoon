package org.apache.commons.io.input;


public class AutoCloseInputStream extends org.apache.commons.io.input.ProxyInputStream {
    public AutoCloseInputStream(final java.io.InputStream in) {
        super(in);
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        in.close();
        in = new org.apache.commons.io.input.ClosedInputStream();
    }

    @java.lang.Override
    protected void skip(final int n) throws java.io.IOException {
        if (n == (org.apache.commons.io.IOUtils.EOF)) {
            close();
        } 
    }

    @java.lang.Override
    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }
}

