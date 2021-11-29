package com.offer.jianzhi.threezhang;

/**
 * @author Yjm
 * @create 2019-09-29 22:00
 */
//一个数的n次方, 不考虑大数的情况 ： n < 0 ,n ==0 ,n > 0
//n > 0 : x^n --> if(n 是奇数) { (x^ (n/2))^2 * x } else { (x^ (n/2))^2 }
public class ncifang {
    public static void main(String[] args) {

        System.out.println(fun(0, 5));
        System.out.println(fun(2, 5));
        System.out.println(fun(-1, 5));
        System.out.println(fun(-1, 0));
        System.out.println(fun(0, -1));
    }

    public static double fun(double x , int n){

        if(n == 0){
            return  1;
        }else if(n > 0) {
            return process(x , n);
        }else{
            if(x == 0) return 0;  // 0^-1 == 0
            return 1 / process(x , -n);
        }
    }

    //n > 0
    public static double process(double x , int n){

        if(n == 1) return x;

        double res = process(x ,n/2);
       if((n & 1) == 0) { //偶数
           return res * res;
       }else {
           return res * res * x;
       }

    }

}
