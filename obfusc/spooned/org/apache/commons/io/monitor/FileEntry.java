package org.apache.commons.io.monitor;


public class FileEntry implements java.io.Serializable {
    private static final long serialVersionUID = -2505664948818681153L;

    static final org.apache.commons.io.monitor.FileEntry[] EMPTY_ENTRIES = new org.apache.commons.io.monitor.FileEntry[0];

    private final org.apache.commons.io.monitor.FileEntry parent;

    private org.apache.commons.io.monitor.FileEntry[] children;

    private final java.io.File file;

    private java.lang.String name;

    private boolean exists;

    private boolean directory;

    private long lastModified;

    private long length;

    public FileEntry(final java.io.File file) {
        this(null, file);
    }

    public FileEntry(final org.apache.commons.io.monitor.FileEntry parent ,final java.io.File file) {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("File is missing");
        } 
        this.file = file;
        this.parent = parent;
        this.name = file.getName();
    }

    public boolean a(final java.io.File file) {
        final boolean origExists = exists;
        final long origLastModified = lastModified;
        final boolean origDirectory = directory;
        final long origLength = length;
        name = file.getName();
        exists = file.exists();
        directory = (exists) && (file.isDirectory());
        lastModified = exists ? file.lastModified() : 0;
        length = (exists) && (!(directory)) ? file.length() : 0;
        return ((((exists) != origExists) || ((lastModified) != origLastModified)) || ((directory) != origDirectory)) || ((length) != origLength);
    }

    public org.apache.commons.io.monitor.FileEntry b(final java.io.File file) {
        return new org.apache.commons.io.monitor.FileEntry(this , file);
    }

    public org.apache.commons.io.monitor.FileEntry h() {
        return parent;
    }

    public int c() {
        return (parent) == null ? 0 : (parent.getLevel()) + 1;
    }

    public org.apache.commons.io.monitor.FileEntry[] i() {
        return (children) != null ? children : EMPTY_ENTRIES;
    }

    public void a(final org.apache.commons.io.monitor.FileEntry[] children) {
        this.children = children;
    }

    public java.io.File d() {
        return file;
    }

    public java.lang.String e() {
        return name;
    }

    public void a(final java.lang.String name) {
        this.name = name;
    }

    public long f() {
        return lastModified;
    }

    public void a(final long lastModified) {
        this.lastModified = lastModified;
    }

    public long g() {
        return length;
    }

    public void b(final long length) {
        this.length = length;
    }

    public boolean b() {
        return exists;
    }

    public void b(final boolean exists) {
        this.exists = exists;
    }

    public boolean a() {
        return directory;
    }

    public void a(final boolean directory) {
        this.directory = directory;
    }
}

