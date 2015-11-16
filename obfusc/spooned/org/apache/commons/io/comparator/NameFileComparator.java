package org.apache.commons.io.comparator;


public class NameFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 8397947749814525798L;

    public static final java.util.Comparator<java.io.File> NAME_COMPARATOR = new org.apache.commons.io.comparator.NameFileComparator();

    public static final java.util.Comparator<java.io.File> NAME_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(NAME_COMPARATOR);

    public static final java.util.Comparator<java.io.File> NAME_INSENSITIVE_COMPARATOR = new org.apache.commons.io.comparator.NameFileComparator(org.apache.commons.io.IOCase.INSENSITIVE);

    public static final java.util.Comparator<java.io.File> NAME_INSENSITIVE_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(NAME_INSENSITIVE_COMPARATOR);

    public static final java.util.Comparator<java.io.File> NAME_SYSTEM_COMPARATOR = new org.apache.commons.io.comparator.NameFileComparator(org.apache.commons.io.IOCase.SYSTEM);

    public static final java.util.Comparator<java.io.File> NAME_SYSTEM_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(NAME_SYSTEM_COMPARATOR);

    private final org.apache.commons.io.IOCase caseSensitivity;

    public NameFileComparator() {
        this.caseSensitivity = org.apache.commons.io.IOCase.SENSITIVE;
    }

    public NameFileComparator(final org.apache.commons.io.IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public int compare(final java.io.File file1, final java.io.File file2) {
        return caseSensitivity.checkCompareTo(file1.getName(), file2.getName());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "[caseSensitivity=") + (caseSensitivity)) + "]";
    }
}

