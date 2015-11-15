package org.apache.commons.io;


public class FileUtilsCleanSymlinksTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    final java.io.File top = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();

    public FileUtilsCleanSymlinksTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        top.mkdirs();
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(top);
    }

    public void c() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File realOuter = new java.io.File(top , "realouter");
        junit.framework.TestCase.assertTrue(realOuter.mkdirs());
        final java.io.File realInner = new java.io.File(realOuter , "realinner");
        junit.framework.TestCase.assertTrue(realInner.mkdirs());
        final java.io.File realFile = new java.io.File(realInner , "file1");
        org.apache.commons.io.FileUtils.touch(realFile);
        junit.framework.TestCase.assertEquals(1, realInner.list().length);
        final java.io.File randomFile = new java.io.File(top , "randomfile");
        org.apache.commons.io.FileUtils.touch(randomFile);
        final java.io.File symlinkFile = new java.io.File(realInner , "fakeinner");
        setupSymlink(randomFile, symlinkFile);
        junit.framework.TestCase.assertEquals(2, realInner.list().length);
        org.apache.commons.io.FileUtils.cleanDirectory(realOuter);
        junit.framework.TestCase.assertEquals(0, realOuter.list().length);
        junit.framework.TestCase.assertTrue(randomFile.exists());
        junit.framework.TestCase.assertFalse(symlinkFile.exists());
    }

    public void a() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File realOuter = new java.io.File(top , "realouter");
        junit.framework.TestCase.assertTrue(realOuter.mkdirs());
        final java.io.File realInner = new java.io.File(realOuter , "realinner");
        junit.framework.TestCase.assertTrue(realInner.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(realInner , "file1"));
        junit.framework.TestCase.assertEquals(1, realInner.list().length);
        final java.io.File randomDirectory = new java.io.File(top , "randomDir");
        junit.framework.TestCase.assertTrue(randomDirectory.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(randomDirectory , "randomfile"));
        junit.framework.TestCase.assertEquals(1, randomDirectory.list().length);
        final java.io.File symlinkDirectory = new java.io.File(realOuter , "fakeinner");
        setupSymlink(randomDirectory, symlinkDirectory);
        junit.framework.TestCase.assertEquals(1, symlinkDirectory.list().length);
        org.apache.commons.io.FileUtils.cleanDirectory(realOuter);
        junit.framework.TestCase.assertEquals(0, realOuter.list().length);
        junit.framework.TestCase.assertEquals("Contents of sym link should not have been removed", 1, randomDirectory.list().length);
    }

    public void b() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File realParent = new java.io.File(top , "realparent");
        junit.framework.TestCase.assertTrue(realParent.mkdirs());
        final java.io.File realInner = new java.io.File(realParent , "realinner");
        junit.framework.TestCase.assertTrue(realInner.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(realInner , "file1"));
        junit.framework.TestCase.assertEquals(1, realInner.list().length);
        final java.io.File randomDirectory = new java.io.File(top , "randomDir");
        junit.framework.TestCase.assertTrue(randomDirectory.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(randomDirectory , "randomfile"));
        junit.framework.TestCase.assertEquals(1, randomDirectory.list().length);
        final java.io.File symlinkDirectory = new java.io.File(realParent , "fakeinner");
        setupSymlink(randomDirectory, symlinkDirectory);
        junit.framework.TestCase.assertEquals(1, symlinkDirectory.list().length);
        final java.io.File symlinkParentDirectory = new java.io.File(top , "fakeouter");
        setupSymlink(realParent, symlinkParentDirectory);
        org.apache.commons.io.FileUtils.cleanDirectory(symlinkParentDirectory);
        junit.framework.TestCase.assertEquals(0, symlinkParentDirectory.list().length);
        junit.framework.TestCase.assertEquals(0, realParent.list().length);
        junit.framework.TestCase.assertEquals("Contents of sym link should not have been removed", 1, randomDirectory.list().length);
    }

    public void h() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File randomDirectory = new java.io.File(top , "randomDir");
        junit.framework.TestCase.assertTrue(randomDirectory.mkdirs());
        org.apache.commons.io.FileUtils.touch(new java.io.File(randomDirectory , "randomfile"));
        junit.framework.TestCase.assertEquals(1, randomDirectory.list().length);
        final java.io.File symlinkDirectory = new java.io.File(top , "fakeDir");
        setupSymlink(randomDirectory, symlinkDirectory);
        org.apache.commons.io.FileUtils.cleanDirectory(symlinkDirectory);
        junit.framework.TestCase.assertEquals(0, symlinkDirectory.list().length);
        junit.framework.TestCase.assertEquals(0, randomDirectory.list().length);
    }

    public void f() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File randomDirectory = new java.io.File(top , "randomDir");
        junit.framework.TestCase.assertTrue(randomDirectory.mkdirs());
        final java.io.File symlinkDirectory = new java.io.File(top , "fakeDir");
        setupSymlink(randomDirectory, symlinkDirectory);
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.isSymlink(symlinkDirectory));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(randomDirectory));
    }

    public void g() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File randomFile = new java.io.File(top , "randomfile");
        org.apache.commons.io.FileUtils.touch(randomFile);
        final java.io.File symlinkFile = new java.io.File(top , "fakeinner");
        setupSymlink(randomFile, symlinkFile);
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.isSymlink(symlinkFile));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(randomFile));
    }

    public void e() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File noexistFile = new java.io.File(top , "noexist");
        final java.io.File symlinkFile = new java.io.File(top , "fakeinner");
        final java.io.File badSymlinkInPathFile = new java.io.File(symlinkFile , "fakeinner");
        final java.io.File noexistParentFile = new java.io.File("noexist" , "file");
        setupSymlink(noexistFile, symlinkFile);
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.isSymlink(symlinkFile));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(noexistFile));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(noexistParentFile));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(badSymlinkInPathFile));
    }

    public void d() throws java.lang.Exception {
        if (java.lang.System.getProperty("os.name").startsWith("Win")) {
            return ;
        } 
        final java.io.File realParent = new java.io.File(top , "realparent");
        junit.framework.TestCase.assertTrue(realParent.mkdirs());
        final java.io.File symlinkParentDirectory = new java.io.File(top , "fakeparent");
        setupSymlink(realParent, symlinkParentDirectory);
        final java.io.File realChild = new java.io.File(symlinkParentDirectory , "realChild");
        junit.framework.TestCase.assertTrue(realChild.mkdirs());
        final java.io.File symlinkChild = new java.io.File(symlinkParentDirectory , "fakeChild");
        setupSymlink(realChild, symlinkChild);
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.isSymlink(symlinkChild));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.isSymlink(realChild));
    }

    private void a(final java.io.File res, final java.io.File link) throws java.lang.Exception {
        final java.util.List<java.lang.String> args = new java.util.ArrayList<java.lang.String>();
        args.add("ln");
        args.add("-s");
        args.add(res.getAbsolutePath());
        args.add(link.getAbsolutePath());
        java.lang.Process proc;
        proc = java.lang.Runtime.getRuntime().exec(args.toArray(new java.lang.String[args.size()]));
        proc.waitFor();
    }
}

