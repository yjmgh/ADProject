package com.nowcoder.nine;

/**
 * @author Yjm
 * @create 2019-09-25 13:24
 */
/*
  最小编辑代价
【题目】
给定两个字符串str1和str2，再给定三个整数ic、dc和rc，分别代表插
入、删除和替换一个字符的代价，返回将str1编辑成str2的最小代价。
【举例】
str1="abc"，str2="adc"，ic=5，dc=3，rc=2。
从"abc"编辑成"adc"，把'b'替换成'd'是代价最小的，所以返回2。
str1="abc"，str2="adc"，ic=5，dc=3，rc=100。
从"abc"编辑成"adc"，先删除'b'，然后插入'd'是代价最小的，所以返
回8。
str1="abc"，str2="abc"，ic=5，dc=3，rc=2。
不用编辑了，本来就是一样的字符串，所以返回0。
  */
public class zuixiaobianjidaijia {
    public static void main(String[] args) {

        String str1 = "abcdf";
        String str2 = "ab12cd3";
        System.out.println(getNumber(str1, str2, 3, 2, 4));
    }

    public static int getNumber(String str1, String str2 , int ic , int dc , int rc){
        if(str1 == null || str2 == null) return 0;

        //使用dp[i][j] 记录str1[i-1]编辑到str2[j-1]的代价，因为还有str2等于""的情况

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();


        int row = ch1.length+1;
        int col = ch2.length+1;
        int[][] dp = new int[row][col];
        //dp[0][0]代表 str1 "" 编辑成str2的""的代价 是0
        for (int i = 1; i < row ; i++) {
            dp[i][0] = dc*i;
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = ic*j;   //代表str1 = ""的时候变成了 str2[j]
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(ch1[i-1] == ch2[j-1]){       //替换的代价
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1] + rc;
                }

                dp[i][j] = Math.min(dp[i][j] , dp[i][j-1] + ic); //插入的代价 A B D -- A B C D  A B C + D插入最后一个字符
                dp[i][j] = Math.min(dp[i][j] , dp[i-1][j] + dc); //删除的代价
            }
        }
        return dp[row - 1][col - 1];
    }
}
