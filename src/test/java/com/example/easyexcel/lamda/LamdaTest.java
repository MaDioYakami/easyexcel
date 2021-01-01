package com.example.easyexcel.lamda;


import com.example.easyexcel.pojo.Dog;
import com.example.easyexcel.pojo.Person;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LamdaTest {

    @Test
    public void testOne() {
        List<Person> items = new ArrayList<>();
        items.add(new Person("1", "小牙刷", 12));
        items.add(new Person("2", "小牙刷", 12));
        items.add(new Person("3", "小牙刷", 12));
        items.add(new Person("4", "小牙刷", 12));


        items.removeIf(ele -> ele.getId().equals("3"));

        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 2, 3, 4, 5);

        //lambda表达式 方法引用
        list.forEach(System.out::println);

        list.forEach(ele -> {
            if (ele % 2 == 0) {
                System.out.println(ele);
            }
        });
    }

    /**
     * 部分JDK提供的函数式接口使用样例
     */
    @Test
    public void testThree() {
        //断言函数接口--- 接受一个参数,返回一个布尔类型的结果
        Predicate<Integer> fun1 = i -> i > 5;
        System.out.println(fun1.test(4));

        //JDK还提供了一些带类型的函数式接口,用这些接口我们就不必再指定泛型了,如下:
        IntPredicate fun11 = i -> i == 10;
        System.out.println(fun11.test(10));

        //消费者----接受一个输入参数并且无返回结果
        Consumer fun2 = s -> System.out.println(s + " world");
        fun2.accept("hello");

        //提供者---无需输入参数, 为我们提供或返回一个参数
        Supplier<String> fun3 = () -> "hi , beijing";
        System.out.println(fun3.get());

        //Function<T,R>---输入参数类型为T,返回类型为R的函数
        Function<Integer, String> fun4 = i -> new DecimalFormat("#,###").format(i);

        //一元函数-----接受一个参数为类型T,返回值类型也为T。
        UnaryOperator<String> fun5 = s -> s.replace(",", "||");
        System.out.println(fun5.apply("嘿嘿,哈哈"));

        //BiFunction<T ,U ,R> 2个输入的函数-----输入类型为T和U,返回类型为R的函数
        BiFunction<Integer, String, Boolean> fun6 = (i, s) -> (i + s).equals("111 hello world");
        System.out.println(fun6.apply(111, " hello world"));

        //BinaryOperator<T> 二元函数----需要输入两个参数,参数类型都为T,返回类型也为T的函数
        BinaryOperator<Integer> fun7 = (s, t) -> s * t;
        System.out.println(fun7.apply(7, 8));
    }

    @Test
    public void TestThree() {
        Dog dog = new Dog();

        // 静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(dog); // 哮天犬叫了

        System.out.println("===================================");

        // 非静态方法，使用对象实例的方法引用
        // Function<Integer, Integer> function = dog::eat;
        // 由于方法的输入参数类型和输出参数类型相同,所以可以使用一元函数接口
        // UnaryOperator<Integer> function = dog::eat;
        // 当然也可以使用带类型的一元函数接口
        IntUnaryOperator function = dog::eat;
        System.out.println("剩下" + function.applyAsInt(2) + "斤"); // 吃了2斤狗粮 剩下8斤

        System.out.println("++++++++++++++++++++++++++++++++++++");

        /**
         * 大家应该知道,在非静态方法里,可以使用this关键字, 它的原理其实就是在形参里默认将当前对象传给了方法,参数名就是this
         *
         * 因此非静态方法eat还可以看成是一个有两个输入一个输出的函数BiFunction<T ,U ,R> 此时可以使用（类名::方法名）的方式进行方法引用
         * 栗子如下：
         */
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");

        System.out.println("******************************************");

        // 构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());

        // 带参数的构造函数的方法引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象：" + function2.apply("旺财"));


    }
}
