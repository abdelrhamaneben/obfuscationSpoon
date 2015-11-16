package org.apache.commons.io;


public class FilenameUtilsTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final java.lang.String SEP = "" + (java.io.File.separatorChar);

    private static final boolean WINDOWS = (java.io.File.separatorChar) == '\\';

    private final java.io.File testFile1;

    private final java.io.File testFile2;

    private final int testFile1Size;

    private final int testFile2Size;

    public FilenameUtilsTestCase(final java.lang.String name) {
        super(name);
        testFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1-test.txt");
        testFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1a-test.txt");
        testFile1Size = ((int)(testFile1.length()));
        testFile2Size = ((int)(testFile2.length()));
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
        createFile(testFile1, testFile1Size);
        createFile(testFile2, testFile2Size);
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
        createFile(testFile1, testFile1Size);
        createFile(testFile2, testFile2Size);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    public void ac() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize(null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("1:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("\\\\\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("\\\\a"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("C:" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("C:\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((((((("" + (SEP)) + "") + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("\\\\server\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("~" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("~\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("~user" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("~user\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("a/b/../c"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.normalize("a/b/../../c"));
        junit.framework.TestCase.assertEquals(("c" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/../../c/"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("a/b/../../../c"));
        junit.framework.TestCase.assertEquals(("a" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/.."));
        junit.framework.TestCase.assertEquals(("a" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/../"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalize("a/b/../.."));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalize("a/b/../../"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("a/b/../../.."));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("a/b/../c/../d"));
        junit.framework.TestCase.assertEquals(((("a" + (SEP)) + "d") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/../c/../d/"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("a/b//d"));
        junit.framework.TestCase.assertEquals(((("a" + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/././."));
        junit.framework.TestCase.assertEquals(((("a" + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("a/b/./././"));
        junit.framework.TestCase.assertEquals(("a" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("./a/"));
        junit.framework.TestCase.assertEquals("a", org.apache.commons.io.FilenameUtils.normalize("./a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalize("./"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalize("."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize(".."));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalize(""));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalize("/a"));
        junit.framework.TestCase.assertEquals((((SEP) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("/a/"));
        junit.framework.TestCase.assertEquals(((((SEP) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("/a/b/../c"));
        junit.framework.TestCase.assertEquals(((SEP) + "c"), org.apache.commons.io.FilenameUtils.normalize("/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("/a/b/../../../c"));
        junit.framework.TestCase.assertEquals((((SEP) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("/a/b/.."));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalize("/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("/a/b/../../.."));
        junit.framework.TestCase.assertEquals(((((SEP) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals(((((((SEP) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("/a/b//d"));
        junit.framework.TestCase.assertEquals((((((SEP) + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("/a/b/././."));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalize("/./a"));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalize("/./"));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalize("/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("/.."));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalize("/"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("~/a"));
        junit.framework.TestCase.assertEquals(((("~" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/a/"));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("~/a/b/../c"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("~/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~/a/b/../../../c"));
        junit.framework.TestCase.assertEquals(((("~" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/a/b/.."));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("~/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("~/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("~" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("~/a/b//d"));
        junit.framework.TestCase.assertEquals(((((("~" + (SEP)) + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/a/b/././."));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("~/./a"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/./"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~/.."));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~/"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("~user/a"));
        junit.framework.TestCase.assertEquals(((("~user" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~user/a/"));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../c"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../../../c"));
        junit.framework.TestCase.assertEquals(((("~user" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/.."));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("~user" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("~user/a/b//d"));
        junit.framework.TestCase.assertEquals(((((("~user" + (SEP)) + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~user/a/b/././."));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("~user/./a"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("~user/./"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("~user/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~user/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("~user/.."));
        junit.framework.TestCase.assertEquals(("~user" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~user/"));
        junit.framework.TestCase.assertEquals(("~user" + (SEP)), org.apache.commons.io.FilenameUtils.normalize("~user"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("C:/a"));
        junit.framework.TestCase.assertEquals(((("C:" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:/a/"));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../c"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../../../c"));
        junit.framework.TestCase.assertEquals(((("C:" + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/.."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("C:" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("C:/a/b//d"));
        junit.framework.TestCase.assertEquals(((((("C:" + (SEP)) + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:/a/b/././."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("C:/./a"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("C:/./"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("C:/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:/.."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("C:/"));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalize("C:a"));
        junit.framework.TestCase.assertEquals((("C:" + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:a/"));
        junit.framework.TestCase.assertEquals(((("C:" + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("C:a/b/../c"));
        junit.framework.TestCase.assertEquals(("C:" + "c"), org.apache.commons.io.FilenameUtils.normalize("C:a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:a/b/../../../c"));
        junit.framework.TestCase.assertEquals((("C:" + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:a/b/.."));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalize("C:a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:a/b/../../.."));
        junit.framework.TestCase.assertEquals(((("C:" + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("C:a/b/../c/../d"));
        junit.framework.TestCase.assertEquals(((((("C:" + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("C:a/b//d"));
        junit.framework.TestCase.assertEquals((((("C:" + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("C:a/b/././."));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalize("C:./a"));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalize("C:./"));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalize("C:."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("C:.."));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalize("C:"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("//server/a"));
        junit.framework.TestCase.assertEquals(((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("//server/a/"));
        junit.framework.TestCase.assertEquals((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../c"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../../../c"));
        junit.framework.TestCase.assertEquals(((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/.."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalize("//server/a/b//d"));
        junit.framework.TestCase.assertEquals(((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b") + (SEP)), org.apache.commons.io.FilenameUtils.normalize("//server/a/b/././."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalize("//server/./a"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("//server/./"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("//server/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("//server/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalize("//server/.."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalize("//server/"));
    }

    public void ag() throws java.lang.Exception {
        try {
            junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize("a\\b/c .txt"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
        try {
            junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalize(" a\\b/c.txt"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void af() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals("/a/c/", org.apache.commons.io.FilenameUtils.normalize("/a/b/../c/", true));
        junit.framework.TestCase.assertEquals("/a/c/", org.apache.commons.io.FilenameUtils.normalize("\\a\\b\\..\\c\\", true));
        junit.framework.TestCase.assertEquals("\\a\\c\\", org.apache.commons.io.FilenameUtils.normalize("/a/b/../c/", false));
        junit.framework.TestCase.assertEquals("\\a\\c\\", org.apache.commons.io.FilenameUtils.normalize("\\a\\b\\..\\c\\", false));
    }

    public void ad() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator(null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("1:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\\\\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\\\a"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("C:" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((((((("" + (SEP)) + "") + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\\\server\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("~" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((((((("~user" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "c.txt"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user\\a\\b/c.txt"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../c"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../../c"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../../c/"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../../../c"));
        junit.framework.TestCase.assertEquals("a", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/.."));
        junit.framework.TestCase.assertEquals("a", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../.."));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../../"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../../.."));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/../c/../d/"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b//d"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/././."));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("a/b/./././"));
        junit.framework.TestCase.assertEquals("a", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("./a/"));
        junit.framework.TestCase.assertEquals("a", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("./a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("./"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator(".."));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator(""));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a"));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/"));
        junit.framework.TestCase.assertEquals(((((SEP) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../c"));
        junit.framework.TestCase.assertEquals(((SEP) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../../../c"));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/.."));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../../.."));
        junit.framework.TestCase.assertEquals(((((SEP) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals(((((((SEP) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b//d"));
        junit.framework.TestCase.assertEquals(((((SEP) + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/././."));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/./a"));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/./"));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/.."));
        junit.framework.TestCase.assertEquals(((SEP) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/"));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../c"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../../../c"));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/.."));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("~" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b//d"));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/a/b/././."));
        junit.framework.TestCase.assertEquals((("~" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/./a"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/./"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/.."));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~/"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/"));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../c"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../../../c"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/.."));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("~user" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b//d"));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/a/b/././."));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/./a"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/./"));
        junit.framework.TestCase.assertEquals((("~user" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/.."));
        junit.framework.TestCase.assertEquals(("~user" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user/"));
        junit.framework.TestCase.assertEquals(("~user" + (SEP)), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("~user"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/"));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../c"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../../../c"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/.."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((("C:" + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b//d"));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/a/b/././."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/./a"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/./"));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/.."));
        junit.framework.TestCase.assertEquals((("C:" + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:/"));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a"));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/"));
        junit.framework.TestCase.assertEquals(((("C:" + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../c"));
        junit.framework.TestCase.assertEquals(("C:" + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../../../c"));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/.."));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../../.."));
        junit.framework.TestCase.assertEquals(((("C:" + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/../c/../d"));
        junit.framework.TestCase.assertEquals(((((("C:" + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b//d"));
        junit.framework.TestCase.assertEquals(((("C:" + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:a/b/././."));
        junit.framework.TestCase.assertEquals(("C:" + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:./a"));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:./"));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:.."));
        junit.framework.TestCase.assertEquals(("C:" + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("C:"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/"));
        junit.framework.TestCase.assertEquals((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../c"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "c"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../../c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../../../c"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/.."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../.."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../../.."));
        junit.framework.TestCase.assertEquals((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/../c/../d"));
        junit.framework.TestCase.assertEquals((((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b//d"));
        junit.framework.TestCase.assertEquals((((((((SEP) + (SEP)) + "server") + (SEP)) + "a") + (SEP)) + "b"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/a/b/././."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + "a"), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/./a"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/./"));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/."));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/../a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/.."));
        junit.framework.TestCase.assertEquals((((((SEP) + (SEP)) + "server") + (SEP)) + ""), org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("//server/"));
    }

    public void ae() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals("/a/c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../c/", true));
        junit.framework.TestCase.assertEquals("/a/c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\a\\b\\..\\c\\", true));
        junit.framework.TestCase.assertEquals("\\a\\c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("/a/b/../c/", false));
        junit.framework.TestCase.assertEquals("\\a\\c", org.apache.commons.io.FilenameUtils.normalizeNoEndSeparator("\\a\\b\\..\\c\\", false));
    }

    public void a() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat("", null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat(null, null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat(null, ""));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat(null, "a"));
        junit.framework.TestCase.assertEquals(((SEP) + "a"), org.apache.commons.io.FilenameUtils.concat(null, "/a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat("", ":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.concat(":", ""));
        junit.framework.TestCase.assertEquals(("f" + (SEP)), org.apache.commons.io.FilenameUtils.concat("", "f/"));
        junit.framework.TestCase.assertEquals("f", org.apache.commons.io.FilenameUtils.concat("", "f"));
        junit.framework.TestCase.assertEquals(((("a" + (SEP)) + "f") + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/", "f/"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "f"), org.apache.commons.io.FilenameUtils.concat("a", "f"));
        junit.framework.TestCase.assertEquals(((((("a" + (SEP)) + "b") + (SEP)) + "f") + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/b/", "f/"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "b") + (SEP)) + "f"), org.apache.commons.io.FilenameUtils.concat("a/b", "f"));
        junit.framework.TestCase.assertEquals(((("a" + (SEP)) + "f") + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/b/", "../f/"));
        junit.framework.TestCase.assertEquals((("a" + (SEP)) + "f"), org.apache.commons.io.FilenameUtils.concat("a/b", "../f"));
        junit.framework.TestCase.assertEquals(((((("a" + (SEP)) + "c") + (SEP)) + "g") + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/b/../c/", "f/../g/"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "c") + (SEP)) + "g"), org.apache.commons.io.FilenameUtils.concat("a/b/../c", "f/../g"));
        junit.framework.TestCase.assertEquals((((("a" + (SEP)) + "c.txt") + (SEP)) + "f"), org.apache.commons.io.FilenameUtils.concat("a/c.txt", "f"));
        junit.framework.TestCase.assertEquals((((SEP) + "f") + (SEP)), org.apache.commons.io.FilenameUtils.concat("", "/f/"));
        junit.framework.TestCase.assertEquals(((SEP) + "f"), org.apache.commons.io.FilenameUtils.concat("", "/f"));
        junit.framework.TestCase.assertEquals((((SEP) + "f") + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/", "/f/"));
        junit.framework.TestCase.assertEquals(((SEP) + "f"), org.apache.commons.io.FilenameUtils.concat("a", "/f"));
        junit.framework.TestCase.assertEquals(((((SEP) + "c") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.concat("a/b/", "/c/d"));
        junit.framework.TestCase.assertEquals((("C:c" + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.concat("a/b/", "C:c/d"));
        junit.framework.TestCase.assertEquals((((("C:" + (SEP)) + "c") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.concat("a/b/", "C:/c/d"));
        junit.framework.TestCase.assertEquals((((("~" + (SEP)) + "c") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.concat("a/b/", "~/c/d"));
        junit.framework.TestCase.assertEquals((((("~user" + (SEP)) + "c") + (SEP)) + "d"), org.apache.commons.io.FilenameUtils.concat("a/b/", "~user/c/d"));
        junit.framework.TestCase.assertEquals(("~" + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/b/", "~"));
        junit.framework.TestCase.assertEquals(("~user" + (SEP)), org.apache.commons.io.FilenameUtils.concat("a/b/", "~user"));
    }

    public void aj() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.separatorsToUnix(null));
        junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToUnix("/a/b/c"));
        junit.framework.TestCase.assertEquals("/a/b/c.txt", org.apache.commons.io.FilenameUtils.separatorsToUnix("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToUnix("/a/b\\c"));
        junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToUnix("\\a\\b\\c"));
        junit.framework.TestCase.assertEquals("D:/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToUnix("D:\\a\\b\\c"));
    }

    public void ak() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.separatorsToWindows(null));
        junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToWindows("\\a\\b\\c"));
        junit.framework.TestCase.assertEquals("\\a\\b\\c.txt", org.apache.commons.io.FilenameUtils.separatorsToWindows("\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToWindows("\\a\\b/c"));
        junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToWindows("/a/b/c"));
        junit.framework.TestCase.assertEquals("D:\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToWindows("D:/a/b/c"));
    }

    public void ai() {
        if (WINDOWS) {
            junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.separatorsToSystem(null));
            junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToSystem("\\a\\b\\c"));
            junit.framework.TestCase.assertEquals("\\a\\b\\c.txt", org.apache.commons.io.FilenameUtils.separatorsToSystem("\\a\\b\\c.txt"));
            junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToSystem("\\a\\b/c"));
            junit.framework.TestCase.assertEquals("\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToSystem("/a/b/c"));
            junit.framework.TestCase.assertEquals("D:\\a\\b\\c", org.apache.commons.io.FilenameUtils.separatorsToSystem("D:/a/b/c"));
        } else {
            junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.separatorsToSystem(null));
            junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToSystem("/a/b/c"));
            junit.framework.TestCase.assertEquals("/a/b/c.txt", org.apache.commons.io.FilenameUtils.separatorsToSystem("/a/b/c.txt"));
            junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToSystem("/a/b\\c"));
            junit.framework.TestCase.assertEquals("/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToSystem("\\a\\b\\c"));
            junit.framework.TestCase.assertEquals("D:/a/b/c", org.apache.commons.io.FilenameUtils.separatorsToSystem("D:\\a\\b\\c"));
        }
    }

    public void t() {
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength(null));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength(":"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("1:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("1:"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("1:a"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\\\\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\\\a"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.FilenameUtils.getPrefixLength(""));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("C:"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.FilenameUtils.getPrefixLength("C:\\"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.FilenameUtils.getPrefixLength("//server/"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("~"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("~/"));
        junit.framework.TestCase.assertEquals(6, org.apache.commons.io.FilenameUtils.getPrefixLength("~user"));
        junit.framework.TestCase.assertEquals(6, org.apache.commons.io.FilenameUtils.getPrefixLength("~user/"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.FilenameUtils.getPrefixLength("a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("C:a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.FilenameUtils.getPrefixLength("C:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.FilenameUtils.getPrefixLength("\\\\server\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.FilenameUtils.getPrefixLength("a/b/c.txt"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.FilenameUtils.getPrefixLength("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.FilenameUtils.getPrefixLength("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.FilenameUtils.getPrefixLength("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(6, org.apache.commons.io.FilenameUtils.getPrefixLength("~user/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.FilenameUtils.getPrefixLength("a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(2, org.apache.commons.io.FilenameUtils.getPrefixLength("~\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(6, org.apache.commons.io.FilenameUtils.getPrefixLength("~user\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.FilenameUtils.getPrefixLength("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("\\\\\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.getPrefixLength("///a/b/c.txt"));
    }

    public void w() {
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfLastSeparator(null));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfLastSeparator("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.FilenameUtils.indexOfLastSeparator("a/b/c"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.FilenameUtils.indexOfLastSeparator("a\\b\\c"));
    }

    public void v() {
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension(null));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension("file"));
        junit.framework.TestCase.assertEquals(4, org.apache.commons.io.FilenameUtils.indexOfExtension("file.txt"));
        junit.framework.TestCase.assertEquals(13, org.apache.commons.io.FilenameUtils.indexOfExtension("a.txt/b.txt/c.txt"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension("a/b/c"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension("a\\b\\c"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension("a/b.notextension/c"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.FilenameUtils.indexOfExtension("a\\b.notextension\\c"));
    }

    public void s() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix(null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix("1:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix("\\\\\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPrefix("\\\\a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPrefix(""));
        junit.framework.TestCase.assertEquals("\\", org.apache.commons.io.FilenameUtils.getPrefix("\\"));
        junit.framework.TestCase.assertEquals("C:", org.apache.commons.io.FilenameUtils.getPrefix("C:"));
        junit.framework.TestCase.assertEquals("C:\\", org.apache.commons.io.FilenameUtils.getPrefix("C:\\"));
        junit.framework.TestCase.assertEquals("//server/", org.apache.commons.io.FilenameUtils.getPrefix("//server/"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getPrefix("~"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getPrefix("~/"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getPrefix("~user"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getPrefix("~user/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPrefix("a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("\\", org.apache.commons.io.FilenameUtils.getPrefix("\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("C:\\", org.apache.commons.io.FilenameUtils.getPrefix("C:\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("\\\\server\\", org.apache.commons.io.FilenameUtils.getPrefix("\\\\server\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPrefix("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("/", org.apache.commons.io.FilenameUtils.getPrefix("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("C:/", org.apache.commons.io.FilenameUtils.getPrefix("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("//server/", org.apache.commons.io.FilenameUtils.getPrefix("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getPrefix("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getPrefix("~user/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPrefix("a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("\\", org.apache.commons.io.FilenameUtils.getPrefix("\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("~\\", org.apache.commons.io.FilenameUtils.getPrefix("~\\a\\b\\c.txt"));
        junit.framework.TestCase.assertEquals("~user\\", org.apache.commons.io.FilenameUtils.getPrefix("~user\\a\\b\\c.txt"));
    }

    public void u() {
        try {
            junit.framework.TestCase.assertEquals("~user\\", org.apache.commons.io.FilenameUtils.getPrefix("~u ser\\a\\b\\c.txt"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void o() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath(null));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("/noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("\\noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("a/b/c"));
        junit.framework.TestCase.assertEquals("a/b/c/", org.apache.commons.io.FilenameUtils.getPath("a/b/c/"));
        junit.framework.TestCase.assertEquals("a\\b\\", org.apache.commons.io.FilenameUtils.getPath("a\\b\\c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath("1:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath("///a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath("//a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath(""));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("C:"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("C:/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("//server/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("~"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("~/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("~user"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("~user/"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("C:a"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("C:a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("~user/a/b/c.txt"));
    }

    public void r() {
        try {
            junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getPath("~user/a/ b/c.txt"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void p() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPath(null));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPath("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("/noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("\\noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("a/b/c"));
        junit.framework.TestCase.assertEquals("a/b/c", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("a/b/c/"));
        junit.framework.TestCase.assertEquals("a\\b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("a\\b\\c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("1:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("///a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("//a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator(""));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("C:"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("C:/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("//server/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~/"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~user"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~user/"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("C:a"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("C:a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~user/a/b/c.txt"));
    }

    public void q() {
        try {
            junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getPathNoEndSeparator("~user/a /b/c.txt"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void k() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath(null));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getFullPath("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getFullPath("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getFullPath("a/b/c"));
        junit.framework.TestCase.assertEquals("a/b/c/", org.apache.commons.io.FilenameUtils.getFullPath("a/b/c/"));
        junit.framework.TestCase.assertEquals("a\\b\\", org.apache.commons.io.FilenameUtils.getFullPath("a\\b\\c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath("1:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath("///a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPath("//a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getFullPath(""));
        junit.framework.TestCase.assertEquals("C:", org.apache.commons.io.FilenameUtils.getFullPath("C:"));
        junit.framework.TestCase.assertEquals("C:/", org.apache.commons.io.FilenameUtils.getFullPath("C:/"));
        junit.framework.TestCase.assertEquals("//server/", org.apache.commons.io.FilenameUtils.getFullPath("//server/"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getFullPath("~"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getFullPath("~/"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getFullPath("~user"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getFullPath("~user/"));
        junit.framework.TestCase.assertEquals("a/b/", org.apache.commons.io.FilenameUtils.getFullPath("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("/a/b/", org.apache.commons.io.FilenameUtils.getFullPath("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("C:", org.apache.commons.io.FilenameUtils.getFullPath("C:a"));
        junit.framework.TestCase.assertEquals("C:a/b/", org.apache.commons.io.FilenameUtils.getFullPath("C:a/b/c.txt"));
        junit.framework.TestCase.assertEquals("C:/a/b/", org.apache.commons.io.FilenameUtils.getFullPath("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("//server/a/b/", org.apache.commons.io.FilenameUtils.getFullPath("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~/a/b/", org.apache.commons.io.FilenameUtils.getFullPath("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~user/a/b/", org.apache.commons.io.FilenameUtils.getFullPath("~user/a/b/c.txt"));
    }

    public void l() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator(null));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("a/b/c"));
        junit.framework.TestCase.assertEquals("a/b/c", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("a/b/c/"));
        junit.framework.TestCase.assertEquals("a\\b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("a\\b\\c"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator(":"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("1:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("1:"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("1:a"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("///a/b/c.txt"));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("//a"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator(""));
        junit.framework.TestCase.assertEquals("C:", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("C:"));
        junit.framework.TestCase.assertEquals("C:/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("C:/"));
        junit.framework.TestCase.assertEquals("//server/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("//server/"));
        junit.framework.TestCase.assertEquals("~", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~"));
        junit.framework.TestCase.assertEquals("~/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~/"));
        junit.framework.TestCase.assertEquals("~user", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~user"));
        junit.framework.TestCase.assertEquals("~user/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~user/"));
        junit.framework.TestCase.assertEquals("a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("/a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("C:", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("C:a"));
        junit.framework.TestCase.assertEquals("C:a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("C:a/b/c.txt"));
        junit.framework.TestCase.assertEquals("C:/a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("C:/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("//server/a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("//server/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~/a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~/a/b/c.txt"));
        junit.framework.TestCase.assertEquals("~user/a/b", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("~user/a/b/c.txt"));
    }

    public void m() {
        junit.framework.TestCase.assertEquals("/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("/"));
        junit.framework.TestCase.assertEquals("\\", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("\\"));
        junit.framework.TestCase.assertEquals("/", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("/abc"));
        junit.framework.TestCase.assertEquals("\\", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("\\abc"));
        junit.framework.TestCase.assertEquals("/abc", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("/abc/xyz"));
        junit.framework.TestCase.assertEquals("\\abc", org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator("\\abc\\xyz"));
    }

    public void n() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getName(null));
        junit.framework.TestCase.assertEquals("noseperator.inthispath", org.apache.commons.io.FilenameUtils.getName("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("c.txt", org.apache.commons.io.FilenameUtils.getName("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getName("a/b/c"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getName("a/b/c/"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getName("a\\b\\c"));
    }

    public void x() {
        try {
            junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getName("a\\b\\ c"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void h() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getBaseName(null));
        junit.framework.TestCase.assertEquals("noseperator", org.apache.commons.io.FilenameUtils.getBaseName("noseperator.inthispath"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getBaseName("a/b/c.txt"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getBaseName("a/b/c"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getBaseName("a/b/c/"));
        junit.framework.TestCase.assertEquals("c", org.apache.commons.io.FilenameUtils.getBaseName("a\\b\\c"));
        junit.framework.TestCase.assertEquals("file.txt", org.apache.commons.io.FilenameUtils.getBaseName("file.txt.bak"));
    }

    public void i() {
        try {
            junit.framework.TestCase.assertEquals("file.txt", org.apache.commons.io.FilenameUtils.getBaseName("fil e.txt.bak"));
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void j() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.getExtension(null));
        junit.framework.TestCase.assertEquals("ext", org.apache.commons.io.FilenameUtils.getExtension("file.ext"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("README"));
        junit.framework.TestCase.assertEquals("com", org.apache.commons.io.FilenameUtils.getExtension("domain.dot.com"));
        junit.framework.TestCase.assertEquals("jpeg", org.apache.commons.io.FilenameUtils.getExtension("image.jpeg"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("a.b/c"));
        junit.framework.TestCase.assertEquals("txt", org.apache.commons.io.FilenameUtils.getExtension("a.b/c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("a/b/c"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("a.b\\c"));
        junit.framework.TestCase.assertEquals("txt", org.apache.commons.io.FilenameUtils.getExtension("a.b\\c.txt"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("a\\b\\c"));
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FilenameUtils.getExtension("C:\\temp\\foo.bar\\README"));
        junit.framework.TestCase.assertEquals("ext", org.apache.commons.io.FilenameUtils.getExtension("../filename.ext"));
    }

    public void ah() {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FilenameUtils.removeExtension(null));
        junit.framework.TestCase.assertEquals("file", org.apache.commons.io.FilenameUtils.removeExtension("file.ext"));
        junit.framework.TestCase.assertEquals("README", org.apache.commons.io.FilenameUtils.removeExtension("README"));
        junit.framework.TestCase.assertEquals("domain.dot", org.apache.commons.io.FilenameUtils.removeExtension("domain.dot.com"));
        junit.framework.TestCase.assertEquals("image", org.apache.commons.io.FilenameUtils.removeExtension("image.jpeg"));
        junit.framework.TestCase.assertEquals("a.b/c", org.apache.commons.io.FilenameUtils.removeExtension("a.b/c"));
        junit.framework.TestCase.assertEquals("a.b/c", org.apache.commons.io.FilenameUtils.removeExtension("a.b/c.txt"));
        junit.framework.TestCase.assertEquals("a/b/c", org.apache.commons.io.FilenameUtils.removeExtension("a/b/c"));
        junit.framework.TestCase.assertEquals("a.b\\c", org.apache.commons.io.FilenameUtils.removeExtension("a.b\\c"));
        junit.framework.TestCase.assertEquals("a.b\\c", org.apache.commons.io.FilenameUtils.removeExtension("a.b\\c.txt"));
        junit.framework.TestCase.assertEquals("a\\b\\c", org.apache.commons.io.FilenameUtils.removeExtension("a\\b\\c"));
        junit.framework.TestCase.assertEquals("C:\\temp\\foo.bar\\README", org.apache.commons.io.FilenameUtils.removeExtension("C:\\temp\\foo.bar\\README"));
        junit.framework.TestCase.assertEquals("../filename", org.apache.commons.io.FilenameUtils.removeExtension("../filename.ext"));
    }

    public void b() {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equals(null, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals(null, ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals("", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equals("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equals("file.txt", "file.txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals("file.txt", "FILE.TXT"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals("a\\b\\file.txt", "a/b/file.txt"));
    }

    public void f() {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsOnSystem(null, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsOnSystem(null, ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsOnSystem("", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsOnSystem("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsOnSystem("file.txt", "file.txt"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.equalsOnSystem("file.txt", "FILE.TXT"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsOnSystem("a\\b\\file.txt", "a/b/file.txt"));
    }

    public void c() {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalized(null, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalized(null, ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalized("", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalized("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalized("file.txt", "file.txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalized("file.txt", "FILE.TXT"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalized("a\\b\\file.txt", "a/b/file.txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalized("a/b/", "a/b"));
    }

    public void e() {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem(null, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem(null, ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("file.txt", "file.txt"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("file.txt", "FILE.TXT"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("a\\b\\file.txt", "a/b/file.txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("a/b/", "a/b"));
    }

    public void d() {
        try {
            org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("//file.txt", "file.txt");
            junit.framework.TestCase.fail("Invalid normalized first file");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("file.txt", "//file.txt");
            junit.framework.TestCase.fail("Invalid normalized second file");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FilenameUtils.equalsNormalizedOnSystem("//file.txt", "//file.txt");
            junit.framework.TestCase.fail("Invalid normalized both filse");
        } catch (final java.lang.NullPointerException e) {
        }
    }

    public void g() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals("file.txt", "FILE.TXT", true, org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.equals("file.txt", "FILE.TXT", true, org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.equals("file.txt", "FILE.TXT", true, org.apache.commons.io.IOCase.SYSTEM));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.equals("file.txt", "FILE.TXT", true, null));
    }

    public void y() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension(null, ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", ((java.lang.String)(null))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file.txt", "txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", "rtf"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", "txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", "rtf"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", "txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", "rtf"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", "txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", "rtf"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", ((java.lang.String)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", "txt"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", "rtf"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", "TXT"));
    }

    public void ab() {
        try {
            org.apache.commons.io.FilenameUtils.isExtension("a.b\\fi le.txt", "TXT");
            junit.framework.TestCase.fail("Should throw IAE");
        } catch (java.lang.IllegalArgumentException ignore) {
        }
    }

    public void z() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension(null, ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.lang.String[0]));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.lang.String[]{ "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.lang.String[]{ "rtf" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", new java.lang.String[]{ "rtf" , "" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.lang.String[]{ "rtf" , "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.lang.String[0]));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.lang.String[]{ "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.lang.String[]{ "rtf" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.lang.String[]{ "rtf" , "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.lang.String[0]));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.lang.String[]{ "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.lang.String[]{ "rtf" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.lang.String[]{ "rtf" , "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.lang.String[0]));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.lang.String[]{ "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.lang.String[]{ "rtf" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.lang.String[]{ "rtf" , "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", ((java.lang.String[])(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[0]));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[]{ "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[]{ "rtf" }));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[]{ "rtf" , "txt" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[]{ "TXT" }));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.lang.String[]{ "TXT" , "RTF" }));
    }

    public void aa() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension(null, ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.util.ArrayList<java.lang.String>()));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.util.ArrayList<java.lang.String>()));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a/b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.util.ArrayList<java.lang.String>()));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b/file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.util.ArrayList<java.lang.String>()));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a\\b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", ((java.util.Collection<java.lang.String>)(null))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>()));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" }))));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "rtf" , "txt" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "TXT" }))));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.isExtension("a.b\\file.txt", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(new java.lang.String[]{ "TXT" , "RTF" }))));
    }
}

