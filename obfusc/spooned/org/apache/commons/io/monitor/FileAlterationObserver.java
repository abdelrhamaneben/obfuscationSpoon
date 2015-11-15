package org.apache.commons.io.monitor;


public class FileAlterationObserver implements java.io.Serializable {
    private static final long serialVersionUID = 1185122225658782848L;

    private final java.util.List<org.apache.commons.io.monitor.FileAlterationListener> listeners = new java.util.concurrent.CopyOnWriteArrayList<org.apache.commons.io.monitor.FileAlterationListener>();

    private final org.apache.commons.io.monitor.FileEntry rootEntry;

    private final java.io.FileFilter fileFilter;

    private final java.util.Comparator<java.io.File> comparator;

    public FileAlterationObserver(final java.lang.String directoryName) {
        this(new java.io.File(directoryName));
    }

    public FileAlterationObserver(final java.lang.String directoryName ,final java.io.FileFilter fileFilter) {
        this(new java.io.File(directoryName), fileFilter);
    }

    public FileAlterationObserver(final java.lang.String directoryName ,final java.io.FileFilter fileFilter ,final org.apache.commons.io.IOCase caseSensitivity) {
        this(new java.io.File(directoryName), fileFilter, caseSensitivity);
    }

    public FileAlterationObserver(final java.io.File directory) {
        this(directory, null);
    }

    public FileAlterationObserver(final java.io.File directory ,final java.io.FileFilter fileFilter) {
        this(directory, fileFilter, null);
    }

    public FileAlterationObserver(final java.io.File directory ,final java.io.FileFilter fileFilter ,final org.apache.commons.io.IOCase caseSensitivity) {
        this(new org.apache.commons.io.monitor.FileEntry(directory), fileFilter, caseSensitivity);
    }

    protected FileAlterationObserver(final org.apache.commons.io.monitor.FileEntry rootEntry ,final java.io.FileFilter fileFilter ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (rootEntry == null) {
            throw new java.lang.IllegalArgumentException("Root entry is missing");
        } 
        if ((rootEntry.getFile()) == null) {
            throw new java.lang.IllegalArgumentException("Root directory is missing");
        } 
        this.rootEntry = rootEntry;
        this.fileFilter = fileFilter;
        if ((caseSensitivity == null) || (caseSensitivity.equals(org.apache.commons.io.IOCase.SYSTEM))) {
            this.comparator = org.apache.commons.io.comparator.NameFileComparator.NAME_SYSTEM_COMPARATOR;
        } else if (caseSensitivity.equals(org.apache.commons.io.IOCase.INSENSITIVE)) {
            this.comparator = org.apache.commons.io.comparator.NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        } else {
            this.comparator = org.apache.commons.io.comparator.NameFileComparator.NAME_COMPARATOR;
        }
    }

    public java.io.File a() {
        return rootEntry.getFile();
    }

    public java.io.FileFilter b() {
        return fileFilter;
    }

    public void a(final org.apache.commons.io.monitor.FileAlterationListener listener) {
        if (listener != null) {
            listeners.add(listener);
        } 
    }

    public void b(final org.apache.commons.io.monitor.FileAlterationListener listener) {
        if (listener != null) {
            while (listeners.remove(listener)) {
            }
        } 
    }

    public java.lang.Iterable<org.apache.commons.io.monitor.FileAlterationListener> c() {
        return listeners;
    }

    public void f() throws java.lang.Exception {
        rootEntry.refresh(rootEntry.getFile());
        final org.apache.commons.io.monitor.FileEntry[] children = doListFiles(rootEntry.getFile(), rootEntry);
        rootEntry.setChildren(children);
    }

    public void e() throws java.lang.Exception {
    }

    public void d() {
        for (final org.apache.commons.io.monitor.FileAlterationListener listener : listeners) {
            listener.onStart(this);
        }
        final java.io.File rootFile = rootEntry.getFile();
        if (rootFile.exists()) {
            checkAndNotify(rootEntry, rootEntry.getChildren(), listFiles(rootFile));
        } else if (rootEntry.isExists()) {
            checkAndNotify(rootEntry, rootEntry.getChildren(), org.apache.commons.io.FileUtils.EMPTY_FILE_ARRAY);
        } else {
        }
        for (final org.apache.commons.io.monitor.FileAlterationListener listener : listeners) {
            listener.onStop(this);
        }
    }

    private void a(final org.apache.commons.io.monitor.FileEntry parent, final org.apache.commons.io.monitor.FileEntry[] previous, final java.io.File[] files) {
        int c = 0;
        final org.apache.commons.io.monitor.FileEntry[] current = (files.length) > 0 ? new org.apache.commons.io.monitor.FileEntry[files.length] : org.apache.commons.io.monitor.FileEntry.EMPTY_ENTRIES;
        for (final org.apache.commons.io.monitor.FileEntry entry : previous) {
            while ((c < (files.length)) && ((comparator.compare(entry.getFile(), files[c])) > 0)) {
                current[c] = createFileEntry(parent, files[c]);
                doCreate(current[c]);
                c++;
            }
            if ((c < (files.length)) && ((comparator.compare(entry.getFile(), files[c])) == 0)) {
                doMatch(entry, files[c]);
                checkAndNotify(entry, entry.getChildren(), listFiles(files[c]));
                current[c] = entry;
                c++;
            } else {
                checkAndNotify(entry, entry.getChildren(), org.apache.commons.io.FileUtils.EMPTY_FILE_ARRAY);
                doDelete(entry);
            }
        }
        for ( ; c < (files.length) ; c++) {
            current[c] = createFileEntry(parent, files[c]);
            doCreate(current[c]);
        }
        parent.setChildren(current);
    }

    private org.apache.commons.io.monitor.FileEntry a(final org.apache.commons.io.monitor.FileEntry parent, final java.io.File file) {
        final org.apache.commons.io.monitor.FileEntry entry = parent.newChildInstance(file);
        entry.refresh(file);
        final org.apache.commons.io.monitor.FileEntry[] children = doListFiles(file, entry);
        entry.setChildren(children);
        return entry;
    }

    private org.apache.commons.io.monitor.FileEntry[] a(java.io.File file, org.apache.commons.io.monitor.FileEntry entry) {
        final java.io.File[] files = listFiles(file);
        final org.apache.commons.io.monitor.FileEntry[] children = (files.length) > 0 ? new org.apache.commons.io.monitor.FileEntry[files.length] : org.apache.commons.io.monitor.FileEntry.EMPTY_ENTRIES;
        for (int i = 0 ; i < (files.length) ; i++) {
            children[i] = createFileEntry(entry, files[i]);
        }
        return children;
    }

    private void a(final org.apache.commons.io.monitor.FileEntry entry) {
        for (final org.apache.commons.io.monitor.FileAlterationListener listener : listeners) {
            if (entry.isDirectory()) {
                listener.onDirectoryCreate(entry.getFile());
            } else {
                listener.onFileCreate(entry.getFile());
            }
        }
        final org.apache.commons.io.monitor.FileEntry[] children = entry.getChildren();
        for (final org.apache.commons.io.monitor.FileEntry aChildren : children) {
            doCreate(aChildren);
        }
    }

    private void b(final org.apache.commons.io.monitor.FileEntry entry, final java.io.File file) {
        if (entry.refresh(file)) {
            for (final org.apache.commons.io.monitor.FileAlterationListener listener : listeners) {
                if (entry.isDirectory()) {
                    listener.onDirectoryChange(file);
                } else {
                    listener.onFileChange(file);
                }
            }
        } 
    }

    private void b(final org.apache.commons.io.monitor.FileEntry entry) {
        for (final org.apache.commons.io.monitor.FileAlterationListener listener : listeners) {
            if (entry.isDirectory()) {
                listener.onDirectoryDelete(entry.getFile());
            } else {
                listener.onFileDelete(entry.getFile());
            }
        }
    }

    private java.io.File[] a(final java.io.File file) {
        java.io.File[] children = null;
        if (file.isDirectory()) {
            children = (fileFilter) == null ? file.listFiles() : file.listFiles(fileFilter);
        } 
        if (children == null) {
            children = org.apache.commons.io.FileUtils.EMPTY_FILE_ARRAY;
        } 
        if (((comparator) != null) && ((children.length) > 1)) {
            java.util.Arrays.sort(children, comparator);
        } 
        return children;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append("[file=\'");
        builder.append(getDirectory().getPath());
        builder.append('\'');
        if ((fileFilter) != null) {
            builder.append(", ");
            builder.append(fileFilter.toString());
        } 
        builder.append(", listeners=");
        builder.append(listeners.size());
        builder.append("]");
        return builder.toString();
    }
}

