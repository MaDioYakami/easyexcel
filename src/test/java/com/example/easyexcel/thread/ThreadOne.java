package com.example.easyexcel.thread;

import org.junit.Test;

public class ThreadOne {


    @Test
    public void testOne() {
        MyThread myThread1 = new MyThread();
        myThread1.start();

    }

    @Test
    public void testTwo() {
        RunableThread runableThread = new RunableThread();
        Thread thread = new Thread(runableThread);
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("name1");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();


    }
}
