package org.apache.commons.io.monitor;


public class CollectionFileListener implements java.io.Serializable , org.apache.commons.io.monitor.FileAlterationListener {
    private static final long serialVersionUID = 939724715678693963L;

    private final boolean clearOnStart;

    private final java.util.Collection<java.io.File> createdFiles = new java.util.ArrayList<java.io.File>();

    private final java.util.Collection<java.io.File> changedFiles = new java.util.ArrayList<java.io.File>();

    private final java.util.Collection<java.io.File> deletedFiles = new java.util.ArrayList<java.io.File>();

    private final java.util.Collection<java.io.File> createdDirectories = new java.util.ArrayList<java.io.File>();

    private final java.util.Collection<java.io.File> changedDirectories = new java.util.ArrayList<java.io.File>();

    private final java.util.Collection<java.io.File> deletedDirectories = new java.util.ArrayList<java.io.File>();

    public CollectionFileListener(final boolean clearOnStart) {
        this.clearOnStart = clearOnStart;
    }

    public void onDirectoryChange(final org.apache.commons.io.monitor.FileAlterationObserver observer) {
        if (clearOnStart) {
            clear();
        } 
    }

    public void onFileChange() {
        createdFiles.clear();
        changedFiles.clear();
        deletedFiles.clear();
        createdDirectories.clear();
        changedDirectories.clear();
        deletedDirectories.clear();
    }

    public java.util.Collection<java.io.File> onDirectoryChange() {
        return changedDirectories;
    }

    public java.util.Collection<java.io.File> onDirectoryChange() {
        return changedFiles;
    }

    public java.util.Collection<java.io.File> onDirectoryDelete() {
        return createdDirectories;
    }

    public java.util.Collection<java.io.File> onDirectoryChange() {
        return createdFiles;
    }

    public java.util.Collection<java.io.File> onFileChange() {
        return deletedDirectories;
    }

    public java.util.Collection<java.io.File> onFileChange() {
        return deletedFiles;
    }

    public void onDirectoryDelete(final java.io.File directory) {
        createdDirectories.add(directory);
    }

    public void onDirectoryChange(final java.io.File directory) {
        changedDirectories.add(directory);
    }

    public void a(final java.io.File directory) {
        deletedDirectories.add(directory);
    }

    public void c(final java.io.File file) {
        createdFiles.add(file);
    }

    public void b(final java.io.File file) {
        changedFiles.add(file);
    }

    public void d(final java.io.File file) {
        deletedFiles.add(file);
    }

    public void a(final org.apache.commons.io.monitor.FileAlterationObserver observer) {
    }
}

