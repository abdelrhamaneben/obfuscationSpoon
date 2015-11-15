package org.apache.commons.io;


public class HexDumpTest extends junit.framework.TestCase {
    public HexDumpTest(final java.lang.String name) {
        super(name);
    }

    private char b(final int n) {
        final char[] hexChars = new char[]{ '0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F' };
        return hexChars[(n % 16)];
    }

    public void a() throws java.io.IOException {
        final byte[] testArray = new byte[256];
        for (int j = 0 ; j < 256 ; j++) {
            testArray[j] = ((byte)(j));
        }
        org.apache.commons.io.output.ByteArrayOutputStream stream = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.HexDump.dump(testArray, 0, stream, 0);
        byte[] outputArray = new byte[16 * (73 + (org.apache.commons.io.HexDump.EOL.length()))];
        for (int j = 0 ; j < 16 ; j++) {
            int offset = (73 + (org.apache.commons.io.HexDump.EOL.length())) * j;
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(toHex(j)));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(' '));
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toHex(j)));
                outputArray[offset++] = ((byte)(toHex(k)));
                outputArray[offset++] = ((byte)(' '));
            }
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toAscii(((j * 16) + k))));
            }
            java.lang.System.arraycopy(org.apache.commons.io.HexDump.EOL.getBytes(), 0, outputArray, offset, org.apache.commons.io.HexDump.EOL.getBytes().length);
        }
        byte[] actualOutput = stream.toByteArray();
        junit.framework.TestCase.assertEquals("array size mismatch", outputArray.length, actualOutput.length);
        for (int j = 0 ; j < (outputArray.length) ; j++) {
            junit.framework.TestCase.assertEquals((("array[ " + j) + "] mismatch"), outputArray[j], actualOutput[j]);
        }
        stream = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.HexDump.dump(testArray, 268435456, stream, 0);
        outputArray = new byte[16 * (73 + (org.apache.commons.io.HexDump.EOL.length()))];
        for (int j = 0 ; j < 16 ; j++) {
            int offset = (73 + (org.apache.commons.io.HexDump.EOL.length())) * j;
            outputArray[offset++] = ((byte)('1'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(toHex(j)));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(' '));
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toHex(j)));
                outputArray[offset++] = ((byte)(toHex(k)));
                outputArray[offset++] = ((byte)(' '));
            }
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toAscii(((j * 16) + k))));
            }
            java.lang.System.arraycopy(org.apache.commons.io.HexDump.EOL.getBytes(), 0, outputArray, offset, org.apache.commons.io.HexDump.EOL.getBytes().length);
        }
        actualOutput = stream.toByteArray();
        junit.framework.TestCase.assertEquals("array size mismatch", outputArray.length, actualOutput.length);
        for (int j = 0 ; j < (outputArray.length) ; j++) {
            junit.framework.TestCase.assertEquals((("array[ " + j) + "] mismatch"), outputArray[j], actualOutput[j]);
        }
        stream = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.HexDump.dump(testArray, -16777216, stream, 0);
        outputArray = new byte[16 * (73 + (org.apache.commons.io.HexDump.EOL.length()))];
        for (int j = 0 ; j < 16 ; j++) {
            int offset = (73 + (org.apache.commons.io.HexDump.EOL.length())) * j;
            outputArray[offset++] = ((byte)('F'));
            outputArray[offset++] = ((byte)('F'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(toHex(j)));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(' '));
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toHex(j)));
                outputArray[offset++] = ((byte)(toHex(k)));
                outputArray[offset++] = ((byte)(' '));
            }
            for (int k = 0 ; k < 16 ; k++) {
                outputArray[offset++] = ((byte)(toAscii(((j * 16) + k))));
            }
            java.lang.System.arraycopy(org.apache.commons.io.HexDump.EOL.getBytes(), 0, outputArray, offset, org.apache.commons.io.HexDump.EOL.getBytes().length);
        }
        actualOutput = stream.toByteArray();
        junit.framework.TestCase.assertEquals("array size mismatch", outputArray.length, actualOutput.length);
        for (int j = 0 ; j < (outputArray.length) ; j++) {
            junit.framework.TestCase.assertEquals((("array[ " + j) + "] mismatch"), outputArray[j], actualOutput[j]);
        }
        stream = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.HexDump.dump(testArray, 268435456, stream, 129);
        outputArray = new byte[(8 * (73 + (org.apache.commons.io.HexDump.EOL.length()))) - 1];
        for (int j = 0 ; j < 8 ; j++) {
            int offset = (73 + (org.apache.commons.io.HexDump.EOL.length())) * j;
            outputArray[offset++] = ((byte)('1'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)('0'));
            outputArray[offset++] = ((byte)(toHex((j + 8))));
            outputArray[offset++] = ((byte)('1'));
            outputArray[offset++] = ((byte)(' '));
            for (int k = 0 ; k < 16 ; k++) {
                final int index = (129 + (j * 16)) + k;
                if (index < 256) {
                    outputArray[offset++] = ((byte)(toHex((index / 16))));
                    outputArray[offset++] = ((byte)(toHex(index)));
                } else {
                    outputArray[offset++] = ((byte)(' '));
                    outputArray[offset++] = ((byte)(' '));
                }
                outputArray[offset++] = ((byte)(' '));
            }
            for (int k = 0 ; k < 16 ; k++) {
                final int index = (129 + (j * 16)) + k;
                if (index < 256) {
                    outputArray[offset++] = ((byte)(toAscii(index)));
                } 
            }
            java.lang.System.arraycopy(org.apache.commons.io.HexDump.EOL.getBytes(), 0, outputArray, offset, org.apache.commons.io.HexDump.EOL.getBytes().length);
        }
        actualOutput = stream.toByteArray();
        junit.framework.TestCase.assertEquals("array size mismatch", outputArray.length, actualOutput.length);
        for (int j = 0 ; j < (outputArray.length) ; j++) {
            junit.framework.TestCase.assertEquals((("array[ " + j) + "] mismatch"), outputArray[j], actualOutput[j]);
        }
        try {
            org.apache.commons.io.HexDump.dump(testArray, 268435456, new org.apache.commons.io.output.ByteArrayOutputStream(), -1);
            junit.framework.TestCase.fail("should have caught ArrayIndexOutOfBoundsException on negative index");
        } catch (final java.lang.ArrayIndexOutOfBoundsException ignored_exception) {
        }
        try {
            org.apache.commons.io.HexDump.dump(testArray, 268435456, new org.apache.commons.io.output.ByteArrayOutputStream(), testArray.length);
            junit.framework.TestCase.fail("should have caught ArrayIndexOutOfBoundsException on large index");
        } catch (final java.lang.ArrayIndexOutOfBoundsException ignored_exception) {
        }
        try {
            org.apache.commons.io.HexDump.dump(testArray, 268435456, null, 0);
            junit.framework.TestCase.fail("should have caught IllegalArgumentException on negative index");
        } catch (final java.lang.IllegalArgumentException ignored_exception) {
        }
    }

    private char a(final int c) {
        char rval = '.';
        if ((c >= 32) && (c <= 126)) {
            rval = ((char)(c));
        } 
        return rval;
    }
}

