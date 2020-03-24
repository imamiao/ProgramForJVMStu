package com.code4Book;

public class GCTest {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] al1, al2, al3, al4;
        al1 = new byte[2 * _1MB];
        al2 = new byte[2 * _1MB];
        al3 = new byte[2 * _1MB];

        al4 = new byte[5 * _1MB];
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[6 * _1MB];
    }

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
