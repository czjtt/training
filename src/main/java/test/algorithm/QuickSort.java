package test.algorithm;

import test.base.math.RandomMath;

/**
 * 快速排序
 *
 * 又称划分交换排序（partition-exchange sort），一种排序算法，最早由东尼·霍尔提出。
 * 在平均状况下，排序 n个项目要 O(nlog n)（大O符号）次比较。
 * 在最坏状况下则需要 O(n^{2})次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他 O(n log n)算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 * Created by tcc on 2017/9/1.
 */
public class QuickSort {
    public static void main(String[] args) {
        testQuickSort();
    }



    protected static void testQuickSort(){
        testQuickSort(17, 10000, 100, true);
    }
    protected static void testQuickSort(int size, int upperBound, int lownBound, boolean print){
//        int[] toSortData = {1,3,2,56,3,2,5,78,3,2,4,5,67,7,47,8,9,4,20};

        int[] toSortData = RandomMath.arrayInteger(size, upperBound, lownBound);
        System.out.println("排序前:");
        for (int i = 0; i < toSortData.length; i++) {
            System.out.print(toSortData[i] + ",");
        }
        System.out.println();
        System.out.println("排序后:");

        long millesTime = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        quickSort(toSortData, 0, toSortData.length - 1);
        millesTime = System.currentTimeMillis() - millesTime;
        nanoTime = System.nanoTime() - nanoTime;
        System.out.println("quicksort data length: " + toSortData.length + ",used time Millis time:" + millesTime + " ,nano time:" + nanoTime);

        if(print) {
            for (int i = 0; i < toSortData.length; i++) {
                System.out.print(toSortData[i] + ",");
            }
        }
    }

    /**
     *
     * @param numbers   待排序数组
     * @param start     开始排序的位置
     * @param end       结束排序的位置
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }
}
