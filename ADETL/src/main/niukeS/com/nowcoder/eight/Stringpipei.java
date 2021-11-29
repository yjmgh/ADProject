package com.nowcoder.eight;

/*
字符串匹配问题
【题目】
给定字符串str，其中绝对不含有字符'.'和'*'。再给定字符串exp，
其中可以含有'.'或'*'，'*'字符不能是exp的首字符，并且任意两个
'*'字符不相邻。exp中的'.'代表任何一个字符，exp中的'*'表示'*' 的前一个字符可以有0个或者多个。请写一个函数，判断str是否能被
exp匹配。
【举例】
str="abc"，exp="abc"，返回true。
str="abc"，exp="a.c"，exp中单个'.'可以代表任意字符，所以返回
true。
str="abcd"，exp=".*"。exp中'*'的前一个字符是'.'，所以可表示任
意数量的'.'字符，当exp是"...."时与"abcd"匹配，返回true。
str=""，exp="..*"。exp中'*'的前一个字符是'.'，可表示任意数量
的'.'字符，但是".*"之前还有一个'.'字符，该字符不受'*'的影响，
所以str起码有一个字符才能被exp匹配。所以返回false。
 */
//思路：str1 i
//     str2 j j+1 看j+1位置是否是*，不是*，则必须是能匹配上，不相等直接false ， 相等则i+1 ,j+1
//                                  是*，不能匹配 则i不变 ，j = j+2 也就是str2 b* == ""
//                                       能匹配 ：i之后能否与j+2匹配，若能return true，不能i+1能否与j+2相匹配，能return true 不能 i+2与j+2
public class Stringpipei {
    public static void main(String[] args) {
        String str = "abcccdefg";
        String exp = "ab.*d.*e.*k";
        System.out.println(getBoolean(str , exp));
    }

    public static boolean getBoolean(String str , String exp){
        if(str == null || exp == null) return false;
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return fun(s , e , 0 , 0);
    }

    public static boolean fun(char[] str , char[] exp , int i , int j){
        if(j == exp.length) return i == str.length;

        //j+1 != '*'的情况
       if(j+1 == exp.length || exp[j+1] != '*'){
           return i != str.length && (exp[j] == str[i] || exp[j] =='.' ) && fun(str , exp , i+1 , j+1);
       }

       /* if(j+1 == exp.length){ //没有 j+1的情况
            return i != str.length && (exp[j] == str[i] || exp[j] =='.' ) && fun(str , exp , i+1 , j+1);
        }
        if(j+1 == exp.length){
            return i != str.length && (exp[j] == str[i] || exp[j] =='.' ) && fun(str , exp , i+1 , j+1);
        }*/

        //j+1 == '*'的情况 能匹配上 且j+1 = '*'
        while(i != str.length &&(exp[j] == str[i] || exp[j] =='.')){
           if(fun(str , exp , i , j+2)){
               return true;
           }
           i++;
        }

        //j+1 == '*'的情况 但是没有匹配上 a a a a b 与 a * c也满足

        return fun(str , exp ,i , j+2);
    }
}
