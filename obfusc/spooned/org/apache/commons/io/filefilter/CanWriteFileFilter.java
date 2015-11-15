package org.apache.commons.io.filefilter;


public class CanWriteFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 5132005214688990379L;

    public static final org.apache.commons.io.filefilter.IOFileFilter CAN_WRITE = new org.apache.commons.io.filefilter.CanWriteFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter CANNOT_WRITE = new org.apache.commons.io.filefilter.NotFileFilter(CAN_WRITE);

    protected CanWriteFileFilter() {
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        return file.canWrite();
    }
}

