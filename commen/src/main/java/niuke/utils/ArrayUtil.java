package niuke.utils;

import java.util.Arrays;

/**
 * @author yuanjiameng
 * @create 2021-09-05 21:57
 * @describe
 */
public class ArrayUtil {
    // 利用java本身的东西对数组进行排序
    public static void getSortArray(int[] arr){
        Arrays.sort(arr);
    }

    // 生成一个有 <= size个数据，值在 [-value,value]的数组
    public static int[] getGenerateRandomArray(int size, int value){

        int[] arr = new int[(int)((size+1)*Math.random())];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((value + 1) * Math.random()) - (int)((value + 1) * Math.random());
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = getGenerateRandomArray(60,70);
        getSortArray(arr);
        printArray(arr);
        System.out.println();
    }

    public static void printArray(int[] arr){

        if(arr == null || arr.length < 1){
            return;
        }

        String end = " ";
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length-1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] +  end);
            }
        }
    }
}
