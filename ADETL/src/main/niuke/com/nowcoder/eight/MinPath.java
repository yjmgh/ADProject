package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-08-28 23:02
 */
public class MinPath {
    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(fun_dp(m));
        System.out.println(min_path1(m));
    }

    //递归版本
    public static int min_path1(int[][] arr){

        if(arr == null) return 0;
        return fun_recur(arr,0,0);
    }

    public static int fun_recur(int[][] arr,int i , int j) {
        if(i == arr.length-1 && j== arr[0].length-1){
            return arr[i][j];
        }
        if(i == arr.length-1){
            return arr[i][j] + fun_recur(arr,i,j+1);
        }
        if(j== arr[0].length-1){
            return arr[i][j] + fun_recur(arr,i+1,j);
        }
        return arr[i][j] +Math.min(fun_recur(arr,i , j+1),fun_recur(arr,i+1 , j));
    }

    //动态规划
    public static int fun_dp(int[][] arr){
        if(arr == null) return -1;
        int t_r = arr.length;
        int t_c = arr[0].length;
        int[][] temp = new int[t_r][t_c];
        temp[t_r-1][t_c-1] = arr[t_r-1][t_c-1];


        int k = t_c - 2;
        int n = t_r - 2;
        while( k >= 0) {
            temp[t_r-1][k] = arr[t_r-1][k] + temp[t_r-1][k+1];
            k--;
        }
        while (n >= 0) {
            temp[n][t_c -1] = arr[n][t_c -1] + temp[n+1][t_c -1];
            n--;
        }

        for (int i = t_r - 2; i >= 0; i--) {
            for (int j = t_c -2; j >= 0; j--) {
                temp[i][j] = arr[i][j] +Math.min(temp[i][j+1] ,temp[i+1][j]);
            }
        }
        return temp[0][0];
    }
}
