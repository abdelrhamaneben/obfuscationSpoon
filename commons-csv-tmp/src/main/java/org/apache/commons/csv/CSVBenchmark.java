package org.apache.commons.csv;


@org.openjdk.jmh.annotations.BenchmarkMode(value = org.openjdk.jmh.annotations.Mode.AverageTime)
@org.openjdk.jmh.annotations.Fork(jvmArgs = { "-server" , "-Xms1024M" , "-Xmx1024M" }, value = 1)
@org.openjdk.jmh.annotations.Threads(value = 1)
@org.openjdk.jmh.annotations.Warmup(iterations = 5)
@org.openjdk.jmh.annotations.Measurement(iterations = 20)
@org.openjdk.jmh.annotations.OutputTimeUnit(value = java.util.concurrent.TimeUnit.MILLISECONDS)
@org.openjdk.jmh.annotations.State(value = org.openjdk.jmh.annotations.Scope.Benchmark)
public class CSVBenchmark {
    private java.lang.String data;

    @org.openjdk.jmh.annotations.Setup
    public void b() throws java.io.IOException {
        final java.io.File file = new java.io.File("src/test/resources/perf/worldcitiespop.txt.gz");
        final java.io.InputStream in = new java.util.zip.GZIPInputStream(new java.io.FileInputStream(file));
        this.data = org.apache.commons.io.IOUtils.toString(in, "ISO-8859-1");
        in.close();
    }

    private java.io.BufferedReader a() throws java.io.IOException {
        return new java.io.BufferedReader(new java.io.StringReader(data));
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int g(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        int count = 0;
        java.lang.String line;
        while ((line = in.readLine()) != null) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int h(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        int count = 0;
        java.lang.String line;
        while ((line = in.readLine()) != null) {
            final java.lang.String[] values = org.apache.commons.lang3.StringUtils.split(line, ',');
            count += values.length;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int a(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.c();
        int count = 0;
        for (final org.apache.commons.csv.CSVRecord record : format.a(in)) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int b(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final com.generationjava.io.CsvReader reader = new com.generationjava.io.CsvReader(in);
        reader.setFieldDelimiter(',');
        int count = 0;
        java.lang.String[] record = null;
        while ((record = reader.readLine()) != null) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int c(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final com.csvreader.CsvReader reader = new com.csvreader.CsvReader(in , ',');
        reader.setRecordDelimiter('\n');
        int count = 0;
        while (reader.readRecord()) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int d(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final com.opencsv.CSVReader reader = new com.opencsv.CSVReader(in , ',');
        int count = 0;
        while ((reader.readNext()) != null) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int e(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final org.skife.csv.CSVReader reader = new org.skife.csv.SimpleReader();
        reader.setSeperator(',');
        final org.apache.commons.csv.CSVBenchmark.CountingReaderCallback callback = new org.apache.commons.csv.CSVBenchmark.CountingReaderCallback();
        reader.parse(in, callback);
        bh.consume(callback);
        in.close();
        return callback.count;
    }

    private static class CountingReaderCallback implements org.skife.csv.ReaderCallback {
        public int count = 0;

        @java.lang.Override
        public void onRow(final java.lang.String[] fields) {
            (count)++;
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public int f(final org.openjdk.jmh.infra.Blackhole bh) throws java.lang.Exception {
        final java.io.BufferedReader in = a();
        final org.supercsv.io.CsvListReader reader = new org.supercsv.io.CsvListReader(in , org.supercsv.prefs.CsvPreference.STANDARD_PREFERENCE);
        int count = 0;
        java.util.List<java.lang.String> record = null;
        while ((record = reader.read()) != null) {
            count++;
        }
        bh.consume(count);
        in.close();
        return count;
    }
}

