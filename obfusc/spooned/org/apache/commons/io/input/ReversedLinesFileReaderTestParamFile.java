package org.apache.commons.io.input;


@org.junit.runner.RunWith(value = org.junit.runners.Parameterized.class)
public class ReversedLinesFileReaderTestParamFile {
    @org.junit.runners.Parameterized.Parameters(name = "{0}, charset={1}")
    public static java.util.Collection<java.lang.Object[]> a() {
        return java.util.Arrays.asList(new java.lang.Object[][]{ new java.lang.Object[]{ "test-file-20byteslength.bin" , "ISO_8859_1" , null } , new java.lang.Object[]{ "test-file-iso8859-1-shortlines-win-linebr.bin" , "ISO_8859_1" , null } , new java.lang.Object[]{ "test-file-iso8859-1.bin" , "ISO_8859_1" , null } , new java.lang.Object[]{ "test-file-shiftjis.bin" , "Shift_JIS" , null } , new java.lang.Object[]{ "test-file-utf16be.bin" , "UTF-16BE" , null } , new java.lang.Object[]{ "test-file-utf16le.bin" , "UTF-16LE" , null } , new java.lang.Object[]{ "test-file-utf8-cr-only.bin" , "UTF-8" , null } , new java.lang.Object[]{ "test-file-utf8-win-linebr.bin" , "UTF-8" , null } , new java.lang.Object[]{ "test-file-utf8-win-linebr.bin" , "UTF-8" , 1 } , new java.lang.Object[]{ "test-file-utf8-win-linebr.bin" , "UTF-8" , 2 } , new java.lang.Object[]{ "test-file-utf8-win-linebr.bin" , "UTF-8" , 3 } , new java.lang.Object[]{ "test-file-utf8-win-linebr.bin" , "UTF-8" , 4 } , new java.lang.Object[]{ "test-file-utf8.bin" , "UTF-8" , null } , new java.lang.Object[]{ "test-file-windows-31j.bin" , "windows-31j" , null } , new java.lang.Object[]{ "test-file-gbk.bin" , "gbk" , null } , new java.lang.Object[]{ "test-file-x-windows-949.bin" , "x-windows-949" , null } , new java.lang.Object[]{ "test-file-x-windows-950.bin" , "x-windows-950" , null } });
    }

    private org.apache.commons.io.input.ReversedLinesFileReader reversedLinesFileReader;

    private java.io.BufferedReader bufferedReader;

    private final java.lang.String fileName;

    private final java.lang.String encoding;

    private final int buffSize;

    public ReversedLinesFileReaderTestParamFile(final java.lang.String fileName ,final java.lang.String encoding ,final java.lang.Integer buffsize) {
        this.fileName = fileName;
        this.encoding = encoding;
        this.buffSize = buffsize == null ? 4096 : buffsize;
    }

    @org.junit.Test
    public void c() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileIso = new java.io.File(getClass().getResource(("/" + (fileName))).toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFileIso , buffSize , encoding);
        final java.util.Stack<java.lang.String> lineStack = new java.util.Stack<java.lang.String>();
        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(testFileIso) , encoding));
        java.lang.String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lineStack.push(line);
        }
        while ((line = reversedLinesFileReader.readLine()) != null) {
            final java.lang.String lineFromBufferedReader = lineStack.pop();
            org.junit.Assert.assertEquals(lineFromBufferedReader, line);
        }
    }

    @org.junit.After
    public void b() {
        try {
            bufferedReader.close();
        } catch (final java.lang.Exception e) {
        }
        try {
            reversedLinesFileReader.close();
        } catch (final java.lang.Exception e) {
        }
    }
}

