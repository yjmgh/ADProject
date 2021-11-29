package com.nowcoder.nine;

import scala.tools.cmd.gen.AnyVals;

/**
 * @author Yjm
 * @create 2019-09-26 11:48
 */
/*
回文最小分割数
【题目】
给定两个字符串str，请把str切割，保证每一部分都是回文串，求最小的分割
数。
【举例】
str="AA12321BB"
，切成"AA","12321","BB"
，每一部分都是回文串，分出3个
部分，所以返回3

*/

/*
解题思路：dp[i]代表以当前位置结尾的最小分割数 ,p[i][j]记录从j到i是否是回文 j [0 i]
1 最小分割可能是dp[j-1] + 1
2 让j从i到0上进行枚举，选择最小的
3 p[j][i]值的确定
    str[j][i]由一个字符组成
    str[j][i]由两个字符组成且两个字符相等
    str[j][i]由多个字符组成，str[j] == str[i]且p[j+1][i-1] == True。

*/
public class zuixioahuiwenfenge {
    public static void main(String[] args) {

       /* int maxLen = 10;
        int testTimes = 5;
        String str = null;
        for (int i = 0; i != testTimes; i++) {
            str = getRandomStringOnlyAToD(maxLen);
            System.out.print("\"" + str + "\"" + " : ");
            System.out.println(getNumber(str));
        }*/

        String str="AA12321BB";
        System.out.println(getNumber(str));

    }
    // for test
    public static String getRandomStringOnlyAToD(int len) {
        int range = 'D' - 'A' + 1;
        char[] charArr = new char[(int) (Math.random() * (len + 1))];
        for (int i = 0; i != charArr.length; i++) {
            charArr[i] = (char) ((int) (Math.random() * range) + 'A');
        }
        return String.valueOf(charArr);
    }


    public static int getNumber(String str){
        if(str == null || str.length() == 0) return 0;
        char[] chs = str.toCharArray();
        int[] dp = new int[chs.length];//dp[i]代表以当前位置结尾的最小分割数

        boolean[][] p = new boolean[chs.length][chs.length];//p[j][i]代表str[j][i]是否能构成一个回文串

        dp[0] = 1;
        p[0][0] = true;
        for (int i = 1; i < chs.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0 ; j--) {
                if(j == i){
                    p[j][i] = true;
                }else if(j == i-1 && chs[j] == chs[i]){
                    p[j][i] = true;
                }else if(chs[j] == chs[i] && p[j+1][i-1] == true) {

                        p[j][i] = true;
                }

                int k = 0 ;
                if(j != 0) k = dp[j-1];
                dp[i] = Math.min(dp[i], p[j][i] == true ? k+1 : k + i - j +1);
            }

        }
            return dp[chs.length-1] ;
    }
}
