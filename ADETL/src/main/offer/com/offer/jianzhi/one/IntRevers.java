package com.offer.jianzhi.one;

/**
 * @author Yjm
 * @create 2019-09-18 10:28
 */
//整数的逆向打印
public class IntRevers {
    public static void main(String[] args) {
        System.out.println(fun(564578));
    }
    public static int fun(int num){
        if(num == 0) return 0;

        if(num > 0){
            return reverse(num);
        }else{
            return 0-reverse(Math.abs(num));
        }
    }

    public static int reverse(int num){

        int res = 0;
        while (true){
            //最后一位
            int l = num % 10;
            res = res*10 + l;
            num = num / 10;

            if(num == 0){
                return res;
            }
        }



    }
}
