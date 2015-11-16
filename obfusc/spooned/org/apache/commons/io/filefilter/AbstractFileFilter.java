package org.apache.commons.io.filefilter;


public abstract class AbstractFileFilter implements org.apache.commons.io.filefilter.IOFileFilter {
    public boolean removeFileFilter(final java.io.File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public boolean removeFileFilter(final java.io.File dir, final java.lang.String name) {
        return accept(new java.io.File(dir , name));
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getClass().getSimpleName();
    }
}

