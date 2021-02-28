package com.example.easyexcel.thread;

public class ThreadExtend extends Thread {
    @Override
    public void run() {
        System.out.println("这是继承Thread的run方法！");
    }
}
