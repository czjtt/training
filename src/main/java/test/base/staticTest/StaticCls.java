package test.base.staticTest;

/**
 * 通常一个普通类不允许声明为静态的，只有一个内部类才可以。
 * 这时这个声明为静态的内部类可以直接作为一个普通类来使用，而不需实例一个外部类。
 *
 * 用static修饰的代码块表示静态代码块，当Java虚拟机（JVM）加载类时，就会执行该代码块（用处非常大，呵呵）。
 * Created by tcc on 2017/7/6.
 */

public class StaticCls {

    public static void main(String[] args) {
        StaticCls.testInnerStaticCls();
        StaticCls.testInnerCls();
    }

    public static void testInnerStaticCls(){
        OuterCls.InnerStaticCls oi = new OuterCls.InnerStaticCls();
    }

    public static void testInnerCls(){
        OuterCls oc = new OuterCls();
        OuterCls.InnerCls is = oc.new InnerCls();
        is.display();
    }
}

/**
 * 这是因为在创建外部类时，内部类会自动捕获一个外部类的引用，所以内部类访问外部类元素，实际上是通过他所持有外部类引用访问的
 */
class OuterCls {

    private String outerName;
    private int outerAge;

    public OuterCls(){
        System.out.println("OuterCls Constructor");
    }

    public static class InnerStaticCls {
        InnerStaticCls() {
            System.out.println("InnerStaticCls Constructor");
        }
    }

    public class InnerCls{
        InnerCls(){
            // 内部类访问外部类的元素
            outerAge = 21;
            outerName = "outerName";
            System.out.println("InnerCls");
        }

        //获取外部类的引用
        public OuterCls getOutCls(){
            return OuterCls.this;
        }

        public void display(){
            System.out.println("outerName:" + outerName + ",outerAge:" + outerAge);
        }
    }
}
