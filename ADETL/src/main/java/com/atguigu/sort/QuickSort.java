package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-08-02 17:45
 */
//快速排序
public class QuickSort {
    public static void main(String[] args) {

        //int[] arr = new int[]{6 ,10 , 9 , 9, 9, 8 ,11};
        int[] arr = new int[]{4 , 9 , 8, 9 ,5, 3 ,10, 7};
        //int[] arr = {6,8};
        QuickS(arr , 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickS(int[] arr , int left , int right){
        if(left == right) return;
        if(arr == null || arr.length == 0){
            System.out.println("数组没有元素，无法进行排序");
            return;
        }

        int l = left ;
        int r = right;
        int pivot = arr[left + ((right - left) >> 1)];
        //int pivot = arr[(left + right) / 2];
        int temp = 0;
        while(l < r ){

            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;
            if(l >= r ){
                break;
            }

                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                //说明：if(arr[l] == pivot) l++;这种形式就是左右两边遇到等于num的就直接跳过去
                //if(arr[l] == pivot) r-- 这样一种是左右两边遇到num就自己不动，让对方继续运行，然后跟自己交换
                //若两边都等于num，那两边都向前移动
                if(arr[l] == pivot) r--;
                if(arr[r] == pivot) l++;
        }

        //这种情况 6 8 传进去的参数是0 1 l会变成1 而left < r == 0 < 1 就会无限循环 如果有下面的代码就会把l变成1
        if(l == r){
            l++;
            r--;
        }
        if(left < r){
            QuickS(arr,left,r);
        }
        if(right > l){
            QuickS(arr , l , right);
        }


    }
}
