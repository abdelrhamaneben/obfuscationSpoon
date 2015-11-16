package org.apache.commons.csv;


public class LexerTest {
    private org.apache.commons.csv.CSVFormat formatWithEscaping;

    @org.junit.Before
    public void a() {
        formatWithEscaping = org.apache.commons.csv.CSVFormat.DEFAULT.c('\\');
    }

    private org.apache.commons.csv.Lexer a(final java.lang.String input, final org.apache.commons.csv.CSVFormat format) {
        return new org.apache.commons.csv.Lexer(format , new org.apache.commons.csv.ExtendedBufferedReader(new java.io.StringReader(input)));
    }

    @org.junit.Test
    public void testSurroundingSpacesAreDeleted() throws java.io.IOException {
        final java.lang.String code = "noSpaces,  leadingSpaces,trailingSpaces  ,  surroundingSpaces  ,  ,,";
        final org.apache.commons.csv.Lexer parser = a(code, org.apache.commons.csv.CSVFormat.DEFAULT.u());
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "noSpaces"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "leadingSpaces"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "trailingSpaces"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "surroundingSpaces"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testSurroundingTabsAreDeleted() throws java.io.IOException {
        final java.lang.String code = "noTabs,\tleadingTab,trailingTab\t,\tsurroundingTabs\t,\t\t,,";
        final org.apache.commons.csv.Lexer parser = a(code, org.apache.commons.csv.CSVFormat.DEFAULT.u());
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "noTabs"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "leadingTab"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "trailingTab"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "surroundingTabs"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testIgnoreEmptyLines() throws java.io.IOException {
        final java.lang.String code = "first,line,\n" + ("\n" + ("\n" + ("second,line\n" + ("\n" + ("\n" + ("third line \n" + ("\n" + ("\n" + ("last, line \n" + ("\n" + ("\n" + "\n")))))))))));
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.s();
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "first"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "second"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "third line "));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "last"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, " line "));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testComments() throws java.io.IOException {
        final java.lang.String code = "first,line,\n" + ("second,line,tokenWith#no-comment\n" + ("# comment line \n" + ("third,line,#no-comment\n" + ("# penultimate comment\n" + "# Final comment\n"))));
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.a('#');
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "first"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "second"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "tokenWith#no-comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "comment line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "third"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "line"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "#no-comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "penultimate comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "Final comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testCommentsAndEmptyLines() throws java.io.IOException {
        final java.lang.String code = "1,2,3,\n" + ("\n" + ("\n" + ("a,b x,c#no-comment\n" + ("#foo\n" + ("\n" + ("\n" + ("d,e,#no-comment\n" + ("\n" + ("\n" + ("# penultimate comment\n" + ("\n" + ("\n" + "# Final comment\n"))))))))))));
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.a('#').b(false);
        org.junit.Assert.assertFalse("Should not ignore empty lines", format.b());
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "1"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "2"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "3"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "b x"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "c#no-comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "foo"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "d"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "e"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "#no-comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "penultimate comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.COMMENT, "Final comment"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testBackslashWithoutEscaping() throws java.io.IOException {
        final java.lang.String code = "a,\\,,b\\\n\\,,";
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT;
        org.junit.Assert.assertFalse(format.g());
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "\\"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b\\"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "\\"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, ""));
    }

    @org.junit.Test
    public void testBackslashWithEscaping() throws java.io.IOException {
        final java.lang.String code = "a,\\,,b\\\\\n\\,,\\\nc,d\\\r\ne";
        final org.apache.commons.csv.CSVFormat format = formatWithEscaping.b(false);
        org.junit.Assert.assertTrue(format.g());
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ","));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b\\"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ","));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "\nc"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "d\r"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, "e"));
    }

    @org.junit.Test
    public void testNextToken4() throws java.io.IOException {
        final java.lang.String code = "a,\"foo\",b\na,   \" foo\",b\na,\"foo \"  ,b\na,  \" foo \"  ,b";
        final org.apache.commons.csv.Lexer parser = a(code, org.apache.commons.csv.CSVFormat.DEFAULT.u());
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "foo"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, " foo"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "foo "));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, " foo "));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, "b"));
    }

    @org.junit.Test
    public void testNextToken5() throws java.io.IOException {
        final java.lang.String code = "a,\"foo\n\",b\n\"foo\n  baar ,,,\"\n\"\n\t \n\"";
        final org.apache.commons.csv.Lexer parser = a(code, org.apache.commons.csv.CSVFormat.DEFAULT);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "foo\n"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "foo\n  baar ,,,"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, "\n\t \n"));
    }

    @org.junit.Test
    public void testNextToken6() throws java.io.IOException {
        final java.lang.String code = "a;\'b and \'\' more\n\'\n!comment;;;;\n;;";
        final org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.d('\'').a('!').b(';');
        final org.apache.commons.csv.Lexer parser = a(code, format);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "a"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "b and \' more\n"));
    }

    @org.junit.Test
    public void testDelimiterIsWhitespace() throws java.io.IOException {
        final java.lang.String code = "one\ttwo\t\tfour \t five\t six";
        final org.apache.commons.csv.Lexer parser = a(code, org.apache.commons.csv.CSVFormat.TDF);
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "one"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "two"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, ""));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "four"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "five"));
        org.junit.Assert.assertThat(parser.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, "six"));
    }

    @org.junit.Test
    public void testEscapedCR() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character\\" + (org.apache.commons.csv.Constants.CR)) + "Escaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.CR)) + "Escaped")));
    }

    @org.junit.Test
    public void testCR() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character" + (org.apache.commons.csv.Constants.CR)) + "NotEscaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("character"));
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("NotEscaped"));
    }

    @org.junit.Test
    public void testEscapedLF() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character\\" + (org.apache.commons.csv.Constants.LF)) + "Escaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.LF)) + "Escaped")));
    }

    @org.junit.Test
    public void testLF() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character" + (org.apache.commons.csv.Constants.LF)) + "NotEscaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("character"));
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("NotEscaped"));
    }

    @org.junit.Test
    public void testEscapedTab() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character\\" + (org.apache.commons.csv.Constants.TAB)) + "Escaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.TAB)) + "Escaped")));
    }

    @org.junit.Test
    public void testTab() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character" + (org.apache.commons.csv.Constants.TAB)) + "NotEscaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.TAB)) + "NotEscaped")));
    }

    @org.junit.Test
    public void testEscapedBackspace() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character\\" + (org.apache.commons.csv.Constants.BACKSPACE)) + "Escaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.BACKSPACE)) + "Escaped")));
    }

    @org.junit.Test
    public void testBackspace() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character" + (org.apache.commons.csv.Constants.BACKSPACE)) + "NotEscaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.BACKSPACE)) + "NotEscaped")));
    }

    @org.junit.Test
    public void testEscapedFF() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character\\" + (org.apache.commons.csv.Constants.FF)) + "Escaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.FF)) + "Escaped")));
    }

    @org.junit.Test
    public void testFF() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a((("character" + (org.apache.commons.csv.Constants.FF)) + "NotEscaped"), formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.FF)) + "NotEscaped")));
    }

    @org.junit.Test
    public void testEscapedMySqlNullValue() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a("character\\NEscaped", formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("character\\NEscaped"));
    }

    @org.junit.Test
    public void testEscapedCharacter() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a("character\\aEscaped", formatWithEscaping);
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent("character\\aEscaped"));
    }

    @org.junit.Test
    public void testEscapedControlCharacter() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a("character!rEscaped", org.apache.commons.csv.CSVFormat.DEFAULT.c('!'));
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.CR)) + "Escaped")));
    }

    @org.junit.Test
    public void testEscapedControlCharacter2() throws java.lang.Exception {
        final org.apache.commons.csv.Lexer lexer = a("character\\rEscaped", org.apache.commons.csv.CSVFormat.DEFAULT.c('\\'));
        org.junit.Assert.assertThat(lexer.a(new org.apache.commons.csv.Token()), org.apache.commons.csv.TokenMatchers.hasContent((("character" + (org.apache.commons.csv.Constants.CR)) + "Escaped")));
    }

    @org.junit.Test(expected = java.io.IOException.class)
    public void testEscapingAtEOF() throws java.lang.Exception {
        final java.lang.String code = "escaping at EOF is evil\\";
        final org.apache.commons.csv.Lexer lexer = a(code, formatWithEscaping);
        lexer.a(new org.apache.commons.csv.Token());
    }
}

