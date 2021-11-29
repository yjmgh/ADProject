package com.nowcoder.one;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-09-13 14:00
 */
//在一个字符串中定位另一个串的高效算法
    //A B C K M N  A B C D str1
    //A B C K M N  A B C E str2
    //过滤的是A B C K M N这部分
    //如果是a b c d e f
    //      a b c d e h
    //则直接过滤掉a b c d e f，到下一个元素
public class KMP {
    public static void main(String[] args) {

        String str = "abadabac";
        System.out.println(Arrays.toString(getNextArray(str.toCharArray())));
    }

    public static int fun_KMP(String str1 , String str2){
        if(str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int ch1 = 0;//i
        int ch2 = 0;
        //chs2每一个元素最长前缀和最长后缀的匹配长度
        int[] next = getNextArray(chs2);

        while(ch1 < chs1.length && ch2 < chs2.length) {//ch2 = chs2.length 代表已经找到了
            //相同就一起加加，不同的话就递归找相同的前缀，一直找到第一个元素还不相同就str1++
            if(chs1[ch1] == chs2[ch2]){
                ch1++;
                ch2++;
            }else if(next[ch2] == -1){
                ch1++;
            }else {
                ch2 = next[ch2];
            }

        }

        return ch2 == chs2.length ? ch1 - ch2 : -1;
    }

    public static int[] getNextArray(char[] chs2){
        if(chs2.length == 1){
            return new int[]{-1};
        }

        int[] next = new int[chs2.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0; // A B C D A B C H K，如果走到了H 那么cn就是D的位置，即相等的最后一个元素，再走到K的时候cn就等于0了
        while (index < next.length){
            //当前的元素是chs2[index] ,看看前一个元素chs2[index-1] 等不等于 前缀+1 的位置
            if(chs2[index-1] == chs2[cn]){
                cn++;
                next[index] = cn;
                index++;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[index] = 0;
                index++;
            }
        }

        return next;
    }
}
