package org.apache.commons.io;


@java.lang.SuppressWarnings(value = "deprecation")
public class IOUtilsWriteTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int FILE_SIZE = (1024 * 4) + 1;

    private final byte[] inData = generateTestData(FILE_SIZE);

    public IOUtilsWriteTestCase(final java.lang.String testName) {
        super(testName);
    }

    @java.lang.Override
    public void setUp() throws java.lang.Exception {
    }

    @java.lang.Override
    public void tearDown() throws java.lang.Exception {
    }

    public void n() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(inData, out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void o() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((byte[])(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void p() throws java.lang.Exception {
        try {
            org.apache.commons.io.IOUtils.write(inData, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void q() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(inData, writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void v() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(((byte[])(null)), writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void w() throws java.lang.Exception {
        try {
            org.apache.commons.io.IOUtils.write(inData, ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void r() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(inData, writer, "UTF8");
        out.off();
        writer.flush();
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF8").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void s() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(null, writer, "UTF8");
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void u() throws java.lang.Exception {
        try {
            org.apache.commons.io.IOUtils.write(inData, null, "UTF8");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void t() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(inData, writer, ((java.lang.String)(null)));
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ah() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(csq, out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void al() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((java.lang.CharSequence)(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void an() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        try {
            org.apache.commons.io.IOUtils.write(csq, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void ai() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(csq, out, "UTF16");
        out.off();
        out.flush();
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF16").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void aj() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((java.lang.CharSequence)(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void ak() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        try {
            org.apache.commons.io.IOUtils.write(csq, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void am() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(csq, out, ((java.lang.String)(null)));
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ao() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(csq, writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ap() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(((java.lang.CharSequence)(null)), writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void aq() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder(new java.lang.String(inData , "US-ASCII"));
        try {
            org.apache.commons.io.IOUtils.write(csq, ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void ar() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str, out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void av() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((java.lang.String)(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void ax() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void as() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str, out, "UTF16");
        out.off();
        out.flush();
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF16").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void at() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((java.lang.String)(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void au() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str, ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void aw() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str, out, ((java.lang.String)(null)));
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ay() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(str, writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void az() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(((java.lang.String)(null)), writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void ba() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str, ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void x() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str.toCharArray(), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ab() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((char[])(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void ad() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str.toCharArray(), ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void y() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str.toCharArray(), out, "UTF16");
        out.off();
        out.flush();
        byte[] bytes = baout.toByteArray();
        bytes = new java.lang.String(bytes , "UTF16").getBytes("US-ASCII");
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, bytes));
    }

    public void z() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(((char[])(null)), out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void aa() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str.toCharArray(), ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void ac() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        org.apache.commons.io.IOUtils.write(str.toCharArray(), out, ((java.lang.String)(null)));
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void ae() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(str.toCharArray(), writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", inData.length, baout.size());
        junit.framework.TestCase.assertTrue("Content differs", java.util.Arrays.equals(inData, baout.toByteArray()));
    }

    public void af() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.write(((char[])(null)), writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void ag() throws java.lang.Exception {
        final java.lang.String str = new java.lang.String(inData , "US-ASCII");
        try {
            org.apache.commons.io.IOUtils.write(str.toCharArray(), ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void a() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(list, "*", out);
        out.off();
        out.flush();
        final java.lang.String expected = "hello*world**this is**some text*";
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void g() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(null, "*", out);
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void h() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(list, null, out);
        out.off();
        out.flush();
        final java.lang.String expected = (("hello" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "world") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void i() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        try {
            org.apache.commons.io.IOUtils.writeLines(list, "*", ((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void b() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello荤" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(list, "*", out, "UTF-8");
        out.off();
        out.flush();
        final java.lang.String expected = "hello荤*world**this is**some text*";
        final java.lang.String actual = baout.toString("UTF-8");
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void c() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(null, "*", out, "US-ASCII");
        out.off();
        out.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void e() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(list, null, out, "US-ASCII");
        out.off();
        out.flush();
        final java.lang.String expected = (("hello" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "world") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void f() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        try {
            org.apache.commons.io.IOUtils.writeLines(list, "*", null, "US-ASCII");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void d() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , false , true);
        org.apache.commons.io.IOUtils.writeLines(list, "*", out, ((java.lang.String)(null)));
        out.off();
        out.flush();
        final java.lang.String expected = "hello*world**this is**some text*";
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void j() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.writeLines(list, "*", writer);
        out.off();
        writer.flush();
        final java.lang.String expected = "hello*world**this is**some text*";
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void k() throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.writeLines(null, "*", writer);
        out.off();
        writer.flush();
        junit.framework.TestCase.assertEquals("Sizes differ", 0, baout.size());
    }

    public void l() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
        @java.lang.SuppressWarnings(value = "resource")
        final org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream out = new org.apache.commons.io.testtools.YellOnFlushAndCloseOutputStream(baout , true , true);
        final java.io.Writer writer = new java.io.OutputStreamWriter(baout , "US-ASCII");
        org.apache.commons.io.IOUtils.writeLines(list, null, writer);
        out.off();
        writer.flush();
        final java.lang.String expected = (("hello" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "world") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = baout.toString();
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void m() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , "world" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        try {
            org.apache.commons.io.IOUtils.writeLines(list, "*", ((java.io.Writer)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }
}

