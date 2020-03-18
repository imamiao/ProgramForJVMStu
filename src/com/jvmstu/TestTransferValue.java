package com.jvmstu;

public class TestTransferValue {
    public void changeValue1(int age) {
        age = 30;
        System.out.println("in --- " + age);// 30
    }

    public void changeValue2(Person person) {
        person.setPersonName("xxx");
        System.out.println("in --- " + person.getPersonName());// xxx
    }

    public void changeValue3(String str) {
        str = "xxx";
        System.out.println("in --- " + str);// xxx
    }

    public static void main(String[] args) {
        TestTransferValue ttf = new TestTransferValue();
        int age = 20;
        ttf.changeValue1(age);
        System.out.println("out --- " + age);// 20
        Person iii = new Person("iii");
        ttf.changeValue2(iii);
        System.out.println("out --- " + iii.getPersonName());// xxx
        String ttt = "ttt";
        ttf.changeValue3(ttt);
        System.out.println("out --- " + ttt);// ttt
    }
}
