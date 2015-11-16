package org.apache.commons.io.filefilter;


public class AndFileFilterTestCase extends org.apache.commons.io.filefilter.ConditionalFileFilterAbstractTestCase {
    private static final java.lang.String DEFAULT_WORKING_PATH = "./AndFileFilterTestCase/";

    private static final java.lang.String WORKING_PATH_NAME_PROPERTY_KEY = (org.apache.commons.io.filefilter.AndFileFilterTestCase.class.getName()) + ".workingDirectory";

    private java.util.List<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>> testFilters;

    private java.util.List<boolean[]> testTrueResults;

    private java.util.List<boolean[]> testFalseResults;

    private java.util.List<java.lang.Boolean> testFileResults;

    private java.util.List<java.lang.Boolean> testFilenameResults;

    public AndFileFilterTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    public void setUp() throws java.lang.Exception {
        super.setUp();
        setUpTestFilters();
    }

    @java.lang.Override
    protected org.apache.commons.io.filefilter.IOFileFilter getFilenameResults(final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters) {
        final org.apache.commons.io.filefilter.AndFileFilter filter = new org.apache.commons.io.filefilter.AndFileFilter();
        for (org.apache.commons.io.filefilter.IOFileFilter filter1 : filters) {
            filter.addFileFilter(filter1);
        }
        return filter;
    }

    @java.lang.Override
    protected org.apache.commons.io.filefilter.IOFileFilter assertFilenameFiltering(final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters) {
        return new org.apache.commons.io.filefilter.AndFileFilter(filters);
    }

    @java.lang.Override
    protected org.apache.commons.io.filefilter.ConditionalFileFilter assertFiltering() {
        return new org.apache.commons.io.filefilter.AndFileFilter();
    }

    @java.lang.Override
    protected java.lang.String resetTrueFilters() {
        return DEFAULT_WORKING_PATH;
    }

    @java.lang.Override
    protected java.util.List<boolean[]> resetFalseFilters() {
        return this.testFalseResults;
    }

    @java.lang.Override
    protected java.util.List<java.lang.Boolean> assertFalseFiltersInvoked() {
        return this.testFileResults;
    }

    @java.lang.Override
    protected java.util.List<java.lang.Boolean> assertFilenameFiltering() {
        return this.testFilenameResults;
    }

    @java.lang.Override
    protected java.util.List<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>> getFilenameResults() {
        return this.testFilters;
    }

    @java.lang.Override
    protected java.util.List<boolean[]> determineWorkingDirectoryPath() {
        return this.testTrueResults;
    }

    @java.lang.Override
    protected java.lang.String assertTrueFiltersInvoked() {
        return WORKING_PATH_NAME_PROPERTY_KEY;
    }

    private void assertFilenameFiltering() {
        this.testFilters = new java.util.ArrayList<java.util.List<org.apache.commons.io.filefilter.IOFileFilter>>();
        this.testTrueResults = new java.util.ArrayList<boolean[]>();
        this.testFalseResults = new java.util.ArrayList<boolean[]>();
        this.testFileResults = new java.util.ArrayList<java.lang.Boolean>();
        this.testFilenameResults = new java.util.ArrayList<java.lang.Boolean>();
        {
            testFilters.add(0, null);
            testTrueResults.add(0, null);
            testFalseResults.add(0, null);
            testFileResults.add(0, null);
            testFilenameResults.add(0, null);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(trueFilters[1]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            final boolean[] trueResults = new boolean[]{ true , true , true };
            final boolean[] falseResults = new boolean[]{ false , false , false };
            testFilters.add(1, filters);
            testTrueResults.add(1, trueResults);
            testFalseResults.add(1, falseResults);
            testFileResults.add(1, java.lang.Boolean.TRUE);
            testFilenameResults.add(1, java.lang.Boolean.TRUE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(falseFilters[1]);
            filters.add(trueFilters[1]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[2]);
            filters.add(falseFilters[3]);
            final boolean[] trueResults = new boolean[]{ false , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(2, filters);
            testTrueResults.add(2, trueResults);
            testFalseResults.add(2, falseResults);
            testFileResults.add(2, java.lang.Boolean.FALSE);
            testFilenameResults.add(2, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(trueFilters[1]);
            filters.add(falseFilters[1]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[2]);
            filters.add(falseFilters[3]);
            final boolean[] trueResults = new boolean[]{ true , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(3, filters);
            testTrueResults.add(3, trueResults);
            testFalseResults.add(3, falseResults);
            testFileResults.add(3, java.lang.Boolean.FALSE);
            testFilenameResults.add(3, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(trueFilters[1]);
            filters.add(trueFilters[2]);
            filters.add(falseFilters[1]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[2]);
            filters.add(falseFilters[3]);
            final boolean[] trueResults = new boolean[]{ true , true , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(4, filters);
            testTrueResults.add(4, trueResults);
            testFalseResults.add(4, falseResults);
            testFileResults.add(4, java.lang.Boolean.FALSE);
            testFilenameResults.add(4, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(falseFilters[1]);
            filters.add(trueFilters[1]);
            filters.add(falseFilters[2]);
            filters.add(falseFilters[3]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            final boolean[] trueResults = new boolean[]{ false , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(5, filters);
            testTrueResults.add(5, trueResults);
            testFalseResults.add(5, falseResults);
            testFileResults.add(5, java.lang.Boolean.FALSE);
            testFilenameResults.add(5, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(trueFilters[1]);
            filters.add(falseFilters[1]);
            filters.add(falseFilters[2]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[3]);
            final boolean[] trueResults = new boolean[]{ true , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(6, filters);
            testTrueResults.add(6, trueResults);
            testFalseResults.add(6, falseResults);
            testFileResults.add(6, java.lang.Boolean.FALSE);
            testFilenameResults.add(6, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(falseFilters[1]);
            filters.add(falseFilters[2]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[3]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            final boolean[] trueResults = new boolean[]{ false , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(7, filters);
            testTrueResults.add(7, trueResults);
            testFalseResults.add(7, falseResults);
            testFileResults.add(7, java.lang.Boolean.FALSE);
            testFilenameResults.add(7, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(trueFilters[1]);
            filters.add(trueFilters[2]);
            filters.add(trueFilters[3]);
            filters.add(falseFilters[1]);
            final boolean[] trueResults = new boolean[]{ true , true , true };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(8, filters);
            testTrueResults.add(8, trueResults);
            testFalseResults.add(8, falseResults);
            testFileResults.add(8, java.lang.Boolean.FALSE);
            testFilenameResults.add(8, java.lang.Boolean.FALSE);
        }
        {
            final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> filters = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>();
            filters.add(falseFilters[1]);
            filters.add(falseFilters[2]);
            filters.add(falseFilters[3]);
            final boolean[] trueResults = new boolean[]{ false , false , false };
            final boolean[] falseResults = new boolean[]{ true , false , false };
            testFilters.add(9, filters);
            testTrueResults.add(9, trueResults);
            testFalseResults.add(9, falseResults);
            testFileResults.add(9, java.lang.Boolean.FALSE);
            testFilenameResults.add(9, java.lang.Boolean.FALSE);
        }
    }
}

