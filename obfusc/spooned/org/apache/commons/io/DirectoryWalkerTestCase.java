package org.apache.commons.io;


public class DirectoryWalkerTestCase {
    private static final java.io.File current = new java.io.File(".");

    private static final java.io.File javaDir = new java.io.File("src/main/java");

    private static final java.io.File orgDir = new java.io.File(javaDir , "org");

    private static final java.io.File apacheDir = new java.io.File(orgDir , "apache");

    private static final java.io.File commonsDir = new java.io.File(apacheDir , "commons");

    private static final java.io.File ioDir = new java.io.File(commonsDir , "io");

    private static final java.io.File outputDir = new java.io.File(ioDir , "output");

    private static final java.io.File[] dirs = new java.io.File[]{ orgDir , apacheDir , commonsDir , ioDir , outputDir };

    private static final java.io.File filenameUtils = new java.io.File(ioDir , "FilenameUtils.java");

    private static final java.io.File ioUtils = new java.io.File(ioDir , "IOUtils.java");

    private static final java.io.File proxyWriter = new java.io.File(outputDir , "ProxyWriter.java");

    private static final java.io.File nullStream = new java.io.File(outputDir , "NullOutputStream.java");

    private static final java.io.File[] ioFiles = new java.io.File[]{ filenameUtils , ioUtils };

    private static final java.io.File[] outputFiles = new java.io.File[]{ proxyWriter , nullStream };

    private static final org.apache.commons.io.filefilter.IOFileFilter dirsFilter = org.apache.commons.io.DirectoryWalkerTestCase.createNameFilter(dirs);

    private static final org.apache.commons.io.filefilter.IOFileFilter iofilesFilter = org.apache.commons.io.DirectoryWalkerTestCase.createNameFilter(ioFiles);

    private static final org.apache.commons.io.filefilter.IOFileFilter outputFilesFilter = org.apache.commons.io.DirectoryWalkerTestCase.createNameFilter(outputFiles);

    private static final org.apache.commons.io.filefilter.IOFileFilter ioDirAndFilesFilter = new org.apache.commons.io.filefilter.OrFileFilter(dirsFilter , iofilesFilter);

    private static final org.apache.commons.io.filefilter.IOFileFilter dirsAndFilesFilter = new org.apache.commons.io.filefilter.OrFileFilter(ioDirAndFilesFilter , outputFilesFilter);

    private static final org.apache.commons.io.filefilter.IOFileFilter NOT_SVN = org.apache.commons.io.filefilter.FileFilterUtils.makeSVNAware(null);

    @org.junit.Test
    public void b() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(dirsAndFilesFilter , -1).find(javaDir);
        org.junit.Assert.assertEquals("Result Size", (((1 + (dirs.length)) + (ioFiles.length)) + (outputFiles.length)), results.size());
        org.junit.Assert.assertTrue("Start Dir", results.contains(javaDir));
        checkContainsFiles("Dir", dirs, results);
        checkContainsFiles("IO File", ioFiles, results);
        checkContainsFiles("Output File", outputFiles, results);
    }

    @org.junit.Test
    public void c() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(NOT_SVN , 0).find(javaDir);
        org.junit.Assert.assertEquals("[A] Result Size", 1, results.size());
        org.junit.Assert.assertTrue("[A] Start Dir", results.contains(javaDir));
    }

    @org.junit.Test
    public void d() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(NOT_SVN , 1).find(javaDir);
        org.junit.Assert.assertEquals("[B] Result Size", 2, results.size());
        org.junit.Assert.assertTrue("[B] Start Dir", results.contains(javaDir));
        org.junit.Assert.assertTrue("[B] Org Dir", results.contains(orgDir));
    }

    @org.junit.Test
    public void e() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(NOT_SVN , 3).find(javaDir);
        org.junit.Assert.assertEquals("[C] Result Size", 4, results.size());
        org.junit.Assert.assertTrue("[C] Start Dir", results.contains(javaDir));
        org.junit.Assert.assertTrue("[C] Org Dir", results.contains(orgDir));
        org.junit.Assert.assertTrue("[C] Apache Dir", results.contains(apacheDir));
        org.junit.Assert.assertTrue("[C] Commons Dir", results.contains(commonsDir));
    }

    @org.junit.Test
    public void f() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(dirsAndFilesFilter , 5).find(javaDir);
        org.junit.Assert.assertEquals("[D] Result Size", ((1 + (dirs.length)) + (ioFiles.length)), results.size());
        org.junit.Assert.assertTrue("[D] Start Dir", results.contains(javaDir));
        checkContainsFiles("[D] Dir", dirs, results);
        checkContainsFiles("[D] File", ioFiles, results);
    }

    @org.junit.Test
    public void g() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(dirsFilter , iofilesFilter , -1).find(javaDir);
        org.junit.Assert.assertEquals("[DirAndFile1] Result Size", ((1 + (dirs.length)) + (ioFiles.length)), results.size());
        org.junit.Assert.assertTrue("[DirAndFile1] Start Dir", results.contains(javaDir));
        checkContainsFiles("[DirAndFile1] Dir", dirs, results);
        checkContainsFiles("[DirAndFile1] File", ioFiles, results);
    }

    @org.junit.Test
    public void h() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(null , null , -1).find(javaDir);
        org.junit.Assert.assertTrue("[DirAndFile2] Result Size", ((results.size()) > ((1 + (dirs.length)) + (ioFiles.length))));
        org.junit.Assert.assertTrue("[DirAndFile2] Start Dir", results.contains(javaDir));
        checkContainsFiles("[DirAndFile2] Dir", dirs, results);
        checkContainsFiles("[DirAndFile2] File", ioFiles, results);
    }

    @org.junit.Test
    public void i() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(dirsFilter , null , -1).find(javaDir);
        final java.util.List<java.io.File> resultDirs = directoriesOnly(results);
        org.junit.Assert.assertEquals("[DirAndFile3] Result Size", (1 + (dirs.length)), resultDirs.size());
        org.junit.Assert.assertTrue("[DirAndFile3] Start Dir", results.contains(javaDir));
        checkContainsFiles("[DirAndFile3] Dir", dirs, resultDirs);
    }

    @org.junit.Test
    public void j() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(null , iofilesFilter , -1).find(javaDir);
        final java.util.List<java.io.File> resultFiles = filesOnly(results);
        org.junit.Assert.assertEquals("[DirAndFile4] Result Size", ioFiles.length, resultFiles.size());
        org.junit.Assert.assertTrue("[DirAndFile4] Start Dir", results.contains(javaDir));
        checkContainsFiles("[DirAndFile4] File", ioFiles, resultFiles);
    }

    @org.junit.Test
    public void m() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(null , 0).find(current);
        org.junit.Assert.assertEquals("Result Size", 1, results.size());
        org.junit.Assert.assertTrue("Current Dir", results.contains(new java.io.File(".")));
    }

    @org.junit.Test
    public void n() {
        final java.io.File invalidDir = new java.io.File("invalid-dir");
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(null , -1).find(invalidDir);
        org.junit.Assert.assertEquals("Result Size", 1, results.size());
        org.junit.Assert.assertTrue("Current Dir", results.contains(invalidDir));
        try {
            new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder(null , -1).find(null);
            org.junit.Assert.fail("Null start directory didn\'t throw Exception");
        } catch (final java.lang.NullPointerException ignore) {
        }
    }

    @org.junit.Test
    public void l() {
        final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFalseFileFinder(null , -1).find(current);
        org.junit.Assert.assertEquals("Result Size", 0, results.size());
    }

    private void a(final java.lang.String prefix, final java.io.File[] files, final java.util.Collection<java.io.File> results) {
        for (int i = 0 ; i < (files.length) ; i++) {
            org.junit.Assert.assertTrue(((((prefix + "[") + i) + "] ") + (files[i])), results.contains(files[i]));
        }
    }

    private void b(final java.lang.String prefix, final java.io.File[] files, final java.util.Collection<java.lang.String> results) {
        for (int i = 0 ; i < (files.length) ; i++) {
            org.junit.Assert.assertTrue(((((prefix + "[") + i) + "] ") + (files[i])), results.contains(files[i].toString()));
        }
    }

    private java.util.List<java.io.File> a(final java.util.Collection<java.io.File> results) {
        final java.util.List<java.io.File> list = new java.util.ArrayList<java.io.File>(results.size());
        for (final java.io.File file : results) {
            if (file.isDirectory()) {
                list.add(file);
            } 
        }
        return list;
    }

    private java.util.List<java.io.File> b(final java.util.Collection<java.io.File> results) {
        final java.util.List<java.io.File> list = new java.util.ArrayList<java.io.File>(results.size());
        for (final java.io.File file : results) {
            if (file.isFile()) {
                list.add(file);
            } 
        }
        return list;
    }

    private static org.apache.commons.io.filefilter.IOFileFilter a(final java.io.File[] files) {
        final java.lang.String[] names = new java.lang.String[files.length];
        for (int i = 0 ; i < (files.length) ; i++) {
            names[i] = files[i].getName();
        }
        return new org.apache.commons.io.filefilter.NameFileFilter(names);
    }

    @org.junit.Test
    public void a() {
        java.lang.String cancelName = null;
        try {
            cancelName = "DirectoryWalker.java";
            new org.apache.commons.io.DirectoryWalkerTestCase.TestCancelWalker(cancelName , false).find(javaDir);
            org.junit.Assert.fail((("CancelException not thrown for \'" + cancelName) + "\'"));
        } catch (final org.apache.commons.io.DirectoryWalker.CancelException cancel) {
            org.junit.Assert.assertEquals(("File:  " + cancelName), cancelName, cancel.getFile().getName());
            org.junit.Assert.assertEquals(("Depth: " + cancelName), 5, cancel.getDepth());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(((("IOException: " + cancelName) + " ") + ex));
        }
        try {
            cancelName = "commons";
            new org.apache.commons.io.DirectoryWalkerTestCase.TestCancelWalker(cancelName , false).find(javaDir);
            org.junit.Assert.fail((("CancelException not thrown for \'" + cancelName) + "\'"));
        } catch (final org.apache.commons.io.DirectoryWalker.CancelException cancel) {
            org.junit.Assert.assertEquals(("File:  " + cancelName), cancelName, cancel.getFile().getName());
            org.junit.Assert.assertEquals(("Depth: " + cancelName), 3, cancel.getDepth());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(((("IOException: " + cancelName) + " ") + ex));
        }
        try {
            final java.util.List<java.io.File> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestCancelWalker(cancelName , true).find(javaDir);
            final java.io.File lastFile = results.get(((results.size()) - 1));
            org.junit.Assert.assertEquals(("Suppress:  " + cancelName), cancelName, lastFile.getName());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(("Suppress threw " + ex));
        }
    }

    @org.junit.Test
    public void o() {
        java.lang.String cancelName = "DirectoryWalker.java";
        org.apache.commons.io.DirectoryWalkerTestCase.TestMultiThreadCancelWalker walker = new org.apache.commons.io.DirectoryWalkerTestCase.TestMultiThreadCancelWalker(cancelName , false);
        try {
            walker.find(javaDir);
            org.junit.Assert.fail((("CancelException not thrown for \'" + cancelName) + "\'"));
        } catch (final org.apache.commons.io.DirectoryWalker.CancelException cancel) {
            final java.io.File last = walker.results.get(((walker.results.size()) - 1));
            org.junit.Assert.assertEquals(cancelName, last.getName());
            org.junit.Assert.assertEquals(("Depth: " + cancelName), 5, cancel.getDepth());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(((("IOException: " + cancelName) + " ") + ex));
        }
        try {
            cancelName = "commons";
            walker = new org.apache.commons.io.DirectoryWalkerTestCase.TestMultiThreadCancelWalker(cancelName , false);
            walker.find(javaDir);
            org.junit.Assert.fail((("CancelException not thrown for \'" + cancelName) + "\'"));
        } catch (final org.apache.commons.io.DirectoryWalker.CancelException cancel) {
            org.junit.Assert.assertEquals(("File:  " + cancelName), cancelName, cancel.getFile().getName());
            org.junit.Assert.assertEquals(("Depth: " + cancelName), 3, cancel.getDepth());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(((("IOException: " + cancelName) + " ") + ex));
        }
        try {
            walker = new org.apache.commons.io.DirectoryWalkerTestCase.TestMultiThreadCancelWalker(cancelName , true);
            final java.util.List<java.io.File> results = walker.find(javaDir);
            final java.io.File lastFile = results.get(((results.size()) - 1));
            org.junit.Assert.assertEquals(("Suppress:  " + cancelName), cancelName, lastFile.getName());
        } catch (final java.io.IOException ex) {
            org.junit.Assert.fail(("Suppress threw " + ex));
        }
    }

    @org.junit.Test
    public void k() {
        final java.util.List<java.lang.String> results = new org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinderString(dirsAndFilesFilter , -1).find(javaDir);
        org.junit.Assert.assertEquals("Result Size", ((outputFiles.length) + (ioFiles.length)), results.size());
        checkContainsString("IO File", ioFiles, results);
        checkContainsString("Output File", outputFiles, results);
    }

    private static class TestFileFinder extends org.apache.commons.io.DirectoryWalker<java.io.File> {
        protected TestFileFinder(final java.io.FileFilter filter ,final int depthLimit) {
            super(filter, depthLimit);
        }

        protected TestFileFinder(final org.apache.commons.io.filefilter.IOFileFilter dirFilter ,final org.apache.commons.io.filefilter.IOFileFilter fileFilter ,final int depthLimit) {
            super(dirFilter, fileFilter, depthLimit);
        }

        protected java.util.List<java.io.File> handleDirectory(final java.io.File startDirectory) {
            final java.util.List<java.io.File> results = new java.util.ArrayList<java.io.File>();
            try {
                walk(startDirectory, results);
            } catch (final java.io.IOException ex) {
                org.junit.Assert.fail(ex.toString());
            }
            return results;
        }

        @java.lang.Override
        protected void a(final java.io.File directory, final int depth, final java.util.Collection<java.io.File> results) {
            results.add(directory);
        }

        @java.lang.Override
        protected void c(final java.io.File file, final int depth, final java.util.Collection<java.io.File> results) {
            results.add(file);
        }
    }

    private static class TestFalseFileFinder extends org.apache.commons.io.DirectoryWalkerTestCase.TestFileFinder {
        protected TestFalseFileFinder(final java.io.FileFilter filter ,final int depthLimit) {
            super(filter, depthLimit);
        }

        @java.lang.Override
        protected boolean handleDirectory(final java.io.File directory, final int depth, final java.util.Collection<java.io.File> results) {
            return false;
        }
    }

    static class TestCancelWalker extends org.apache.commons.io.DirectoryWalker<java.io.File> {
        private final java.lang.String cancelFileName;

        private final boolean suppressCancel;

        TestCancelWalker(final java.lang.String cancelFileName ,final boolean suppressCancel) {
            super();
            this.cancelFileName = cancelFileName;
            this.suppressCancel = suppressCancel;
        }

        protected java.util.List<java.io.File> handleDirectory(final java.io.File startDirectory) throws java.io.IOException {
            final java.util.List<java.io.File> results = new java.util.ArrayList<java.io.File>();
            walk(startDirectory, results);
            return results;
        }

        @java.lang.Override
        protected void a(final java.io.File directory, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            results.add(directory);
            if (cancelFileName.equals(directory.getName())) {
                throw new org.apache.commons.io.DirectoryWalker.CancelException(directory , depth);
            } 
        }

        @java.lang.Override
        protected void c(final java.io.File file, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            results.add(file);
            if (cancelFileName.equals(file.getName())) {
                throw new org.apache.commons.io.DirectoryWalker.CancelException(file , depth);
            } 
        }

        @java.lang.Override
        protected void handleDirectory(final java.io.File startDirectory, final java.util.Collection<java.io.File> results, final org.apache.commons.io.DirectoryWalker.CancelException cancel) throws java.io.IOException {
            if (!(suppressCancel)) {
                super.handleCancelled(startDirectory, results, cancel);
            } 
        }
    }

    static class TestMultiThreadCancelWalker extends org.apache.commons.io.DirectoryWalker<java.io.File> {
        private final java.lang.String cancelFileName;

        private final boolean suppressCancel;

        private boolean cancelled;

        public java.util.List<java.io.File> results;

        TestMultiThreadCancelWalker(final java.lang.String cancelFileName ,final boolean suppressCancel) {
            super();
            this.cancelFileName = cancelFileName;
            this.suppressCancel = suppressCancel;
        }

        protected java.util.List<java.io.File> handleDirectory(final java.io.File startDirectory) throws java.io.IOException {
            results = new java.util.ArrayList<java.io.File>();
            walk(startDirectory, results);
            return results;
        }

        @java.lang.Override
        protected void a(final java.io.File directory, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            results.add(directory);
            org.junit.Assert.assertFalse(cancelled);
            if (cancelFileName.equals(directory.getName())) {
                cancelled = true;
            } 
        }

        @java.lang.Override
        protected void c(final java.io.File file, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            results.add(file);
            org.junit.Assert.assertFalse(cancelled);
            if (cancelFileName.equals(file.getName())) {
                cancelled = true;
            } 
        }

        @java.lang.Override
        protected boolean find(final java.io.File file, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            return cancelled;
        }

        @java.lang.Override
        protected void handleDirectory(final java.io.File startDirectory, final java.util.Collection<java.io.File> results, final org.apache.commons.io.DirectoryWalker.CancelException cancel) throws java.io.IOException {
            if (!(suppressCancel)) {
                super.handleCancelled(startDirectory, results, cancel);
            } 
        }
    }

    private static class TestFileFinderString extends org.apache.commons.io.DirectoryWalker<java.lang.String> {
        protected TestFileFinderString(final java.io.FileFilter filter ,final int depthLimit) {
            super(filter, depthLimit);
        }

        protected java.util.List<java.lang.String> handleDirectory(final java.io.File startDirectory) {
            final java.util.List<java.lang.String> results = new java.util.ArrayList<java.lang.String>();
            try {
                walk(startDirectory, results);
            } catch (final java.io.IOException ex) {
                org.junit.Assert.fail(ex.toString());
            }
            return results;
        }

        @java.lang.Override
        protected void c(final java.io.File file, final int depth, final java.util.Collection<java.lang.String> results) {
            results.add(file.toString());
        }
    }
}

