package org.apache.commons.io.filefilter;


public class TrueFileFilter implements java.io.Serializable , org.apache.commons.io.filefilter.IOFileFilter {
    private static final long serialVersionUID = 8782512160909720199L;

    public static final org.apache.commons.io.filefilter.IOFileFilter TRUE = new org.apache.commons.io.filefilter.TrueFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter INSTANCE = TRUE;

    protected TrueFileFilter() {
    }

    public boolean a(final java.io.File file) {
        return true;
    }

    public boolean a(final java.io.File dir, final java.lang.String name) {
        return true;
    }
}

