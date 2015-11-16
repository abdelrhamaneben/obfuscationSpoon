package org.apache.commons.io.filefilter;


public interface ConditionalFileFilter {
    void a(org.apache.commons.io.filefilter.IOFileFilter ioFileFilter);

    java.util.List<org.apache.commons.io.filefilter.IOFileFilter> setFileFilters();

    boolean removeFileFilter(org.apache.commons.io.filefilter.IOFileFilter ioFileFilter);

    void a(java.util.List<org.apache.commons.io.filefilter.IOFileFilter> fileFilters);
}

