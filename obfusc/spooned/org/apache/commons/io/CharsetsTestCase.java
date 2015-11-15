package org.apache.commons.io;


public class CharsetsTestCase {
    @org.junit.Test
    public void b() {
        final java.util.SortedMap<java.lang.String, java.nio.charset.Charset> requiredCharsets = org.apache.commons.io.Charsets.requiredCharsets();
        org.junit.Assert.assertEquals(requiredCharsets.get("US-ASCII").name(), "US-ASCII");
        org.junit.Assert.assertEquals(requiredCharsets.get("ISO-8859-1").name(), "ISO-8859-1");
        org.junit.Assert.assertEquals(requiredCharsets.get("UTF-8").name(), "UTF-8");
        org.junit.Assert.assertEquals(requiredCharsets.get("UTF-16").name(), "UTF-16");
        org.junit.Assert.assertEquals(requiredCharsets.get("UTF-16BE").name(), "UTF-16BE");
        org.junit.Assert.assertEquals(requiredCharsets.get("UTF-16LE").name(), "UTF-16LE");
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void a() {
        org.junit.Assert.assertEquals("ISO-8859-1", org.apache.commons.io.Charsets.ISO_8859_1.name());
    }

    @org.junit.Test
    public void c() {
        org.junit.Assert.assertEquals(java.nio.charset.Charset.defaultCharset(), org.apache.commons.io.Charsets.toCharset(((java.lang.String)(null))));
        org.junit.Assert.assertEquals(java.nio.charset.Charset.defaultCharset(), org.apache.commons.io.Charsets.toCharset(((java.nio.charset.Charset)(null))));
        org.junit.Assert.assertEquals(java.nio.charset.Charset.defaultCharset(), org.apache.commons.io.Charsets.toCharset(java.nio.charset.Charset.defaultCharset()));
        org.junit.Assert.assertEquals(java.nio.charset.Charset.forName("UTF-8"), org.apache.commons.io.Charsets.toCharset(java.nio.charset.Charset.forName("UTF-8")));
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void d() {
        org.junit.Assert.assertEquals("US-ASCII", org.apache.commons.io.Charsets.US_ASCII.name());
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void e() {
        org.junit.Assert.assertEquals("UTF-16", org.apache.commons.io.Charsets.UTF_16.name());
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void f() {
        org.junit.Assert.assertEquals("UTF-16BE", org.apache.commons.io.Charsets.UTF_16BE.name());
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void g() {
        org.junit.Assert.assertEquals("UTF-16LE", org.apache.commons.io.Charsets.UTF_16LE.name());
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void h() {
        org.junit.Assert.assertEquals("UTF-8", org.apache.commons.io.Charsets.UTF_8.name());
    }
}

