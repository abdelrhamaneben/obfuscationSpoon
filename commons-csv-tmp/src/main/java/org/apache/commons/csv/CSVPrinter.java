package org.apache.commons.csv;


public final class CSVPrinter implements java.io.Closeable , java.io.Flushable {
    private final java.lang.Appendable out;

    private final org.apache.commons.csv.CSVFormat format;

    private boolean newRecord = true;

    public CSVPrinter(final java.lang.Appendable out ,final org.apache.commons.csv.CSVFormat format) throws java.io.IOException {
        org.apache.commons.csv.Assertions.notNull(out, "out");
        org.apache.commons.csv.Assertions.notNull(format, "format");
        this.out = out;
        this.format = format;
        if ((format.q()) != null) {
            for (final java.lang.String line : format.q()) {
                if (line != null) {
                    b(line);
                } 
            }
        } 
        if (((format.p()) != null) && (!(format.e()))) {
            b(((java.lang.Object[])(format.p())));
        } 
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if ((out) instanceof java.io.Closeable) {
            ((java.io.Closeable)(out)).close();
        } 
    }

    @java.lang.Override
    public void flush() throws java.io.IOException {
        if ((out) instanceof java.io.Flushable) {
            ((java.io.Flushable)(out)).flush();
        } 
    }

    public java.lang.Appendable a() {
        return this.out;
    }

    public void a(final java.lang.Object value) throws java.io.IOException {
        java.lang.String strValue;
        if (value == null) {
            final java.lang.String nullString = format.n();
            strValue = nullString == null ? org.apache.commons.csv.Constants.EMPTY : nullString;
        } else {
            strValue = value.toString();
        }
        a(value, strValue, 0, strValue.length());
    }

    private void a(final java.lang.Object object, final java.lang.CharSequence value, final int offset, final int len) throws java.io.IOException {
        if (!(newRecord)) {
            out.append(format.j());
        } 
        if (format.i()) {
            b(object, value, offset, len);
        } else if (format.g()) {
            a(value, offset, len);
        } else {
            out.append(value, offset, (offset + len));
        }
        newRecord = false;
    }

    private void a(final java.lang.CharSequence value, final int offset, final int len) throws java.io.IOException {
        int start = offset;
        int pos = offset;
        final int end = offset + len;
        final char delim = format.j();
        final char escape = format.l().charValue();
        while (pos < end) {
            char c = value.charAt(pos);
            if ((((c == (org.apache.commons.csv.Constants.CR)) || (c == (org.apache.commons.csv.Constants.LF))) || (c == delim)) || (c == escape)) {
                if (pos > start) {
                    out.append(value, start, pos);
                } 
                if (c == (org.apache.commons.csv.Constants.LF)) {
                    c = 'n';
                } else if (c == (org.apache.commons.csv.Constants.CR)) {
                    c = 'r';
                } 
                out.append(escape);
                out.append(c);
                start = pos + 1;
            } 
            pos++;
        }
        if (pos > start) {
            out.append(value, start, pos);
        } 
    }

    private void b(final java.lang.Object object, final java.lang.CharSequence value, final int offset, final int len) throws java.io.IOException {
        boolean quote = false;
        int start = offset;
        int pos = offset;
        final int end = offset + len;
        final char delimChar = format.j();
        final char quoteChar = format.m().charValue();
        org.apache.commons.csv.QuoteMode quoteModePolicy = format.w();
        if (quoteModePolicy == null) {
            quoteModePolicy = org.apache.commons.csv.QuoteMode.MINIMAL;
        } 
        switch (quoteModePolicy) {
            case ALL :
                quote = true;
                break;
            case NON_NUMERIC :
                quote = !(object instanceof java.lang.Number);
                break;
            case NONE :
                a(value, offset, len);
                return ;
            case MINIMAL :
                if (len <= 0) {
                    if (newRecord) {
                        quote = true;
                    } 
                } else {
                    char c = value.charAt(pos);
                    if ((newRecord) && ((((c < '0') || ((c > '9') && (c < 'A'))) || ((c > 'Z') && (c < 'a'))) || (c > 'z'))) {
                        quote = true;
                    } else if (c <= (org.apache.commons.csv.Constants.COMMENT)) {
                        quote = true;
                    } else {
                        while (pos < end) {
                            c = value.charAt(pos);
                            if ((((c == (org.apache.commons.csv.Constants.LF)) || (c == (org.apache.commons.csv.Constants.CR))) || (c == quoteChar)) || (c == delimChar)) {
                                quote = true;
                                break;
                            } 
                            pos++;
                        }
                        if (!quote) {
                            pos = end - 1;
                            c = value.charAt(pos);
                            if (c <= (org.apache.commons.csv.Constants.SP)) {
                                quote = true;
                            } 
                        } 
                    }
                }
                if (!quote) {
                    out.append(value, start, end);
                    return ;
                } 
                break;
            default :
                throw new java.lang.IllegalStateException(("Unexpected Quote value: " + quoteModePolicy));
        }
        if (!quote) {
            out.append(value, start, end);
            return ;
        } 
        out.append(quoteChar);
        while (pos < end) {
            final char c = value.charAt(pos);
            if (c == quoteChar) {
                out.append(value, start, (pos + 1));
                start = pos;
            } 
            pos++;
        }
        out.append(value, start, pos);
        out.append(quoteChar);
    }

    public void b(final java.lang.String comment) throws java.io.IOException {
        if (!(format.f())) {
            return ;
        } 
        if (!(newRecord)) {
            b();
        } 
        out.append(format.k().charValue());
        out.append(org.apache.commons.csv.Constants.SP);
        for (int i = 0 ; i < (comment.length()) ; i++) {
            final char c = comment.charAt(i);
            switch (c) {
                case org.apache.commons.csv.Constants.CR :
                    if (((i + 1) < (comment.length())) && ((comment.charAt((i + 1))) == (org.apache.commons.csv.Constants.LF))) {
                        i++;
                    } 
                case org.apache.commons.csv.Constants.LF :
                    b();
                    out.append(format.k().charValue());
                    out.append(org.apache.commons.csv.Constants.SP);
                    break;
                default :
                    out.append(c);
                    break;
            }
        }
        b();
    }

    public void b() throws java.io.IOException {
        final java.lang.String recordSeparator = format.o();
        if (recordSeparator != null) {
            out.append(recordSeparator);
        } 
        newRecord = true;
    }

    public void b(final java.lang.Iterable<?> values) throws java.io.IOException {
        for (final java.lang.Object value : values) {
            a(value);
        }
        b();
    }

    public void b(final java.lang.Object... values) throws java.io.IOException {
        for (final java.lang.Object value : values) {
            a(value);
        }
        b();
    }

    public void c(final java.lang.Iterable<?> values) throws java.io.IOException {
        for (final java.lang.Object value : values) {
            if (value instanceof java.lang.Object[]) {
                b(((java.lang.Object[])(value)));
            } else if (value instanceof java.lang.Iterable) {
                b(((java.lang.Iterable<?>)(value)));
            } else {
                b(value);
            }
        }
    }

    public void c(final java.lang.Object... values) throws java.io.IOException {
        for (final java.lang.Object value : values) {
            if (value instanceof java.lang.Object[]) {
                b(((java.lang.Object[])(value)));
            } else if (value instanceof java.lang.Iterable) {
                b(((java.lang.Iterable<?>)(value)));
            } else {
                b(value);
            }
        }
    }

    public void b(final java.sql.ResultSet resultSet) throws java.io.IOException, java.sql.SQLException {
        final int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1 ; i <= columnCount ; i++) {
                a(resultSet.getObject(i));
            }
            b();
        }
    }
}

