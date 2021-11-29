package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-08-29 20:33
 */
public class CowN {
    public static void main(String[] args) {
        System.out.println(getN(7));
    }
    public static int getN(int N){
        if(N <= 0 ) return 0;
        return CowNumber(N);
    }

    public static int CowNumber(int N){
        if(N == 1) return 1;
        if(N == 2) return 2;
        if(N == 3) return 3;

        return CowNumber(N-1) + CowNumber(N-3);


    }
}
