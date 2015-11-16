package org.apache.commons.io;


public abstract class DirectoryWalker<T> {
    private final java.io.FileFilter filter;

    private final int depthLimit;

    protected DirectoryWalker() {
        this(null, -1);
    }

    protected DirectoryWalker(final java.io.FileFilter filter ,final int depthLimit) {
        this.filter = filter;
        this.depthLimit = depthLimit;
    }

    protected DirectoryWalker(org.apache.commons.io.filefilter.IOFileFilter directoryFilter ,org.apache.commons.io.filefilter.IOFileFilter fileFilter ,final int depthLimit) {
        if ((directoryFilter == null) && (fileFilter == null)) {
            this.filter = null;
        } else {
            directoryFilter = directoryFilter != null ? directoryFilter : org.apache.commons.io.filefilter.TrueFileFilter.TRUE;
            fileFilter = fileFilter != null ? fileFilter : org.apache.commons.io.filefilter.TrueFileFilter.TRUE;
            directoryFilter = org.apache.commons.io.filefilter.FileFilterUtils.makeDirectoryOnly(directoryFilter);
            fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.makeFileOnly(fileFilter);
            this.filter = org.apache.commons.io.filefilter.FileFilterUtils.or(directoryFilter, fileFilter);
        }
        this.depthLimit = depthLimit;
    }

    protected final void b(final java.io.File startDirectory, final java.util.Collection<T> results) throws java.io.IOException {
        if (startDirectory == null) {
            throw new java.lang.NullPointerException("Start Directory is null");
        } 
        try {
            handleStart(startDirectory, results);
            walk(startDirectory, 0, results);
            handleEnd(results);
        } catch (final org.apache.commons.io.DirectoryWalker.CancelException cancel) {
            handleCancelled(startDirectory, results, cancel);
        }
    }

    private void h(final java.io.File directory, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
        checkIfCancelled(directory, depth, results);
        if (handleDirectory(directory, depth, results)) {
            handleDirectoryStart(directory, depth, results);
            final int childDepth = depth + 1;
            if (((depthLimit) < 0) || (childDepth <= (depthLimit))) {
                checkIfCancelled(directory, depth, results);
                java.io.File[] childFiles = (filter) == null ? directory.listFiles() : directory.listFiles(filter);
                childFiles = filterDirectoryContents(directory, depth, childFiles);
                if (childFiles == null) {
                    handleRestricted(directory, childDepth, results);
                } else {
                    for (final java.io.File childFile : childFiles) {
                        if (childFile.isDirectory()) {
                            walk(childFile, childDepth, results);
                        } else {
                            checkIfCancelled(childFile, childDepth, results);
                            handleFile(childFile, childDepth, results);
                            checkIfCancelled(childFile, childDepth, results);
                        }
                    }
                }
            } 
            handleDirectoryEnd(directory, depth, results);
        } 
        checkIfCancelled(directory, depth, results);
    }

    protected final void c(final java.io.File file, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
        if (handleIsCancelled(file, depth, results)) {
            throw new org.apache.commons.io.DirectoryWalker.CancelException(file , depth);
        } 
    }

    protected boolean b(final java.io.File file, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
        return false;
    }

    protected void a(final java.io.File startDirectory, final java.util.Collection<T> results, final org.apache.commons.io.DirectoryWalker.CancelException cancel) throws java.io.IOException {
        throw cancel;
    }

    protected void a(final java.io.File startDirectory, final java.util.Collection<T> results) throws java.io.IOException {
    }

    protected boolean a(final java.io.File directory, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
        return true;
    }

    protected void e(final java.io.File directory, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
    }

    protected java.io.File[] a(final java.io.File directory, final int depth, final java.io.File[] files) throws java.io.IOException {
        return files;
    }

    protected void f(final java.io.File file, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
    }

    protected void g(final java.io.File directory, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
    }

    protected void d(final java.io.File directory, final int depth, final java.util.Collection<T> results) throws java.io.IOException {
    }

    protected void a(final java.util.Collection<T> results) throws java.io.IOException {
    }

    public static class CancelException extends java.io.IOException {
        private static final long serialVersionUID = 1347339620135041008L;

        private final java.io.File file;

        private final int depth;

        public CancelException(final java.io.File file ,final int depth) {
            this("Operation Cancelled", file, depth);
        }

        public CancelException(final java.lang.String message ,final java.io.File file ,final int depth) {
            super(message);
            this.file = file;
            this.depth = depth;
        }

        public java.io.File b() {
            return file;
        }

        public int a() {
            return depth;
        }
    }
}

