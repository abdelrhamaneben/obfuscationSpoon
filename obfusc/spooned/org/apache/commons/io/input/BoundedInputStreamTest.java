package org.apache.commons.io.input;


public class BoundedInputStreamTest extends junit.framework.TestCase {
    public BoundedInputStreamTest(final java.lang.String name) {
        super(name);
    }

    public void b() throws java.lang.Exception {
        org.apache.commons.io.input.BoundedInputStream bounded = null;
        final byte[] helloWorld = "Hello World".getBytes();
        final byte[] hello = "Hello".getBytes();
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , helloWorld.length);
        for (int i = 0 ; i < (helloWorld.length) ; i++) {
            junit.framework.TestCase.assertEquals((("limit = length byte[" + i) + "]"), helloWorld[i], bounded.read());
        }
        junit.framework.TestCase.assertEquals("limit = length end", -1, bounded.read());
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , ((helloWorld.length) + 1));
        for (int i = 0 ; i < (helloWorld.length) ; i++) {
            junit.framework.TestCase.assertEquals((("limit > length byte[" + i) + "]"), helloWorld[i], bounded.read());
        }
        junit.framework.TestCase.assertEquals("limit > length end", -1, bounded.read());
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , hello.length);
        for (int i = 0 ; i < (hello.length) ; i++) {
            junit.framework.TestCase.assertEquals((("limit < length byte[" + i) + "]"), hello[i], bounded.read());
        }
        junit.framework.TestCase.assertEquals("limit < length end", -1, bounded.read());
    }

    public void a() throws java.lang.Exception {
        org.apache.commons.io.input.BoundedInputStream bounded = null;
        final byte[] helloWorld = "Hello World".getBytes();
        final byte[] hello = "Hello".getBytes();
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld));
        compare("limit = -1", helloWorld, org.apache.commons.io.IOUtils.toByteArray(bounded));
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , 0);
        compare("limit = 0", new byte[0], org.apache.commons.io.IOUtils.toByteArray(bounded));
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , helloWorld.length);
        compare("limit = length", helloWorld, org.apache.commons.io.IOUtils.toByteArray(bounded));
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , ((helloWorld.length) + 1));
        compare("limit > length", helloWorld, org.apache.commons.io.IOUtils.toByteArray(bounded));
        bounded = new org.apache.commons.io.input.BoundedInputStream(new java.io.ByteArrayInputStream(helloWorld) , ((helloWorld.length) - 6));
        compare("limit < length", hello, org.apache.commons.io.IOUtils.toByteArray(bounded));
    }

    private void a(final java.lang.String msg, final byte[] expected, final byte[] actual) {
        junit.framework.TestCase.assertEquals((msg + " length"), expected.length, actual.length);
        for (int i = 0 ; i < (expected.length) ; i++) {
            junit.framework.TestCase.assertEquals((((msg + " byte[") + i) + "]"), expected[i], actual[i]);
        }
    }
}

