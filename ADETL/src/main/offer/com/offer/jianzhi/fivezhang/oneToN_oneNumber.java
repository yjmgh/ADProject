package com.offer.jianzhi.fivezhang;

/**
 * @author Yjm
 * @create 2019-10-05 20:50
 */
//题目：1 ~ N中 1 出现的个数
//思路： 例如 N = 21345 先解决1346 ~ 21345中1的个数 ， 在递归解决 1 ~ 1345中1的个数
//具体方法：判断万位是否大于1 ， 若大于1，直接10000+x :x=2*4*10^4 , 其中9999出现了两次 09999 ， 19999 若等于1 ：N-10000+1 + 4*10^3
//伪代码：1 N ：先变成str,在变成char[]
//       2 fun(char[] , i) 看i == chs.length-1 :相等 {看是否就是 1 若是返回1 ， 不是返回0}
//       3 不等：分两部分：num1 + fun(num2) :num1: 判断i是否大于1 大于：1+后面几个0.toString + n*(几位)*10^(几位-1)
//                                                              == 1：num - 10000 + 1 + (几位)*10^(几位-1)
//       4 返回 num1 + fun(num2)
public class oneToN_oneNumber {
    public static void main(String[] args) {
        System.out.println(fun(21345));
    }
    public static int fun(int N){
        if(N <= 0) return 0;
        char[] chs = String.valueOf(N).toCharArray();

        return process(chs , 0);
    }

    public static int process(char[] chs , int i){
        if(i == chs.length-1){
            int val = chs[i] - '0';
            return chs[i] >= '1' ? 1 : 0;
        }
        int chsi = chs[i] - '0';
        int count = 0;
        if(chsi > 1){
            count = (int)Math.pow(10,(double) (chs.length - i - 1));
        }else {
            String s = "";
            int j = i+1;
            while(j < chs.length){
                s += chs[j];
                j++;
            }
            count = Integer.valueOf(s) + 1;
        }

        count += chsi * (chs.length - i -1) * Math.pow(10 , chs.length - i -2);
        int num2 = process(chs , i+1);
        return count + num2;
    }
}
