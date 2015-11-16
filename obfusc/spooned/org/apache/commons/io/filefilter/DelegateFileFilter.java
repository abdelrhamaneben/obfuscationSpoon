package org.apache.commons.io.filefilter;


public class DelegateFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -8723373124984771318L;

    private final java.io.FilenameFilter filenameFilter;

    private final java.io.FileFilter fileFilter;

    public DelegateFileFilter(final java.io.FilenameFilter filter) {
        if (filter == null) {
            throw new java.lang.IllegalArgumentException("The FilenameFilter must not be null");
        } 
        this.filenameFilter = filter;
        this.fileFilter = null;
    }

    public DelegateFileFilter(final java.io.FileFilter filter) {
        if (filter == null) {
            throw new java.lang.IllegalArgumentException("The FileFilter must not be null");
        } 
        this.fileFilter = filter;
        this.filenameFilter = null;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        if ((fileFilter) != null) {
            return fileFilter.accept(file);
        } else {
            return super.accept(file);
        }
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File dir, final java.lang.String name) {
        if ((filenameFilter) != null) {
            return filenameFilter.accept(dir, name);
        } else {
            return super.accept(dir, name);
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.String delegate = (fileFilter) != null ? fileFilter.toString() : filenameFilter.toString();
        return (((super.toString()) + "(") + delegate) + ")";
    }
}

