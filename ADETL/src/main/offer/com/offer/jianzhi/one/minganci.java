package com.offer.jianzhi.one;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-25 19:07
 */
public class minganci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        String str = "abcdefrABCDEFG()012345678987654 BCDEF";
        fun(str);
    }

    public static void fun(String str){
        if(str == null || str.length() == 0) System.out.print("");

        String[] sp = str.split(" ");

        String s1 = sp[0];
        String s2 = sp[1];
        //if(s2.length() <= 0 )

        char[] arr = new char[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            arr[i] = '*';
        }

        String s = new String(arr);
        if(s1.contains(s2)){
            String re = s1.replace(s2, s);
            System.out.print(re);
            return;
        }

        System.out.println(str);
    }
}
