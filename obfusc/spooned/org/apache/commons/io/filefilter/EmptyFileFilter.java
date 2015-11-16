package org.apache.commons.io.filefilter;


public class EmptyFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 3631422087512832211L;

    public static final org.apache.commons.io.filefilter.IOFileFilter EMPTY = new org.apache.commons.io.filefilter.EmptyFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter NOT_EMPTY = new org.apache.commons.io.filefilter.NotFileFilter(EMPTY);

    protected EmptyFileFilter() {
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        if (file.isDirectory()) {
            final java.io.File[] files = file.listFiles();
            return (files == null) || ((files.length) == 0);
        } else {
            return (file.length()) == 0;
        }
    }
}

