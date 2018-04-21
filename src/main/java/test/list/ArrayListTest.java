package test.list;

import java.util.*;

/**
 * Created by czj on 2017/1/25.
 * vm args:-XX:+PrintCompilation 查看JIT编译工作  输出一些关于从字节码转化成本地代码的编译过程
 */
public class ArrayListTest {

    public static void main(String[] args){
//        slipArray();
        testDistinctLinkedHashSet();
        testDistinctHashSet();
    }

    public static void addtest() {
        long start1 = System.nanoTime();
        int a=add(1);
        long end1 = System.nanoTime();
        System.out.print("1 used:" + (end1 - start1) + ",value:" + a + "\n");

        long start2 = System.nanoTime();
        int b=add(2);
        long end2 = System.nanoTime();
        System.out.print("2 used:" + (end2 - start2) + ",value:" + b + "\n");

        long start3 = System.nanoTime();
        int c=add(3);
        long end3 = System.nanoTime();
        System.out.print("3 used:" + (end3 - start3) + ",value:" + c + "\n");

    }

    public static void testAdd(){
        Thread t = new Thread();
        try {
            t.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addtest();
    }
    private static int add(int a){
        for (int i = 0; i < 10000000; i++) {
            a+=2;
        }
        return a;
    }

    public static void slipArray(){

        int [] data = {1,2,3,4,5,6,7,8,9};
        int [] newData;
        newData = Arrays.copyOfRange(data, 2, 7);
        for(int i:newData)
            System.out.print(i+" ");

    }

    public static void testDistinctHashSet(){
        System.out.println("test distinct HashSet");
        Set<Object> alist = new HashSet<>();
        Set<Object> blist = new HashSet();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(7);
        blist.add(2);
        blist.add(3);
        blist.add(5);
        blist.add(7);
        blist.add(9);
        alist.addAll(blist);
        alist.removeAll(blist);
        for(Object a : alist){
            System.out.print(a + ",");
        }
        System.out.println();
    }

    /***
     * LinkedHashSet测试
     */
    public static void testDistinctLinkedHashSet(){
        System.out.println("test distinct LinkedHashSet");
        Set<Object> alist = new LinkedHashSet<>();
        Set<Object> blist = new LinkedHashSet();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(7);
        blist.add(2);
        blist.add(3);
        blist.add(5);
        blist.add(7);
        blist.add(9);
        alist.addAll(blist);
        alist.removeAll(blist);
        for(Object a : alist){
            System.out.print(a + ",");
        }
        System.out.println();
    }
    /**
     * 对两个list中的数据去重处理
     * @param alist
     * @param blist
     */
    public static List<Object> distinctList(List<Object> alist, List<Object> blist){
        alist.addAll(blist);
        alist = new ArrayList<>(new LinkedHashSet<>(alist));
        alist.removeAll(blist);
        return alist;
    }
}
