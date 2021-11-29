package com.nowcoder.nine;

import com.twitter.chill.Base64;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-24 17:10
 */
//1 先找出最长公共子序列的长度 使用dp[str1.length][sre.length]
//2 获得最长的长度后从dp右下角开始依次遍历找 倒数第一个重复的字母..倒数第二个重复的字母.....
public class longestGonggongzixulie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextInt();

    }

    public static String fun(String str1 , String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = dp_fun(chs1, chs2);

        int m = chs1.length - 1;
        int n = chs2.length - 1;

        char[] res = new char[dp[m][n]];

        int index = res.length - 1;

        while (index >= 0){
            //就是说dp[i][j] 是由 dp[i][j-1]来的就回到dp[i][j-1]，是由 dp[i-1][j]来的就回到dp[i-1][j]，否则就是由dp[i-1][j-1]得到的
            //现在问题是如果是由dp[i-1][j]变过来的 怎么得到的dp[i-1][j-1]的？
            //答：A B D C
            //    A B C D
            //当 i = 2 j = 3 的时候一定是由 A B    A B C变过来的
            //A B C      i = B
            //A B C D    J = B画画图就清楚了
            //遇到 str[i] == str2[j]的时候肯定就是斜角 ， 不然肯定是下或左中的一个
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            }else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }

        return String.valueOf(res);
    }
    //获得dp数组
    //1 dp[i][j] 可能来自 dp[i-1][j] dp[i][j-1] dp[i-1][j-1]+1(str1[i] == str2[j])中的一个，谁大就是谁
    //2 边界 str[i] 跟 str[0]匹配上之后接下来的值都是1 str[j]同理
    public static int[][] dp_fun(char[] str1 , char[] str2){
        int[][] dp = new int[str1.length][str2.length];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //第一行
        for (int i = 1; i < str2.length; i++) {
            if(dp[0][i-1] == 1) {
                dp[0][i] = 1;
            }else if(str2[i] == str1[0]){
                dp[0][i] = 1;
            }
        }

        //第一列
        for (int j = 1; j < str1.length; j++) {
            if(dp[j-1][0] == 1) {
                dp[j][0] = 1;
            }else if(str1[j] == str2[0]){
                dp[j][0] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp;
    }
}
