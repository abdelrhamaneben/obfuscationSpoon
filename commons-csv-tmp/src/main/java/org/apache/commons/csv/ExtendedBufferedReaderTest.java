package org.apache.commons.csv;


public class ExtendedBufferedReaderTest {
    @org.junit.Test
    public void testEmptyInput() throws java.lang.Exception {
        final org.apache.commons.csv.ExtendedBufferedReader br = a("");
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.read());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.c());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.b());
        org.junit.Assert.assertNull(br.readLine());
        org.junit.Assert.assertEquals(0, br.read(new char[10], 0, 0));
        br.close();
    }

    @org.junit.Test
    public void testReadLookahead1() throws java.lang.Exception {
        final org.apache.commons.csv.ExtendedBufferedReader br = a("1\n2\r3\n");
        org.junit.Assert.assertEquals(0, br.d());
        org.junit.Assert.assertEquals('1', br.c());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.UNDEFINED, br.b());
        org.junit.Assert.assertEquals(0, br.d());
        org.junit.Assert.assertEquals('1', br.read());
        org.junit.Assert.assertEquals('1', br.b());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('\n', br.c());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('1', br.b());
        org.junit.Assert.assertEquals('\n', br.read());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('\n', br.b());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('2', br.c());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('\n', br.b());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('2', br.read());
        org.junit.Assert.assertEquals(2, br.d());
        org.junit.Assert.assertEquals('2', br.b());
        org.junit.Assert.assertEquals('\r', br.c());
        org.junit.Assert.assertEquals(2, br.d());
        org.junit.Assert.assertEquals('2', br.b());
        org.junit.Assert.assertEquals('\r', br.read());
        org.junit.Assert.assertEquals('\r', br.b());
        org.junit.Assert.assertEquals(2, br.d());
        org.junit.Assert.assertEquals('3', br.c());
        org.junit.Assert.assertEquals('\r', br.b());
        org.junit.Assert.assertEquals('3', br.read());
        org.junit.Assert.assertEquals('3', br.b());
        org.junit.Assert.assertEquals(3, br.d());
        org.junit.Assert.assertEquals('\n', br.c());
        org.junit.Assert.assertEquals(3, br.d());
        org.junit.Assert.assertEquals('3', br.b());
        org.junit.Assert.assertEquals('\n', br.read());
        org.junit.Assert.assertEquals(3, br.d());
        org.junit.Assert.assertEquals('\n', br.b());
        org.junit.Assert.assertEquals(3, br.d());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.c());
        org.junit.Assert.assertEquals('\n', br.b());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.read());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.b());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.read());
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.END_OF_STREAM, br.c());
        org.junit.Assert.assertEquals(3, br.d());
        br.close();
    }

    @org.junit.Test
    public void testReadLookahead2() throws java.lang.Exception {
        final char[] ref = new char[5];
        final char[] res = new char[5];
        final org.apache.commons.csv.ExtendedBufferedReader br = a("abcdefg");
        ref[0] = 'a';
        ref[1] = 'b';
        ref[2] = 'c';
        org.junit.Assert.assertEquals(3, br.read(res, 0, 3));
        org.junit.Assert.assertArrayEquals(ref, res);
        org.junit.Assert.assertEquals('c', br.b());
        org.junit.Assert.assertEquals('d', br.c());
        ref[4] = 'd';
        org.junit.Assert.assertEquals(1, br.read(res, 4, 1));
        org.junit.Assert.assertArrayEquals(ref, res);
        org.junit.Assert.assertEquals('d', br.b());
        br.close();
    }

    @org.junit.Test
    public void testReadLine() throws java.lang.Exception {
        org.apache.commons.csv.ExtendedBufferedReader br = a("");
        org.junit.Assert.assertNull(br.readLine());
        br.close();
        br = a("\n");
        org.junit.Assert.assertEquals("", br.readLine());
        org.junit.Assert.assertNull(br.readLine());
        br.close();
        br = a("foo\n\nhello");
        org.junit.Assert.assertEquals(0, br.d());
        org.junit.Assert.assertEquals("foo", br.readLine());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals("", br.readLine());
        org.junit.Assert.assertEquals(2, br.d());
        org.junit.Assert.assertEquals("hello", br.readLine());
        org.junit.Assert.assertEquals(3, br.d());
        org.junit.Assert.assertNull(br.readLine());
        org.junit.Assert.assertEquals(3, br.d());
        br.close();
        br = a("foo\n\nhello");
        org.junit.Assert.assertEquals('f', br.read());
        org.junit.Assert.assertEquals('o', br.c());
        org.junit.Assert.assertEquals("oo", br.readLine());
        org.junit.Assert.assertEquals(1, br.d());
        org.junit.Assert.assertEquals('\n', br.c());
        org.junit.Assert.assertEquals("", br.readLine());
        org.junit.Assert.assertEquals(2, br.d());
        org.junit.Assert.assertEquals('h', br.c());
        org.junit.Assert.assertEquals("hello", br.readLine());
        org.junit.Assert.assertNull(br.readLine());
        org.junit.Assert.assertEquals(3, br.d());
        br.close();
        br = a("foo\rbaar\r\nfoo");
        org.junit.Assert.assertEquals("foo", br.readLine());
        org.junit.Assert.assertEquals('b', br.c());
        org.junit.Assert.assertEquals("baar", br.readLine());
        org.junit.Assert.assertEquals('f', br.c());
        org.junit.Assert.assertEquals("foo", br.readLine());
        org.junit.Assert.assertNull(br.readLine());
        br.close();
    }

    @org.junit.Test
    public void testReadChar() throws java.lang.Exception {
        final java.lang.String LF = "\n";
        final java.lang.String CR = "\r";
        final java.lang.String CRLF = CR + LF;
        final java.lang.String LFCR = LF + CR;
        final java.lang.String test = (((((((((((("a" + LF) + "b") + CR) + "c") + LF) + LF) + "d") + CR) + CR) + "e") + LFCR) + "f ") + CRLF;
        final int EOLeolct = 9;
        org.apache.commons.csv.ExtendedBufferedReader br;
        br = a(test);
        org.junit.Assert.assertEquals(0, br.d());
        while ((br.readLine()) != null) {
        }
        org.junit.Assert.assertEquals(EOLeolct, br.d());
        br.close();
        br = a(test);
        org.junit.Assert.assertEquals(0, br.d());
        while ((br.read()) != (-1)) {
        }
        org.junit.Assert.assertEquals(EOLeolct, br.d());
        br.close();
        br = a(test);
        org.junit.Assert.assertEquals(0, br.d());
        final char[] buff = new char[10];
        while ((br.read(buff, 0, 3)) != (-1)) {
        }
        org.junit.Assert.assertEquals(EOLeolct, br.d());
        br.close();
    }

    private org.apache.commons.csv.ExtendedBufferedReader a(final java.lang.String s) {
        return new org.apache.commons.csv.ExtendedBufferedReader(new java.io.StringReader(s));
    }
}

