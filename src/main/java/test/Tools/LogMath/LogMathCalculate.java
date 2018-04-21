package test.Tools.LogMath;

import test.Tools.NumberConversion.DoubleConversion;
import test.Tools.RadixConversion.RadixConversion;

/**
 * log函数Math计算
 * Created by tcc on 2017/7/11.
 */
public class LogMathCalculate {

    public static final int FINAL_A = 212;
    public static final double FINAL_MIN_N = 1.5;
    public static final double FINAL_MAX_N = 2.5;

//    public static void main(String[] args) {
//        LogMathCalculate lmc = new LogMathCalculate();
//        System.out.println(lmc.testRssiLogMath("cc"));
//    }

    /**
     * rssi数据计算距离
     * @param rssi
     * @return
     */
    public Distance testRssiLogMath(String rssi){
        RadixConversion nbc = new RadixConversion();
        int r = nbc.DecConvByHex(rssi);
        double min = ((FINAL_A - r)/(10*FINAL_MIN_N));
        double max = ((FINAL_A - r)/(10*FINAL_MAX_N));
        double max_result = DoubleConversion.formateDouble(Math.pow(10,min), 2);
        double min_result = DoubleConversion.formateDouble(Math.pow(10,max), 2);
        return new Distance(FINAL_MAX_N, FINAL_MIN_N, min_result, max_result);
    }

    /**
     * 初始化
     * @param min_n
     * @param max_n
     * @param min_distance
     * @param max_distance
     */
    public static Distance initDistance(double min_n, double max_n, double min_distance, double max_distance){
        Distance distance = new Distance(min_n,max_n,min_distance,max_distance);
        return distance;
    }

    public static class Distance{
        private double min_n;
        private double max_n;
        private double min_distance;
        private double max_distance;

        public Distance() {
        }

        public Distance(double min_n, double max_n, double min_distance, double max_distance) {
            this.min_n = min_n;
            this.max_n = max_n;
            this.min_distance = min_distance;
            this.max_distance = max_distance;
        }

        @Override
        public String toString() {
            return "Distance{min_n=" + min_n + ":min_distance=" + min_distance +
                    ", max_n=" + max_n + ":max_distance=" + max_distance +
                    '}';
        }

        public double getMin_distance() {
            return min_distance;
        }

        public void setMin_distance(double min_distance) {
            this.min_distance = min_distance;
        }

        public double getMax_distance() {
            return max_distance;
        }

        public void setMax_distance(double max_distance) {
            this.max_distance = max_distance;
        }
    }

    public static double DecLogMath(long d){
        return Math.log10(d);
    }

    public static double log(double value, double base){
        return Math.log(value)/Math.log(base);
    }
}
