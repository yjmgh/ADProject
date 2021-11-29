package com.nowcoder.nine;

/**
 * @author Yjm
 * @create 2019-09-24 23:07
 */
/*
括号问题
【题目】
给定一个字符串str，判断是不是整体有效的括号字符串。
【举例】
str="()"，返回true；str="(()())"，返回true；str="(())"，返回true。
str="())"。返回false；str="()("，返回false；str="()a()"，返回false。
【补充题目】
给定一个括号字符串str，返回最长的有效括号子串。
【举例】
str="(()())"，返回6；
str="())"，返回2；
str="()(()()("，返回4。
*/

//解题思路：
//1 使用dp[i]记录以i位置结尾的最长有效的子串，dp[i] == '(' 则为0
//      当遇到 ")" 就让指针指着已经有效的前一个 ( () ) index 指着0位置
//      如果index位置是"("则必配成功，就让dp[i-1] + 2 , 因为i-1位置要么就是0 ，要么就是有效位置   再加上dp[index - 1]之前的
public class kuohaowenti {
    public static void main(String[] args) {
        String str1 = "((())())";
        System.out.println(fun(str1));

        String str2 = "(())(()(()))";
        System.out.println(fun(str2));

        String str3 = "()(()()(";
        System.out.println(fun(str3));
    }

    public static int fun(String str){
        if(str == null || str.length() == 0 ) return 0;
        char[] chs = str.toCharArray();
        //第一个元素无论是 ( 还是 )  dp[0]都是0
        int[] dp = new int[str.length()];
        dp[0] = 0;
        int index = 0;
        int res = 0;
        for (int i = 1; i < chs.length; i++) {
            if(chs[i] == ')'){
                index = i - 1 - dp[i-1];
                if(index >= 0 && chs[index] == '('){
                    dp[i] = dp[i-1] + 2 + (index > 0 ?dp[index-1] : 0);
                }

            }
            res = Math.max(res , dp[i]);
        }

        return res;
    }
}
