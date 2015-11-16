package org.apache.commons.io;


public class FileUtilsCleanDirectoryTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    final java.io.File top = getLocalTestDirectory();

    public FileUtilsCleanDirectoryTestCase(final java.lang.String name) {
        super(name);
    }

    private java.io.File testCopyDirectoryToItself() {
        return new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "list-files");
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        top.mkdirs();
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        chmod(top, 775, true);
        org.apache.commons.io.FileUtils.deleteDirectory(top);
    }

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(0, top.list().length);
        org.apache.commons.io.FileUtils.cleanDirectory(top);
        junit.framework.TestCase.assertEquals(0, top.list().length);
    }

    public void b() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.touch(new java.io.File(top , "regular"));
        org.apache.commons.io.FileUtils.touch(new java.io.File(top , ".hidden"));
        junit.framework.TestCase.assertEquals(2, top.list().length);
        org.apache.commons.io.FileUtils.cleanDirectory(top);
        junit.framework.TestCase.assertEquals(0, top.list().length);
    }

    public void a() throws java.lang.Exception {
        final java.io.File nested = new java.io.File(top , "nested");
        junit.framework.TestCase.assertTrue(nested.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(nested , "file"));
        junit.framework.TestCase.assertEquals(1, top.list().length);
        org.apache.commons.io.FileUtils.cleanDirectory(top);
        junit.framework.TestCase.assertEquals(0, top.list().length);
    }

    public void d() throws java.lang.Exception {
        if ((java.lang.System.getProperty("os.name").startsWith("Win")) || (!(chmod(top, 0, false)))) {
            return ;
        } 
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(top);
            junit.framework.TestCase.fail("expected IOException");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(("Failed to list contents of " + (top.getAbsolutePath())), e.getMessage());
        }
    }

    public void c() throws java.lang.Exception {
        final java.io.File file = new java.io.File(top , "restricted");
        org.apache.commons.io.FileUtils.touch(file);
        if ((java.lang.System.getProperty("os.name").startsWith("Win")) || (!(chmod(top, 500, false)))) {
            return ;
        } 
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(top);
            junit.framework.TestCase.fail("expected IOException");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertEquals(("Unable to delete file: " + (file.getAbsolutePath())), e.getMessage());
        }
    }

    private boolean testCopyDirectoryToItself(final java.io.File file, final int mode, final boolean recurse) throws java.lang.InterruptedException {
        final java.util.List<java.lang.String> args = new java.util.ArrayList<java.lang.String>();
        args.add("chmod");
        if (recurse) {
            args.add("-R");
        } 
        args.add(java.lang.Integer.toString(mode));
        args.add(file.getAbsolutePath());
        java.lang.Process proc;
        try {
            proc = java.lang.Runtime.getRuntime().exec(args.toArray(new java.lang.String[args.size()]));
        } catch (final java.io.IOException e) {
            return false;
        }
        final int result = proc.waitFor();
        return result == 0;
    }
}

