package com.offer.jianzhi.twozhang;

/**
 * @author Yjm
 * @create 2019-09-27 21:28
 */
//题目：旋转数组最小值 剑指offer P86    3 4 5 1 2
//解题思路： 采用二分法
//1 l r mid = (l + r) / 2   看mid若大于l则属于 属于子数组1 l=mid ，mid若 < r则属于子数组2 r=mid
//2 旋转了0个的情况，即数组有序的情况 l < r 直接返回第一个元素 mid = l
//3 l == r == mid 的情况   使用遍历
public class xuanzhuanshuzuzuixiaozhi {
    public static void main(String[] args) {
        //System.out.println(getNumber(new int[]{1, 0, 1, 1, 1}));
        System.out.println(getNumber(new int[]{3 , 4 , 5, 1, 2}));
        //System.out.println(getNumber(new int[]{3 , 4 , 5, 1, 2}));
    }

    public static int getNumber(int[] arr){
        //在函数前判断if(arr == null || arr.length == 0) return Integer.MAX_VALUE ;

        int len = arr.length;
        int l = 0;
        int r = arr.length-1;
        if(arr[l] < arr[r]) return arr[0];  // 2
        int mid = 0; //mid此时赋值是没有意义的
        //l 会越界 ， r也不会越界
        while  (l < r){
            if(l == r-1){
                mid = r;
                break;
            }
            mid = l + ((r - l) >> 1);

            if(arr[l] == arr[r] && arr[l] == arr[mid]) return getMin(arr , l , r); //也只会是第一次，遇上了就是遇上了

            if(arr[mid] >= arr[l]) l = mid;

            if(arr[mid] <= arr[r]) r = mid;
        }

        return arr[mid];
    }

    public static int getMin(int[] arr , int l , int r){
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            res = Math.min(res , arr[i]);
        }

        return res;
    }
}
