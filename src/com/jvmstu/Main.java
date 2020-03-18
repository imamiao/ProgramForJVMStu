package com.jvmstu;

public class Main {
    public static void main(String[] args) {
        // Confirming these class loaders. They are Bootstrap,Extension,Application sort by usage order.
        Main m = new Main();
        System.out.println(m.getClass().getClassLoader());// App
        System.out.println(m.getClass().getClassLoader().getParent()); // Ext
        System.out.println(m.getClass().getClassLoader().getParent().getParent()); // Bootstrap(Printing null. Because it's beyond the reach of Java. It's implemented by C++.)
    }
}
