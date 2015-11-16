package org.apache.commons.io.filefilter;


public class FileFilterTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    static final java.lang.String SVN_DIR_NAME = ".svn";

    private static final boolean WINDOWS = (java.io.File.separatorChar) == '\\';

    public FileFilterTestCase(final java.lang.String name) {
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
        junit.framework.TestCase.assertNotNull(filter.toString());
    }

    public void aj() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.SuffixFileFilter(new java.lang.String[]{ "tes" , "est" });
        final java.io.File testFile = new java.io.File("test");
        final java.io.File fredFile = new java.io.File("fred");
        assertFiltering(filter, new java.io.File("fred.tes"), true);
        assertFiltering(filter, new java.io.File("fred.est"), true);
        assertFiltering(filter, new java.io.File("fred.EST"), false);
        assertFiltering(filter, new java.io.File("fred.exe"), false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.or(org.apache.commons.io.filefilter.FileFilterUtils.suffixFileFilter("tes"), org.apache.commons.io.filefilter.FileFilterUtils.suffixFileFilter("est"));
        assertFiltering(filter, new java.io.File("fred"), false);
        assertFiltering(filter, new java.io.File(".tes"), true);
        assertFiltering(filter, new java.io.File("fred.test"), true);
        filter = new org.apache.commons.io.filefilter.SuffixFileFilter("est");
        assertFiltering(filter, new java.io.File("test"), true);
        assertFiltering(filter, new java.io.File("fred"), false);
        junit.framework.TestCase.assertTrue(filter.accept(testFile.getParentFile(), testFile.getName()));
        junit.framework.TestCase.assertTrue(!(filter.accept(fredFile.getParentFile(), fredFile.getName())));
        final java.util.List<java.lang.String> prefixes = java.util.Arrays.asList("ood", "red");
        final org.apache.commons.io.filefilter.IOFileFilter listFilter = new org.apache.commons.io.filefilter.SuffixFileFilter(prefixes);
        junit.framework.TestCase.assertTrue(!(listFilter.accept(testFile.getParentFile(), testFile.getName())));
        junit.framework.TestCase.assertTrue(listFilter.accept(fredFile.getParentFile(), fredFile.getName()));
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.lang.String)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.lang.String[])(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.util.List<java.lang.String>)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void ak() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.SuffixFileFilter(new java.lang.String[]{ "tes" , "est" } , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo.tes"), true);
        assertFiltering(filter, new java.io.File("foo.est"), true);
        assertFiltering(filter, new java.io.File("foo.EST"), true);
        assertFiltering(filter, new java.io.File("foo.TES"), true);
        assertFiltering(filter, new java.io.File("foo.exe"), false);
        filter = new org.apache.commons.io.filefilter.SuffixFileFilter("est" , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("test"), true);
        assertFiltering(filter, new java.io.File("TEST"), true);
        final java.util.List<java.lang.String> suffixes = java.util.Arrays.asList("tes", "est");
        filter = new org.apache.commons.io.filefilter.SuffixFileFilter(suffixes , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("bar.tes"), true);
        assertFiltering(filter, new java.io.File("bar.est"), true);
        assertFiltering(filter, new java.io.File("bar.EST"), true);
        assertFiltering(filter, new java.io.File("bar.TES"), true);
        assertFiltering(filter, new java.io.File("bar.exe"), false);
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.lang.String)(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.lang.String[])(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.SuffixFileFilter(((java.util.List<java.lang.String>)(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        filter = org.apache.commons.io.filefilter.FileFilterUtils.suffixFileFilter("est", org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("test"), true);
        assertFiltering(filter, new java.io.File("TEST"), true);
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.suffixFileFilter(null, org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.DirectoryFileFilter();
        assertFiltering(filter, new java.io.File("src/"), true);
        assertFiltering(filter, new java.io.File("src/main/java/"), true);
        assertFiltering(filter, new java.io.File("pom.xml"), false);
        assertFiltering(filter, new java.io.File("imaginary"), false);
        assertFiltering(filter, new java.io.File("imaginary/"), false);
        assertFiltering(filter, new java.io.File("LICENSE.txt"), false);
        junit.framework.TestCase.assertSame(org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY, org.apache.commons.io.filefilter.DirectoryFileFilter.INSTANCE);
    }

    public void f() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFileFilter.FILE;
        assertFiltering(filter, new java.io.File("src/"), false);
        assertFiltering(filter, new java.io.File("src/java/"), false);
        assertFiltering(filter, new java.io.File("pom.xml"), true);
        assertFiltering(filter, new java.io.File("imaginary"), false);
        assertFiltering(filter, new java.io.File("imaginary/"), false);
        assertFiltering(filter, new java.io.File("LICENSE.txt"), true);
    }

    public void ag() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.PrefixFileFilter(new java.lang.String[]{ "foo" , "bar" });
        final java.io.File testFile = new java.io.File("test");
        final java.io.File fredFile = new java.io.File("fred");
        assertFiltering(filter, new java.io.File("foo.test"), true);
        assertFiltering(filter, new java.io.File("FOO.test"), false);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("food/"), true);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.prefixFileFilter("bar");
        assertFiltering(filter, new java.io.File("barred\\"), true);
        assertFiltering(filter, new java.io.File("test"), false);
        assertFiltering(filter, new java.io.File("fo_o.test"), false);
        assertFiltering(filter, new java.io.File("abar.exe"), false);
        filter = new org.apache.commons.io.filefilter.PrefixFileFilter("tes");
        assertFiltering(filter, new java.io.File("test"), true);
        assertFiltering(filter, new java.io.File("fred"), false);
        junit.framework.TestCase.assertTrue(filter.accept(testFile.getParentFile(), testFile.getName()));
        junit.framework.TestCase.assertTrue(!(filter.accept(fredFile.getParentFile(), fredFile.getName())));
        final java.util.List<java.lang.String> prefixes = java.util.Arrays.asList("foo", "fre");
        final org.apache.commons.io.filefilter.IOFileFilter listFilter = new org.apache.commons.io.filefilter.PrefixFileFilter(prefixes);
        junit.framework.TestCase.assertTrue(!(listFilter.accept(testFile.getParentFile(), testFile.getName())));
        junit.framework.TestCase.assertTrue(listFilter.accept(fredFile.getParentFile(), fredFile.getName()));
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.lang.String)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.lang.String[])(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.util.List<java.lang.String>)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void ah() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.PrefixFileFilter(new java.lang.String[]{ "foo" , "bar" } , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo.test1"), true);
        assertFiltering(filter, new java.io.File("bar.test1"), true);
        assertFiltering(filter, new java.io.File("FOO.test1"), true);
        assertFiltering(filter, new java.io.File("BAR.test1"), true);
        filter = new org.apache.commons.io.filefilter.PrefixFileFilter("bar" , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo.test2"), false);
        assertFiltering(filter, new java.io.File("bar.test2"), true);
        assertFiltering(filter, new java.io.File("FOO.test2"), false);
        assertFiltering(filter, new java.io.File("BAR.test2"), true);
        final java.util.List<java.lang.String> prefixes = java.util.Arrays.asList("foo", "bar");
        filter = new org.apache.commons.io.filefilter.PrefixFileFilter(prefixes , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo.test3"), true);
        assertFiltering(filter, new java.io.File("bar.test3"), true);
        assertFiltering(filter, new java.io.File("FOO.test3"), true);
        assertFiltering(filter, new java.io.File("BAR.test3"), true);
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.lang.String)(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.lang.String[])(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.PrefixFileFilter(((java.util.List<java.lang.String>)(null)) , org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        filter = org.apache.commons.io.filefilter.FileFilterUtils.prefixFileFilter("bar", org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo.test2"), false);
        assertFiltering(filter, new java.io.File("bar.test2"), true);
        assertFiltering(filter, new java.io.File("FOO.test2"), false);
        assertFiltering(filter, new java.io.File("BAR.test2"), true);
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.prefixFileFilter(null, org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void z() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "foo" , "bar" });
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("fred"), false);
        filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "foo" , "bar" } , org.apache.commons.io.IOCase.SENSITIVE);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("FOO"), false);
        assertFiltering(filter, new java.io.File("BAR"), false);
        filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "foo" , "bar" } , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("FOO"), true);
        assertFiltering(filter, new java.io.File("BAR"), true);
        filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "foo" , "bar" } , org.apache.commons.io.IOCase.SYSTEM);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("FOO"), WINDOWS);
        assertFiltering(filter, new java.io.File("BAR"), WINDOWS);
        filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "foo" , "bar" } , null);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("FOO"), false);
        assertFiltering(filter, new java.io.File("BAR"), false);
        final java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
        list.add("foo");
        list.add("bar");
        filter = new org.apache.commons.io.filefilter.NameFileFilter(list);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("bar"), true);
        assertFiltering(filter, new java.io.File("fred"), false);
        filter = new org.apache.commons.io.filefilter.NameFileFilter("foo");
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("FOO"), false);
        assertFiltering(filter, new java.io.File("barfoo"), false);
        assertFiltering(filter, new java.io.File("foobar"), false);
        assertFiltering(filter, new java.io.File("fred"), false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("foo", org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, new java.io.File("FOO"), true);
        assertFiltering(filter, new java.io.File("barfoo"), false);
        assertFiltering(filter, new java.io.File("foobar"), false);
        assertFiltering(filter, new java.io.File("fred"), false);
    }

    public void aa() throws java.lang.Exception {
        final java.lang.String test = null;
        try {
            new org.apache.commons.io.filefilter.NameFileFilter(test);
            junit.framework.TestCase.fail("constructing a NameFileFilter with a null String argument should fail.");
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter(test, org.apache.commons.io.IOCase.INSENSITIVE);
            junit.framework.TestCase.fail("constructing a NameFileFilter with a null String argument should fail.");
        } catch (final java.lang.IllegalArgumentException iae) {
        }
    }

    public void ab() throws java.lang.Exception {
        final java.lang.String[] test = null;
        try {
            new org.apache.commons.io.filefilter.NameFileFilter(test);
            junit.framework.TestCase.fail("constructing a NameFileFilter with a null String[] argument should fail.");
        } catch (final java.lang.IllegalArgumentException iae) {
        }
    }

    public void ac() throws java.lang.Exception {
        final java.util.List<java.lang.String> test = null;
        try {
            new org.apache.commons.io.filefilter.NameFileFilter(test);
            junit.framework.TestCase.fail("constructing a NameFileFilter with a null List argument should fail.");
        } catch (final java.lang.IllegalArgumentException iae) {
        }
    }

    public void al() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        assertFiltering(filter, new java.io.File("foo.test"), true);
        assertFiltering(filter, new java.io.File("foo"), true);
        assertFiltering(filter, null, true);
        junit.framework.TestCase.assertSame(org.apache.commons.io.filefilter.TrueFileFilter.TRUE, org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE);
    }

    public void c() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.falseFileFilter();
        assertFiltering(filter, new java.io.File("foo.test"), false);
        assertFiltering(filter, new java.io.File("foo"), false);
        assertFiltering(filter, null, false);
        junit.framework.TestCase.assertSame(org.apache.commons.io.filefilter.FalseFileFilter.FALSE, org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE);
    }

    public void ad() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.notFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter());
        assertFiltering(filter, new java.io.File("foo.test"), false);
        assertFiltering(filter, new java.io.File("foo"), false);
        assertFiltering(filter, null, false);
        try {
            new org.apache.commons.io.filefilter.NotFileFilter(null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void af() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter trueFilter = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE;
        final org.apache.commons.io.filefilter.IOFileFilter falseFilter = org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE;
        final java.io.File testFile = new java.io.File("foo.test");
        assertFiltering(new org.apache.commons.io.filefilter.OrFileFilter(trueFilter , trueFilter), testFile, true);
        assertFiltering(new org.apache.commons.io.filefilter.OrFileFilter(trueFilter , falseFilter), testFile, true);
        assertFiltering(new org.apache.commons.io.filefilter.OrFileFilter(falseFilter , trueFilter), testFile, true);
        assertFiltering(new org.apache.commons.io.filefilter.OrFileFilter(falseFilter , falseFilter), testFile, false);
        assertFiltering(new org.apache.commons.io.filefilter.OrFileFilter(), testFile, false);
        final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
        filters.add(trueFilter);
        filters.add(falseFilter);
        final org.apache.commons.io.filefilter.OrFileFilter orFilter = new org.apache.commons.io.filefilter.OrFileFilter(filters);
        assertFiltering(orFilter, testFile, true);
        junit.framework.TestCase.assertEquals(orFilter.getFileFilters(), filters);
        orFilter.removeFileFilter(trueFilter);
        assertFiltering(orFilter, testFile, false);
        orFilter.setFileFilters(filters);
        assertFiltering(orFilter, testFile, true);
        junit.framework.TestCase.assertTrue(orFilter.accept(testFile.getParentFile(), testFile.getName()));
        orFilter.removeFileFilter(trueFilter);
        junit.framework.TestCase.assertTrue(!(orFilter.accept(testFile.getParentFile(), testFile.getName())));
        try {
            new org.apache.commons.io.filefilter.OrFileFilter(falseFilter , null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        final org.apache.commons.io.filefilter.OrFileFilter f = new org.apache.commons.io.filefilter.OrFileFilter(null);
        junit.framework.TestCase.assertTrue(f.getFileFilters().isEmpty());
    }

    public void d() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter trueFilter = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE;
        final org.apache.commons.io.filefilter.IOFileFilter falseFilter = org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE;
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.and(trueFilter, trueFilter, trueFilter), new java.io.File("foo.test"), true);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.and(trueFilter, falseFilter, trueFilter), new java.io.File("foo.test"), false);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.and(falseFilter, trueFilter), new java.io.File("foo.test"), false);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.and(falseFilter, falseFilter), new java.io.File("foo.test"), false);
    }

    public void e() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter trueFilter = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE;
        final org.apache.commons.io.filefilter.IOFileFilter falseFilter = org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE;
        final java.io.File testFile = new java.io.File("foo.test");
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.or(trueFilter, trueFilter), testFile, true);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.or(trueFilter, trueFilter, falseFilter), testFile, true);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.or(falseFilter, trueFilter), testFile, true);
        assertFiltering(org.apache.commons.io.filefilter.FileFilterUtils.or(falseFilter, falseFilter, falseFilter), testFile, false);
    }

    public void am() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.WildcardFileFilter("*.txt");
        assertFiltering(filter, new java.io.File("log.txt"), true);
        assertFiltering(filter, new java.io.File("log.TXT"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter("*.txt" , org.apache.commons.io.IOCase.SENSITIVE);
        assertFiltering(filter, new java.io.File("log.txt"), true);
        assertFiltering(filter, new java.io.File("log.TXT"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter("*.txt" , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("log.txt"), true);
        assertFiltering(filter, new java.io.File("log.TXT"), true);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter("*.txt" , org.apache.commons.io.IOCase.SYSTEM);
        assertFiltering(filter, new java.io.File("log.txt"), true);
        assertFiltering(filter, new java.io.File("log.TXT"), WINDOWS);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter("*.txt" , null);
        assertFiltering(filter, new java.io.File("log.txt"), true);
        assertFiltering(filter, new java.io.File("log.TXT"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter(new java.lang.String[]{ "*.java" , "*.class" });
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.class"), true);
        assertFiltering(filter, new java.io.File("Test.jsp"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter(new java.lang.String[]{ "*.java" , "*.class" } , org.apache.commons.io.IOCase.SENSITIVE);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.JAVA"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter(new java.lang.String[]{ "*.java" , "*.class" } , org.apache.commons.io.IOCase.INSENSITIVE);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.JAVA"), true);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter(new java.lang.String[]{ "*.java" , "*.class" } , org.apache.commons.io.IOCase.SYSTEM);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.JAVA"), WINDOWS);
        filter = new org.apache.commons.io.filefilter.WildcardFileFilter(new java.lang.String[]{ "*.java" , "*.class" } , null);
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.JAVA"), false);
        final java.util.List<java.lang.String> patternList = java.util.Arrays.asList("*.txt", "*.xml", "*.gif");
        final org.apache.commons.io.filefilter.IOFileFilter listFilter = new org.apache.commons.io.filefilter.WildcardFileFilter(patternList);
        assertFiltering(listFilter, new java.io.File("Test.txt"), true);
        assertFiltering(listFilter, new java.io.File("Test.xml"), true);
        assertFiltering(listFilter, new java.io.File("Test.gif"), true);
        assertFiltering(listFilter, new java.io.File("Test.bmp"), false);
        final java.io.File txtFile = new java.io.File("test.txt");
        final java.io.File bmpFile = new java.io.File("test.bmp");
        final java.io.File dir = new java.io.File("src/java");
        junit.framework.TestCase.assertTrue(listFilter.accept(txtFile));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(bmpFile)));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(dir)));
        junit.framework.TestCase.assertTrue(listFilter.accept(txtFile.getParentFile(), txtFile.getName()));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(bmpFile.getParentFile(), bmpFile.getName())));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(dir.getParentFile(), dir.getName())));
        try {
            new org.apache.commons.io.filefilter.WildcardFileFilter(((java.lang.String)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.WildcardFileFilter(((java.lang.String[])(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.WildcardFileFilter(((java.util.List<java.lang.String>)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void v() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter1 = org.apache.commons.io.filefilter.FileFilterUtils.makeCVSAware(null);
        final org.apache.commons.io.filefilter.IOFileFilter filter2 = org.apache.commons.io.filefilter.FileFilterUtils.makeCVSAware(org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("test-file1.txt"));
        java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "CVS");
        file.mkdirs();
        assertFiltering(filter1, file, false);
        assertFiltering(filter2, file, false);
        org.apache.commons.io.FileUtils.deleteDirectory(file);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test-file1.txt");
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, true);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test-file2.log");
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, false);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "CVS");
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, false);
    }

    public void y() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter filter1 = org.apache.commons.io.filefilter.FileFilterUtils.makeSVNAware(null);
        final org.apache.commons.io.filefilter.IOFileFilter filter2 = org.apache.commons.io.filefilter.FileFilterUtils.makeSVNAware(org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("test-file1.txt"));
        java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , SVN_DIR_NAME);
        file.mkdirs();
        assertFiltering(filter1, file, false);
        assertFiltering(filter2, file, false);
        org.apache.commons.io.FileUtils.deleteDirectory(file);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test-file1.txt");
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, true);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test-file2.log");
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, false);
        file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , SVN_DIR_NAME);
        createFile(file, 0);
        assertFiltering(filter1, file, true);
        assertFiltering(filter2, file, false);
    }

    public void ai() throws java.lang.Exception {
        final java.io.File smallFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "small.txt");
        createFile(smallFile, 32);
        final java.io.File largeFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "large.txt");
        createFile(largeFile, 128);
        final org.apache.commons.io.filefilter.IOFileFilter filter1 = org.apache.commons.io.filefilter.FileFilterUtils.sizeFileFilter(64);
        final org.apache.commons.io.filefilter.IOFileFilter filter2 = org.apache.commons.io.filefilter.FileFilterUtils.sizeFileFilter(64, true);
        final org.apache.commons.io.filefilter.IOFileFilter filter3 = org.apache.commons.io.filefilter.FileFilterUtils.sizeFileFilter(64, false);
        assertFiltering(filter1, smallFile, false);
        assertFiltering(filter2, smallFile, false);
        assertFiltering(filter3, smallFile, true);
        assertFiltering(filter1, largeFile, true);
        assertFiltering(filter2, largeFile, true);
        assertFiltering(filter3, largeFile, false);
        final org.apache.commons.io.filefilter.IOFileFilter filter4 = org.apache.commons.io.filefilter.FileFilterUtils.sizeRangeFileFilter(33, 127);
        final org.apache.commons.io.filefilter.IOFileFilter filter5 = org.apache.commons.io.filefilter.FileFilterUtils.sizeRangeFileFilter(32, 127);
        final org.apache.commons.io.filefilter.IOFileFilter filter6 = org.apache.commons.io.filefilter.FileFilterUtils.sizeRangeFileFilter(33, 128);
        final org.apache.commons.io.filefilter.IOFileFilter filter7 = org.apache.commons.io.filefilter.FileFilterUtils.sizeRangeFileFilter(31, 129);
        final org.apache.commons.io.filefilter.IOFileFilter filter8 = org.apache.commons.io.filefilter.FileFilterUtils.sizeRangeFileFilter(128, 128);
        assertFiltering(filter4, smallFile, false);
        assertFiltering(filter4, largeFile, false);
        assertFiltering(filter5, smallFile, true);
        assertFiltering(filter5, largeFile, false);
        assertFiltering(filter6, smallFile, false);
        assertFiltering(filter6, largeFile, true);
        assertFiltering(filter7, smallFile, true);
        assertFiltering(filter7, largeFile, true);
        assertFiltering(filter8, largeFile, true);
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.sizeFileFilter(-1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void p() throws java.lang.Exception {
        final java.io.File hiddenDir = new java.io.File(SVN_DIR_NAME);
        if (hiddenDir.exists()) {
            assertFiltering(org.apache.commons.io.filefilter.HiddenFileFilter.HIDDEN, hiddenDir, hiddenDir.isHidden());
            assertFiltering(org.apache.commons.io.filefilter.HiddenFileFilter.VISIBLE, hiddenDir, !(hiddenDir.isHidden()));
        } 
        assertFiltering(org.apache.commons.io.filefilter.HiddenFileFilter.HIDDEN, org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), false);
        assertFiltering(org.apache.commons.io.filefilter.HiddenFileFilter.VISIBLE, org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), true);
    }

    public void a() throws java.lang.Exception {
        final java.io.File emptyDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "empty-dir");
        emptyDir.mkdirs();
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.EMPTY, emptyDir, true);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.NOT_EMPTY, emptyDir, false);
        final java.io.File emptyFile = new java.io.File(emptyDir , "empty-file.txt");
        createFile(emptyFile, 0);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.EMPTY, emptyFile, true);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.NOT_EMPTY, emptyFile, false);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.EMPTY, emptyDir, false);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.NOT_EMPTY, emptyDir, true);
        final java.io.File notEmptyFile = new java.io.File(emptyDir , "not-empty-file.txt");
        createFile(notEmptyFile, 32);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.EMPTY, notEmptyFile, false);
        assertFiltering(org.apache.commons.io.filefilter.EmptyFileFilter.NOT_EMPTY, notEmptyFile, true);
        org.apache.commons.io.FileUtils.forceDelete(emptyDir);
    }

    public void w() throws java.lang.Exception {
        junit.framework.TestCase.assertSame(org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY, org.apache.commons.io.filefilter.FileFilterUtils.makeDirectoryOnly(null));
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.makeDirectoryOnly(org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("B"));
        final java.io.File fileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A");
        final java.io.File fileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B");
        fileA.mkdirs();
        fileB.mkdirs();
        assertFiltering(filter, fileA, false);
        assertFiltering(filter, fileB, true);
        org.apache.commons.io.FileUtils.deleteDirectory(fileA);
        org.apache.commons.io.FileUtils.deleteDirectory(fileB);
        createFile(fileA, 32);
        createFile(fileB, 32);
        assertFiltering(filter, fileA, false);
        assertFiltering(filter, fileB, false);
        fileA.delete();
        fileB.delete();
    }

    public void x() throws java.lang.Exception {
        junit.framework.TestCase.assertSame(org.apache.commons.io.filefilter.FileFileFilter.FILE, org.apache.commons.io.filefilter.FileFilterUtils.makeFileOnly(null));
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.makeFileOnly(org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("B"));
        final java.io.File fileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A");
        final java.io.File fileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B");
        fileA.mkdirs();
        fileB.mkdirs();
        assertFiltering(filter, fileA, false);
        assertFiltering(filter, fileB, false);
        org.apache.commons.io.FileUtils.deleteDirectory(fileA);
        org.apache.commons.io.FileUtils.deleteDirectory(fileB);
        createFile(fileA, 32);
        createFile(fileB, 32);
        assertFiltering(filter, fileA, false);
        assertFiltering(filter, fileB, true);
        fileA.delete();
        fileB.delete();
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void q() throws java.lang.Exception {
        final byte[] classFileMagicNumber = new byte[]{ ((byte)(202)) , ((byte)(254)) , ((byte)(186)) , ((byte)(190)) };
        final java.lang.String xmlFileContent = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n" + "<element>text</element>";
        final java.io.File classFileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A.class");
        final java.io.File xmlFileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B.xml");
        final java.io.File emptyFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "C.xml");
        final java.io.File dir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "D");
        dir.mkdirs();
        final java.io.OutputStream classFileAStream = org.apache.commons.io.FileUtils.openOutputStream(classFileA);
        org.apache.commons.io.IOUtils.write(classFileMagicNumber, classFileAStream);
        generateTestData(classFileAStream, 32);
        classFileAStream.close();
        org.apache.commons.io.FileUtils.write(xmlFileB, xmlFileContent, org.apache.commons.io.Charsets.UTF_8);
        org.apache.commons.io.FileUtils.touch(emptyFile);
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.MagicNumberFileFilter(classFileMagicNumber);
        assertFiltering(filter, classFileA, true);
        assertFiltering(filter, xmlFileB, false);
        assertFiltering(filter, emptyFile, false);
        assertFiltering(filter, dir, false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.magicNumberFileFilter(classFileMagicNumber);
        assertFiltering(filter, classFileA, true);
        assertFiltering(filter, xmlFileB, false);
        assertFiltering(filter, emptyFile, false);
        assertFiltering(filter, dir, false);
    }

    public void r() throws java.lang.Exception {
        final byte[] tarMagicNumber = new byte[]{ 117 , 115 , 116 , 97 , 114 };
        final long tarMagicNumberOffset = 257;
        final java.io.File tarFileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A.tar");
        final java.io.File randomFileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B.txt");
        final java.io.File dir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "D");
        dir.mkdirs();
        final java.io.OutputStream tarFileAStream = org.apache.commons.io.FileUtils.openOutputStream(tarFileA);
        generateTestData(tarFileAStream, tarMagicNumberOffset);
        org.apache.commons.io.IOUtils.write(tarMagicNumber, tarFileAStream);
        tarFileAStream.close();
        createFile(randomFileB, (2 * tarMagicNumberOffset));
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.MagicNumberFileFilter(tarMagicNumber , tarMagicNumberOffset);
        assertFiltering(filter, tarFileA, true);
        assertFiltering(filter, randomFileB, false);
        assertFiltering(filter, dir, false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.magicNumberFileFilter(tarMagicNumber, tarMagicNumberOffset);
        assertFiltering(filter, tarFileA, true);
        assertFiltering(filter, randomFileB, false);
        assertFiltering(filter, dir, false);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void s() throws java.lang.Exception {
        final byte[] classFileMagicNumber = new byte[]{ ((byte)(202)) , ((byte)(254)) , ((byte)(186)) , ((byte)(190)) };
        final java.lang.String xmlFileContent = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n" + "<element>text</element>";
        final java.lang.String xmlMagicNumber = "<?xml version=\"1.0\"";
        final java.io.File classFileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A.class");
        final java.io.File xmlFileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B.xml");
        final java.io.File dir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "D");
        dir.mkdirs();
        final java.io.OutputStream classFileAStream = org.apache.commons.io.FileUtils.openOutputStream(classFileA);
        org.apache.commons.io.IOUtils.write(classFileMagicNumber, classFileAStream);
        generateTestData(classFileAStream, 32);
        classFileAStream.close();
        org.apache.commons.io.FileUtils.write(xmlFileB, xmlFileContent, org.apache.commons.io.Charsets.UTF_8);
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.MagicNumberFileFilter(xmlMagicNumber);
        assertFiltering(filter, classFileA, false);
        assertFiltering(filter, xmlFileB, true);
        assertFiltering(filter, dir, false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.magicNumberFileFilter(xmlMagicNumber);
        assertFiltering(filter, classFileA, false);
        assertFiltering(filter, xmlFileB, true);
        assertFiltering(filter, dir, false);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void t() throws java.lang.Exception {
        final java.lang.String tarMagicNumber = "ustar";
        final long tarMagicNumberOffset = 257;
        final java.io.File tarFileA = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "A.tar");
        final java.io.File randomFileB = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "B.txt");
        final java.io.File dir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "D");
        dir.mkdirs();
        final java.io.OutputStream tarFileAStream = org.apache.commons.io.FileUtils.openOutputStream(tarFileA);
        generateTestData(tarFileAStream, tarMagicNumberOffset);
        org.apache.commons.io.IOUtils.write(tarMagicNumber, tarFileAStream, org.apache.commons.io.Charsets.UTF_8);
        tarFileAStream.close();
        createFile(randomFileB, (2 * tarMagicNumberOffset));
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.MagicNumberFileFilter(tarMagicNumber , tarMagicNumberOffset);
        assertFiltering(filter, tarFileA, true);
        assertFiltering(filter, randomFileB, false);
        assertFiltering(filter, dir, false);
        filter = org.apache.commons.io.filefilter.FileFilterUtils.magicNumberFileFilter(tarMagicNumber, tarMagicNumberOffset);
        assertFiltering(filter, tarFileA, true);
        assertFiltering(filter, randomFileB, false);
        assertFiltering(filter, dir, false);
    }

    public void u() {
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter(((java.lang.String)(null)) , 0);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter("0" , -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter("" , 0);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter(((byte[])(null)) , 0);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter(new byte[]{ 0 } , -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.MagicNumberFileFilter(new byte[]{  } , 0);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
    }

    public void g() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.io.File[] filtered = org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, fileA, fileB);
        junit.framework.TestCase.assertEquals(1, filtered.length);
        junit.framework.TestCase.assertEquals(fileA, filtered[0]);
    }

    public void i() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final java.util.List<java.io.File> fileList = java.util.Arrays.asList(fileA, fileB);
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.io.File[] filtered = org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, fileList);
        junit.framework.TestCase.assertEquals(1, filtered.length);
        junit.framework.TestCase.assertEquals(fileA, filtered[0]);
    }

    public void h() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filter(null, fileA, fileB);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, fileA, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final java.io.File[] filtered = org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, ((java.io.File[])(null)));
        junit.framework.TestCase.assertEquals(0, filtered.length);
    }

    public void j() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final java.util.List<java.io.File> fileList = java.util.Arrays.asList(fileA, fileB);
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.util.List<java.io.File> filteredList = org.apache.commons.io.filefilter.FileFilterUtils.filterList(filter, fileList);
        junit.framework.TestCase.assertTrue(filteredList.contains(fileA));
        junit.framework.TestCase.assertFalse(filteredList.contains(fileB));
    }

    public void l() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.util.List<java.io.File> filteredList = org.apache.commons.io.filefilter.FileFilterUtils.filterList(filter, fileA, fileB);
        junit.framework.TestCase.assertTrue(filteredList.contains(fileA));
        junit.framework.TestCase.assertFalse(filteredList.contains(fileB));
    }

    public void k() {
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filterList(null, java.util.Collections.<java.io.File>emptyList());
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filterList(filter, java.util.Arrays.asList(((java.io.File)(null))));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final java.util.List<java.io.File> filteredList = org.apache.commons.io.filefilter.FileFilterUtils.filterList(filter, ((java.util.List<java.io.File>)(null)));
        junit.framework.TestCase.assertEquals(0, filteredList.size());
    }

    public void m() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final java.util.Set<java.io.File> fileList = new java.util.HashSet<java.io.File>(java.util.Arrays.asList(fileA, fileB));
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.util.Set<java.io.File> filteredSet = org.apache.commons.io.filefilter.FileFilterUtils.filterSet(filter, fileList);
        junit.framework.TestCase.assertTrue(filteredSet.contains(fileA));
        junit.framework.TestCase.assertFalse(filteredSet.contains(fileB));
    }

    public void o() throws java.lang.Exception {
        final java.io.File fileA = newFile("A");
        final java.io.File fileB = newFile("B");
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("A");
        final java.util.Set<java.io.File> filteredSet = org.apache.commons.io.filefilter.FileFilterUtils.filterSet(filter, fileA, fileB);
        junit.framework.TestCase.assertTrue(filteredSet.contains(fileA));
        junit.framework.TestCase.assertFalse(filteredSet.contains(fileB));
    }

    public void n() {
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filterSet(null, java.util.Collections.<java.io.File>emptySet());
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.trueFileFilter();
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.filterSet(filter, new java.util.HashSet<java.io.File>(java.util.Arrays.asList(((java.io.File)(null)))));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        final java.util.Set<java.io.File> filteredSet = org.apache.commons.io.filefilter.FileFilterUtils.filterSet(filter, ((java.util.Set<java.io.File>)(null)));
        junit.framework.TestCase.assertEquals(0, filteredSet.size());
    }

    public void b() {
        junit.framework.TestCase.assertNotNull(new org.apache.commons.io.filefilter.FileFilterUtils());
    }

    public void ae() {
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.toList(((org.apache.commons.io.filefilter.IOFileFilter)(null)));
            junit.framework.TestCase.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.filefilter.FileFilterUtils.toList(new org.apache.commons.io.filefilter.IOFileFilter[]{ null });
            junit.framework.TestCase.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void testCopyDirectoryToItself() throws java.lang.Exception {
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.WildcardFilter("*.txt");
        final java.util.List<java.lang.String> patternList = java.util.Arrays.asList("*.txt", "*.xml", "*.gif");
        final org.apache.commons.io.filefilter.IOFileFilter listFilter = new org.apache.commons.io.filefilter.WildcardFilter(patternList);
        final java.io.File txtFile = new java.io.File("test.txt");
        final java.io.File bmpFile = new java.io.File("test.bmp");
        final java.io.File dir = new java.io.File("src/java");
        assertFiltering(filter, new java.io.File("log.txt"), true);
        filter = new org.apache.commons.io.filefilter.WildcardFilter("log?.txt");
        assertFiltering(filter, new java.io.File("log1.txt"), true);
        assertFiltering(filter, new java.io.File("log12.txt"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFilter("open??.????04");
        assertFiltering(filter, new java.io.File("openAB.102504"), true);
        assertFiltering(filter, new java.io.File("openA.102504"), false);
        assertFiltering(filter, new java.io.File("openXY.123103"), false);
        filter = new org.apache.commons.io.filefilter.WildcardFilter(new java.lang.String[]{ "*.java" , "*.class" });
        assertFiltering(filter, new java.io.File("Test.java"), true);
        assertFiltering(filter, new java.io.File("Test.class"), true);
        assertFiltering(filter, new java.io.File("Test.jsp"), false);
        assertFiltering(listFilter, new java.io.File("Test.txt"), true);
        assertFiltering(listFilter, new java.io.File("Test.xml"), true);
        assertFiltering(listFilter, new java.io.File("Test.gif"), true);
        assertFiltering(listFilter, new java.io.File("Test.bmp"), false);
        junit.framework.TestCase.assertTrue(listFilter.accept(txtFile));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(bmpFile)));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(dir)));
        junit.framework.TestCase.assertTrue(listFilter.accept(txtFile.getParentFile(), txtFile.getName()));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(bmpFile.getParentFile(), bmpFile.getName())));
        junit.framework.TestCase.assertTrue(!(listFilter.accept(dir.getParentFile(), dir.getName())));
        try {
            new org.apache.commons.io.filefilter.WildcardFilter(((java.lang.String)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.WildcardFilter(((java.lang.String[])(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.WildcardFilter(((java.util.List<java.lang.String>)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.OrFileFilter orFilter = new org.apache.commons.io.filefilter.OrFileFilter();
        final java.io.File testFile = new java.io.File("test.txt");
        org.apache.commons.io.filefilter.IOFileFilter filter = new org.apache.commons.io.filefilter.DelegateFileFilter(((java.io.FileFilter)(orFilter)));
        assertFiltering(filter, testFile, false);
        junit.framework.TestCase.assertNotNull(filter.toString());
        filter = new org.apache.commons.io.filefilter.DelegateFileFilter(((java.io.FilenameFilter)(orFilter)));
        assertFiltering(filter, testFile, false);
        junit.framework.TestCase.assertNotNull(filter.toString());
        try {
            new org.apache.commons.io.filefilter.DelegateFileFilter(((java.io.FileFilter)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
        try {
            new org.apache.commons.io.filefilter.DelegateFileFilter(((java.io.FilenameFilter)(null)));
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException iae) {
        }
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.IOFileFilter trueFilter = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE;
        final org.apache.commons.io.filefilter.IOFileFilter falseFilter = org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE;
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(trueFilter , trueFilter), new java.io.File("foo.test"), true);
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(trueFilter , falseFilter), new java.io.File("foo.test"), false);
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(falseFilter , trueFilter), new java.io.File("foo.test"), false);
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(falseFilter , falseFilter), new java.io.File("foo.test"), false);
        final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(filters), new java.io.File("test"), false);
        assertFiltering(new org.apache.commons.io.filefilter.AndFileFilter(), new java.io.File("test"), false);
        try {
            new org.apache.commons.io.filefilter.AndFileFilter(falseFilter , null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            new org.apache.commons.io.filefilter.AndFileFilter(null , falseFilter);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        final org.apache.commons.io.filefilter.AndFileFilter f = new org.apache.commons.io.filefilter.AndFileFilter(null);
        junit.framework.TestCase.assertTrue(f.getFileFilters().isEmpty());
        junit.framework.TestCase.assertNotNull(f.toString());
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final java.io.File oldFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "old.txt");
        final java.io.File reference = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "reference.txt");
        final java.io.File newFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "new.txt");
        createFile(oldFile, 0);
        do {
            try {
                java.lang.Thread.sleep(1000);
            } catch (final java.lang.InterruptedException ie) {
            }
            createFile(reference, 0);
        } while ((oldFile.lastModified()) == (reference.lastModified()) );
        final java.util.Date date = new java.util.Date();
        final long now = date.getTime();
        do {
            try {
                java.lang.Thread.sleep(1000);
            } catch (final java.lang.InterruptedException ie) {
            }
            createFile(newFile, 0);
        } while ((reference.lastModified()) == (newFile.lastModified()) );
        final org.apache.commons.io.filefilter.IOFileFilter filter1 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(now);
        final org.apache.commons.io.filefilter.IOFileFilter filter2 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(now, true);
        final org.apache.commons.io.filefilter.IOFileFilter filter3 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(now, false);
        final org.apache.commons.io.filefilter.IOFileFilter filter4 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(date);
        final org.apache.commons.io.filefilter.IOFileFilter filter5 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(date, true);
        final org.apache.commons.io.filefilter.IOFileFilter filter6 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(date, false);
        final org.apache.commons.io.filefilter.IOFileFilter filter7 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(reference);
        final org.apache.commons.io.filefilter.IOFileFilter filter8 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(reference, true);
        final org.apache.commons.io.filefilter.IOFileFilter filter9 = org.apache.commons.io.filefilter.FileFilterUtils.ageFileFilter(reference, false);
        assertFiltering(filter1, oldFile, true);
        assertFiltering(filter2, oldFile, true);
        assertFiltering(filter3, oldFile, false);
        assertFiltering(filter4, oldFile, true);
        assertFiltering(filter5, oldFile, true);
        assertFiltering(filter6, oldFile, false);
        assertFiltering(filter7, oldFile, true);
        assertFiltering(filter8, oldFile, true);
        assertFiltering(filter9, oldFile, false);
        assertFiltering(filter1, newFile, false);
        assertFiltering(filter2, newFile, false);
        assertFiltering(filter3, newFile, true);
        assertFiltering(filter4, newFile, false);
        assertFiltering(filter5, newFile, false);
        assertFiltering(filter6, newFile, true);
        assertFiltering(filter7, newFile, false);
        assertFiltering(filter8, newFile, false);
        assertFiltering(filter9, newFile, true);
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final java.io.File readOnlyFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "read-only-file1.txt");
        createFile(readOnlyFile, 32);
        readOnlyFile.setReadOnly();
        assertFiltering(org.apache.commons.io.filefilter.CanReadFileFilter.CAN_READ, readOnlyFile, true);
        assertFiltering(org.apache.commons.io.filefilter.CanReadFileFilter.CANNOT_READ, readOnlyFile, false);
        assertFiltering(org.apache.commons.io.filefilter.CanReadFileFilter.READ_ONLY, readOnlyFile, true);
        readOnlyFile.delete();
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        final java.io.File readOnlyFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "read-only-file2.txt");
        createFile(readOnlyFile, 32);
        readOnlyFile.setReadOnly();
        assertFiltering(org.apache.commons.io.filefilter.CanWriteFileFilter.CAN_WRITE, org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), true);
        assertFiltering(org.apache.commons.io.filefilter.CanWriteFileFilter.CANNOT_WRITE, org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), false);
        assertFiltering(org.apache.commons.io.filefilter.CanWriteFileFilter.CAN_WRITE, readOnlyFile, false);
        assertFiltering(org.apache.commons.io.filefilter.CanWriteFileFilter.CANNOT_WRITE, readOnlyFile, true);
        readOnlyFile.delete();
    }

    public void testCopyDirectoryToItself() {
        junit.framework.TestCase.assertNotNull(org.apache.commons.io.filefilter.FileFilterUtils.asFileFilter(((java.io.FileFilter)(org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE))));
        junit.framework.TestCase.assertNotNull(org.apache.commons.io.filefilter.FileFilterUtils.asFileFilter(((java.io.FilenameFilter)(org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE))).toString());
    }
}

