package org.apache.commons.io.input;


public class ClosedInputStreamTest extends junit.framework.TestCase {
    public void a() throws java.lang.Exception {
        final org.apache.commons.io.input.ClosedInputStream cis = new org.apache.commons.io.input.ClosedInputStream();
        junit.framework.TestCase.assertEquals("read()", -1, cis.read());
        cis.close();
    }
}

