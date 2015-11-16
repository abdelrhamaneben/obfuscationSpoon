package org.apache.commons.csv;


public final class CSVRecord implements java.io.Serializable , java.lang.Iterable<java.lang.String> {
    private static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];

    private static final long serialVersionUID = 1L;

    private final long characterPosition;

    private final java.lang.String comment;

    private final java.util.Map<java.lang.String, java.lang.Integer> mapping;

    private final long recordNumber;

    private final java.lang.String[] values;

    CSVRecord(final java.lang.String[] values ,final java.util.Map<java.lang.String, java.lang.Integer> mapping ,final java.lang.String comment ,final long recordNumber ,final long characterPosition) {
        this.recordNumber = recordNumber;
        this.values = values != null ? values : EMPTY_STRING_ARRAY;
        this.mapping = mapping;
        this.comment = comment;
        this.characterPosition = characterPosition;
    }

    public java.lang.String a(final java.lang.Enum<?> e) {
        return c(e.toString());
    }

    public java.lang.String a(final int i) {
        return values[i];
    }

    public java.lang.String c(final java.lang.String name) {
        if ((mapping) == null) {
            throw new java.lang.IllegalStateException("No header mapping was specified, the record values can\'t be accessed by name");
        } 
        final java.lang.Integer index = mapping.get(name);
        if (index == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Mapping for %s not found, expected one of %s", name, mapping.keySet()));
        } 
        try {
            return values[index.intValue()];
        } catch (final java.lang.ArrayIndexOutOfBoundsException e) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Index for header \'%s\' is %d but CSVRecord only has %d values!", name, index, java.lang.Integer.valueOf(values.length)));
        }
    }

    public long g() {
        return characterPosition;
    }

    public java.lang.String c() {
        return comment;
    }

    public long h() {
        return recordNumber;
    }

    public boolean a() {
        return ((mapping) == null) || ((mapping.size()) == (values.length));
    }

    public boolean a(final java.lang.String name) {
        return ((mapping) != null) && (mapping.containsKey(name));
    }

    public boolean b(final java.lang.String name) {
        return (a(name)) && ((mapping.get(name).intValue()) < (values.length));
    }

    @java.lang.Override
    public java.util.Iterator<java.lang.String> iterator() {
        return e().iterator();
    }

    <M extends java.util.Map<java.lang.String, java.lang.String>>M a(final M map) {
        if ((mapping) == null) {
            return map;
        } 
        for (final java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : mapping.entrySet()) {
            final int col = entry.getValue().intValue();
            if (col < (values.length)) {
                map.put(entry.getKey(), values[col]);
            } 
        }
        return map;
    }

    public int b() {
        return values.length;
    }

    private java.util.List<java.lang.String> e() {
        return java.util.Arrays.asList(values);
    }

    public java.util.Map<java.lang.String, java.lang.String> f() {
        return a(new java.util.HashMap<java.lang.String, java.lang.String>(values.length));
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((((("CSVRecord [comment=" + (comment)) + ", mapping=") + (mapping)) + ", recordNumber=") + (recordNumber)) + ", values=") + (java.util.Arrays.toString(values))) + "]";
    }

    java.lang.String[] d() {
        return values;
    }
}

