package org.apache.commons.io.comparator;


public abstract class ComparatorAbstractTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    protected org.apache.commons.io.comparator.AbstractFileComparator comparator;

    protected java.util.Comparator<java.io.File> reverse;

    protected java.io.File equalFile1;

    protected java.io.File equalFile2;

    protected java.io.File lessFile;

    protected java.io.File moreFile;

    public ComparatorAbstractTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.DefaultFileComparator.DEFAULT_COMPARATOR));
        reverse = org.apache.commons.io.comparator.DefaultFileComparator.DEFAULT_REVERSE;
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        comparator = null;
        reverse = null;
        equalFile1 = null;
        equalFile2 = null;
        lessFile = null;
        moreFile = null;
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    public void a() {
        junit.framework.TestCase.assertEquals("equal", 0, comparator.compare(equalFile1, equalFile2));
        junit.framework.TestCase.assertTrue("less", ((comparator.compare(lessFile, moreFile)) < 0));
        junit.framework.TestCase.assertTrue("more", ((comparator.compare(moreFile, lessFile)) > 0));
    }

    public void b() {
        junit.framework.TestCase.assertEquals("equal", 0, reverse.compare(equalFile1, equalFile2));
        junit.framework.TestCase.assertTrue("less", ((reverse.compare(moreFile, lessFile)) < 0));
        junit.framework.TestCase.assertTrue("more", ((reverse.compare(lessFile, moreFile)) > 0));
    }

    public void d() {
        junit.framework.TestCase.assertNull(comparator.sort(((java.io.File[])(null))));
    }

    public void c() {
        final java.io.File[] files = new java.io.File[3];
        files[0] = equalFile1;
        files[1] = moreFile;
        files[2] = lessFile;
        comparator.sort(files);
        junit.framework.TestCase.assertSame("equal", lessFile, files[0]);
        junit.framework.TestCase.assertSame("less", equalFile1, files[1]);
        junit.framework.TestCase.assertSame("more", moreFile, files[2]);
    }

    public void e() {
        final java.util.List<java.io.File> files = new java.util.ArrayList<java.io.File>();
        files.add(equalFile1);
        files.add(moreFile);
        files.add(lessFile);
        comparator.sort(files);
        junit.framework.TestCase.assertSame("equal", lessFile, files.get(0));
        junit.framework.TestCase.assertSame("less", equalFile1, files.get(1));
        junit.framework.TestCase.assertSame("more", moreFile, files.get(2));
    }

    public void f() {
        junit.framework.TestCase.assertNull(comparator.sort(((java.util.List<java.io.File>)(null))));
    }

    public void g() {
        junit.framework.TestCase.assertNotNull("comparator", comparator.toString());
        junit.framework.TestCase.assertTrue("reverse", reverse.toString().startsWith("ReverseComparator["));
    }
}

