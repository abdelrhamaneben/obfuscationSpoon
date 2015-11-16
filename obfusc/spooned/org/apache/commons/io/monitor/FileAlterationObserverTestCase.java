package org.apache.commons.io.monitor;


public class FileAlterationObserverTestCase extends org.apache.commons.io.monitor.AbstractMonitorTestCase {
    public FileAlterationObserverTestCase(final java.lang.String name) {
        super(name);
        testDirName = "test-observer";
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        listener = new org.apache.commons.io.monitor.CollectionFileListener(true);
        super.setUp();
    }

    public void a() {
        final org.apache.commons.io.monitor.FileAlterationObserver observer = new org.apache.commons.io.monitor.FileAlterationObserver("/foo");
        observer.addListener(null);
        junit.framework.TestCase.assertFalse("Listeners[1]", observer.getListeners().iterator().hasNext());
        observer.removeListener(null);
        junit.framework.TestCase.assertFalse("Listeners[2]", observer.getListeners().iterator().hasNext());
        final org.apache.commons.io.monitor.FileAlterationListenerAdaptor listener = new org.apache.commons.io.monitor.FileAlterationListenerAdaptor();
        observer.addListener(listener);
        final java.util.Iterator<org.apache.commons.io.monitor.FileAlterationListener> it = observer.getListeners().iterator();
        junit.framework.TestCase.assertTrue("Listeners[3]", it.hasNext());
        junit.framework.TestCase.assertEquals("Added", listener, it.next());
        junit.framework.TestCase.assertFalse("Listeners[4]", it.hasNext());
        observer.removeListener(listener);
        junit.framework.TestCase.assertFalse("Listeners[5]", observer.getListeners().iterator().hasNext());
    }

    public void g() {
        final java.io.File file = new java.io.File("/foo");
        org.apache.commons.io.monitor.FileAlterationObserver observer = null;
        observer = new org.apache.commons.io.monitor.FileAlterationObserver(file);
        junit.framework.TestCase.assertEquals((("FileAlterationObserver[file=\'" + (file.getPath())) + "\', listeners=0]"), observer.toString());
        observer = new org.apache.commons.io.monitor.FileAlterationObserver(file , org.apache.commons.io.filefilter.CanReadFileFilter.CAN_READ);
        junit.framework.TestCase.assertEquals((("FileAlterationObserver[file=\'" + (file.getPath())) + "\', CanReadFileFilter, listeners=0]"), observer.toString());
        junit.framework.TestCase.assertEquals(file, observer.getDirectory());
    }

    public void b() {
        try {
            checkAndNotify();
            checkCollectionsEmpty("A");
            final java.io.File testDirA = new java.io.File(testDir , "test-dir-A");
            final java.io.File testDirB = new java.io.File(testDir , "test-dir-B");
            final java.io.File testDirC = new java.io.File(testDir , "test-dir-C");
            testDirA.mkdir();
            testDirB.mkdir();
            testDirC.mkdir();
            final java.io.File testDirAFile1 = touch(new java.io.File(testDirA , "A-file1.java"));
            final java.io.File testDirAFile2 = touch(new java.io.File(testDirA , "A-file2.txt"));
            final java.io.File testDirAFile3 = touch(new java.io.File(testDirA , "A-file3.java"));
            java.io.File testDirAFile4 = touch(new java.io.File(testDirA , "A-file4.java"));
            final java.io.File testDirBFile1 = touch(new java.io.File(testDirB , "B-file1.java"));
            checkAndNotify();
            checkCollectionSizes("B", 3, 0, 0, 4, 0, 0);
            junit.framework.TestCase.assertTrue("B testDirA", listener.getCreatedDirectories().contains(testDirA));
            junit.framework.TestCase.assertTrue("B testDirB", listener.getCreatedDirectories().contains(testDirB));
            junit.framework.TestCase.assertTrue("B testDirC", listener.getCreatedDirectories().contains(testDirC));
            junit.framework.TestCase.assertTrue("B testDirAFile1", listener.getCreatedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertFalse("B testDirAFile2", listener.getCreatedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertTrue("B testDirAFile3", listener.getCreatedFiles().contains(testDirAFile3));
            junit.framework.TestCase.assertTrue("B testDirAFile4", listener.getCreatedFiles().contains(testDirAFile4));
            junit.framework.TestCase.assertTrue("B testDirBFile1", listener.getCreatedFiles().contains(testDirBFile1));
            checkAndNotify();
            checkCollectionsEmpty("C");
            testDirAFile4 = touch(testDirAFile4);
            org.apache.commons.io.FileUtils.deleteDirectory(testDirB);
            checkAndNotify();
            checkCollectionSizes("D", 0, 0, 1, 0, 1, 1);
            junit.framework.TestCase.assertTrue("D testDirB", listener.getDeletedDirectories().contains(testDirB));
            junit.framework.TestCase.assertTrue("D testDirAFile4", listener.getChangedFiles().contains(testDirAFile4));
            junit.framework.TestCase.assertTrue("D testDirBFile1", listener.getDeletedFiles().contains(testDirBFile1));
            org.apache.commons.io.FileUtils.deleteDirectory(testDir);
            checkAndNotify();
            checkCollectionSizes("E", 0, 0, 2, 0, 0, 3);
            junit.framework.TestCase.assertTrue("E testDirA", listener.getDeletedDirectories().contains(testDirA));
            junit.framework.TestCase.assertTrue("E testDirAFile1", listener.getDeletedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertFalse("E testDirAFile2", listener.getDeletedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertTrue("E testDirAFile3", listener.getDeletedFiles().contains(testDirAFile3));
            junit.framework.TestCase.assertTrue("E testDirAFile4", listener.getDeletedFiles().contains(testDirAFile4));
            testDir.mkdir();
            checkAndNotify();
            checkCollectionsEmpty("F");
            checkAndNotify();
            checkCollectionsEmpty("G");
        } catch (final java.lang.Exception e) {
            e.printStackTrace();
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    public void c() {
        try {
            checkAndNotify();
            checkCollectionsEmpty("A");
            java.io.File testDirA = new java.io.File(testDir , "test-dir-A");
            testDirA.mkdir();
            testDir = touch(testDir);
            testDirA = touch(testDirA);
            java.io.File testDirAFile1 = new java.io.File(testDirA , "A-file1.java");
            final java.io.File testDirAFile2 = touch(new java.io.File(testDirA , "A-file2.java"));
            java.io.File testDirAFile3 = new java.io.File(testDirA , "A-file3.java");
            final java.io.File testDirAFile4 = touch(new java.io.File(testDirA , "A-file4.java"));
            java.io.File testDirAFile5 = new java.io.File(testDirA , "A-file5.java");
            checkAndNotify();
            checkCollectionSizes("B", 1, 0, 0, 2, 0, 0);
            junit.framework.TestCase.assertFalse("B testDirAFile1", listener.getCreatedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertTrue("B testDirAFile2", listener.getCreatedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertFalse("B testDirAFile3", listener.getCreatedFiles().contains(testDirAFile3));
            junit.framework.TestCase.assertTrue("B testDirAFile4", listener.getCreatedFiles().contains(testDirAFile4));
            junit.framework.TestCase.assertFalse("B testDirAFile5", listener.getCreatedFiles().contains(testDirAFile5));
            junit.framework.TestCase.assertFalse("B testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile2 exists", testDirAFile2.exists());
            junit.framework.TestCase.assertFalse("B testDirAFile3 exists", testDirAFile3.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile4 exists", testDirAFile4.exists());
            junit.framework.TestCase.assertFalse("B testDirAFile5 exists", testDirAFile5.exists());
            checkAndNotify();
            checkCollectionsEmpty("C");
            testDirAFile1 = touch(testDirAFile1);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("D", 0, 1, 0, 1, 0, 0);
            junit.framework.TestCase.assertTrue("D testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("D testDirAFile1", listener.getCreatedFiles().contains(testDirAFile1));
            testDirAFile3 = touch(testDirAFile3);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("E", 0, 1, 0, 1, 0, 0);
            junit.framework.TestCase.assertTrue("E testDirAFile3 exists", testDirAFile3.exists());
            junit.framework.TestCase.assertTrue("E testDirAFile3", listener.getCreatedFiles().contains(testDirAFile3));
            testDirAFile5 = touch(testDirAFile5);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("F", 0, 1, 0, 1, 0, 0);
            junit.framework.TestCase.assertTrue("F testDirAFile5 exists", testDirAFile5.exists());
            junit.framework.TestCase.assertTrue("F testDirAFile5", listener.getCreatedFiles().contains(testDirAFile5));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    public void e() {
        try {
            checkAndNotify();
            checkCollectionsEmpty("A");
            java.io.File testDirA = new java.io.File(testDir , "test-dir-A");
            testDirA.mkdir();
            testDir = touch(testDir);
            testDirA = touch(testDirA);
            java.io.File testDirAFile1 = touch(new java.io.File(testDirA , "A-file1.java"));
            final java.io.File testDirAFile2 = touch(new java.io.File(testDirA , "A-file2.java"));
            java.io.File testDirAFile3 = touch(new java.io.File(testDirA , "A-file3.java"));
            final java.io.File testDirAFile4 = touch(new java.io.File(testDirA , "A-file4.java"));
            java.io.File testDirAFile5 = touch(new java.io.File(testDirA , "A-file5.java"));
            checkAndNotify();
            checkCollectionSizes("B", 1, 0, 0, 5, 0, 0);
            junit.framework.TestCase.assertTrue("B testDirAFile1", listener.getCreatedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertTrue("B testDirAFile2", listener.getCreatedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertTrue("B testDirAFile3", listener.getCreatedFiles().contains(testDirAFile3));
            junit.framework.TestCase.assertTrue("B testDirAFile4", listener.getCreatedFiles().contains(testDirAFile4));
            junit.framework.TestCase.assertTrue("B testDirAFile5", listener.getCreatedFiles().contains(testDirAFile5));
            junit.framework.TestCase.assertTrue("B testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile2 exists", testDirAFile2.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile3 exists", testDirAFile3.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile4 exists", testDirAFile4.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile5 exists", testDirAFile5.exists());
            checkAndNotify();
            checkCollectionsEmpty("C");
            testDirAFile1 = touch(testDirAFile1);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("D", 0, 1, 0, 0, 1, 0);
            junit.framework.TestCase.assertTrue("D testDirAFile1", listener.getChangedFiles().contains(testDirAFile1));
            testDirAFile3 = touch(testDirAFile3);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("E", 0, 1, 0, 0, 1, 0);
            junit.framework.TestCase.assertTrue("E testDirAFile3", listener.getChangedFiles().contains(testDirAFile3));
            testDirAFile5 = touch(testDirAFile5);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("F", 0, 1, 0, 0, 1, 0);
            junit.framework.TestCase.assertTrue("F testDirAFile5", listener.getChangedFiles().contains(testDirAFile5));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    public void d() {
        try {
            checkAndNotify();
            checkCollectionsEmpty("A");
            java.io.File testDirA = new java.io.File(testDir , "test-dir-A");
            testDirA.mkdir();
            testDir = touch(testDir);
            testDirA = touch(testDirA);
            final java.io.File testDirAFile1 = touch(new java.io.File(testDirA , "A-file1.java"));
            final java.io.File testDirAFile2 = touch(new java.io.File(testDirA , "A-file2.java"));
            final java.io.File testDirAFile3 = touch(new java.io.File(testDirA , "A-file3.java"));
            final java.io.File testDirAFile4 = touch(new java.io.File(testDirA , "A-file4.java"));
            final java.io.File testDirAFile5 = touch(new java.io.File(testDirA , "A-file5.java"));
            junit.framework.TestCase.assertTrue("B testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile2 exists", testDirAFile2.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile3 exists", testDirAFile3.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile4 exists", testDirAFile4.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile5 exists", testDirAFile5.exists());
            checkAndNotify();
            checkCollectionSizes("B", 1, 0, 0, 5, 0, 0);
            junit.framework.TestCase.assertTrue("B testDirAFile1", listener.getCreatedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertTrue("B testDirAFile2", listener.getCreatedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertTrue("B testDirAFile3", listener.getCreatedFiles().contains(testDirAFile3));
            junit.framework.TestCase.assertTrue("B testDirAFile4", listener.getCreatedFiles().contains(testDirAFile4));
            junit.framework.TestCase.assertTrue("B testDirAFile5", listener.getCreatedFiles().contains(testDirAFile5));
            checkAndNotify();
            checkCollectionsEmpty("C");
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile1);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("D", 0, 1, 0, 0, 0, 1);
            junit.framework.TestCase.assertFalse("D testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("D testDirAFile1", listener.getDeletedFiles().contains(testDirAFile1));
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile3);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("E", 0, 1, 0, 0, 0, 1);
            junit.framework.TestCase.assertFalse("E testDirAFile3 exists", testDirAFile3.exists());
            junit.framework.TestCase.assertTrue("E testDirAFile3", listener.getDeletedFiles().contains(testDirAFile3));
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile5);
            testDirA = touch(testDirA);
            checkAndNotify();
            checkCollectionSizes("F", 0, 1, 0, 0, 0, 1);
            junit.framework.TestCase.assertFalse("F testDirAFile5 exists", testDirAFile5.exists());
            junit.framework.TestCase.assertTrue("F testDirAFile5", listener.getDeletedFiles().contains(testDirAFile5));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    public void f() {
        try {
            final java.io.File testDirA = new java.io.File(testDir , "test-dir-A");
            java.io.File testDirAFile1 = new java.io.File(testDirA , "A-file1.java");
            testDirA.mkdir();
            final java.io.FileFilter nameFilter = org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter(testDirAFile1.getName());
            createObserver(testDirA, nameFilter);
            checkAndNotify();
            checkCollectionsEmpty("A");
            junit.framework.TestCase.assertFalse("A testDirAFile1 exists", testDirAFile1.exists());
            testDirAFile1 = touch(testDirAFile1);
            java.io.File testDirAFile2 = touch(new java.io.File(testDirA , "A-file2.txt"));
            java.io.File testDirAFile3 = touch(new java.io.File(testDirA , "A-file3.java"));
            junit.framework.TestCase.assertTrue("B testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile2 exists", testDirAFile2.exists());
            junit.framework.TestCase.assertTrue("B testDirAFile3 exists", testDirAFile3.exists());
            checkAndNotify();
            checkCollectionSizes("C", 0, 0, 0, 1, 0, 0);
            junit.framework.TestCase.assertTrue("C created", listener.getCreatedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertFalse("C created", listener.getCreatedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertFalse("C created", listener.getCreatedFiles().contains(testDirAFile3));
            testDirAFile1 = touch(testDirAFile1);
            testDirAFile2 = touch(testDirAFile2);
            testDirAFile3 = touch(testDirAFile3);
            checkAndNotify();
            checkCollectionSizes("D", 0, 0, 0, 0, 1, 0);
            junit.framework.TestCase.assertTrue("D changed", listener.getChangedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertFalse("D changed", listener.getChangedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertFalse("D changed", listener.getChangedFiles().contains(testDirAFile3));
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile1);
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile2);
            org.apache.commons.io.FileUtils.deleteQuietly(testDirAFile3);
            junit.framework.TestCase.assertFalse("E testDirAFile1 exists", testDirAFile1.exists());
            junit.framework.TestCase.assertFalse("E testDirAFile2 exists", testDirAFile2.exists());
            junit.framework.TestCase.assertFalse("E testDirAFile3 exists", testDirAFile3.exists());
            checkAndNotify();
            checkCollectionSizes("E", 0, 0, 0, 0, 0, 1);
            junit.framework.TestCase.assertTrue("E deleted", listener.getDeletedFiles().contains(testDirAFile1));
            junit.framework.TestCase.assertFalse("E deleted", listener.getDeletedFiles().contains(testDirAFile2));
            junit.framework.TestCase.assertFalse("E deleted", listener.getDeletedFiles().contains(testDirAFile3));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Threw " + e));
        }
    }

    protected void testAddRemoveObservers() throws java.lang.Exception {
        observer.checkAndNotify();
    }
}

