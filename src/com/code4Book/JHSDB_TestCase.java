package com.code4Book;


public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();// 方法区
        ObjectHolder instanceObj = new ObjectHolder(); // 堆

        void foo() {
            ObjectHolder localObj = new ObjectHolder(); // 栈
            System.out.println("done");
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
