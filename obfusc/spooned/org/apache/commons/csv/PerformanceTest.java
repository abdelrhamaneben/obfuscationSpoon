package org.apache.commons.csv;


@java.lang.SuppressWarnings(value = "boxing")
public class PerformanceTest {
    private static final java.lang.String[] PROPS = new java.lang.String[]{ "java.version" , "java.vendor" , "java.vm.version" , "java.vm.name" , "os.name" , "os.arch" , "os.version" };

    private static int max = 10;

    private static int num = 0;

    private static long[] elapsedTimes = new long[org.apache.commons.csv.PerformanceTest.max];

    private static final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.EXCEL;

    private static final java.io.File BIG_FILE = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") , "worldcitiespop.txt");

    public static void main(final java.lang.String[] args) throws java.lang.Exception {
        if (BIG_FILE.exists()) {
            java.lang.System.out.println(java.lang.String.format("Found test fixture %s: %,d bytes.", BIG_FILE, BIG_FILE.length()));
        } else {
            java.lang.System.out.println((("Decompressing test fixture " + (BIG_FILE)) + "..."));
            final java.io.InputStream input = new java.util.zip.GZIPInputStream(new java.io.FileInputStream("src/test/resources/perf/worldcitiespop.txt.gz"));
            final java.io.OutputStream output = new java.io.FileOutputStream(BIG_FILE);
            org.apache.commons.io.IOUtils.copy(input, output);
            input.close();
            output.close();
            java.lang.System.out.println(java.lang.String.format("Decompressed test fixture %s: %,d bytes.", BIG_FILE, BIG_FILE.length()));
        }
        final int argc = args.length;
        java.lang.String[] tests;
        if (argc > 0) {
            org.apache.commons.csv.PerformanceTest.max = java.lang.Integer.parseInt(args[0]);
        } 
        if (argc > 1) {
            tests = new java.lang.String[argc - 1];
            for (int i = 1 ; i < argc ; i++) {
                tests[(i - 1)] = args[i];
            }
        } else {
            tests = new java.lang.String[]{ "file" , "split" , "extb" , "exts" , "csv" , "lexreset" , "lexnew" };
        }
        for (final java.lang.String p : PROPS) {
            java.lang.System.out.println(((p + "=") + (java.lang.System.getProperty(p))));
        }
        java.lang.System.out.println((("Max count: " + (org.apache.commons.csv.PerformanceTest.max)) + "\n"));
        for (final java.lang.String test : tests) {
            if ("file".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testReadBigFile(false);
            } else if ("split".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testReadBigFile(true);
            } else if ("csv".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testParseCommonsCSV();
            } else if ("lexreset".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testCSVLexer(false, test);
            } else if ("lexnew".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testCSVLexer(true, test);
            } else if (test.startsWith("CSVLexer")) {
                org.apache.commons.csv.PerformanceTest.testCSVLexer(false, test);
            } else if ("extb".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testExtendedBuffer(false);
            } else if ("exts".equals(test)) {
                org.apache.commons.csv.PerformanceTest.testExtendedBuffer(true);
            } else {
                java.lang.System.out.println(("Invalid test name: " + test));
            }
        }
    }

    private static java.io.BufferedReader getReader() throws java.io.IOException {
        return new java.io.BufferedReader(new java.io.FileReader(BIG_FILE));
    }

    private static class Stats {
        final int count;

        final int fields;

        Stats(final int c ,final int f) {
            count = c;
            fields = f;
        }
    }

    private static void show(final java.lang.String msg, final org.apache.commons.csv.PerformanceTest.Stats s, final long start) {
        final long elapsed = (java.lang.System.currentTimeMillis()) - start;
        java.lang.System.out.printf((((("%-20s: %5dms " + (s.count)) + " lines ") + (s.fields)) + " fields%n"), msg, elapsed);
        org.apache.commons.csv.PerformanceTest.elapsedTimes[(org.apache.commons.csv.PerformanceTest.num)++] = elapsed;
    }

    private static void show() {
        long tot = 0;
        if ((org.apache.commons.csv.PerformanceTest.num) > 1) {
            for (int i = 1 ; i < (org.apache.commons.csv.PerformanceTest.num) ; i++) {
                tot += org.apache.commons.csv.PerformanceTest.elapsedTimes[i];
            }
            java.lang.System.out.printf("%-20s: %5dms%n%n", "Average(not first)", (tot / ((org.apache.commons.csv.PerformanceTest.num) - 1)));
        } 
        org.apache.commons.csv.PerformanceTest.num = 0;
    }

    private static void testReadBigFile(final boolean split) throws java.lang.Exception {
        for (int i = 0 ; i < (org.apache.commons.csv.PerformanceTest.max) ; i++) {
            final java.io.BufferedReader in = org.apache.commons.csv.PerformanceTest.getReader();
            final long t0 = java.lang.System.currentTimeMillis();
            final org.apache.commons.csv.PerformanceTest.Stats s = org.apache.commons.csv.PerformanceTest.readAll(in, split);
            in.close();
            org.apache.commons.csv.PerformanceTest.show((split ? "file+split" : "file"), s, t0);
        }
        org.apache.commons.csv.PerformanceTest.show();
    }

    private static org.apache.commons.csv.PerformanceTest.Stats readAll(final java.io.BufferedReader in, final boolean split) throws java.io.IOException {
        int count = 0;
        int fields = 0;
        java.lang.String record;
        while ((record = in.readLine()) != null) {
            count++;
            fields += split ? record.split(",").length : 1;
        }
        return new org.apache.commons.csv.PerformanceTest.Stats(count , fields);
    }

    private static void testExtendedBuffer(final boolean makeString) throws java.lang.Exception {
        for (int i = 0 ; i < (org.apache.commons.csv.PerformanceTest.max) ; i++) {
            final org.apache.commons.csv.ExtendedBufferedReader in = new org.apache.commons.csv.ExtendedBufferedReader(org.apache.commons.csv.PerformanceTest.getReader());
            final long t0 = java.lang.System.currentTimeMillis();
            int read;
            int fields = 0;
            int lines = 0;
            if (makeString) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while ((read = in.read()) != (-1)) {
                    sb.append(((char)(read)));
                    if (read == ',') {
                        sb.toString();
                        sb = new java.lang.StringBuilder();
                        fields++;
                    } else if (read == '\n') {
                        sb.toString();
                        sb = new java.lang.StringBuilder();
                        lines++;
                    } 
                }
            } else {
                while ((read = in.read()) != (-1)) {
                    if (read == ',') {
                        fields++;
                    } else if (read == '\n') {
                        lines++;
                    } 
                }
            }
            fields += lines;
            in.close();
            org.apache.commons.csv.PerformanceTest.show(("Extended" + (makeString ? " toString" : "")), new org.apache.commons.csv.PerformanceTest.Stats(lines , fields), t0);
        }
        org.apache.commons.csv.PerformanceTest.show();
    }

    private static void testParseCommonsCSV() throws java.lang.Exception {
        for (int i = 0 ; i < (org.apache.commons.csv.PerformanceTest.max) ; i++) {
            final java.io.BufferedReader reader = org.apache.commons.csv.PerformanceTest.getReader();
            final org.apache.commons.csv.CSVParser parser = new org.apache.commons.csv.CSVParser(reader , format);
            final long t0 = java.lang.System.currentTimeMillis();
            final org.apache.commons.csv.PerformanceTest.Stats s = org.apache.commons.csv.PerformanceTest.iterate(parser);
            reader.close();
            org.apache.commons.csv.PerformanceTest.show("CSV", s, t0);
            parser.close();
        }
        org.apache.commons.csv.PerformanceTest.show();
    }

    private static java.lang.reflect.Constructor<org.apache.commons.csv.Lexer> getLexerCtor(final java.lang.String clazz) throws java.lang.Exception {
        @java.lang.SuppressWarnings(value = "unchecked")
        final java.lang.Class<org.apache.commons.csv.Lexer> lexer = ((java.lang.Class<org.apache.commons.csv.Lexer>)(java.lang.Class.forName(("org.apache.commons.csv." + clazz))));
        return lexer.getConstructor(new java.lang.Class<?>[]{ org.apache.commons.csv.CSVFormat.class , org.apache.commons.csv.ExtendedBufferedReader.class });
    }

    private static void testCSVLexer(final boolean newToken, final java.lang.String test) throws java.lang.Exception {
        org.apache.commons.csv.Token token = new org.apache.commons.csv.Token();
        java.lang.String dynamic = "";
        for (int i = 0 ; i < (org.apache.commons.csv.PerformanceTest.max) ; i++) {
            final org.apache.commons.csv.ExtendedBufferedReader input = new org.apache.commons.csv.ExtendedBufferedReader(org.apache.commons.csv.PerformanceTest.getReader());
            org.apache.commons.csv.Lexer lexer = null;
            if (test.startsWith("CSVLexer")) {
                dynamic = "!";
                lexer = org.apache.commons.csv.PerformanceTest.getLexerCtor(test).newInstance(new java.lang.Object[]{ format , input });
            } else {
                lexer = new org.apache.commons.csv.Lexer(format , input);
            }
            int count = 0;
            int fields = 0;
            final long t0 = java.lang.System.currentTimeMillis();
            do {
                if (newToken) {
                    token = new org.apache.commons.csv.Token();
                } else {
                    token.a();
                }
                lexer.a(token);
                switch (token.type) {
                    case EOF :
                        break;
                    case EORECORD :
                        fields++;
                        count++;
                        break;
                    case INVALID :
                        throw new java.io.IOException((("invalid parse sequence <" + (token.content.toString())) + ">"));
                    case TOKEN :
                        fields++;
                        break;
                    case COMMENT :
                        break;
                    default :
                        throw new java.lang.IllegalStateException(("Unexpected Token type: " + (token.type)));
                }
            } while (!(token.type.equals(org.apache.commons.csv.Token.Type.EOF)) );
            final org.apache.commons.csv.PerformanceTest.Stats s = new org.apache.commons.csv.PerformanceTest.Stats(count , fields);
            input.close();
            org.apache.commons.csv.PerformanceTest.show(((((lexer.getClass().getSimpleName()) + dynamic) + " ") + (newToken ? "new" : "reset")), s, t0);
        }
        org.apache.commons.csv.PerformanceTest.show();
    }

    private static org.apache.commons.csv.PerformanceTest.Stats iterate(final java.lang.Iterable<org.apache.commons.csv.CSVRecord> it) {
        int count = 0;
        int fields = 0;
        for (final org.apache.commons.csv.CSVRecord record : it) {
            count++;
            fields += record.b();
        }
        return new org.apache.commons.csv.PerformanceTest.Stats(count , fields);
    }
}

