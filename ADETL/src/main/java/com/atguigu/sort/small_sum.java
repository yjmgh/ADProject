package com.atguigu.sort;

import java.util.Arrays;

/**
 * 求最小和问题
 * {4, 8 , 7 ,1 ,5,9,9 , 11 ,10};
 * 例如 求9之前所有比9小的值的和
 * @author Yjm
 * @create 2019-08-10 15:01
 */
public class small_sum {
    public static void main(String[] args) {
        //int[] arr = new int[]{4, 8 , 7 ,1 ,5,9,9 , 11 ,10};
        int[] arr = {1,3,4,2,5};
        int[] temp = new int[arr.length];

        int min_sum = mergeSort(arr,0,arr.length-1,temp);
        System.out.println(min_sum);
        System.out.println(Arrays.toString(arr));
    }

    public static int mergeSort(int[] arr , int left ,int right,int[] temp){
        if(arr == null || arr.length == 0) return 0;
        if(left == right) return 0;

        int mid = left + ((right - left) >> 1);
        //左边有一个最小和，右边有一个最小和，合并在一起的时候又会有一个最小和
        int min_sum = mergeSort(arr,left,mid,temp)
                + mergeSort(arr,mid + 1,right,temp)
                +merge(arr,left,mid,right,temp);
        return min_sum;

    }

    public static int merge(int[] arr , int left , int mid , int right ,int[] temp){

        int i = left;
        int j = mid + 1;
        int k = 0;
        int res = 0;
        while(i<=mid && j <= right){
          if(arr[i] < arr[j]) {
              res += (right - j + 1) * arr[i];   //必须放在前面，不然i++，就改变了
              temp[k] = arr[i];
              k++;
              i++;
          }
          if(arr[j] <= arr[i]){
              temp[k] = arr[j];
              k++;
              j++;
          }

        }

        while(i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= right){
            temp[k] = arr[j];
            k++;
            j++;
        }

        k = 0;
        int leftindex = left;
        while(leftindex <= right){
            arr[leftindex] = temp[k];
            leftindex++;
            k++;
        }

        return res;
    }

}
