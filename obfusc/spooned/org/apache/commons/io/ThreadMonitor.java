package org.apache.commons.io;


class ThreadMonitor implements java.lang.Runnable {
    private final java.lang.Thread thread;

    private final long timeout;

    public static java.lang.Thread a(final long timeout) {
        return org.apache.commons.io.ThreadMonitor.start(java.lang.Thread.currentThread(), timeout);
    }

    public static java.lang.Thread a(final java.lang.Thread thread, final long timeout) {
        java.lang.Thread monitor = null;
        if (timeout > 0) {
            final org.apache.commons.io.ThreadMonitor timout = new org.apache.commons.io.ThreadMonitor(thread , timeout);
            monitor = new java.lang.Thread(timout , org.apache.commons.io.ThreadMonitor.class.getSimpleName());
            monitor.setDaemon(true);
            monitor.start();
        } 
        return monitor;
    }

    public static void a(final java.lang.Thread thread) {
        if (thread != null) {
            thread.interrupt();
        } 
    }

    private ThreadMonitor(final java.lang.Thread thread ,final long timeout) {
        this.thread = thread;
        this.timeout = timeout;
    }

    public void a() {
        try {
            java.lang.Thread.sleep(timeout);
            thread.interrupt();
        } catch (final java.lang.InterruptedException e) {
        }
    }
}

