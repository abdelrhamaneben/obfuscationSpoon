package org.apache.commons.io.input;


public class ReversedLinesFileReaderTestSimple {
    private org.apache.commons.io.input.ReversedLinesFileReader reversedLinesFileReader;

    @org.junit.After
    public void a() {
        try {
            reversedLinesFileReader.close();
        } catch (final java.lang.Exception e) {
        }
    }

    @org.junit.Test
    public void b() throws java.io.IOException, java.net.URISyntaxException {
        final int blockSize = 10;
        final java.io.File testFile20Bytes = new java.io.File(getClass().getResource("/test-file-20byteslength.bin").toURI());
        reversedLinesFileReader = new org.apache.commons.io.input.ReversedLinesFileReader(testFile20Bytes , blockSize , "ISO-8859-1");
        final java.lang.String testLine = "123456789";
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(testLine, reversedLinesFileReader.readLine());
        org.apache.commons.io.input.ReversedLinesFileReaderTestParamBlockSize.assertEqualsAndNoLineBreaks(testLine, reversedLinesFileReader.readLine());
    }

    @org.junit.Test(expected = java.io.UnsupportedEncodingException.class)
    public void d() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileEmpty = new java.io.File(getClass().getResource("/test-file-empty.bin").toURI());
        new org.apache.commons.io.input.ReversedLinesFileReader(testFileEmpty , 4096 , "UTF-16").close();
    }

    @org.junit.Test(expected = java.io.UnsupportedEncodingException.class)
    public void c() throws java.io.IOException, java.net.URISyntaxException {
        final java.io.File testFileEncodingBig5 = new java.io.File(getClass().getResource("/test-file-empty.bin").toURI());
        new org.apache.commons.io.input.ReversedLinesFileReader(testFileEncodingBig5 , 4096 , "Big5").close();
    }
}

