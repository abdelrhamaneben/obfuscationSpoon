package org.apache.commons.io.input;


public class CharSequenceReaderTest {
    private static final char NONE = new char[1][0];

    @org.junit.Test
    public void a() throws java.io.IOException {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        checkRead(reader, "Foo");
        reader.close();
        checkRead(reader, "Foo");
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        org.junit.Assert.assertTrue(reader.markSupported());
        reader.close();
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        checkRead(reader, "Foo");
        reader.mark(0);
        checkRead(reader, "Bar");
        reader.reset();
        checkRead(reader, "Bar");
        reader.close();
        checkRead(reader, "Foo");
        reader.reset();
        checkRead(reader, "Foo");
    }

    @org.junit.Test
    public void g() throws java.io.IOException {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        org.junit.Assert.assertEquals(3, reader.skip(3));
        checkRead(reader, "Bar");
        org.junit.Assert.assertEquals(-1, reader.skip(3));
        reader.reset();
        org.junit.Assert.assertEquals(2, reader.skip(2));
        org.junit.Assert.assertEquals(4, reader.skip(10));
        org.junit.Assert.assertEquals(-1, reader.skip(1));
        reader.close();
        org.junit.Assert.assertEquals(6, reader.skip(20));
        org.junit.Assert.assertEquals(-1, reader.read());
    }

    @org.junit.Test
    public void d() throws java.io.IOException {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("Foo");
        org.junit.Assert.assertEquals('F', reader.read());
        org.junit.Assert.assertEquals('o', reader.read());
        org.junit.Assert.assertEquals('o', reader.read());
        org.junit.Assert.assertEquals(-1, reader.read());
        org.junit.Assert.assertEquals(-1, reader.read());
        reader.close();
    }

    @org.junit.Test
    public void e() throws java.io.IOException {
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        char[] chars = new char[2];
        org.junit.Assert.assertEquals(2, reader.read(chars));
        checkArray(new char[]{ 'F' , 'o' }, chars);
        chars = new char[3];
        org.junit.Assert.assertEquals(3, reader.read(chars));
        checkArray(new char[]{ 'o' , 'B' , 'a' }, chars);
        chars = new char[3];
        org.junit.Assert.assertEquals(1, reader.read(chars));
        checkArray(new char[]{ 'r' , NONE , NONE }, chars);
        org.junit.Assert.assertEquals(-1, reader.read(chars));
        reader.close();
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        final char[] chars = new char[10];
        final java.io.Reader reader = new org.apache.commons.io.input.CharSequenceReader("FooBar");
        org.junit.Assert.assertEquals(3, reader.read(chars, 3, 3));
        checkArray(new char[]{ NONE , NONE , NONE , 'F' , 'o' , 'o' }, chars);
        org.junit.Assert.assertEquals(3, reader.read(chars, 0, 3));
        checkArray(new char[]{ 'B' , 'a' , 'r' , 'F' , 'o' , 'o' , NONE }, chars);
        org.junit.Assert.assertEquals(-1, reader.read(chars));
        reader.close();
    }

    private void a(final java.io.Reader reader, final java.lang.String expected) throws java.io.IOException {
        for (int i = 0 ; i < (expected.length()) ; i++) {
            org.junit.Assert.assertEquals((((("Read[" + i) + "] of \'") + expected) + "\'"), expected.charAt(i), ((char)(reader.read())));
        }
    }

    private void a(final char[] expected, final char[] actual) {
        for (int i = 0 ; i < (expected.length) ; i++) {
            org.junit.Assert.assertEquals((("Compare[" + i) + "]"), expected[i], actual[i]);
        }
    }
}

