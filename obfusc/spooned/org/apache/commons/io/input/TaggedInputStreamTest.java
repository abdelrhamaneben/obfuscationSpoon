package org.apache.commons.io.input;


public class TaggedInputStreamTest extends junit.framework.TestCase {
    public void b() {
        try {
            final java.io.InputStream stream = new org.apache.commons.io.input.TaggedInputStream(new org.apache.commons.io.input.ClosedInputStream());
            junit.framework.TestCase.assertEquals(0, stream.available());
            junit.framework.TestCase.assertEquals(-1, stream.read());
            junit.framework.TestCase.assertEquals(-1, stream.read(new byte[1]));
            junit.framework.TestCase.assertEquals(-1, stream.read(new byte[1], 0, 1));
            stream.close();
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.fail("Unexpected exception thrown");
        }
    }

    public void c() {
        try {
            final java.io.InputStream stream = new org.apache.commons.io.input.TaggedInputStream(new java.io.ByteArrayInputStream(new byte[]{ 'a' , 'b' , 'c' }));
            junit.framework.TestCase.assertEquals(3, stream.available());
            junit.framework.TestCase.assertEquals('a', stream.read());
            final byte[] buffer = new byte[1];
            junit.framework.TestCase.assertEquals(1, stream.read(buffer));
            junit.framework.TestCase.assertEquals('b', buffer[0]);
            junit.framework.TestCase.assertEquals(1, stream.read(buffer, 0, 1));
            junit.framework.TestCase.assertEquals('c', buffer[0]);
            junit.framework.TestCase.assertEquals(-1, stream.read());
            stream.close();
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.fail("Unexpected exception thrown");
        }
    }

    public void a() {
        final java.io.IOException exception = new java.io.IOException("test exception");
        final org.apache.commons.io.input.TaggedInputStream stream = new org.apache.commons.io.input.TaggedInputStream(new org.apache.commons.io.input.BrokenInputStream(exception));
        try {
            stream.available();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertTrue(stream.isCauseOf(e));
            try {
                stream.throwIfCauseOf(e);
                junit.framework.TestCase.fail("Expected exception not thrown.");
            } catch (final java.io.IOException e2) {
                junit.framework.TestCase.assertEquals(exception, e2);
            }
        }
        try {
            stream.read();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertTrue(stream.isCauseOf(e));
            try {
                stream.throwIfCauseOf(e);
                junit.framework.TestCase.fail("Expected exception not thrown.");
            } catch (final java.io.IOException e2) {
                junit.framework.TestCase.assertEquals(exception, e2);
            }
        }
        try {
            stream.close();
            junit.framework.TestCase.fail("Expected exception not thrown.");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertTrue(stream.isCauseOf(e));
            try {
                stream.throwIfCauseOf(e);
                junit.framework.TestCase.fail("Expected exception not thrown.");
            } catch (final java.io.IOException e2) {
                junit.framework.TestCase.assertEquals(exception, e2);
            }
        }
    }

    public void d() throws java.lang.Exception {
        final java.io.IOException exception = new java.io.IOException("test exception");
        final java.io.InputStream closed = new org.apache.commons.io.input.ClosedInputStream();
        final org.apache.commons.io.input.TaggedInputStream stream = new org.apache.commons.io.input.TaggedInputStream(closed);
        junit.framework.TestCase.assertFalse(stream.isCauseOf(exception));
        junit.framework.TestCase.assertFalse(stream.isCauseOf(new org.apache.commons.io.TaggedIOException(exception , java.util.UUID.randomUUID())));
        try {
            stream.throwIfCauseOf(exception);
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.fail("Unexpected exception thrown");
        }
        try {
            stream.throwIfCauseOf(new org.apache.commons.io.TaggedIOException(exception , java.util.UUID.randomUUID()));
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.fail("Unexpected exception thrown");
        }
        stream.close();
    }
}

