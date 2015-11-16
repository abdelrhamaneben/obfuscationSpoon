package org.apache.commons.io;


public class FileDeleteStrategyTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public FileDeleteStrategyTestCase(final java.lang.String name) {
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

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        final java.io.File baseDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(baseDir , "test");
        junit.framework.TestCase.assertTrue(subDir.mkdir());
        final java.io.File subFile = new java.io.File(subDir , "a.txt");
        createFile(subFile, 16);
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertTrue(subFile.exists());
        try {
            org.apache.commons.io.FileDeleteStrategy.NORMAL.delete(subDir);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertTrue(subFile.exists());
        org.apache.commons.io.FileDeleteStrategy.NORMAL.delete(subFile);
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertFalse(subFile.exists());
        org.apache.commons.io.FileDeleteStrategy.NORMAL.delete(subDir);
        junit.framework.TestCase.assertFalse(subDir.exists());
        org.apache.commons.io.FileDeleteStrategy.NORMAL.delete(subDir);
        junit.framework.TestCase.assertFalse(subDir.exists());
    }

    public void b() throws java.lang.Exception {
        final java.io.File baseDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(baseDir , "test");
        junit.framework.TestCase.assertTrue(subDir.mkdir());
        final java.io.File subFile = new java.io.File(subDir , "a.txt");
        createFile(subFile, 16);
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertTrue(subFile.exists());
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileDeleteStrategy.NORMAL.deleteQuietly(subDir));
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertTrue(subFile.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileDeleteStrategy.NORMAL.deleteQuietly(subFile));
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertFalse(subFile.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileDeleteStrategy.NORMAL.deleteQuietly(subDir));
        junit.framework.TestCase.assertFalse(subDir.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileDeleteStrategy.NORMAL.deleteQuietly(subDir));
        junit.framework.TestCase.assertFalse(subDir.exists());
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final java.io.File baseDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(baseDir , "test");
        junit.framework.TestCase.assertTrue(subDir.mkdir());
        final java.io.File subFile = new java.io.File(subDir , "a.txt");
        createFile(subFile, 16);
        junit.framework.TestCase.assertTrue(subDir.exists());
        junit.framework.TestCase.assertTrue(subFile.exists());
        org.apache.commons.io.FileDeleteStrategy.FORCE.delete(subDir);
        junit.framework.TestCase.assertFalse(subDir.exists());
        junit.framework.TestCase.assertFalse(subFile.exists());
        org.apache.commons.io.FileDeleteStrategy.FORCE.delete(subDir);
        junit.framework.TestCase.assertFalse(subDir.exists());
    }

    public void a() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileDeleteStrategy.NORMAL.delete(null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileDeleteStrategy.NORMAL.deleteQuietly(null));
    }

    public void c() {
        junit.framework.TestCase.assertEquals("FileDeleteStrategy[Normal]", org.apache.commons.io.FileDeleteStrategy.NORMAL.toString());
        junit.framework.TestCase.assertEquals("FileDeleteStrategy[Force]", org.apache.commons.io.FileDeleteStrategy.FORCE.toString());
    }
}

