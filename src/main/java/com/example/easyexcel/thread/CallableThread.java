package com.example.easyexcel.thread;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("这是实现Callable接口的多线程call方法");
        return 1;
    }
}
