package org.apache.commons.csv;


final class Assertions {
    private Assertions() {
    }

    public static void notNull(final java.lang.Object parameter, final java.lang.String parameterName) {
        if (parameter == null) {
            throw new java.lang.IllegalArgumentException((("Parameter \'" + parameterName) + "\' must not be null!"));
        } 
    }
}

