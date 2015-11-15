package org.apache.commons.io.input;


public class ClassLoaderObjectInputStreamTest extends junit.framework.TestCase {
    public ClassLoaderObjectInputStreamTest(final java.lang.String name) {
        super(name);
    }

    public void a() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        final java.lang.Object input = java.lang.Boolean.FALSE;
        oos.writeObject(input);
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final java.lang.Object result = clois.readObject();
        junit.framework.TestCase.assertEquals(input, result);
        clois.close();
    }

    public void b() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        final java.lang.Object input = ((long)(123));
        oos.writeObject(input);
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final java.lang.Object result = clois.readObject();
        junit.framework.TestCase.assertEquals(input, result);
        clois.close();
    }

    public void e() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        final long input = 12345L;
        oos.writeLong(input);
        oos.close();
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final long result = clois.readLong();
        junit.framework.TestCase.assertEquals(input, result);
        clois.close();
    }

    private static enum E {
A, B, C;    }

    private static class Test implements java.io.Serializable {
        private static final long serialVersionUID = 1L;

        private int i;

        private java.lang.Object o;

        private org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.E e;

        Test(int i ,java.lang.Object o) {
            this.i = i;
            this.e = org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.E.A;
            this.o = o;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object other) {
            if (other instanceof org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.Test) {
                org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.Test tother = ((org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.Test)(other));
                return (((this.i) == (tother.i)) & ((this.e) == (tother.e))) & (equalObject(tother.o));
            } else {
                return false;
            }
        }

        private boolean a(java.lang.Object other) {
            if ((this.o) == null) {
                return other == null;
            } 
            return o.equals(other);
        }

        @java.lang.Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public void c() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        final java.lang.Object input = new org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.Test(123 , null);
        oos.writeObject(input);
        oos.close();
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final java.lang.Object result = clois.readObject();
        junit.framework.TestCase.assertEquals(input, result);
        clois.close();
    }

    public void d() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        final java.lang.Object input = new org.apache.commons.io.input.ClassLoaderObjectInputStreamTest.Test(123 , 0);
        oos.writeObject(input);
        oos.close();
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final java.lang.Object result = clois.readObject();
        junit.framework.TestCase.assertEquals(input, result);
        clois.close();
    }

    public void f() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        oos.writeObject(java.lang.Boolean.FALSE);
        final java.io.InputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
        final org.apache.commons.io.input.ClassLoaderObjectInputStream clois = new org.apache.commons.io.input.ClassLoaderObjectInputStream(getClass().getClassLoader() , bais);
        final java.lang.String[] interfaces = new java.lang.String[]{ java.lang.Comparable.class.getName() };
        final java.lang.Class<?> result = clois.resolveProxyClass(interfaces);
        junit.framework.TestCase.assertTrue("Assignable", java.lang.Comparable.class.isAssignableFrom(result));
        clois.close();
    }
}

