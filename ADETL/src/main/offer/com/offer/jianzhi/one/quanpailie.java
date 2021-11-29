package com.offer.jianzhi.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yjm
 * @create 2019-09-18 22:41
 */
//思想： "" a b c d
    //:  a [b c d], b [ a c d] ....
    //: ab [c d] ac[b d]
    //:abc [d] add [c]
public class quanpailie {
    public static void main(String[] args) {
        /*String[] arr = new String[]{"a","b","c","d"} ;
        fun(arr);*/

        fun_arr("abcd");
    }
    public static void fun(String[] arr){

        List<String> str = Arrays.asList(arr);
        fun2(str , "");
    }

    public static void fun2(List list , String pre){
        if(!"".equals(pre)){
            System.out.println(pre);
        }
        for (int i = 0; i < list.size(); i++) {
            //输出以a开头的全排列
            LinkedList ls = new LinkedList<>(list);
            fun2(ls , pre+ls.remove(i));//ls , pre+ls.remove(i) 经过pre+ls.remove(i)之后 ls变成了3
        }

    }

    //a b c d 使用a依次替换 b c d ：a [ b c d ] , b [ a c d ] , c [ a b d ], d [ a b c]
    public static void fun_arr(String str){
        if(str == null || str.length() == 0) return;
        char[] chs = str.toCharArray();
        fun_arr2(chs , 0 , "");

    }

    public static void fun_arr2(char[] chs , int i ,String str){

        if(!"".equals(str)){
            System.out.println(str);
        }

        if(i == chs.length) return;

        for (int j = i; j < chs.length; j++) {
            swap(chs, i , j);
            fun_arr2(chs , i + 1 ,str + chs[i]);
            swap(chs, i , j);

        }

    }

    public static void swap(char[] chs, int i , int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

}
