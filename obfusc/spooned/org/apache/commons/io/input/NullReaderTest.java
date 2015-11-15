package org.apache.commons.io.input;


public class NullReaderTest extends junit.framework.TestCase {
    public NullReaderTest(final java.lang.String name) {
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
        final org.apache.commons.io.input.NullReaderTest.TestNullReader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(size);
        for (int i = 0 ; i < size ; i++) {
            junit.framework.TestCase.assertEquals((("Check Value [" + i) + "]"), i, reader.read());
        }
        junit.framework.TestCase.assertEquals("End of File", -1, reader.read());
        try {
            final int result = reader.read();
            junit.framework.TestCase.fail((("Should have thrown an IOException, value=[" + result) + "]"));
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read after end of file", e.getMessage());
        }
        reader.close();
        junit.framework.TestCase.assertEquals("Available after close", 0, reader.getPosition());
    }

    public void e() throws java.lang.Exception {
        final char[] chars = new char[10];
        final java.io.Reader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(15);
        final int count1 = reader.read(chars);
        junit.framework.TestCase.assertEquals("Read 1", chars.length, count1);
        for (int i = 0 ; i < count1 ; i++) {
            junit.framework.TestCase.assertEquals("Check Chars 1", i, chars[i]);
        }
        final int count2 = reader.read(chars);
        junit.framework.TestCase.assertEquals("Read 2", 5, count2);
        for (int i = 0 ; i < count2 ; i++) {
            junit.framework.TestCase.assertEquals("Check Chars 2", (count1 + i), chars[i]);
        }
        final int count3 = reader.read(chars);
        junit.framework.TestCase.assertEquals("Read 3 (EOF)", -1, count3);
        try {
            final int count4 = reader.read(chars);
            junit.framework.TestCase.fail((("Should have thrown an IOException, value=[" + count4) + "]"));
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read after end of file", e.getMessage());
        }
        reader.close();
        final int offset = 2;
        final int lth = 4;
        final int count5 = reader.read(chars, offset, lth);
        junit.framework.TestCase.assertEquals("Read 5", lth, count5);
        for (int i = offset ; i < lth ; i++) {
            junit.framework.TestCase.assertEquals("Check Chars 3", i, chars[i]);
        }
    }

    public void a() throws java.lang.Exception {
        final java.io.Reader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(2 , false , true);
        junit.framework.TestCase.assertEquals("Read 1", 0, reader.read());
        junit.framework.TestCase.assertEquals("Read 2", 1, reader.read());
        try {
            final int result = reader.read();
            junit.framework.TestCase.fail((("Should have thrown an EOFException, value=[" + result) + "]"));
        } catch (final java.io.EOFException e) {
        }
        reader.close();
    }

    public void b() throws java.lang.Exception {
        int position = 0;
        final int readlimit = 10;
        final java.io.Reader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(100 , true , false);
        junit.framework.TestCase.assertTrue("Mark Should be Supported", reader.markSupported());
        try {
            reader.reset();
            junit.framework.TestCase.fail("Read limit exceeded, expected IOException ");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("No Mark IOException message", "No position has been marked", e.getMessage());
        }
        for ( ; position < 3 ; position++) {
            junit.framework.TestCase.assertEquals((("Read Before Mark [" + position) + "]"), position, reader.read());
        }
        reader.mark(readlimit);
        for (int i = 0 ; i < 3 ; i++) {
            junit.framework.TestCase.assertEquals((("Read After Mark [" + i) + "]"), (position + i), reader.read());
        }
        reader.reset();
        for (int i = 0 ; i < (readlimit + 1) ; i++) {
            junit.framework.TestCase.assertEquals((("Read After Reset [" + i) + "]"), (position + i), reader.read());
        }
        try {
            reader.reset();
            junit.framework.TestCase.fail("Read limit exceeded, expected IOException ");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Read limit IOException message", (((("Marked position [" + position) + "] is no longer valid - passed the read limit [") + readlimit) + "]"), e.getMessage());
        }
        reader.close();
    }

    public void c() throws java.lang.Exception {
        final java.io.Reader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(100 , false , true);
        junit.framework.TestCase.assertFalse("Mark Should NOT be Supported", reader.markSupported());
        try {
            reader.mark(5);
            junit.framework.TestCase.fail("mark() should throw UnsupportedOperationException");
        } catch (final java.lang.UnsupportedOperationException e) {
            junit.framework.TestCase.assertEquals("mark() error message", "Mark not supported", e.getMessage());
        }
        try {
            reader.reset();
            junit.framework.TestCase.fail("reset() should throw UnsupportedOperationException");
        } catch (final java.lang.UnsupportedOperationException e) {
            junit.framework.TestCase.assertEquals("reset() error message", "Mark not supported", e.getMessage());
        }
        reader.close();
    }

    public void f() throws java.lang.Exception {
        final java.io.Reader reader = new org.apache.commons.io.input.NullReaderTest.TestNullReader(10 , true , false);
        junit.framework.TestCase.assertEquals("Read 1", 0, reader.read());
        junit.framework.TestCase.assertEquals("Read 2", 1, reader.read());
        junit.framework.TestCase.assertEquals("Skip 1", 5, reader.skip(5));
        junit.framework.TestCase.assertEquals("Read 3", 7, reader.read());
        junit.framework.TestCase.assertEquals("Skip 2", 2, reader.skip(5));
        junit.framework.TestCase.assertEquals("Skip 3 (EOF)", -1, reader.skip(5));
        try {
            reader.skip(5);
            junit.framework.TestCase.fail("Expected IOException for skipping after end of file");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals("Skip after EOF IOException message", "Skip after end of file", e.getMessage());
        }
        reader.close();
    }

    private static final class TestNullReader extends org.apache.commons.io.input.NullReader {
        public TestNullReader(final int size) {
            super(size);
        }

        public TestNullReader(final int size ,final boolean markSupported ,final boolean throwEofException) {
            super(size, markSupported, throwEofException);
        }

        @java.lang.Override
        protected int b() {
            return ((int)(getPosition())) - 1;
        }

        @java.lang.Override
        protected void a(final char[] chars, final int offset, final int length) {
            final int startPos = ((int)(getPosition())) - length;
            for (int i = offset ; i < length ; i++) {
                chars[i] = ((char)(startPos + i));
            }
        }
    }
}

