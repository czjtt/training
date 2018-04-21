package test.algorithm;

/**
 * Created by tcc on 2017/9/1.
 */
public class testMainSort {

    public static void main(String[] args) {
        testBasketAndQuickSort();
    }

    protected static void testBasketAndQuickSort(){
        int size = 50000000;
        int upperBound = 200000000;
        int lownBound = 100000000;
        boolean print = false;
//        QuickSort.testQuickSort(size, upperBound, lownBound, print);
        System.out.println();
        BasketSort.testBasketFast(size, upperBound, lownBound, print);


    }
}
