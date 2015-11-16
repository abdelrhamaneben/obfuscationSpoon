package org.apache.commons.csv;


public class CSVFormatTest {
    private static void assertNotEquals(final java.lang.Object right, final java.lang.Object left) {
        org.junit.Assert.assertFalse(right.equals(left));
        org.junit.Assert.assertFalse(left.equals(right));
    }

    private static org.apache.commons.csv.CSVFormat copy(final org.apache.commons.csv.CSVFormat format) {
        return format.b(format.j());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testDelimiterSameAsCommentStartThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.b('!').a('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testDelimiterSameAsEscapeThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.b('!').c('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testDuplicateHeaderElements() {
        org.apache.commons.csv.CSVFormat.DEFAULT.c("A", "A");
    }

    @org.junit.Test
    public void testEquals() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.DEFAULT;
        final org.apache.commons.csv.CSVFormat left = org.apache.commons.csv.CSVFormatTest.copy(right);
        org.junit.Assert.assertFalse(right.equals(null));
        org.junit.Assert.assertFalse(right.equals("A String Instance"));
        org.junit.Assert.assertEquals(right, right);
        org.junit.Assert.assertEquals(right, left);
        org.junit.Assert.assertEquals(left, right);
        org.junit.Assert.assertEquals(right.hashCode(), right.hashCode());
        org.junit.Assert.assertEquals(right.hashCode(), left.hashCode());
    }

    @org.junit.Test
    public void testEqualsCommentStart() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').d('\"').a('#').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.a('!');
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsDelimiter() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('!');
        final org.apache.commons.csv.CSVFormat left = org.apache.commons.csv.CSVFormat.newFormat('?');
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsEscape() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').d('\"').a('#').c('+').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.c('!');
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsHeader() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').e(org.apache.commons.csv.Constants.CR).a('#').c('+').c("One", "Two", "Three").s().u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.c("Three", "Two", "One");
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsIgnoreEmptyLines() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').a('#').c('+').s().u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.b(false);
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsIgnoreSurroundingSpaces() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').a('#').c('+').u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.d(false);
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsQuoteChar() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').d('\"');
        final org.apache.commons.csv.CSVFormat left = right.d('!');
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsQuotePolicy() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').d('\"').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.a(org.apache.commons.csv.QuoteMode.MINIMAL);
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsRecordSeparator() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').e(org.apache.commons.csv.Constants.CR).a('#').c('+').s().u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL);
        final org.apache.commons.csv.CSVFormat left = right.e(org.apache.commons.csv.Constants.LF);
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsNullString() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').e(org.apache.commons.csv.Constants.CR).a('#').c('+').s().u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL).a("null");
        final org.apache.commons.csv.CSVFormat left = right.a("---");
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test
    public void testEqualsSkipHeaderRecord() {
        final org.apache.commons.csv.CSVFormat right = org.apache.commons.csv.CSVFormat.newFormat('\'').e(org.apache.commons.csv.Constants.CR).a('#').c('+').s().u().d('\"').a(org.apache.commons.csv.QuoteMode.ALL).a("null").v();
        final org.apache.commons.csv.CSVFormat left = right.e(false);
        org.apache.commons.csv.CSVFormatTest.assertNotEquals(right, left);
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testEscapeSameAsCommentStartThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.c('!').a('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testEscapeSameAsCommentStartThrowsExceptionForWrapperType() {
        org.apache.commons.csv.CSVFormat.DEFAULT.b(new java.lang.Character('!')).a(new java.lang.Character('!'));
    }

    @org.junit.Test
    public void testFormat() {
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT;
        org.junit.Assert.assertEquals("", format.a());
        org.junit.Assert.assertEquals("a,b,c", format.a("a", "b", "c"));
        org.junit.Assert.assertEquals("\"x,y\",z", format.a("x,y", "z"));
    }

    @org.junit.Test
    public void testGetHeader() throws java.lang.Exception {
        final java.lang.String[] header = new java.lang.String[]{ "one" , "two" , "three" };
        final org.apache.commons.csv.CSVFormat formatWithHeader = org.apache.commons.csv.CSVFormat.DEFAULT.c(header);
        final java.lang.String[] headerCopy = formatWithHeader.p();
        headerCopy[0] = "A";
        headerCopy[1] = "B";
        headerCopy[2] = "C";
        org.junit.Assert.assertFalse(java.util.Arrays.equals(formatWithHeader.p(), headerCopy));
        org.junit.Assert.assertNotSame(formatWithHeader.p(), headerCopy);
    }

    @org.junit.Test
    public void testNullRecordSeparatorCsv106() {
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.newFormat(';').v().c("H1", "H2");
        final java.lang.String formatStr = format.a("A", "B");
        org.junit.Assert.assertNotNull(formatStr);
        org.junit.Assert.assertFalse(formatStr.endsWith("null"));
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuoteCharSameAsCommentStartThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.d('!').a('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuoteCharSameAsCommentStartThrowsExceptionForWrapperType() {
        org.apache.commons.csv.CSVFormat.DEFAULT.c(new java.lang.Character('!')).a('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuoteCharSameAsDelimiterThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.d('!').b('!');
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuotePolicyNoneWithoutEscapeThrowsException() {
        org.apache.commons.csv.CSVFormat.newFormat('!').a(org.apache.commons.csv.QuoteMode.NONE);
    }

    @org.junit.Test
    public void testRFC4180() {
        org.junit.Assert.assertEquals(null, org.apache.commons.csv.CSVFormat.RFC4180.k());
        org.junit.Assert.assertEquals(',', org.apache.commons.csv.CSVFormat.RFC4180.j());
        org.junit.Assert.assertEquals(null, org.apache.commons.csv.CSVFormat.RFC4180.l());
        org.junit.Assert.assertFalse(org.apache.commons.csv.CSVFormat.RFC4180.b());
        org.junit.Assert.assertEquals(java.lang.Character.valueOf('\"'), org.apache.commons.csv.CSVFormat.RFC4180.m());
        org.junit.Assert.assertEquals(null, org.apache.commons.csv.CSVFormat.RFC4180.w());
        org.junit.Assert.assertEquals("\r\n", org.apache.commons.csv.CSVFormat.RFC4180.o());
    }

    @java.lang.SuppressWarnings(value = "boxing")
    @org.junit.Test
    public void testSerialization() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(out);
        oos.writeObject(org.apache.commons.csv.CSVFormat.DEFAULT);
        oos.flush();
        oos.close();
        final java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(out.toByteArray()));
        final org.apache.commons.csv.CSVFormat format = ((org.apache.commons.csv.CSVFormat)(in.readObject()));
        org.junit.Assert.assertNotNull(format);
        org.junit.Assert.assertEquals("delimiter", org.apache.commons.csv.CSVFormat.DEFAULT.j(), format.j());
        org.junit.Assert.assertEquals("encapsulator", org.apache.commons.csv.CSVFormat.DEFAULT.m(), format.m());
        org.junit.Assert.assertEquals("comment start", org.apache.commons.csv.CSVFormat.DEFAULT.k(), format.k());
        org.junit.Assert.assertEquals("record separator", org.apache.commons.csv.CSVFormat.DEFAULT.o(), format.o());
        org.junit.Assert.assertEquals("escape", org.apache.commons.csv.CSVFormat.DEFAULT.l(), format.l());
        org.junit.Assert.assertEquals("trim", org.apache.commons.csv.CSVFormat.DEFAULT.d(), format.d());
        org.junit.Assert.assertEquals("empty lines", org.apache.commons.csv.CSVFormat.DEFAULT.b(), format.b());
    }

    @org.junit.Test
    public void testWithCommentStart() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithCommentStart = org.apache.commons.csv.CSVFormat.DEFAULT.a('#');
        org.junit.Assert.assertEquals(java.lang.Character.valueOf('#'), formatWithCommentStart.k());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testWithCommentStartCRThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.a(org.apache.commons.csv.Constants.CR);
    }

    @org.junit.Test
    public void testWithDelimiter() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithDelimiter = org.apache.commons.csv.CSVFormat.DEFAULT.b('!');
        org.junit.Assert.assertEquals('!', formatWithDelimiter.j());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testWithDelimiterLFThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.b(org.apache.commons.csv.Constants.LF);
    }

    @org.junit.Test
    public void testWithEscape() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithEscape = org.apache.commons.csv.CSVFormat.DEFAULT.c('&');
        org.junit.Assert.assertEquals(java.lang.Character.valueOf('&'), formatWithEscape.l());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testWithEscapeCRThrowsExceptions() {
        org.apache.commons.csv.CSVFormat.DEFAULT.c(org.apache.commons.csv.Constants.CR);
    }

    @org.junit.Test
    public void testWithHeader() throws java.lang.Exception {
        final java.lang.String[] header = new java.lang.String[]{ "one" , "two" , "three" };
        final org.apache.commons.csv.CSVFormat formatWithHeader = org.apache.commons.csv.CSVFormat.DEFAULT.c(header);
        org.junit.Assert.assertArrayEquals(header, formatWithHeader.p());
        org.junit.Assert.assertNotSame(header, formatWithHeader.p());
        header[0] = "A";
        header[1] = "B";
        header[2] = "C";
        org.junit.Assert.assertFalse(java.util.Arrays.equals(formatWithHeader.p(), header));
    }

    @org.junit.Test
    public void testJiraCsv154_withCommentMarker() throws java.io.IOException {
        final java.lang.String comment = "This is a header comment";
        org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.EXCEL.c("H1", "H2").a('#').d(comment);
        java.lang.StringBuilder out = new java.lang.StringBuilder();
        final org.apache.commons.csv.CSVPrinter printer = format.a(out);
        printer.a("A");
        printer.a("B");
        printer.close();
        java.lang.String s = out.toString();
        org.junit.Assert.assertTrue(s, s.contains(comment));
    }

    @org.junit.Test
    public void testJiraCsv154_withHeaderComments() throws java.io.IOException {
        final java.lang.String comment = "This is a header comment";
        org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.EXCEL.c("H1", "H2").d(comment).a('#');
        java.lang.StringBuilder out = new java.lang.StringBuilder();
        final org.apache.commons.csv.CSVPrinter printer = format.a(out);
        printer.a("A");
        printer.a("B");
        printer.close();
        java.lang.String s = out.toString();
        org.junit.Assert.assertTrue(s, s.contains(comment));
    }

    @org.junit.Test
    public void testWithIgnoreEmptyLines() throws java.lang.Exception {
        org.junit.Assert.assertFalse(org.apache.commons.csv.CSVFormat.DEFAULT.b(false).b());
        org.junit.Assert.assertTrue(org.apache.commons.csv.CSVFormat.DEFAULT.s().b());
    }

    @org.junit.Test
    public void testWithIgnoreSurround() throws java.lang.Exception {
        org.junit.Assert.assertFalse(org.apache.commons.csv.CSVFormat.DEFAULT.d(false).d());
        org.junit.Assert.assertTrue(org.apache.commons.csv.CSVFormat.DEFAULT.u().d());
    }

    @org.junit.Test
    public void testWithNullString() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithNullString = org.apache.commons.csv.CSVFormat.DEFAULT.a("null");
        org.junit.Assert.assertEquals("null", formatWithNullString.n());
    }

    @org.junit.Test
    public void testWithQuoteChar() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithQuoteChar = org.apache.commons.csv.CSVFormat.DEFAULT.d('\"');
        org.junit.Assert.assertEquals(java.lang.Character.valueOf('\"'), formatWithQuoteChar.m());
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testWithQuoteLFThrowsException() {
        org.apache.commons.csv.CSVFormat.DEFAULT.d(org.apache.commons.csv.Constants.LF);
    }

    @org.junit.Test
    public void testWithQuotePolicy() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithQuotePolicy = org.apache.commons.csv.CSVFormat.DEFAULT.a(org.apache.commons.csv.QuoteMode.ALL);
        org.junit.Assert.assertEquals(org.apache.commons.csv.QuoteMode.ALL, formatWithQuotePolicy.w());
    }

    @org.junit.Test
    public void testWithRecordSeparatorCR() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithRecordSeparator = org.apache.commons.csv.CSVFormat.DEFAULT.e(org.apache.commons.csv.Constants.CR);
        org.junit.Assert.assertEquals(java.lang.String.valueOf(org.apache.commons.csv.Constants.CR), formatWithRecordSeparator.o());
    }

    @org.junit.Test
    public void testWithRecordSeparatorLF() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithRecordSeparator = org.apache.commons.csv.CSVFormat.DEFAULT.e(org.apache.commons.csv.Constants.LF);
        org.junit.Assert.assertEquals(java.lang.String.valueOf(org.apache.commons.csv.Constants.LF), formatWithRecordSeparator.o());
    }

    @org.junit.Test
    public void testWithRecordSeparatorCRLF() throws java.lang.Exception {
        final org.apache.commons.csv.CSVFormat formatWithRecordSeparator = org.apache.commons.csv.CSVFormat.DEFAULT.b(org.apache.commons.csv.Constants.CRLF);
        org.junit.Assert.assertEquals(org.apache.commons.csv.Constants.CRLF, formatWithRecordSeparator.o());
    }
}

