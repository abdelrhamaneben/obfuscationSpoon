package org.apache.commons.io;


public class FileSystemUtilsTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public FileSystemUtilsTestCase(final java.lang.String name) {
        super(name);
    }

    public void ab() throws java.lang.Exception {
        if ((java.io.File.separatorChar) == '/') {
            java.lang.String[] cmd = null;
            java.lang.String osName = java.lang.System.getProperty("os.name");
            osName = osName.toLowerCase(java.util.Locale.ENGLISH);
            if ((osName.contains("hp-ux")) || (osName.contains("aix"))) {
                cmd = new java.lang.String[]{ "df" , "-P" , "/" };
            } else if (((osName.contains("sunos")) || (osName.contains("sun os"))) || (osName.contains("solaris"))) {
                cmd = new java.lang.String[]{ "/usr/xpg4/bin/df" , "-P" , "/" };
            } else {
                cmd = new java.lang.String[]{ "df" , "/" };
            }
            final java.lang.Process proc = java.lang.Runtime.getRuntime().exec(cmd);
            boolean kilobyteBlock = true;
            java.io.BufferedReader r = null;
            try {
                r = new java.io.BufferedReader(new java.io.InputStreamReader(proc.getInputStream()));
                final java.lang.String line = r.readLine();
                org.junit.Assert.assertNotNull("Unexpected null line", line);
                if (line.contains("512")) {
                    kilobyteBlock = false;
                } 
            } finally {
                org.apache.commons.io.IOUtils.closeQuietly(r);
            }
            @java.lang.SuppressWarnings(value = "deprecation")
            final long free = org.apache.commons.io.FileSystemUtils.freeSpace("/");
            final long kb = org.apache.commons.io.FileSystemUtils.freeSpaceKb("/");
            if (kilobyteBlock) {
                junit.framework.TestCase.assertEquals(free, kb, 256.0);
            } else {
                junit.framework.TestCase.assertEquals((free / 2.0), kb, 256.0);
            }
        } else {
            @java.lang.SuppressWarnings(value = "deprecation")
            final long bytes = org.apache.commons.io.FileSystemUtils.freeSpace("");
            final long kb = org.apache.commons.io.FileSystemUtils.freeSpaceKb("");
            junit.framework.TestCase.assertEquals((((double)(bytes)) / 1024), kb, 256.0);
        }
    }

    public void b() throws java.lang.Exception {
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtils();
        try {
            fsu.freeSpaceOS(null, 1, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            fsu.freeSpaceOS(null, 1, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void a() throws java.lang.Exception {
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtils();
        try {
            fsu.freeSpaceOS("", -1, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalStateException ex) {
        }
        try {
            fsu.freeSpaceOS("", -1, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalStateException ex) {
        }
    }

    public void c() throws java.lang.Exception {
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtils();
        try {
            fsu.freeSpaceOS("", 0, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalStateException ex) {
        }
        try {
            fsu.freeSpaceOS("", 0, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalStateException ex) {
        }
    }

    public void e() throws java.lang.Exception {
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtils() {
            @java.lang.Override
            protected long freeSpaceWindows(final java.lang.String path, final long timeout) throws java.io.IOException {
                return 12345L;
            }
        };
        junit.framework.TestCase.assertEquals(12345L, fsu.freeSpaceOS("", 1, false, -1));
        junit.framework.TestCase.assertEquals((12345L / 1024), fsu.freeSpaceOS("", 1, true, -1));
    }

    public void d() throws java.lang.Exception {
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtils() {
            @java.lang.Override
            protected long freeSpaceUnix(final java.lang.String path, final boolean kb, final boolean posix, final long timeout) throws java.io.IOException {
                return kb ? 12345L : 54321;
            }
        };
        junit.framework.TestCase.assertEquals(54321L, fsu.freeSpaceOS("", 2, false, -1));
        junit.framework.TestCase.assertEquals(12345L, fsu.freeSpaceOS("", 2, true, -1));
    }

    public void y() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\Xxxx\n" + ("\n" + ("19/08/2005  22:43    <DIR>          .\n" + ("19/08/2005  22:43    <DIR>          ..\n" + ("11/08/2005  01:07                81 build.properties\n" + ("17/08/2005  21:44    <DIR>          Desktop\n" + ("               7 File(s)        180,260 bytes\n" + "              10 Dir(s)  41,411,551,232 bytes free")))))))));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(41411551232L, fsu.freeSpaceWindows("", -1));
    }

    public void t() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\Xxxx\n" + ("\n" + ("19/08/2005  22:43    <DIR>          .\n" + ("19/08/2005  22:43    <DIR>          ..\n" + ("11/08/2005  01:07                81 build.properties\n" + ("17/08/2005  21:44    <DIR>          Desktop\n" + ("               7 File(s)         180260 bytes\n" + "              10 Dir(s)     41411551232 bytes free")))))))));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines , "dir /a /-c ");
        junit.framework.TestCase.assertEquals(41411551232L, fsu.freeSpaceWindows("", -1));
    }

    public void x() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\Xxxx\n" + ("\n" + ("19/08/2005  22:43    <DIR>          .\n" + ("19/08/2005  22:43    <DIR>          ..\n" + ("11/08/2005  01:07                81 build.properties\n" + ("17/08/2005  21:44    <DIR>          Desktop\n" + ("               7 File(s)         180260 bytes\n" + "              10 Dir(s)     41411551232 bytes free")))))))));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines , "dir /a /-c \"C:\"");
        junit.framework.TestCase.assertEquals(41411551232L, fsu.freeSpaceWindows("C:", -1));
    }

    public void z() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\Xxxx\n" + ("\n" + ("19/08/2005  22:43    <DIR>          .\n" + ("19/08/2005  22:43    <DIR>          ..\n" + ("11/08/2005  01:07                81 build.properties\n" + ("17/08/2005  21:44    <DIR>          Desktop\n" + ("               7 File(s)         180260 bytes\n" + "              10 Dir(s)     41411551232 bytes free")))))))));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines , "dir /a /-c \"C:\\somedir\"");
        junit.framework.TestCase.assertEquals(41411551232L, fsu.freeSpaceWindows("C:\\somedir", -1));
    }

    public void aa() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\Xxxx\n" + ("\n" + ("19/08/2005  22:43    <DIR>          .\n" + ("19/08/2005  22:43    <DIR>          ..\n" + ("11/08/2005  01:07                81 build.properties\n" + ("17/08/2005  21:44    <DIR>          Desktop\n" + ("               7 File(s)         180260 bytes\n" + "              10 Dir(s)     41411551232 bytes free")))))))));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines , "dir /a /-c \"C:\\somedir\"");
        junit.framework.TestCase.assertEquals(41411551232L, fsu.freeSpaceWindows("\"C:\\somedir\"", -1));
    }

    public void u() throws java.lang.Exception {
        final java.lang.String lines = "";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceWindows("C:", -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void s() throws java.lang.Exception {
        final java.lang.String lines = "\n\n";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceWindows("C:", -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void v() throws java.lang.Exception {
        final java.lang.String lines = "BlueScreenOfDeath";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceWindows("C:", -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void w() throws java.lang.Exception {
        final java.lang.String lines = " Volume in drive C is HDD\n" + (" Volume Serial Number is XXXX-YYYY\n" + ("\n" + (" Directory of C:\\Documents and Settings\\empty" + "\n")));
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(1 , lines);
        try {
            fsu.freeSpaceWindows("C:", -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void f() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "xxx:/home/users/s     14428928  12956424   1472504  90% /home/users/s";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            fsu.freeSpaceUnix("", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            fsu.freeSpaceUnix("", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            fsu.freeSpaceUnix("", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void r() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "/dev/xxx                497944    308528    189416  62% /";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(189416L, fsu.freeSpaceUnix("/", false, false, -1));
    }

    public void n() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem  1K-blocks      Used    Avail Capacity  Mounted on\n" + "/dev/xxxxxx    128990    102902    15770    87%    /";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(15770L, fsu.freeSpaceUnix("/", false, false, -1));
    }

    public void p() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "/dev/xxx                497944    308528    189416  62% /";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(189416L, fsu.freeSpaceUnix("/", true, false, -1));
    }

    public void o() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem  1K-blocks      Used    Avail Capacity  Mounted on\n" + "/dev/xxxxxx    128990    102902    15770    87%    /";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(15770L, fsu.freeSpaceUnix("/", true, false, -1));
    }

    public void q() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem            kbytes    used   avail capacity  Mounted on\n" + "/dev/dsk/x0x0x0x0    1350955  815754  481163    63%";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(481163L, fsu.freeSpaceUnix("/dev/dsk/x0x0x0x0", true, false, -1));
    }

    public void l() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + ("xxx-yyyyyyy-zzz:/home/users/s\n" + "                      14428928  12956424   1472504  90% /home/users/s");
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(1472504L, fsu.freeSpaceUnix("/home/users/s", false, false, -1));
    }

    public void m() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + ("xxx-yyyyyyy-zzz:/home/users/s\n" + "                      14428928  12956424   1472504  90% /home/users/s");
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        junit.framework.TestCase.assertEquals(1472504L, fsu.freeSpaceUnix("/home/users/s", true, false, -1));
    }

    public void g() throws java.lang.Exception {
        final java.lang.String lines = "";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("/home/users/s", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void h() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "                      14428928  12956424       100";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("/home/users/s", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void i() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "xxx:/home/users/s     14428928  12956424   nnnnnnn  90% /home/users/s";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("/home/users/s", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void j() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "xxx:/home/users/s     14428928  12956424        -1  90% /home/users/s";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("/home/users/s", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void k() throws java.lang.Exception {
        final java.lang.String lines = "Filesystem           1K-blocks      Used Available Use% Mounted on\n" + "xxx-yyyyyyy-zzz:/home/users/s";
        final org.apache.commons.io.FileSystemUtils fsu = new org.apache.commons.io.FileSystemUtilsTestCase.MockFileSystemUtils(0 , lines);
        try {
            fsu.freeSpaceUnix("/home/users/s", false, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, false, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", false, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            fsu.freeSpaceUnix("/home/users/s", true, true, -1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    static class MockFileSystemUtils extends org.apache.commons.io.FileSystemUtils {
        private final int exitCode;

        private final byte[] bytes;

        private final java.lang.String cmd;

        public MockFileSystemUtils(final int exitCode ,final java.lang.String lines) {
            this(exitCode, lines, null);
        }

        public MockFileSystemUtils(final int exitCode ,final java.lang.String lines ,final java.lang.String cmd) {
            this.exitCode = exitCode;
            this.bytes = lines.getBytes();
            this.cmd = cmd;
        }

        @java.lang.Override
        java.lang.Process a(final java.lang.String[] params) {
            if ((cmd) != null) {
                junit.framework.TestCase.assertEquals(cmd, params[((params.length) - 1)]);
            } 
            return new java.lang.Process() {
                @java.lang.Override
                public java.io.InputStream getErrorStream() {
                    return null;
                }

                @java.lang.Override
                public java.io.InputStream getInputStream() {
                    return new java.io.ByteArrayInputStream(bytes);
                }

                @java.lang.Override
                public java.io.OutputStream getOutputStream() {
                    return null;
                }

                @java.lang.Override
                public int waitFor() throws java.lang.InterruptedException {
                    return exitCode;
                }

                @java.lang.Override
                public int exitValue() {
                    return exitCode;
                }

                @java.lang.Override
                public void destroy() {
                }
            };
        }
    }
}

