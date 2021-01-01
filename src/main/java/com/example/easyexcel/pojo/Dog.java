package com.example.easyexcel.pojo;

/**
 * 用来测试lamda表达式的类
 */
public class Dog {
    private String name = "哮天犬";

    /**
     * 默认10斤狗粮
     */
    private int food = 10;

    public Dog() {
    }

    /**
     * 带参数的构造函数
     *
     * @param name
     */
    public Dog(String name) {
        this.name = name;
    }

    /**
     * 狗叫，静态方法
     *
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮 JDK
     * <p>
     * 默认会把当前实例传入到非静态方法，参数名为this，位置是第一个；
     *
     * @param num
     * @return 还剩下多少斤
     */
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }
    // 和上面的eat方法效果一模一樣
    // public int eat(Dog this, int num) {
    // System.out.println("吃了" + num + "斤狗粮");
    // this.food -= num;
    // return this.food;
    // }

    @Override
    public String toString() {
        return this.name;
    }
}
