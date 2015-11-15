package org.apache.commons.io;


public class HexDump {
    public HexDump() {
        super();
    }

    public static void a(final byte[] data, final long offset, final java.io.OutputStream stream, final int index) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if ((index < 0) || (index >= (data.length))) {
            throw new java.lang.ArrayIndexOutOfBoundsException(((("illegal index: " + index) + " into array of length ") + (data.length)));
        } 
        if (stream == null) {
            throw new java.lang.IllegalArgumentException("cannot write to nullstream");
        } 
        long display_offset = offset + index;
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder(74);
        for (int j = index ; j < (data.length) ; j += 16) {
            int chars_read = (data.length) - j;
            if (chars_read > 16) {
                chars_read = 16;
            } 
            org.apache.commons.io.HexDump.dump(buffer, display_offset).append(' ');
            for (int k = 0 ; k < 16 ; k++) {
                if (k < chars_read) {
                    org.apache.commons.io.HexDump.dump(buffer, data[(k + j)]);
                } else {
                    buffer.append("  ");
                }
                buffer.append(' ');
            }
            for (int k = 0 ; k < chars_read ; k++) {
                if (((data[(k + j)]) >= ' ') && ((data[(k + j)]) < 127)) {
                    buffer.append(((char)(data[(k + j)])));
                } else {
                    buffer.append('.');
                }
            }
            buffer.append(EOL);
            stream.write(buffer.toString().getBytes(java.nio.charset.Charset.defaultCharset()));
            stream.flush();
            buffer.setLength(0);
            display_offset += chars_read;
        }
    }

    public static final java.lang.String EOL = java.lang.System.getProperty("line.separator");

    private static final char[] _hexcodes = new char[]{ '0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F' };

    private static final int[] _shifts = new int[]{ 28 , 24 , 20 , 16 , 12 , 8 , 4 , 0 };

    private static java.lang.StringBuilder a(final java.lang.StringBuilder _lbuffer, final long value) {
        for (int j = 0 ; j < 8 ; j++) {
            _lbuffer.append(_hexcodes[(((int)((value >> (_shifts[j])))) & 15)]);
        }
        return _lbuffer;
    }

    private static java.lang.StringBuilder a(final java.lang.StringBuilder _cbuffer, final byte value) {
        for (int j = 0 ; j < 2 ; j++) {
            _cbuffer.append(_hexcodes[((value >> (_shifts[(j + 6)])) & 15)]);
        }
        return _cbuffer;
    }
}

