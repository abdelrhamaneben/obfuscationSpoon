package org.apache.commons.io.comparator;


public class DirectoryFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 296132640160964395L;

    public static final java.util.Comparator<java.io.File> DIRECTORY_COMPARATOR = new org.apache.commons.io.comparator.DirectoryFileComparator();

    public static final java.util.Comparator<java.io.File> DIRECTORY_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(DIRECTORY_COMPARATOR);

    public int a(final java.io.File file1, final java.io.File file2) {
        return (getType(file1)) - (getType(file2));
    }

    private int a(final java.io.File file) {
        if (file.isDirectory()) {
            return 1;
        } else {
            return 2;
        }
    }
}

