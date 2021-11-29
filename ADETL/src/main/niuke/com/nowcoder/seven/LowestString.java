package com.nowcoder.seven;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yjm
 * @create 2019-08-29 21:56
 */
public class LowestString {
    public static void main(String[] args) {
        String[] str = {"b","ba","ngruhgur"};
        System.out.println(getLowestString(str));
    }
    public static String getLowestString(String[] str){
        if(str == null || str.length ==0) return "";
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2+o1);
            }
        });
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res +=str[i];
        }
        return res;
    }


}
