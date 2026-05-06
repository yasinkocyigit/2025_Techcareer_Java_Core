package com.yasin.tutorials.javacore;

// Thread Extends
public class _19_1_ThreadExamples extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Extends");
    }
}

// Thread Implements
class ThreadImplements implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Implements");
    }
}

@SuppressWarnings("unused")
// Thread Implements
class ThreadMainImplements {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Main Implements");
            }
        });
    }
}
