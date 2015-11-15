package org.apache.commons.io.input;


@org.junit.runner.RunWith(value = org.junit.runners.Parameterized.class)
public class ReversedLinesFileReaderTestParamBlockSize {
    private static final java.lang.String UTF_8 = "UTF-8";

    private static final java.lang.String ISO_8859_1 = "ISO-8859-1";

    @java.lang.SuppressWarnings(value = "boxing")
    @org.junit.runners.Parameterized.Parameters(name = "BlockSize={0}")
    public static java.util.Collection<java.lang.Integer[]> a() {
        return java.util.Arrays.asList(new java.lang.Integer[][]{ new java.lang.Integer[]{ 1 } , new java.lang.Integer[]{ 3 } , new java.lang.Integer[]{ 8 } , new java.lang.Integer[]{ 256 } , new java.lang.Integer[]{ 4096 } });
    }

    private org.apache.commons.io.input.ReversedLinesFileReader reversedLinesFileReader;

    private final int testParamBlockSize;

    public ReversedLinesFileReaderTestParamBlockSize(final java.lang.Integer testWithBlockSize) {
        testParamBlockSize = testWithBlockSize;
    }

    private static final java.lang.String TEST_LINE = "A Test Line. Special chars: ÄäÜüÖöß ÃáéíïçñÂ ©µ¥£±²®";

    private static final java.lang.String TEST_LINE_SHIFT_JIS1 = "Hiragana letters: ぁあぃいぅ";

    private static final java.lang.String TEST_LINE_SHIFT_JIS2 = "Kanji letters: 明輸子京";

    private static final java.lang.String TEST_LINE_WINDOWS_31J_1 = "ぁあぃいぅ";

    private static final java.lang.String TEST_LINE_WINDOWS_31J_2 = "明輸子京";

    private static final java.lang.String TEST_LINE_GBK_1 = "明輸子京";

    private static final java.lang.String TEST_LINE_GBK_2 = "简体中文";

    private static final java.lang.String TEST_LINE_X_WINDOWS_949_1 = "한국어";

    private static final java.lang.String TEST_LINE_X_WINDOWS_949_2 = "대한민국";

    private static final java.lang.String TEST_LINE_X_WINDOWS_950_1 = "明輸子京";

    private static final java.lang.String TEST_LINE_X_WINDOWS_950_2 = "繁體中文";

    @org.junit.After
    public void b() {
        try {
            reversedLinesFileReader.close();
        } catch (final java.lang.Exception e) {
        }
    }

    @org.junit.Test
    public void f() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource("/test-file-iso8859-1.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , testParamBlockSize , ISO_8859_1);
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void m() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource("/test-file-utf8-win-linebr.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , testParamBlockSize , UTF_8);
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void l() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource("/test-file-utf8-cr-only.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , testParamBlockSize , UTF_8);
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void k() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource("/test-file-utf8.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , testParamBlockSize , UTF_8);
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void c() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileEmpty = new java.io.File(getClass().getResource("/test-file-empty.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileEmpty , testParamBlockSize , UTF_8);
        org.junit.Assert.assertNull(reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void i() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileUTF16BE = new java.io.File(getClass().getResource("/test-file-utf16be.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileUTF16BE , testParamBlockSize , "UTF-16BE");
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void j() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileUTF16LE = new java.io.File(getClass().getResource("/test-file-utf16le.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileUTF16LE , testParamBlockSize , "UTF-16LE");
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void h() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileShiftJIS = new java.io.File(getClass().getResource("/test-file-shiftjis.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileShiftJIS , testParamBlockSize , "Shift_JIS");
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_SHIFT_JIS2, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_SHIFT_JIS1, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void q() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileWindows31J = new java.io.File(getClass().getResource("/test-file-windows-31j.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileWindows31J , testParamBlockSize , "windows-31j");
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_WINDOWS_31J_2, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_WINDOWS_31J_1, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void e() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileGBK = new java.io.File(getClass().getResource("/test-file-gbk.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileGBK , testParamBlockSize , "GBK");
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_GBK_2, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_GBK_1, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void r() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFilexWindows949 = new java.io.File(getClass().getResource("/test-file-x-windows-949.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFilexWindows949 , testParamBlockSize , "x-windows-949");
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_X_WINDOWS_949_2, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_X_WINDOWS_949_1, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void s() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFilexWindows950 = new java.io.File(getClass().getResource("/test-file-x-windows-950.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFilexWindows950 , testParamBlockSize , "x-windows-950");
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_X_WINDOWS_950_2, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(TEST_LINE_X_WINDOWS_950_1, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void d() throws java.io.IOException, java.net.URISyntaxException {
        final int blockSize = 10;
        final java.io.File testFile20Bytes = new java.io.File(getClass().getResource("/test-file-20byteslength.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFile20Bytes , blockSize , ISO_8859_1);
        final java.lang.String testLine = "123456789";
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(testLine, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(testLine, reversedLinesFileReader.readLine());
    }

    @org.junit.Test
    public void n() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileUtf8 = new java.io.File(getClass().getResource("/test-file-utf8-win-linebr.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileUtf8 , testParamBlockSize , UTF_8);
        assertFileWithShrinkingTestLines(reversedLinesFileReader);
    }

    @org.junit.Test
    public void g() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource("/test-file-iso8859-1-shortlines-win-linebr.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , testParamBlockSize , ISO_8859_1);
        for (int i = 3 ; i > 0 ; i--) {
            for (int j = 1 ; j <= 3 ; j++) {
                org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks("", reversedLinesFileReader.readLine());
            }
            org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(("" + i), reversedLinesFileReader.readLine());
        }
    }

    @org.junit.Test(expected = java.io.UnsupportedEncodingException.class)
    public void p() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileEmpty = new java.io.File(getClass().getResource("/test-file-empty.bin").toURI());
        new org.apache.commons.io.input.ReversedLinesFileReader(testFileEmpty , testParamBlockSize , "UTF-16").close();
    }

    @org.junit.Test(expected = java.io.UnsupportedEncodingException.class)
    public void o() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileEncodingBig5 = new java.io.File(getClass().getResource("/test-file-empty.bin").toURI());
        new org.apache.commons.io.input.ReversedLinesFileReader(testFileEncodingBig5 , testParamBlockSize , "Big5").close();
    }

    private void a(final org.apache.commons.io.input.ReversedLinesFileReader reversedLinesFileReader) throws java.io.IOException {
        java.lang.String line = null;
        int lineCount = 0;
        while ((line = reversedLinesFileReader.readLine()) != null) {
            lineCount++;
            org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks((("Line " + lineCount) + " is not matching"), TEST_LINE.substring(0, lineCount), line);
        }
    }

    static void a(final java.lang.String msg, final java.lang.String expected, final java.lang.String actual) {
        if (actual != null) {
            org.junit.Assert.assertFalse(("Line contains \\n: line=" + actual), actual.contains("\n"));
            org.junit.Assert.assertFalse(("Line contains \\r: line=" + actual), actual.contains("\r"));
        } 
        org.junit.Assert.assertEquals(msg, expected, actual);
    }

    static void a(final java.lang.String expected, final java.lang.String actual) {
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(null, expected, actual);
    }
}

