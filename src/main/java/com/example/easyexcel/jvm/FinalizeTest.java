package com.example.easyexcel.jvm;

public class FinalizeTest {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行了finalize垃圾回收！");
    }
}
