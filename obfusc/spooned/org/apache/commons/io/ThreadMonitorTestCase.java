package org.apache.commons.io;


public class ThreadMonitorTestCase extends junit.framework.TestCase {
    public ThreadMonitorTestCase(final java.lang.String name) {
        super(name);
    }

    public void c() {
        try {
            final java.lang.Thread monitor = org.apache.commons.io.ThreadMonitor.start(100);
            java.lang.Thread.sleep(200);
            org.apache.commons.io.ThreadMonitor.stop(monitor);
            junit.framework.TestCase.fail("Expected InterruptedException");
        } catch (final java.lang.InterruptedException e) {
        }
    }

    public void a() {
        try {
            final java.lang.Thread monitor = org.apache.commons.io.ThreadMonitor.start(200);
            java.lang.Thread.sleep(100);
            org.apache.commons.io.ThreadMonitor.stop(monitor);
        } catch (final java.lang.InterruptedException e) {
            junit.framework.TestCase.fail("Timed Out");
        }
    }

    public void b() {
        try {
            final java.lang.Thread monitor = org.apache.commons.io.ThreadMonitor.start(-1);
            junit.framework.TestCase.assertNull("Timeout -1, Monitor should be null", monitor);
            java.lang.Thread.sleep(100);
            org.apache.commons.io.ThreadMonitor.stop(monitor);
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Timeout -1, threw " + e));
        }
        try {
            final java.lang.Thread monitor = org.apache.commons.io.ThreadMonitor.start(0);
            junit.framework.TestCase.assertNull("Timeout 0, Monitor should be null", monitor);
            java.lang.Thread.sleep(100);
            org.apache.commons.io.ThreadMonitor.stop(monitor);
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Timeout 0, threw " + e));
        }
    }
}

