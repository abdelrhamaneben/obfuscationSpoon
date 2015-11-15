package org.apache.commons.io;


public class FilenameUtilsWildcardTestCase extends junit.framework.TestCase {
    private static final boolean WINDOWS = (java.io.File.separatorChar) == '\\';

    public FilenameUtilsWildcardTestCase(final java.lang.String name) {
        super(name);
    }

    public void b() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch(null, "Foo"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch(null, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("", "*"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("", "?"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Fo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Fo?"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo Bar and Catflap", "Fo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("New Bookmarks", "N?w ?o?k??r?s"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Bar"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo Bar Foo", "F*o Bar*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Adobe Acrobat Installer", "Ad*er"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "*Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("BarFoo", "*Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Foo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("FooBar", "Foo*"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "*Foo"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("BARFOO", "*Foo"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "Foo*"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOOBAR", "Foo*"));
    }

    public void e() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem(null, "Foo"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem(null, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "Fo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "Fo?"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo Bar and Catflap", "Fo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("New Bookmarks", "N?w ?o?k??r?s"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "Bar"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo Bar Foo", "F*o Bar*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Adobe Acrobat Installer", "Ad*er"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "*Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("BarFoo", "*Foo"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("Foo", "Foo*"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("FooBar", "Foo*"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("FOO", "*Foo"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("BARFOO", "*Foo"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("FOO", "Foo*"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatchOnSystem("FOOBAR", "Foo*"));
    }

    public void d() {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch(null, "Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", null, org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch(null, null, org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("", "", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Fo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Fo?", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo Bar and Catflap", "Fo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("New Bookmarks", "N?w ?o?k??r?s", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Bar", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo Bar Foo", "F*o Bar*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Adobe Acrobat Installer", "Ad*er", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "*Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Foo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "*Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("BarFoo", "*Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("Foo", "Foo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("FooBar", "Foo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "*Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("BARFOO", "*Foo", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "Foo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FilenameUtils.wildcardMatch("FOOBAR", "Foo*", org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "*Foo", org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("BARFOO", "*Foo", org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "Foo*", org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FilenameUtils.wildcardMatch("FOOBAR", "Foo*", org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "*Foo", org.apache.commons.io.IOCase.SYSTEM));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatch("BARFOO", "*Foo", org.apache.commons.io.IOCase.SYSTEM));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatch("FOO", "Foo*", org.apache.commons.io.IOCase.SYSTEM));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.FilenameUtils.wildcardMatch("FOOBAR", "Foo*", org.apache.commons.io.IOCase.SYSTEM));
    }

    public void f() {
        assertArrayEquals(new java.lang.String[]{ "Ad" , "*" , "er" }, org.apache.commons.io.FilenameUtils.splitOnTokens("Ad*er"));
        assertArrayEquals(new java.lang.String[]{ "Ad" , "?" , "er" }, org.apache.commons.io.FilenameUtils.splitOnTokens("Ad?er"));
        assertArrayEquals(new java.lang.String[]{ "Test" , "*" , "?" , "One" }, org.apache.commons.io.FilenameUtils.splitOnTokens("Test*?One"));
        assertArrayEquals(new java.lang.String[]{ "Test" , "?" , "*" , "One" }, org.apache.commons.io.FilenameUtils.splitOnTokens("Test?*One"));
        assertArrayEquals(new java.lang.String[]{ "*" }, org.apache.commons.io.FilenameUtils.splitOnTokens("****"));
        assertArrayEquals(new java.lang.String[]{ "*" , "?" , "?" , "*" }, org.apache.commons.io.FilenameUtils.splitOnTokens("*??*"));
        assertArrayEquals(new java.lang.String[]{ "*" , "?" , "*" , "?" , "*" }, org.apache.commons.io.FilenameUtils.splitOnTokens("*?**?*"));
        assertArrayEquals(new java.lang.String[]{ "*" , "?" , "*" , "?" , "*" }, org.apache.commons.io.FilenameUtils.splitOnTokens("*?***?*"));
        assertArrayEquals(new java.lang.String[]{ "h" , "?" , "?" , "*" }, org.apache.commons.io.FilenameUtils.splitOnTokens("h??*"));
        assertArrayEquals(new java.lang.String[]{ "" }, org.apache.commons.io.FilenameUtils.splitOnTokens(""));
    }

    private void a(final java.lang.Object[] a1, final java.lang.Object[] a2) {
        junit.framework.TestCase.assertEquals(a1.length, a2.length);
        for (int i = 0 ; i < (a1.length) ; i++) {
            junit.framework.TestCase.assertEquals(a1[i], a2[i]);
        }
    }

    private void a(final java.lang.String text, final java.lang.String wildcard, final boolean expected) {
        junit.framework.TestCase.assertEquals(((text + " ") + wildcard), expected, org.apache.commons.io.FilenameUtils.wildcardMatch(text, wildcard));
    }

    public void c() {
        assertMatch("log.txt", "log.txt", true);
        assertMatch("log.txt1", "log.txt", false);
        assertMatch("log.txt", "log.txt*", true);
        assertMatch("log.txt", "log.txt*1", false);
        assertMatch("log.txt", "*log.txt*", true);
        assertMatch("log.txt", "*.txt", true);
        assertMatch("txt.log", "*.txt", false);
        assertMatch("config.ini", "*.ini", true);
        assertMatch("config.txt.bak", "con*.txt", false);
        assertMatch("log.txt9", "*.txt?", true);
        assertMatch("log.txt", "*.txt?", false);
        assertMatch("progtestcase.java~5~", "*test*.java~*~", true);
        assertMatch("progtestcase.java;5~", "*test*.java~*~", false);
        assertMatch("progtestcase.java~5", "*test*.java~*~", false);
        assertMatch("log.txt", "log.*", true);
        assertMatch("log.txt", "log?*", true);
        assertMatch("log.txt12", "log.txt??", true);
        assertMatch("log.log", "log**log", true);
        assertMatch("log.log", "log**", true);
        assertMatch("log.log", "log.**", true);
        assertMatch("log.log", "**.log", true);
        assertMatch("log.log", "**log", true);
        assertMatch("log.log", "log*log", true);
        assertMatch("log.log", "log*", true);
        assertMatch("log.log", "log.*", true);
        assertMatch("log.log", "*.log", true);
        assertMatch("log.log", "*log", true);
        assertMatch("log.log", "*log?", false);
        assertMatch("log.log", "*log?*", true);
        assertMatch("log.log.abc", "*log?abc", true);
        assertMatch("log.log.abc.log.abc", "*log?abc", true);
        assertMatch("log.log.abc.log.abc.d", "*log?abc?d", true);
    }

    public void g() {
        assertMatch("aaa", "aa*?", true);
        assertMatch("", "?*", false);
        assertMatch("a", "a?*", false);
        assertMatch("aa", "aa?*", false);
        assertMatch("a", "?*", true);
        assertMatch("aa", "?*", true);
        assertMatch("aaa", "?*", true);
        assertMatch("", "?", false);
        assertMatch("a", "a?", false);
        assertMatch("aa", "aa?", false);
        assertMatch("aab", "aa?", true);
        assertMatch("aaa", "*a", true);
    }

    public void a() {
        final java.util.Locale orig = java.util.Locale.getDefault();
        final java.util.Locale[] locales = java.util.Locale.getAvailableLocales();
        final java.lang.String[][] data = new java.lang.String[][]{ new java.lang.String[]{ "I" , "i" } , new java.lang.String[]{ "i" , "I" } , new java.lang.String[]{ "i" , "İ" } , new java.lang.String[]{ "i" , "ı" } , new java.lang.String[]{ "Σ" , "ς" } , new java.lang.String[]{ "Σ" , "σ" } , new java.lang.String[]{ "ς" , "σ" } };
        try {
            for (int i = 0 ; i < (data.length) ; i++) {
                for (final java.util.Locale locale : locales) {
                    java.util.Locale.setDefault(locale);
                    junit.framework.TestCase.assertTrue(("Test data corrupt: " + i), data[i][0].equalsIgnoreCase(data[i][1]));
                    final boolean match = org.apache.commons.io.FilenameUtils.wildcardMatch(data[i][0], data[i][1], org.apache.commons.io.IOCase.INSENSITIVE);
                    junit.framework.TestCase.assertTrue((((java.util.Locale.getDefault().toString()) + ": ") + i), match);
                }
            }
        } finally {
            java.util.Locale.setDefault(orig);
        }
    }
}

