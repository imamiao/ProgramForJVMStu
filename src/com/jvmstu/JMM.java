package com.jvmstu;

public class JMM {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.addTo50();
            System.out.println(myNumber.number);
        }, "AA").start();

        while (myNumber.number == 10) {

        }

        System.out.println("end");
    }

}

class MyNumber {
    volatile int number = 10;

    public MyNumber() {
    }

    public void addTo50() {
        this.number = 50;
    }
}