package org.apache.commons.io;


public class SelectorAdapter extends java.nio.channels.Selector {
    @java.lang.Override
    public boolean isOpen() {
        return false;
    }

    @java.lang.Override
    public java.nio.channels.spi.SelectorProvider provider() {
        return null;
    }

    @java.lang.Override
    public java.util.Set<java.nio.channels.SelectionKey> keys() {
        return null;
    }

    @java.lang.Override
    public java.util.Set<java.nio.channels.SelectionKey> selectedKeys() {
        return null;
    }

    @java.lang.Override
    public int selectNow() throws java.io.IOException {
        return 0;
    }

    @java.lang.Override
    public int select(final long timeout) throws java.io.IOException {
        return 0;
    }

    @java.lang.Override
    public int select() throws java.io.IOException {
        return 0;
    }

    @java.lang.Override
    public java.nio.channels.Selector wakeup() {
        return null;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
    }
}

