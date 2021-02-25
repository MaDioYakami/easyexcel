package com.example.easyexcel.thread;

public class RunableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("这是实现Runable接口的线程任务！");
    }
}
