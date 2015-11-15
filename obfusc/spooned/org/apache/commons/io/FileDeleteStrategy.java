package org.apache.commons.io;


public class FileDeleteStrategy {
    public static final org.apache.commons.io.FileDeleteStrategy NORMAL = new org.apache.commons.io.FileDeleteStrategy("Normal");

    public static final org.apache.commons.io.FileDeleteStrategy FORCE = new org.apache.commons.io.FileDeleteStrategy.ForceFileDeleteStrategy();

    private final java.lang.String name;

    protected FileDeleteStrategy(final java.lang.String name) {
        this.name = name;
    }

    public boolean a(final java.io.File fileToDelete) {
        if ((fileToDelete == null) || ((fileToDelete.exists()) == false)) {
            return true;
        } 
        try {
            return doDelete(fileToDelete);
        } catch (final java.io.IOException ex) {
            return false;
        }
    }

    public void c(final java.io.File fileToDelete) throws java.io.IOException {
        if ((fileToDelete.exists()) && ((doDelete(fileToDelete)) == false)) {
            throw new java.io.IOException(("Deletion failed: " + fileToDelete));
        } 
    }

    protected boolean b(final java.io.File fileToDelete) throws java.io.IOException {
        return fileToDelete.delete();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ("FileDeleteStrategy[" + (name)) + "]";
    }

    static class ForceFileDeleteStrategy extends org.apache.commons.io.FileDeleteStrategy {
        ForceFileDeleteStrategy() {
            super("Force");
        }

        @java.lang.Override
        protected boolean b(final java.io.File fileToDelete) throws java.io.IOException {
            org.apache.commons.io.FileUtils.forceDelete(fileToDelete);
            return true;
        }
    }
}

