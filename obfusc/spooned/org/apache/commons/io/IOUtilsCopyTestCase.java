package org.apache.commons.io;


public class IOUtilsCopyTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int FILE_SIZE = (1024 * 4) + 1;

    private final byte[] inData = generateTestData(FILE_SIZE);

    public IOUtilsCopyTestCase(final java.lang.String testName) {
        super(testName);
    }

    @java.lang.Override
    public void setUp() throws java.lang.Exception {
    }

    @java.lang.Override
    public void tearDown() throws java.lang.Exception {
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void a() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final int count = org.apache.commons.io.IOUtils.copy(in, out);
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
        junit.framework.TestCase.assertEquals(inData.length, count);
    }

    public void b() throws java.lang.Exception {
        testCopy_inputStreamToOutputStreamWithBufferSize(1);
        testCopy_inputStreamToOutputStreamWithBufferSize(2);
        testCopy_inputStreamToOutputStreamWithBufferSize(4);
        testCopy_inputStreamToOutputStreamWithBufferSize(8);
        testCopy_inputStreamToOutputStreamWithBufferSize(16);
        testCopy_inputStreamToOutputStreamWithBufferSize(32);
        testCopy_inputStreamToOutputStreamWithBufferSize(64);
        testCopy_inputStreamToOutputStreamWithBufferSize(128);
        testCopy_inputStreamToOutputStreamWithBufferSize(256);
        testCopy_inputStreamToOutputStreamWithBufferSize(512);
        testCopy_inputStreamToOutputStreamWithBufferSize(1024);
        testCopy_inputStreamToOutputStreamWithBufferSize(2048);
        testCopy_inputStreamToOutputStreamWithBufferSize(4096);
        testCopy_inputStreamToOutputStreamWithBufferSize(8192);
        testCopy_inputStreamToOutputStreamWithBufferSize(16384);
    }

    @java.lang.SuppressWarnings(value = "resource")
    private void a(final int bufferSize) throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final long count = org.apache.commons.io.IOUtils.copy(in, out, bufferSize);
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
        junit.framework.TestCase.assertEquals(inData.length, count);
    }

    public void d() throws java.lang.Exception {
        final java.io.OutputStream out = new org.apache.commons.io.output.ByteArrayOutputStream();
        try {
            org.apache.commons.io.IOUtils.copy(((java.io.InputStream)(null)), out);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void e() throws java.lang.Exception {
        final java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        try {
            org.apache.commons.io.IOUtils.copy(in, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void c() throws java.lang.Exception {
        final long size = ((long)(java.lang.Integer.MAX_VALUE)) + ((long)(1));
        final java.io.InputStream in = new org.apache.commons.io.input.NullInputStream(size);
        final java.io.OutputStream out = new org.apache.commons.io.output.NullOutputStream();
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOUtils.copy(in, out));
        in.close();
        junit.framework.TestCase.assertEquals("copyLarge()", size, org.apache.commons.io.IOUtils.copyLarge(in, out));
    }

    @java.lang.SuppressWarnings(value = { "resource" , "deprecation" })
    public void f() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.copy(in, writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void k() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(((java.io.InputStream)(null)), writer);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void l() throws java.lang.Exception {
        final java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        try {
            org.apache.commons.io.IOUtils.copy(in, ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void g() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.copy(in, writer, "UTF8");
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF8").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void i() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(null, writer, "UTF8");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void j() throws java.lang.Exception {
        final java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        try {
            org.apache.commons.io.IOUtils.copy(in, null, "UTF8");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void h() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.copy(in, writer, ((java.lang.String)(null)));
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    @java.lang.SuppressWarnings(value = { "resource" , "deprecation" })
    public void m() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.copy(reader, out);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void r() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        try {
            org.apache.commons.io.IOUtils.copy(((java.io.Reader)(null)), out);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = { "resource" , "deprecation" })
    public void s() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(reader, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void n() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.copy(reader, out, "UTF16");
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF16").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void p() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        try {
            org.apache.commons.io.IOUtils.copy(null, out, "UTF16");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void q() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(reader, null, "UTF16");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void o() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.copy(reader, out, ((java.lang.String)(null)));
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void t() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        final int count = org.apache.commons.io.IOUtils.copy(reader, writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("The number of characters returned by copy is wrong", inData.length, count);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void v() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(((java.io.Reader)(null)), writer);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void w() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.copy(reader, ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void u() throws java.lang.Exception {
        final long size = ((long)(java.lang.Integer.MAX_VALUE)) + ((long)(1));
        final java.io.Reader reader = new org.apache.commons.io.input.NullReader(size);
        final java.io.Writer writer = new org.apache.commons.io.output.NullWriter();
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOUtils.copy(reader, writer));
        reader.close();
        junit.framework.TestCase.assertEquals("copyLarge()", size, org.apache.commons.io.IOUtils.copyLarge(reader, writer));
    }
}

