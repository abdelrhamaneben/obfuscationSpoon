package org.apache.commons.io.testtools;


public class YellOnFlushAndCloseOutputStream extends org.apache.commons.io.output.ProxyOutputStream {
    private boolean yellForFlush;

    private boolean yellForClose;

    public YellOnFlushAndCloseOutputStream(final java.io.OutputStream proxy ,final boolean yellForFlush ,final boolean yellForClose) {
        super(proxy);
        this.yellForFlush = yellForFlush;
        this.yellForClose = yellForClose;
    }

    @java.lang.Override
    public void flush() throws java.io.IOException {
        if (yellForFlush) {
            throw new junit.framework.AssertionFailedError("flush() was called on OutputStream");
        } 
        super.flush();
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if (yellForClose) {
            throw new junit.framework.AssertionFailedError("close() was called on OutputStream");
        } 
        super.close();
    }

    public void a() {
        yellForFlush = false;
        yellForClose = false;
    }
}

