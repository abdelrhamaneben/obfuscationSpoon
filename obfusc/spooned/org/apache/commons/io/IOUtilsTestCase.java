package org.apache.commons.io;


public class IOUtilsTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int FILE_SIZE = (1024 * 4) + 1;

    private static final boolean WINDOWS = (java.io.File.separatorChar) == '\\';

    private char[] carr = null;

    private byte[] iarr = null;

    private java.io.File m_testFile;

    public IOUtilsTestCase(final java.lang.String name) {
        super(name);
    }

    private void testCopyDirectoryToItself(final byte[] b0, final byte[] b1) {
        junit.framework.TestCase.assertTrue("Content not equal according to java.util.Arrays#equals()", java.util.Arrays.equals(b0, b1));
    }

    @java.lang.Override
    public void setUp() {
        try {
            org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
            m_testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file2-test.txt");
            createFile(m_testFile, FILE_SIZE);
        } catch (final java.io.IOException ioe) {
            throw new java.lang.RuntimeException(("Can\'t run this test because the environment could not be built: " + (ioe.getMessage())));
        }
        iarr = new byte[200];
        java.util.Arrays.fill(iarr, ((byte)(-1)));
        for (int i = 0 ; i < 80 ; i++) {
            iarr[i] = ((byte)(i));
        }
        carr = new char[200];
        java.util.Arrays.fill(carr, ((char)(-1)));
        for (int i = 0 ; i < 80 ; i++) {
            carr[i] = ((char)(i));
        }
    }

    @java.lang.Override
    public void tearDown() {
        carr = null;
        iarr = null;
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        } catch (final java.io.IOException e) {
            throw new java.lang.RuntimeException(((("Could not clear up " + (org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory())) + ": ") + e));
        }
    }

    public void h() {
        final java.io.Closeable closeable = new java.io.Closeable() {
            public void a() throws java.io.IOException {
                throw new java.io.IOException();
            }
        };
        org.apache.commons.io.IOUtils.closeQuietly(closeable, null, closeable);
    }

    public void i() {
        org.apache.commons.io.IOUtils.closeQuietly(new java.io.Closeable() {
            public void a() throws java.io.IOException {
                throw new java.io.IOException();
            }
        });
    }

    public void j() {
        java.nio.channels.Selector selector = null;
        try {
            selector = java.nio.channels.Selector.open();
        } catch (final java.io.IOException e) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(selector);
        }
    }

    public void k() {
        final java.nio.channels.Selector selector = new org.apache.commons.io.SelectorAdapter() {
            @java.lang.Override
            public void close() throws java.io.IOException {
                throw new java.io.IOException();
            }
        };
        org.apache.commons.io.IOUtils.closeQuietly(selector);
    }

    public void l() {
        final java.nio.channels.Selector selector = null;
        org.apache.commons.io.IOUtils.closeQuietly(selector);
    }

    public void m() {
        java.nio.channels.Selector selector = null;
        try {
            selector = java.nio.channels.Selector.open();
        } catch (final java.io.IOException e) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(selector);
            org.apache.commons.io.IOUtils.closeQuietly(selector);
        }
    }

    public void n() throws java.io.IOException {
        org.apache.commons.io.IOUtils.closeQuietly(((java.net.ServerSocket)(null)));
        org.apache.commons.io.IOUtils.closeQuietly(new java.net.ServerSocket());
    }

    public void o() throws java.io.IOException {
        org.apache.commons.io.IOUtils.closeQuietly(new java.net.ServerSocket() {
            @java.lang.Override
            public void close() throws java.io.IOException {
                throw new java.io.IOException();
            }
        });
    }

    public void p() {
        org.apache.commons.io.IOUtils.closeQuietly(((java.net.Socket)(null)));
        org.apache.commons.io.IOUtils.closeQuietly(new java.net.Socket());
    }

    public void q() {
        org.apache.commons.io.IOUtils.closeQuietly(new java.net.Socket() {
            @java.lang.Override
            public synchronized void close() throws java.io.IOException {
                throw new java.io.IOException();
            }
        });
    }

    public void r() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals('/', org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX);
        junit.framework.TestCase.assertEquals('\\', org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
        junit.framework.TestCase.assertEquals("\n", org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX);
        junit.framework.TestCase.assertEquals("\r\n", org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS);
        if (WINDOWS) {
            junit.framework.TestCase.assertEquals('\\', org.apache.commons.io.IOUtils.DIR_SEPARATOR);
            junit.framework.TestCase.assertEquals("\r\n", org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        } else {
            junit.framework.TestCase.assertEquals('/', org.apache.commons.io.IOUtils.DIR_SEPARATOR);
            junit.framework.TestCase.assertEquals("\n", org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void t() throws java.lang.Exception {
        {
            final java.io.ByteArrayInputStream input1 = new java.io.ByteArrayInputStream("".getBytes(org.apache.commons.io.Charsets.UTF_8));
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(input1, input1));
        }
        {
            final java.io.ByteArrayInputStream input1 = new java.io.ByteArrayInputStream("ABC".getBytes(org.apache.commons.io.Charsets.UTF_8));
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(input1, input1));
        }
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.ByteArrayInputStream("".getBytes(org.apache.commons.io.Charsets.UTF_8)), new java.io.ByteArrayInputStream("".getBytes(org.apache.commons.io.Charsets.UTF_8))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.BufferedInputStream(new java.io.ByteArrayInputStream("".getBytes(org.apache.commons.io.Charsets.UTF_8))), new java.io.BufferedInputStream(new java.io.ByteArrayInputStream("".getBytes(org.apache.commons.io.Charsets.UTF_8)))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.ByteArrayInputStream("ABC".getBytes(org.apache.commons.io.Charsets.UTF_8)), new java.io.ByteArrayInputStream("ABC".getBytes(org.apache.commons.io.Charsets.UTF_8))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOUtils.contentEquals(new java.io.ByteArrayInputStream("ABCD".getBytes(org.apache.commons.io.Charsets.UTF_8)), new java.io.ByteArrayInputStream("ABC".getBytes(org.apache.commons.io.Charsets.UTF_8))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOUtils.contentEquals(new java.io.ByteArrayInputStream("ABC".getBytes(org.apache.commons.io.Charsets.UTF_8)), new java.io.ByteArrayInputStream("ABCD".getBytes(org.apache.commons.io.Charsets.UTF_8))));
    }

    public void u() throws java.lang.Exception {
        {
            final java.io.StringReader input1 = new java.io.StringReader("");
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(input1, input1));
        }
        {
            final java.io.StringReader input1 = new java.io.StringReader("ABC");
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(input1, input1));
        }
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.StringReader(""), new java.io.StringReader("")));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.BufferedReader(new java.io.StringReader("")), new java.io.BufferedReader(new java.io.StringReader(""))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEquals(new java.io.StringReader("ABC"), new java.io.StringReader("ABC")));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOUtils.contentEquals(new java.io.StringReader("ABCD"), new java.io.StringReader("ABC")));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOUtils.contentEquals(new java.io.StringReader("ABC"), new java.io.StringReader("ABCD")));
    }

    public void s() throws java.lang.Exception {
        {
            final java.io.Reader input1 = new java.io.CharArrayReader("".toCharArray());
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(input1, input1));
        }
        {
            final java.io.Reader input1 = new java.io.CharArrayReader("321\r\n".toCharArray());
            junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(input1, input1));
        }
        java.io.Reader r1;
        java.io.Reader r2;
        r1 = new java.io.CharArrayReader("".toCharArray());
        r2 = new java.io.CharArrayReader("".toCharArray());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r1, r2));
        r1 = new java.io.CharArrayReader("1".toCharArray());
        r2 = new java.io.CharArrayReader("1".toCharArray());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r1, r2));
        r1 = new java.io.CharArrayReader("1".toCharArray());
        r2 = new java.io.CharArrayReader("2".toCharArray());
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r1, r2));
        r1 = new java.io.CharArrayReader("123\rabc".toCharArray());
        r2 = new java.io.CharArrayReader("123\nabc".toCharArray());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r1, r2));
        r1 = new java.io.CharArrayReader("321".toCharArray());
        r2 = new java.io.CharArrayReader("321\r\n".toCharArray());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r1, r2));
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void af() throws java.lang.Exception {
        final java.io.File destination = newFile("copy8.txt");
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        byte[] in;
        try {
            in = org.apache.commons.io.IOUtils.toByteArray(fin);
        } finally {
            fin.close();
        }
        final java.io.FileOutputStream fout = new java.io.FileOutputStream(destination);
        try {
            org.apache.commons.io.CopyUtils.copy(in, fout);
            fout.flush();
            checkFile(destination, m_testFile);
            checkWrite(fout);
        } finally {
            fout.close();
        }
        deleteFile(destination);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void ag() throws java.lang.Exception {
        final java.io.File destination = newFile("copy7.txt");
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        byte[] in;
        try {
            in = org.apache.commons.io.IOUtils.toByteArray(fin);
        } finally {
            fin.close();
        }
        final java.io.FileWriter fout = new java.io.FileWriter(destination);
        try {
            org.apache.commons.io.CopyUtils.copy(in, fout);
            fout.flush();
            checkFile(destination, m_testFile);
            checkWrite(fout);
        } finally {
            fout.close();
        }
        deleteFile(destination);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void ah() throws java.lang.Exception {
        final java.io.File destination = newFile("copy6.txt");
        final java.io.FileReader fin = new java.io.FileReader(m_testFile);
        java.lang.String str;
        try {
            str = org.apache.commons.io.IOUtils.toString(fin);
        } finally {
            fin.close();
        }
        final java.io.FileWriter fout = new java.io.FileWriter(destination);
        try {
            org.apache.commons.io.CopyUtils.copy(str, fout);
            fout.flush();
            checkFile(destination, m_testFile);
            checkWrite(fout);
        } finally {
            fout.close();
        }
        deleteFile(destination);
    }

    public void v() throws java.io.IOException {
        java.io.CharArrayReader is = null;
        java.io.CharArrayWriter os = null;
        try {
            is = new java.io.CharArrayReader(carr);
            os = new java.io.CharArrayWriter();
            junit.framework.TestCase.assertEquals(200, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, 2000));
            final char[] oarr = os.toCharArray();
            junit.framework.TestCase.assertEquals(200, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(((char)(-1)), oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void w() throws java.io.IOException {
        java.io.CharArrayReader is = null;
        java.io.CharArrayWriter os = null;
        try {
            is = new java.io.CharArrayReader(carr);
            os = new java.io.CharArrayWriter();
            junit.framework.TestCase.assertEquals(200, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, -1));
            final char[] oarr = os.toCharArray();
            junit.framework.TestCase.assertEquals(200, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(((char)(-1)), oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void x() throws java.io.IOException {
        java.io.CharArrayReader is = null;
        java.io.CharArrayWriter os = null;
        try {
            is = new java.io.CharArrayReader(carr);
            os = new java.io.CharArrayWriter();
            junit.framework.TestCase.assertEquals(100, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, 100));
            final char[] oarr = os.toCharArray();
            junit.framework.TestCase.assertEquals(100, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(((char)(-1)), oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void y() throws java.io.IOException {
        java.io.CharArrayReader is = null;
        java.io.CharArrayWriter os = null;
        try {
            is = new java.io.CharArrayReader(carr);
            os = new java.io.CharArrayWriter();
            junit.framework.TestCase.assertEquals(100, org.apache.commons.io.IOUtils.copyLarge(is, os, 10, 100));
            final char[] oarr = os.toCharArray();
            junit.framework.TestCase.assertEquals(100, oarr.length);
            junit.framework.TestCase.assertEquals(11, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[69]);
            junit.framework.TestCase.assertEquals(((char)(-1)), oarr[70]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void z() throws java.io.IOException {
        java.io.CharArrayReader is = null;
        java.io.CharArrayWriter os = null;
        try {
            is = new java.io.CharArrayReader(carr);
            os = new java.io.CharArrayWriter();
            org.apache.commons.io.IOUtils.copyLarge(is, os, 1000, 100);
            junit.framework.TestCase.fail("Should have thrown EOFException");
        } catch (final java.io.EOFException eofe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void aa() throws java.io.IOException {
        java.io.ByteArrayInputStream is = null;
        java.io.ByteArrayOutputStream os = null;
        try {
            is = new java.io.ByteArrayInputStream(iarr);
            os = new java.io.ByteArrayOutputStream();
            junit.framework.TestCase.assertEquals(200, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, 2000));
            final byte[] oarr = os.toByteArray();
            junit.framework.TestCase.assertEquals(200, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(-1, oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void ab() throws java.io.IOException {
        java.io.ByteArrayInputStream is = null;
        java.io.ByteArrayOutputStream os = null;
        try {
            is = new java.io.ByteArrayInputStream(iarr);
            os = new java.io.ByteArrayOutputStream();
            junit.framework.TestCase.assertEquals(200, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, -1));
            final byte[] oarr = os.toByteArray();
            junit.framework.TestCase.assertEquals(200, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(-1, oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void ac() throws java.io.IOException {
        java.io.ByteArrayInputStream is = null;
        java.io.ByteArrayOutputStream os = null;
        try {
            is = new java.io.ByteArrayInputStream(iarr);
            os = new java.io.ByteArrayOutputStream();
            junit.framework.TestCase.assertEquals(100, org.apache.commons.io.IOUtils.copyLarge(is, os, 0, 100));
            final byte[] oarr = os.toByteArray();
            junit.framework.TestCase.assertEquals(100, oarr.length);
            junit.framework.TestCase.assertEquals(1, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[79]);
            junit.framework.TestCase.assertEquals(-1, oarr[80]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void ad() throws java.io.IOException {
        java.io.ByteArrayInputStream is = null;
        java.io.ByteArrayOutputStream os = null;
        try {
            is = new java.io.ByteArrayInputStream(iarr);
            os = new java.io.ByteArrayOutputStream();
            junit.framework.TestCase.assertEquals(100, org.apache.commons.io.IOUtils.copyLarge(is, os, 10, 100));
            final byte[] oarr = os.toByteArray();
            junit.framework.TestCase.assertEquals(100, oarr.length);
            junit.framework.TestCase.assertEquals(11, oarr[1]);
            junit.framework.TestCase.assertEquals(79, oarr[69]);
            junit.framework.TestCase.assertEquals(-1, oarr[70]);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void ae() throws java.io.IOException {
        java.io.ByteArrayInputStream is = null;
        java.io.ByteArrayOutputStream os = null;
        try {
            is = new java.io.ByteArrayInputStream(iarr);
            os = new java.io.ByteArrayOutputStream();
            org.apache.commons.io.IOUtils.copyLarge(is, os, 1000, 100);
            junit.framework.TestCase.fail("Should have thrown EOFException");
        } catch (final java.io.EOFException eofe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(is);
            org.apache.commons.io.IOUtils.closeQuietly(os);
        }
    }

    public void ar() throws java.lang.Exception {
        final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(FILE_SIZE);
        final java.io.FileInputStream fileInputStream = new java.io.FileInputStream(m_testFile);
        final java.nio.channels.FileChannel input = fileInputStream.getChannel();
        try {
            junit.framework.TestCase.assertEquals(FILE_SIZE, org.apache.commons.io.IOUtils.read(input, buffer));
            junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOUtils.read(input, buffer));
            junit.framework.TestCase.assertEquals(0, buffer.remaining());
            junit.framework.TestCase.assertEquals(0, input.read(buffer));
            buffer.clear();
            try {
                org.apache.commons.io.IOUtils.readFully(input, buffer);
                junit.framework.TestCase.fail("Should have failed with EOFxception");
            } catch (final java.io.EOFException expected) {
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(input, fileInputStream);
        }
    }

    public void ai() throws java.lang.Exception {
        final int size = 1027;
        final byte[] buffer = new byte[size];
        final java.io.InputStream input = new java.io.ByteArrayInputStream(new byte[size]);
        try {
            org.apache.commons.io.IOUtils.readFully(input, buffer, 0, -1);
            junit.framework.TestCase.fail("Should have failed with IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, 0);
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, (size - 1));
        try {
            org.apache.commons.io.IOUtils.readFully(input, buffer, 0, 2);
            junit.framework.TestCase.fail("Should have failed with EOFxception");
        } catch (final java.io.EOFException expected) {
        }
        org.apache.commons.io.IOUtils.closeQuietly(input);
    }

    public void ak() throws java.lang.Exception {
        final byte[] bytes = "abcd1234".getBytes("UTF-8");
        final java.io.ByteArrayInputStream stream = new java.io.ByteArrayInputStream(bytes);
        final byte[] result = org.apache.commons.io.IOUtils.readFully(stream, bytes.length);
        org.apache.commons.io.IOUtils.closeQuietly(stream);
        assertEqualContent(result, bytes);
    }

    public void aj() throws java.lang.Exception {
        final byte[] bytes = "abcd1234".getBytes("UTF-8");
        final java.io.ByteArrayInputStream stream = new java.io.ByteArrayInputStream(bytes);
        final byte[] buffer = "wx00000000".getBytes("UTF-8");
        org.apache.commons.io.IOUtils.readFully(stream, buffer, 2, 8);
        junit.framework.TestCase.assertEquals("wxabcd1234", new java.lang.String(buffer , 0 , buffer.length , "UTF-8"));
        org.apache.commons.io.IOUtils.closeQuietly(stream);
    }

    public void al() throws java.lang.Exception {
        final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(FILE_SIZE);
        final java.io.FileInputStream fileInputStream = new java.io.FileInputStream(m_testFile);
        final java.nio.channels.FileChannel input = fileInputStream.getChannel();
        try {
            org.apache.commons.io.IOUtils.readFully(input, buffer);
            junit.framework.TestCase.assertEquals(FILE_SIZE, buffer.position());
            junit.framework.TestCase.assertEquals(0, buffer.remaining());
            junit.framework.TestCase.assertEquals(0, input.read(buffer));
            org.apache.commons.io.IOUtils.readFully(input, buffer);
            junit.framework.TestCase.assertEquals(FILE_SIZE, buffer.position());
            junit.framework.TestCase.assertEquals(0, buffer.remaining());
            junit.framework.TestCase.assertEquals(0, input.read(buffer));
            org.apache.commons.io.IOUtils.readFully(input, buffer);
            buffer.clear();
            try {
                org.apache.commons.io.IOUtils.readFully(input, buffer);
                junit.framework.TestCase.fail("Should have failed with EOFxception");
            } catch (final java.io.EOFException expected) {
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(input, fileInputStream);
        }
    }

    public void am() throws java.lang.Exception {
        final int size = 1027;
        final char[] buffer = new char[size];
        final java.io.Reader input = new java.io.CharArrayReader(new char[size]);
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, 0);
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, (size - 3));
        try {
            org.apache.commons.io.IOUtils.readFully(input, buffer, 0, -1);
            junit.framework.TestCase.fail("Should have failed with IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.IOUtils.readFully(input, buffer, 0, 5);
            junit.framework.TestCase.fail("Should have failed with EOFException");
        } catch (final java.io.EOFException expected) {
        }
        org.apache.commons.io.IOUtils.closeQuietly(input);
    }

    public void an() throws java.lang.Exception {
        final java.io.Reader reader = new java.io.StringReader("abcd1234");
        final char[] buffer = "wx00000000".toCharArray();
        org.apache.commons.io.IOUtils.readFully(reader, buffer, 2, 8);
        junit.framework.TestCase.assertEquals("wxabcd1234", new java.lang.String(buffer));
        org.apache.commons.io.IOUtils.closeQuietly(reader);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void ao() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        java.io.InputStream in = null;
        try {
            final java.lang.String[] data = new java.lang.String[]{ "hello" , "world" , "" , "this is" , "some text" };
            createLineBasedFile(file, data);
            in = new java.io.FileInputStream(file);
            final java.util.List<java.lang.String> lines = org.apache.commons.io.IOUtils.readLines(in);
            junit.framework.TestCase.assertEquals(java.util.Arrays.asList(data), lines);
            junit.framework.TestCase.assertEquals(-1, in.read());
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            deleteFile(file);
        }
    }

    public void ap() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        java.io.InputStream in = null;
        try {
            final java.lang.String[] data = new java.lang.String[]{ "hello" , "/u1234" , "" , "this is" , "some text" };
            createLineBasedFile(file, data);
            in = new java.io.FileInputStream(file);
            final java.util.List<java.lang.String> lines = org.apache.commons.io.IOUtils.readLines(in, "UTF-8");
            junit.framework.TestCase.assertEquals(java.util.Arrays.asList(data), lines);
            junit.framework.TestCase.assertEquals(-1, in.read());
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            deleteFile(file);
        }
    }

    public void aq() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        java.io.Reader in = null;
        try {
            final java.lang.String[] data = new java.lang.String[]{ "hello" , "/u1234" , "" , "this is" , "some text" };
            createLineBasedFile(file, data);
            in = new java.io.InputStreamReader(new java.io.FileInputStream(file));
            final java.util.List<java.lang.String> lines = org.apache.commons.io.IOUtils.readLines(in);
            junit.framework.TestCase.assertEquals(java.util.Arrays.asList(data), lines);
            junit.framework.TestCase.assertEquals(-1, in.read());
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            deleteFile(file);
        }
    }

    public void av() throws java.lang.Exception {
        final java.io.FileReader in = new java.io.FileReader(m_testFile);
        try {
            junit.framework.TestCase.assertEquals(((FILE_SIZE) - 10), org.apache.commons.io.IOUtils.skip(in, ((FILE_SIZE) - 10)));
            junit.framework.TestCase.assertEquals(10, org.apache.commons.io.IOUtils.skip(in, 20));
            junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOUtils.skip(in, 10));
        } finally {
            in.close();
        }
    }

    public void aw() throws java.lang.Exception {
        final java.io.InputStream in = new java.io.FileInputStream(m_testFile);
        try {
            junit.framework.TestCase.assertEquals(((FILE_SIZE) - 10), org.apache.commons.io.IOUtils.skip(in, ((FILE_SIZE) - 10)));
            junit.framework.TestCase.assertEquals(10, org.apache.commons.io.IOUtils.skip(in, 20));
            junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOUtils.skip(in, 10));
        } finally {
            in.close();
        }
    }

    public void ax() throws java.lang.Exception {
        final java.io.FileInputStream fileInputStream = new java.io.FileInputStream(m_testFile);
        final java.nio.channels.FileChannel fileChannel = fileInputStream.getChannel();
        try {
            junit.framework.TestCase.assertEquals(((FILE_SIZE) - 10), org.apache.commons.io.IOUtils.skip(fileChannel, ((FILE_SIZE) - 10)));
            junit.framework.TestCase.assertEquals(10, org.apache.commons.io.IOUtils.skip(fileChannel, 20));
            junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOUtils.skip(fileChannel, 10));
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(fileChannel, fileInputStream);
        }
    }

    public void as() throws java.lang.Exception {
        final int size = 1027;
        final java.io.InputStream input = new java.io.ByteArrayInputStream(new byte[size]);
        try {
            org.apache.commons.io.IOUtils.skipFully(input, -1);
            junit.framework.TestCase.fail("Should have failed with IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        org.apache.commons.io.IOUtils.skipFully(input, 0);
        org.apache.commons.io.IOUtils.skipFully(input, (size - 1));
        try {
            org.apache.commons.io.IOUtils.skipFully(input, 2);
            junit.framework.TestCase.fail("Should have failed with IOException");
        } catch (final java.io.IOException expected) {
        }
        org.apache.commons.io.IOUtils.closeQuietly(input);
    }

    public void at() throws java.lang.Exception {
        final java.io.FileInputStream fileInputStream = new java.io.FileInputStream(m_testFile);
        final java.nio.channels.FileChannel fileChannel = fileInputStream.getChannel();
        try {
            try {
                org.apache.commons.io.IOUtils.skipFully(fileChannel, -1);
                junit.framework.TestCase.fail("Should have failed with IllegalArgumentException");
            } catch (final java.lang.IllegalArgumentException expected) {
            }
            org.apache.commons.io.IOUtils.skipFully(fileChannel, 0);
            org.apache.commons.io.IOUtils.skipFully(fileChannel, ((FILE_SIZE) - 1));
            try {
                org.apache.commons.io.IOUtils.skipFully(fileChannel, 2);
                junit.framework.TestCase.fail("Should have failed with IOException");
            } catch (final java.io.IOException expected) {
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(fileChannel, fileInputStream);
        }
    }

    public void au() throws java.lang.Exception {
        final int size = 1027;
        final java.io.Reader input = new java.io.CharArrayReader(new char[size]);
        org.apache.commons.io.IOUtils.skipFully(input, 0);
        org.apache.commons.io.IOUtils.skipFully(input, (size - 3));
        try {
            org.apache.commons.io.IOUtils.skipFully(input, -1);
            junit.framework.TestCase.fail("Should have failed with IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.IOUtils.skipFully(input, 5);
            junit.framework.TestCase.fail("Should have failed with IOException");
        } catch (final java.io.IOException expected) {
        }
        org.apache.commons.io.IOUtils.closeQuietly(input);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void ay() throws java.lang.Exception {
        final java.io.File destination = newFile("copy5.txt");
        final java.io.FileReader fin = new java.io.FileReader(m_testFile);
        java.lang.String str;
        try {
            str = org.apache.commons.io.IOUtils.toString(fin);
        } finally {
            fin.close();
        }
        final java.io.FileOutputStream fout = new java.io.FileOutputStream(destination);
        try {
            org.apache.commons.io.CopyUtils.copy(str, fout);
            checkFile(destination, m_testFile);
            checkWrite(fout);
        } finally {
            fout.close();
        }
        deleteFile(destination);
    }

    public void ba() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final java.io.InputStream in = org.apache.commons.io.IOUtils.toBufferedInputStream(fin);
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(in);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all bytes were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void az() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final java.io.InputStream in = org.apache.commons.io.IOUtils.toBufferedInputStream(fin, 2048);
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(in);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all bytes were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void bb() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(fin);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all bytes were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void bc() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            org.apache.commons.io.IOUtils.toByteArray(fin, -1);
            junit.framework.TestCase.fail("IllegalArgumentException excepted");
        } catch (final java.lang.IllegalArgumentException exc) {
            junit.framework.TestCase.assertTrue("Exception message does not start with \"Size must be equal or greater than zero\"", exc.getMessage().startsWith("Size must be equal or greater than zero"));
        } finally {
            fin.close();
        }
    }

    public void bd() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(fin, m_testFile.length());
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all bytes were read", 0, fin.available());
            junit.framework.TestCase.assertEquals(((("Wrong output size: out.length=" + (out.length)) + "!=") + (FILE_SIZE)), FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void be() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            org.apache.commons.io.IOUtils.toByteArray(fin, ((m_testFile.length()) + 1));
            junit.framework.TestCase.fail("IOException excepted");
        } catch (final java.io.IOException exc) {
            junit.framework.TestCase.assertTrue("Exception message does not start with \"Unexpected readed size\"", exc.getMessage().startsWith("Unexpected readed size"));
        } finally {
            fin.close();
        }
    }

    public void bf() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            org.apache.commons.io.IOUtils.toByteArray(fin, (((long)(java.lang.Integer.MAX_VALUE)) + 1));
            junit.framework.TestCase.fail("IOException excepted");
        } catch (final java.lang.IllegalArgumentException exc) {
            junit.framework.TestCase.assertTrue("Exception message does not start with \"Size cannot be greater than Integer max value\"", exc.getMessage().startsWith("Size cannot be greater than Integer max value"));
        } finally {
            fin.close();
        }
    }

    public void bg() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(fin, 0);
            junit.framework.TestCase.assertNotNull("Out cannot be null", out);
            junit.framework.TestCase.assertEquals("Out length must be 0", 0, out.length);
        } finally {
            fin.close();
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bh() throws java.io.IOException {
        final java.lang.String charsetName = "UTF-8";
        final byte[] expecteds = charsetName.getBytes(charsetName);
        byte[] actuals = org.apache.commons.io.IOUtils.toByteArray(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(expecteds)));
        org.junit.Assert.assertArrayEquals(expecteds, actuals);
        actuals = org.apache.commons.io.IOUtils.toByteArray(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(expecteds)), charsetName);
        org.junit.Assert.assertArrayEquals(expecteds, actuals);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bi() throws java.lang.Exception {
        final java.io.FileReader fin = new java.io.FileReader(m_testFile);
        try {
            final java.lang.String str = org.apache.commons.io.IOUtils.toString(fin);
            final byte[] out = org.apache.commons.io.IOUtils.toByteArray(str);
            assertEqualContent(str.getBytes(), out);
        } finally {
            fin.close();
        }
    }

    public void bj() throws java.lang.Exception {
        final java.net.URI url = m_testFile.toURI();
        final byte[] actual = org.apache.commons.io.IOUtils.toByteArray(url);
        org.junit.Assert.assertEquals(FILE_SIZE, actual.length);
    }

    public void bk() throws java.lang.Exception {
        final java.net.URL url = m_testFile.toURI().toURL();
        final byte[] actual = org.apache.commons.io.IOUtils.toByteArray(url);
        org.junit.Assert.assertEquals(FILE_SIZE, actual.length);
    }

    public void bl() throws java.lang.Exception {
        final java.net.URLConnection urlConn = m_testFile.toURI().toURL().openConnection();
        byte[] actual;
        try {
            actual = org.apache.commons.io.IOUtils.toByteArray(urlConn);
        } finally {
            org.apache.commons.io.IOUtils.close(urlConn);
        }
        org.junit.Assert.assertEquals(FILE_SIZE, actual.length);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bm() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final char[] out = org.apache.commons.io.IOUtils.toCharArray(fin);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all chars were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void bn() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final char[] out = org.apache.commons.io.IOUtils.toCharArray(fin, "UTF-8");
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all chars were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fin.close();
        }
    }

    public void bo() throws java.lang.Exception {
        final java.io.FileReader fr = new java.io.FileReader(m_testFile);
        try {
            final char[] out = org.apache.commons.io.IOUtils.toCharArray(fr);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length);
            assertEqualContent(out, m_testFile);
        } finally {
            fr.close();
        }
    }

    @java.lang.SuppressWarnings(value = "javadoc")
    public void bp() throws java.lang.Exception {
        final java.lang.CharSequence csq = new java.lang.StringBuilder("Abc123Xyz!");
        @java.lang.SuppressWarnings(value = "deprecation")
        java.io.InputStream inStream = org.apache.commons.io.IOUtils.toInputStream(csq);
        byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(csq.toString().getBytes(), bytes);
        inStream = org.apache.commons.io.IOUtils.toInputStream(csq, ((java.lang.String)(null)));
        bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(csq.toString().getBytes(), bytes);
        inStream = org.apache.commons.io.IOUtils.toInputStream(csq, "UTF-8");
        bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(csq.toString().getBytes("UTF-8"), bytes);
    }

    @java.lang.SuppressWarnings(value = "javadoc")
    public void bq() throws java.lang.Exception {
        final java.lang.String str = "Abc123Xyz!";
        @java.lang.SuppressWarnings(value = "deprecation")
        java.io.InputStream inStream = org.apache.commons.io.IOUtils.toInputStream(str);
        byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(str.getBytes(), bytes);
        inStream = org.apache.commons.io.IOUtils.toInputStream(str, ((java.lang.String)(null)));
        bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(str.getBytes(), bytes);
        inStream = org.apache.commons.io.IOUtils.toInputStream(str, "UTF-8");
        bytes = org.apache.commons.io.IOUtils.toByteArray(inStream);
        assertEqualContent(str.getBytes("UTF-8"), bytes);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void br() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final byte[] in = org.apache.commons.io.IOUtils.toByteArray(fin);
            final java.lang.String str = org.apache.commons.io.IOUtils.toString(in);
            assertEqualContent(in, str.getBytes());
        } finally {
            fin.close();
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bs() throws java.lang.Exception {
        final java.io.FileInputStream fin = new java.io.FileInputStream(m_testFile);
        try {
            final java.lang.String out = org.apache.commons.io.IOUtils.toString(fin);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Not all bytes were read", 0, fin.available());
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
        } finally {
            fin.close();
        }
    }

    public void bt() throws java.lang.Exception {
        final java.io.FileReader fin = new java.io.FileReader(m_testFile);
        try {
            final java.lang.String out = org.apache.commons.io.IOUtils.toString(fin);
            junit.framework.TestCase.assertNotNull(out);
            junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
        } finally {
            fin.close();
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bu() throws java.lang.Exception {
        final java.net.URI url = m_testFile.toURI();
        final java.lang.String out = org.apache.commons.io.IOUtils.toString(url);
        junit.framework.TestCase.assertNotNull(out);
        junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
    }

    private void testGetPath_with_nullbyte(final java.lang.String encoding) throws java.lang.Exception {
        final java.net.URI uri = m_testFile.toURI();
        final java.lang.String out = org.apache.commons.io.IOUtils.toString(uri, encoding);
        junit.framework.TestCase.assertNotNull(out);
        junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
    }

    public void bv() throws java.lang.Exception {
        testToString_URI("US-ASCII");
    }

    public void bw() throws java.lang.Exception {
        testToString_URI(null);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void bx() throws java.lang.Exception {
        final java.net.URL url = m_testFile.toURI().toURL();
        final java.lang.String out = org.apache.commons.io.IOUtils.toString(url);
        junit.framework.TestCase.assertNotNull(out);
        junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
    }

    private void aa(final java.lang.String encoding) throws java.lang.Exception {
        final java.net.URL url = m_testFile.toURI().toURL();
        final java.lang.String out = org.apache.commons.io.IOUtils.toString(url, encoding);
        junit.framework.TestCase.assertNotNull(out);
        junit.framework.TestCase.assertEquals("Wrong output size", FILE_SIZE, out.length());
    }

    public void by() throws java.lang.Exception {
        testToString_URL("US-ASCII");
    }

    public void bz() throws java.lang.Exception {
        testToString_URL(null);
    }

    public void a() {
        try {
            org.apache.commons.io.IOUtils.buffer(((java.io.InputStream)(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (java.lang.NullPointerException npe) {
        }
        try {
            org.apache.commons.io.IOUtils.buffer(((java.io.OutputStream)(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (java.lang.NullPointerException npe) {
        }
        try {
            org.apache.commons.io.IOUtils.buffer(((java.io.Reader)(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (java.lang.NullPointerException npe) {
        }
        try {
            org.apache.commons.io.IOUtils.buffer(((java.io.Writer)(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (java.lang.NullPointerException npe) {
        }
    }

    public void testCopyDirectoryToItself() {
        java.io.InputStream is = new java.io.InputStream() {
            @java.lang.Override
            public int read() throws java.io.IOException {
                return 0;
            }
        };
        final java.io.BufferedInputStream bis = org.apache.commons.io.IOUtils.buffer(is);
        junit.framework.TestCase.assertNotSame(is, bis);
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis));
    }

    public void testGetPath_with_nullbyte() {
        java.io.InputStream is = new java.io.InputStream() {
            @java.lang.Override
            public int read() throws java.io.IOException {
                return 0;
            }
        };
        final java.io.BufferedInputStream bis = org.apache.commons.io.IOUtils.buffer(is, 2048);
        junit.framework.TestCase.assertNotSame(is, bis);
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis));
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis, 1024));
    }

    public void b() {
        java.io.OutputStream is = new java.io.OutputStream() {
            @java.lang.Override
            public void write(int b) throws java.io.IOException {
            }
        };
        final java.io.BufferedOutputStream bis = org.apache.commons.io.IOUtils.buffer(is);
        junit.framework.TestCase.assertNotSame(is, bis);
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis));
    }

    public void c() {
        java.io.OutputStream os = new java.io.OutputStream() {
            @java.lang.Override
            public void write(int b) throws java.io.IOException {
            }
        };
        final java.io.BufferedOutputStream bos = org.apache.commons.io.IOUtils.buffer(os, 2048);
        junit.framework.TestCase.assertNotSame(os, bos);
        junit.framework.TestCase.assertSame(bos, org.apache.commons.io.IOUtils.buffer(bos));
        junit.framework.TestCase.assertSame(bos, org.apache.commons.io.IOUtils.buffer(bos, 1024));
    }

    public void d() {
        java.io.Reader is = new java.io.Reader() {
            @java.lang.Override
            public int read(char[] cbuf, int off, int len) throws java.io.IOException {
                return 0;
            }

            @java.lang.Override
            public void close() throws java.io.IOException {
            }
        };
        final java.io.BufferedReader bis = org.apache.commons.io.IOUtils.buffer(is);
        junit.framework.TestCase.assertNotSame(is, bis);
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis));
    }

    public void e() {
        java.io.Reader r = new java.io.Reader() {
            @java.lang.Override
            public int read(char[] cbuf, int off, int len) throws java.io.IOException {
                return 0;
            }

            @java.lang.Override
            public void close() throws java.io.IOException {
            }
        };
        final java.io.BufferedReader br = org.apache.commons.io.IOUtils.buffer(r, 2048);
        junit.framework.TestCase.assertNotSame(r, br);
        junit.framework.TestCase.assertSame(br, org.apache.commons.io.IOUtils.buffer(br));
        junit.framework.TestCase.assertSame(br, org.apache.commons.io.IOUtils.buffer(br, 1024));
    }

    public void f() {
        java.io.Writer is = new java.io.Writer() {
            @java.lang.Override
            public void write(int b) throws java.io.IOException {
            }

            @java.lang.Override
            public void write(char[] cbuf, int off, int len) throws java.io.IOException {
            }

            @java.lang.Override
            public void flush() throws java.io.IOException {
            }

            @java.lang.Override
            public void close() throws java.io.IOException {
            }
        };
        final java.io.BufferedWriter bis = org.apache.commons.io.IOUtils.buffer(is);
        junit.framework.TestCase.assertNotSame(is, bis);
        junit.framework.TestCase.assertSame(bis, org.apache.commons.io.IOUtils.buffer(bis));
    }

    public void g() {
        java.io.Writer w = new java.io.Writer() {
            @java.lang.Override
            public void write(int b) throws java.io.IOException {
            }

            @java.lang.Override
            public void write(char[] cbuf, int off, int len) throws java.io.IOException {
            }

            @java.lang.Override
            public void flush() throws java.io.IOException {
            }

            @java.lang.Override
            public void close() throws java.io.IOException {
            }
        };
        final java.io.BufferedWriter bw = org.apache.commons.io.IOUtils.buffer(w, 2024);
        junit.framework.TestCase.assertNotSame(w, bw);
        junit.framework.TestCase.assertSame(bw, org.apache.commons.io.IOUtils.buffer(bw));
        junit.framework.TestCase.assertSame(bw, org.apache.commons.io.IOUtils.buffer(bw, 1024));
    }
}

