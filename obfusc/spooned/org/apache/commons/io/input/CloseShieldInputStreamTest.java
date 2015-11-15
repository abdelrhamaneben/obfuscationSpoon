package org.apache.commons.io.input;


public class CloseShieldInputStreamTest extends junit.framework.TestCase {
    private byte[] data;

    private java.io.InputStream original;

    private java.io.InputStream shielded;

    private boolean closed;

    @java.lang.Override
    protected void setUp() {
        data = new byte[]{ 'x' , 'y' , 'z' };
        original = new java.io.ByteArrayInputStream(data) {
            @java.lang.Override
            public void close() {
                closed = true;
            }
        };
        shielded = new org.apache.commons.io.input.CloseShieldInputStream(original);
        closed = false;
    }

    public void a() throws java.io.IOException {
        shielded.close();
        junit.framework.TestCase.assertFalse("closed", closed);
        junit.framework.TestCase.assertEquals("read()", -1, shielded.read());
        junit.framework.TestCase.assertEquals("read()", data[0], original.read());
    }
}

