package org.apache.commons.csv;


final class Lexer implements java.io.Closeable {
    private static final char DISABLED = '￾';

    private final char delimiter;

    private final char escape;

    private final char quoteChar;

    private final char commentStart;

    private final boolean ignoreSurroundingSpaces;

    private final boolean ignoreEmptyLines;

    private final org.apache.commons.csv.ExtendedBufferedReader reader;

    Lexer(final org.apache.commons.csv.CSVFormat format ,final org.apache.commons.csv.ExtendedBufferedReader reader) {
        this.reader = reader;
        this.delimiter = format.j();
        this.escape = a(format.l());
        this.quoteChar = a(format.m());
        this.commentStart = a(format.k());
        this.ignoreSurroundingSpaces = format.d();
        this.ignoreEmptyLines = format.b();
    }

    org.apache.commons.csv.Token a(final org.apache.commons.csv.Token token) throws java.io.IOException {
        int lastChar = reader.b();
        int c = reader.read();
        boolean eol = i(c);
        if (ignoreEmptyLines) {
            while (eol && (g(lastChar))) {
                lastChar = c;
                c = reader.read();
                eol = i(c);
                if (c(c)) {
                    token.type = org.apache.commons.csv.Token.Type.EOF;
                    return token;
                } 
            }
        } 
        if ((c(lastChar)) || ((!(b(lastChar))) && (c(c)))) {
            token.type = org.apache.commons.csv.Token.Type.EOF;
            return token;
        } 
        if ((g(lastChar)) && (a(c))) {
            final java.lang.String line = reader.readLine();
            if (line == null) {
                token.type = org.apache.commons.csv.Token.Type.EOF;
                return token;
            } 
            final java.lang.String comment = line.trim();
            token.content.append(comment);
            token.type = org.apache.commons.csv.Token.Type.COMMENT;
            return token;
        } 
        while ((token.type) == (org.apache.commons.csv.Token.Type.INVALID)) {
            if (ignoreSurroundingSpaces) {
                while ((h(c)) && (!eol)) {
                    c = reader.read();
                    eol = i(c);
                }
            } 
            if (b(c)) {
                token.type = org.apache.commons.csv.Token.Type.TOKEN;
            } else if (eol) {
                token.type = org.apache.commons.csv.Token.Type.EORECORD;
            } else if (f(c)) {
                b(token);
            } else if (c(c)) {
                token.type = org.apache.commons.csv.Token.Type.EOF;
                token.isReady = true;
            } else {
                a(token, c);
            }
        }
        return token;
    }

    private org.apache.commons.csv.Token a(final org.apache.commons.csv.Token token, int ch) throws java.io.IOException {
        while (true) {
            if (i(ch)) {
                token.type = org.apache.commons.csv.Token.Type.EORECORD;
                break;
            } else if (c(ch)) {
                token.type = org.apache.commons.csv.Token.Type.EOF;
                token.isReady = true;
                break;
            } else if (b(ch)) {
                token.type = org.apache.commons.csv.Token.Type.TOKEN;
                break;
            } else if (d(ch)) {
                final int unescaped = b();
                if (unescaped == (org.apache.commons.csv.Constants.END_OF_STREAM)) {
                    token.content.append(((char)(ch))).append(((char)(reader.b())));
                } else {
                    token.content.append(((char)(unescaped)));
                }
                ch = reader.read();
            } else {
                token.content.append(((char)(ch)));
                ch = reader.read();
            }
        }
        if (ignoreSurroundingSpaces) {
            a(token.content);
        } 
        return token;
    }

    private org.apache.commons.csv.Token b(final org.apache.commons.csv.Token token) throws java.io.IOException {
        final long startLineNumber = d();
        int c;
        while (true) {
            c = reader.read();
            if (d(c)) {
                final int unescaped = b();
                if (unescaped == (org.apache.commons.csv.Constants.END_OF_STREAM)) {
                    token.content.append(((char)(c))).append(((char)(reader.b())));
                } else {
                    token.content.append(((char)(unescaped)));
                }
            } else if (f(c)) {
                if (f(reader.c())) {
                    c = reader.read();
                    token.content.append(((char)(c)));
                } else {
                    while (true) {
                        c = reader.read();
                        if (b(c)) {
                            token.type = org.apache.commons.csv.Token.Type.TOKEN;
                            return token;
                        } else if (c(c)) {
                            token.type = org.apache.commons.csv.Token.Type.EOF;
                            token.isReady = true;
                            return token;
                        } else if (i(c)) {
                            token.type = org.apache.commons.csv.Token.Type.EORECORD;
                            return token;
                        } else if (!(h(c))) {
                            throw new java.io.IOException((("(line " + (d())) + ") invalid char between encapsulated token and delimiter"));
                        } 
                    }
                }
            } else if (c(c)) {
                throw new java.io.IOException((("(startline " + startLineNumber) + ") EOF reached before encapsulated token finished"));
            } else {
                token.content.append(((char)(c)));
            }
        }
    }

    private char a(final java.lang.Character c) {
        return c == null ? DISABLED : c.charValue();
    }

    long d() {
        return reader.d();
    }

    long c() {
        return reader.e();
    }

    int b() throws java.io.IOException {
        final int ch = reader.read();
        switch (ch) {
            case 'r' :
                return org.apache.commons.csv.Constants.CR;
            case 'n' :
                return org.apache.commons.csv.Constants.LF;
            case 't' :
                return org.apache.commons.csv.Constants.TAB;
            case 'b' :
                return org.apache.commons.csv.Constants.BACKSPACE;
            case 'f' :
                return org.apache.commons.csv.Constants.FF;
            case org.apache.commons.csv.Constants.CR :
            case org.apache.commons.csv.Constants.LF :
            case org.apache.commons.csv.Constants.FF :
            case org.apache.commons.csv.Constants.TAB :
            case org.apache.commons.csv.Constants.BACKSPACE :
                return ch;
            case org.apache.commons.csv.Constants.END_OF_STREAM :
                throw new java.io.IOException("EOF whilst processing escape sequence");
            default :
                if (e(ch)) {
                    return ch;
                } 
                return org.apache.commons.csv.Constants.END_OF_STREAM;
        }
    }

    void a(final java.lang.StringBuilder buffer) {
        int length = buffer.length();
        while ((length > 0) && (java.lang.Character.isWhitespace(buffer.charAt((length - 1))))) {
            length = length - 1;
        }
        if (length != (buffer.length())) {
            buffer.setLength(length);
        } 
    }

    boolean i(int ch) throws java.io.IOException {
        if ((ch == (org.apache.commons.csv.Constants.CR)) && ((reader.c()) == (org.apache.commons.csv.Constants.LF))) {
            ch = reader.read();
        } 
        return (ch == (org.apache.commons.csv.Constants.LF)) || (ch == (org.apache.commons.csv.Constants.CR));
    }

    boolean a() {
        return reader.a();
    }

    boolean h(final int ch) {
        return (!(b(ch))) && (java.lang.Character.isWhitespace(((char)(ch))));
    }

    boolean g(final int ch) {
        return ((ch == (org.apache.commons.csv.Constants.LF)) || (ch == (org.apache.commons.csv.Constants.CR))) || (ch == (org.apache.commons.csv.Constants.UNDEFINED));
    }

    boolean c(final int ch) {
        return ch == (org.apache.commons.csv.Constants.END_OF_STREAM);
    }

    boolean b(final int ch) {
        return ch == (delimiter);
    }

    boolean d(final int ch) {
        return ch == (escape);
    }

    boolean f(final int ch) {
        return ch == (quoteChar);
    }

    boolean a(final int ch) {
        return ch == (commentStart);
    }

    private boolean e(final int ch) {
        return (((ch == (delimiter)) || (ch == (escape))) || (ch == (quoteChar))) || (ch == (commentStart));
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        reader.close();
    }
}

