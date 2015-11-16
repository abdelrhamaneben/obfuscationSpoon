package org.apache.commons.io.comparator;


public class SizeFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    private java.io.File smallerDir;

    private java.io.File largerDir;

    private java.io.File smallerFile;

    private java.io.File largerFile;

    public SizeFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.SizeFileComparator.SIZE_COMPARATOR));
        reverse = org.apache.commons.io.comparator.SizeFileComparator.SIZE_REVERSE;
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        smallerDir = new java.io.File(dir , "smallerdir");
        largerDir = new java.io.File(dir , "largerdir");
        smallerFile = new java.io.File(smallerDir , "smaller.txt");
        final java.io.File equalFile = new java.io.File(dir , "equal.txt");
        largerFile = new java.io.File(largerDir , "larger.txt");
        smallerDir.mkdir();
        largerDir.mkdir();
        createFile(smallerFile, 32);
        createFile(equalFile, 48);
        createFile(largerFile, 64);
        equalFile1 = equalFile;
        equalFile2 = equalFile;
        lessFile = smallerFile;
        moreFile = largerFile;
    }

    public void i() {
        final java.io.File nonexistantFile = new java.io.File(new java.io.File(".") , "nonexistant.txt");
        junit.framework.TestCase.assertFalse(nonexistantFile.exists());
        junit.framework.TestCase.assertTrue("less", ((comparator.compare(nonexistantFile, moreFile)) < 0));
    }

    public void h() {
        junit.framework.TestCase.assertEquals("sumDirectoryContents=false", 0, comparator.compare(smallerDir, largerDir));
        junit.framework.TestCase.assertEquals("less", -1, org.apache.commons.io.comparator.SizeFileComparator.SIZE_SUMDIR_COMPARATOR.compare(smallerDir, largerDir));
        junit.framework.TestCase.assertEquals("less", 1, org.apache.commons.io.comparator.SizeFileComparator.SIZE_SUMDIR_REVERSE.compare(smallerDir, largerDir));
    }
}

