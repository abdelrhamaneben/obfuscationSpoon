package org.apache.commons.io;


class Java7Support {
    private static final boolean IS_JAVA7;

    private static java.lang.reflect.Method isSymbolicLink;

    private static java.lang.reflect.Method delete;

    private static java.lang.reflect.Method toPath;

    private static java.lang.reflect.Method exists;

    private static java.lang.reflect.Method toFile;

    private static java.lang.reflect.Method readSymlink;

    private static java.lang.reflect.Method createSymlink;

    private static java.lang.Object emptyLinkOpts;

    private static java.lang.Object emptyFileAttributes;

    static {
        boolean isJava7x = true;
        try {
            java.lang.ClassLoader cl = java.lang.Thread.currentThread().getContextClassLoader();
            java.lang.Class<?> files = cl.loadClass("java.nio.file.Files");
            java.lang.Class<?> path = cl.loadClass("java.nio.file.Path");
            java.lang.Class<?> fa = cl.loadClass("java.nio.file.attribute.FileAttribute");
            java.lang.Class<?> linkOption = cl.loadClass("java.nio.file.LinkOption");
            org.apache.commons.io.Java7Support.isSymbolicLink = files.getMethod("isSymbolicLink", path);
            org.apache.commons.io.Java7Support.delete = files.getMethod("delete", path);
            org.apache.commons.io.Java7Support.readSymlink = files.getMethod("readSymbolicLink", path);
            org.apache.commons.io.Java7Support.emptyFileAttributes = java.lang.reflect.Array.newInstance(fa, 0);
            org.apache.commons.io.Java7Support.createSymlink = files.getMethod("createSymbolicLink", path, path, org.apache.commons.io.Java7Support.emptyFileAttributes.getClass());
            org.apache.commons.io.Java7Support.emptyLinkOpts = java.lang.reflect.Array.newInstance(linkOption, 0);
            org.apache.commons.io.Java7Support.exists = files.getMethod("exists", path, org.apache.commons.io.Java7Support.emptyLinkOpts.getClass());
            org.apache.commons.io.Java7Support.toPath = java.io.File.class.getMethod("toPath");
            org.apache.commons.io.Java7Support.toFile = path.getMethod("toFile");
        } catch (java.lang.ClassNotFoundException e) {
            isJava7x = false;
        } catch (java.lang.NoSuchMethodException e) {
            isJava7x = false;
        }
        IS_JAVA7 = isJava7x;
    }

    public static boolean b(java.io.File file) {
        try {
            java.lang.Object path = org.apache.commons.io.Java7Support.toPath.invoke(file);
            java.lang.Boolean result = ((java.lang.Boolean)(org.apache.commons.io.Java7Support.isSymbolicLink.invoke(null, path)));
            return result.booleanValue();
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.io.File c(java.io.File symlink) throws java.io.IOException {
        try {
            java.lang.Object path = org.apache.commons.io.Java7Support.toPath.invoke(symlink);
            java.lang.Object resultPath = org.apache.commons.io.Java7Support.readSymlink.invoke(null, path);
            return ((java.io.File)(org.apache.commons.io.Java7Support.toFile.invoke(resultPath)));
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private static boolean a(java.io.File file) throws java.io.IOException {
        try {
            java.lang.Object path = org.apache.commons.io.Java7Support.toPath.invoke(file);
            final java.lang.Boolean result = ((java.lang.Boolean)(org.apache.commons.io.Java7Support.exists.invoke(null, path, org.apache.commons.io.Java7Support.emptyLinkOpts)));
            return result.booleanValue();
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw ((java.lang.RuntimeException)(e.getTargetException()));
        }
    }

    public static java.io.File a(java.io.File symlink, java.io.File target) throws java.io.IOException {
        try {
            if (!(org.apache.commons.io.Java7Support.exists(symlink))) {
                java.lang.Object link = org.apache.commons.io.Java7Support.toPath.invoke(symlink);
                java.lang.Object path = org.apache.commons.io.Java7Support.createSymlink.invoke(null, link, org.apache.commons.io.Java7Support.toPath.invoke(target), org.apache.commons.io.Java7Support.emptyFileAttributes);
                return ((java.io.File)(org.apache.commons.io.Java7Support.toFile.invoke(path)));
            } 
            return symlink;
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            final java.lang.Throwable targetException = e.getTargetException();
            throw ((java.io.IOException)(targetException));
        }
    }

    public static void d(java.io.File file) throws java.io.IOException {
        try {
            java.lang.Object path = org.apache.commons.io.Java7Support.toPath.invoke(file);
            org.apache.commons.io.Java7Support.delete.invoke(null, path);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw ((java.io.IOException)(e.getTargetException()));
        }
    }

    public static boolean a() {
        return IS_JAVA7;
    }
}

