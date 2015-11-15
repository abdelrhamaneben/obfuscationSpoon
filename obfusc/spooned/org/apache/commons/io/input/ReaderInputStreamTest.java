package org.apache.commons.io.input;


public class ReaderInputStreamTest {
    private static final java.lang.String TEST_STRING = "à peine arrivés nous entrâmes dans sa chambre";

    private static final java.lang.String LARGE_TEST_STRING;

    static {
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        for (int i = 0 ; i < 100 ; i++) {
            buffer.append(TEST_STRING);
        }
        LARGE_TEST_STRING = buffer.toString();
    }

    private final java.util.Random random = new java.util.Random();

    private void b(final java.lang.String testString, final java.lang.String charsetName) throws java.io.IOException {
        final byte[] bytes = testString.getBytes(charsetName);
        final org.apache.commons.io.input.ReaderInputStream in = new org.apache.commons.io.input.ReaderInputStream(new java.io.StringReader(testString) , charsetName);
        for (final byte b : bytes) {
            final int read = in.read();
            org.junit.Assert.assertTrue((read >= 0));
            org.junit.Assert.assertTrue((read <= 255));
            org.junit.Assert.assertEquals(b, ((byte)(read)));
        }
        org.junit.Assert.assertEquals(-1, in.read());
        in.close();
    }

    private void a(final java.lang.String testString, final java.lang.String charsetName) throws java.io.IOException {
        final byte[] expected = testString.getBytes(charsetName);
        final org.apache.commons.io.input.ReaderInputStream in = new org.apache.commons.io.input.ReaderInputStream(new java.io.StringReader(testString) , charsetName);
        final byte[] buffer = new byte[128];
        int offset = 0;
        while (true) {
            int bufferOffset = random.nextInt(64);
            final int bufferLength = random.nextInt(64);
            int read = in.read(buffer, bufferOffset, bufferLength);
            if (read == (-1)) {
                org.junit.Assert.assertEquals(offset, expected.length);
                break;
            } else {
                org.junit.Assert.assertTrue((read <= bufferLength));
                while (read > 0) {
                    org.junit.Assert.assertTrue((offset < (expected.length)));
                    org.junit.Assert.assertEquals(expected[offset], buffer[bufferOffset]);
                    offset++;
                    bufferOffset++;
                    read--;
                }
            }
        }
        in.close();
    }

    @org.junit.Test
    public void h() throws java.io.IOException {
        testWithSingleByteRead(TEST_STRING, "UTF-8");
    }

    @org.junit.Test
    public void c() throws java.io.IOException {
        testWithSingleByteRead(LARGE_TEST_STRING, "UTF-8");
    }

    @org.junit.Test
    public void g() throws java.io.IOException {
        testWithBufferedRead(TEST_STRING, "UTF-8");
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        testWithBufferedRead(LARGE_TEST_STRING, "UTF-8");
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        testWithSingleByteRead(TEST_STRING, "UTF-16");
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    @org.junit.Test
    public void d() throws java.lang.Exception {
        final java.lang.String inStr = "test";
        final org.apache.commons.io.input.ReaderInputStream r = new org.apache.commons.io.input.ReaderInputStream(new java.io.StringReader(inStr));
        final byte[] bytes = new byte[30];
        org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        org.junit.Assert.assertEquals(inStr.length(), r.read(bytes, 0, ((inStr.length()) + 1)));
        org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        r.close();
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    @org.junit.Test
    public void e() throws java.lang.Exception {
        final org.apache.commons.io.input.ReaderInputStream r = new org.apache.commons.io.input.ReaderInputStream(new java.io.StringReader(""));
        final byte[] bytes = new byte[30];
        org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        org.junit.Assert.assertEquals(-1, r.read(bytes, 0, 1));
        org.junit.Assert.assertEquals(0, r.read(bytes, 0, 0));
        org.junit.Assert.assertEquals(-1, r.read(bytes, 0, 1));
        r.close();
    }

    @org.junit.Test
    public void a() throws java.io.IOException {
        final char[] inputChars = new char[]{ ((char)(224)) , ((char)(178)) , ((char)(160)) };
        final java.nio.charset.Charset charset = java.nio.charset.Charset.forName("ASCII");
        final org.apache.commons.io.input.ReaderInputStream stream = new org.apache.commons.io.input.ReaderInputStream(new java.io.CharArrayReader(inputChars) , charset);
        try {
            while ((stream.read()) != (-1)) {
            }
        } finally {
            stream.close();
        }
    }
}

