package com.code4Book;

public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC obA = new ReferenceCountingGC();
        ReferenceCountingGC obB = new ReferenceCountingGC();

        obA.instance = obB;
        obB.instance = obA;

        obA = null;
        obB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();

    }
}
