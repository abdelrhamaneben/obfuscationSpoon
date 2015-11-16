package org.apache.commons.io;


public class FileUtilsListFilesTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public FileUtilsListFilesTestCase(final java.lang.String name) {
        super(name);
    }

    private java.io.File testCopyDirectoryToItself() {
        return new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "list-files");
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        java.io.File dir = getLocalTestDirectory();
        if (dir.exists()) {
            org.apache.commons.io.FileUtils.deleteDirectory(dir);
        } 
        dir.mkdirs();
        java.io.File file = new java.io.File(dir , "dummy-build.xml");
        org.apache.commons.io.FileUtils.touch(file);
        file = new java.io.File(dir , "README");
        org.apache.commons.io.FileUtils.touch(file);
        dir = new java.io.File(dir , "subdir1");
        dir.mkdirs();
        file = new java.io.File(dir , "dummy-build.xml");
        org.apache.commons.io.FileUtils.touch(file);
        file = new java.io.File(dir , "dummy-readme.txt");
        org.apache.commons.io.FileUtils.touch(file);
        dir = new java.io.File(dir , "subsubdir1");
        dir.mkdirs();
        file = new java.io.File(dir , "dummy-file.txt");
        org.apache.commons.io.FileUtils.touch(file);
        file = new java.io.File(dir , "dummy-index.html");
        org.apache.commons.io.FileUtils.touch(file);
        dir = dir.getParentFile();
        dir = new java.io.File(dir , "CVS");
        dir.mkdirs();
        file = new java.io.File(dir , "Entries");
        org.apache.commons.io.FileUtils.touch(file);
        file = new java.io.File(dir , "Repository");
        org.apache.commons.io.FileUtils.touch(file);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        final java.io.File dir = getLocalTestDirectory();
        org.apache.commons.io.FileUtils.deleteDirectory(dir);
    }

    private java.util.Collection<java.lang.String> testCopyDirectoryToItself(final java.util.Collection<java.io.File> files) {
        final java.util.Collection<java.lang.String> filenames = new java.util.ArrayList<java.lang.String>(files.size());
        for (final java.io.File file : files) {
            filenames.add(file.getName());
        }
        return filenames;
    }

    private java.util.Collection<java.lang.String> testCopyDirectoryToItself(final java.util.Iterator<java.io.File> files) {
        final java.util.Collection<java.lang.String> filenames = new java.util.ArrayList<java.lang.String>();
        while (files.hasNext()) {
            filenames.add(files.next().getName());
        }
        return filenames;
    }

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        final java.lang.String[] extensions = new java.lang.String[]{ "xml" , "txt" };
        java.util.Iterator<java.io.File> files = org.apache.commons.io.FileUtils.iterateFiles(getLocalTestDirectory(), extensions, false);
        java.util.Collection<java.lang.String> filenames = filesToFilenames(files);
        junit.framework.TestCase.assertEquals(1, filenames.size());
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertFalse(filenames.contains("README"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-file.txt"));
        files = org.apache.commons.io.FileUtils.iterateFiles(getLocalTestDirectory(), extensions, true);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertEquals(4, filenames.size());
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-file.txt"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-index.html"));
        files = org.apache.commons.io.FileUtils.iterateFiles(getLocalTestDirectory(), null, false);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertEquals(2, filenames.size());
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertTrue(filenames.contains("README"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-file.txt"));
    }

    public void b() throws java.lang.Exception {
        final java.lang.String[] extensions = new java.lang.String[]{ "xml" , "txt" };
        java.util.Collection<java.io.File> files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), extensions, false);
        junit.framework.TestCase.assertEquals(1, files.size());
        java.util.Collection<java.lang.String> filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertFalse(filenames.contains("README"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-file.txt"));
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), extensions, true);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertEquals(4, filenames.size());
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-file.txt"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-index.html"));
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), null, false);
        junit.framework.TestCase.assertEquals(2, files.size());
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue(filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertTrue(filenames.contains("README"));
        junit.framework.TestCase.assertFalse(filenames.contains("dummy-file.txt"));
    }

    public void a() throws java.lang.Exception {
        java.util.Collection<java.io.File> files;
        java.util.Collection<java.lang.String> filenames;
        org.apache.commons.io.filefilter.IOFileFilter fileFilter;
        org.apache.commons.io.filefilter.IOFileFilter dirFilter;
        fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), fileFilter, null);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue("\'dummy-build.xml\' is missing", filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertFalse("\'dummy-index.html\' shouldn\'t be found", filenames.contains("dummy-index.html"));
        junit.framework.TestCase.assertFalse("\'Entries\' shouldn\'t be found", filenames.contains("Entries"));
        fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        dirFilter = org.apache.commons.io.filefilter.FileFilterUtils.notFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("CVS"));
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), fileFilter, dirFilter);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue("\'dummy-build.xml\' is missing", filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertTrue("\'dummy-index.html\' is missing", filenames.contains("dummy-index.html"));
        junit.framework.TestCase.assertFalse("\'Entries\' shouldn\'t be found", filenames.contains("Entries"));
        fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        dirFilter = org.apache.commons.io.filefilter.FileFilterUtils.makeCVSAware(null);
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), fileFilter, dirFilter);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue("\'dummy-build.xml\' is missing", filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertTrue("\'dummy-index.html\' is missing", filenames.contains("dummy-index.html"));
        junit.framework.TestCase.assertFalse("\'Entries\' shouldn\'t be found", filenames.contains("Entries"));
        fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        dirFilter = org.apache.commons.io.filefilter.FileFilterUtils.prefixFileFilter("sub");
        dirFilter = org.apache.commons.io.filefilter.FileFilterUtils.makeCVSAware(dirFilter);
        files = org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), fileFilter, dirFilter);
        filenames = filesToFilenames(files);
        junit.framework.TestCase.assertTrue("\'dummy-build.xml\' is missing", filenames.contains("dummy-build.xml"));
        junit.framework.TestCase.assertTrue("\'dummy-index.html\' is missing", filenames.contains("dummy-index.html"));
        junit.framework.TestCase.assertFalse("\'Entries\' shouldn\'t be found", filenames.contains("Entries"));
        try {
            org.apache.commons.io.FileUtils.listFiles(getLocalTestDirectory(), null, null);
            junit.framework.TestCase.fail("Expected error about null parameter");
        } catch (final java.lang.NullPointerException e) {
        }
    }
}

