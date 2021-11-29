package com.nowcoder.minor;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-08-18 11:08
 */
//常规荷兰国旗问题
public class NetherlandsFlag {
    public static void main(String[] args) {

        int[] arr = getArray(10);
        int[] arr1 = partition(arr,0,arr.length-1,1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

    }

    public static int[] partition(int[] arr , int l , int r, int p){
       // if(arr == null || arr.length == 0) return ;

        int less = l - 1;
        int more = r + 1;

        while(l < more){
            if(arr[l] < p){
                less++;
                swap(arr , less ,l);
                l++;
            }else if(arr[l] > p){
                more--;
                swap(arr , more , l); //交换过来的元素有可能还是小于P
            }else {
                l++;
            }
        }
        return  new int[]{less+1,more-1};
    }

    public static void swap(int[] arr , int i ,int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] getArray(int n){

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*3);
        }
        return arr;
    }
}
