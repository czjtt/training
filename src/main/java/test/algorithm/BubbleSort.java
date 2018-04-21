package test.algorithm;

/**
 * 冒泡排序
 * 冒泡排序（英语：Bubble Sort，台湾另外一种译名为：泡沫排序）是一种简单的排序算法。
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 * 冒泡排序算法的运作如下：
 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 3.针对所有的元素重复以上的步骤，除了最后一个。
 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * Created by tcc on 2017/11/17.
 */
public class BubbleSort {

    public static int[] arr = {45,68,3234,486,123,8496,15,75,68,4869,98,234,1,35,89,46,85};

    public static void bubbleSort(int[] arr) {
        int i, temp, len = arr.length;
        boolean changed;
        do {
            changed = false;
            for (i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
    }

    public static void print(int[] data){
        System.out.print("print data:");
        for(int i : data){
            System.out.print(i + ",");
        }
        System.out.println("print " + data.length + " data.");
    }

    public static void main(String[] args) {
        long s = System.nanoTime();
        BubbleSort.bubbleSort(arr);
        print(arr);
        System.out.println();
        System.out.println(System.nanoTime() - s);
    }

}
