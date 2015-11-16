package org.apache.commons.csv;


@org.junit.runner.RunWith(value = org.junit.runners.Parameterized.class)
public class CSVFileParserTest {
    private static final java.io.File BASE = new java.io.File("src/test/resources/CSVFileParser");

    private final java.io.BufferedReader testData;

    private final java.lang.String testName;

    public CSVFileParserTest(final java.io.File file) throws java.io.FileNotFoundException {
        this.testName = file.getName();
        this.testData = new java.io.BufferedReader(new java.io.FileReader(file));
    }

    private java.lang.String a() throws java.io.IOException {
        java.lang.String line;
        do {
            line = testData.readLine();
        } while ((line != null) && (line.startsWith("#")) );
        return line;
    }

    @org.junit.runners.Parameterized.Parameters
    public static java.util.Collection<java.lang.Object[]> b() {
        final java.util.List<java.lang.Object[]> list = new java.util.ArrayList<java.lang.Object[]>();
        final java.io.FilenameFilter filenameFilter = new java.io.FilenameFilter() {
            @java.lang.Override
            public boolean accept(final java.io.File dir, final java.lang.String name) {
                return (name.startsWith("test")) && (name.endsWith(".txt"));
            }
        };
        final java.io.File[] files = BASE.listFiles(filenameFilter);
        for (final java.io.File f : files) {
            list.add(new java.lang.Object[]{ f });
        }
        return list;
    }

    @org.junit.Test
    public void testCSVFile() throws java.lang.Exception {
        java.lang.String line = a();
        org.junit.Assert.assertNotNull("file must contain config line", line);
        final java.lang.String[] split = line.split(" ");
        org.junit.Assert.assertTrue(((testName) + " require 1 param"), ((split.length) >= 1));
        org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(',').d('\"');
        boolean checkComments = false;
        for (int i = 1 ; i < (split.length) ; i++) {
            final java.lang.String option = split[i];
            final java.lang.String[] option_parts = option.split("=", 2);
            if ("IgnoreEmpty".equalsIgnoreCase(option_parts[0])) {
                format = format.b(java.lang.Boolean.parseBoolean(option_parts[1]));
            } else if ("IgnoreSpaces".equalsIgnoreCase(option_parts[0])) {
                format = format.d(java.lang.Boolean.parseBoolean(option_parts[1]));
            } else if ("CommentStart".equalsIgnoreCase(option_parts[0])) {
                format = format.a(option_parts[1].charAt(0));
            } else if ("CheckComments".equalsIgnoreCase(option_parts[0])) {
                checkComments = true;
            } else {
                org.junit.Assert.fail((((testName) + " unexpected option: ") + option));
            }
        }
        line = a();
        org.junit.Assert.assertEquals(((testName) + " Expected format "), line, format.toString());
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(new java.io.File(BASE , split[0]), java.nio.charset.Charset.defaultCharset(), format);
        for (final org.apache.commons.csv.CSVRecord record : parser) {
            java.lang.String parsed = java.util.Arrays.toString(record.d());
            if (checkComments) {
                final java.lang.String comment = record.c().replace("\n", "\\n");
                if (comment != null) {
                    parsed += "#" + comment;
                } 
            } 
            final int count = record.b();
            org.junit.Assert.assertEquals(testName, a(), ((count + ":") + parsed));
        }
        parser.close();
    }

    @org.junit.Test
    public void testCSVUrl() throws java.lang.Exception {
        java.lang.String line = a();
        org.junit.Assert.assertNotNull("file must contain config line", line);
        final java.lang.String[] split = line.split(" ");
        org.junit.Assert.assertTrue(((testName) + " require 1 param"), ((split.length) >= 1));
        org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(',').d('\"');
        boolean checkComments = false;
        for (int i = 1 ; i < (split.length) ; i++) {
            final java.lang.String option = split[i];
            final java.lang.String[] option_parts = option.split("=", 2);
            if ("IgnoreEmpty".equalsIgnoreCase(option_parts[0])) {
                format = format.b(java.lang.Boolean.parseBoolean(option_parts[1]));
            } else if ("IgnoreSpaces".equalsIgnoreCase(option_parts[0])) {
                format = format.d(java.lang.Boolean.parseBoolean(option_parts[1]));
            } else if ("CommentStart".equalsIgnoreCase(option_parts[0])) {
                format = format.a(option_parts[1].charAt(0));
            } else if ("CheckComments".equalsIgnoreCase(option_parts[0])) {
                checkComments = true;
            } else {
                org.junit.Assert.fail((((testName) + " unexpected option: ") + option));
            }
        }
        line = a();
        org.junit.Assert.assertEquals(((testName) + " Expected format "), line, format.toString());
        final java.net.URL resource = java.lang.ClassLoader.getSystemResource(("CSVFileParser/" + (split[0])));
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(resource, java.nio.charset.Charset.forName("UTF-8"), format);
        for (final org.apache.commons.csv.CSVRecord record : parser) {
            java.lang.String parsed = java.util.Arrays.toString(record.d());
            if (checkComments) {
                final java.lang.String comment = record.c().replace("\n", "\\n");
                if (comment != null) {
                    parsed += "#" + comment;
                } 
            } 
            final int count = record.b();
            org.junit.Assert.assertEquals(testName, a(), ((count + ":") + parsed));
        }
        parser.close();
    }
}

