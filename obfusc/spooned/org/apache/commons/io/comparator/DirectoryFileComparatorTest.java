package org.apache.commons.io.comparator;


public class DirectoryFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public DirectoryFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.DirectoryFileComparator.DIRECTORY_COMPARATOR));
        reverse = org.apache.commons.io.comparator.DirectoryFileComparator.DIRECTORY_REVERSE;
        final java.io.File currentDir = new java.io.File(".");
        equalFile1 = new java.io.File(currentDir , "src");
        equalFile2 = new java.io.File(currentDir , "src/site/xdoc");
        lessFile = new java.io.File(currentDir , "src");
        moreFile = new java.io.File(currentDir , "pom.xml");
    }

    @java.lang.Override
    public void createLineBasedFile() {
    }

    @java.lang.Override
    public void generateTestData() {
    }
}

