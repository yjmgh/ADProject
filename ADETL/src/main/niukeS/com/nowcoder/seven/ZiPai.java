package com.nowcoder.seven;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-09-19 16:36
 */
/*
排成一条线的纸牌博弈问题【题目】
给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
【举例】
arr=【1，2，100，4】。
开始时玩家A只能拿走1或4。如果玩家A拿走1，则排列变为【2，100，4】，接下来玩家B可以拿走2或4，然后继续轮到玩家A。如果开始时玩家A拿走4，则排列变为【1，2，100】，接下来玩家B可以拿走1或100，然后继续轮到玩家A。玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100。所以玩家A会先拿1，让排列变为【2，100，4】，接下来玩家B不管怎么选，100都会被玩家A拿走。玩家A会获胜，分数为101。所以返回101。
arr=【1，100，2】。
开始时玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，分数是100.所以返回100
*/
public class ZiPai {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(getNumber(new int[]{1, 2, 100, 4})));
        System.out.println(getNumber(new int[]{1, 2, 100, 4}));
        //System.out.println(fun(new int[]{1, 2, 100, 4}));
    }

    public static int getNumber(int[] arr ){
        /*int[] arr1 = new int[2];
        if(arr == null) return arr1;
        if(arr.length == 1) {
            arr1[0] = arr[0];
            return arr1;
        }
       // int[] arr1 = new int[2];
        arr1[0] = A(arr , 0 , arr.length -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        arr1[1] = sum - arr1[0];
        return arr1;*/
        if(arr == null || arr.length == 0){
            return 0;
        }
        //整体思路是 f是先拿 s是后拿
        //A 拿走arr[i] 那么B会给A返回B拿走一个后最坏的结果给A
        //i == j的情况 先拿的人能拿走 后拿的人是拿不走的
        int A = f(arr,0,arr.length-1);
        // B先选在[0,arr.length-1]拿走一个，把剩下结果中最小的一个给A返过去，所以得到的6应该是A的，但是实际上B可选的值域没这么大
        int B = s(arr,0,arr.length-1);
        System.out.println(A);
        System.out.println(B);
        return Math.max(A,B);
    }

    public static int f(int[] arr , int i , int j){
        if(i == j){
            return arr[i];
        }
        //我先拿，想要获得最大值
        return Math.max(arr[i] + s(arr , i+1, j) , arr[j] + s(arr , i , j-1));
        //s(arr , i+1, j)是 B拿走一个后剩下的比较差的情况
    }

    public static int s(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        //我后拿 ，给你返回我拿完后让你最小的值
        return Math.min(f(arr , i+1, j) , f(arr , i , j-1));
    }

    public static int fun(int[] arr ){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];

            for (int i = j-1; i >= 0 ; i--) {
                f[i][j] = Math.max(arr[i] + s[i+1][j],arr[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j] , f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }

    /*public static int fun(int[] arr , int l , int r){
        if(l == r){
            return arr[l];
        }
        //A B两个人
        //A 拿了当前第一个
        fun(arr , l+1 , r);

        fun(arr , l , r-1);




    }*/
}
