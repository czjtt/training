package test.jdk;

/**
 * ==   比较两个对象的引用(地址值)
 * equal    值相等
 *
 * equal    必须是对象进行比较
 *
 * Created by tcc on 2017/12/4.
 */
public class equal {

    public static void main(String[] args) {
        equalTest();
    }

    public static void equalTest(){

        if('0' == 0){
            System.out.println("two equal");
        }

        if("0".equals(0)){
            System.out.println("equal");
        }

    }
}
