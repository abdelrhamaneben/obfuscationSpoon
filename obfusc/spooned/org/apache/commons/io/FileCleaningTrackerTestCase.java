package org.apache.commons.io;


public class FileCleaningTrackerTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    protected org.apache.commons.io.FileCleaningTracker b() {
        return new org.apache.commons.io.FileCleaningTracker();
    }

    private java.io.File testFile;

    private org.apache.commons.io.FileCleaningTracker theInstance;

    public FileCleaningTrackerTestCase(final java.lang.String name) {
        super(name);
        testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file-test.txt");
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        theInstance = newInstance();
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        {
            theInstance.q = new java.lang.ref.ReferenceQueue<java.lang.Object>();
            theInstance.trackers.clear();
            theInstance.deleteFailures.clear();
            theInstance.exitWhenFinished = false;
            theInstance.reaper = null;
        }
        theInstance = null;
    }

    public void j() throws java.lang.Exception {
        final java.lang.String path = testFile.getPath();
        junit.framework.TestCase.assertFalse(testFile.exists());
        java.io.RandomAccessFile r = new java.io.RandomAccessFile(testFile , "rw");
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        theInstance.track(path, r);
        junit.framework.TestCase.assertEquals(1, theInstance.getTrackCount());
        r.close();
        testFile = null;
        r = null;
        waitUntilTrackCount();
        pauseForDeleteToComplete(new java.io.File(path));
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertEquals(showFailures(), false, new java.io.File(path).exists());
    }

    public void c() throws java.lang.Exception {
        createFile(testFile, 100);
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().exists());
        java.lang.Object obj = new java.lang.Object();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        theInstance.track(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), obj);
        junit.framework.TestCase.assertEquals(1, theInstance.getTrackCount());
        obj = null;
        waitUntilTrackCount();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertTrue(testFile.getParentFile().exists());
    }

    public void e() throws java.lang.Exception {
        createFile(testFile, 100);
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().exists());
        java.lang.Object obj = new java.lang.Object();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        theInstance.track(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), obj, null);
        junit.framework.TestCase.assertEquals(1, theInstance.getTrackCount());
        obj = null;
        waitUntilTrackCount();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertTrue(testFile.getParentFile().exists());
    }

    public void d() throws java.lang.Exception {
        createFile(testFile, 100);
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().exists());
        java.lang.Object obj = new java.lang.Object();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        theInstance.track(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), obj, org.apache.commons.io.FileDeleteStrategy.FORCE);
        junit.framework.TestCase.assertEquals(1, theInstance.getTrackCount());
        obj = null;
        waitUntilTrackCount();
        pauseForDeleteToComplete(testFile.getParentFile());
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertEquals(showFailures(), false, new java.io.File(testFile.getPath()).exists());
        junit.framework.TestCase.assertEquals(showFailures(), false, testFile.getParentFile().exists());
    }

    public void k() throws java.lang.Exception {
        try {
            theInstance.track(((java.io.File)(null)), new java.lang.Object());
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            theInstance.track(((java.io.File)(null)), new java.lang.Object(), org.apache.commons.io.FileDeleteStrategy.NORMAL);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            theInstance.track(((java.lang.String)(null)), new java.lang.Object());
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            theInstance.track(((java.lang.String)(null)), new java.lang.Object(), org.apache.commons.io.FileDeleteStrategy.NORMAL);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void h() throws java.lang.Exception {
        junit.framework.TestCase.assertFalse(theInstance.exitWhenFinished);
        theInstance.exitWhenFinished();
        junit.framework.TestCase.assertTrue(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals(null, theInstance.reaper);
        waitUntilTrackCount();
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertTrue(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals(null, theInstance.reaper);
    }

    public void i() throws java.lang.Exception {
        junit.framework.TestCase.assertFalse(theInstance.exitWhenFinished);
        theInstance.exitWhenFinished();
        junit.framework.TestCase.assertTrue(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals(null, theInstance.reaper);
        final java.lang.String path = testFile.getPath();
        final java.lang.Object marker = new java.lang.Object();
        try {
            theInstance.track(path, marker);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalStateException ex) {
        }
        junit.framework.TestCase.assertTrue(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals(null, theInstance.reaper);
    }

    public void f() throws java.lang.Exception {
        final java.lang.String path = testFile.getPath();
        junit.framework.TestCase.assertEquals("1-testFile exists", false, testFile.exists());
        java.io.RandomAccessFile r = new java.io.RandomAccessFile(testFile , "rw");
        junit.framework.TestCase.assertEquals("2-testFile exists", true, testFile.exists());
        junit.framework.TestCase.assertEquals("3-Track Count", 0, theInstance.getTrackCount());
        theInstance.track(path, r);
        junit.framework.TestCase.assertEquals("4-Track Count", 1, theInstance.getTrackCount());
        junit.framework.TestCase.assertEquals("5-exitWhenFinished", false, theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals("6-reaper.isAlive", true, theInstance.reaper.isAlive());
        junit.framework.TestCase.assertEquals("7-exitWhenFinished", false, theInstance.exitWhenFinished);
        theInstance.exitWhenFinished();
        junit.framework.TestCase.assertEquals("8-exitWhenFinished", true, theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals("9-reaper.isAlive", true, theInstance.reaper.isAlive());
        r.close();
        testFile = null;
        r = null;
        waitUntilTrackCount();
        pauseForDeleteToComplete(new java.io.File(path));
        junit.framework.TestCase.assertEquals("10-Track Count", 0, theInstance.getTrackCount());
        junit.framework.TestCase.assertEquals(("11-testFile exists " + (showFailures())), false, new java.io.File(path).exists());
        junit.framework.TestCase.assertEquals("12-exitWhenFinished", true, theInstance.exitWhenFinished);
        junit.framework.TestCase.assertEquals("13-reaper.isAlive", false, theInstance.reaper.isAlive());
    }

    public void g() throws java.lang.Exception {
        final java.lang.String path = testFile.getPath();
        junit.framework.TestCase.assertFalse(testFile.exists());
        java.io.RandomAccessFile r = new java.io.RandomAccessFile(testFile , "rw");
        junit.framework.TestCase.assertTrue(testFile.exists());
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        theInstance.track(path, r);
        junit.framework.TestCase.assertEquals(1, theInstance.getTrackCount());
        junit.framework.TestCase.assertFalse(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertTrue(theInstance.reaper.isAlive());
        r.close();
        testFile = null;
        r = null;
        waitUntilTrackCount();
        pauseForDeleteToComplete(new java.io.File(path));
        junit.framework.TestCase.assertEquals(0, theInstance.getTrackCount());
        junit.framework.TestCase.assertEquals(showFailures(), false, new java.io.File(path).exists());
        junit.framework.TestCase.assertFalse(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertTrue(theInstance.reaper.isAlive());
        junit.framework.TestCase.assertFalse(theInstance.exitWhenFinished);
        theInstance.exitWhenFinished();
        for (int i = 0 ; (i < 20) && (theInstance.reaper.isAlive()) ; i++) {
            java.lang.Thread.sleep(500L);
        }
        junit.framework.TestCase.assertTrue(theInstance.exitWhenFinished);
        junit.framework.TestCase.assertFalse(theInstance.reaper.isAlive());
    }

    private void b(java.io.File file) {
        int count = 0;
        while ((file.exists()) && ((count++) < 40)) {
            try {
                java.lang.Thread.sleep(500L);
            } catch (final java.lang.InterruptedException e) {
            }
            file = new java.io.File(file.getPath());
        }
    }

    private java.lang.String a() throws java.lang.Exception {
        if ((theInstance.deleteFailures.size()) == 1) {
            return ("[Delete Failed: " + (theInstance.deleteFailures.get(0))) + "]";
        } else {
            return ("[Delete Failures: " + (theInstance.deleteFailures.size())) + "]";
        }
    }

    private void l() throws java.lang.Exception {
        java.lang.System.gc();
        java.lang.Thread.sleep(500);
        int count = 0;
        while (((theInstance.getTrackCount()) != 0) && ((count++) < 5)) {
            java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
            try {
                long i = 0;
                while ((theInstance.getTrackCount()) != 0) {
                    list.add(("A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String " + (i++)));
                }
            } catch (final java.lang.Throwable ignored) {
            }
            list = null;
            java.lang.System.gc();
            java.lang.Thread.sleep(1000);
        }
        if ((theInstance.getTrackCount()) != 0) {
            throw new java.lang.IllegalStateException("Your JVM is not releasing References, try running the testcase with less memory (-Xmx)");
        } 
    }
}

