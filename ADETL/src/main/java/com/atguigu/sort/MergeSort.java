package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-08-02 21:16
 */
//归并排序
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[]{4, 8 , 7 ,1 ,5,9,9 , 11 ,10};
        int[] temp = new int[arr.length];
        MergeS(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void MergeS(int[] arr , int left, int right,int[] temp){

        if(left < right){
            int mid = (left + right)/2;
            MergeS(arr ,left , mid ,temp);
            MergeS(arr , mid + 1 , right,temp);
            Merge(arr,left, mid ,right,temp);
        }

    }

    public static void Merge(int[] arr, int left,int mid , int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i <= mid){

            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        t=0;
        int templeft = left;
        while(templeft <= right){
            arr[templeft] = temp[t];
            templeft++;
            t++;
        }

    }
}
