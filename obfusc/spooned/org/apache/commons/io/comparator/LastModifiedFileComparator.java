package org.apache.commons.io.comparator;


public class LastModifiedFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 7372168004395734046L;

    public static final java.util.Comparator<java.io.File> LASTMODIFIED_COMPARATOR = new org.apache.commons.io.comparator.LastModifiedFileComparator();

    public static final java.util.Comparator<java.io.File> LASTMODIFIED_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(LASTMODIFIED_COMPARATOR);

    public int a(final java.io.File file1, final java.io.File file2) {
        final long result = (file1.lastModified()) - (file2.lastModified());
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

