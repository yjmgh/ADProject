package com.offer.jianzhi.fivezhang;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-10-05 19:07
 */
//题目：最长不含重复字符的子字符串
//思路:使用窗口，记录以当前字符串结尾的最长子字符串
public class longestSubArrNoCF {
    public static void main(String[] args) {
       String str = "arabcacfr";
        System.out.println(fun(str));
    }

    public static String fun(String str){
        if(str == null || str.length() == 0) return "";

        char[] chs = str.toCharArray();
        HashMap<Character , Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int size = 1;

        int max = 1;
        int location = 0;

        //1 使用hashMap<char , int> 记录当前窗口内的字符及其位置
        map.put(chs[0] , 0);

        //2 如果窗口内没有该字符 ，将该字符加进去，r右扩 ， size++ ，hashmap也加进去
        for (int i = 1; i <chs.length; i++) {
            if(!map.containsKey(chs[i])){
                r++;
                size++;
                map.put(chs[i] , i);
                if(max < size){
                    max = size;
                    location = l;
                }
            }else {//3 窗口内有该字符，定位到该字符位置 ，从l到 该位置，依次删除map中的数据，size--，最后r扩进去 ， size++，
                int loca = map.get(chs[i]);
                for (int j = l; j <= loca; j++) {
                    map.remove(chs[j]);
                    size--;
                    l++;
                }
                r++;
                size++;
                map.put(chs[i] , i);

            }
        }
        StringBuilder res = new StringBuilder();
        while (max > 0){
            res.append(chs[location]);
            location++;
            max--;
        }
        //使用max记录最大长度，weizhi记录起始位置

        return res.toString();
    }
}
