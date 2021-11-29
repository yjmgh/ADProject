package com.nowcoder.nine;

/**
 * @author Yjm
 * @create 2019-09-24 22:06
 */
/*
最长公共子串问题
【题目】
给定两个字符串str1和str2，返回两个字符串的最长公共子串。
【举例】
str1="1AB2345CD"，str2="12345EF"，返回"2345"。
【要求】
如果str1长度为M，str2长度为N，实现时间复杂度为O(MN)，额
外空间复杂度为O(1)的方法。
*/
//解题思路：
//1 找出以每个 (i ,j)结尾的最长子串
//        1  dp[i][j] = (str[i]  ==  str[j]) ? dp[i-1][j-1] + 1 : 0;
//        2  第一行，第一列 能跟对方第一个元素对应上就是1 否则就是0
//2 找出最大值及其位置，就可以输出了
public class LongestGonggongzichuan {
    public static void main(String[] args) {
        System.out.println(getString("AC", "B"));
    }

    public static String getString(String str1,String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")) return "";

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        int[][] dp = fun(ch1 , ch2);

        int max = 0;
        int end = 0;//
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {

                if(dp[i][j] > max){

                    max = dp[i][j];
                    end = i;
                }
            }
        }
        //[1 , 1)代表取不到1 这里底层直接就是""
        //return max == 0 ? "" str1.substring(end - max + 1 , end +1);
        return str1.substring(end - max + 1 , end +1);

    }

    public static int[][] fun(char[] str1 , char[] str2){
        int[][] dp = new int[str1.length][str2.length];

        //第一列
        for (int i = 0; i < str1.length; i++) {
            if(str1[i] == str2[0]){
                dp[i][0] = 1;
            }
        }

        //第一行
        for (int i = 0; i < str2.length; i++) {
            if(str2[i] == str1[0]){
                dp[0][i] = 1;
            }
        }

        //之后的每一个元素
        for (int i = 1; i <str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }//否则就是0
            }
        }

        return dp;
    }
}
