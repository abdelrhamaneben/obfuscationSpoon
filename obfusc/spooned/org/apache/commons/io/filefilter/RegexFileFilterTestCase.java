package org.apache.commons.io.filefilter;


public class RegexFileFilterTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public RegexFileFilterTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    public void setUp() {
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
    }

    @java.lang.Override
    public void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    public void testCopyDirectoryToItself(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File file, final boolean expected) throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(((((("Filter(File) " + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file));
        if ((file != null) && ((file.getParentFile()) != null)) {
            junit.framework.TestCase.assertEquals(((((("Filter(File, String) " + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file.getParentFile(), file.getName()));
        } else if (file == null) {
            junit.framework.TestCase.assertEquals((((("Filter(File, String) " + (filter.getClass().getName())) + " not ") + expected) + " for null"), expected, filter.accept(file));
        } 
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.RegexFileFilter("^.*[tT]est(-\\d+)?\\.java$");
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("test-10.java"), true);
        assertFiltering(filter, new java.io.File("test-.java"), false);
        filter = new org.apache.commons.io.filefilter.RegexFileFilter("^[Tt]est.java$");
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("test.java"), true);
        assertFiltering(filter, new java.io.File("tEST.java"), false);
        filter = new org.apache.commons.io.filefilter.RegexFileFilter(java.util.regex.Pattern.compile("^test.java$", java.util.regex.Pattern.CASE_INSENSITIVE));
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("test.java"), true);
        assertFiltering(filter, new java.io.File("tEST.java"), true);
        filter = new org.apache.commons.io.filefilter.RegexFileFilter("^test.java$" , java.util.regex.Pattern.CASE_INSENSITIVE);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("test.java"), true);
        assertFiltering(filter, new java.io.File("tEST.java"), true);
        filter = new org.apache.commons.io.filefilter.RegexFileFilter("^test.java$" , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("test.java"), true);
        assertFiltering(filter, new java.io.File("tEST.java"), true);
        try {
            new org.apache.commons.io.filefilter.RegexFileFilter(((java.lang.String)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.RegexFileFilter(null , java.util.regex.Pattern.CASE_INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.RegexFileFilter(null , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.RegexFileFilter(((java.util.regex.Pattern)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }
}

