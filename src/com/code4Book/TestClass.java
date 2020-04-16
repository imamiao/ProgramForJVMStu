package com.code4Book;

public class TestClass {
/*    private int m;

    private int inc() {
        return m + 1;
    }*/

/*    static {
        i = 0;
        System.out.println(i);
    }

    static int i = 1;*/

    /*    static class Parent {
            public static int A = 1;
            static
            {
                A = 2;
            }
        }

        static class Sub extends Parent {
            public static int B = A;
        }

        public static void main(String[] args) {
            System.out.println(Sub.B);
        }*/
    static class DeadLoopClass {
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {

                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
