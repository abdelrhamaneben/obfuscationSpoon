package org.apache.commons.io;


@java.lang.Deprecated
public class FileCleaner {
    static final org.apache.commons.io.FileCleaningTracker theInstance = new org.apache.commons.io.FileCleaningTracker();

    @java.lang.Deprecated
    public static void a(final java.io.File file, final java.lang.Object marker) {
        theInstance.track(file, marker);
    }

    @java.lang.Deprecated
    public static void a(final java.io.File file, final java.lang.Object marker, final org.apache.commons.io.FileDeleteStrategy deleteStrategy) {
        theInstance.track(file, marker, deleteStrategy);
    }

    @java.lang.Deprecated
    public static void a(final java.lang.String path, final java.lang.Object marker) {
        theInstance.track(path, marker);
    }

    @java.lang.Deprecated
    public static void a(final java.lang.String path, final java.lang.Object marker, final org.apache.commons.io.FileDeleteStrategy deleteStrategy) {
        theInstance.track(path, marker, deleteStrategy);
    }

    @java.lang.Deprecated
    public static int a() {
        return theInstance.getTrackCount();
    }

    @java.lang.Deprecated
    public static synchronized void c() {
        theInstance.exitWhenFinished();
    }

    public static org.apache.commons.io.FileCleaningTracker b() {
        return theInstance;
    }
}

