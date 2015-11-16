package org.apache.commons.io.comparator;


public class PathFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public PathFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.PathFileComparator.PATH_COMPARATOR));
        reverse = org.apache.commons.io.comparator.PathFileComparator.PATH_REVERSE;
        equalFile1 = new java.io.File("foo/file.txt");
        equalFile2 = new java.io.File("foo/file.txt");
        lessFile = new java.io.File("abc/file.txt");
        moreFile = new java.io.File("xyz/file.txt");
    }

    public void h() {
        final java.io.File file3 = new java.io.File("FOO/file.txt");
        final java.util.Comparator<java.io.File> sensitive = new org.apache.commons.io.comparator.PathFileComparator(null);
        junit.framework.TestCase.assertTrue("sensitive file1 & file2 = 0", ((sensitive.compare(equalFile1, equalFile2)) == 0));
        junit.framework.TestCase.assertTrue("sensitive file1 & file3 > 0", ((sensitive.compare(equalFile1, file3)) > 0));
        junit.framework.TestCase.assertTrue("sensitive file1 & less  > 0", ((sensitive.compare(equalFile1, lessFile)) > 0));
        final java.util.Comparator<java.io.File> insensitive = org.apache.commons.io.comparator.PathFileComparator.PATH_INSENSITIVE_COMPARATOR;
        junit.framework.TestCase.assertTrue("insensitive file1 & file2 = 0", ((insensitive.compare(equalFile1, equalFile2)) == 0));
        junit.framework.TestCase.assertTrue("insensitive file1 & file3 = 0", ((insensitive.compare(equalFile1, file3)) == 0));
        junit.framework.TestCase.assertTrue("insensitive file1 & file4 > 0", ((insensitive.compare(equalFile1, lessFile)) > 0));
        junit.framework.TestCase.assertTrue("insensitive file3 & less  > 0", ((insensitive.compare(file3, lessFile)) > 0));
    }
}

