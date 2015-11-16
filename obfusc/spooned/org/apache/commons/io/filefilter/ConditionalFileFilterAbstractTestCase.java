package org.apache.commons.io.filefilter;


public abstract class ConditionalFileFilterAbstractTestCase extends org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase {
    private static final java.lang.String TEST_FILE_NAME_PREFIX = "TestFile";

    private static final java.lang.String TEST_FILE_TYPE = ".tst";

    protected org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter[] trueFilters;

    protected org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterFalseFileFilter[] falseFilters;

    private java.io.File file;

    private java.io.File workingPath;

    public ConditionalFileFilterAbstractTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    public void setUp() throws java.lang.Exception {
        this.workingPath = org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.determineWorkingDirectoryPath(getWorkingPathNamePropertyKey(), getDefaultWorkingPath());
        this.file = new java.io.File(this.workingPath , (((TEST_FILE_NAME_PREFIX) + 1) + (TEST_FILE_TYPE)));
        this.trueFilters = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter[4];
        this.falseFilters = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterFalseFileFilter[4];
        this.trueFilters[1] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter();
        this.trueFilters[2] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter();
        this.trueFilters[3] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter();
        this.falseFilters[1] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterFalseFileFilter();
        this.falseFilters[2] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterFalseFileFilter();
        this.falseFilters[3] = new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterFalseFileFilter();
    }

    public void j() {
        final java.util.List<org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter>();
        final org.apache.commons.io.filefilter.ConditionalFileFilter fileFilter = getConditionalFileFilter();
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        for (int i = 0 ; i < (filters.size()) ; i++) {
            junit.framework.TestCase.assertEquals("file filters count: ", i, fileFilter.getFileFilters().size());
            fileFilter.addFileFilter(filters.get(i));
            junit.framework.TestCase.assertEquals("file filters count: ", (i + 1), fileFilter.getFileFilters().size());
        }
        for (final org.apache.commons.io.filefilter.IOFileFilter filter : fileFilter.getFileFilters()) {
            junit.framework.TestCase.assertTrue("found file filter", filters.contains(filter));
        }
        junit.framework.TestCase.assertEquals("file filters count", filters.size(), fileFilter.getFileFilters().size());
    }

    public void n() {
        final java.util.List<org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter>();
        final org.apache.commons.io.filefilter.ConditionalFileFilter fileFilter = getConditionalFileFilter();
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        filters.add(new org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter());
        for (org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.TesterTrueFileFilter filter : filters) {
            fileFilter.removeFileFilter(filter);
            junit.framework.TestCase.assertTrue("file filter removed", !(fileFilter.getFileFilters().contains(filter)));
        }
        junit.framework.TestCase.assertEquals("file filters count", 0, fileFilter.getFileFilters().size());
    }

    public void m() throws java.lang.Exception {
        final org.apache.commons.io.filefilter.ConditionalFileFilter fileFilter = getConditionalFileFilter();
        final java.io.File file = new java.io.File(this.workingPath , (((TEST_FILE_NAME_PREFIX) + 1) + (TEST_FILE_TYPE)));
        org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFileFiltering(1, ((org.apache.commons.io.filefilter.IOFileFilter)(fileFilter)), file, false);
        org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFilenameFiltering(1, ((org.apache.commons.io.filefilter.IOFileFilter)(fileFilter)), file, false);
    }

    public void l() throws java.lang.Exception {
        final java.util.List<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>> testFilters = getTestFilters();
        final java.util.List<boolean[]> testTrueResults = getTrueResults();
        final java.util.List<boolean[]> testFalseResults = getFalseResults();
        final java.util.List<java.lang.Boolean> testFileResults = getFileResults();
        final java.util.List<java.lang.Boolean> testFilenameResults = getFilenameResults();
        for (int i = 1 ; i < (testFilters.size()) ; i++) {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = testFilters.get(i);
            final boolean[] trueResults = testTrueResults.get(i);
            final boolean[] falseResults = testFalseResults.get(i);
            final boolean fileResults = testFileResults.get(i);
            final boolean filenameResults = testFilenameResults.get(i);
            final org.apache.commons.io.filefilter.IOFileFilter filter = buildFilterUsingConstructor(filters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetTrueFilters(this.trueFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetFalseFilters(this.falseFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFileFiltering(i, filter, this.file, fileResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertTrueFiltersInvoked(i, trueFilters, trueResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFalseFiltersInvoked(i, falseFilters, falseResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetTrueFilters(this.trueFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetFalseFilters(this.falseFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFilenameFiltering(i, filter, this.file, filenameResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertTrueFiltersInvoked(i, trueFilters, trueResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFalseFiltersInvoked(i, falseFilters, falseResults);
        }
    }

    public void k() throws java.lang.Exception {
        final java.util.List<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>> testFilters = getTestFilters();
        final java.util.List<boolean[]> testTrueResults = getTrueResults();
        final java.util.List<boolean[]> testFalseResults = getFalseResults();
        final java.util.List<java.lang.Boolean> testFileResults = getFileResults();
        final java.util.List<java.lang.Boolean> testFilenameResults = getFilenameResults();
        for (int i = 1 ; i < (testFilters.size()) ; i++) {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = testFilters.get(i);
            final boolean[] trueResults = testTrueResults.get(i);
            final boolean[] falseResults = testFalseResults.get(i);
            final boolean fileResults = testFileResults.get(i);
            final boolean filenameResults = testFilenameResults.get(i);
            final org.apache.commons.io.filefilter.IOFileFilter filter = buildFilterUsingAdd(filters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetTrueFilters(this.trueFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetFalseFilters(this.falseFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFileFiltering(i, filter, this.file, fileResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertTrueFiltersInvoked(i, trueFilters, trueResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFalseFiltersInvoked(i, falseFilters, falseResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetTrueFilters(this.trueFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.resetFalseFilters(this.falseFilters);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFilenameFiltering(i, filter, this.file, filenameResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertTrueFiltersInvoked(i, trueFilters, trueResults);
            org.apache.commons.io.filefilter.IOFileFilterAbstractTestCase.assertFalseFiltersInvoked(i, falseFilters, falseResults);
        }
    }

    protected abstract org.apache.commons.io.filefilter.ConditionalFileFilter i();

    protected abstract org.apache.commons.io.filefilter.IOFileFilter a(java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters);

    protected abstract org.apache.commons.io.filefilter.IOFileFilter b(java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters);

    protected abstract java.util.List<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>> g();

    protected abstract java.util.List<boolean[]> h();

    protected abstract java.util.List<boolean[]> d();

    protected abstract java.util.List<java.lang.Boolean> e();

    protected abstract java.util.List<java.lang.Boolean> f();

    protected abstract java.lang.String c();

    protected abstract java.lang.String b();
}

