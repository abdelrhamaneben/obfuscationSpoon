package org.apache.commons.io.filefilter;


public class HiddenFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 8930842316112759062L;

    public static final org.apache.commons.io.filefilter.IOFileFilter HIDDEN = new org.apache.commons.io.filefilter.HiddenFileFilter();

    public static final org.apache.commons.io.filefilter.IOFileFilter VISIBLE = new org.apache.commons.io.filefilter.NotFileFilter(HIDDEN);

    protected HiddenFileFilter() {
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        return file.isHidden();
    }
}

