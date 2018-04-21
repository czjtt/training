package test.base.math;

/**
 * Created by tcc on 2017/9/1.
 */
public class RandomMath {

    /**
     * 随机生成一组integer数组
     * @param size           数组长度
     * @param upperBound    数组上限
     * @param lownBound     数组下限
     */
    public static int[] arrayInteger(final int size, final int upperBound, final int lownBound){
        int[] array = new int[size];
        for(int i = 0;i < size;i++){
            array[i] = Double.valueOf(Math.random()*(upperBound - lownBound)).intValue() + lownBound;
        }
        return array;
    }
}
