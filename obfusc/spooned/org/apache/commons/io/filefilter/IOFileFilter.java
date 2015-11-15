package org.apache.commons.io.filefilter;


public interface IOFileFilter extends java.io.FileFilter , java.io.FilenameFilter {
    boolean a(java.io.File file);

    boolean a(java.io.File dir, java.lang.String name);
}

