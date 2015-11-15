package org.apache.commons.io.testtools;


public class YellOnCloseInputStream extends org.apache.commons.io.input.ProxyInputStream {
    public YellOnCloseInputStream(final java.io.InputStream proxy) {
        super(proxy);
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        throw new junit.framework.AssertionFailedError("close() was called on OutputStream");
    }
}

