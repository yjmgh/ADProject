package com.offer.jianzhi.fivezhang;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-10-05 16:52
 */
//题目：输出第一个只出现一次的字符   P240
//思路：使用hashmap记录，每个字符的// 出现次数 ，第二次遍历的时候输出第一个第一次出现的字符
public class OneChar {
    public static void main(String[] args) {
        String str = "abaccdeff";
        fun(str);
    }

    public static void fun(String str){
        if(str == null || str.length() == 0) return ;

        char[] chs = str.toCharArray();
        HashMap<Character , Integer> map = new HashMap<>();

        for (int i = 0; i < chs.length; i++) {
            if(map.containsKey(chs[i])){
                Integer val = map.get(chs[i]);
                map.put(chs[i] , val + 1);
            }else {
                map.put(chs[i] , 1);
            }
        }

        for (int i = 0; i < chs.length; i++) {
            Integer val = map.get(chs[i]);
            if(val == 1){
                System.out.println(chs[i]);
                break;
            }
        }

    }
}
