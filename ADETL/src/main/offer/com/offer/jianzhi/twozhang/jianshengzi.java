package com.offer.jianzhi.twozhang;

/**
 * @author Yjm
 * @create 2019-09-27 23:20
 */
//剑指offer P96 长度N 减M段
//思路：到N时候   1 -- N-1 的最大值已经计算好了
//一般的 N ： for(1 : N/2) { i * dp[N-i] }    当cur为i的时候 ，
//                                                 1 就只有两段 i * (N-i)
//                                                 2 超过两段那么dp[N-i]就是已经计算好的最大值  dp[N-i]内部是一定会切的
// 选出最大值然后跟总体的最大值进行比较
//边界的N N < 2 : 0
//       N == 2 : 1
public class jianshengzi {
    public static void main(String[] args) {
        System.out.println(getNumber1(100));
        System.out.println(getNumber(100));

        System.out.println(getNumDigui(8));
    }

    // 动态对话版本
    public static int getNumber(int N){
        if(N < 2) return 0;
        if(N == 2) return 1;
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N ; i++) {
            int max = 0;
            for (int j = 1; j <= i/2 ; j++) {
                max = Math.max(max , j * (i-j));    // 1 2 3 4 5 6 7 8   i = 3 的时候 2 * 1 * 5 的情况已经计算好了

                max = Math.max(max , j* dp[i - j]);
                max = Math.max(max , dp[j]* (i - j));

                max = Math.max(max , dp[j]* dp[i - j]);
            }
            dp[i] = max;
        }

        return dp[N];
    }

    public static int getNumber1(int N){
        if(N < 2) return 0;
        if(N == 2) return 1;
        if(N == 3) return 2;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= N ; i++) {
            int max = 0;
            for (int j = 1; j <= i/2 ; j++) {
                //max = Math.max(max , j * (i-j));    // 1 2 3 4 5 6 7 8   i = 3 的时候 2 * 1 * 5 的情况已经计算好了
                max = Math.max(max , dp[j]* dp[i - j]);
            }
            dp[i] = max;
        }

        return dp[N];
    }

    // 递归版本
    public static int getNumDigui(int N){
        if(N < 2) return 0;
        if(N == 2) return 1;
        if(N == 3) return 2;

        return getNumberDiguiFn(N);

    }

    // 当数据>=4就能满足 2*(n-2)>=n,就是说一段绳子裁成2端的乘积的最大值一定>=绳子总长数
    // 就是说当N>=4的时候，裁比不裁更好
    public static int getNumberDiguiFn(int N){
        if(N < 4) return N;
        int max = 0;

        //将绳子分为两部分，每部分的长度
        for(int i = 1; i<=N/2; i++){
            max=Math.max(getNumberDiguiFn(i)*getNumberDiguiFn(N-i),max);
        }

        return max;
    }

}
