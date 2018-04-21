package test.arithmetic.math;

import java.io.IOException;
import java.util.Scanner;

/**
 * 公因数
 * Created by tcc on 2017/9/22.
 */
public class CommonFactor {

    public static void main(String[] args) throws IOException{
        CommonFactor.calcGreatestCommonFactor();
    }

    public static void calcGreatestCommonFactor(){
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入计算的最大公因数的两个数。(输入1010结束) entry a:");
            String a_str = sc.nextLine();
            if("1010".equals(a_str)){
                break;
            }
            System.out.println("entry b:");
            String b_str = sc.nextLine();
            if("1010".equals(b_str)){
                break;
            }
            int a = Integer.parseInt(a_str);
            int b = Integer.parseInt(b_str);
            System.out.println("a:" + a + ",b:" + b);
            System.out.println(CommonFactor.greatestCommonFactor(a, b));
        }
        System.out.println("end");
    }

    /**
     * 返回两个数的最大公因数
     * @param a
     * @param b
     * @return
     */
    public static int greatestCommonFactor(int a, int b){
        if(b>a){
            int t = a;
            a = b;
            b = t;
        }
        int n = a%b;
        if(n != 0){
            a = b;
            b = n;
            return greatestCommonFactor(a, b);
        }
        return b;
    }
}
