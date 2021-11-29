package com.nowcoder.minor;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-08-18 12:47
 */

// 说一下桶排序
// n个数就有n+1个桶，最小值和最大值放在最边上那两个桶，这样就能保证中间一定有空桶
// 桶x 空桶x+1 桶x+2 这样[min(桶x+2) - max(桶x)] > (空桶x+1).length,这样就能保证最大的差值一定不在同一个桶里面，也仅仅是不在一个桶里面而已
public class MaxGap_tong {
    public static void main(String[] args) {
        int[] arr = getArray(10, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxGap(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println(test(arr));
    }

    //最大差值
    public static int maxGap(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        // 1 先找最大值跟最小值
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(maxValue,arr[i]);
            minValue = Math.min(minValue,arr[i]);
        }

        if(maxValue == minValue) return 0;
        // 2 分桶
        int[] maxArr = new int[len+1];
        int[] minArr = new int[len+1];
        boolean[] hasNum = new boolean[len+1];
        int bid = 0 ; //真正的桶就是上面三个数组，最主要的就是bid的获取

        for (int i = 0; i < len; i++) {
            bid =bucket(arr[i],len,minValue,maxValue) ;
            maxArr[bid] = hasNum[bid]?Math.max(maxArr[bid],arr[i]):arr[i];
            minArr[bid] = hasNum[bid]?Math.min(minArr[bid],arr[i]):arr[i];
            hasNum[bid] = true;
        }

        int res = 0; //最终要返回的差值
        int lastMax = maxArr[0];//记录当前元素之前非空桶的桶的最大值
        for (int i = 1; i <= len; i++) {
            if(hasNum[i]){
                res = Math.max(res,minArr[i]-lastMax);
                lastMax = maxArr[i];
            }
        }

        // 3 返回值
        return res;
    }

    private static int bucket(long num , long len , long min , long max) {
        return (int)((num - min) * len / (max - min));
    }

    public static int[] getArray(int n,int m){

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*m);
        }
        return arr;
    }

    public static  int test(int[] arr){

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            max = Math.max(max,(arr[i+1] - arr[i]));
        }
        return max;
    }
}
