package org.apache.commons.io;


public class FileUtilsWaitForTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public FileUtilsWaitForTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    public void testCopyDirectoryToItself() {
        org.apache.commons.io.FileUtils.waitFor(new java.io.File(""), -1);
        org.apache.commons.io.FileUtils.waitFor(new java.io.File(""), 2);
    }

    public void testGetPath_with_nullbyte() throws java.lang.InterruptedException {
        final java.util.concurrent.atomic.AtomicBoolean wasInterrupted = new java.util.concurrent.atomic.AtomicBoolean(false);
        final java.util.concurrent.CountDownLatch started = new java.util.concurrent.CountDownLatch(1);
        java.lang.Runnable thread = new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                started.countDown();
                org.apache.commons.io.FileUtils.waitFor(new java.io.File(""), 2);
                wasInterrupted.set(java.lang.Thread.currentThread().isInterrupted());
            }
        };
        java.lang.Thread thread1 = new java.lang.Thread(thread);
        thread1.start();
        started.await();
        thread1.interrupt();
        thread1.join();
        junit.framework.TestCase.assertTrue(wasInterrupted.get());
    }
}

