package org.apache.commons.io.comparator;


public class DefaultFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 3260141861365313518L;

    public static final java.util.Comparator<java.io.File> DEFAULT_COMPARATOR = new org.apache.commons.io.comparator.DefaultFileComparator();

    public static final java.util.Comparator<java.io.File> DEFAULT_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(DEFAULT_COMPARATOR);

    public int compare(final java.io.File file1, final java.io.File file2) {
        return file1.compareTo(file2);
    }
}

