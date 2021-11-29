package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-08-29 20:47
 */
//打印一个字符串的全部子序列，包括空字符串 看看程序的之前格式
public class SubstringPrint {
    public static void main(String[] args) {
        substring("abc");
    }

    public static void substring(String str){
        if(str == null) return;

        char[] chars = str.toCharArray();
        printSub(chars , 0 , "");


    }

    public static void printSub(char[] chars , int i , String res){
        if(i == chars.length){
            System.out.println(res);
            return;
        }
            printSub(chars , i+1 ,res);
            printSub(chars , i+1 ,res+chars[i]);
    }
}
