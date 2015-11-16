package org.apache.commons.io.input;


public class NullInputStreamTest extends junit.framework.TestCase {
    public NullInputStreamTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        super.tearDown();
    }

    public void d() throws java.lang.Exception {
        final int size = 5;
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(size);
        for (int i = 0 ; i < size ; i++) {
            junit.framework.TestCase.assertEquals((("Check Size [" + i) + "]"), (size - i), input.available());
            junit.framework.TestCase.assertEquals((("Check Value [" + i) + "]"), i, input.read());
        }
        junit.framework.TestCase.assertEquals("Available after contents all read", 0, input.available());
        junit.framework.TestCase.assertEquals("End of File", -1, input.read());
        junit.framework.TestCase.assertEquals("Available after End of File", 0, input.available());
        try {
            final int result = input.read();
            junit.framework.TestCase.fail((("Should have thrown an IOException, byte=[" + result) + "]"));
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read after end of file", e.getMessage());
        }
        input.close();
        junit.framework.TestCase.assertEquals("Available after close", size, input.available());
    }

    public void e() throws java.lang.Exception {
        final byte[] bytes = new byte[10];
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(15);
        final int count1 = input.read(bytes);
        junit.framework.TestCase.assertEquals("Read 1", bytes.length, count1);
        for (int i = 0 ; i < count1 ; i++) {
            junit.framework.TestCase.assertEquals("Check Bytes 1", i, bytes[i]);
        }
        final int count2 = input.read(bytes);
        junit.framework.TestCase.assertEquals("Read 2", 5, count2);
        for (int i = 0 ; i < count2 ; i++) {
            junit.framework.TestCase.assertEquals("Check Bytes 2", (count1 + i), bytes[i]);
        }
        final int count3 = input.read(bytes);
        junit.framework.TestCase.assertEquals("Read 3 (EOF)", -1, count3);
        try {
            final int count4 = input.read(bytes);
            junit.framework.TestCase.fail((("Should have thrown an IOException, byte=[" + count4) + "]"));
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read after end of file", e.getMessage());
        }
        input.close();
        final int offset = 2;
        final int lth = 4;
        final int count5 = input.read(bytes, offset, lth);
        junit.framework.TestCase.assertEquals("Read 5", lth, count5);
        for (int i = offset ; i < lth ; i++) {
            junit.framework.TestCase.assertEquals("Check Bytes 2", i, bytes[i]);
        }
    }

    public void a() throws java.lang.Exception {
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(2 , false , true);
        junit.framework.TestCase.assertEquals("Read 1", 0, input.read());
        junit.framework.TestCase.assertEquals("Read 2", 1, input.read());
        try {
            final int result = input.read();
            junit.framework.TestCase.fail((("Should have thrown an EOFException, byte=[" + result) + "]"));
        } catch (final java.io.EOFException e) {
        }
        input.close();
    }

    public void b() throws java.lang.Exception {
        int position = 0;
        final int readlimit = 10;
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(100 , true , false);
        junit.framework.TestCase.assertTrue("Mark Should be Supported", input.markSupported());
        try {
            input.reset();
            junit.framework.TestCase.fail("Read limit exceeded, expected IOException ");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("No Mark IOException message", "No position has been marked", e.getMessage());
        }
        for ( ; position < 3 ; position++) {
            junit.framework.TestCase.assertEquals((("Read Before Mark [" + position) + "]"), position, input.read());
        }
        input.mark(readlimit);
        for (int i = 0 ; i < 3 ; i++) {
            junit.framework.TestCase.assertEquals((("Read After Mark [" + i) + "]"), (position + i), input.read());
        }
        input.reset();
        for (int i = 0 ; i < (readlimit + 1) ; i++) {
            junit.framework.TestCase.assertEquals((("Read After Reset [" + i) + "]"), (position + i), input.read());
        }
        try {
            input.reset();
            junit.framework.TestCase.fail("Read limit exceeded, expected IOException ");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read limit IOException message", (((("Marked position [" + position) + "] is no longer valid - passed the read limit [") + readlimit) + "]"), e.getMessage());
        }
        input.close();
    }

    public void c() throws java.lang.Exception {
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(100 , false , true);
        junit.framework.TestCase.assertFalse("Mark Should NOT be Supported", input.markSupported());
        try {
            input.mark(5);
            junit.framework.TestCase.fail("mark() should throw UnsupportedOperationException");
        } catch (final java.lang.UnsupportedOperationException e) {
            junit.framework.TestCase.assertEquals("mark() error message", "Mark not supported", e.getMessage());
        }
        try {
            input.reset();
            junit.framework.TestCase.fail("reset() should throw UnsupportedOperationException");
        } catch (final java.lang.UnsupportedOperationException e) {
            junit.framework.TestCase.assertEquals("reset() error message", "Mark not supported", e.getMessage());
        }
        input.close();
    }

    public void f() throws java.lang.Exception {
        final java.io.InputStream input = new org.apache.commons.io.input.NullInputStreamTest.TestNullInputStream(10 , true , false);
        junit.framework.TestCase.assertEquals("Read 1", 0, input.read());
        junit.framework.TestCase.assertEquals("Read 2", 1, input.read());
        junit.framework.TestCase.assertEquals("Skip 1", 5, input.skip(5));
        junit.framework.TestCase.assertEquals("Read 3", 7, input.read());
        junit.framework.TestCase.assertEquals("Skip 2", 2, input.skip(5));
        junit.framework.TestCase.assertEquals("Skip 3 (EOF)", -1, input.skip(5));
        try {
            input.skip(5);
            junit.framework.TestCase.fail("Expected IOException for skipping after end of file");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Skip after EOF IOException message", "Skip after end of file", e.getMessage());
        }
        input.close();
    }

    private static final class TestNullInputStream extends org.apache.commons.io.input.NullInputStream {
        public TestNullInputStream(final int size) {
            super(size);
        }

        public TestNullInputStream(final int size ,final boolean markSupported ,final boolean throwEofException) {
            super(size, markSupported, throwEofException);
        }

        @java.lang.Override
        protected int b() {
            return ((int)(getPosition())) - 1;
        }

        @java.lang.Override
        protected void a(final byte[] bytes, final int offset, final int length) {
            final int startPos = ((int)(getPosition())) - length;
            for (int i = offset ; i < length ; i++) {
                bytes[i] = ((byte)(startPos + i));
            }
        }
    }
}

