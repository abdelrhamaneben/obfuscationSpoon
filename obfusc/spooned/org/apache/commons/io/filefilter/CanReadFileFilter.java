package org.apache.commons.io.filefilter;


public class CanReadFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 3179904805251622989L;

    public static final org.apache.commons.io.filefilter.IOFileFilter CAN_READ = new org.apache.commons.io.filefilter.CanReadFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter CANNOT_READ = new org.apache.commons.io.filefilter.NotFileFilter(CAN_READ);

    public static final org.apache.commons.io.filefilter.IOFileFilter READ_ONLY = new org.apache.commons.io.filefilter.AndFileFilter(CAN_READ , org.apache.commons.io.filefilter.CanWriteFileFilter.CANNOT_WRITE);

    protected CanReadFileFilter() {
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        return file.canRead();
    }
}

