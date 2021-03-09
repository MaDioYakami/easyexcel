package com.example.easyexcel.sync;

import com.example.easyexcel.jvm.FinalizeTest;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TestOne {

    @Test
    public void test1() {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }

    @Test
    public void test2() throws IOException {
        FinalizeTest finalizeTest = new FinalizeTest();
        finalizeTest = null;
        System.gc();
        //System.in.read();

    }

    @Test
    public void test3() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            try {
                System.out.println("子线程执行");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(thread.getState());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());

    }

}