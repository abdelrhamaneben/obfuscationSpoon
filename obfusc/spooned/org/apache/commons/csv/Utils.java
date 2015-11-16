package org.apache.commons.csv;


final class Utils {
    private Utils() {
    }

    public static void compare(final java.lang.String message, final java.lang.String[][] expected, final java.util.List<org.apache.commons.csv.CSVRecord> actual) {
        org.junit.Assert.assertEquals((message + "  - outer array size"), expected.length, actual.size());
        for (int i = 0 ; i < (expected.length) ; i++) {
            org.junit.Assert.assertArrayEquals((((message + " (entry ") + i) + ")"), expected[i], actual.get(i).d());
        }
    }
}

