package test.java8.interfaceTest.FunctionalInterface;

import java.util.function.IntFunction;

/**
 * Functional接口
 * “函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 * 因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
 * 我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，
 * 你只需要给你的接口添加 @FunctionalInterface 注解，编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的。
 * Created by tcc on 2017/5/3.
 */
public class LambdaTest2 {

    public LambdaTest2(){

    }

    public static void main(String[] args) {

        IntFunction<int[]> arrayMaker = int[]::new;
        LambdaTest2 t = new LambdaTest2();
        //      也可以先创建对象
        //      Action1 a1 = ()->System.out.println("hello");

        t.test1(()->{System.out.println("hello");});

        //Action2<String,Integer> a2 = (f)->"这个数字是:"+f;
        //如果参数就一个,那么还可以这样简写 去掉小括号
        Action2<String,Integer> a2 = f->"这个数字是:"+f;
        t.test2(a2);
    }

    public void test1(Action1 a){
        a.run();
    }
    public void test2(Action2<String,Integer> a){
        System.out.println(a.run(3));
    }
}

