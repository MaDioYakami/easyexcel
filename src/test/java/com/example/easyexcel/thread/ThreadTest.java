package com.example.easyexcel.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class ThreadTest {

    @Test
    public void testOne() {
        ThreadExtend threadOne = new ThreadExtend();
        threadOne.start();
        new Thread(()->{
            System.out.println("这是lamda表达式的线程");
        }).start();
    }

    @Test
    public void testTwo() {
        RunnableThread two = new RunnableThread();
        Thread thread = new Thread(two);
        thread.start();

    }

    @Test
    public void testThree() {
        CallableThread ctt = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
