package org.apache.commons.io.monitor;


public abstract class AbstractMonitorTestCase extends junit.framework.TestCase {
    protected org.apache.commons.io.monitor.FileAlterationObserver observer;

    protected org.apache.commons.io.monitor.CollectionFileListener listener;

    protected java.lang.String testDirName = null;

    protected java.io.File testDir;

    protected long pauseTime = 100L;

    public AbstractMonitorTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        testDir = new java.io.File(new java.io.File(".") , testDirName);
        if (testDir.exists()) {
            org.apache.commons.io.FileUtils.cleanDirectory(testDir);
        } else {
            testDir.mkdir();
        }
        final org.apache.commons.io.filefilter.IOFileFilter files = org.apache.commons.io.filefilter.FileFilterUtils.fileFileFilter();
        final org.apache.commons.io.filefilter.IOFileFilter javaSuffix = org.apache.commons.io.filefilter.FileFilterUtils.suffixFileFilter(".java");
        final org.apache.commons.io.filefilter.IOFileFilter fileFilter = org.apache.commons.io.filefilter.FileFilterUtils.and(files, javaSuffix);
        final org.apache.commons.io.filefilter.IOFileFilter directories = org.apache.commons.io.filefilter.FileFilterUtils.directoryFileFilter();
        final org.apache.commons.io.filefilter.IOFileFilter visible = org.apache.commons.io.filefilter.HiddenFileFilter.VISIBLE;
        final org.apache.commons.io.filefilter.IOFileFilter dirFilter = org.apache.commons.io.filefilter.FileFilterUtils.and(directories, visible);
        final org.apache.commons.io.filefilter.IOFileFilter filter = org.apache.commons.io.filefilter.FileFilterUtils.or(dirFilter, fileFilter);
        createObserver(testDir, filter);
    }

    protected void testAddRemoveObservers(final java.io.File file, final java.io.FileFilter fileFilter) {
        observer = new org.apache.commons.io.monitor.FileAlterationObserver(file , fileFilter);
        observer.addListener(listener);
        observer.addListener(new org.apache.commons.io.monitor.FileAlterationListenerAdaptor());
        try {
            observer.initialize();
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Observer init() threw " + e));
        }
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(testDir);
    }

    protected void testAddRemoveObservers(final java.lang.String label) {
        checkCollectionSizes(("EMPTY-" + label), 0, 0, 0, 0, 0, 0);
    }

    protected void testAddRemoveObservers(java.lang.String label, final int dirCreate, final int dirChange, final int dirDelete, final int fileCreate, final int fileChange, final int fileDelete) {
        label = ((((((((((((label + "[") + (listener.getCreatedDirectories().size())) + " ") + (listener.getChangedDirectories().size())) + " ") + (listener.getDeletedDirectories().size())) + " ") + (listener.getCreatedFiles().size())) + " ") + (listener.getChangedFiles().size())) + " ") + (listener.getDeletedFiles().size())) + "]";
        junit.framework.TestCase.assertEquals((label + ": No. of directories created"), dirCreate, listener.getCreatedDirectories().size());
        junit.framework.TestCase.assertEquals((label + ": No. of directories changed"), dirChange, listener.getChangedDirectories().size());
        junit.framework.TestCase.assertEquals((label + ": No. of directories deleted"), dirDelete, listener.getDeletedDirectories().size());
        junit.framework.TestCase.assertEquals((label + ": No. of files created"), fileCreate, listener.getCreatedFiles().size());
        junit.framework.TestCase.assertEquals((label + ": No. of files changed"), fileChange, listener.getChangedFiles().size());
        junit.framework.TestCase.assertEquals((label + ": No. of files deleted"), fileDelete, listener.getDeletedFiles().size());
    }

    protected java.io.File testAddRemoveObservers(java.io.File file) {
        final long lastModified = file.exists() ? file.lastModified() : 0;
        try {
            org.apache.commons.io.FileUtils.touch(file);
            file = new java.io.File(file.getParent() , file.getName());
            while (lastModified == (file.lastModified())) {
                sleepHandleInterruped(pauseTime);
                org.apache.commons.io.FileUtils.touch(file);
                file = new java.io.File(file.getParent() , file.getName());
            }
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(((("Touching " + file) + ": ") + e));
        }
        sleepHandleInterruped(pauseTime);
        return file;
    }

    protected void testAddRemoveObservers(final long timeInMilliseconds) {
        try {
            java.lang.Thread.sleep(timeInMilliseconds);
        } catch (final java.lang.InterruptedException ie) {
        }
    }
}

