package com.jvmstu;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.showOOMException();
    }

    public void showClassLoader() {
        // Confirming these class loaders. They are Bootstrap,Extension,Application sort by usage order.
        Main m = new Main();
        System.out.println(m.getClass().getClassLoader());// App
        System.out.println(m.getClass().getClassLoader().getParent()); // Ext
        System.out.println(m.getClass().getClassLoader().getParent().getParent()); // Bootstrap(Printing null. Because it's beyond the reach of Java. It's implemented by C++.)
    }

    public void getMemoryStates() {
        long l = Runtime.getRuntime().maxMemory();//JVM堆内存试图使用的最大内存，即-Xmx参数值
        System.out.println(l / 1024 / 1024);
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);//JVM堆内存当前使用的内存大小，即-Xms参数值
    }

    public void showOOMException() {
        // set the vm attribute：-Xms10m -Xmx10m -XX:+PrintGCDetails
        String str = "我爱喝牛奶";
        while (true) {
            str += str + new Random().nextInt(1000000) + new Random().nextInt(9999999);
        }
    }
}
