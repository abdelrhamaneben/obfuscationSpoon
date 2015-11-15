package org.apache.commons.io.filefilter;


public class FalseFileFilter implements java.io.Serializable , org.apache.commons.io.filefilter.IOFileFilter {
    private static final long serialVersionUID = 6210271677940926200L;

    public static final org.apache.commons.io.filefilter.IOFileFilter FALSE = new org.apache.commons.io.filefilter.FalseFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter INSTANCE = FALSE;

    protected FalseFileFilter() {
    }

    public boolean a(final java.io.File file) {
        return false;
    }

    public boolean a(final java.io.File dir, final java.lang.String name) {
        return false;
    }
}

