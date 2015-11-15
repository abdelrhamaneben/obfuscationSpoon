package org.apache.commons.io.monitor;


public final class FileAlterationMonitor implements java.lang.Runnable {
    private final long interval;

    private final java.util.List<org.apache.commons.io.monitor.FileAlterationObserver> observers = new java.util.concurrent.CopyOnWriteArrayList<org.apache.commons.io.monitor.FileAlterationObserver>();

    private java.lang.Thread thread = null;

    private java.util.concurrent.ThreadFactory threadFactory;

    private volatile boolean running = false;

    public FileAlterationMonitor() {
        this(10000);
    }

    public FileAlterationMonitor(final long interval) {
        this.interval = interval;
    }

    public FileAlterationMonitor(final long interval ,final org.apache.commons.io.monitor.FileAlterationObserver... observers) {
        this(interval);
        if (observers != null) {
            for (final org.apache.commons.io.monitor.FileAlterationObserver observer : observers) {
                addObserver(observer);
            }
        } 
    }

    public long b() {
        return interval;
    }

    public synchronized void a(final java.util.concurrent.ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void a(final org.apache.commons.io.monitor.FileAlterationObserver observer) {
        if (observer != null) {
            observers.add(observer);
        } 
    }

    public void b(final org.apache.commons.io.monitor.FileAlterationObserver observer) {
        if (observer != null) {
            while (observers.remove(observer)) {
            }
        } 
    }

    public java.lang.Iterable<org.apache.commons.io.monitor.FileAlterationObserver> a() {
        return observers;
    }

    public synchronized void d() throws java.lang.Exception {
        if (running) {
            throw new java.lang.IllegalStateException("Monitor is already running");
        } 
        for (final org.apache.commons.io.monitor.FileAlterationObserver observer : observers) {
            observer.initialize();
        }
        running = true;
        if ((threadFactory) != null) {
            thread = threadFactory.newThread(this);
        } else {
            thread = new java.lang.Thread(this);
        }
        thread.start();
    }

    public synchronized void e() throws java.lang.Exception {
        stop(interval);
    }

    public synchronized void a(final long stopInterval) throws java.lang.Exception {
        if ((running) == false) {
            throw new java.lang.IllegalStateException("Monitor is not running");
        } 
        running = false;
        try {
            thread.join(stopInterval);
        } catch (final java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
        }
        for (final org.apache.commons.io.monitor.FileAlterationObserver observer : observers) {
            observer.destroy();
        }
    }

    public void c() {
        while (running) {
            for (final org.apache.commons.io.monitor.FileAlterationObserver observer : observers) {
                observer.checkAndNotify();
            }
            if (!(running)) {
                break;
            } 
            try {
                java.lang.Thread.sleep(interval);
            } catch (final java.lang.InterruptedException ignored) {
            }
        }
    }
}

