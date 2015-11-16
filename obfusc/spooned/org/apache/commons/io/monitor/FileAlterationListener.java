package org.apache.commons.io.monitor;


public interface FileAlterationListener {
    void onDirectoryChange(final org.apache.commons.io.monitor.FileAlterationObserver observer);

    void onDirectoryChange(final java.io.File directory);

    void onDirectoryCreate(final java.io.File directory);

    void onDirectoryDelete(final java.io.File directory);

    void onFileDelete(final java.io.File file);

    void onFileCreate(final java.io.File file);

    void onFileChange(final java.io.File file);

    void onDirectoryDelete(final org.apache.commons.io.monitor.FileAlterationObserver observer);
}

