package com.code4Book;

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        RuntimeConstantPoolOOM r = new RuntimeConstantPoolOOM();
        //r.test();
        r.test1();
    }

    public void test() {
        Set<String> set = new HashSet<>();
        short i = 0;
        try {
            while (true) {
                set.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("i:" + i);
            throw e;
        }
    }

    // todo 如何才会使一个字符串进入常量池中?
    public void test1() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true?
        String str666 = new String("计算机软件");
        System.out.println(str1.intern() == str666);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // true?

        String str3 = "计算机软件";
        System.out.println(str1 == str3); // true?
        System.out.println(str1.intern() == str3); // true?
    }
}
