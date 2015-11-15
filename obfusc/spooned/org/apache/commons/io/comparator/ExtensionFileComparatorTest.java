package org.apache.commons.io.comparator;


public class ExtensionFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public ExtensionFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.ExtensionFileComparator.EXTENSION_COMPARATOR));
        reverse = org.apache.commons.io.comparator.ExtensionFileComparator.EXTENSION_REVERSE;
        equalFile1 = new java.io.File("abc.foo");
        equalFile2 = new java.io.File("def.foo");
        lessFile = new java.io.File("abc.abc");
        moreFile = new java.io.File("abc.xyz");
    }

    public void a() {
        final java.io.File file3 = new java.io.File("abc.FOO");
        final java.util.Comparator<java.io.File> sensitive = new org.apache.commons.io.comparator.ExtensionFileComparator(null);
        junit.framework.TestCase.assertTrue("sensitive file1 & file2 = 0", ((sensitive.compare(equalFile1, equalFile2)) == 0));
        junit.framework.TestCase.assertTrue("sensitive file1 & file3 > 0", ((sensitive.compare(equalFile1, file3)) > 0));
        junit.framework.TestCase.assertTrue("sensitive file1 & less  > 0", ((sensitive.compare(equalFile1, lessFile)) > 0));
        final java.util.Comparator<java.io.File> insensitive = org.apache.commons.io.comparator.ExtensionFileComparator.EXTENSION_INSENSITIVE_COMPARATOR;
        junit.framework.TestCase.assertTrue("insensitive file1 & file2 = 0", ((insensitive.compare(equalFile1, equalFile2)) == 0));
        junit.framework.TestCase.assertTrue("insensitive file1 & file3 = 0", ((insensitive.compare(equalFile1, file3)) == 0));
        junit.framework.TestCase.assertTrue("insensitive file1 & file4 > 0", ((insensitive.compare(equalFile1, lessFile)) > 0));
        junit.framework.TestCase.assertTrue("insensitive file3 & less  > 0", ((insensitive.compare(file3, lessFile)) > 0));
    }
}

