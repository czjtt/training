package test.java8;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tcc on 2017/4/26.
 */
public class GrammarTest {

    public String testName = "test";

    public static void main(String[] args){
        GrammarTest grammarTest = new GrammarTest();
//        grammarTest.test();
//        grammarTest.sort();
//        grammarTest.sortJoin();
//        grammarTest.sortEfficiencyComparison();
//        grammarTest.swing();
//        grammarTest.testName = "ddddd";
//        grammarTest.swing();
//        grammarTest.ThreadLocal();
        grammarTest.typeRule();

    }

    public void test(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).map((x) -> {
            return x * x;
        }).forEach(System.out::println);
    }

    public void sort(){
        System.out.println("sort list.");
        List<Integer> sortLists = new ArrayList<>();
        sortLists.add(1);
        sortLists.add(4);
        sortLists.add(6);
        sortLists.add(3);
        sortLists.add(2);
        sortLists.forEach(e->System.out.print(","+e));
        List<Integer> afterSortLists = sortLists.stream().sorted((In1,In2)->
                In1-In2).collect(Collectors.toList());
//        Collections.sort(sortLists, Comparator.comparing().thenComparing().);
        System.out.println();
        System.out.println("after sort:");
        afterSortLists.stream().forEach(e->System.out.print(","+e));
//        String join = afterSortLists.stream().map((x)->String.valueOf(x)).collect(Collectors.joining(","));
    }

    /**
     *
     */
    public void sortJoin(){
        System.out.println("sort list.");
        List<String> sortLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sortLists.add("" + (int)Math.random()*10000);
        }
        Collections.sort(sortLists,(a, b) -> b.compareTo(a));
        System.out.println("after Collections.sort :" + sortLists.stream().collect(Collectors.joining(",")));
        Arrays.parallelSort(sortLists.toArray(),(str1,str2)->(str1.toString().length()-str2.toString().length()));
        System.out.println("after Arrays.parallelSort :" + sortLists.stream().collect(Collectors.joining(",")));
        String s = sortLists.stream().sorted((In1,In2)->(In1.toString().length()-In2.toString().length())).collect(Collectors.joining(","));
        System.out.println("after sort:" + s);
        Arrays.sort(sortLists.toArray());
    }

    /**
     * 排序的时间比较 10000000 量
     * Collections.sort used time:20ms
     * Arrays.sort used time:39
     * Arrays.parallelSort used time:225ms
     */
    public void sortEfficiencyComparison(){
        System.out.println("sort list.");
        List<Integer> sortLists = new ArrayList<>();
        Integer[] intlist = new Integer[0];
        long time = 0L;
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            sortLists.add((int)Math.random()*size);
        }
        System.out.println("capcity:" + size);

        time = System.currentTimeMillis();
        Collections.sort(sortLists);
        System.out.println("Collections.sort used time:" + (System.currentTimeMillis() - time) );

        time = System.currentTimeMillis();
        Arrays.sort(sortLists.toArray());
        System.out.println("Arrays.sort used time:" + (System.currentTimeMillis() - time) );

                time = System.currentTimeMillis();
        Arrays.parallelSort(sortLists.toArray(intlist));
        System.out.println("Arrays.parallelSort used time:" + (System.currentTimeMillis() - time) );
    }

    public void swing(){
        String name = "232323";
        Button button = new Button();
        button.addActionListener(event->{System.out.print("name:" + name);});
        button.addActionListener(event-> System.out.println("testname:" + testName));
    }

    public void ThreadLocal(){
        ThreadLocal<Integer> t = ThreadLocal.withInitial(()->1);
        ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
        System.out.println("!");
    }

    /**
     * 类型推断规则
     */
    public void typeRule(){
        // 1.
        Runnable helloWorld = ()-> System.out.println("hello world!");
        helloWorld.run();
        // 2.
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
        button.getActionListeners();
        // 3.


    }

}
