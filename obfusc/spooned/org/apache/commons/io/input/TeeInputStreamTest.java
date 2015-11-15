package org.apache.commons.io.input;


public class TeeInputStreamTest extends junit.framework.TestCase {
    private final java.lang.String ASCII = "US-ASCII";

    private java.io.InputStream tee;

    private java.io.ByteArrayOutputStream output;

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        final java.io.InputStream input = new java.io.ByteArrayInputStream("abc".getBytes(ASCII));
        output = new java.io.ByteArrayOutputStream();
        tee = new org.apache.commons.io.input.TeeInputStream(input , output);
    }

    public void c() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals("", new java.lang.String(output.toString(ASCII)));
    }

    public void d() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals('a', tee.read());
        junit.framework.TestCase.assertEquals("a", new java.lang.String(output.toString(ASCII)));
    }

    public void b() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals('a', tee.read());
        junit.framework.TestCase.assertEquals('b', tee.read());
        junit.framework.TestCase.assertEquals('c', tee.read());
        junit.framework.TestCase.assertEquals(-1, tee.read());
        junit.framework.TestCase.assertEquals("abc", new java.lang.String(output.toString(ASCII)));
    }

    public void e() throws java.lang.Exception {
        final byte[] buffer = new byte[8];
        junit.framework.TestCase.assertEquals(3, tee.read(buffer));
        junit.framework.TestCase.assertEquals('a', buffer[0]);
        junit.framework.TestCase.assertEquals('b', buffer[1]);
        junit.framework.TestCase.assertEquals('c', buffer[2]);
        junit.framework.TestCase.assertEquals(-1, tee.read(buffer));
        junit.framework.TestCase.assertEquals("abc", new java.lang.String(output.toString(ASCII)));
    }

    public void f() throws java.lang.Exception {
        final byte[] buffer = new byte[8];
        junit.framework.TestCase.assertEquals(3, tee.read(buffer, 4, 4));
        junit.framework.TestCase.assertEquals('a', buffer[4]);
        junit.framework.TestCase.assertEquals('b', buffer[5]);
        junit.framework.TestCase.assertEquals('c', buffer[6]);
        junit.framework.TestCase.assertEquals(-1, tee.read(buffer, 4, 4));
        junit.framework.TestCase.assertEquals("abc", new java.lang.String(output.toString(ASCII)));
    }

    public void g() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals('a', tee.read());
        junit.framework.TestCase.assertEquals(1, tee.skip(1));
        junit.framework.TestCase.assertEquals('c', tee.read());
        junit.framework.TestCase.assertEquals(-1, tee.read());
        junit.framework.TestCase.assertEquals("ac", new java.lang.String(output.toString(ASCII)));
    }

    public void a() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals('a', tee.read());
        tee.mark(1);
        junit.framework.TestCase.assertEquals('b', tee.read());
        tee.reset();
        junit.framework.TestCase.assertEquals('b', tee.read());
        junit.framework.TestCase.assertEquals('c', tee.read());
        junit.framework.TestCase.assertEquals(-1, tee.read());
        junit.framework.TestCase.assertEquals("abbc", new java.lang.String(output.toString(ASCII)));
    }
}

