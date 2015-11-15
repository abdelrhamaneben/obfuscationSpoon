package org.apache.commons.io.comparator;


public class DefaultFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public DefaultFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.DefaultFileComparator.DEFAULT_COMPARATOR));
        reverse = org.apache.commons.io.comparator.DefaultFileComparator.DEFAULT_REVERSE;
        equalFile1 = new java.io.File("foo");
        equalFile2 = new java.io.File("foo");
        lessFile = new java.io.File("abc");
        moreFile = new java.io.File("xyz");
    }
}

