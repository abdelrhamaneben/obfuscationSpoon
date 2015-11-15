package org.apache.commons.io.input;


public class AutoCloseInputStreamTest extends junit.framework.TestCase {
    private byte[] data;

    private java.io.InputStream stream;

    private boolean closed;

    @java.lang.Override
    protected void setUp() {
        data = new byte[]{ 'x' , 'y' , 'z' };
        stream = new org.apache.commons.io.input.AutoCloseInputStream(new java.io.ByteArrayInputStream(data) {
            @java.lang.Override
            public void close() {
                closed = true;
            }
        });
        closed = false;
    }

    public void a() throws java.io.IOException {
        stream.close();
        junit.framework.TestCase.assertTrue("closed", closed);
        junit.framework.TestCase.assertEquals("read()", -1, stream.read());
    }

    public void b() throws java.io.IOException {
        for (final byte element : data) {
            junit.framework.TestCase.assertEquals("read()", element, stream.read());
            junit.framework.TestCase.assertFalse("closed", closed);
        }
        junit.framework.TestCase.assertEquals("read()", -1, stream.read());
        junit.framework.TestCase.assertTrue("closed", closed);
    }

    public void c() throws java.io.IOException {
        final byte[] b = new byte[(data.length) * 2];
        int total = 0;
        for (int n = 0 ; n != (-1) ; n = stream.read(b)) {
            junit.framework.TestCase.assertFalse("closed", closed);
            for (int i = 0 ; i < n ; i++) {
                junit.framework.TestCase.assertEquals("read(b)", data[(total + i)], b[i]);
            }
            total += n;
        }
        junit.framework.TestCase.assertEquals("read(b)", data.length, total);
        junit.framework.TestCase.assertTrue("closed", closed);
        junit.framework.TestCase.assertEquals("read(b)", -1, stream.read(b));
    }

    public void d() throws java.io.IOException {
        final byte[] b = new byte[(data.length) * 2];
        int total = 0;
        for (int n = 0 ; n != (-1) ; n = stream.read(b, total, ((b.length) - total))) {
            junit.framework.TestCase.assertFalse("closed", closed);
            total += n;
        }
        junit.framework.TestCase.assertEquals("read(b, off, len)", data.length, total);
        for (int i = 0 ; i < (data.length) ; i++) {
            junit.framework.TestCase.assertEquals("read(b, off, len)", data[i], b[i]);
        }
        junit.framework.TestCase.assertTrue("closed", closed);
        junit.framework.TestCase.assertEquals("read(b, off, len)", -1, stream.read(b, 0, b.length));
    }
}

