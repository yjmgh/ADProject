package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanjiameng
 * @create 2021-10-12 20:05
 * @describe
 */
public class Divide_29 {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        System.out.println(divide(a,b));
    }
    public static int divide(int dividend, int divisor) {
        //处理特殊的情况
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == -2147483648) return 2147483647;
            return -dividend;
        }

        long dd = Math.abs((long)dividend);
        long dv = Math.abs((long)divisor);

        long res = div(dd, dv);
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) res = -res;

        if(res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        return (int)res;

    }

    //这里的a和b都是正数 a/b
    public static long div(long dd, long dv){
        if(dd < dv ) return 0;

        long b = dv;
        int count = 1;
        while((b<<1) <= dd){
            count = count<<1;
            b = b<<1;
        }

        return count + div(dd - b,dv);

    }
}
