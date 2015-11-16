package org.apache.commons.io;


@java.lang.SuppressWarnings(value = "deprecation")
public class CopyUtilsTest extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int FILE_SIZE = (1024 * 4) + 1;

    private final byte[] inData = generateTestData(FILE_SIZE);

    public CopyUtilsTest(final java.lang.String testName) {
        super(testName);
    }

    @java.lang.Override
    public void setUp() throws java.lang.Exception {
    }

    @java.lang.Override
    public void tearDown() throws java.lang.Exception {
    }

    public void i() {
        new org.apache.commons.io.CopyUtils();
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.CopyUtils.copy(inData, out);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        org.apache.commons.io.CopyUtils.copy(inData, writer);
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void a() throws java.lang.Exception {
        final java.lang.String inDataStr = "data";
        final java.lang.String charsetName = "UTF-8";
        final java.io.StringWriter writer = new java.io.StringWriter();
        org.apache.commons.io.CopyUtils.copy(inDataStr.getBytes(charsetName), writer, charsetName);
        junit.framework.TestCase.assertEquals(inDataStr, writer.toString());
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void b() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final int count = org.apache.commons.io.CopyUtils.copy(in, out);
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
        junit.framework.TestCase.assertEquals(inData.length, count);
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void c() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        org.apache.commons.io.CopyUtils.copy(in, writer);
        writer.flush();
        junit.framework.TestCase.assertEquals("Not all bytes were read", 0, in.available());
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void d() throws java.lang.Exception {
        final java.lang.String inDataStr = "data";
        final java.lang.String charsetName = "UTF-8";
        final java.io.StringWriter writer = new java.io.StringWriter();
        org.apache.commons.io.CopyUtils.copy(new java.io.ByteArrayInputStream(inDataStr.getBytes(charsetName)), writer, charsetName);
        junit.framework.TestCase.assertEquals(inDataStr, writer.toString());
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void e() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.CopyUtils.copy(reader, out);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    @java.lang.SuppressWarnings(value = "resource")
    public void f() throws java.lang.Exception {
        java.io.InputStream in = new java.io.ByteArrayInputStream(inData);
        in = new org.apache.commons.io.testtools.YellOnCloseInputStream(in);
        final java.io.Reader reader = new java.io.InputStreamReader(in , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        final int count = org.apache.commons.io.CopyUtils.copy(reader, writer);
        writer.flush();
        junit.framework.TestCase.assertEquals("The number of characters returned by copy is wrong", inData.length, count);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void g() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.CopyUtils.copy(str, out);
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void h() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final java.io.OutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(out , "US-ASCII");
        org.apache.commons.io.CopyUtils.copy(str, writer);
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }
}

