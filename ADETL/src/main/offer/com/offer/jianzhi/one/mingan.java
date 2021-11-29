package com.offer.jianzhi.one;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-25 19:41
 */
//敏感词替换
public class mingan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //String str = "abcdefrABCDEFG()012345678987654 BCDEF";

        System.out.println(fun(str));
    }

    public static String fun(String str){
        if(str == null || str.length() == 0) System.out.print("");

        String[] sp = str.split(" ");

        String s1 = sp[0];
        String s2 = sp[1];

        return fun1(s1,s2);
    }
    public static String fun1(String str1 , String str2) {
        if(str1 == null || str2 == null){
            return "";
        }
        String sta = getStar(str2.length());

        return str1.replace(str2 , sta);


    }

    public static String getStar(int len){

        if(len <= 0){
            return "";
        }
       /* String[] star = {"*","**","***","****","*****","******","*******","********","*********","**********"};
        if(len <= 10){
            return star[len-1];
        }*/

        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = '*';
        }
        return new String(arr);
    }


}
