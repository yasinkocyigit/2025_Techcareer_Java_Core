package com.yasin.tutorials.javacore;

public class _19_3_ThreadExtendsMain {

    public static void main(String[] args) throws InterruptedException {

        // Thread Instance
        _19_2_ThreadExtends thread1=new _19_2_ThreadExtends(1L,"java se");
        _19_2_ThreadExtends thread2=new _19_2_ThreadExtends(2L,"java me");
        _19_2_ThreadExtends thread3=new _19_2_ThreadExtends(3L,"java ee");

        // Start
        // join: üst Thread bitmeden diğer Threadler başlamasın
        System.out.println("getName "+thread1.getName());
        System.out.println("HashCode "+thread1.hashCode());
        System.out.println("thread1 isAlive "+thread1.isAlive());
        thread1.start();
        System.out.println("thread1 isAlive "+thread1.isAlive());
        thread1.join();
        System.out.println("thread1 isAlive "+thread1.isAlive());

        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
    }
}
