package com.code4Book;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = null;
        try {
            obj = myLoader.loadClass("com.code4Book.ClassLoaderTest").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert obj != null;
        System.out.println(obj.getClass());
        Object obj1 = new ClassLoaderTest();
        System.out.println("obj:" + (obj instanceof com.code4Book.ClassLoaderTest));
        System.out.println("obj1:" +(obj1 instanceof com.code4Book.ClassLoaderTest));
    }
}
