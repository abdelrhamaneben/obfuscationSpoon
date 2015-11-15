package org.apache.commons.io.input;


public class UnixLineEndingInputStreamTest {
    @org.junit.Test
    public void g() throws java.lang.Exception {
        org.junit.Assert.assertEquals("abc\n", roundtrip("abc"));
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\nbc\n", roundtrip("a\r\nbc"));
    }

    @org.junit.Test
    public void e() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\n\nbc\n", roundtrip("a\r\n\r\nbc"));
    }

    @org.junit.Test
    public void h() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\n\n", roundtrip("a\r\n\r\n"));
    }

    @org.junit.Test
    public void b() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\nb\n", roundtrip("a\rb"));
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\nb", roundtrip("a\rb", false));
    }

    @org.junit.Test
    public void a() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\n", roundtrip("a\r"));
    }

    @org.junit.Test
    public void f() throws java.lang.Exception {
        org.junit.Assert.assertEquals("a\n\n", roundtrip("a\r\n\r\n", false));
        org.junit.Assert.assertEquals("a", roundtrip("a", false));
    }

    private java.lang.String a(java.lang.String msg) throws java.io.IOException {
        return roundtrip(msg, true);
    }

    private java.lang.String a(java.lang.String msg, boolean ensure) throws java.io.IOException {
        java.io.ByteArrayInputStream baos = new java.io.ByteArrayInputStream(msg.getBytes("UTF-8"));
        org.apache.commons.io.input.UnixLineEndingInputStream lf = new org.apache.commons.io.input.UnixLineEndingInputStream(baos , ensure);
        byte[] buf = new byte[100];
        final int read = lf.read(buf);
        lf.close();
        return new java.lang.String(buf , 0 , read , "UTF-8");
    }
}

