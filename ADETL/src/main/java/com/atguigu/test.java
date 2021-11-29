package com.atguigu;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-08-03 16:27
 */
public class test {
    public static void main(String[] args) {

        //1
        //1100
        //110011
        //现在str1是优秀的判断str2是否是优秀的
        String str1 = "1100";
        String str2 ="110011";

        /*int n =1;
        while(n>0){

        }*/
        System.out.println(good(str1, str2));
    }

    public static boolean good(String str1 , String str2){

        if(good(str1,str1+str2)){
            if(good(rev(str1),rev(str1)+str2)){
                return true;
            }
        }
        return false;
    }

    public static String rev(String str){

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] =='1'){
                chars[i] ='0';
            }else if(chars[i] == '0'){
                chars[i] = '1';
            }
        }
        return Arrays.toString(chars);
    }
}
