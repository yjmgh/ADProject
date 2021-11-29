package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author yuanjiameng
 * @create 2021-10-14 23:46
 * @describe
 * 快排
 */
public class QuickSortV2 {
    public static void main(String[] args) {
        //int[] arr = new int[]{4 , 9 , 8, 9 ,5, 3 ,10, 7};
        int[] arr = new int[]{10 ,6 , 8 , 9, 9, 8 ,11};
        //int[] arr = {6,8};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void Sort(int[] arr){
        //处理特殊情况
        if(arr == null || arr.length <= 1) return;
        QuickSort(arr, 0, arr.length-1);
    }

    public static void QuickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int mid = start + ((end-start)>>1);
        int[] res = partition(arr, start, end, arr[mid]);

        //排左边
        QuickSort(arr, start, res[0]-1);
        //排左边
        QuickSort(arr, res[1]+1, end);

    }

    public static int[] partition(int[] arr , int begin , int end , int pivot){//荷兰国旗问题
        int small = begin - 1;
        int big = end + 1;
        int cur = begin;
        while (cur < big){
            if(arr[cur] < pivot){
                small++;
                swap(arr , small , cur);
                cur++;
            }else if(arr[cur] > pivot){
                big--;
                swap(arr,cur,big);
            }else {
                cur++;
            }

        }
        int[] res = new int[2] ;
        res[0] = small+1;
        res[1] = big-1;
        return res;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
