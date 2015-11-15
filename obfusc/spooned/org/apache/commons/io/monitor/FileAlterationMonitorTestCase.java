package org.apache.commons.io.monitor;


public class FileAlterationMonitorTestCase extends org.apache.commons.io.monitor.AbstractMonitorTestCase {
    public FileAlterationMonitorTestCase(final java.lang.String name) {
        super(name);
        testDirName = "test-monitor";
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        listener = new org.apache.commons.io.monitor.CollectionFileListener(false);
        super.setUp();
    }

    public void b() {
        final org.apache.commons.io.monitor.FileAlterationMonitor monitor = new org.apache.commons.io.monitor.FileAlterationMonitor();
        junit.framework.TestCase.assertEquals("Interval", 10000, monitor.getInterval());
    }

    public void a() {
        org.apache.commons.io.monitor.FileAlterationObserver[] observers = null;
        org.apache.commons.io.monitor.FileAlterationMonitor monitor = null;
        monitor = new org.apache.commons.io.monitor.FileAlterationMonitor(123 , observers);
        junit.framework.TestCase.assertEquals("Interval", 123, monitor.getInterval());
        junit.framework.TestCase.assertFalse("Observers[1]", monitor.getObservers().iterator().hasNext());
        observers = new org.apache.commons.io.monitor.FileAlterationObserver[1];
        monitor = new org.apache.commons.io.monitor.FileAlterationMonitor(456 , observers);
        junit.framework.TestCase.assertFalse("Observers[2]", monitor.getObservers().iterator().hasNext());
        monitor.addObserver(null);
        junit.framework.TestCase.assertFalse("Observers[3]", monitor.getObservers().iterator().hasNext());
        monitor.removeObserver(null);
        final org.apache.commons.io.monitor.FileAlterationObserver observer = new org.apache.commons.io.monitor.FileAlterationObserver("foo");
        monitor.addObserver(observer);
        final java.util.Iterator<org.apache.commons.io.monitor.FileAlterationObserver> it = monitor.getObservers().iterator();
        junit.framework.TestCase.assertTrue("Observers[4]", it.hasNext());
        junit.framework.TestCase.assertEquals("Added", observer, it.next());
        junit.framework.TestCase.assertFalse("Observers[5]", it.hasNext());
        monitor.removeObserver(observer);
        junit.framework.TestCase.assertFalse("Observers[6]", monitor.getObservers().iterator().hasNext());
    }

    public void c() {
        try {
            final long interval = 100;
            listener.clear();
            final org.apache.commons.io.monitor.FileAlterationMonitor monitor = new org.apache.commons.io.monitor.FileAlterationMonitor(interval , observer);
            junit.framework.TestCase.assertEquals("Interval", interval, monitor.getInterval());
            monitor.start();
            try {
                monitor.start();
            } catch (final java.lang.IllegalStateException e) {
            }
            checkCollectionsEmpty("A");
            java.io.File file1 = touch(new java.io.File(testDir , "file1.java"));
            checkFile("Create", file1, listener.getCreatedFiles());
            listener.clear();
            checkCollectionsEmpty("B");
            file1 = touch(file1);
            checkFile("Update", file1, listener.getChangedFiles());
            listener.clear();
            checkCollectionsEmpty("C");
            file1.delete();
            checkFile("Delete", file1, listener.getDeletedFiles());
            listener.clear();
            monitor.stop();
            try {
                monitor.stop();
            } catch (final java.lang.IllegalStateException e) {
            }
        } catch (final java.lang.Exception e) {
            e.printStackTrace();
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    public void d() {
        try {
            final long interval = 100;
            listener.clear();
            final org.apache.commons.io.monitor.FileAlterationMonitor monitor = new org.apache.commons.io.monitor.FileAlterationMonitor(interval , observer);
            monitor.setThreadFactory(java.util.concurrent.Executors.defaultThreadFactory());
            junit.framework.TestCase.assertEquals("Interval", interval, monitor.getInterval());
            monitor.start();
            checkCollectionsEmpty("A");
            final java.io.File file2 = touch(new java.io.File(testDir , "file2.java"));
            checkFile("Create", file2, listener.getCreatedFiles());
            listener.clear();
            checkCollectionsEmpty("B");
            file2.delete();
            checkFile("Delete", file2, listener.getDeletedFiles());
            listener.clear();
            monitor.stop();
        } catch (final java.lang.Exception e) {
            e.printStackTrace();
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    private void a(final java.lang.String label, final java.io.File file, final java.util.Collection<java.io.File> files) {
        for (int i = 0 ; i < 20 ; i++) {
            if (files.contains(file)) {
                return ;
            } 
            sleepHandleInterruped(pauseTime);
        }
        junit.framework.TestCase.fail((((label + " ") + file) + " not found"));
    }
}

