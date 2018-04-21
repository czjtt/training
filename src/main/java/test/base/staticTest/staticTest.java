package test.base.staticTest;

/**
 * 1.在一个类中定义一个方法为static，那就是说，无需本类的对象即可调用此方法
 *  声明为static的方法有以下几条限制：
 · 它们仅能调用其他的static 方法。
 · 它们只能访问static数据。
 · 它们不能以任何方式引用this 或super。
 * 2.static变量有点类似于C中的全局变量的概念。
 * 3.Static 块仅在该类被加载时执行一次
 * static定义的变量会优先于任何其它非static变量，不论其出现的顺序如何。
 * 在涉及到继承的时候，会先初始化父类的static变量，然后是子类的，依次类推。
 * Created by tcc on 2017/7/6.
 */
public class staticTest {

    public static void prt(String s) {
        System.out.println(s);
    }

    Value3 v = new Value3(10);
    static Value3 v1, v2;
    static {//此即为static块
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v1 = new Value3(27);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v2 = new Value3(15);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
    }

    public static void main(String[] args) {
        staticTest ct = new staticTest();
        prt("ct.c=" + ct.v.c);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v1.inc();
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        prt("ct.c=" + ct.v.c);
    }
}

class Value3 {
    static int c = 0;
    Value3() {
        c = 15;
    }

    Value3(int i) {
        c = i;
    }

    static void inc() {
        c++;
    }
}