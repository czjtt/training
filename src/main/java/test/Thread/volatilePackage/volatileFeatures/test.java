package test.Thread.volatilePackage.volatileFeatures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by tcc on 2017/6/15.
 * 锁提供了两种主要特性：互斥（mutual exclusion）和可见性（visibility）。
 * Volatile变量具有 synchronized 的可见性特性，但是不具备原子特性。
 * 您只能在有限的一些情形下使用 volatile变量替代锁。要使 volatile变量提供理想的线程安全，必须同时满足下面两个条件：
 * ● 对变量的写操作不依赖于当前值。
 * ● 该变量没有包含在具有其他变量的不变式中。
 */
public class test {

    volatile int value = 0;

    public static void main(String[] args) {
        test t = new test();
//        System.out.println(t.AtomicIntegerObj());
//        System.out.println(t.LongAdderObj());
//        System.out.println(new AtomicInteger());
//        System.out.println(new AtomicLong());

        for(int i=0;i<100;i++){
            Thread t1 = new Thread();

            t1.run();
        }
    }





//    清单 6. 结合使用 volatile 和 synchronized 实现 “开销较低的读－写锁”
//    您可以在读操作中使用 volatile 确保当前值的可见性，因此可以使用锁进行所有变化的操作，使用 volatile 进行只读操作
    public int getValue(){
        return value;
    }

    public synchronized int increment(){
        return value++;
    }

    public AtomicInteger AtomicIntegerObj(){
        AtomicInteger count = new AtomicInteger();
        count.addAndGet(1);
        return count;
    }

    public LongAdder LongAdderObj(){
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        return longAdder;
    }
}
