package org.apache.commons.io;


public class FileUtilsFileNewerTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int FILE1_SIZE = 1;

    private static final int FILE2_SIZE = (1024 * 4) + 1;

    private final java.io.File m_testFile1;

    private final java.io.File m_testFile2;

    public FileUtilsFileNewerTestCase(final java.lang.String name) {
        super(name);
        m_testFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1-test.txt");
        m_testFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file2-test.txt");
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
        createFile(m_testFile1, FILE1_SIZE);
        createFile(m_testFile2, FILE2_SIZE);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        m_testFile1.delete();
        m_testFile2.delete();
    }

    public void a() {
        if (!(m_testFile1.exists())) {
            throw new java.lang.IllegalStateException("The m_testFile1 should exist");
        } 
        final long fileLastModified = m_testFile1.lastModified();
        final long TWO_SECOND = 2000;
        testIsFileNewer("two second earlier is not newer", m_testFile1, (fileLastModified + TWO_SECOND), false);
        testIsFileNewer("same time is not newer", m_testFile1, fileLastModified, false);
        testIsFileNewer("two second later is newer", m_testFile1, (fileLastModified - TWO_SECOND), true);
    }

    public void b() {
        final java.io.File imaginaryFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "imaginaryFile");
        if (imaginaryFile.exists()) {
            throw new java.lang.IllegalStateException("The imaginary File exists");
        } 
        testIsFileNewer("imaginary file can be newer", imaginaryFile, m_testFile2.lastModified(), false);
    }

    protected void a(final java.lang.String description, final java.io.File file, final long time, final boolean wantedResult) {
        junit.framework.TestCase.assertEquals((description + " - time"), wantedResult, org.apache.commons.io.FileUtils.isFileNewer(file, time));
        junit.framework.TestCase.assertEquals((description + " - date"), wantedResult, org.apache.commons.io.FileUtils.isFileNewer(file, new java.util.Date(time)));
        final java.io.File temporaryFile = m_testFile2;
        temporaryFile.setLastModified(time);
        junit.framework.TestCase.assertEquals("The temporary file hasn\'t the right last modification date", time, temporaryFile.lastModified());
        junit.framework.TestCase.assertEquals((description + " - file"), wantedResult, org.apache.commons.io.FileUtils.isFileNewer(file, temporaryFile));
    }

    public void d() {
        try {
            org.apache.commons.io.FileUtils.isFileNewer(null, 0);
            junit.framework.TestCase.fail("File not specified");
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    public void c() {
        try {
            org.apache.commons.io.FileUtils.isFileNewer(m_testFile1, ((java.util.Date)(null)));
            junit.framework.TestCase.fail("Date not specified");
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    public void e() {
        try {
            org.apache.commons.io.FileUtils.isFileNewer(m_testFile1, ((java.io.File)(null)));
            junit.framework.TestCase.fail("Reference file not specified");
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }
}

