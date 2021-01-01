package com.example.easyexcel.lamda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    /**
     * a.forEach
     * <p>
     * 迭代集合中元素。接收一个 Lambda 表达式
     * <p>
     * 然后在 Stream 的每一个元素上执行该表达式
     * <p>
     * 此操作是及早求值方法
     * <p>
     * b.collect(toList())
     * <p>
     * 由Stream 里的值生成一个列表，是一个及早求值操作
     * <p>
     * 很多Stream 操作都是惰性求值，因此调用Stream 一系列方法之后
     * <p>
     * 还需最后再调用一个类似collect 的及早求值方法返回集合
     * <p>
     * 开篇的例子：(再将符合要求的字符串放到一个新的集合里)
     * <p>
     * 使用filter过滤器：遍历数据并检查其中的元素
     */
    @Test
    public void testList() {
        // 创建集合
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("sdf");
        list.add("a");
        list.add("asdf");
        list.add("d");
        list.add("basdfgh");

        // 统计长度大于2的
        long count = list.stream().filter((s) -> s.length() > 2).count();

        // 将符合要求的放入集合
        List<String> list2 = list.stream().filter((s) -> s.length() > 2).collect(Collectors.toList());

        System.out.println(count);
        list2.forEach(System.out::println);
    }

    /**
     * 如果有一个函数可以将一种类型的值转换成另外一种类型
     * <p>
     * map 操作就可以使用该函数，将一个流中的值转换成一个新的流
     * <p>
     * 需求：将字符串全转换成大写
     */
    @Test
    public void testMap() {
        // 创建集合
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("sdf");
        list.add("a");
        list.add("asdf");
        list.add("d");
        list.add("basdfgh");

        // 转换为大写
        List<String> list2 = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());

        list2.forEach(System.out::println);
    }

    /**
     * 遍历数据并检查其中的元素。例如获取字符串List中以数字开始的字符集合
     */
    @Test
    public void testFilter() {
        // 创建集合
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("1sdf");
        list.add("a");
        list.add("2asdf");
        list.add("d");
        list.add("basdfgh");

        // 获取数字开头的
        List<String> list2 = list.stream().filter((s) -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());

        list2.forEach(System.out::println);

    }

    /**
     * 可用Stream 替换值， 然后将多个Stream 连接成一个Stream
     * <p>
     * map 操作可用一个新的值代替Stream 中的值
     * <p>
     * 若用户希望让map操作有点变化
     * <p>
     * 生成一个新的Stream 对象取而代之则flatMap适用
     * <p>
     * 假设有一个包含多个列表的流，现在希望得到所有数字的序列
     */
    @Test
    public void testFlatMap() {
        Stream<?> flatMap = Stream.of(Arrays.asList("a", "b"), Arrays.asList(1, 2, 3)).flatMap((s) -> s.stream());
        flatMap.forEach(System.out::println);


    }

    /**
     * 获取Stream中最大值或最小值，获取字符串List中长度最长的字符串长度
     */
    @Test
    public void testMaxAndMin() {
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("ab");
        list.add("abcd");
        list.add("abcde");

        // 获取最大值
        int max = list.stream().map((s) -> s.length()).max(Integer::compareTo).get();
        System.out.println(max);

        // 获取最小值，另一种方法
        int min = list.stream().min(Comparator.comparing((s) -> s.length())).get().length();
        System.out.println(min);
    }

    /**
     * 通过指定的函数把stream中的多个元素汇聚为一个元素，min max等是它的特例
     * 格式：reduce(初始值，(r, i) -> r + i) 或者 reduce((r, i) -> r + "*" i)
     * 计算1~100的和
     */
    @Test
    public void reduce() {
        List<Long> list = new ArrayList<>();

        // 封装到集合
        for (long i = 1; i <= 100; i++) {
            list.add(i);
        }

        // 计算
        // reduce：参1，和的初始值
        Long sum = list.stream().parallel().reduce(0L, (r, l) -> r + l);

        System.out.println(sum);
    }
}
