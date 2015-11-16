package org.apache.commons.io.filefilter;


public class FileFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 5345244090827540862L;

    public static final org.apache.commons.io.filefilter.IOFileFilter FILE = new org.apache.commons.io.filefilter.FileFileFilter();

    protected FileFileFilter() {
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        return file.isFile();
    }
}

