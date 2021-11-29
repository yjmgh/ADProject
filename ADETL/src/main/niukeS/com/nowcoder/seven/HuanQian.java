package com.nowcoder.seven;

/**
 * @author Yjm
 * @create 2019-09-18 23:03
 */
/*
换钱的方法数【题目】
给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求换钱有多少种方法。
【举例】
arr=【5，10，25，1】，aim=0。
组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
arr=【5，10，25，1】，aim=15。
组成15元的方法有6种，分别为3张5元、1张10元+1张5元、1张10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所以返回6。
arr=【3，5】，aim=2。
任何方法都无法组成2元。所以返回0。
*/
public class HuanQian {
    public static void main(String[] args) {
        int[] arr = new int[]{5,10,25,1};
       // System.out.println(dp_fun(arr, 35));
        System.out.println(fun3(arr, 0,34));
        System.out.println(fun4(arr, 34));
        //System.out.println(getNumber(arr, 35));

    }

    public static int getNumber(int[] arr ,  int aim){
        if(arr == null || arr.length ==0 || aim < 0) return 0;

        return fun(arr , 0 , aim);

    }
//递归有多少种换钱方式
    public static int fun(int[] arr , int i , int aim){
        if(i == arr.length){
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int j = 0; arr[i] *j <= aim ; j++) {
            res += fun(arr ,  i +1 , aim - arr[i]*j);
        }
        return res;
    }
//动态规划 有多少种换钱方式
    public static int dp_fun(int[] arr ,  int aim){

        int[][] arr1 = new int[arr.length+1][aim+1];
        arr1[arr.length][0] = 1;

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = aim; j >= 0 ; j--) {
                int res = 0;
                int k =0;
                int a = j;
                while(true){
                    if((a - arr[i]*k) < 0) break;
                    res += arr1[i+1][a - arr[i]*k];
                    k++;
                }
                arr1[i][j] = res;
            }
        }

        return arr1[0][aim];
    }

//递归 最小张数
    public static int fun3(int[] arr ,int i, int aim ){

        if(i == arr.length){
            return aim == 0 ? 0 : -1;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; arr[i]*j <= aim ; j++) {
            int subRes = fun3(arr , i+1,aim-arr[i]*j);
            if(subRes != -1){
                min = Math.min(min , subRes+j);
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
//动态规划 最小张数
    public static  int fun4(int[] arr , int aim){
        int[][] arr1 =  new int[arr.length+1][aim+1];
        for (int i = 1; i <= aim; i++) {
            arr1[arr.length][i] = -1;
        }

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = aim; j >= 0 ; j--) {
                int min = Integer.MAX_VALUE;
                int k =0;
                int a = j;
                while(true){
                    if((a - arr[i]*k) < 0) break;
                    int subRes = arr1[i+1][a - arr[i]*k];
                    if(subRes != -1){
                        min = Math.min(min , subRes+k);
                    }
                    k++;
                }

                arr1[i][j] = (min != Integer.MAX_VALUE) ? min : -1;
            }
        }

        return arr1[0][aim];

    }
}
