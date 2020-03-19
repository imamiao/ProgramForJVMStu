package com.jvmstu;

/**
 * 引用计数GC
 */
public class RefCountGC {
    private byte[] bigSize = new byte[2 * 1024 * 1024];
    Object instance = null;

    public static void main(String[] args) {
        RefCountGC obA = new RefCountGC();
        RefCountGC obB = new RefCountGC();

        obA.instance = obB;
        obB.instance = obA;

        obA = null;
        obB = null;

        //System.gc();
    }
}
