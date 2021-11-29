package ry;

import java.util.*;

/**
 * @author yuanjiameng
 * @create 2021-11-24 21:59
 * @describe
 */
public class RongYao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s1 = sc.nextLine().trim().toCharArray();
        char[] s2 = sc.nextLine().trim().toCharArray();
        long[] s = qushu(s1);
        long[] x= qushu(s2);

        long[] res = fun(s,x);
        StringBuilder sr = new StringBuilder();

        for (int i = s.length-1; i >=0 ; i--) {
            sr.append(res[i]);
            if(i > 0){
                sr.append(" ");
            }
        }
        System.out.println(sr.toString());

    }

    public static long[] qushu(char[] str){
        String s = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {

            if((str[i] >= '0' && str[i] <= '9') || str[i] == '-'){
                s = s+str[i];
            }else if(str[i] == ' '){
                if(s != ""){
                    sb.append(s);
                    sb.append("_");

                }
                s = "";
            }else if(str[i] == ']'){
                sb.append(s);

            }
        }

        String[] res = sb.toString().split("_");
        long[] r = new long[res.length];
        for (int i = 0; i < res.length; i++) {
            r[i] = Long.parseLong(res[i]);
        }

        return r;
    }
    public static long[] fun(long[] s, long[] x){

        long[] res = new long[s.length];
        for (int i = 0; i < s.length; i++) {

            double ss = Math.abs(s[i])*Math.abs(s[i]);
            double xx = Math.abs(x[i])*Math.abs(x[i]);

            res[i] = Math.round(Math.sqrt(ss+xx));
        }

        Arrays.sort(res);
        return res;
    }
}

//[5041  5761   4691  672  5172  -9735  -9907  -4906    2880   9222]
//[3740  3871   3171  1886 163  1961   -4476  -7229    -9735   -11219]