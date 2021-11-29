package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-08-02 22:33
 */
public class InsertSort {
    public static void main(String[] args) {

        int[]  arr = new int[]{45,4,4,56,7,89,12,3};
        InsertS(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertS(int[] arr){
       int insertVal = 0;
       int insertIndex = 0;

       for(int i = 1 ; i < arr.length  ;i++){
           insertVal = arr[i];
           insertIndex = i - 1;
           while(insertIndex >= 0 && arr[insertIndex] > insertVal){
               arr[insertIndex + 1] = arr[insertIndex];
               insertIndex--;
           }

               arr[insertIndex +1] = insertVal;


       }


    }
}
