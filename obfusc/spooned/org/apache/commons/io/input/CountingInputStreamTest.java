package org.apache.commons.io.input;


public class CountingInputStreamTest extends junit.framework.TestCase {
    public CountingInputStreamTest(final java.lang.String name) {
        super(name);
    }

    public void a() throws java.lang.Exception {
        final java.lang.String text = "A piece of text";
        final byte[] bytes = text.getBytes();
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(bytes);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[21];
        final byte[] ba = new byte[5];
        int found = cis.read(ba);
        java.lang.System.arraycopy(ba, 0, result, 0, 5);
        junit.framework.TestCase.assertEquals(found, cis.getCount());
        final int value = cis.read();
        found++;
        result[5] = ((byte)(value));
        junit.framework.TestCase.assertEquals(found, cis.getCount());
        found += cis.read(result, 6, 5);
        junit.framework.TestCase.assertEquals(found, cis.getCount());
        found += cis.read(result, 11, 10);
        junit.framework.TestCase.assertEquals(found, cis.getCount());
        final java.lang.String textResult = new java.lang.String(result).trim();
        junit.framework.TestCase.assertEquals(textResult, text);
        cis.close();
    }

    public void e() throws java.lang.Exception {
        final long size = ((long)(java.lang.Integer.MAX_VALUE)) + ((long)(1));
        final org.apache.commons.io.input.NullInputStream mock = new org.apache.commons.io.input.NullInputStream(size);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(mock);
        final java.io.OutputStream out = new org.apache.commons.io.output.NullOutputStream();
        org.apache.commons.io.IOUtils.copyLarge(cis, out);
        try {
            cis.getCount();
            junit.framework.TestCase.fail("Expected getCount() to throw an ArithmeticException");
        } catch (final java.lang.ArithmeticException ae) {
        }
        try {
            cis.resetCount();
            junit.framework.TestCase.fail("Expected resetCount() to throw an ArithmeticException");
        } catch (final java.lang.ArithmeticException ae) {
        }
        mock.close();
        org.apache.commons.io.IOUtils.copyLarge(cis, out);
        junit.framework.TestCase.assertEquals("getByteCount()", size, cis.getByteCount());
        junit.framework.TestCase.assertEquals("resetByteCount()", size, cis.resetByteCount());
    }

    public void f() throws java.lang.Exception {
        final java.lang.String text = "A piece of text";
        final byte[] bytes = text.getBytes();
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(bytes);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[bytes.length];
        int found = cis.read(result, 0, 5);
        junit.framework.TestCase.assertEquals(found, cis.getCount());
        final int count = cis.resetCount();
        found = cis.read(result, 6, 5);
        junit.framework.TestCase.assertEquals(found, count);
        cis.close();
    }

    public void h() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[0]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final int found = cis.read();
        junit.framework.TestCase.assertEquals(-1, found);
        junit.framework.TestCase.assertEquals(0, cis.getCount());
        cis.close();
    }

    public void i() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[0]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[10];
        final int found = cis.read(result);
        junit.framework.TestCase.assertEquals(-1, found);
        junit.framework.TestCase.assertEquals(0, cis.getCount());
        cis.close();
    }

    public void j() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[0]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[10];
        final int found = cis.read(result, 0, 5);
        junit.framework.TestCase.assertEquals(-1, found);
        junit.framework.TestCase.assertEquals(0, cis.getCount());
        cis.close();
    }

    public void b() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[2]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        int found = cis.read();
        junit.framework.TestCase.assertEquals(0, found);
        junit.framework.TestCase.assertEquals(1, cis.getCount());
        found = cis.read();
        junit.framework.TestCase.assertEquals(0, found);
        junit.framework.TestCase.assertEquals(2, cis.getCount());
        found = cis.read();
        junit.framework.TestCase.assertEquals(-1, found);
        junit.framework.TestCase.assertEquals(2, cis.getCount());
        cis.close();
    }

    public void c() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[2]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[10];
        final int found = cis.read(result);
        junit.framework.TestCase.assertEquals(2, found);
        junit.framework.TestCase.assertEquals(2, cis.getCount());
        cis.close();
    }

    public void d() throws java.lang.Exception {
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(new byte[2]);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        final byte[] result = new byte[10];
        final int found = cis.read(result, 0, 5);
        junit.framework.TestCase.assertEquals(2, found);
        junit.framework.TestCase.assertEquals(2, cis.getCount());
        cis.close();
    }

    public void g() throws java.io.IOException {
        final java.lang.String text = "Hello World!";
        final byte[] bytes = text.getBytes();
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(bytes);
        final org.apache.commons.io.input.CountingInputStream cis = new org.apache.commons.io.input.CountingInputStream(bais);
        junit.framework.TestCase.assertEquals(6, cis.skip(6));
        junit.framework.TestCase.assertEquals(6, cis.getCount());
        final byte[] result = new byte[6];
        cis.read(result);
        junit.framework.TestCase.assertEquals("World!", new java.lang.String(result));
        junit.framework.TestCase.assertEquals(12, cis.getCount());
        cis.close();
    }
}

