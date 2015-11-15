package org.apache.commons.io.input;


public class CharSequenceInputStreamTest {
    private static final java.lang.String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final java.lang.String LARGE_TEST_STRING;

    private static final java.lang.String TEST_STRING = "à peine arrivés nous entrâmes dans sa chambre";

    static {
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        for (int i = 0 ; i < 100 ; i++) {
            buffer.append(TEST_STRING);
        }
        LARGE_TEST_STRING = buffer.toString();
    }

    private final java.util.Random random = new java.util.Random();

    private java.util.Set<java.lang.String> a() {
        return org.apache.commons.io.Charsets.requiredCharsets().keySet();
    }

    private void a(final java.lang.String testString, final java.lang.String charsetName) throws java.io.IOException {
        final byte[] expected = testString.getBytes(charsetName);
        final java.io.InputStream in = new org.apache.commons.io.input.CharSequenceInputStream(testString , charsetName , 512);
        try {
            final byte[] buffer = new byte[128];
            int offset = 0;
            while (true) {
                int bufferOffset = random.nextInt(64);
                final int bufferLength = random.nextInt(64);
                int read = in.read(buffer, bufferOffset, bufferLength);
                if (read == (-1)) {
                    org.junit.Assert.assertEquals("EOF: offset should equal length", expected.length, offset);
                    break;
                } else {
                    org.junit.Assert.assertTrue(((("Read " + read) + " <= ") + bufferLength), (read <= bufferLength));
                    while (read > 0) {
                        org.junit.Assert.assertTrue(((("offset " + offset) + " < ") + (expected.length)), (offset < (expected.length)));
                        org.junit.Assert.assertEquals("bytes should agree", expected[offset], buffer[bufferOffset]);
                        offset++;
                        bufferOffset++;
                        read--;
                    }
                }
            }
        } finally {
            in.close();
        }
    }

    @org.junit.Test
    public void c() throws java.io.IOException {
        for (final java.lang.String csName : java.nio.charset.Charset.availableCharsets().keySet()) {
            if (isAvailabilityTestableForCharset(csName)) {
                testBufferedRead(TEST_STRING, csName);
            } 
        }
    }

    @org.junit.Test
    public void d() throws java.io.IOException {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testBufferedRead(TEST_STRING, csName);
        }
    }

    @org.junit.Test
    public void e() throws java.io.IOException {
        testBufferedRead(TEST_STRING, "UTF-8");
    }

    private void d(final java.lang.String csName) throws java.io.IOException {
        final char[] inputChars = new char[]{ ((char)(224)) , ((char)(178)) , ((char)(160)) };
        final java.nio.charset.Charset charset = java.nio.charset.Charset.forName(csName);
        final java.io.InputStream stream = new org.apache.commons.io.input.CharSequenceInputStream(new java.lang.String(inputChars) , charset , 512);
        try {
            while ((stream.read()) != (-1)) {
            }
        } finally {
            stream.close();
        }
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testCharsetMismatchInfiniteLoop(csName);
        }
    }

    private void a(final int bufferSize, final int dataSize, final int readFirst, final java.lang.String csName) throws java.lang.Exception {
        final org.apache.commons.io.input.CharSequenceInputStream is = new org.apache.commons.io.input.CharSequenceInputStream(ALPHABET , csName , bufferSize);
        for (int i = 0 ; i < readFirst ; i++) {
            final int ch = is.read();
            org.junit.Assert.assertFalse((ch == (-1)));
        }
        is.mark(dataSize);
        final byte[] data1 = new byte[dataSize];
        final int readCount1 = is.read(data1);
        org.junit.Assert.assertEquals(dataSize, readCount1);
        is.reset();
        final byte[] data2 = new byte[dataSize];
        final int readCount2 = is.read(data2);
        org.junit.Assert.assertEquals(dataSize, readCount2);
        is.close();
        org.junit.Assert.assertArrayEquals(((("bufferSize=" + bufferSize) + " dataSize=") + dataSize), data1, data2);
    }

    @org.junit.Test
    public void g() throws java.lang.Exception {
        testIO_356(10, 10, 0, "UTF-16");
    }

    @org.junit.Test
    public void h() throws java.lang.Exception {
        testIO_356(10, 10, 0, "UTF-8");
    }

    @org.junit.Test
    public void i() throws java.lang.Exception {
        testIO_356(10, 10, 1, "UTF-8");
    }

    @org.junit.Test
    public void j() throws java.lang.Exception {
        testIO_356(10, 10, 2, "UTF-8");
    }

    @org.junit.Test
    public void k() throws java.lang.Exception {
        testIO_356(10, 13, 0, "UTF-8");
    }

    @org.junit.Test
    public void l() throws java.lang.Exception {
        testIO_356(10, 13, 1, "UTF-8");
    }

    @org.junit.Test
    public void m() throws java.lang.Exception {
        testIO_356(10, 20, 0, "UTF-8");
    }

    private void a(final java.lang.String csName, final int maxBytesPerChar) throws java.lang.Exception {
        for (int bufferSize = maxBytesPerChar ; bufferSize <= 10 ; bufferSize++) {
            for (int dataSize = 1 ; dataSize <= 20 ; dataSize++) {
                testIO_356(bufferSize, dataSize, 0, csName);
            }
        }
    }

    @org.junit.Test
    public void n() throws java.lang.Exception {
        testIO_356_Loop("UTF-16", 4);
    }

    @org.junit.Test
    public void o() throws java.lang.Exception {
        testIO_356_Loop("UTF-8", 4);
    }

    @org.junit.Test
    public void p() throws java.io.IOException {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testBufferedRead(LARGE_TEST_STRING, csName);
        }
    }

    @org.junit.Test
    public void q() throws java.io.IOException {
        testBufferedRead(LARGE_TEST_STRING, "UTF-8");
    }

    @org.junit.Test
    public void r() throws java.io.IOException {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testSingleByteRead(LARGE_TEST_STRING, csName);
        }
    }

    @org.junit.Test
    public void s() throws java.io.IOException {
        testSingleByteRead(LARGE_TEST_STRING, "UTF-8");
    }

    private void e(final java.lang.String csName) throws java.lang.Exception {
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream("test" , csName);
        try {
            org.junit.Assert.assertEquals(2, r.skip(2));
            r.mark(0);
            org.junit.Assert.assertEquals(csName, 's', r.read());
            org.junit.Assert.assertEquals(csName, 't', r.read());
            org.junit.Assert.assertEquals(csName, -1, r.read());
            r.reset();
            org.junit.Assert.assertEquals(csName, 's', r.read());
            org.junit.Assert.assertEquals(csName, 't', r.read());
            org.junit.Assert.assertEquals(csName, -1, r.read());
            r.reset();
            r.reset();
        } finally {
            r.close();
        }
    }

    @org.junit.Test
    @org.junit.Ignore
    public void t() throws java.lang.Exception {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testMarkReset(csName);
        }
    }

    @org.junit.Test
    public void u() throws java.lang.Exception {
        testMarkReset("US-ASCII");
    }

    @org.junit.Test
    public void v() throws java.lang.Exception {
        testMarkReset("UTF-8");
    }

    @org.junit.Test
    public void w() throws java.lang.Exception {
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream("test" , "UTF-8");
        try {
            org.junit.Assert.assertTrue(r.markSupported());
        } finally {
            r.close();
        }
    }

    private void f(final java.lang.String csName) throws java.lang.Exception {
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream("test" , csName);
        try {
            final byte[] bytes = new byte[30];
            org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        } finally {
            r.close();
        }
    }

    @org.junit.Test
    public void x() throws java.lang.Exception {
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream("" , "UTF-8");
        try {
            final byte[] bytes = new byte[30];
            org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        } finally {
            r.close();
        }
    }

    @org.junit.Test
    public void y() throws java.lang.Exception {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testReadZero(csName);
        }
    }

    private void b(final java.lang.String testString, final java.lang.String charsetName) throws java.io.IOException {
        final byte[] bytes = testString.getBytes(charsetName);
        final java.io.InputStream in = new org.apache.commons.io.input.CharSequenceInputStream(testString , charsetName , 512);
        try {
            for (final byte b : bytes) {
                final int read = in.read();
                org.junit.Assert.assertTrue((("read " + read) + " >=0 "), (read >= 0));
                org.junit.Assert.assertTrue((("read " + read) + " <= 255"), (read <= 255));
                org.junit.Assert.assertEquals("Should agree with input", b, ((byte)(read)));
            }
            org.junit.Assert.assertEquals(-1, in.read());
        } finally {
            in.close();
        }
    }

    @org.junit.Test
    public void z() throws java.io.IOException {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testSingleByteRead(TEST_STRING, csName);
        }
    }

    @org.junit.Test
    public void aa() throws java.io.IOException {
        testSingleByteRead(TEST_STRING, "UTF-16");
    }

    @org.junit.Test
    public void ab() throws java.io.IOException {
        testSingleByteRead(TEST_STRING, "UTF-8");
    }

    private void aa(final java.lang.String csName) throws java.lang.Exception {
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream("test" , csName);
        try {
            org.junit.Assert.assertEquals(1, r.skip(1));
            org.junit.Assert.assertEquals(2, r.skip(2));
            org.junit.Assert.assertEquals(csName, 't', r.read());
            r.skip(100);
            org.junit.Assert.assertEquals(csName, -1, r.read());
        } finally {
            r.close();
        }
    }

    @org.junit.Test
    @org.junit.Ignore
    public void ac() throws java.lang.Exception {
        for (final java.lang.String csName : getRequiredCharsetNames()) {
            testSkip(csName);
        }
    }

    @org.junit.Test
    public void ad() throws java.lang.Exception {
        testSkip("US-ASCII");
    }

    @org.junit.Test
    public void ae() throws java.lang.Exception {
        testSkip("UTF-8");
    }

    private int a(java.io.InputStream is, int min) throws java.lang.Exception {
        int available = is.available();
        org.junit.Assert.assertTrue(((("avail should be >= " + min) + ", but was ") + available), (available >= min));
        return available;
    }

    private void c(final java.lang.String csName) throws java.lang.Exception {
        final java.lang.String input = "test";
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream(input , csName);
        try {
            int available = checkAvail(r, input.length());
            org.junit.Assert.assertEquals((available - 1), r.skip((available - 1)));
            available = checkAvail(r, 1);
            org.junit.Assert.assertEquals(1, r.skip(1));
            available = checkAvail(r, 0);
        } finally {
            r.close();
        }
    }

    private void b(final java.lang.String csName) throws java.lang.Exception {
        final java.lang.String input = "test";
        final java.io.InputStream r = new org.apache.commons.io.input.CharSequenceInputStream(input , csName);
        try {
            int available = checkAvail(r, input.length());
            byte[] buff = new byte[available];
            org.junit.Assert.assertEquals((available - 1), r.skip((available - 1)));
            available = checkAvail(r, 1);
            buff = new byte[available];
            org.junit.Assert.assertEquals(available, r.read(buff, 0, available));
        } finally {
            r.close();
        }
    }

    @org.junit.Test
    public void b() throws java.lang.Exception {
        for (final java.lang.String csName : java.nio.charset.Charset.availableCharsets().keySet()) {
            if (isAvailabilityTestableForCharset(csName)) {
                testAvailableSkip(csName);
                testAvailableRead(csName);
            } 
        }
    }

    private boolean a(final java.lang.String csName) {
        return ((java.nio.charset.Charset.forName(csName).canEncode()) && (!("COMPOUND_TEXT".equalsIgnoreCase(csName)))) && (!("x-COMPOUND_TEXT".equalsIgnoreCase(csName)));
    }
}

