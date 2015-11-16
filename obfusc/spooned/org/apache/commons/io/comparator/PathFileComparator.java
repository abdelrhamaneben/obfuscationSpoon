package org.apache.commons.io.comparator;


public class PathFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 6527501707585768673L;

    public static final java.util.Comparator<java.io.File> PATH_COMPARATOR = new org.apache.commons.io.comparator.PathFileComparator();

    public static final java.util.Comparator<java.io.File> PATH_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(PATH_COMPARATOR);

    public static final java.util.Comparator<java.io.File> PATH_INSENSITIVE_COMPARATOR = new org.apache.commons.io.comparator.PathFileComparator(org.apache.commons.io.IOCase.INSENSITIVE);

    public static final java.util.Comparator<java.io.File> PATH_INSENSITIVE_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(PATH_INSENSITIVE_COMPARATOR);

    public static final java.util.Comparator<java.io.File> PATH_SYSTEM_COMPARATOR = new org.apache.commons.io.comparator.PathFileComparator(org.apache.commons.io.IOCase.SYSTEM);

    public static final java.util.Comparator<java.io.File> PATH_SYSTEM_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(PATH_SYSTEM_COMPARATOR);

    private final org.apache.commons.io.IOCase caseSensitivity;

    public PathFileComparator() {
        this.caseSensitivity = org.apache.commons.io.IOCase.SENSITIVE;
    }

    public PathFileComparator(final org.apache.commons.io.IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public int a(final java.io.File file1, final java.io.File file2) {
        return caseSensitivity.checkCompareTo(file1.getPath(), file2.getPath());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "[caseSensitivity=") + (caseSensitivity)) + "]";
    }
}

