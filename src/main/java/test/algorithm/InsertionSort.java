package test.algorithm;

/**
 * 插入排序
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。 插入排序是稳定的。
 * 时间复杂度：O（n^2）.
 * Created by tcc on 2017/12/18.
 */
public class InsertionSort {

    public static void insertsort(int arr[]){
        for(int i = 1;i < arr.length; i ++){
            if(arr[i] < arr[i-1]){//注意[0,i-1]都是有序的。如果待插入元素比arr[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
                int temp = arr[i];
                int j;
                for(j = i-1; j >= 0 && arr[j] > temp; j --){
                    arr[j+1] = arr[j];//把比temp大或相等的元素全部往后移动一个位置
                }
                arr[j+1] = temp;//把待排序的元素temp插入腾出位置的(j+1)
            }
        }

    }

    public static void main(String[] args) {
        int array[] = {3,1,5,7,2,4,9,6};

        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }

        insertsort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }


}
