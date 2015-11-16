package org.apache.commons.csv;


public class CSVParserTest {
    private static final java.lang.String CSV_INPUT = "a,b,c,d\n" + (" a , b , 1 2 \n" + ("\"foo baar\", b,\n" + "   \"foo\n,,\n\"\",,\n\"\"\",d,e\n"));

    private static final java.lang.String CSV_INPUT_1 = "a,b,c,d";

    private static final java.lang.String CSV_INPUT_2 = "a,b,1 2";

    private static final java.lang.String[][] RESULT = new java.lang.String[][]{ new java.lang.String[]{ "a" , "b" , "c" , "d" } , new java.lang.String[]{ "a" , "b" , "1 2" } , new java.lang.String[]{ "foo baar" , "b" , "" } , new java.lang.String[]{ "foo\n,,\n\",,\n\"" , "d" , "e" } };

    @org.junit.Test
    public void testBackslashEscaping() throws java.io.IOException {
        final java.lang.String code = "one,two,three\n" + ("\'\',\'\'\n" + ("/\',/\'\n" + ("\'/\'\',\'/\'\'\n" + ("\'\'\'\',\'\'\'\'\n" + ("/,,/,\n" + ("//,//\n" + ("\'//\',\'//\'\n" + ("   8   ,   \"quoted \"\" /\" // string\"   \n" + ("9,   /\n   \n" + "")))))))));
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "one" , "two" , "three" } , new java.lang.String[]{ "" , "" } , new java.lang.String[]{ "\'" , "\'" } , new java.lang.String[]{ "\'" , "\'" } , new java.lang.String[]{ "\'" , "\'" } , new java.lang.String[]{ "," , "," } , new java.lang.String[]{ "/" , "/" } , new java.lang.String[]{ "/" , "/" } , new java.lang.String[]{ "   8   " , "   \"quoted \"\" /\" / string\"   " } , new java.lang.String[]{ "9" , "   \n   " } };
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(',').d('\'').b(org.apache.commons.csv.Constants.CRLF).c('/').s();
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, format);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertTrue(((records.size()) > 0));
        org.apache.commons.csv.Utils.compare("Records do not match expected result", res, records);
        parser.close();
    }

    @org.junit.Test
    public void testBackslashEscaping2() throws java.io.IOException {
        final java.lang.String code = "" + (" , , \n" + (" \t ,  , \n" + (" // , /, , /,\n" + "")));
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ " " , " " , " " } , new java.lang.String[]{ " \t " , "  " , " " } , new java.lang.String[]{ " / " , " , " , " ," } };
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(',').b(org.apache.commons.csv.Constants.CRLF).c('/').s();
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, format);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertTrue(((records.size()) > 0));
        org.apache.commons.csv.Utils.compare("", res, records);
        parser.close();
    }

    @org.junit.Test
    @org.junit.Ignore
    public void testBackslashEscapingOld() throws java.io.IOException {
        final java.lang.String code = "one,two,three\n" + ("on\\\"e,two\n" + ("on\"e,two\n" + ("one,\"tw\\\"o\"\n" + ("one,\"t\\,wo\"\n" + ("one,two,\"th,ree\"\n" + ("\"a\\\\\"\n" + ("a\\,b\n" + "\"a\\\\,b\"")))))));
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "one" , "two" , "three" } , new java.lang.String[]{ "on\\\"e" , "two" } , new java.lang.String[]{ "on\"e" , "two" } , new java.lang.String[]{ "one" , "tw\"o" } , new java.lang.String[]{ "one" , "t\\,wo" } , new java.lang.String[]{ "one" , "two" , "th,ree" } , new java.lang.String[]{ "a\\\\" } , new java.lang.String[]{ "a\\" , "b" } , new java.lang.String[]{ "a\\\\,b" } };
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(res.length, records.size());
        org.junit.Assert.assertTrue(((records.size()) > 0));
        for (int i = 0 ; i < (res.length) ; i++) {
            org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
        }
        parser.close();
    }

    @org.junit.Test
    @org.junit.Ignore(value = "CSV-107")
    public void testBOM() throws java.io.IOException {
        final java.net.URL url = java.lang.ClassLoader.getSystemClassLoader().getResource("CSVFileParser/bom.csv");
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(url, java.nio.charset.Charset.forName("UTF-8"), org.apache.commons.csv.CSVFormat.EXCEL.c());
        try {
            for (final org.apache.commons.csv.CSVRecord record : parser) {
                final java.lang.String string = record.c("Date");
                org.junit.Assert.assertNotNull(string);
            }
        } finally {
            parser.close();
        }
    }

    @org.junit.Test
    public void testBOMInputStream() throws java.io.IOException {
        final java.net.URL url = java.lang.ClassLoader.getSystemClassLoader().getResource("CSVFileParser/bom.csv");
        final java.io.Reader reader = new java.io.InputStreamReader(new org.apache.commons.io.input.BOMInputStream(url.openStream()) , "UTF-8");
        final org.apache.commons.csv.CSVParser parser = new org.apache.commons.csv.CSVParser(reader , org.apache.commons.csv.CSVFormat.EXCEL.c());
        try {
            for (final org.apache.commons.csv.CSVRecord record : parser) {
                final java.lang.String string = record.c("Date");
                org.junit.Assert.assertNotNull(string);
            }
        } finally {
            parser.close();
            reader.close();
        }
    }

    @org.junit.Test
    public void testCarriageReturnEndings() throws java.io.IOException {
        final java.lang.String code = "foo\rbaar,\rhello,world\r,kanu";
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(4, records.size());
        parser.close();
    }

    @org.junit.Test
    public void testCarriageReturnLineFeedEndings() throws java.io.IOException {
        final java.lang.String code = "foo\r\nbaar,\r\nhello,world\r\n,kanu";
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(4, records.size());
        parser.close();
    }

    @org.junit.Test(expected = java.util.NoSuchElementException.class)
    public void testClose() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("# comment\na,b,c\n1,2,3\nx,y,z");
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVFormat.DEFAULT.a('#').c().a(in);
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = parser.iterator();
        org.junit.Assert.assertTrue(records.hasNext());
        parser.close();
        org.junit.Assert.assertFalse(records.hasNext());
        records.next();
    }

    @org.junit.Test
    public void testCSV57() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("", org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> list = parser.b();
        org.junit.Assert.assertNotNull(list);
        org.junit.Assert.assertEquals(0, list.size());
        parser.close();
    }

    @org.junit.Test
    public void testDefaultFormat() throws java.io.IOException {
        final java.lang.String code = "" + ("a,b#\n" + ("\"\n\",\" \",#\n" + ("#,\"\"\n" + "# Final comment\n")));
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "a" , "b#" } , new java.lang.String[]{ "\n" , " " , "#" } , new java.lang.String[]{ "#" , "" } , new java.lang.String[]{ "# Final comment" } };
        org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT;
        org.junit.Assert.assertFalse(format.f());
        org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, format);
        java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertTrue(((records.size()) > 0));
        org.apache.commons.csv.Utils.compare("Failed to parse without comments", res, records);
        final java.lang.String[][] res_comments = new java.lang.String[][]{ new java.lang.String[]{ "a" , "b#" } , new java.lang.String[]{ "\n" , " " , "#" } };
        format = org.apache.commons.csv.CSVFormat.DEFAULT.a('#');
        parser.close();
        parser = org.apache.commons.csv.CSVParser.parse(code, format);
        records = parser.b();
        org.apache.commons.csv.Utils.compare("Failed to parse with comments", res_comments, records);
        parser.close();
    }

    @org.junit.Test
    public void testEmptyFile() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("", org.apache.commons.csv.CSVFormat.DEFAULT);
        org.junit.Assert.assertNull(parser.g());
        parser.close();
    }

    @org.junit.Test
    public void testEmptyLineBehaviourCSV() throws java.lang.Exception {
        final java.lang.String[] codes = new java.lang.String[]{ "hello,\r\n\r\n\r\n" , "hello,\n\n\n" , "hello,\"\"\r\n\r\n\r\n" , "hello,\"\"\n\n\n" };
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "hello" , "" } };
        for (final java.lang.String code : codes) {
            final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(res.length, records.size());
            org.junit.Assert.assertTrue(((records.size()) > 0));
            for (int i = 0 ; i < (res.length) ; i++) {
                org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
            }
            parser.close();
        }
    }

    @org.junit.Test
    public void testEmptyLineBehaviourExcel() throws java.lang.Exception {
        final java.lang.String[] codes = new java.lang.String[]{ "hello,\r\n\r\n\r\n" , "hello,\n\n\n" , "hello,\"\"\r\n\r\n\r\n" , "hello,\"\"\n\n\n" };
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "hello" , "" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "" } };
        for (final java.lang.String code : codes) {
            final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL);
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(res.length, records.size());
            org.junit.Assert.assertTrue(((records.size()) > 0));
            for (int i = 0 ; i < (res.length) ; i++) {
                org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
            }
            parser.close();
        }
    }

    @org.junit.Test
    @org.junit.Ignore
    public void testStartWithEmptyLinesThenHeaders() throws java.lang.Exception {
        final java.lang.String[] codes = new java.lang.String[]{ "\r\n\r\n\r\nhello,\r\n\r\n\r\n" , "hello,\n\n\n" , "hello,\"\"\r\n\r\n\r\n" , "hello,\"\"\n\n\n" };
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "hello" , "" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "" } };
        for (final java.lang.String code : codes) {
            final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL);
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(res.length, records.size());
            org.junit.Assert.assertTrue(((records.size()) > 0));
            for (int i = 0 ; i < (res.length) ; i++) {
                org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
            }
            parser.close();
        }
    }

    @org.junit.Test
    public void testEndOfFileBehaviorCSV() throws java.lang.Exception {
        final java.lang.String[] codes = new java.lang.String[]{ "hello,\r\n\r\nworld,\r\n" , "hello,\r\n\r\nworld," , "hello,\r\n\r\nworld,\"\"\r\n" , "hello,\r\n\r\nworld,\"\"" , "hello,\r\n\r\nworld,\n" , "hello,\r\n\r\nworld," , "hello,\r\n\r\nworld,\"\"\n" , "hello,\r\n\r\nworld,\"\"" };
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "hello" , "" } , new java.lang.String[]{ "world" , "" } };
        for (final java.lang.String code : codes) {
            final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(res.length, records.size());
            org.junit.Assert.assertTrue(((records.size()) > 0));
            for (int i = 0 ; i < (res.length) ; i++) {
                org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
            }
            parser.close();
        }
    }

    @org.junit.Test
    public void testEndOfFileBehaviourExcel() throws java.lang.Exception {
        final java.lang.String[] codes = new java.lang.String[]{ "hello,\r\n\r\nworld,\r\n" , "hello,\r\n\r\nworld," , "hello,\r\n\r\nworld,\"\"\r\n" , "hello,\r\n\r\nworld,\"\"" , "hello,\r\n\r\nworld,\n" , "hello,\r\n\r\nworld," , "hello,\r\n\r\nworld,\"\"\n" , "hello,\r\n\r\nworld,\"\"" };
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "hello" , "" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "world" , "" } };
        for (final java.lang.String code : codes) {
            final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL);
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(res.length, records.size());
            org.junit.Assert.assertTrue(((records.size()) > 0));
            for (int i = 0 ; i < (res.length) ; i++) {
                org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
            }
            parser.close();
        }
    }

    @org.junit.Test
    public void testExcelFormat1() throws java.io.IOException {
        final java.lang.String code = "value1,value2,value3,value4\r\na,b,c,d\r\n  x,,," + "\r\n\r\n\"\"\"hello\"\"\",\"  \"\"world\"\"\",\"abc\ndef\",\r\n";
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "value1" , "value2" , "value3" , "value4" } , new java.lang.String[]{ "a" , "b" , "c" , "d" } , new java.lang.String[]{ "  x" , "" , "" , "" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "\"hello\"" , "  \"world\"" , "abc\ndef" , "" } };
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(res.length, records.size());
        org.junit.Assert.assertTrue(((records.size()) > 0));
        for (int i = 0 ; i < (res.length) ; i++) {
            org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
        }
        parser.close();
    }

    @org.junit.Test
    public void testExcelFormat2() throws java.lang.Exception {
        final java.lang.String code = "foo,baar\r\n\r\nhello,\r\n\r\nworld,\r\n";
        final java.lang.String[][] res = new java.lang.String[][]{ new java.lang.String[]{ "foo" , "baar" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "hello" , "" } , new java.lang.String[]{ "" } , new java.lang.String[]{ "world" , "" } };
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(res.length, records.size());
        org.junit.Assert.assertTrue(((records.size()) > 0));
        for (int i = 0 ; i < (res.length) ; i++) {
            org.junit.Assert.assertArrayEquals(res[i], records.get(i).d());
        }
        parser.close();
    }

    @org.junit.Test
    public void testExcelHeaderCountLessThanData() throws java.lang.Exception {
        final java.lang.String code = "A,B,C,,\r\na,b,c,d,e\r\n";
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.EXCEL.c());
        try {
            for (final org.apache.commons.csv.CSVRecord record : parser.b()) {
                org.junit.Assert.assertEquals("a", record.c("A"));
                org.junit.Assert.assertEquals("b", record.c("B"));
                org.junit.Assert.assertEquals("c", record.c("C"));
            }
        } finally {
            parser.close();
        }
    }

    @org.junit.Test
    public void testForEach() throws java.lang.Exception {
        final java.util.List<org.apache.commons.csv.CSVRecord> records = new java.util.ArrayList<org.apache.commons.csv.CSVRecord>();
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        for (final org.apache.commons.csv.CSVRecord record : org.apache.commons.csv.CSVFormat.DEFAULT.a(in)) {
            records.add(record);
        }
        org.junit.Assert.assertEquals(3, records.size());
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "a" , "b" , "c" }, records.get(0).d());
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "1" , "2" , "3" }, records.get(1).d());
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "x" , "y" , "z" }, records.get(2).d());
    }

    @org.junit.Test
    public void testGetHeaderMap() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("a,b,c\n1,2,3\nx,y,z", org.apache.commons.csv.CSVFormat.DEFAULT.c("A", "B", "C"));
        final java.util.Map<java.lang.String, java.lang.Integer> headerMap = parser.c();
        final java.util.Iterator<java.lang.String> columnNames = headerMap.keySet().iterator();
        org.junit.Assert.assertEquals("A", columnNames.next());
        org.junit.Assert.assertEquals("B", columnNames.next());
        org.junit.Assert.assertEquals("C", columnNames.next());
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = parser.iterator();
        for (int i = 0 ; i < 3 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertEquals(record.a(0), record.c("A"));
            org.junit.Assert.assertEquals(record.a(1), record.c("B"));
            org.junit.Assert.assertEquals(record.a(2), record.c("C"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
        parser.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testDuplicateHeaders() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse("a,b,a\n1,2,3\nx,y,z", org.apache.commons.csv.CSVFormat.DEFAULT.c(new java.lang.String[]{  }));
    }

    @org.junit.Test
    public void testGetLine() throws java.io.IOException {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(CSV_INPUT, org.apache.commons.csv.CSVFormat.DEFAULT.u());
        for (final java.lang.String[] re : RESULT) {
            org.junit.Assert.assertArrayEquals(re, parser.g().d());
        }
        org.junit.Assert.assertNull(parser.g());
        parser.close();
    }

    @org.junit.Test
    public void testGetLineNumberWithCR() throws java.lang.Exception {
        a(java.lang.String.valueOf(org.apache.commons.csv.Constants.CR));
    }

    @org.junit.Test
    public void testGetLineNumberWithCRLF() throws java.lang.Exception {
        a(org.apache.commons.csv.Constants.CRLF);
    }

    @org.junit.Test
    public void testGetLineNumberWithLF() throws java.lang.Exception {
        a(java.lang.String.valueOf(org.apache.commons.csv.Constants.LF));
    }

    @org.junit.Test
    public void testGetRecordPositionWithCRLF() throws java.lang.Exception {
        c(org.apache.commons.csv.Constants.CRLF);
    }

    @org.junit.Test
    public void testGetRecordPositionWithLF() throws java.lang.Exception {
        c(java.lang.String.valueOf(org.apache.commons.csv.Constants.LF));
    }

    @org.junit.Test
    public void testGetOneLine() throws java.io.IOException {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(CSV_INPUT_1, org.apache.commons.csv.CSVFormat.DEFAULT);
        final org.apache.commons.csv.CSVRecord record = parser.b().get(0);
        org.junit.Assert.assertArrayEquals(RESULT[0], record.d());
        parser.close();
    }

    @org.junit.Test
    public void testGetOneLineOneParser() throws java.io.IOException {
        final java.io.PipedWriter writer = new java.io.PipedWriter();
        final java.io.PipedReader reader = new java.io.PipedReader(writer);
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT;
        final org.apache.commons.csv.CSVParser parser = new org.apache.commons.csv.CSVParser(reader , format);
        try {
            writer.append(CSV_INPUT_1);
            writer.append(format.o());
            final org.apache.commons.csv.CSVRecord record1 = parser.g();
            org.junit.Assert.assertArrayEquals(RESULT[0], record1.d());
            writer.append(CSV_INPUT_2);
            writer.append(format.o());
            final org.apache.commons.csv.CSVRecord record2 = parser.g();
            org.junit.Assert.assertArrayEquals(RESULT[1], record2.d());
        } finally {
            parser.close();
        }
    }

    @org.junit.Test
    public void testGetRecordNumberWithCR() throws java.lang.Exception {
        b(java.lang.String.valueOf(org.apache.commons.csv.Constants.CR));
    }

    @org.junit.Test
    public void testGetRecordNumberWithCRLF() throws java.lang.Exception {
        b(org.apache.commons.csv.Constants.CRLF);
    }

    @org.junit.Test
    public void testGetRecordNumberWithLF() throws java.lang.Exception {
        b(java.lang.String.valueOf(org.apache.commons.csv.Constants.LF));
    }

    @org.junit.Test
    public void testGetRecords() throws java.io.IOException {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(CSV_INPUT, org.apache.commons.csv.CSVFormat.DEFAULT.u());
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(RESULT.length, records.size());
        org.junit.Assert.assertTrue(((records.size()) > 0));
        for (int i = 0 ; i < (RESULT.length) ; i++) {
            org.junit.Assert.assertArrayEquals(RESULT[i], records.get(i).d());
        }
        parser.close();
    }

    @org.junit.Test
    public void testGetRecordWithMultiLineValues() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse((((("\"a\r\n1\",\"a\r\n2\"" + (org.apache.commons.csv.Constants.CRLF)) + "\"b\r\n1\",\"b\r\n2\"") + (org.apache.commons.csv.Constants.CRLF)) + "\"c\r\n1\",\"c\r\n2\""), org.apache.commons.csv.CSVFormat.DEFAULT.b(org.apache.commons.csv.Constants.CRLF));
        org.apache.commons.csv.CSVRecord record;
        org.junit.Assert.assertEquals(0, parser.f());
        org.junit.Assert.assertEquals(0, parser.e());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(3, parser.e());
        org.junit.Assert.assertEquals(1, record.h());
        org.junit.Assert.assertEquals(1, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(6, parser.e());
        org.junit.Assert.assertEquals(2, record.h());
        org.junit.Assert.assertEquals(2, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(8, parser.e());
        org.junit.Assert.assertEquals(3, record.h());
        org.junit.Assert.assertEquals(3, parser.f());
        org.junit.Assert.assertNull((record = parser.g()));
        org.junit.Assert.assertEquals(8, parser.e());
        org.junit.Assert.assertEquals(3, parser.f());
        parser.close();
    }

    @org.junit.Test
    public void testHeader() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c().a(in).iterator();
        for (int i = 0 ; i < 2 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertEquals(record.a(0), record.c("a"));
            org.junit.Assert.assertEquals(record.a(1), record.c("b"));
            org.junit.Assert.assertEquals(record.a(2), record.c("c"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test
    public void testHeaderMissing() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c().a(in).iterator();
        for (int i = 0 ; i < 2 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertEquals(record.a(0), record.c("a"));
            org.junit.Assert.assertEquals(record.a(2), record.c("c"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testHeadersMissingException() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,,c,,d\n1,2,3,4\nx,y,z,zz");
        org.apache.commons.csv.CSVFormat.DEFAULT.c().a(in).iterator();
    }

    @org.junit.Test
    public void testHeadersMissing() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,,c,,d\n1,2,3,4\nx,y,z,zz");
        org.apache.commons.csv.CSVFormat.DEFAULT.c().r().a(in).iterator();
    }

    @org.junit.Test
    public void testHeaderMissingWithNull() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,,c,,d\n1,2,3,4\nx,y,z,zz");
        org.apache.commons.csv.CSVFormat.DEFAULT.c().a("").r().a(in).iterator();
    }

    @org.junit.Test
    public void testHeaderComment() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("# comment\na,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.a('#').c().a(in).iterator();
        for (int i = 0 ; i < 2 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertEquals(record.a(0), record.c("a"));
            org.junit.Assert.assertEquals(record.a(1), record.c("b"));
            org.junit.Assert.assertEquals(record.a(2), record.c("c"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test
    public void testIgnoreEmptyLines() throws java.io.IOException {
        final java.lang.String code = "\nfoo,baar\n\r\n,\n\n,world\r\n\n";
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(3, records.size());
        parser.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testInvalidFormat() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat invalidFormat = org.apache.commons.csv.CSVFormat.DEFAULT.b(org.apache.commons.csv.Constants.CR);
        new org.apache.commons.csv.CSVParser(null , invalidFormat).close();
    }

    @org.junit.Test
    public void testIterator() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> iterator = org.apache.commons.csv.CSVFormat.DEFAULT.a(in).iterator();
        org.junit.Assert.assertTrue(iterator.hasNext());
        try {
            iterator.remove();
            org.junit.Assert.fail("expected UnsupportedOperationException");
        } catch (final java.lang.UnsupportedOperationException expected) {
        }
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "a" , "b" , "c" }, iterator.next().d());
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "1" , "2" , "3" }, iterator.next().d());
        org.junit.Assert.assertTrue(iterator.hasNext());
        org.junit.Assert.assertTrue(iterator.hasNext());
        org.junit.Assert.assertTrue(iterator.hasNext());
        org.junit.Assert.assertArrayEquals(new java.lang.String[]{ "x" , "y" , "z" }, iterator.next().d());
        org.junit.Assert.assertFalse(iterator.hasNext());
        try {
            iterator.next();
            org.junit.Assert.fail("NoSuchElementException expected");
        } catch (final java.util.NoSuchElementException e) {
        }
    }

    @org.junit.Test
    public void testLineFeedEndings() throws java.io.IOException {
        final java.lang.String code = "foo\nbaar,\nhello,world\n,kanu";
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
        org.junit.Assert.assertEquals(4, records.size());
        parser.close();
    }

    @org.junit.Test
    public void testMappedButNotSetAsOutlook2007ContactExport() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c("A", "B", "C").v().a(in).iterator();
        org.apache.commons.csv.CSVRecord record;
        record = records.next();
        org.junit.Assert.assertTrue(record.a("A"));
        org.junit.Assert.assertTrue(record.a("B"));
        org.junit.Assert.assertTrue(record.a("C"));
        org.junit.Assert.assertTrue(record.b("A"));
        org.junit.Assert.assertTrue(record.b("B"));
        org.junit.Assert.assertFalse(record.b("C"));
        org.junit.Assert.assertEquals("1", record.c("A"));
        org.junit.Assert.assertEquals("2", record.c("B"));
        org.junit.Assert.assertFalse(record.a());
        record = records.next();
        org.junit.Assert.assertTrue(record.a("A"));
        org.junit.Assert.assertTrue(record.a("B"));
        org.junit.Assert.assertTrue(record.a("C"));
        org.junit.Assert.assertTrue(record.b("A"));
        org.junit.Assert.assertTrue(record.b("B"));
        org.junit.Assert.assertTrue(record.b("C"));
        org.junit.Assert.assertEquals("x", record.c("A"));
        org.junit.Assert.assertEquals("y", record.c("B"));
        org.junit.Assert.assertEquals("z", record.c("C"));
        org.junit.Assert.assertTrue(record.a());
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test
    public void testMultipleIterators() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse((("a,b,c" + (org.apache.commons.csv.Constants.CR)) + "d,e,f"), org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> itr1 = parser.iterator();
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> itr2 = parser.iterator();
        final org.apache.commons.csv.CSVRecord first = itr1.next();
        org.junit.Assert.assertEquals("a", first.a(0));
        org.junit.Assert.assertEquals("b", first.a(1));
        org.junit.Assert.assertEquals("c", first.a(2));
        final org.apache.commons.csv.CSVRecord second = itr2.next();
        org.junit.Assert.assertEquals("d", second.a(0));
        org.junit.Assert.assertEquals("e", second.a(1));
        org.junit.Assert.assertEquals("f", second.a(2));
        parser.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testNewCSVParserNullReaderFormat() throws java.lang.Exception {
        new org.apache.commons.csv.CSVParser(null , org.apache.commons.csv.CSVFormat.DEFAULT).close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testNewCSVParserReaderNullFormat() throws java.lang.Exception {
        new org.apache.commons.csv.CSVParser(new java.io.StringReader("") , null).close();
    }

    @org.junit.Test
    public void testNoHeaderMap() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("a,b,c\n1,2,3\nx,y,z", org.apache.commons.csv.CSVFormat.DEFAULT);
        org.junit.Assert.assertNull(parser.c());
        parser.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseFileNullFormat() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse(new java.io.File(""), java.nio.charset.Charset.defaultCharset(), null);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseNullFileFormat() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse(((java.io.File)(null)), java.nio.charset.Charset.defaultCharset(), org.apache.commons.csv.CSVFormat.DEFAULT);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseNullStringFormat() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse(((java.lang.String)(null)), org.apache.commons.csv.CSVFormat.DEFAULT);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseNullUrlCharsetFormat() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse(((java.io.File)(null)), java.nio.charset.Charset.defaultCharset(), org.apache.commons.csv.CSVFormat.DEFAULT);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParserUrlNullCharsetFormat() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(new java.net.URL("http://commons.apache.org"), null, org.apache.commons.csv.CSVFormat.DEFAULT);
        parser.close();
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseStringNullFormat() throws java.lang.Exception {
        org.apache.commons.csv.CSVParser.parse("csv data", null);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testParseUrlCharsetNullFormat() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(new java.net.URL("http://commons.apache.org"), java.nio.charset.Charset.defaultCharset(), null);
        parser.close();
    }

    @org.junit.Test
    public void testProvidedHeader() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c("A", "B", "C").a(in).iterator();
        for (int i = 0 ; i < 3 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertTrue(record.a("A"));
            org.junit.Assert.assertTrue(record.a("B"));
            org.junit.Assert.assertTrue(record.a("C"));
            org.junit.Assert.assertFalse(record.a("NOT MAPPED"));
            org.junit.Assert.assertEquals(record.a(0), record.c("A"));
            org.junit.Assert.assertEquals(record.a(1), record.c("B"));
            org.junit.Assert.assertEquals(record.a(2), record.c("C"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test
    public void testProvidedHeaderAuto() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c().a(in).iterator();
        for (int i = 0 ; i < 2 ; i++) {
            org.junit.Assert.assertTrue(records.hasNext());
            final org.apache.commons.csv.CSVRecord record = records.next();
            org.junit.Assert.assertTrue(record.a("a"));
            org.junit.Assert.assertTrue(record.a("b"));
            org.junit.Assert.assertTrue(record.a("c"));
            org.junit.Assert.assertFalse(record.a("NOT MAPPED"));
            org.junit.Assert.assertEquals(record.a(0), record.c("a"));
            org.junit.Assert.assertEquals(record.a(1), record.c("b"));
            org.junit.Assert.assertEquals(record.a(2), record.c("c"));
        }
        org.junit.Assert.assertFalse(records.hasNext());
    }

    @org.junit.Test
    public void testRoundtrip() throws java.lang.Exception {
        final java.io.StringWriter out = new java.io.StringWriter();
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(out , org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.lang.String input = "a,b,c\r\n1,2,3\r\nx,y,z\r\n";
        for (final org.apache.commons.csv.CSVRecord record : org.apache.commons.csv.CSVParser.parse(input, org.apache.commons.csv.CSVFormat.DEFAULT)) {
            printer.b(record);
        }
        org.junit.Assert.assertEquals(input, out.toString());
        printer.close();
    }

    @org.junit.Test
    public void testSkipAutoHeader() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c().a(in).iterator();
        final org.apache.commons.csv.CSVRecord record = records.next();
        org.junit.Assert.assertEquals("1", record.c("a"));
        org.junit.Assert.assertEquals("2", record.c("b"));
        org.junit.Assert.assertEquals("3", record.c("c"));
    }

    @org.junit.Test
    public void testSkipSetHeader() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("a,b,c\n1,2,3\nx,y,z");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c("a", "b", "c").v().a(in).iterator();
        final org.apache.commons.csv.CSVRecord record = records.next();
        org.junit.Assert.assertEquals("1", record.c("a"));
        org.junit.Assert.assertEquals("2", record.c("b"));
        org.junit.Assert.assertEquals("3", record.c("c"));
    }

    private void a(final java.lang.String lineSeparator) throws java.io.IOException {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse((((("a" + lineSeparator) + "b") + lineSeparator) + "c"), org.apache.commons.csv.CSVFormat.DEFAULT.b(lineSeparator));
        org.junit.Assert.assertEquals(0, parser.e());
        org.junit.Assert.assertNotNull(parser.g());
        org.junit.Assert.assertEquals(1, parser.e());
        org.junit.Assert.assertNotNull(parser.g());
        org.junit.Assert.assertEquals(2, parser.e());
        org.junit.Assert.assertNotNull(parser.g());
        org.junit.Assert.assertEquals(2, parser.e());
        org.junit.Assert.assertNull(parser.g());
        org.junit.Assert.assertEquals(2, parser.e());
        parser.close();
    }

    private void b(final java.lang.String lineSeparator) throws java.io.IOException {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse((((("a" + lineSeparator) + "b") + lineSeparator) + "c"), org.apache.commons.csv.CSVFormat.DEFAULT.b(lineSeparator));
        org.apache.commons.csv.CSVRecord record;
        org.junit.Assert.assertEquals(0, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(1, record.h());
        org.junit.Assert.assertEquals(1, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(2, record.h());
        org.junit.Assert.assertEquals(2, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(3, record.h());
        org.junit.Assert.assertEquals(3, parser.f());
        org.junit.Assert.assertNull((record = parser.g()));
        org.junit.Assert.assertEquals(3, parser.f());
        parser.close();
    }

    private void c(final java.lang.String lineSeparator) throws java.io.IOException {
        final java.lang.String nl = lineSeparator;
        final java.lang.String code = ((((((((((("a,b,c" + lineSeparator) + "1,2,3") + lineSeparator) + "\'A") + nl) + "A\',\'B") + nl) + "B\',CC") + lineSeparator) + "Ä,Ö,Ü") + lineSeparator) + "EOF,EOF,EOF";
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(',').d('\'').b(lineSeparator);
        org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(code, format);
        org.apache.commons.csv.CSVRecord record;
        org.junit.Assert.assertEquals(0, parser.f());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(1, record.h());
        org.junit.Assert.assertEquals(code.indexOf('a'), record.g());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(2, record.h());
        org.junit.Assert.assertEquals(code.indexOf('1'), record.g());
        org.junit.Assert.assertNotNull((record = parser.g()));
        final long positionRecord3 = record.g();
        org.junit.Assert.assertEquals(3, record.h());
        org.junit.Assert.assertEquals(code.indexOf("\'A"), record.g());
        org.junit.Assert.assertEquals((("A" + lineSeparator) + "A"), record.a(0));
        org.junit.Assert.assertEquals((("B" + lineSeparator) + "B"), record.a(1));
        org.junit.Assert.assertEquals("CC", record.a(2));
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(4, record.h());
        org.junit.Assert.assertEquals(code.indexOf('Ä'), record.g());
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(5, record.h());
        org.junit.Assert.assertEquals(code.indexOf("EOF"), record.g());
        parser.close();
        parser = new org.apache.commons.csv.CSVParser(new java.io.StringReader(code.substring(((int)(positionRecord3)))) , format , positionRecord3 , 3);
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(3, record.h());
        org.junit.Assert.assertEquals(code.indexOf("\'A"), record.g());
        org.junit.Assert.assertEquals((("A" + lineSeparator) + "A"), record.a(0));
        org.junit.Assert.assertEquals((("B" + lineSeparator) + "B"), record.a(1));
        org.junit.Assert.assertEquals("CC", record.a(2));
        org.junit.Assert.assertNotNull((record = parser.g()));
        org.junit.Assert.assertEquals(4, record.h());
        org.junit.Assert.assertEquals(code.indexOf('Ä'), record.g());
        org.junit.Assert.assertEquals("Ä", record.a(0));
        parser.close();
    }

    @org.junit.Test
    public void testIgnoreCaseHeaderMapping() throws java.lang.Exception {
        final java.io.Reader in = new java.io.StringReader("1,2,3");
        final java.util.Iterator<org.apache.commons.csv.CSVRecord> records = org.apache.commons.csv.CSVFormat.DEFAULT.c("One", "TWO", "three").t().a(in).iterator();
        final org.apache.commons.csv.CSVRecord record = records.next();
        org.junit.Assert.assertEquals("1", record.c("one"));
        org.junit.Assert.assertEquals("2", record.c("two"));
        org.junit.Assert.assertEquals("3", record.c("THREE"));
    }
}

