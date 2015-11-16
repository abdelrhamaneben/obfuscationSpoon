package org.apache.commons.csv;


public class CSVPrinterTest {
    private final java.lang.String recordSeparator = org.apache.commons.csv.CSVFormat.DEFAULT.o();

    private static java.lang.String printable(final java.lang.String s) {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0 ; i < (s.length()) ; i++) {
            final char ch = s.charAt(i);
            if ((ch <= ' ') || (ch >= 128)) {
                sb.append("(").append(((int)(ch))).append(")");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private void a(final org.apache.commons.csv.CSVFormat format) throws java.lang.Exception {
        final java.util.Random r = new java.util.Random();
        final int nLines = (r.nextInt(4)) + 1;
        final int nCol = (r.nextInt(3)) + 1;
        final java.lang.String[][] lines = new java.lang.String[nLines][];
        for (int i = 0 ; i < nLines ; i++) {
            final java.lang.String[] line = new java.lang.String[nCol];
            lines[i] = line;
            for (int j = 0 ; j < nCol ; j++) {
                line[j] = a();
            }
        }
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , format);
        for (int i = 0 ; i < nLines ; i++) {
            printer.b(((java.lang.Object[])(lines[i])));
        }
        printer.flush();
        printer.close();
        final java.lang.String result = sw.toString();
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(result, format);
        final java.util.List<org.apache.commons.csv.CSVRecord> parseResult = parser.b();
        org.apache.commons.csv.Utils.compare(("Printer output :" + (org.apache.commons.csv.CSVPrinterTest.printable(result))), lines, parseResult);
        parser.close();
    }

    private void a(final org.apache.commons.csv.CSVFormat format, final int iter) throws java.lang.Exception {
        for (int i = 0 ; i < iter ; i++) {
            a(format);
        }
    }

    private java.lang.String a() {
        final java.util.Random r = new java.util.Random();
        final int sz = r.nextInt(20);
        final char[] buf = new char[sz];
        for (int i = 0 ; i < sz ; i++) {
            char ch;
            final int what = r.nextInt(20);
            switch (what) {
                case 0 :
                    ch = '\r';
                    break;
                case 1 :
                    ch = '\n';
                    break;
                case 2 :
                    ch = '\t';
                    break;
                case 3 :
                    ch = '\f';
                    break;
                case 4 :
                    ch = ' ';
                    break;
                case 5 :
                    ch = ',';
                    break;
                case 6 :
                    ch = '\"';
                    break;
                case 7 :
                    ch = '\'';
                    break;
                case 8 :
                    ch = '\\';
                    break;
                default :
                    ch = ((char)(r.nextInt(300)));
                    break;
            }
            buf[i] = ch;
        }
        return new java.lang.String(buf);
    }

    @org.junit.Test
    public void testDisabledComment() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("This is a comment");
        org.junit.Assert.assertEquals("", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrintAllArrayOfArrays() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.c(((java.lang.Object[])(new java.lang.String[][]{ new java.lang.String[]{ "r1c1" , "r1c2" } , new java.lang.String[]{ "r2c1" , "r2c2" } })));
        org.junit.Assert.assertEquals(((("r1c1,r1c2" + (recordSeparator)) + "r2c1,r2c2") + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrintAllArrayOfLists() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.c(((java.lang.Object[])(new java.util.List[]{ java.util.Arrays.asList("r1c1", "r1c2") , java.util.Arrays.asList("r2c1", "r2c2") })));
        org.junit.Assert.assertEquals(((("r1c1,r1c2" + (recordSeparator)) + "r2c1,r2c2") + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrintAllIterableOfArrays() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.c(java.util.Arrays.asList(new java.lang.String[][]{ new java.lang.String[]{ "r1c1" , "r1c2" } , new java.lang.String[]{ "r2c1" , "r2c2" } }));
        org.junit.Assert.assertEquals(((("r1c1,r1c2" + (recordSeparator)) + "r2c1,r2c2") + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrintAllIterableOfLists() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.c(java.util.Arrays.asList(new java.util.List[]{ java.util.Arrays.asList("r1c1", "r1c2") , java.util.Arrays.asList("r2c1", "r2c2") }));
        org.junit.Assert.assertEquals(((("r1c1,r1c2" + (recordSeparator)) + "r2c1,r2c2") + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrinter1() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.b("a", "b");
        org.junit.Assert.assertEquals(("a,b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testExcelPrinter2() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.EXCEL);
        printer.b("a,b", "b");
        org.junit.Assert.assertEquals(("\"a,b\",b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    private java.sql.Connection b() throws java.lang.ClassNotFoundException, java.sql.SQLException {
        java.lang.Class.forName("org.h2.Driver");
        return java.sql.DriverManager.getConnection("jdbc:h2:mem:my_test;", "sa", "");
    }

    @org.junit.Test
    public void testJdbcPrinter() throws java.io.IOException, java.lang.ClassNotFoundException, java.sql.SQLException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final java.sql.Connection connection = b();
        try {
            a(connection);
            final java.sql.Statement stmt = connection.createStatement();
            final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
            printer.b(stmt.executeQuery("select ID, NAME from TEST"));
            org.junit.Assert.assertEquals(((("1,r1" + (recordSeparator)) + "2,r2") + (recordSeparator)), sw.toString());
            printer.close();
        } finally {
            connection.close();
        }
    }

    @org.junit.Test
    public void testJdbcPrinterWithResultSet() throws java.io.IOException, java.lang.ClassNotFoundException, java.sql.SQLException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        java.lang.Class.forName("org.h2.Driver");
        final java.sql.Connection connection = b();
        try {
            a(connection);
            @java.lang.SuppressWarnings(value = "resource")
            final java.sql.Statement stmt = connection.createStatement();
            @java.lang.SuppressWarnings(value = "resource")
            final java.sql.ResultSet resultSet = stmt.executeQuery("select ID, NAME from TEST");
            final org.apache.commons.csv.CSVPrinter printer = org.apache.commons.csv.CSVFormat.DEFAULT.a(resultSet).a(sw);
            printer.b(resultSet);
            org.junit.Assert.assertEquals(((((("ID,NAME" + (recordSeparator)) + "1,r1") + (recordSeparator)) + "2,r2") + (recordSeparator)), sw.toString());
            printer.close();
        } finally {
            connection.close();
        }
    }

    @org.junit.Test
    public void testJdbcPrinterWithResultSetMetaData() throws java.io.IOException, java.lang.ClassNotFoundException, java.sql.SQLException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        java.lang.Class.forName("org.h2.Driver");
        final java.sql.Connection connection = b();
        try {
            a(connection);
            @java.lang.SuppressWarnings(value = "resource")
            final java.sql.Statement stmt = connection.createStatement();
            @java.lang.SuppressWarnings(value = "resource")
            final java.sql.ResultSet resultSet = stmt.executeQuery("select ID, NAME from TEST");
            final org.apache.commons.csv.CSVPrinter printer = org.apache.commons.csv.CSVFormat.DEFAULT.a(resultSet.getMetaData()).a(sw);
            printer.b(resultSet);
            org.junit.Assert.assertEquals(((((("ID,NAME" + (recordSeparator)) + "1,r1") + (recordSeparator)) + "2,r2") + (recordSeparator)), sw.toString());
            printer.close();
        } finally {
            connection.close();
        }
    }

    private void a(final java.sql.Connection connection) throws java.sql.SQLException {
        final java.sql.Statement statement = connection.createStatement();
        try {
            statement.execute("CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))");
            statement.execute("insert into TEST values(1, \'r1\')");
            statement.execute("insert into TEST values(2, \'r2\')");
        } finally {
            statement.close();
        }
    }

    @org.junit.Test
    public void testMultiLineComment() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.a('#'));
        printer.b("This is a comment\non multiple lines");
        org.junit.Assert.assertEquals(((("# This is a comment" + (recordSeparator)) + "# on multiple lines") + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter1() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", "b");
        org.junit.Assert.assertEquals(("a,b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter2() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a,b", "b");
        org.junit.Assert.assertEquals(("\"a,b\",b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter3() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a, b", "b ");
        org.junit.Assert.assertEquals(("\"a, b\",\"b \"" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter4() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", "b\"c");
        org.junit.Assert.assertEquals(("a,\"b\"\"c\"" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter5() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", "b\nc");
        org.junit.Assert.assertEquals(("a,\"b\nc\"" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter6() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", "b\r\nc");
        org.junit.Assert.assertEquals(("a,\"b\r\nc\"" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrinter7() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", "b\\c");
        org.junit.Assert.assertEquals(("a,b\\c" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrint() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = org.apache.commons.csv.CSVFormat.DEFAULT.a(sw);
        printer.b("a", "b\\c");
        org.junit.Assert.assertEquals(("a,b\\c" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrintNullValues() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT);
        printer.b("a", null, "b");
        org.junit.Assert.assertEquals(("a,,b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPrintCustomNullValues() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.a("NULL"));
        printer.b("a", null, "b");
        org.junit.Assert.assertEquals(("a,NULL,b" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testParseCustomNullValues() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.a("NULL");
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , format);
        printer.b("a", null, "b");
        printer.close();
        final java.lang.String csvString = sw.toString();
        org.junit.Assert.assertEquals(("a,NULL,b" + (recordSeparator)), csvString);
        final java.lang.Iterable<org.apache.commons.csv.CSVRecord> iterable = format.a(new java.io.StringReader(csvString));
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> iterator = iterable.iterator();
        final org.apache.commons.csv.CSVRecord record = iterator.next();
        org.junit.Assert.assertEquals("a", record.a(0));
        org.junit.Assert.assertEquals(null, record.a(1));
        org.junit.Assert.assertEquals("b", record.a(2));
        org.junit.Assert.assertFalse(iterator.hasNext());
        ((org.apache.commons.csv.CSVParser)(iterable)).close();
    }

    @org.junit.Test
    public void testQuoteAll() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.a(org.apache.commons.csv.QuoteMode.ALL));
        printer.b("a", "b\nc", "d");
        org.junit.Assert.assertEquals(("\"a\",\"b\nc\",\"d\"" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testQuoteNonNumeric() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.a(org.apache.commons.csv.QuoteMode.NON_NUMERIC));
        printer.b("a", "b\nc", java.lang.Integer.valueOf(1));
        org.junit.Assert.assertEquals(("\"a\",\"b\nc\",1" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testRandom() throws java.lang.Exception {
        final int iter = 10000;
        a(org.apache.commons.csv.CSVFormat.DEFAULT, iter);
        a(org.apache.commons.csv.CSVFormat.EXCEL, iter);
        a(org.apache.commons.csv.CSVFormat.MYSQL, iter);
    }

    @org.junit.Test
    public void testPlainQuoted() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.d('\''));
        printer.a("abc");
        org.junit.Assert.assertEquals("abc", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testSingleLineComment() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.a('#'));
        printer.b("This is a comment");
        org.junit.Assert.assertEquals(("# This is a comment" + (recordSeparator)), sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testSingleQuoteQuoted() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.d('\''));
        printer.a("a\'b\'c");
        printer.a("xyz");
        org.junit.Assert.assertEquals("\'a\'\'b\'\'c\',xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testDelimeterQuoted() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.d('\''));
        printer.a("a,b,c");
        printer.a("xyz");
        org.junit.Assert.assertEquals("\'a,b,c\',xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testDelimeterQuoteNONE() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.c('!').a(org.apache.commons.csv.QuoteMode.NONE);
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , format);
        printer.a("a,b,c");
        printer.a("xyz");
        org.junit.Assert.assertEquals("a!,b!,c,xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testEOLQuoted() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.d('\''));
        printer.a("a\rb\nc");
        printer.a("x\by\fz");
        org.junit.Assert.assertEquals("\'a\rb\nc\',x\by\fz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPlainEscaped() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null).c('!'));
        printer.a("abc");
        printer.a("xyz");
        org.junit.Assert.assertEquals("abc,xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testDelimiterEscaped() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c('!').c(null));
        printer.a("a,b,c");
        printer.a("xyz");
        org.junit.Assert.assertEquals("a!,b!,c,xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testEOLEscaped() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null).c('!'));
        printer.a("a\rb\nc");
        printer.a("x\fy\bz");
        org.junit.Assert.assertEquals("a!rb!nc,x\fy\bz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testPlainPlain() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null));
        printer.a("abc");
        printer.a("xyz");
        org.junit.Assert.assertEquals("abc,xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testDelimiterPlain() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null));
        printer.a("a,b,c");
        printer.a("xyz");
        org.junit.Assert.assertEquals("a,b,c,xyz", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testHeader() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null).c("C1", "C2", "C3"));
        printer.b("a", "b", "c");
        printer.b("x", "y", "z");
        org.junit.Assert.assertEquals("C1,C2,C3\r\na,b,c\r\nx,y,z\r\n", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testHeaderNotSet() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null));
        printer.b("a", "b", "c");
        printer.b("x", "y", "z");
        org.junit.Assert.assertEquals("a,b,c\r\nx,y,z\r\n", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testSkipHeaderRecordTrue() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null).c("C1", "C2", "C3").e(true));
        printer.b("a", "b", "c");
        printer.b("x", "y", "z");
        org.junit.Assert.assertEquals("a,b,c\r\nx,y,z\r\n", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testSkipHeaderRecordFalse() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null).c("C1", "C2", "C3").e(false));
        printer.b("a", "b", "c");
        printer.b("x", "y", "z");
        org.junit.Assert.assertEquals("C1,C2,C3\r\na,b,c\r\nx,y,z\r\n", sw.toString());
        printer.close();
    }

    @org.junit.Test
    public void testHeaderCommentExcel() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final java.util.Date now = new java.util.Date();
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.EXCEL;
        final org.apache.commons.csv.CSVPrinter csvPrinter = a(sw, now, format);
        org.junit.Assert.assertEquals((("# Generated by Apache Commons CSV 1.1\r\n# " + now) + "\r\nCol1,Col2\r\nA,B\r\nC,D\r\n"), sw.toString());
        csvPrinter.close();
    }

    @org.junit.Test
    public void testHeaderCommentTdf() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final java.util.Date now = new java.util.Date();
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.TDF;
        final org.apache.commons.csv.CSVPrinter csvPrinter = a(sw, now, format);
        org.junit.Assert.assertEquals((("# Generated by Apache Commons CSV 1.1\r\n# " + now) + "\r\nCol1\tCol2\r\nA\tB\r\nC\tD\r\n"), sw.toString());
        csvPrinter.close();
    }

    private org.apache.commons.csv.CSVPrinter a(final java.io.StringWriter sw, final java.util.Date now, final org.apache.commons.csv.CSVFormat baseFormat) throws java.io.IOException {
        org.apache.commons.csv.CSVFormat format = baseFormat;
        format = format.d("Generated by Apache Commons CSV 1.1", now);
        format = format.a('#');
        format = format.c("Col1", "Col2");
        final org.apache.commons.csv.CSVPrinter csvPrinter = format.a(sw);
        csvPrinter.b("A", "B");
        csvPrinter.b("C", "D");
        csvPrinter.close();
        return csvPrinter;
    }

    @org.junit.Test
    public void testEOLPlain() throws java.io.IOException {
        final java.io.StringWriter sw = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(sw , org.apache.commons.csv.CSVFormat.DEFAULT.c(null));
        printer.a("a\rb\nc");
        printer.a("x\fy\bz");
        org.junit.Assert.assertEquals("a\rb\nc,x\fy\bz", sw.toString());
        printer.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testInvalidFormat() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat invalidFormat = org.apache.commons.csv.CSVFormat.DEFAULT.b(org.apache.commons.csv.Constants.CR);
        new org.apache.commons.csv.CSVPrinter(new java.io.StringWriter() , invalidFormat).close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testNewCSVPrinterNullAppendableFormat() throws java.lang.Exception {
        new org.apache.commons.csv.CSVPrinter(null , org.apache.commons.csv.CSVFormat.DEFAULT).close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testNewCsvPrinterAppendableNullFormat() throws java.lang.Exception {
        new org.apache.commons.csv.CSVPrinter(new java.io.StringWriter() , null).close();
    }
}

