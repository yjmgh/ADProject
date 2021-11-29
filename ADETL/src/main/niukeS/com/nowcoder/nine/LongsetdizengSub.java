package com.nowcoder.nine;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-09-23 16:23
 */
/*
最长递增子序列
【题目】
给定数组arr，返回arr的最长递增子序列。
【举例】
arr=[2,1,5,3,6,4,8,9,7]，返回的最长递增子序列为
[1,3,4,8,9]。
【要求】
如果arr长度为N，请实现时间复杂度为O(NlogN)的方法。
*/
/*
思路：
1 使用dp[i]记录以i结尾的最长递增子序列 两层循环 第二层从0 -- i-1
2 找到最大值及其位置
3 从最大值位置开始 依次往前找元素 元素满足 arr[j] < arr[i] && dp[j] == len -1
4 len--;
*/
public class LongsetdizengSub {
    public static void main(String[] args) {
        int[] arr={2,1,5,3,6,4,8,9,7};
        int[] a = fun(arr);
        System.out.println(Arrays.toString(a));
    }
    public static int[] fun(int[] arr){
        if(arr == null || arr.length == 0) return null;
        //1 使用dp[i]记录以i结尾的最长递增子序列 两层循环 第二层从0 -- i-1
        int[] dp = fun2(arr);
        System.out.println(Arrays.toString(dp));
        int [] res = fun3(arr , dp);

        return res;
    }
    //求dp[i]
    public static int[] fun2(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }

        return dp;
    }

    public static int[] fun3(int[] arr , int[] dp){
        //找出dp[i]最大的值， 及其位置
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }

        int[] res = new int[max];
        res[max-1] = arr[index];
        int k = max -2;
        for (int i = index; i >= 0 ; i--) {

            if(arr[i] < arr[index] && dp[i] == max - 1){
                res[k] = arr[i];
                k--;
                max--;
                index = i;
            }
        }

        return res;
    }
}
