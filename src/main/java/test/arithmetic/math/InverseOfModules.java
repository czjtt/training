package test.arithmetic.math;

import java.util.Scanner;

/**
 * 模反元素
 * 如果两个正整数a和n互质，那么一定有整数b,使ab-1被n整除，或ab被n除的余数为1，这时，b就是a的模反元素。b+nk都是a的模反元素。
 * 互质概念：公因数只有一个1的两个非零自然数。
 * 1. 任意两个质数构成互质关系，比如13和61。
 * 2. 一个数是质数，另一个数只要不是前者的倍数，两者就构成互质关系，比如3和10。
 * 3. 如果两个数之中，较大的那个数是质数，则两者构成互质关系，比如97和57。
 * 4. 1和任意一个自然数是都是互质关系，比如1和99。
 * 5. p是大于1的整数，则p和p-1构成互质关系，比如57和56。
 * 6. p是大于1的奇数，则p和p-2构成互质关系，比如17和15。
 * Created by tcc on 2017/9/22.
 */
public class InverseOfModules {

    public static void main(String[] args) {
        InverseOfModules.calcWhetherInverseOfModules();

    }

    public static void calcWhetherInverseOfModules(){
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入计算的模反元素b是a的模反元素。(输入1010结束) entry b:");
            String b_str = sc.nextLine();
            if("1010".equals(b_str)){
                break;
            }
            System.out.println("entry a:");
            String a_str = sc.nextLine();
            if("1010".equals(a_str)){
                break;
            }
            int a = Integer.parseInt(a_str);
            int b = Integer.parseInt(b_str);
            System.out.println("a:" + a + ",b:" + b + ",n:" + (a*b - 1));
            if(InverseOfModules.whetherInverseOfModules(b, a)){
                System.out.println(b + "是" + a + "的模反元素。");
            }else {
                System.out.println(b + "不是" + a + "的模反元素。");
            }
        }
        System.out.println("end");
    }

    /**
     * b是否是a的模反元素
     * @param b
     * @param a
     * @return
     */
    public static boolean whetherInverseOfModules(int b, int a){
        if(a > 0 && b > 0 && a*b-1 > 0){
            // a 与 a*b-1 是否互质
            if(CommonFactor.greatestCommonFactor(a, a*b - 1) == 1){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
