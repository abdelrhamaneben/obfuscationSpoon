package org.apache.commons.io.comparator;


public class ExtensionFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = 1928235200184222815L;

    public static final java.util.Comparator<java.io.File> EXTENSION_COMPARATOR = new org.apache.commons.io.comparator.ExtensionFileComparator();

    public static final java.util.Comparator<java.io.File> EXTENSION_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(EXTENSION_COMPARATOR);

    public static final java.util.Comparator<java.io.File> EXTENSION_INSENSITIVE_COMPARATOR = new org.apache.commons.io.comparator.ExtensionFileComparator(org.apache.commons.io.IOCase.INSENSITIVE);

    public static final java.util.Comparator<java.io.File> EXTENSION_INSENSITIVE_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(EXTENSION_INSENSITIVE_COMPARATOR);

    public static final java.util.Comparator<java.io.File> EXTENSION_SYSTEM_COMPARATOR = new org.apache.commons.io.comparator.ExtensionFileComparator(org.apache.commons.io.IOCase.SYSTEM);

    public static final java.util.Comparator<java.io.File> EXTENSION_SYSTEM_REVERSE = new org.apache.commons.io.comparator.ReverseComparator(EXTENSION_SYSTEM_COMPARATOR);

    private final org.apache.commons.io.IOCase caseSensitivity;

    public ExtensionFileComparator() {
        this.caseSensitivity = org.apache.commons.io.IOCase.SENSITIVE;
    }

    public ExtensionFileComparator(final org.apache.commons.io.IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public int a(final java.io.File file1, final java.io.File file2) {
        final java.lang.String suffix1 = org.apache.commons.io.FilenameUtils.getExtension(file1.getName());
        final java.lang.String suffix2 = org.apache.commons.io.FilenameUtils.getExtension(file2.getName());
        return caseSensitivity.checkCompareTo(suffix1, suffix2);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "[caseSensitivity=") + (caseSensitivity)) + "]";
    }
}

