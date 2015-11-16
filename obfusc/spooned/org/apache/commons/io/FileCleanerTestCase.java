package org.apache.commons.io;


@java.lang.SuppressWarnings(value = "deprecation")
public class FileCleanerTestCase extends org.apache.commons.io.FileCleaningTrackerTestCase {
    @java.lang.Override
    protected org.apache.commons.io.FileCleaningTracker testGetPath_with_nullbyte() {
        return org.apache.commons.io.FileCleaner.getInstance();
    }

    public FileCleanerTestCase(final java.lang.String name) {
        super(name);
    }
}

