package org.apache.commons.io.filefilter;


public class OrFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable , org.apache.commons.io.filefilter.ConditionalFileFilter {
    private static final long serialVersionUID = 5767770777065432721L;

    private final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> fileFilters;

    public OrFileFilter() {
        this.fileFilters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
    }

    public OrFileFilter(final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> fileFilters) {
        if (fileFilters == null) {
            this.fileFilters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
        } else {
            this.fileFilters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>(fileFilters);
        }
    }

    public OrFileFilter(final org.apache.commons.io.filefilter.IOFileFilter filter1 ,final org.apache.commons.io.filefilter.IOFileFilter filter2) {
        if ((filter1 == null) || (filter2 == null)) {
            throw new java.lang.IllegalArgumentException("The filters must not be null");
        } 
        this.fileFilters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>(2);
        addFileFilter(filter1);
        addFileFilter(filter2);
    }

    public void toString(final org.apache.commons.io.filefilter.IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
    }

    public java.util.List<org.apache.commons.io.filefilter.IOFileFilter> removeFileFilter() {
        return java.util.Collections.unmodifiableList(this.fileFilters);
    }

    public boolean a(final org.apache.commons.io.filefilter.IOFileFilter ioFileFilter) {
        return this.fileFilters.remove(ioFileFilter);
    }

    public void removeFileFilter(final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        for (final org.apache.commons.io.filefilter.IOFileFilter fileFilter : fileFilters) {
            if (fileFilter.accept(file)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file, final java.lang.String name) {
        for (final org.apache.commons.io.filefilter.IOFileFilter fileFilter : fileFilters) {
            if (fileFilter.accept(file, name)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if ((fileFilters) != null) {
            for (int i = 0 ; i < (fileFilters.size()) ; i++) {
                if (i > 0) {
                    buffer.append(",");
                } 
                final java.lang.Object filter = fileFilters.get(i);
                buffer.append((filter == null ? "null" : filter.toString()));
            }
        } 
        buffer.append(")");
        return buffer.toString();
    }
}

