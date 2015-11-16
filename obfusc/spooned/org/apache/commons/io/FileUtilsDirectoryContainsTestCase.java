package org.apache.commons.io;


public class FileUtilsDirectoryContainsTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private java.io.File directory1;

    private java.io.File directory2;

    private java.io.File directory3;

    private java.io.File file1;

    private java.io.File file1ByRelativeDirectory2;

    private java.io.File file2;

    private java.io.File file2ByRelativeDirectory1;

    private java.io.File file3;

    final java.io.File top = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();

    public FileUtilsDirectoryContainsTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        top.mkdirs();
        directory1 = new java.io.File(top , "directory1");
        directory2 = new java.io.File(top , "directory2");
        directory3 = new java.io.File(directory2 , "directory3");
        directory1.mkdir();
        directory2.mkdir();
        directory3.mkdir();
        file1 = new java.io.File(directory1 , "file1");
        file2 = new java.io.File(directory2 , "file2");
        file3 = new java.io.File(top , "file3");
        file1ByRelativeDirectory2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "directory2/../directory1/file1");
        file2ByRelativeDirectory1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "directory1/../directory2/file2");
        org.apache.commons.io.FileUtils.touch(file1);
        org.apache.commons.io.FileUtils.touch(file2);
        org.apache.commons.io.FileUtils.touch(file3);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(top);
    }

    @org.junit.Test
    public void a() throws java.io.IOException {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(directory1, file1ByRelativeDirectory2));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(directory2, file2ByRelativeDirectory1));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory1, file2ByRelativeDirectory1));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory2, file1ByRelativeDirectory2));
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(top, directory1));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(top, directory2));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(top, directory3));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(directory2, directory3));
    }

    @org.junit.Test
    public void c() throws java.io.IOException {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(directory1, file1));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(directory2, file2));
    }

    @org.junit.Test
    public void d() throws java.io.IOException {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory1, file2));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory2, file1));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory1, file3));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory2, file3));
    }

    @org.junit.Test
    public void e() throws java.io.IOException {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory1, top));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory2, top));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory3, top));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory3, directory2));
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        final java.io.File dir = new java.io.File("DOESNOTEXIST");
        junit.framework.TestCase.assertFalse(dir.exists());
        try {
            junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(dir, file1));
            junit.framework.TestCase.fail(("Expected " + (java.lang.IllegalArgumentException.class.getName())));
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    @org.junit.Test
    public void j() throws java.io.IOException {
        try {
            junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(file1, file1));
            junit.framework.TestCase.fail(("Expected " + (java.lang.IllegalArgumentException.class.getName())));
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    @org.junit.Test
    public void i() throws java.io.IOException {
        java.io.File fooFile = new java.io.File(directory1.getParent() , "directory1.txt");
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(directory1, fooFile));
    }

    @org.junit.Test
    public void g() throws java.io.IOException {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(top, null));
        final java.io.File file = new java.io.File("DOESNOTEXIST");
        junit.framework.TestCase.assertFalse(file.exists());
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.directoryContains(top, file));
    }

    @org.junit.Test
    public void h() throws java.io.IOException {
        final java.io.File file = new java.io.File(top , "DOESNOTEXIST");
        junit.framework.TestCase.assertTrue("Check directory exists", top.exists());
        junit.framework.TestCase.assertFalse("Check file does not exist", file.exists());
        junit.framework.TestCase.assertFalse("Direcory does not contain unrealized file", org.apache.commons.io.FileUtils.directoryContains(top, file));
    }

    @org.junit.Test
    public void k() throws java.io.IOException {
        final java.io.File dir = new java.io.File("DOESNOTEXIST");
        final java.io.File file = new java.io.File(dir , "DOESNOTEXIST2");
        junit.framework.TestCase.assertFalse(dir.exists());
        junit.framework.TestCase.assertFalse(file.exists());
        try {
            junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.directoryContains(dir, file));
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }
}

