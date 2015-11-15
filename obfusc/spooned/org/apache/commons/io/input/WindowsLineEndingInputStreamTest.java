package org.apache.commons.io.input;


public class WindowsLineEndingInputStreamTest {
    @org.junit.Test
    public void f() throws java.lang.Exception {
        org.junit.Assert.assertEquals("abc\r\n", roundtrip("abc"));
    }

    @org.junit.Test
    public void a() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\r\nbc\r\n", roundtrip("a\r\nbc"));
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\r\n\r\nbc\r\n", roundtrip("a\r\n\r\nbc"));
    }

    @org.junit.Test
    public void g() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\r\n\r\n", roundtrip("a\r\n\r\n"));
    }

    @org.junit.Test
    public void b() throws java.lang.Exception {
        final java.lang.String roundtrip = roundtrip("ab\nc", false);
        org.junit.Assert.assertEquals("ab\r\nc", roundtrip);
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\rbc", roundtrip("a\rbc", false));
    }

    @org.junit.Test
    public void e() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\r\n\r\n", roundtrip("a\r\n\r\n", false));
        org.junit.Assert.assertEquals("a", roundtrip("a", false));
    }

    private java.lang.String a(java.lang.String msg) throws java.io.IOException {
        return roundtrip(msg, true);
    }

    private java.lang.String a(java.lang.String msg, boolean ensure) throws java.io.IOException {
        java.io.ByteArrayInputStream baos = new java.io.ByteArrayInputStream(msg.getBytes("UTF-8"));
        org.apache.commons.io.input.WindowsLineEndingInputStream lf = new org.apache.commons.io.input.WindowsLineEndingInputStream(baos , ensure);
        byte[] buf = new byte[100];
        final int read = lf.read(buf);
        lf.close();
        return new java.lang.String(buf , 0 , read , "UTF-8");
    }
}

