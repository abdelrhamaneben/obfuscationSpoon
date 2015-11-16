package org.apache.commons.io.filefilter;


public interface IOFileFilter extends java.io.FileFilter , java.io.FilenameFilter {
    boolean toString(java.io.File file);

    boolean toString(java.io.File dir, java.lang.String name);
}

