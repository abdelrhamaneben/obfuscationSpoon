package org.apache.commons.io.input;


public class BoundedReaderTest {
    private final java.io.Reader sr = new java.io.BufferedReader(new java.io.StringReader("01234567890"));

    private final java.io.Reader shortReader = new java.io.BufferedReader(new java.io.StringReader("01"));

    @org.junit.Test
    public void i() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.read();
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void j() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(shortReader , 3);
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void g() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        char[] cbuf = new char[4];
        for (int i = 0 ; i < (cbuf.length) ; i++) {
            cbuf[i] = 'X';
        }
        final int read = mr.read(cbuf, 0, 4);
        org.junit.Assert.assertEquals(3, read);
        org.junit.Assert.assertEquals('0', cbuf[0]);
        org.junit.Assert.assertEquals('1', cbuf[1]);
        org.junit.Assert.assertEquals('2', cbuf[2]);
        org.junit.Assert.assertEquals('X', cbuf[3]);
        mr.close();
    }

    @org.junit.Test
    public void h() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        char[] cbuf = new char[4];
        for (int i = 0 ; i < (cbuf.length) ; i++) {
            cbuf[i] = 'X';
        }
        final int read = mr.read(cbuf, 1, 2);
        org.junit.Assert.assertEquals(2, read);
        org.junit.Assert.assertEquals('X', cbuf[0]);
        org.junit.Assert.assertEquals('0', cbuf[1]);
        org.junit.Assert.assertEquals('1', cbuf[2]);
        org.junit.Assert.assertEquals('X', cbuf[3]);
        mr.close();
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.mark(3);
        mr.read();
        mr.read();
        mr.read();
        mr.reset();
        mr.read();
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void e() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.mark(4);
        mr.read();
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.read();
        mr.mark(3);
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void c() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.mark(3);
        mr.read();
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.reset();
        mr.mark(1);
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void d() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.mark(4);
        mr.read();
        mr.read();
        mr.read();
        mr.reset();
        mr.read();
        mr.read();
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void k() throws java.io.IOException {
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.skip(2);
        mr.read();
        org.junit.Assert.assertEquals(-1, mr.read());
        mr.close();
    }

    @org.junit.Test
    public void a() throws java.io.IOException {
        final java.util.concurrent.atomic.AtomicBoolean closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        final java.io.Reader sr = new java.io.BufferedReader(new java.io.StringReader("01234567890")) {
            @java.lang.Override
            public void close() throws java.io.IOException {
                closed.set(true);
                super.close();
            }
        };
        org.apache.commons.io.input.BoundedReader mr = new org.apache.commons.io.input.BoundedReader(sr , 3);
        mr.close();
        org.junit.Assert.assertTrue(closed.get());
    }
}

