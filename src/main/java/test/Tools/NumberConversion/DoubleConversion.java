package test.Tools.NumberConversion;

import test.Tools.FinalStaticConstant;

/**
 * double转换工具
 * Created by tcc on 2017/7/11.
 */
public class DoubleConversion {

    /**
     * 对d保留两个小数点
     * @param d
     * @return
     */
    public static double formateTwoPointDouble(double d){
        return (double)Math.round(d * 100) / 100;
    }

    /**
     * 数值格式转换，对d保留radix个小数点
     * @param d
     * @param radix
     * @return
     * @throws NumberFormatException
     */
    public static double formateDouble(double d, int radix) throws NumberFormatException{
        if(radix<0){
            throw new NumberFormatException("radix can not be less than zero.");
        }
        int a = (int) Math.pow(FinalStaticConstant.TEN, radix);
        return (double)Math.round(d*a)/a;
    }
}
