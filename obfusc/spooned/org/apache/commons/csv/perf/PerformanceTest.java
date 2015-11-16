package org.apache.commons.csv.perf;


@java.lang.SuppressWarnings(value = "boxing")
public class PerformanceTest {
    private final int max = 10;

    private static final java.io.File BIG_FILE = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") , "worldcitiespop.txt");

    @org.junit.BeforeClass
    public static void b() throws java.io.FileNotFoundException, java.io.IOException {
        if (BIG_FILE.exists()) {
            java.lang.System.out.println(java.lang.String.format("Found test fixture %s: %,d bytes.", BIG_FILE, BIG_FILE.length()));
            return ;
        } 
        java.lang.System.out.println((("Decompressing test fixture " + (BIG_FILE)) + "..."));
        final java.io.InputStream input = new java.util.zip.GZIPInputStream(new java.io.FileInputStream("src/test/resources/perf/worldcitiespop.txt.gz"));
        final java.io.OutputStream output = new java.io.FileOutputStream(BIG_FILE);
        org.apache.commons.io.IOUtils.copy(input, output);
        java.lang.System.out.println(java.lang.String.format("Decompressed test fixture %s: %,d bytes.", BIG_FILE, BIG_FILE.length()));
        input.close();
        output.close();
    }

    private java.io.BufferedReader a() throws java.io.IOException {
        return new java.io.BufferedReader(new java.io.FileReader(BIG_FILE));
    }

    private long a(final java.io.Reader in, final boolean traverseColumns) throws java.io.IOException {
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.d(false);
        long recordCount = 0;
        for (final org.apache.commons.csv.CSVRecord record : format.a(in)) {
            recordCount++;
            if (traverseColumns) {
                for (@java.lang.SuppressWarnings(value = "unused")
                final java.lang.String value : record) {
                }
            } 
        }
        return recordCount;
    }

    private void a(final java.lang.String s) {
        java.lang.System.out.println(s);
    }

    private long a(final java.io.BufferedReader in) throws java.io.IOException {
        long count = 0;
        while ((in.readLine()) != null) {
            count++;
        }
        return count;
    }

    public long a(final boolean traverseColumns) throws java.lang.Exception {
        final long startMillis = java.lang.System.currentTimeMillis();
        final long count = a(a(), traverseColumns);
        final long totalMillis = (java.lang.System.currentTimeMillis()) - startMillis;
        a(java.lang.String.format("File parsed in %,d milliseconds with Commons CSV: %,d lines.", totalMillis, count));
        return totalMillis;
    }

    @org.junit.Test
    public void testParseBigFileRepeat() throws java.lang.Exception {
        long bestTime = java.lang.Long.MAX_VALUE;
        for (int i = 0 ; i < (this.max) ; i++) {
            bestTime = java.lang.Math.min(a(false), bestTime);
        }
        a(java.lang.String.format("Best time out of %,d is %,d milliseconds.", this.max, bestTime));
    }

    @org.junit.Test
    public void testReadBigFile() throws java.lang.Exception {
        long bestTime = java.lang.Long.MAX_VALUE;
        for (int i = 0 ; i < (this.max) ; i++) {
            final java.io.BufferedReader in = a();
            final long startMillis = java.lang.System.currentTimeMillis();
            long count = 0;
            try {
                count = a(in);
            } finally {
                in.close();
            }
            final long totalMillis = (java.lang.System.currentTimeMillis()) - startMillis;
            bestTime = java.lang.Math.min(totalMillis, bestTime);
            a(java.lang.String.format("File read in %,d milliseconds: %,d lines.", totalMillis, count));
        }
        a(java.lang.String.format("Best time out of %,d is %,d milliseconds.", this.max, bestTime));
    }
}

