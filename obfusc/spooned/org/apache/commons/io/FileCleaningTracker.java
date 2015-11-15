package org.apache.commons.io;


public class FileCleaningTracker {
    java.lang.ref.ReferenceQueue<java.lang.Object> q = new java.lang.ref.ReferenceQueue<java.lang.Object>();

    final java.util.Collection<org.apache.commons.io.FileCleaningTracker.Tracker> trackers = java.util.Collections.synchronizedSet(new java.util.HashSet<org.apache.commons.io.FileCleaningTracker.Tracker>());

    final java.util.List<java.lang.String> deleteFailures = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.String>());

    volatile boolean exitWhenFinished = false;

    java.lang.Thread reaper;

    public void a(final java.io.File file, final java.lang.Object marker) {
        track(file, marker, null);
    }

    public void a(final java.io.File file, final java.lang.Object marker, final org.apache.commons.io.FileDeleteStrategy deleteStrategy) {
        if (file == null) {
            throw new java.lang.NullPointerException("The file must not be null");
        } 
        addTracker(file.getPath(), marker, deleteStrategy);
    }

    public void a(final java.lang.String path, final java.lang.Object marker) {
        track(path, marker, null);
    }

    public void b(final java.lang.String path, final java.lang.Object marker, final org.apache.commons.io.FileDeleteStrategy deleteStrategy) {
        if (path == null) {
            throw new java.lang.NullPointerException("The path must not be null");
        } 
        addTracker(path, marker, deleteStrategy);
    }

    private synchronized void a(final java.lang.String path, final java.lang.Object marker, final org.apache.commons.io.FileDeleteStrategy deleteStrategy) {
        if (exitWhenFinished) {
            throw new java.lang.IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        } 
        if ((reaper) == null) {
            reaper = new Reaper();
            reaper.start();
        } 
        trackers.add(new org.apache.commons.io.FileCleaningTracker.Tracker(path , deleteStrategy , marker , q));
    }

    public int a() {
        return trackers.size();
    }

    public java.util.List<java.lang.String> b() {
        return deleteFailures;
    }

    public synchronized void c() {
        exitWhenFinished = true;
        if ((reaper) != null) {
            synchronized(reaper) {
                reaper.interrupt();
            }
        } 
    }

    private final class Reaper extends java.lang.Thread {
        Reaper() {
            super("File Reaper");
            setPriority(java.lang.Thread.MAX_PRIORITY);
            setDaemon(true);
        }

        @java.lang.Override
        public void run() {
            while (((exitWhenFinished) == false) || ((trackers.size()) > 0)) {
                try {
                    final org.apache.commons.io.FileCleaningTracker.Tracker tracker = ((org.apache.commons.io.FileCleaningTracker.Tracker)(q.remove()));
                    trackers.remove(tracker);
                    if (!(tracker.delete())) {
                        deleteFailures.add(tracker.getPath());
                    } 
                    tracker.clear();
                } catch (final java.lang.InterruptedException e) {
                    continue;
                }
            }
        }
    }

    private static final class Tracker extends java.lang.ref.PhantomReference<java.lang.Object> {
        private final java.lang.String path;

        private final org.apache.commons.io.FileDeleteStrategy deleteStrategy;

        Tracker(final java.lang.String path ,final org.apache.commons.io.FileDeleteStrategy deleteStrategy ,final java.lang.Object marker ,final java.lang.ref.ReferenceQueue<?> queue) {
            super(marker, queue);
            this.path = path;
            this.deleteStrategy = deleteStrategy == null ? org.apache.commons.io.FileDeleteStrategy.NORMAL : deleteStrategy;
        }

        public java.lang.String b() {
            return path;
        }

        public boolean a() {
            return deleteStrategy.deleteQuietly(new java.io.File(path));
        }
    }
}

