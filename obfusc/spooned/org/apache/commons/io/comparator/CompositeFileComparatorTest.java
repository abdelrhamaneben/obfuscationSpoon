package org.apache.commons.io.comparator;


public class CompositeFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public CompositeFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = new org.apache.commons.io.comparator.CompositeFileComparator(new org.apache.commons.io.comparator.AbstractFileComparator[]{ ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.SizeFileComparator.SIZE_COMPARATOR)) , ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.ExtensionFileComparator.EXTENSION_COMPARATOR)) });
        reverse = new org.apache.commons.io.comparator.ReverseComparator(comparator);
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        lessFile = new java.io.File(dir , "xyz.txt");
        equalFile1 = new java.io.File(dir , "foo.txt");
        equalFile2 = new java.io.File(dir , "bar.txt");
        moreFile = new java.io.File(dir , "foo.xyz");
        createFile(lessFile, 32);
        createFile(equalFile1, 48);
        createFile(equalFile2, 48);
        createFile(moreFile, 48);
    }

    public void b() {
        final java.util.List<java.util.Comparator<java.io.File>> list = new java.util.ArrayList<java.util.Comparator<java.io.File>>();
        list.add(org.apache.commons.io.comparator.SizeFileComparator.SIZE_COMPARATOR);
        list.add(org.apache.commons.io.comparator.ExtensionFileComparator.EXTENSION_COMPARATOR);
        final java.util.Comparator<java.io.File> c = new org.apache.commons.io.comparator.CompositeFileComparator(list);
        junit.framework.TestCase.assertEquals("equal", 0, c.compare(equalFile1, equalFile2));
        junit.framework.TestCase.assertTrue("less", ((c.compare(lessFile, moreFile)) < 0));
        junit.framework.TestCase.assertTrue("more", ((c.compare(moreFile, lessFile)) > 0));
    }

    public void c() {
        final java.util.Comparator<java.io.File> c = new org.apache.commons.io.comparator.CompositeFileComparator(((java.lang.Iterable<java.util.Comparator<java.io.File>>)(null)));
        junit.framework.TestCase.assertEquals("less,more", 0, c.compare(lessFile, moreFile));
        junit.framework.TestCase.assertEquals("more,less", 0, c.compare(moreFile, lessFile));
        junit.framework.TestCase.assertEquals("toString", "CompositeFileComparator{}", c.toString());
    }

    public void a() {
        final java.util.Comparator<java.io.File> c = new org.apache.commons.io.comparator.CompositeFileComparator(((java.util.Comparator<java.io.File>[])(null)));
        junit.framework.TestCase.assertEquals("less,more", 0, c.compare(lessFile, moreFile));
        junit.framework.TestCase.assertEquals("more,less", 0, c.compare(moreFile, lessFile));
        junit.framework.TestCase.assertEquals("toString", "CompositeFileComparator{}", c.toString());
    }
}

