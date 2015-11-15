package org.apache.commons.io.testtools;


public abstract class FileBasedTestCase extends junit.framework.TestCase {
    private static volatile java.io.File testDir;

    public FileBasedTestCase(final java.lang.String name) {
        super(name);
    }

    public static java.io.File a() {
        if ((org.apache.commons.io.testtools.FileBasedTestCase.testDir) == null) {
            org.apache.commons.io.testtools.FileBasedTestCase.testDir = new java.io.File("test/io/").getAbsoluteFile();
        } 
        org.apache.commons.io.testtools.FileBasedTestCase.testDir.mkdirs();
        return org.apache.commons.io.testtools.FileBasedTestCase.testDir;
    }

    protected void a(final java.io.File file, final long size) throws java.io.IOException {
        if (!(file.getParentFile().exists())) {
            throw new java.io.IOException((("Cannot create file " + file) + " as the parent directory does not exist"));
        } 
        final java.io.BufferedOutputStream output = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
        try {
            generateTestData(output, size);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(output);
        }
    }

    protected byte[] a(final long size) {
        try {
            final org.apache.commons.io.output.ByteArrayOutputStream baout = new org.apache.commons.io.output.ByteArrayOutputStream();
            generateTestData(baout, size);
            return baout.toByteArray();
        } catch (final java.io.IOException ioe) {
            throw new java.lang.RuntimeException(("This should never happen: " + (ioe.getMessage())));
        }
    }

    protected void a(final java.io.OutputStream out, final long size) throws java.io.IOException {
        for (int i = 0 ; i < size ; i++) {
            out.write(((byte)((i % 127) + 1)));
        }
    }

    protected void a(final java.io.File file, final java.lang.String[] data) throws java.io.IOException {
        if (((file.getParentFile()) != null) && (!(file.getParentFile().exists()))) {
            throw new java.io.IOException((("Cannot create file " + file) + " as the parent directory does not exist"));
        } 
        final java.io.PrintWriter output = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file) , "UTF-8"));
        try {
            for (final java.lang.String element : data) {
                output.println(element);
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(output);
        }
    }

    protected java.io.File a(final java.lang.String filename) throws java.io.IOException {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , filename);
        if (destination.exists()) {
            org.apache.commons.io.FileUtils.forceDelete(destination);
        } 
        return destination;
    }

    protected void b(final java.io.File file, final java.io.File referenceFile) throws java.lang.Exception {
        junit.framework.TestCase.assertTrue("Check existence of output file", file.exists());
        assertEqualContent(referenceFile, file);
    }

    private void a(final java.io.File f0, final java.io.File f1) throws java.io.IOException {
        final java.io.InputStream is0 = new java.io.FileInputStream(f0);
        try {
            final java.io.InputStream is1 = new java.io.FileInputStream(f1);
            try {
                final byte[] buf0 = new byte[1024];
                final byte[] buf1 = new byte[1024];
                int n0 = 0;
                int n1 = 0;
                while ((-1) != n0) {
                    n0 = is0.read(buf0);
                    n1 = is1.read(buf1);
                    junit.framework.TestCase.assertTrue((((((((("The files " + f0) + " and ") + f1) + " have differing number of bytes available (") + n0) + " vs ") + n1) + ")"), (n0 == n1));
                    junit.framework.TestCase.assertTrue((((("The files " + f0) + " and ") + f1) + " have different content"), java.util.Arrays.equals(buf0, buf1));
                }
            } finally {
                is1.close();
            }
        } finally {
            is0.close();
        }
    }

    protected void a(final byte[] b0, final java.io.File file) throws java.io.IOException {
        final java.io.InputStream is = new java.io.FileInputStream(file);
        int count = 0;
        int numRead = 0;
        final byte[] b1 = new byte[b0.length];
        try {
            while ((count < (b0.length)) && (numRead >= 0)) {
                numRead = is.read(b1, count, b0.length);
                count += numRead;
            }
            junit.framework.TestCase.assertEquals("Different number of bytes: ", b0.length, count);
            for (int i = 0 ; i < count ; i++) {
                junit.framework.TestCase.assertEquals((("byte " + i) + " differs"), b0[i], b1[i]);
            }
        } finally {
            is.close();
        }
    }

    protected void a(final char[] c0, final java.io.File file) throws java.io.IOException {
        final java.io.Reader ir = new java.io.FileReader(file);
        int count = 0;
        int numRead = 0;
        final char[] c1 = new char[c0.length];
        try {
            while ((count < (c0.length)) && (numRead >= 0)) {
                numRead = ir.read(c1, count, c0.length);
                count += numRead;
            }
            junit.framework.TestCase.assertEquals("Different number of chars: ", c0.length, count);
            for (int i = 0 ; i < count ; i++) {
                junit.framework.TestCase.assertEquals((("char " + i) + " differs"), c0[i], c1[i]);
            }
        } finally {
            ir.close();
        }
    }

    protected void a(final java.io.OutputStream output) throws java.lang.Exception {
        try {
            new java.io.PrintStream(output).write(0);
        } catch (final java.lang.Throwable t) {
            throw new junit.framework.AssertionFailedError((("The copy() method closed the stream " + "when it shouldn\'t have. ") + (t.getMessage())));
        }
    }

    protected void a(final java.io.Writer output) throws java.lang.Exception {
        try {
            new java.io.PrintWriter(output).write('a');
        } catch (final java.lang.Throwable t) {
            throw new junit.framework.AssertionFailedError((("The copy() method closed the stream " + "when it shouldn\'t have. ") + (t.getMessage())));
        }
    }

    protected void a(final java.io.File file) throws java.lang.Exception {
        if (file.exists()) {
            junit.framework.TestCase.assertTrue(("Couldn\'t delete file: " + file), file.delete());
        } 
    }
}

