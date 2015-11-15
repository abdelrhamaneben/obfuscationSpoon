package org.apache.commons.io.input;


public class BrokenInputStreamTest extends junit.framework.TestCase {
    private java.io.IOException exception;

    private java.io.InputStream stream;

    @java.lang.Override
    protected void setUp() {
        exception = new java.io.IOException("test exception");
        stream = new org.apache.commons.io.input.BrokenInputStream(exception);
    }

    public void c() {
        try {
            stream.read();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
        try {
            stream.read(new byte[1]);
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
        try {
            stream.read(new byte[1], 0, 1);
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
    }

    public void a() {
        try {
            stream.available();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
    }

    public void e() {
        try {
            stream.skip(1);
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
    }

    public void d() {
        try {
            stream.reset();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
    }

    public void b() {
        try {
            stream.close();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(exception, e);
        }
    }
}

