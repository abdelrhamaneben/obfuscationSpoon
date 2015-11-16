package org.apache.commons.io.filefilter;


public class DirectoryFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -5148237843784525732L;

    public static final org.apache.commons.io.filefilter.IOFileFilter DIRECTORY = new org.apache.commons.io.filefilter.DirectoryFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter INSTANCE = DIRECTORY;

    protected DirectoryFileFilter() {
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        return file.isDirectory();
    }
}

