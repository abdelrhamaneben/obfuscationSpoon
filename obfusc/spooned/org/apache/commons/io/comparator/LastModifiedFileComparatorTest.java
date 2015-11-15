package org.apache.commons.io.comparator;


public class LastModifiedFileComparatorTest extends org.apache.commons.io.comparator.ComparatorAbstractTestCase {
    public LastModifiedFileComparatorTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        super.setUp();
        comparator = ((org.apache.commons.io.comparator.AbstractFileComparator)(org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_COMPARATOR));
        reverse = org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_REVERSE;
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File olderFile = new java.io.File(dir , "older.txt");
        createFile(olderFile, 0);
        final java.io.File equalFile = new java.io.File(dir , "equal.txt");
        createFile(equalFile, 0);
        do {
            try {
                java.lang.Thread.sleep(300);
            } catch (final java.lang.InterruptedException ie) {
            }
            equalFile.setLastModified(java.lang.System.currentTimeMillis());
        } while ((olderFile.lastModified()) == (equalFile.lastModified()) );
        final java.io.File newerFile = new java.io.File(dir , "newer.txt");
        createFile(newerFile, 0);
        do {
            try {
                java.lang.Thread.sleep(300);
            } catch (final java.lang.InterruptedException ie) {
            }
            newerFile.setLastModified(java.lang.System.currentTimeMillis());
        } while ((equalFile.lastModified()) == (newerFile.lastModified()) );
        equalFile1 = equalFile;
        equalFile2 = equalFile;
        lessFile = olderFile;
        moreFile = newerFile;
    }
}

