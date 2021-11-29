package com.offer.jianzhi.twozhang;

/**
 * @author Yjm
 * @create 2019-09-26 20:53
 */
public class kaixin {
    public static void main(String[] args) {

    }
    /*public static int getNumber(int[] arr , int N , int M){
        if(arr == null || arr.length == 0 || M <= 0 || M > N) return 0;

        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum[i] = i > 0 ? sum[i-1] + arr[i] : arr[i];
            int max = Integer.MIN_VALUE;
            for (int j = i; j >=0 && j > i - M; j--) {
                max = Math.max(max , sum[i] - sum[j])
            }

        }
    }*/
}
