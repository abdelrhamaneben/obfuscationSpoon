package org.apache.commons.io.input;


public class ClassLoaderObjectInputStream extends java.io.ObjectInputStream {
    private final java.lang.ClassLoader classLoader;

    public ClassLoaderObjectInputStream(final java.lang.ClassLoader classLoader ,final java.io.InputStream inputStream) throws java.io.IOException , java.io.StreamCorruptedException {
        super(inputStream);
        this.classLoader = classLoader;
    }

    @java.lang.Override
    protected java.lang.Class<?> resolveClass(final java.io.ObjectStreamClass objectStreamClass) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            return java.lang.Class.forName(objectStreamClass.getName(), false, classLoader);
        } catch (java.lang.ClassNotFoundException cnfe) {
            return super.resolveClass(objectStreamClass);
        }
    }

    @java.lang.Override
    protected java.lang.Class<?> resolveProxyClass(final java.lang.String[] interfaces) throws java.io.IOException, java.lang.ClassNotFoundException {
        final java.lang.Class<?>[] interfaceClasses = new java.lang.Class[interfaces.length];
        for (int i = 0 ; i < (interfaces.length) ; i++) {
            interfaceClasses[i] = java.lang.Class.forName(interfaces[i], false, classLoader);
        }
        try {
            return java.lang.reflect.Proxy.getProxyClass(classLoader, interfaceClasses);
        } catch (final java.lang.IllegalArgumentException e) {
            return super.resolveProxyClass(interfaces);
        }
    }
}

