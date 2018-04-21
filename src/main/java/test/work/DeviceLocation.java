package test.work;

import test.Tools.LogMath.LogMathCalculate;
import test.Tools.NumberConversion.DoubleConversion;
import test.Tools.RadixConversion.RadixConversion;

/**
 * Created by tcc on 2017/7/12.
 */
public class DeviceLocation {

    public static void main(String[] args) {
        String a = "bc";
        printDistance(a);
        a="be";
        printDistance(a);
        a="bd";
        printDistance(a);

    }

    public static void printDistance(String rssi){
        DeviceLocation dl = new DeviceLocation();
        System.out.println(RadixConversion.DecConvByHex(rssi));
        System.out.println(dl.testRssiLogMath(rssi));
    }

    /**
     * rssi数据计算距离
     * 计算公式：rssi = A - 10*n*log(d) --> d = 10^((A- rssi)/(10n))
     * 默认值：A:212,n:1.5～2.5
     * A：1米处rssi值，rssi：信号值，n：路径损耗系数(1.5～2.5)，d：距离
     * @param rssi
     * @return
     */
    public String testRssiLogMath(String rssi){
        RadixConversion nbc = new RadixConversion();
        int r = nbc.DecConvByHex(rssi);
        double min = ((LogMathCalculate.FINAL_A - r)/(10*LogMathCalculate.FINAL_MIN_N));
        double max = ((LogMathCalculate.FINAL_A - r)/(10*LogMathCalculate.FINAL_MAX_N));
        double max_result = DoubleConversion.formateDouble(Math.pow(10,min), 2);
        double min_result = DoubleConversion.formateDouble(Math.pow(10,max), 2);
        LogMathCalculate.Distance distance = LogMathCalculate.initDistance(LogMathCalculate.FINAL_MAX_N, LogMathCalculate.FINAL_MIN_N, min_result, max_result);
        return distance.toString();
    }
}
