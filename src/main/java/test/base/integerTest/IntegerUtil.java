package test.base.integerTest;

/**
 * Created by tcc on 2017/9/1.
 */
public class IntegerUtil {

    public static int maxValue(int data[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i< data.length;i++){
            max = max > data[i] ? max : data[i];
        }
        return max;
    }

    public static int minValue(int data[]){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < data.length;i++){
            min = min < data[i] ? min : data[i];
        }
        return min;
    }
}
