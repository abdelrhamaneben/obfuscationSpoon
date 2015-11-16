package org.apache.commons.io.comparator;


public class SizeFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = -1201561106411416190L;

    public static final java.util.Comparator<java.io.File> SIZE_COMPARATOR = new org.apache.commons.io.comparator.SizeFileComparator();

    public static final java.util.Comparator<java.io.File> SIZE_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(SIZE_COMPARATOR);

    public static final java.util.Comparator<java.io.File> SIZE_SUMDIR_COMPARATOR = new org.apache.commons.io.comparator.SizeFileComparator(true);

    public static final java.util.Comparator<java.io.File> SIZE_SUMDIR_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(SIZE_SUMDIR_COMPARATOR);

    private final boolean sumDirectoryContents;

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    public SizeFileComparator(final boolean sumDirectoryContents) {
        this.sumDirectoryContents = sumDirectoryContents;
    }

    public int compare(final java.io.File file1, final java.io.File file2) {
        long size1 = 0;
        if (file1.isDirectory()) {
            size1 = (sumDirectoryContents) && (file1.exists()) ? org.apache.commons.io.FileUtils.sizeOfDirectory(file1) : 0;
        } else {
            size1 = file1.length();
        }
        long size2 = 0;
        if (file2.isDirectory()) {
            size2 = (sumDirectoryContents) && (file2.exists()) ? org.apache.commons.io.FileUtils.sizeOfDirectory(file2) : 0;
        } else {
            size2 = file2.length();
        }
        final long result = size1 - size2;
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "[sumDirectoryContents=") + (sumDirectoryContents)) + "]";
    }
}

