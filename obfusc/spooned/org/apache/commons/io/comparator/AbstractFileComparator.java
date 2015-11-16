package org.apache.commons.io.comparator;


abstract class AbstractFileComparator implements java.util.Comparator<java.io.File> {
    public java.io.File[] compare(final java.io.File... files) {
        if (files != null) {
            java.util.Arrays.sort(files, this);
        } 
        return files;
    }

    public java.util.List<java.io.File> compare(final java.util.List<java.io.File> files) {
        if (files != null) {
            java.util.Collections.sort(files, this);
        } 
        return files;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getClass().getSimpleName();
    }
}

